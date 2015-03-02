using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace JasperRazorTest.Controllers
{
    public class WebTestController : ApiController
    {
        // GET: api/WebTest
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/WebTest/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/WebTest
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/WebTest/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/WebTest/5
        public void Delete(int id)
        {
        }
    }
}
