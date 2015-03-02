using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(JasperWebGrid.Startup))]
namespace JasperWebGrid
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
