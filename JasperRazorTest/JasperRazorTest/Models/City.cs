using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace JasperRazorTest.Models
{
    public class City 
    {
        public String Name { get; set; }
        public String Country { get; set; }
        public String District { get; set; }
        public String Population { get; set; }
    }
}