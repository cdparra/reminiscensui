package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import crowdMemories.Location;

public final class date_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");




    String url = request.getParameter("url");
    String title = request.getParameter("title");
    String button = request.getParameter("submit");
    String lat = null, lng = null, radius = null, indirizzo = null, description = null;

    if (button.equals("map")) {

        lat = request.getParameter("lat");
        lng = request.getParameter("lng");
        radius = request.getParameter("radius");
        indirizzo = request.getParameter("indirizzo");

    } else if (button.equals("text")) {

        description = request.getParameter("description");
    }


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Date Page</title>\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"jquery-ui-1.9.0.custom/css/smoothness/jquery-ui-1.9.0.custom.min.css\" rel=\"stylesheet\"/>\n");
      out.write("\n");
      out.write("        <script src=\"bootstrap/js/jquery-1.8.2.min.js\"></script>\n");
      out.write("        <script src=\"jquery-ui-1.9.0.custom/js/jquery-ui-1.9.0.custom.min.js\"></script>\n");
      out.write("        <script src=\"date.js\"></script>\n");
      out.write("\n");
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
      out.write("                margin-top: 40px;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function check(num){\n");
      out.write("                if(isNaN(num)){\n");
      out.write("                    alert(\"Please enter a number!\");   \n");
      out.write("                    num.value = null;\n");
      out.write("                }  \n");
      out.write("            }\n");
      out.write("        </script>\n");
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
      out.write("                            <button name=\"submit\" value=\"yes\" class=\"btn btn-success btn-large pull-right\" type=\"submit\" style=\"margin-left: 540px;\"> Submit </button>\n");
      out.write("                            Date: <input name=\"datepicker\" type=\"text\" id=\"datepicker\" placeholder=\"click here to view calendar\" readonly=\"readonly\"/>\n");
      out.write("                            ");

                                if (button.equals("map")) {
                            
      out.write("\n");
      out.write("                            <div style=\"display:none\">\n");
      out.write("                                <input name=\"url\" value=\"");
      out.print( url);
      out.write("\">\n");
      out.write("                                <input name=\"title\" value=\"");
      out.print( title);
      out.write("\">\n");
      out.write("                                <input name=\"lat\" value=\"");
      out.print( lat);
      out.write("\">\n");
      out.write("                                <input name=\"lng\" value=\"");
      out.print( lng);
      out.write("\">\n");
      out.write("                                <input name=\"radius\" value=\"");
      out.print( radius);
      out.write("\">\n");
      out.write("                                <input name=\"indirizzo\" value=\"");
      out.print( indirizzo);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            ");

                            } else if (button.equals("text")) {
                            
      out.write("\n");
      out.write("                            <div style=\"display:none\">\n");
      out.write("                                <input name=\"url\" value=\"");
      out.print( url);
      out.write("\">\n");
      out.write("                                <input name=\"title\" value=\"");
      out.print( title);
      out.write("\">\n");
      out.write("                                <input name=\"description\" value=\"");
      out.print( description);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            ");
                             }
                            
      out.write("\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <button id=\"almost\" class=\"btn btn-large btn-primary btn-block\" >Almost</button>\n");
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
      out.write("                                                <td><p>Decade:</p></td>\n");
      out.write("                                                <td><input id=\"decade\" name=\"decade\" type=\"text\" placeholder=\"1980\" value=\"\" onchange=\"check(this)\"/></td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Year:</p></td>\n");
      out.write("                                                <td><input name=\"year\" type=\"text\" placeholder=\"1986\" value=\"\" onchange=\"check(this)\"/></td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Season:</p> </td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <select name=\"season\">\n");
      out.write("                                                        <option selected value=\"\">Select Season</option>\n");
      out.write("                                                        <option value=\"Winter\">Winter</option>\n");
      out.write("                                                        <option value=\"Spring\">Spring</option>\n");
      out.write("                                                        <option value=\"Summer\">Summer</option>\n");
      out.write("                                                        <option value=\"Autumn\">Autumn</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Month:</p> </td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <select name=\"month\">\n");
      out.write("                                                        <option selected value=\"\">Select Month</option>\n");
      out.write("                                                        <option value=\"01\">January</option>\n");
      out.write("                                                        <option value=\"02\">February</option>\n");
      out.write("                                                        <option value=\"03\">March</option>\n");
      out.write("                                                        <option value=\"04\">April</option>\n");
      out.write("                                                        <option value=\"05\">May</option>\n");
      out.write("                                                        <option value=\"06\">June</option>\n");
      out.write("                                                        <option value=\"07\">July</option>\n");
      out.write("                                                        <option value=\"08\">August</option>\n");
      out.write("                                                        <option value=\"09\">September</option>\n");
      out.write("                                                        <option value=\"10\">October</option>\n");
      out.write("                                                        <option value=\"11\">November</option>\n");
      out.write("                                                        <option value=\"12\">December</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </td>                                                                  \n");
      out.write("                                            </tr>\n");
      out.write("                                        </table>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <table class=\"table\">\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Day:</p> </td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <select name=\"day\">\n");
      out.write("                                                        <option selected value=\"\">Select Day</option>\n");
      out.write("                                                        <option value=\"1\">1</option>\n");
      out.write("                                                        <option value=\"2\">2</option>\n");
      out.write("                                                        <option value=\"3\">3</option>\n");
      out.write("                                                        <option value=\"4\">4</option>\n");
      out.write("                                                        <option value=\"5\">5</option>\n");
      out.write("                                                        <option value=\"6\">6</option>\n");
      out.write("                                                        <option value=\"7\">7</option>\n");
      out.write("                                                        <option value=\"8\">8</option>\n");
      out.write("                                                        <option value=\"9\">9</option>\n");
      out.write("                                                        <option value=\"10\">10</option>\n");
      out.write("                                                        <option value=\"11\">11</option>\n");
      out.write("                                                        <option value=\"12\">12</option>\n");
      out.write("                                                        <option value=\"13\">13</option>\n");
      out.write("                                                        <option value=\"14\">14</option>\n");
      out.write("                                                        <option value=\"15\">15</option>\n");
      out.write("                                                        <option value=\"16\">16</option>\n");
      out.write("                                                        <option value=\"17\">17</option>\n");
      out.write("                                                        <option value=\"18\">18</option>\n");
      out.write("                                                        <option value=\"19\">19</option>\n");
      out.write("                                                        <option value=\"20\">20</option>\n");
      out.write("                                                        <option value=\"21\">21</option>\n");
      out.write("                                                        <option value=\"22\">22</option>\n");
      out.write("                                                        <option value=\"23\">23</option>\n");
      out.write("                                                        <option value=\"24\">24</option>\n");
      out.write("                                                        <option value=\"25\">25</option>\n");
      out.write("                                                        <option value=\"26\">26</option>\n");
      out.write("                                                        <option value=\"27\">27</option>\n");
      out.write("                                                        <option value=\"28\">28</option>\n");
      out.write("                                                        <option value=\"29\">29</option>\n");
      out.write("                                                        <option value=\"30\">30</option>\n");
      out.write("                                                        <option value=\"31\">31</option>\n");
      out.write("                                                    </select> \n");
      out.write("                                                </td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Day Name:</p> </td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <select name=\"day_name\">\n");
      out.write("                                                        <option selected value=\"\">Select Day Name</option>\n");
      out.write("                                                        <option value=\"Monday\">Monday</option>\n");
      out.write("                                                        <option value=\"Tuesday\">Tuesday</option>\n");
      out.write("                                                        <option value=\"Wednesday\">Wednesday</option>\n");
      out.write("                                                        <option value=\"Thursday\">Thursday</option>\n");
      out.write("                                                        <option value=\"Friday\">Friday</option>\n");
      out.write("                                                        <option value=\"Saturday\">Saturday</option>\n");
      out.write("                                                        <option value=\"Sunday\">Sunday</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </td>                     \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Day Part:</p></td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <select name=\"day_part\">\n");
      out.write("                                                        <option selected value=\"\">Select Day Part</option>\n");
      out.write("                                                        <option value=\"early morning\">Early morning</option>\n");
      out.write("                                                        <option value=\"morning\">Morning</option>\n");
      out.write("                                                        <option value=\"midday\">Midday</option>\n");
      out.write("                                                        <option value=\"afternoon\">Afternoon</option>\n");
      out.write("                                                        <option value=\"evening\">Evening</option>\n");
      out.write("                                                        <option value=\"night\">Night</option>\n");
      out.write("                                                        <option value=\"midnight\">Midnight</option>\n");
      out.write("                                                        <option value=\"late night\">Late night</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><p>Time:</p></td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <select name=\"hour\" style=\"max-width: 70px;\">\n");
      out.write("                                                        <option selected value=\"\">hh</option>\n");
      out.write("                                                        <option value=\"00\">00</option>\n");
      out.write("                                                        <option value=\"01\">01</option>\n");
      out.write("                                                        <option value=\"02\">02</option>\n");
      out.write("                                                        <option value=\"03\">03</option>\n");
      out.write("                                                        <option value=\"04\">04</option>\n");
      out.write("                                                        <option value=\"05\">05</option>\n");
      out.write("                                                        <option value=\"06\">06</option>\n");
      out.write("                                                        <option value=\"07\">07</option>\n");
      out.write("                                                        <option value=\"08\">08</option>\n");
      out.write("                                                        <option value=\"09\">09</option>\n");
      out.write("                                                        <option value=\"10\">10</option>\n");
      out.write("                                                        <option value=\"11\">11</option>\n");
      out.write("                                                        <option value=\"12\">12</option>\n");
      out.write("                                                        <option value=\"13\">13</option>\n");
      out.write("                                                        <option value=\"14\">14</option>\n");
      out.write("                                                        <option value=\"15\">15</option>\n");
      out.write("                                                        <option value=\"16\">16</option>\n");
      out.write("                                                        <option value=\"17\">17</option>\n");
      out.write("                                                        <option value=\"18\">18</option>\n");
      out.write("                                                        <option value=\"19\">19</option>\n");
      out.write("                                                        <option value=\"20\">20</option>\n");
      out.write("                                                        <option value=\"21\">21</option>\n");
      out.write("                                                        <option value=\"22\">22</option>\n");
      out.write("                                                        <option value=\"23\">23</option>\n");
      out.write("                                                    </select> \n");
      out.write("                                                    <select name=\"minute\" style=\"max-width: 70px;\">\n");
      out.write("                                                        <option selected value=\"\">mm</option>\n");
      out.write("                                                        <option value=\"00\">00</option>\n");
      out.write("                                                        <option value=\"01\">01</option>\n");
      out.write("                                                        <option value=\"02\">02</option>\n");
      out.write("                                                        <option value=\"03\">03</option>\n");
      out.write("                                                        <option value=\"04\">04</option>\n");
      out.write("                                                        <option value=\"05\">05</option>\n");
      out.write("                                                        <option value=\"06\">06</option>\n");
      out.write("                                                        <option value=\"07\">07</option>\n");
      out.write("                                                        <option value=\"08\">08</option>\n");
      out.write("                                                        <option value=\"09\">09</option>\n");
      out.write("                                                        <option value=\"10\">10</option>\n");
      out.write("                                                        <option value=\"11\">11</option>\n");
      out.write("                                                        <option value=\"12\">12</option>\n");
      out.write("                                                        <option value=\"13\">13</option>\n");
      out.write("                                                        <option value=\"14\">14</option>\n");
      out.write("                                                        <option value=\"15\">15</option>\n");
      out.write("                                                        <option value=\"16\">16</option>\n");
      out.write("                                                        <option value=\"17\">17</option>\n");
      out.write("                                                        <option value=\"18\">18</option>\n");
      out.write("                                                        <option value=\"19\">19</option>\n");
      out.write("                                                        <option value=\"20\">20</option>\n");
      out.write("                                                        <option value=\"21\">21</option>\n");
      out.write("                                                        <option value=\"22\">22</option>\n");
      out.write("                                                        <option value=\"23\">23</option>\n");
      out.write("                                                        <option value=\"24\">24</option>\n");
      out.write("                                                        <option value=\"25\">25</option>\n");
      out.write("                                                        <option value=\"26\">26</option>\n");
      out.write("                                                        <option value=\"27\">27</option>\n");
      out.write("                                                        <option value=\"28\">28</option>\n");
      out.write("                                                        <option value=\"29\">29</option>\n");
      out.write("                                                        <option value=\"30\">30</option>\n");
      out.write("                                                        <option value=\"31\">31</option>                                                    \n");
      out.write("                                                        <option value=\"32\">32</option>                                                      \n");
      out.write("                                                        <option value=\"33\">33</option>\n");
      out.write("                                                        <option value=\"34\">34</option>\n");
      out.write("                                                        <option value=\"35\">35</option>\n");
      out.write("                                                        <option value=\"36\">36</option>\n");
      out.write("                                                        <option value=\"37\">37</option>\n");
      out.write("                                                        <option value=\"38\">38</option>\n");
      out.write("                                                        <option value=\"39\">39</option>\n");
      out.write("                                                        <option value=\"40\">40</option>\n");
      out.write("                                                        <option value=\"41\">41</option>\n");
      out.write("                                                        <option value=\"42\">42</option>\n");
      out.write("                                                        <option value=\"43\">43</option>\n");
      out.write("                                                        <option value=\"44\">44</option>\n");
      out.write("                                                        <option value=\"45\">45</option>\n");
      out.write("                                                        <option value=\"46\">46</option>\n");
      out.write("                                                        <option value=\"47\">47</option>\n");
      out.write("                                                        <option value=\"48\">48</option>\n");
      out.write("                                                        <option value=\"49\">49</option>\n");
      out.write("                                                        <option value=\"50\">50</option>\n");
      out.write("                                                        <option value=\"51\">51</option>\n");
      out.write("                                                        <option value=\"52\">52</option>\n");
      out.write("                                                        <option value=\"53\">53</option>\n");
      out.write("                                                        <option value=\"54\">54</option>\n");
      out.write("                                                        <option value=\"55\">55</option>\n");
      out.write("                                                        <option value=\"56\">56</option>\n");
      out.write("                                                        <option value=\"57\">57</option>\n");
      out.write("                                                        <option value=\"58\">58</option>\n");
      out.write("                                                        <option value=\"59\">59</option>\n");
      out.write("                                                    </select> \n");
      out.write("                                                    <select name=\"second\" style=\"max-width: 70px \">\n");
      out.write("                                                        <option selected value=\"\">ss</option>\n");
      out.write("                                                        <option value=\"00\">00</option>\n");
      out.write("                                                        <option value=\"01\">01</option>\n");
      out.write("                                                        <option value=\"02\">02</option>\n");
      out.write("                                                        <option value=\"03\">03</option>\n");
      out.write("                                                        <option value=\"04\">04</option>\n");
      out.write("                                                        <option value=\"05\">05</option>\n");
      out.write("                                                        <option value=\"06\">06</option>\n");
      out.write("                                                        <option value=\"07\">07</option>\n");
      out.write("                                                        <option value=\"08\">08</option>\n");
      out.write("                                                        <option value=\"09\">09</option>\n");
      out.write("                                                        <option value=\"10\">10</option>\n");
      out.write("                                                        <option value=\"11\">11</option>\n");
      out.write("                                                        <option value=\"12\">12</option>\n");
      out.write("                                                        <option value=\"13\">13</option>\n");
      out.write("                                                        <option value=\"14\">14</option>\n");
      out.write("                                                        <option value=\"15\">15</option>\n");
      out.write("                                                        <option value=\"16\">16</option>\n");
      out.write("                                                        <option value=\"17\">17</option>\n");
      out.write("                                                        <option value=\"18\">18</option>\n");
      out.write("                                                        <option value=\"19\">19</option>\n");
      out.write("                                                        <option value=\"20\">20</option>\n");
      out.write("                                                        <option value=\"21\">21</option>\n");
      out.write("                                                        <option value=\"22\">22</option>\n");
      out.write("                                                        <option value=\"23\">23</option>\n");
      out.write("                                                        <option value=\"24\">24</option>\n");
      out.write("                                                        <option value=\"25\">25</option>\n");
      out.write("                                                        <option value=\"26\">26</option>\n");
      out.write("                                                        <option value=\"27\">27</option>\n");
      out.write("                                                        <option value=\"28\">28</option>\n");
      out.write("                                                        <option value=\"29\">29</option>\n");
      out.write("                                                        <option value=\"30\">30</option>\n");
      out.write("                                                        <option value=\"31\">31</option>                                                    \n");
      out.write("                                                        <option value=\"32\">32</option>                                                      \n");
      out.write("                                                        <option value=\"33\">33</option>\n");
      out.write("                                                        <option value=\"34\">34</option>\n");
      out.write("                                                        <option value=\"35\">35</option>\n");
      out.write("                                                        <option value=\"36\">36</option>\n");
      out.write("                                                        <option value=\"37\">37</option>\n");
      out.write("                                                        <option value=\"38\">38</option>\n");
      out.write("                                                        <option value=\"39\">39</option>\n");
      out.write("                                                        <option value=\"40\">40</option>\n");
      out.write("                                                        <option value=\"41\">41</option>\n");
      out.write("                                                        <option value=\"42\">42</option>\n");
      out.write("                                                        <option value=\"43\">43</option>\n");
      out.write("                                                        <option value=\"44\">44</option>\n");
      out.write("                                                        <option value=\"45\">45</option>\n");
      out.write("                                                        <option value=\"46\">46</option>\n");
      out.write("                                                        <option value=\"47\">47</option>\n");
      out.write("                                                        <option value=\"48\">48</option>\n");
      out.write("                                                        <option value=\"49\">49</option>\n");
      out.write("                                                        <option value=\"50\">50</option>\n");
      out.write("                                                        <option value=\"51\">51</option>\n");
      out.write("                                                        <option value=\"52\">52</option>\n");
      out.write("                                                        <option value=\"53\">53</option>\n");
      out.write("                                                        <option value=\"54\">54</option>\n");
      out.write("                                                        <option value=\"55\">55</option>\n");
      out.write("                                                        <option value=\"56\">56</option>\n");
      out.write("                                                        <option value=\"57\">57</option>\n");
      out.write("                                                        <option value=\"58\">58</option>\n");
      out.write("                                                        <option value=\"59\">59</option>\n");
      out.write("                                                    </select> \n");
      out.write("                                                    <!--\n");
      out.write("                                                    <input name=\"time\" type=\"text\" placeholder=\"hh-mm-ss\" value=\"\"/>\n");
      out.write("                                                    -->\n");
      out.write("                                                </td>                            \n");
      out.write("                                            </tr>\n");
      out.write("                                        </table>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>  \n");
      out.write("                            ");

                                if (button.equals("map")) {
                            
      out.write("\n");
      out.write("                            <div style=\"display:none\">\n");
      out.write("                                <input name=\"url\" value=\"");
      out.print( url);
      out.write("\">\n");
      out.write("                                <input name=\"title\" value=\"");
      out.print( title);
      out.write("\">\n");
      out.write("                                <input name=\"lat\" value=\"");
      out.print( lat);
      out.write("\">\n");
      out.write("                                <input name=\"lng\" value=\"");
      out.print( lng);
      out.write("\">\n");
      out.write("                                <input name=\"radius\" value=\"");
      out.print( radius);
      out.write("\">\n");
      out.write("                                <input name=\"indirizzo\" value=\"");
      out.print( indirizzo);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            ");

                            } else if (button.equals("text")) {
                            
      out.write("\n");
      out.write("                            <div style=\"display:none\">\n");
      out.write("                                <input name=\"url\" value=\"");
      out.print( url);
      out.write("\">\n");
      out.write("                                <input name=\"title\" value=\"");
      out.print( title);
      out.write("\">\n");
      out.write("                                <input name=\"description\" value=\"");
      out.print( description);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            ");
                             }
                            
      out.write("\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <button id=\"no\" class=\"btn btn-large btn-danger btn-block\">No</button>\n");
      out.write("\n");
      out.write("                    <div id=\"nodiv\">\n");
      out.write("                        <form action=\"menu.jsp\" >\n");
      out.write("                            <textarea id=\"description\" name=\"description\" placeholder=\"Try to write date textually\" ></textarea>\n");
      out.write("                            <button name=\"submit\" value=\"no\" class=\"btn btn-danger btn-large pull-right\" type=\"submit\"> Submit </button>\n");
      out.write("                            ");

                                if (button.equals("map")) {
                            
      out.write("\n");
      out.write("                            <div style=\"display:none\">\n");
      out.write("                                <input name=\"url\" value=\"");
      out.print( url);
      out.write("\">\n");
      out.write("                                <input name=\"title\" value=\"");
      out.print( title);
      out.write("\">\n");
      out.write("                                <input name=\"lat\" value=\"");
      out.print( lat);
      out.write("\">\n");
      out.write("                                <input name=\"lng\" value=\"");
      out.print( lng);
      out.write("\">\n");
      out.write("                                <input name=\"radius\" value=\"");
      out.print( radius);
      out.write("\">\n");
      out.write("                                <input name=\"indirizzo\" value=\"");
      out.print( indirizzo);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            ");

                            } else if (button.equals("text")) {
                            
      out.write("\n");
      out.write("                            <div style=\"display:none\">\n");
      out.write("                                <input name=\"url\" value=\"");
      out.print( url);
      out.write("\">\n");
      out.write("                                <input name=\"title\" value=\"");
      out.print( title);
      out.write("\">\n");
      out.write("                                <input name=\"description\" value=\"");
      out.print( description);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            ");
                             }
                            
      out.write("\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <!--\n");
      out.write("                                        <button id=\"event\" class=\"btn btn-large btn-warning btn-block\" >There was an event?</button>\n");
      out.write("                    \n");
      out.write("                                        <div id=\"eventdiv\">\n");
      out.write("                                            <form action=\"menu.jsp\">\n");
      out.write("                                                <p>Here goes the event chooser</p>\n");
      out.write("                                                <input name=\"event\" />\n");
      out.write("                                                <button name=\"submit\" value=\"event\" class=\"btn btn-warning btn-large pull-right\" type=\"submit\"> Submit </button>\n");
      out.write("                                            </form>\n");
      out.write("                                        </div>\n");
      out.write("                    -->\n");
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
