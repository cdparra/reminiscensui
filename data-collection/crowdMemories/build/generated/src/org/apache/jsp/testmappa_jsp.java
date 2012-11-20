package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testmappa_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\" />\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\"/>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("\n");
      out.write("            /*   html { height: 100% }\n");
      out.write("               body { height: 100%; margin: 0; padding: 0 }\n");
      out.write("            /*/\n");
      out.write("            p{\n");
      out.write("                text-align: center\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #map_canvas { \n");
      out.write("                height: 100%;\n");
      out.write("                width: 100% \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #sfondo { \n");
      out.write("                width: 940px;\n");
      out.write("                height: 620px;\n");
      out.write("                margin-top: 40px;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script src=\"bootstrap/js/jquery-1.8.2.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\"\n");
      out.write("                src=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyAfhwuXTgopU7b9KHaTB9YDZwQ6LdPbLJ8&sensor=false\">\n");
      out.write("        </script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            var geocoder;\n");
      out.write("            var map;\n");
      out.write("            var marker;\n");
      out.write("            var latlng;\n");
      out.write("            \n");
      out.write("            function initialize() {\n");
      out.write("                geocoder = new google.maps.Geocoder();\n");
      out.write("                \n");
      out.write("                latlng = new google.maps.LatLng(41.901514, 12.4607737);\n");
      out.write("                \n");
      out.write("                var mapOptions = {\n");
      out.write("                    zoom: 8,\n");
      out.write("                    center: latlng,\n");
      out.write("                    mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("                }\n");
      out.write("               \n");
      out.write("                map = new google.maps.Map(document.getElementById(\"map_canvas\"), mapOptions);\n");
      out.write("                \n");
      out.write("                marker = new google.maps.Marker({\n");
      out.write("                    position: latlng,\n");
      out.write("                    map: map,\n");
      out.write("                    draggable: true\n");
      out.write("                }); \n");
      out.write("            \n");
      out.write("                google.maps.event.addListener(marker, 'dragend', function() {                    \n");
      out.write("                    map.setCenter(marker.getPosition());\n");
      out.write("                    document.getElementById(\"lat\").innerHTML = marker.getPosition().lat();\n");
      out.write("                    document.getElementById(\"lng\").innerHTML = marker.getPosition().lng();\n");
      out.write("                    \n");
      out.write("                });\n");
      out.write("            \n");
      out.write("                if(navigator.geolocation) {\n");
      out.write("                    navigator.geolocation.getCurrentPosition(function(position) {\n");
      out.write("                        var pos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);\n");
      out.write("                        \n");
      out.write("                        marker.setPosition(pos);\n");
      out.write("                        document.getElementById(\"lat\").innerHTML = marker.getPosition().lat();\n");
      out.write("                        document.getElementById(\"lng\").innerHTML = marker.getPosition().lng();\n");
      out.write("                   \n");
      out.write("                        map.setCenter(pos);\n");
      out.write("                    }, function() {\n");
      out.write("                        handleNoGeolocation(true);\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("                else {\n");
      out.write("                    // Browser doesn't support Geolocation\n");
      out.write("                    handleNoGeolocation(false);\n");
      out.write("                }\n");
      out.write("            }        \n");
      out.write("           \n");
      out.write("            function handleNoGeolocation(errorFlag) {\n");
      out.write("                //var latlng = new google.maps.LatLng(-34.397, 150.644);\n");
      out.write("                if (errorFlag) {\n");
      out.write("                    var content = 'Error: The Geolocation service failed.';\n");
      out.write("                } else {\n");
      out.write("                    var content = 'Error: Your browser doesn\\'t support geolocation.';\n");
      out.write("                }\n");
      out.write("                var options = {\n");
      out.write("                    map: map,\n");
      out.write("                    position: latlng,\n");
      out.write("                    content: content\n");
      out.write("                };\n");
      out.write("               \n");
      out.write("                var infowindow = new google.maps.InfoWindow(options);\n");
      out.write("                map.setCenter(options.position);\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("            function codeAddress() {\n");
      out.write("                var address = document.getElementById(\"address\").value;\n");
      out.write("                geocoder.geocode( { 'address': address}, function(results, status) {\n");
      out.write("                    if (status == google.maps.GeocoderStatus.OK) {\n");
      out.write("                        \n");
      out.write("                        map.setCenter(results[0].geometry.location);\n");
      out.write("                        marker.setPosition(results[0].geometry.location);\n");
      out.write("                      \n");
      out.write("                        document.getElementById(\"lat\").innerHTML = marker.getPosition().lat();\n");
      out.write("                        document.getElementById(\"lng\").innerHTML = marker.getPosition().lng();\n");
      out.write("                                        \n");
      out.write("                    } else {\n");
      out.write("                        alert(\"Geocode was not successful for the following reason: \" + status);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            } \n");
      out.write("            \n");
      out.write("            // google.maps.event.addDomListener(window, 'load', initialize);\n");
      out.write("        \n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"initialize()\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div id=\"sfondo\" class=\"hero-unit\">\n");
      out.write("                <h1>Do you remember the location?</h1>\n");
      out.write("                <div class=\"span7\" style=\"width: 540px; height: 480px\">\n");
      out.write("                    <p>If you remember exactly the location just drag the marker on the map over the location and submit.</p>\n");
      out.write("                    <div id=\"map_canvas\" ></div>\n");
      out.write("                    <table style=\"width: 200px; height: 30px\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td id=\"lat\"></td>\n");
      out.write("                            <td id=\"lng\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"span4\" style=\"width:340px\">\n");
      out.write("                    <p> Otherwise you can search or describe it textually.</p>\n");
      out.write("\n");
      out.write("                    <input id=\"address\" type=\"text\" placeholder=\"Insert place here\" >\n");
      out.write("                    <input type=\"button\" class=\"btn btn-primary\" value=\"Search Place\" onclick=\"codeAddress()\">\n");
      out.write("\n");
      out.write("                    <textarea style=\"width: 340px; height: 280px; resize: none\" placeholder=\"Add location textually\"></textarea>\n");
      out.write("                \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
