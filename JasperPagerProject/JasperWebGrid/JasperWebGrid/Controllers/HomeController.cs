using JasperWebGrid.Models;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApiTest.Models;

namespace JasperWebGrid.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index(String id)
        {
            //Get current page from session
            String currentPage;
            if (System.Web.HttpContext.Current.Session["Page"] == null)
            {
                System.Web.HttpContext.Current.Session["Page"] = 1;
                currentPage = "1";
            }
            else
            {
                currentPage = System.Web.HttpContext.Current.Session["Page"].ToString();
            }

            //Get all page count
            String itemsPerPage = "12";
            String totalPages = (Convert.ToInt32(getAllCitiesCount()) / Convert.ToInt32(itemsPerPage)).ToString();

            

            ViewBag.totalPages = Convert.ToString(Convert.ToInt32(totalPages) + 1);

            String test2 = id;
            List<City> cities = getAllCities();
            ViewBag.counter = getAllCitiesCount();

            if(id == null)
            {
                ViewBag.CurrentPage = 1;
            }
            else
            {
                ViewBag.CurrentPage = id;
            }
            return View(cities);
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }


        private List<City> getAllCities()
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

        private String getAllCitiesCount()
        {
            MySqlConnection connection = new MySqlConnection("server=localhost;port=1986;username=jasper;password=wenwen927");
            MySqlCommand command = new MySqlCommand("Select Count(*) as count from world.city", connection);
            connection.Open();
            String data = "";
            int counter = 0;
            using (MySqlDataReader dataReader = command.ExecuteReader())
            {
                while (dataReader.Read())
                {
                    
                    data = dataReader.GetString("count");
                  
                }
            }
            connection.Close();
            return data;
        }

        private List<City> getCitiesBasedOnPage(String page, String numberOfItems)
        {
            String startPoint = ((Convert.ToInt32(page) - 1) * Convert.ToInt32(numberOfItems)).ToString() ;
            MySqlConnection connection = new MySqlConnection("server=localhost;port=1986;username=jasper;password=wenwen927");
            MySqlCommand command = new MySqlCommand("Select * from world.city limit " + startPoint + " , " + numberOfItems, connection);
            List<City> cities = new List<City>();
            connection.Open();
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

        private List<List<City>> getCitiesBasedOnPage(String page, String numberOfItems, String itemsPerRow)
        {
            String startPoint = ((Convert.ToInt32(page) - 1) * Convert.ToInt32(numberOfItems)).ToString();
            MySqlConnection connection = new MySqlConnection("server=localhost;port=1986;username=jasper;password=wenwen927");
            MySqlCommand command = new MySqlCommand("Select * from world.city limit " + startPoint + " , " + numberOfItems, connection);
            List<List<City>> cities = new List<List<City>>();
            int counter = 0;
            List<City> cityGroup = new List<City>();
            connection.Open();
            using (MySqlDataReader dataReader = command.ExecuteReader())
            {
                while (dataReader.Read())
                {
                    if (counter % 4 == 0)
                    {
                        cities.Add(cityGroup);
                        cityGroup = new List<City>();
                    }
                    City city = new City();
                    city.Name = dataReader.GetString("Name");
                    city.Country = dataReader.GetString("CountryCode");
                    city.District = dataReader.GetString("District");
                    city.Population = dataReader.GetString("Population");
                    cityGroup.Add(city);
                    counter++;
                }
            }
            connection.Close();
            return cities;
        }

        public ActionResult BrowsePage(String id)
        {
            //To create pager
            List<Page> pages = new List<Page>();
            String currentPage = id;
            String allPages = (Convert.ToInt32(getAllCitiesCount()) / 20).ToString() ;
            if(id == null)
            {
                currentPage = "1";
            }
            if (Convert.ToInt32(allPages) >= 5)
            {
                if (Convert.ToInt32(currentPage) + 2 <= Convert.ToInt32(allPages))
                {
                    if (Convert.ToInt32(currentPage) >= 3)
                    {
                        for (int i = -2; i <= 2; i++)
                        {
                            Page page = new Page();
                            page.page = (Convert.ToInt32(id) + i).ToString();
                            if (currentPage == page.page)
                            {
                                page.active = true;
                            }
                            else
                            {
                                page.active = false;
                            }
                            pages.Add(page);
                        }
                    }
                    else
                    {
                        for (int i = 1; i <= 5; i++)
                        {
                            Page page = new Page();
                            page.page = i.ToString();
                            if (currentPage == page.page)
                            {
                                page.active = true;
                            }
                            else
                            {
                                page.active = false;
                            }
                            pages.Add(page);
                        }
                    }
                }
                else
                {
                    for (int i = 4; i >= 0; i--)
                    {
                        Page page = new Page();
                        page.page = (Convert.ToInt32(allPages) - i).ToString();
                        if (currentPage == page.page)
                        {
                            page.active = true;
                        }
                        else
                        {
                            page.active = false;
                        }
                        pages.Add(page);
                    }
                }
            }
            else 
            {
                for (int i = 1; i <= Convert.ToInt32(allPages); i++)
                {
                    Page page = new Page();
                    page.page = i.ToString();
                    if (currentPage == page.page)
                    {
                        page.active = true;
                    }
                    else
                    {
                        page.active = false;
                    }
                    pages.Add(page);
                }
            }
            //List<City> citiesToShow = getCitiesBasedOnPage(currentPage, "20");
            List<List<City>> citiesToShow = getCitiesBasedOnPage(currentPage, "20", "4");
            if (Convert.ToInt32(currentPage) > 1)
            {
                ViewBag.previousPage = Convert.ToInt32(currentPage) - 1;
            }
            else
            {
                ViewBag.previousPage = 1;
            }
            if (Convert.ToInt32(currentPage) < Convert.ToInt32(allPages))
            {
                ViewBag.nextPage = Convert.ToInt32(currentPage) + 1;
            }
            else
            {
                ViewBag.nextPage = allPages;
            }
            ViewData["pages"] = pages;
            ViewData["citiesToShow"] = citiesToShow;
            ViewBag.baseBrowseLink = "http://localhost:52492/Home/BrowsePage/";
            return View();
        }
    }
}