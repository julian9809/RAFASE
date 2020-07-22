package org.apache.jsp;

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
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <title>RAFASE</title>\r\n");
      out.write("        <!-- RAFASE icon -->\r\n");
      out.write("        <link rel=\"icon\" href=\"img/Logo.png\" type=\"image/png\">\r\n");
      out.write("        <!-- Font Awesome -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.11.2/css/all.css\">\r\n");
      out.write("        <!-- Google Fonts Roboto -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap\">\r\n");
      out.write("        <!-- Bootstrap core CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap/bootstrap.min.css\">\r\n");
      out.write("        <!-- Material Design Bootstrap -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/mdb/mdb.min.css\">\r\n");
      out.write("        <!-- Customs styles for this template -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/custom/cover.css\">\r\n");
      out.write("        <!-- Customs fonts -->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Averia+Libre&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"text-center\">\r\n");
      out.write("        <div class=\"cover-container d-flex w-100 h-100 p-3 mx-auto flex-column\">\r\n");
      out.write("            <header class=\"masthead mb-auto\">\r\n");
      out.write("                <div class=\"inner\">\r\n");
      out.write("                    <img id=\"logo\" class=\"masthead-brand\" src=\"img/rafase.gif\">\r\n");
      out.write("                    <nav class=\"nav nav-masthead justify-content-center\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"templates/index.jsp\">Quienes Somos</a>\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">Contacto</a>\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("            </header>\r\n");
      out.write("\r\n");
      out.write("            <main role=\"main\" class=\"inner cover\">\r\n");
      out.write("                <h1 class=\"cover-heading\">RAFASE</h1>\r\n");
      out.write("                <p class=\"lead inicio\">Somos una tienda virtual con varias sucursales fisicas en distintas ciudades del pais, escoge tu ciudad eh inicia a comprar de forma rapida y sencilla.</p>\r\n");
      out.write("                <form class=\"lead btn-group\">\r\n");
      out.write("                    <select class=\"btn btn-lg btn-light\" name=\"ciudad\" id=\"ciudad\">\r\n");
      out.write("                        <option selected hidden disabled>Escoge tu ciudad</option>\r\n");
      out.write("                        <option value=\"BT\">Bogotá</option>\r\n");
      out.write("                        <option value=\"ME\">Medellin</option>\r\n");
      out.write("                        <option value=\"CA\">Cali</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                    <button class=\"btn btn-lg btn-success\" type=\"summit\">Continuar</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </main>\r\n");
      out.write("\r\n");
      out.write("            <footer class=\"container footer mastfoot mt-auto\">\r\n");
      out.write("                <div class=\"inner\">\r\n");
      out.write("                <p>&copy; 2020 RAFASE, Inc. &middot; <a href=\"#\">Privacidad</a> &middot; <a href=\"#\">Términos y Condiciones</a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </footer>\r\n");
      out.write("            <!-------------------------------Scripts--------------------------------->\r\n");
      out.write("        <!-- jQuery -->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("        <!-- Bootstrap tooltips -->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/popper.min.js\"></script>\r\n");
      out.write("        <!-- Bootstrap core JavaScript -->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <!-- MDB core JavaScript -->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/mdb.min.js\"></script>\r\n");
      out.write("        </div>\r\n");
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
