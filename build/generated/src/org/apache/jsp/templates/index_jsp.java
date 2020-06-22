package org.apache.jsp.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>RAFASE</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap-theme.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/index.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" media=\"screen\" href=\"https://fontlibrary.org/face/averia\" type=\"text/css\"/>        \r\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-latest.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-5 \">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-2 text-center\">\r\n");
      out.write("\t\t\t\t<img id=\"logo\" src=\"../img/Logo.png\">\t\t\t\t\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-8 text-center\">\r\n");
      out.write("                                <h2 class=\"text-left\" id=\"titulo\">RAFASE</h2>\r\n");
      out.write("                                <h5 class=\"text-left\">Rapido, Facil y Seguro</h5>\r\n");
      out.write("                            </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("\t\t\t<span></span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-2 text-left\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("                    </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <!------------------------------Barra de navegacion-------------------------------------------->\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar navbar-light bg-light\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Inicio</a>\r\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("              <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("              <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("                <li class=\"nav-item active\">\r\n");
      out.write("                  <a class=\"nav-link\" href=\"#\">Ir a Pagar<span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                  <a class=\"nav-link\" href=\"#\">Control</a>\r\n");
      out.write("                </li>\r\n");
      out.write("              </ul>\r\n");
      out.write("              <form class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("                <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Buscar producto\" aria-label=\"Search\">\r\n");
      out.write("                <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Buscar</button>                \r\n");
      out.write("              </form>\r\n");
      out.write("                <button class=\"btn btn-outline-info iniciar_sesion\">Iniciar sesión</button>\r\n");
      out.write("                <button class=\"btn btn-outline-primary\">Registrarse</button>\r\n");
      out.write("            </div>\r\n");
      out.write("          </nav>\r\n");
      out.write("        <!--------------------------------Carrusel de imagenes------------------------------------------->\r\n");
      out.write("        <div id=\"carouselExampleCaptions\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("            <ol class=\"carousel-indicators\">\r\n");
      out.write("                <li data-target=\"#carouselExampleCaptions\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("                <li data-target=\"#carouselExampleCaptions\" data-slide-to=\"1\"></li>\r\n");
      out.write("                <li data-target=\"#carouselExampleCaptions\" data-slide-to=\"2\"></li>\r\n");
      out.write("            </ol>\r\n");
      out.write("            <div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("                <div class=\"carousel-item active\" style=\"height: 40vh\">\r\n");
      out.write("                    <img src=\"../img/Granel.jpg\" class=\"d-block w-100\" alt=\"granel\">\r\n");
      out.write("                    <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("                        <h5 style=\"text-shadow:5px 5px 7px #000000\">Mercado</h5>\r\n");
      out.write("                        <p style=\"text-shadow:5px 5px 7px #000000\">Todo lo que necesitas para tu hogar.</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"carousel-item\"  style=\"height: 40vh\">\r\n");
      out.write("                    <img src=\"../img/Celulares.jpg\" class=\"d-block w-100\" alt=\"celulares\">\r\n");
      out.write("                        <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("                            <h5 style=\"text-shadow:5px 5px 7px #000000\">Tecnología</h5>\r\n");
      out.write("                            <p style=\"text-shadow:5px 5px 7px #000000\">Encuentra todos los articulos tecnologicos.</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"carousel-item\"  style=\"height: 40vh\">\r\n");
      out.write("                    <img src=\"../img/Libros.jpg\" class=\"d-block w-100\" alt=\"libros\">\r\n");
      out.write("                    <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("                        <h5 style=\"text-shadow:5px 5px 7px #000000\">Libros</h5>\r\n");
      out.write("                        <p style=\"text-shadow:5px 5px 7px #000000\">Encuentra variedad de libros de todas categorias.</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <a class=\"carousel-control-prev\" href=\"#carouselExampleCaptions\" role=\"button\" data-slide=\"prev\">\r\n");
      out.write("                <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("                <span class=\"sr-only\">Previous</span>\r\n");
      out.write("            </a>\r\n");
      out.write("            <a class=\"carousel-control-next\" href=\"#carouselExampleCaptions\" role=\"button\" data-slide=\"next\">\r\n");
      out.write("                <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("                <span class=\"sr-only\">Next</span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <!--------------------------------Productos------------------------------------------->\r\n");
      out.write("        <center>\r\n");
      out.write("            <h2>Categorias</h2>\r\n");
      out.write("        </center>\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("        <div class=\"col\">\r\n");
      out.write("            <span></span>     \r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"card-deck col-8\">\r\n");
      out.write("            <div class=\"card text-white bg-primary mb-3\" style=\"max-width: 18rem;\">\r\n");
      out.write("                <div class=\"card-header\">Entretenimiento</div>\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <h5 class=\"card-title text-center\">\r\n");
      out.write("                            <svg class=\"bi bi-film\" width=\"3em\" height=\"3em\" viewBox=\"0 0 16 16\" fill=\"currentColor\" xmlns=\"http://www.w3.org/2000/svg\">\r\n");
      out.write("                                <path fill-rule=\"evenodd\" d=\"M0 1a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V1zm4 0h8v6H4V1zm8 8H4v6h8V9zM1 1h2v2H1V1zm2 3H1v2h2V4zM1 7h2v2H1V7zm2 3H1v2h2v-2zm-2 3h2v2H1v-2zM15 1h-2v2h2V1zm-2 3h2v2h-2V4zm2 3h-2v2h2V7zm-2 3h2v2h-2v-2zm2 3h-2v2h2v-2z\"/>\r\n");
      out.write("                            </svg>\r\n");
      out.write("                        </h5>\r\n");
      out.write("                        <p class=\"card-text\">boton</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"card text-white bg-secondary mb-3\" style=\"max-width: 18rem;\">\r\n");
      out.write("                <div class=\"card-header\">Hogar</div>\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <h5 class=\"card-title\">Secondary card title</h5>\r\n");
      out.write("                        <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"card text-white bg-success mb-3\" style=\"max-width: 18rem;\">\r\n");
      out.write("                <div class=\"card-header\">Mercado</div>\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <h5 class=\"card-title\">Success card title</h5>\r\n");
      out.write("                        <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col\">\r\n");
      out.write("            <span></span>     \r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"../js/jquery.js\"></script>\r\n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
