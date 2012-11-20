package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import crowdMemories.Image;

public final class menu_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

        String name = request.getParameter("submit");

        if (name.equals("yes")) {

            immagine.setDate(request.getParameter("datepicker"));

            immagine.setTypeofdate("yes");
        } else if (name.equals("almost")) {

            immagine.setDecade(request.getParameter("decade"));
            immagine.setYear(request.getParameter("year"));
            immagine.setMonth(request.getParameter("month"));
            immagine.setDay(request.getParameter("day"));
            immagine.setDayName(request.getParameter("day_name"));
            immagine.setDayPart(request.getParameter("dayPart"));
            immagine.setSeason(request.getParameter("season"));

            immagine.setTypeofdate("almost");
        } else if (name.equals("event")) {
            // request.getParameter("event");
            // immagine.setTypeofdate("event");
        } else if (name.equals("no")) {
            immagine.setDescriptionTime(request.getParameter("description"));

            immagine.setTypeofdate("no");
        }
        // response.sendRedirect("menu.jsp");
    } catch (Exception e) {
    }


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Menu</title>\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\"/>\n");
      out.write("        <script src=\"bootstrap/js/jquery-1.8.2.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\"\n");
      out.write("                src=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyAfhwuXTgopU7b9KHaTB9YDZwQ6LdPbLJ8&sensor=false\">\n");
      out.write("        </script>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #sfondo { \n");
      out.write("                width: 940px;\n");
      out.write("                height: 500px ; \n");
      out.write("                margin-top: 40px;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("            }\n");
      out.write("            #map_canvas{\n");
      out.write("                width: 450px;\n");
      out.write("                height: 300px;               \n");
      out.write("            }\n");
      out.write("            p{/*\n");
      out.write("                text-align: center\n");
      out.write("                */ }\n");
      out.write("\n");
      out.write("            .btn-large{\n");
      out.write("                font-size: 20px\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            function initialize() {\n");
      out.write("                var latlng = new google.maps.LatLng(41.901514, 12.4607737);\n");
      out.write("   \n");
      out.write("                var mapOptions = {\n");
      out.write("                    zoom: 8,\n");
      out.write("                    center: latlng,\n");
      out.write("                    mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                var map = new google.maps.Map(document.getElementById(\"map_canvas\"), mapOptions);\n");
      out.write("                \n");
      out.write("                var marker = new google.maps.Marker({\n");
      out.write("                    map: map,\n");
      out.write("                    position: latlng\n");
      out.write("                });   \n");
      out.write("              \n");
      out.write("            };\n");
      out.write("            \n");
      out.write("            function loadScript() {\n");
      out.write("                var script = document.createElement(\"script\");\n");
      out.write("                script.type = \"text/javascript\";\n");
      out.write("                script.src = \"http://maps.googleapis.com/maps/api/js?key=AIzaSyAfhwuXTgopU7b9KHaTB9YDZwQ6LdPbLJ8&sensor=false&callback=initialize\";\n");
      out.write("                    \n");
      out.write("                document.body.appendChild(script);\n");
      out.write("            };\n");
      out.write("             \n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div id=\"sfondo\" class=\"hero-unit\">\n");
      out.write("                <h1>General info</h1>\n");
      out.write("\n");
      out.write("                <h2>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((crowdMemories.Image)_jspx_page_context.findAttribute("immagine")).getTitle())));
      out.write("</h2>\n");
      out.write("                <img src=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((crowdMemories.Image)_jspx_page_context.findAttribute("immagine")).getUrl())));
      out.write("\"  class=\"img-rounded\" style=\"max-height: 400px; max-width: 400px\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <h1>Location</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("                ");

                    if (immagine.HasPosition()) {
                
      out.write("\n");
      out.write("\n");
      out.write("                <input id=\"lat\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((crowdMemories.Image)_jspx_page_context.findAttribute("immagine")).getLatitude())));
      out.write("\"/>\n");
      out.write("                <input id=\"lng\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((crowdMemories.Image)_jspx_page_context.findAttribute("immagine")).getLongitude())));
      out.write("\"/>\n");
      out.write("                <input id=\"radius\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((crowdMemories.Image)_jspx_page_context.findAttribute("immagine")).getRadius())));
      out.write("\"/>\n");
      out.write("\n");
      out.write("                <div id=\"map_canvas\"></div>\n");
      out.write("\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    loadScript();\n");
      out.write("                </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <a class=\"btn btn-danger btn-large\" href=\"mappacerchio.jsp\" style=\"width: 33%;\"> Edit the location</a>\n");
      out.write("                ");
                                } else {
                
      out.write("\n");
      out.write("                <a class=\"btn btn-danger btn-large\" href=\"mappacerchio.jsp\" style=\"width: 33%;\"> Add a location for youe photo</a>\n");
      out.write("                ");
                                }
                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <h1>Date</h1>\n");
      out.write("\n");
      out.write("                ");

                    if (immagine.getTypeofdate().equals("yes")) {
                
      out.write("\n");
      out.write("                <p name=\"date\">");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((crowdMemories.Image)_jspx_page_context.findAttribute("immagine")).getDate())));
      out.write("</p>\n");
      out.write("                ");
                               } else if (immagine.getTypeofdate().equals("almost")) {
                
      out.write("\n");
      out.write("                ");
                               } else if (immagine.getTypeofdate().equals("no")) {
                
      out.write("\n");
      out.write("                ");
                               } else if (immagine.getTypeofdate().equals("event")) {
                
      out.write("\n");
      out.write("                ");
                               }
                
      out.write("\n");
      out.write("                <a class=\"btn btn-primary btn-large\" href=\"date.jsp\" style=\"width: 33%;\">Edit the date</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div> \n");
      out.write("            <a class=\"btn btn-success btn-large\" href=\"index.jsp\" style=\"width: 33%;\" > Finish</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<table class=\"table\">\n");
      out.write("    <thead>\n");
      out.write("    <th>name</th>\n");
      out.write("    <th>details</th>\n");
      out.write("</thead>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        url\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getUrl());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        title\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getTitle());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        address\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getAddress());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        latitude\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getLatitude());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        longitude\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getLongitude());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        radius\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getRadius());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        location description\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getDescriptionLoc());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        date\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getDate());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        decade\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getDecade());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        year\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getYear());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        season\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getSeason());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        day\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getDay());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        dayname\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getDayName());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        time description\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            out.println(immagine.getDescriptionTime());
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        date accurancy\n");
      out.write("    </td>\n");
      out.write("    <td>\n");
      out.write("        ");

            //    out.println(date_accurancy(immagine));
        
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</body>\n");
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
