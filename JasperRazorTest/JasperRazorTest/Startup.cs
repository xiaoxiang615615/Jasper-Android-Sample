using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(JasperRazorTest.Startup))]
namespace JasperRazorTest
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
