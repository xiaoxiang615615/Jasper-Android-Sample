﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Configuration;
using System.Web.Mvc;

namespace JasperRazorTest.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";
            System.Configuration.Configuration webConfig = WebConfigurationManager.OpenWebConfiguration("/JasperRazorTest");
            System.Configuration.ConnectionStringSettings connectionString = webConfig.ConnectionStrings.ConnectionStrings["DefaultConnection"];
            Console.WriteLine(connectionString);
            return View();
        }
    }
}