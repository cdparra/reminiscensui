<%-- 
    Document   : menu
    Created on : 10-ott-2012, 17.14.51
    Author     : francesco
--%>

<%@page errorPage="errorPage.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
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

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <link href="jquery-ui-1.9.0.custom/css/smoothness/jquery-ui-1.9.0.custom.min.css" rel="stylesheet">
        <script src="bootstrap/js/jquery-1.8.2.min.js"></script>
        <script src="jquery-ui-1.9.0.custom/js/jquery-ui-1.9.0.custom.min.js"></script>
        <script src="http://dev.kucherbaev.com/CrowdMemories/cm-func.js"></script>
        <script src="menuMap.js"></script>

        <style type="text/css">
            #image { 
                display: block;
                margin-left: auto;
                margin-right: auto;
                max-height: 500px; 
                max-width: 750px;
                margin-bottom: 40px;
                margin-top: 40px
            }
            #sfondo { 
                width: 940px;
                /* height: 1000px ;*/ 
                margin-top: 40px;
                margin-left: auto;
                margin-right: auto;
                background-color: whitesmoke;
            }
            #sfondo p{
                margin-left: 40px;
                font-size: 20px;
            }

            #sfondo h3{
                margin-left: 40px;
            }

            #sfondo h1{
                margin-bottom: 0;
                font-size: 60px;
                line-height: 1;
                letter-spacing: -1px;
                color: inherit;
            }
            #sfondo .btn{
                margin-right: 10px;
            }

            #map_canvas{

                width: 450px;
                height: 300px;               
                margin-left: auto;
                margin-right: auto;
                margin-top: 50px;
                margin-bottom: 40px;
            }
            p{/*
                text-align: center
                */ }

            .btn-large{
                font-size: 20px
            }
            #loc-not{
                text-align: center;
                display: block;
                height: 120px;
                margin-top: 70px;
            }
        </style>

    </head>
    <body>
        <div class="container">
            <div id="sfondo" class="container">
                <div>
                    <h1>Summary</h1>

                    <h2 style="text-align: center"><%=title%></h2>
                    <img id="image" src="<%=url%>"  class="img-rounded">

                    <h1 style="margin-top: 50px;">Location</h1>

                    <%
                        if (has_marker) {
                    %>
                    <div style="display: none">
                        <input id="lat" value="<%=lat%>"/>
                        <input id="lng" value="<%=lng%>"/>
                    </div>
                    <div class="span2" style="margin-top: 100px">
                        <p style="text-align: center"><%=indirizzo%></p>
                    </div>
                    <div id="map_canvas"></div>

                    <script type="text/javascript">
                        loadScriptMapMarker();
                    </script>

                    <%
                    } else if (has_circle) {
                    %>
                    <div style="display: none">
                        <input id="lat" value="<%=lat%>"/>
                        <input id="lng" value="<%=lng%>"/>
                        <input id="radius" value="<%=radius%>"/>
                    </div>

                    <div id="map_canvas"></div>

                    <script type="text/javascript">
                        loadScriptMapCircle();
                    </script>

                    <%                    } else if (loc_desc) {
                    %>

                    <div>
                        <h3>Here is your text description</h3>
                        <p><%=description_loc%></p>
                    </div>

                    <%                                } else {
                    %>

                    <div id="loc-not">
                        <p>You don't enter a location!</p>
                    </div>

                    <%                                }
                    %>

                    <h1>Date</h1>


                    <%                if (datetype.equals("yes")) {
                    %>

                    <div style="display: none">
                        <input id="date" value="<%=date%>"/>
                    </div>

                    <div style="margin-top: 30px;">
                        <p><%=date%></p>
                        <div class="span3 offset4" style="margin-top: 0px">
                            <div id="datepicker"></div>
                        </div>
                    </div>

                    <script type="text/javascript">
                        var date = document.getElementById("date").value;
                        console.log(date);
                        $("#datepicker").datepicker({
                            defaultDate: date
                        });
                    </script>
                    <%                                } else if (datetype.equals("no")) {
                    %>

                    <div>
                        <h3>Here is your date description</h3>
                        <p><%=description_time%></p>
                    </div>

                    <%                                } else if (datetype.equals("almost")) {
                    %>
                    <div>
                        <table class="table" style="width: 400px; text-align: center">
                            <%
                                if (!(decade.equals(""))) {
                            %>
                            <tr>
                                <td><p>Decade:</p> </td>
                                <td><p><%=decade%></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(year.equals(""))) {
                            %>
                            <tr>
                                <td><p>Year:</p> </td>
                                <td><p><%=year%></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(season.equals(""))) {
                            %>
                            <tr>
                                <td><p>Season:</p> </td>
                                <td><p><%=season%></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(month.equals(""))) {
                            %>
                            <tr>
                                <td><p>Month:</p> </td>
                                <td><p><%=month%></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(day.equals(""))) {
                            %>
                            <tr>
                                <td><p>Day:</p> </td>
                                <td><p><%=day%></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(day_name.equals(""))) {
                            %>
                            <tr>
                                <td><p>Day Name:</p> </td>
                                <td><p><%=day_name%></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(day_part.equals(""))) {
                            %>
                            <tr>
                                <td><p>Day Part:</p> </td>
                                <td><p><%=day_part%></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(hour.equals(""))) {
                            %>
                            <tr>
                                <td><p>hour:</p> </td>
                                <td><p><%=hour%></p></td>                            
                            </tr>

                            <%                                            }
                                if (!(minute.equals(""))) {
                            %>
                            <tr>
                                <td><p>minute:</p> </td>
                                <td><p><%=minute%></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(second.equals(""))) {
                            %>
                            <tr>
                                <td><p>second:</p> </td>
                                <td><p><%=second%></p></td>                            
                            </tr>
                            <%                                           }
                            %>
                        </table>
                    </div>
                    <%
                    } else {
                    %>

                    <div id="loc-not">
                        <p>You don't enter a date!</p>
                    </div>

                    <%    }
                    %>
                </div>

            </div>
            <div class="hero-unit" style="margin-top: 100px; width: 823px; margin-left: auto; margin-right: auto;text-align: center;"> 
                <form action="Submit" name="submit">
                    <h2>If everything you enter is correct just click Submit</h2>
                    <button class="btn btn-success btn-large" style="width: 300px" type="submit"> Submit </button>

                    <div style="display: none;">
                        <input name="url" value="<%= url%>">
                        <input name="title" value="<%= title%>">
                        <input name="loctype" value="<%=loctype%>">
                        <input name="lat" value="<%= lat%>">
                        <input name="lng" value="<%= lng%>">
                        <input name="radius" value="<%= radius%>">
                        <input name="indirizzo" value="<%= indirizzo%>">
                        <input name="description_loc" value="<%=description_loc%>">
                        <input name="datetype" value="<%=datetype%>">
                        <input name="date" value="<%=date%>"/>
                        <input name="decade" value="<%= decade%>">
                        <input name="year" value="<%= year%>">
                        <input name="season" value="<%= season%>">
                        <input name="month" value="<%= month%>">
                        <input name="day" value="<%= day%>">
                        <input name="day_name" value="<%= day_name%>">
                        <input name="day_part" value="<%= day_part%>">
                        <input name="hour" value="<%=hour%>">
                        <input name="minute" value="<%=minute%>">
                        <input name="second" value="<%=second%>"/>
                        <input name="description_time" value="<%=description_time%>">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>