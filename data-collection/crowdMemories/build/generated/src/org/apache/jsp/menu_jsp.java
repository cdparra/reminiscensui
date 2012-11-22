package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    //setting url e immagine
    String url = request.getParameter("url");
    String title = request.getParameter("title");

    //setting location
    String loctype = request.getParameter("loctype");
    String lat = null;
    String lng = null;
    String radius = null;
    String indirizzo = null;
    String description_loc = null;
    boolean has_marker = false;
    boolean has_circle = false;
    boolean loc_desc = false;

    if (loctype.equals("map")) {

        lat = request.getParameter("lat");
        lng = request.getParameter("lng");
        radius = request.getParameter("radius");

        if (radius.equals("0")) {
            has_marker = true;
        } else {
            has_circle = true;
        }

        indirizzo = request.getParameter("indirizzo");

    } else if (loctype.equals("text")) {
        loc_desc = true;
        description_loc = request.getParameter("description");
    }

    //setting date
    String datetype = request.getParameter("submit");

    String date = null;
    String decade = null;
    String year = null;
    String season = null;
    String month = null;
    String day = null;
    String day_name = null;
    String day_part = null;
    String hour = null;
    String minute = null;
    String second = null;
    String description_time = null;

    if (datetype.equals("yes")) {

        date = request.getParameter("datepicker");

    } else if (datetype.equals("almost")) {

        decade = request.getParameter("decade");
        year = request.getParameter("year");
        month = request.getParameter("month");
        day = request.getParameter("day");
        day_name = request.getParameter("day_name");
        day_part = request.getParameter("day_part");
        season = request.getParameter("season");
        hour = request.getParameter("hour");
        minute = request.getParameter("minute");
        second = request.getParameter("second");

    } else if (datetype.equals("no")) {

        description_time = request.getParameter("description");
    }


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Summary</title>\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"jquery-ui-1.9.0.custom/css/smoothness/jquery-ui-1.9.0.custom.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"bootstrap/js/jquery-1.8.2.min.js\"></script>\n");
      out.write("        <script src=\"jquery-ui-1.9.0.custom/js/jquery-ui-1.9.0.custom.min.js\"></script>\n");
      out.write("        <script src=\"menuMap.js\"></script>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #image { \n");
      out.write("                display: block;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                max-height: 500px; \n");
      out.write("                max-width: 750px\n");
      out.write("                    /* margin-top: 60px; */\n");
      out.write("            }\n");
      out.write("            #sfondo { \n");
      out.write("                width: 940px;\n");
      out.write("                /* height: 1000px ;*/ \n");
      out.write("                margin-top: 40px;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                background-color: whitesmoke;\n");
      out.write("            }\n");
      out.write("            #sfondo p{\n");
      out.write("                margin-left: 40px;\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #sfondo h3{\n");
      out.write("                margin-left: 40px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #sfondo h1{\n");
      out.write("                margin-bottom: 0;\n");
      out.write("                font-size: 60px;\n");
      out.write("                line-height: 1;\n");
      out.write("                letter-spacing: -1px;\n");
      out.write("                color: inherit;\n");
      out.write("            }\n");
      out.write("            #sfondo .btn{\n");
      out.write("                margin-right: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #map_canvas{\n");
      out.write("\n");
      out.write("                width: 450px;\n");
      out.write("                height: 300px;               \n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                margin-top: 50px;\n");
      out.write("                margin-bottom: 40px;\n");
      out.write("            }\n");
      out.write("            p{/*\n");
      out.write("                text-align: center\n");
      out.write("                */ }\n");
      out.write("\n");
      out.write("            .btn-large{\n");
      out.write("                font-size: 20px\n");
      out.write("            }\n");
      out.write("            #loc-not{\n");
      out.write("                text-align: center;\n");
      out.write("                display: block;\n");
      out.write("                height: 120px;\n");
      out.write("                margin-top: 70px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div id=\"sfondo\" class=\"container\">\n");
      out.write("                <div>\n");
      out.write("                    <h1>Summary</h1>\n");
      out.write("\n");
      out.write("                    <h2 style=\"text-align: center\">");
      out.print(title);
      out.write("</h2>\n");
      out.write("                    <img id=\"image\" src=\"");
      out.print(url);
      out.write("\"  class=\"img-rounded\">\n");
      out.write("\n");
      out.write("                    <h1 style=\"margin-top: 50px;\">Location</h1>\n");
      out.write("\n");
      out.write("                    ");

                        if (has_marker) {
                    
      out.write("\n");
      out.write("                    <div style=\"display: none\">\n");
      out.write("                        <input id=\"lat\" value=\"");
      out.print(lat);
      out.write("\"/>\n");
      out.write("                        <input id=\"lng\" value=\"");
      out.print(lng);
      out.write("\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <a class=\"btn btn-primary btn-large pull-right\" href=\"mappacerchio.jsp\" style=\"margin-top: 50px\"> Edit the location</a>\n");
      out.write("                    <div class=\"span2\" style=\"margin-top: 100px\">\n");
      out.write("                        <p style=\"text-align: center\">");
      out.print(indirizzo);
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"map_canvas\"></div>\n");
      out.write("\n");
      out.write("                    <script type=\"text/javascript\">\n");
      out.write("                        loadScriptMapMarker();\n");
      out.write("                    </script>\n");
      out.write("\n");
      out.write("                    ");

                    } else if (has_circle) {
                    
      out.write("\n");
      out.write("                    <div style=\"display: none\">\n");
      out.write("                        <input id=\"lat\" value=\"");
      out.print(lat);
      out.write("\"/>\n");
      out.write("                        <input id=\"lng\" value=\"");
      out.print(lng);
      out.write("\"/>\n");
      out.write("                        <input id=\"radius\" value=\"");
      out.print(radius);
      out.write("\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <a class=\"btn btn-primary btn-large pull-right\" href=\"mappacerchio.jsp\" style=\"margin-top: 50px\"> Edit the location</a>\n");
      out.write("\n");
      out.write("                    <div id=\"map_canvas\"></div>\n");
      out.write("\n");
      out.write("                    <script type=\"text/javascript\">\n");
      out.write("                        loadScriptMapCircle();\n");
      out.write("                    </script>\n");
      out.write("\n");
      out.write("                    ");
                    } else if (loc_desc) {
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <div>\n");
      out.write("                        <a class=\"btn btn-primary btn-large pull-right\" href=\"mappacerchio.jsp\" > Edit the location</a>\n");
      out.write("                        <h3>Here is your text description</h3>\n");
      out.write("                        <p>");
      out.print(description_loc);
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");
                                } else {
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <div id=\"loc-not\">\n");
      out.write("                        <a class=\"btn btn-primary btn-large pull-right\" href=\"mappacerchio.jsp\" > Add a location for your photo</a>\n");
      out.write("                        <p>You don't enter a location! Click the button and add it</p>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");
                                }
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <h1>Date</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
                if (datetype.equals("yes")) {
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <div style=\"display: none\">\n");
      out.write("                        <input id=\"date\" value=\"");
      out.print(date);
      out.write("\"/>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div style=\"margin-top: 30px;\">\n");
      out.write("                        <a class=\"btn btn-primary btn-large pull-right\" href=\"date.jsp\" >Edit photo's date</a>\n");
      out.write("                        <p>");
      out.print(date);
      out.write("</p>\n");
      out.write("                        <div class=\"span3 offset4\" style=\"margin-top: 0px\">\n");
      out.write("                            <div id=\"datepicker\"></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <script type=\"text/javascript\">\n");
      out.write("                        var date = document.getElementById(\"date\").value;\n");
      out.write("                        console.log(date);\n");
      out.write("                        $(\"#datepicker\").datepicker({\n");
      out.write("                            defaultDate: date\n");
      out.write("                        });\n");
      out.write("                    </script>\n");
      out.write("                    ");
                                } else if (datetype.equals("no")) {
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <div>\n");
      out.write("                        <a class=\"btn btn-primary btn-large pull-right\" href=\"date.jsp\" >Edit photo's date</a>\n");
      out.write("                        <h3>Here is your date description</h3>\n");
      out.write("                        <p>");
      out.print(description_time);
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");
                                } else if (datetype.equals("almost")) {
                    
      out.write("\n");
      out.write("                    <div>\n");
      out.write("                        <a class=\"btn btn-primary btn-large pull-right\" href=\"date.jsp\" >Edit photo's date</a>\n");
      out.write("                        <table class=\"table\" style=\"width: 400px; text-align: center\">\n");
      out.write("                            ");

                                if (!(decade.equals(""))) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><p>Decade:</p> </td>\n");
      out.write("                                <td><p>");
      out.print(decade);
      out.write("</p></td>                            \n");
      out.write("                            </tr>\n");
      out.write("                            ");
                                            }
                                if (!(year.equals(""))) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><p>Year:</p> </td>\n");
      out.write("                                <td><p>");
      out.print(year);
      out.write("</p></td>                            \n");
      out.write("                            </tr>\n");
      out.write("                            ");
                                            }
                                if (!(season.equals(""))) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><p>Season:</p> </td>\n");
      out.write("                                <td><p>");
      out.print(season);
      out.write("</p></td>                            \n");
      out.write("                            </tr>\n");
      out.write("                            ");
                                            }
                                if (!(month.equals(""))) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><p>Month:</p> </td>\n");
      out.write("                                <td><p>");
      out.print(month);
      out.write("</p></td>                            \n");
      out.write("                            </tr>\n");
      out.write("                            ");
                                            }
                                if (!(day.equals(""))) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><p>Day:</p> </td>\n");
      out.write("                                <td><p>");
      out.print(day);
      out.write("</p></td>                            \n");
      out.write("                            </tr>\n");
      out.write("                            ");
                                            }
                                if (!(day_name.equals(""))) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><p>Day Name:</p> </td>\n");
      out.write("                                <td><p>");
      out.print(day_name);
      out.write("</p></td>                            \n");
      out.write("                            </tr>\n");
      out.write("                            ");
                                            }
                                if (!(day_part.equals(""))) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><p>Day Part:</p> </td>\n");
      out.write("                                <td><p>");
      out.print(day_part);
      out.write("</p></td>                            \n");
      out.write("                            </tr>\n");
      out.write("                            ");
                                            }
                                if (!(hour.equals(""))) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><p>hour:</p> </td>\n");
      out.write("                                <td><p>");
      out.print(hour);
      out.write("</p></td>                            \n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            ");
                                            }
                                if (!(minute.equals(""))) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><p>minute:</p> </td>\n");
      out.write("                                <td><p>");
      out.print(minute);
      out.write("</p></td>                            \n");
      out.write("                            </tr>\n");
      out.write("                            ");
                                            }
                                if (!(second.equals(""))) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><p>second:</p> </td>\n");
      out.write("                                <td><p>");
      out.print(second);
      out.write("</p></td>                            \n");
      out.write("                            </tr>\n");
      out.write("                            ");
                                           }
                            
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                    } else {
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <div id=\"loc-not\">\n");
      out.write("                        <a class=\"btn btn-primary btn-large pull-right\" href=\"date.jsp\" >Add photo's date</a>\n");
      out.write("                        <p>You don't enter a date! Click the button and add it</p>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");
    }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"hero-unit\" style=\"margin-top: 100px; width: 823px; margin-left: auto; margin-right: auto;text-align: center;\"> \n");
      out.write("                <form action=\"Submit\" name=\"submit\">\n");
      out.write("                    <h2>If everything you enter is correct just click Submit</h2>\n");
      out.write("                    <button class=\"btn btn-success btn-large\" style=\"width: 300px\" type=\"submit\"> Submit </button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <table class=\"table\" style=\"margin-top: 200px\">\n");
      out.write("            <thead>\n");
      out.write("            <th>name</th>\n");
      out.write("            <th>details</th>\n");
      out.write("        </thead>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                url\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(url);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                title\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(title);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                address\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(indirizzo);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                latitude\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(lat);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                longitude\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(lng);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                radius\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(radius);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                location description text\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(description_loc);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                date\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(date);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                exact-date\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(date);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                decade\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(decade);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                year\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(year);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                season\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(season);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                day\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(day);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                dayname\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(day_name);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                day part\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(day_part);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                hour\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(hour);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                min\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(minute);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                sec\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(second);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                time description\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(description_loc);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                type of date\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");
      out.print(datetype);
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
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
