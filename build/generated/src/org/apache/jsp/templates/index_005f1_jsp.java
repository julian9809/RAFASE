package org.apache.jsp.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Carrito;
import control.PedidoDAO;
import java.util.ArrayList;
import modelo.Producto;
import control.ProductosDAO;

public final class index_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");

    String producto_buscado = request.getParameter("busqueda");
    String usuario = "";
    System.out.println("" + request.getParameter("usuario"));
    if (request.getParameter("usuario") == null) {
        usuario = "visitante";
    } else {
        usuario = request.getParameter("usuario");
    }

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <link rel=\"icon\" href=\"../img/Logo.png\" type=\"image/png\">\r\n");
      out.write("        <!-- Bootstrap core CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap-theme.min.css\">\r\n");
      out.write("        <!-- Customs styles for this template -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/index.css\">\r\n");
      out.write("        <!-- Customs fonts -->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Averia+Libre&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-sm-2 col-md-2 col-lg-1 col-xl-1 text-center\">\r\n");
      out.write("                        <img id=\"logo\" src=\"../img/rafase.gif\">\t\t\t\t\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-10 col-md-10 col-lg-11 col-xl-11 text-center\">\r\n");
      out.write("                        <h2 class=\"text-left\" id=\"titulo\">RAFASE</h2>\r\n");
      out.write("                        <h5 class=\"text-left\">Rapido, Facil y Seguro</h5>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <!-------------------------------Barra de navegación--------------------------------->\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar navbar-light bg-light sticky-top\">\r\n");
      out.write("            <img id=\"logo\" src=\"../img/Logo.png\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"../MantenerUsuario?usuario=");
      out.print(usuario);
      out.write("&pagina=inicio\">Inicio</a>\r\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("                    <li class=\"nav-item active\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"../BuscarProducto?usuario=");
      out.print(usuario);
      out.write("&producto_buscado=\">Productos<span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item active\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">Ir a pagar<span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">Control</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <form action=\"../BuscarProducto\" method=\"post\" class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("                    <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Buscar productos\" name=\"producto_buscado\" id=\"producto_buscado\" aria-label=\"Search\">\r\n");
      out.write("                    <input type=\"hidden\" name = \"usuario\" id=\"usuario\" value=");
      out.print(usuario);
      out.write(">\r\n");
      out.write("                    <button class=\"btn btn-outline-success my-2 my-sm-0 buscar\" type=\"submit\">Buscar</button>                \r\n");
      out.write("                </form>\r\n");
      out.write("                ");
if (usuario.equals("visitante")) {
      out.write("\r\n");
      out.write("                <div class=\"btn-group\" role=\"group\">\r\n");
      out.write("                    <a class=\"btn btn-outline-info\"  href=\"sign.jsp\" role=\"button\">Iniciar sesión</a>\r\n");
      out.write("                    <a class=\"btn btn-outline-primary\"  href=\"registro_user.jsp\" role=\"button\">Registrarse</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
} else {
      out.write("\r\n");
      out.write("                <div class=\"btn-group\" role=\"group\">\r\n");
      out.write("                    <a class=\"btn btn-outline-info\"  href=\"#\" role=\"button\">");
      out.print(usuario);
      out.write("</a>\r\n");
      out.write("                    <form><a class=\"btn btn-outline-primary\"  href=\"../cerrarSesion?usuario=visitante\" role=\"button\">Log out</a></form>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <!--------------------------------FOOTER--------------------------------->\r\n");
      out.write("        <footer class=\"container\">\r\n");
      out.write("            <p class=\"float-right\"><a href=\"#\">Volver al arriba</a></p>\r\n");
      out.write("            <p>&copy; 2020 RAFASE, Inc. &middot; <a href=\"#\">Privacidad</a> &middot; <a href=\"#\">Términos y Condiciones</a></p>\r\n");
      out.write("        </footer>\r\n");
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
