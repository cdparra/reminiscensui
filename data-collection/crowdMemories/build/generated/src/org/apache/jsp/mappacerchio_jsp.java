package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import crowdMemories.Media;

public final class mappacerchio_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"errorPage.jsp", true, 8192, true);
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
      out.write("\n");
      out.write("\n");

    /*
     if (session.getAttribute("user_name") == null) {
     response.sendRedirect("index.jsp");
     }
     */

      out.write('\n');

    String url = request.getParameter("url");
    String title = request.getParameter("title");

    /*
     try {


     Media media = new Media();

     media.setTitle(title);
     media.setUrl(url);
     media.setSource_url(url);
     session.setAttribute("media", media);

     } catch (Exception e) {
     }
     */

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\" />\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\"/>\n");
      out.write("        <title>Map</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("\n");
      out.write("            .hero-unit p{\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 14px;\n");
      out.write("                line-height: 20px \n");
      out.write("            }\n");
      out.write("            #address{\n");
      out.write("                width:350px;\n");
      out.write("            }\n");
      out.write("            #right{\n");
      out.write("                width: 350px;\n");
      out.write("            }\n");
      out.write("            #search{\n");
      out.write("                padding: 20px\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #map_canvas { \n");
      out.write("                height: 480px;\n");
      out.write("                width: 540px \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #sfondo { \n");
      out.write("                width: 940px;\n");
      out.write("                height: 830px;\n");
      out.write("                margin-top: 40px;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("            }\n");
      out.write("            .modal p{\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 20px\n");
      out.write("            }\n");
      out.write("            #mytext{\n");
      out.write("                width: 327px; \n");
      out.write("                height: 470px;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                margin-bottom: 100px;\n");
      out.write("                resize: none\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script src=\"bootstrap/js/jquery-1.8.2.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\"\n");
      out.write("                src=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyAfhwuXTgopU7b9KHaTB9YDZwQ6LdPbLJ8&sensor=false\">\n");
      out.write("        </script>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.js\"></script>\n");
      out.write("        <script src=\"myMapMarkerCircle.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("           \n");
      out.write("            function checkDescription(){\n");
      out.write("                var text = document.getElementById('mytext').value;\n");
      out.write("               \n");
      out.write("                if(text == \"\"){\n");
      out.write("                    $(\"#myModalDescription\").modal('show');\n");
      out.write("                    return false;\n");
      out.write("                }else{\n");
      out.write("                    return true;\n");
      out.write("                }  \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function checkLocation(){\n");
      out.write("                var lat = document.getElementById('lat').value;\n");
      out.write("                var lng = document.getElementById('lng').value;\n");
      out.write("                \n");
      out.write("                if(lat == \"\" ||lng == \"\"){\n");
      out.write("                    $(\"#myModalLocation\").modal('show');\n");
      out.write("                    return false;\n");
      out.write("                }else{\n");
      out.write("                    return true;\n");
      out.write("                }           \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"initialize()\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div id=\"sfondo\" class=\"hero-unit\">\n");
      out.write("                <a href=\"date.jsp\"><span class=\"label pull-right\">skip this <i class=\"icon-forward\"></i></span></a>\n");
      out.write("                <h1>Do you remember the location?</h1>\n");
      out.write("                <div style=\"display: block; text-align: center\">\n");
      out.write("                    <h2>");
      out.print( title);
      out.write("</h2>\n");
      out.write("                    <img id=\"img\" src=\" ");
      out.print( url);
      out.write(" \" style=\"max-width: 400px; max-height: 400px\" alt=\"image not found\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"span7\" >\n");
      out.write("                    <p>If you remember exactly the location just drag the marker on the map over the location or select with a rightclick on the map the area in which you think it was.</p>\n");
      out.write("                    <div id=\"map_canvas\" ></div>\n");
      out.write("                    <div id=\"search\">\n");
      out.write("                        <p> You can also search a place!  </p>\n");
      out.write("                        <input id=\"address\" name=\"address\" class=\"input-medium search-query\" type=\"text\" placeholder=\"Insert place here\" >\n");
      out.write("                        <input type=\"button\" class=\"btn btn-primary\" value=\"Search Place\" onclick=\"codeAddress()\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <form method=\"get\" action=\"date.jsp\" >\n");
      out.write("                        <button class=\"btn btn-success btn-large\" type=\"submit\" name=\"submit\" value=\"map\" onclick=\"return checkLocation()\"> Add the location on the map</button>\n");
      out.write("\n");
      out.write("                        <div style=\"display: none; margin-top: 652px\">\n");
      out.write("                            <input name=\"url\" value=\"");
      out.print( url);
      out.write("\">\n");
      out.write("                            <input name=\"title\" value=\"");
      out.print( title);
      out.write("\">\n");
      out.write("                            <table class=\"table\" style=\"margin-top: 40px; width: 700px;\">\n");
      out.write("                                <thead>\n");
      out.write("                                <th>Latitudine</th>\n");
      out.write("                                <th>Longitudine</th>\n");
      out.write("                                <th>Radius</th>\n");
      out.write("                                <th>Indirizzo</th>\n");
      out.write("                                </thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td >\n");
      out.write("                                        <input id=\"lat\" name=\"lat\" type=\"text\" value=\"\"/>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td >\n");
      out.write("                                        <input id=\"lng\" name=\"lng\" type=\"text\" value=\"\"/>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td >\n");
      out.write("                                        <input id=\"radius\" name=\"radius\" type=\"text\" value=\"0\"/>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td >\n");
      out.write("                                        <input id=\"indirizzo\" name=\"indirizzo\" type=\"text\" value=\"\"/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id=\"right\" class=\"span4\" >\n");
      out.write("                    <form method=\"get\" action=\"date.jsp\">\n");
      out.write("                        <p> Otherwise you can describe it textually.</p>\n");
      out.write("                        <textarea id=\"mytext\" name=\"description\" placeholder=\"Add location textually\"></textarea>\n");
      out.write("                        <button class=\"btn btn-success btn-large \" type=\"submit\" name=\"submit\" value=\"text\" onclick=\"return checkDescription()\"> or add the description </button>\n");
      out.write("\n");
      out.write("                        <div style=\"display: none\">\n");
      out.write("                            <input name=\"url\" value=\"");
      out.print( url);
      out.write("\">\n");
      out.write("                            <input name=\"title\" value=\"");
      out.print( title);
      out.write("\">\n");
      out.write("                        </div>           \n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"myModalDescription\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>\n");
      out.write("                <h3 id=\"myModalLabel\">Warning!</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <p>The description you entered could not be Empty!</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button class=\"btn btn-primary\" data-dismiss=\"modal\" aria-hidden=\"true\">Close</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"myModalLocation\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>\n");
      out.write("                <h3 id=\"myModalLabel\">Warning!</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <p>Please check the location you entered!</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button class=\"btn btn-primary\" data-dismiss=\"modal\" aria-hidden=\"true\">Close</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
