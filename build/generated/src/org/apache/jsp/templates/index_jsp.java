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
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-6 \">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-4 text-center\">\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<img id=\"logo\" src=\"../img/Logo.png\">\r\n");
      out.write("\t\t\t\t<br><br>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-8 text-center\">\r\n");
      out.write("                                <br><br>\r\n");
      out.write("                                <h2 class=\"text-left\" id=\"titulo\">RAFASE</h2>\r\n");
      out.write("                                <h5 class=\"text-left\">Rapido, Facil y Seguro</h5>\r\n");
      out.write("                                <br>\r\n");
      out.write("                            </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("\t\t\t<span></span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-2 text-left\">\r\n");
      out.write("\t\t\t<br><br><br>\r\n");
      out.write("\t\t\t<button class=\"btn btn-primary\">Iniciar sesión</button>\r\n");
      out.write("                        <button class=\"btn btn-primary\">Registrarse</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
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
      out.write("                <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Buscar</button>\r\n");
      out.write("              </form>\r\n");
      out.write("            </div>\r\n");
      out.write("          </nav>\r\n");
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
