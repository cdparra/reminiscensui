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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-latest.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <link href=\"bootstrap/css/select2.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <script src=\"bootstrap/js/select2.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $('#combobox1').select2();\n");
      out.write("                $('#combobox2').select2();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div style=\"width:1024px;margin-right: auto; margin-left: auto;padding:5px;text-align: center;\">\n");
      out.write("            <form action=\"checkAttributi.jsp\" method=\"post\">\n");
      out.write("                Persona 1  : <!--<input name=\"persona1\" font-names=\"Comic Sans MS\" size=15 type=\"text\" />-->\n");
      out.write("                <select id=\"combobox1\" name=\"combobox1\" style=\"width:300px\">\n");
      out.write("                    <option value=\"Fantozzi\">Ugo Fantozzi</option>\n");
      out.write("                    <option value=\"Kessler\">Bruno Kessler</option>\n");
      out.write("                    <option value=\"Parra\">Ygnacio Parra</option>\n");
      out.write("                </select>\n");
      out.write("                <br />\n");
      out.write("                <br />\n");
      out.write("                Persona 2  : \n");
      out.write("                <select id=\"combobox2\" name=\"combobox2\" style=\"width:300px\">\n");
      out.write("                    <option value=\"Kessler\">Bruno Kessler</option>\n");
      out.write("                    <option value=\"Fantozzi\">Ugo Fantozzi</option>\n");
      out.write("                    <option value=\"Parra\">Ygnacio Parra</option>\n");
      out.write("                </select> \n");
      out.write("                <br />\n");
      out.write("                <br />\n");
      out.write("                <input type=\"submit\" value=\"prova\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
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
