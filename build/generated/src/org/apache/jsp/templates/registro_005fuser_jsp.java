package org.apache.jsp.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registro_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"icon\" href=\"../img/Logo.png\" type=\"image/png\">\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap/bootstrap-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container register\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-3 register-left\">\n");
      out.write("                    <img src=\"https://image.ibb.co/n7oTvU/logo_white.png\" alt=\"\"/>\n");
      out.write("                    <h3>Welcome</h3>\n");
      out.write("                    <p>You are 30 seconds away from earning your own money!</p>\n");
      out.write("                    <input type=\"submit\" name=\"\" value=\"Login\"/><br/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-9 register-right\">\n");
      out.write("                    <ul class=\"nav nav-tabs nav-justified\" id=\"myTab\" role=\"tablist\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\" id=\"home-tab\" data-toggle=\"tab\" href=\"#home\" role=\"tab\" aria-controls=\"home\" aria-selected=\"true\">Employee</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" id=\"profile-tab\" data-toggle=\"tab\" href=\"#profile\" role=\"tab\" aria-controls=\"profile\" aria-selected=\"false\">Hirer</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <div class=\"tab-content\" id=\"myTabContent\">\n");
      out.write("                        <div class=\"tab-pane fade show active\" id=\"home\" role=\"tabpanel\" aria-labelledby=\"home-tab\">\n");
      out.write("                            <h3 class=\"register-heading\">Apply as a Employee</h3>\n");
      out.write("                            <div class=\"row register-form\">\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"First Name *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Last Name *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" placeholder=\"Password *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"password\" class=\"form-control\"  placeholder=\"Confirm Password *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"maxl\">\n");
      out.write("                                            <label class=\"radio inline\"> \n");
      out.write("                                                <input type=\"radio\" name=\"gender\" value=\"male\" checked>\n");
      out.write("                                                <span> Male </span> \n");
      out.write("                                            </label>\n");
      out.write("                                            <label class=\"radio inline\"> \n");
      out.write("                                                <input type=\"radio\" name=\"gender\" value=\"female\">\n");
      out.write("                                                <span>Female </span> \n");
      out.write("                                            </label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"email\" class=\"form-control\" placeholder=\"Your Email *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"text\" minlength=\"10\" maxlength=\"10\" name=\"txtEmpPhone\" class=\"form-control\" placeholder=\"Your Phone *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <select class=\"form-control\">\n");
      out.write("                                            <option class=\"hidden\"  selected disabled>Please select your Sequrity Question</option>\n");
      out.write("                                            <option>What is your Birthdate?</option>\n");
      out.write("                                            <option>What is Your old Phone Number</option>\n");
      out.write("                                            <option>What is your Pet Name?</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Enter Your Answer *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <input type=\"submit\" class=\"btnRegister\"  value=\"Register\"/>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"tab-pane fade show\" id=\"profile\" role=\"tabpanel\" aria-labelledby=\"profile-tab\">\n");
      out.write("                            <h3  class=\"register-heading\">Apply as a Hirer</h3>\n");
      out.write("                            <div class=\"row register-form\">\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"First Name *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Last Name *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"email\" class=\"form-control\" placeholder=\"Email *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"text\" maxlength=\"10\" minlength=\"10\" class=\"form-control\" placeholder=\"Phone *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" placeholder=\"Password *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" placeholder=\"Confirm Password *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <select class=\"form-control\">\n");
      out.write("                                            <option class=\"hidden\"  selected disabled>Please select your Sequrity Question</option>\n");
      out.write("                                            <option>What is your Birthdate?</option>\n");
      out.write("                                            <option>What is Your old Phone Number</option>\n");
      out.write("                                            <option>What is your Pet Name?</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"`Answer *\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <input type=\"submit\" class=\"btnRegister\"  value=\"Register\"/>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-------------------------------Scripts--------------------------------->\n");
      out.write("        <script src=\"../js/jquery.js\"></script>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
