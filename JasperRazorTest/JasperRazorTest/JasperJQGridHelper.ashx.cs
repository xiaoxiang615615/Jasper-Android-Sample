using JasperRazorTest.Models;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;

namespace JasperRazorTest
{
    /// <summary>
    /// Summary description for JasperJQGridHelper
    /// </summary>
    public class JasperJQGridHelper : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            String page = "";
            String rows = "";
            String sidx = "";
            String sord = "";
            var jsonSerializer = new JavaScriptSerializer();
            var test = jsonSerializer.Serialize(getAllCities().AsQueryable<City>().ToList<City>());
            String jqGridPara = HttpContext.Current.Request.QueryString.ToString();
            String[] jqGridParameter = jqGridPara.Split('&');
            
            foreach(String jqGridParameterDetail in jqGridParameter)
            {
                String[] detail = jqGridParameterDetail.Split('=');
                if(detail[0] == "page")
                {
                    page = detail[1];
                }
                if (detail[0] == "rows")
                {
                    rows = detail[1];
                }
                if (detail[0] == "sidx")
                {
                    sidx = detail[1];
                }
                if (detail[0] == "sord")
                {
                    sord = detail[1];
                }
            }
            //context.Response.Write(jsonSerializer.Serialize(getAllCities().AsQueryable<City>().ToList<City>()));
            String testString = getAllCities(page, rows, sidx, sord);
            context.Response.Write(testString);
        }

        public bool IsReusable
        {
            get
            {
                return false;
            }
        }

        public List<City> getAllCities()
        {
            MySqlConnection connection = new MySqlConnection("server=localhost;port=1986;username=jasper;password=wenwen927");
            MySqlCommand command = new MySqlCommand("Select * from world.city", connection);
            List<City> cities = new List<City>();
            connection.Open();
            String data = "";
            int counter = 0;
            using (MySqlDataReader dataReader = command.ExecuteReader())
            {
                while (dataReader.Read())
                {
                    City city = new City();
                    city.Name = dataReader.GetString("Name");
                    city.Country = dataReader.GetString("CountryCode");
                    city.District = dataReader.GetString("District");
                    city.Population = dataReader.GetString("Population");
                    cities.Add(city);
                }
            }
            connection.Close();

            return cities;
        }

        public String getAllCities(String page, String rows, String sidx, String sord)
        {
            String count = "5000";
            MySqlConnection connection = new MySqlConnection("server=localhost;port=1986;username=jasper;password=wenwen927");
            MySqlCommand countCommand = new MySqlCommand("Select Count(*) as Count from world.city", connection);
            connection.Open();
            using (MySqlDataReader dataReader = countCommand.ExecuteReader())
            {
                if (dataReader.Read())
                {
                    count = dataReader.GetString("Count");
                }
            }
            int totalPages = Convert.ToInt32(count) / Convert.ToInt32(rows);
            int start = Convert.ToInt32(rows)*Convert.ToInt32(page) - Convert.ToInt32(rows);
            MySqlCommand command = new MySqlCommand("Select * from world.city order by "+sidx+" "+ sord +" limit "+ start +" , "+rows, connection);
            List<City> cities = new List<City>();
            //connection.Open();
            String data = "";
            int counter = 0;
            using (MySqlDataReader dataReader = command.ExecuteReader())
            {
                while (dataReader.Read())
                {
                    City city = new City();
                    city.Name = dataReader.GetString("Name");
                    city.Country = dataReader.GetString("CountryCode");
                    city.District = dataReader.GetString("District");
                    city.Population = dataReader.GetString("Population");
                    cities.Add(city);
                }
            }
            connection.Close();

            String returnString = "<?xml version='1.0' encoding='utf-8'?>";
            returnString += "<rows>";
            returnString += "<page>" + page + "</page>";
            returnString += "<total>" + totalPages + "</total>";
            returnString += "<records>" + count + "</records>";
            int rowid = 1;
            foreach (City city in cities)
            {
                returnString += "<row id='" + Convert.ToString(rowid) + "'>";
                rowid++;
                returnString += "<cell>" + city.Name + "</cell>";
                returnString += "<cell>" + city.Country + "</cell>";
                returnString += "<cell>" + city.Name + "</cell>";
                returnString += "<cell>" + city.Population + "</cell>";
                returnString += "</row>";
            }
            returnString += "</rows>";
            return returnString;

        }
    }


}