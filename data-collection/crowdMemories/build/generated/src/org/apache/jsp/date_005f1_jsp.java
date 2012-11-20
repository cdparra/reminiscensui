package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class date_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      crowdMemories.Image immagine = null;
      synchronized (session) {
        immagine = (crowdMemories.Image) _jspx_page_context.getAttribute("immagine", PageContext.SESSION_SCOPE);
        if (immagine == null){
          immagine = new crowdMemories.Image();
          _jspx_page_context.setAttribute("immagine", immagine, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');


    try {

        if (request.getParameter("submit").equals("yes")) {
            immagine.setLatitude(request.getParameter("lat"));
            immagine.setLongitude(request.getParameter("lng"));
            immagine.setRadius(request.getParameter("radius"));
            immagine.setAddress(request.getParameter("indirizzo"));
            immagine.setDescriptionLoc(request.getParameter("description"));
            immagine.setAddress(request.getParameter("indirizzo"));
            immagine.setDescriptionLoc(request.getParameter("description"));
            immagine.setHasPosition(true);
        }
        //   response.sendRedirect("date.jsp");
    } catch (Exception e) {
    }


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Date Page</title>\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"jquery-ui-1.9.0.custom/css/smoothness/jquery-ui-1.9.0.custom.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <script src=\"bootstrap/js/jquery-1.8.2.min.js\"></script>\n");
      out.write("        <script src=\"jquery-ui-1.9.0.custom/js/jquery-ui-1.9.0.custom.min.js\"></script>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #yesdiv{\n");
      out.write("                display: none\n");
      out.write("            }\n");
      out.write("            #almostdiv{\n");
      out.write("                display: none\n");
      out.write("            }\n");
      out.write("            #eventdiv{\n");
      out.write("                display: none\n");
      out.write("            }\n");
      out.write("            #nodiv{\n");
      out.write("                display: none\n");
      out.write("            }\n");
      out.write("            #description{\n");
      out.write("                resize: none;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                width: 700px;\n");
      out.write("                height: 100px\n");
      out.write("            }\n");
      out.write("            .span5 form {\n");
      out.write("                margin: 0 0 0px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #sfondo { \n");
      out.write("                width: 940px;\n");
      out.write("                height: 560px ; \n");
      out.write("                margin-top: 40px;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function(){\n");
      out.write("              \n");
      out.write("                $(\"#datepicker\").datepicker({\n");
      out.write("                    changeMonth: true,\n");
      out.write("                    changeYear: true,\n");
      out.write("                    yearRange: \"-150: +10\"\n");
      out.write("                });\n");
      out.write("              \n");
      out.write("                $(\"#yes\").click(function(){\n");
      out.write("                    $(\"#eventdiv\").slideUp();\n");
      out.write("                    $(\"#almostdiv\").slideUp();\n");
      out.write("                    $(\"#nodiv\").slideUp();\n");
      out.write("                    $(\"#yesdiv\").slideDown();\n");
      out.write("                    // document.getElementById('decade').value = null;\n");
      out.write("                    // document.getElementById('year').value = null;\n");
      out.write("                    // document.getElementById('season').value = null;\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $(\"#almost\").click(function(){\n");
      out.write("                    $(\"#yesdiv\").slideUp();\n");
      out.write("                    $(\"#nodiv\").slideUp();\n");
      out.write("                    $(\"#eventdiv\").slideUp();\n");
      out.write("                    $(\"#almostdiv\").slideDown();\n");
      out.write("                    // document.getElementById('datepicker').value = null;\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $(\"#event\").click(function(){\n");
      out.write("                    $(\"#almostdiv\").slideUp();\n");
      out.write("                    $(\"#nodiv\").slideUp();\n");
      out.write("                    $(\"#yesdiv\").slideUp();\n");
      out.write("                    $(\"#eventdiv\").slideDown();\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $(\"#no\").click(function(){\n");
      out.write("                    $(\"#yesdiv\").slideUp();\n");
      out.write("                    $(\"#almostdiv\").slideUp();\n");
      out.write("                    $(\"#eventdiv\").slideUp();\n");
      out.write("                    $(\"#nodiv\").slideDown();\n");
      out.write("                })\n");
      out.write("                \n");
      out.write("            })\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div id=\"sfondo\" class=\"hero-unit\">\n");
      out.write("                <a href=\"menu.jsp\"><span class=\"label pull-right\">skip this <i class=\"icon-forward\"></i></span></a>\n");
      out.write("                <h1>Do you remember exactly the date?</h1>\n");
      out.write("\n");
      out.write("                <div style=\"margin-top: 15px\">\n");
      out.write("\n");
      out.write("                    <button id=\"yes\" class=\"btn btn-large btn-success btn-block\">Yes, sure!</button>\n");
      out.write("\n");
      out.write("                    <div id=\"yesdiv\">\n");
      out.write("                        <form action=\"menu.jsp\">\n");
      out.write("                            Date: <input name=\"datepicker\" type=\"text\" id=\"datepicker\" placeholder=\"click here to view calendar\" />\n");
      out.write("                            <button name=\"submit\" value=\"yes\" class=\"btn btn-success btn-large\" type=\"submit\" style=\"margin-left: 540px;\"> Submit </button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"btn-group\">\n");
      out.write("                        <button id=\"almost\" class=\"btn btn-large btn-primary \" style=\"width: 50%; font-size: 30px\">Almost</button>\n");
      out.write("                        <button id=\"event\" class=\"btn btn-large btn-primary \" style=\"width: 50% ; font-size: 30px\">There was an event?</button>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div id=\"almostdiv\">\n");
      out.write("                        <form action=\"menu.jsp\">\n");
      out.write("                            <p style=\"text-align: center; padding-top: 5px\">Just enter what you remember</p>\n");
      out.write("                            <button name=\"submit\" value=\"almost\" class=\"btn btn-primary btn-large pull-right\" type=\"submit\"> Submit </button>\n");
      out.write("                            <table>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <table class=\"table\">\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Decade:</p> </td>\n");
      out.write("                                                <td><input name=\"decade\" type=\"text\" placeholder=\"80s\" value=\"\"/></td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Year:</p> </td>\n");
      out.write("                                                <td><input name=\"year\" type=\"text\" placeholder=\"1986\" value=\"\"/></td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Season:</p> </td>\n");
      out.write("                                                <td><input name=\"season\" type=\"text\" placeholder=\"winter\" value=\"\"/></td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Month:</p> </td>\n");
      out.write("                                                <td><input name=\"month\" type=\"text\" placeholder=\"may or 05\" value=\"\"/></td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                        </table>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <table class=\"table\">\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Day:</p> </td>\n");
      out.write("                                                <td><input name=\"day\" type=\"text\" placeholder=\"27th\" value=\"\"/></td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Day Name:</p> </td>\n");
      out.write("                                                <td><input name=\"day_name\" type=\"text\" placeholder=\"monday\" value=\"\"/></td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Day Part:</p> </td>\n");
      out.write("                                                <td><input name=\"day_part\" type=\"text\" placeholder=\"afternoon\" value=\"\"/></td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Time:</p> </td>\n");
      out.write("                                                <td><input name=\"time\" type=\"text\" placeholder=\"hh-mm-ss\" value=\"\"/></td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                        </table>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>             \n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div id=\"eventdiv\">\n");
      out.write("                        <form action=\"menu.jsp\">\n");
      out.write("                            <p>Here goes the event chooser</p>\n");
      out.write("                            <input name=\"event\" />\n");
      out.write("                            <button name=\"submit\" value=\"event\" class=\"btn btn-primary btn-large pull-right\" type=\"submit\"> Submit </button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <button id=\"no\" class=\"btn btn-large btn-danger btn-block\">No</button>\n");
      out.write("\n");
      out.write("                    <div id=\"nodiv\">\n");
      out.write("                        <form action=\"menu.jsp\">\n");
      out.write("                            <textarea id=\"description\" name=\"description\" placeholder=\"Try to write date textually\" ></textarea>\n");
      out.write("                            <button name=\"submit\" value=\"no\" class=\"btn btn-danger btn-large pull-right\" type=\"submit\"> Submit </button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
