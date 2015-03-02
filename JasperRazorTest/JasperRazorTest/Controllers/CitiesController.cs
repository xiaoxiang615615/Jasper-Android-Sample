using JasperRazorTest.Models;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Http;
using System.Web.Script.Serialization;

namespace JasperRazorTest.Controllers
{
    public class CitiesController : ApiController
    {
      

        public void getAllCities(String page, String rows, String sidx, String sord)
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

            MySqlCommand command = new MySqlCommand("Select * from world.city", connection);
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
            returnString += "<page>"+page+"</page>";
            returnString += "<total>"+totalPages+"</total>";
            returnString += "<records>"+count+"</records>";
            int rowid = 1;
            foreach(City city in cities)
            {
                returnString += "<row id='"+Convert.ToString(rowid)+"'>";
                rowid++;
                returnString += "<cell>"+city.Name+"</cell>";
                returnString += "<cell>"+city.Name+"</cell>";
                returnString += "<cell>"+city.Name+"</cell>";
                returnString += "<cell>"+city.Name+"</cell>";
                returnString += "</row>";
            }
            returnString += "</rows>";
            System.Web.HttpContext.Current.Response.Write(returnString);
            
        }
    }
}
