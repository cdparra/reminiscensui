<%-- 
    Document   : menu
    Created on : 10-ott-2012, 17.14.51
    Author     : francesco
--%>


<%
    if (session.getAttribute("user_name") == null) {
        response.sendRedirect("index.jsp");
    }
%>

<%@page errorPage="errorPage.jsp"%>
<%@page import="crowdMemories.Media"%>
<%@page import="crowdMemories.Fuzzy_date"%>
<%@page import="crowdMemories.Location" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

//<jsp:useBean id="media" scope="session" class="crowdMemories.Media"/>
//<jsp:useBean id="location" scope="session" class="crowdMemories.Location"/>
//<jsp:useBean id="date" scope="session" class="crowdMemories.Fuzzy_date"/>

    try {

        String name = request.getParameter("submit");
        session.setAttribute("date", new Fuzzy_date());

        if (name.equals("yes")) {

            Fuzzy_date date = new Fuzzy_date();

            date.setType_of_date("yes");
            date.setDate(request.getParameter("datepicker"));

            session.setAttribute("date", date);

        } else if (name.equals("almost")) {

            Fuzzy_date date = new Fuzzy_date();

            date.setType_of_date("almost");
            date.setDecade(request.getParameter("decade"));
            date.setYear(request.getParameter("year"));
            date.setMonth(request.getParameter("month"));
            date.setDay(request.getParameter("day"));
            date.setDay_name(request.getParameter("day_name"));
            date.setDay_part(request.getParameter("day_part"));
            date.setSeason(request.getParameter("season"));
            date.setHour(request.getParameter("hour"));
            date.setMinute(request.getParameter("minute"));
            date.setSecond(request.getParameter("second"));

            session.setAttribute("date", date);

        } else if (name.equals("no")) {

            Fuzzy_date date = new Fuzzy_date();

            date.setType_of_date("no");
            date.setDescription_time(request.getParameter("description"));

            session.setAttribute("date", date);
        }
        //quando ci sarà anche event
        // } else if (name.equals("event")) {
        //   date.setType_of_date("event"); 
    } catch (Exception e) {
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
        <script src="menuMap.js"></script>

        <style type="text/css">
            #image { 
                display: block;
                margin-left: auto;
                margin-right: auto;
                max-height: 500px; 
                max-width: 750px
                    /* margin-top: 60px; */
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

                    <h2 style="text-align: center"><jsp:getProperty name='media' property='title'/></h2>
                    <img id="image" src="<jsp:getProperty name='media' property='url'/>"  class="img-rounded">

                    <h1 style="margin-top: 50px;">Location</h1>

                    <%
                        if (((Location) session.getAttribute("location")).getHas_marker()) {
                    %>
                    <div style="display: none">
                        <input id="lat" value="<jsp:getProperty name='location' property='latitude'/>"/>
                        <input id="lng" value="<jsp:getProperty name='location' property='longitude'/>"/>
                    </div>
                    <a class="btn btn-primary btn-large pull-right" href="mappacerchio.jsp" style="margin-top: 50px"> Edit the location</a>
                    <div class="span2" style="margin-top: 100px">
                        <p style="text-align: center"><jsp:getProperty name="location" property="address"/></p>
                    </div>
                    <div id="map_canvas"></div>

                    <script type="text/javascript">
                        loadScriptMapMarker();
                    </script>

                    <%                                } else if (((Location) session.getAttribute("location")).getHas_circle()) {
                    %>
                    <div style="display: none">
                        <input id="lat" value="<jsp:getProperty name='location' property='latitude'/>"/>
                        <input id="lng" value="<jsp:getProperty name='location' property='longitude'/>"/>
                        <input id="radius" value="<jsp:getProperty name='location' property='radius'/>"/>
                    </div>
                    <a class="btn btn-primary btn-large pull-right" href="mappacerchio.jsp" style="margin-top: 50px"> Edit the location</a>

                    <div id="map_canvas"></div>

                    <script type="text/javascript">
                        loadScriptMapCircle();
                    </script>

                    <%                                } else if (((Location) session.getAttribute("location")).getHas_description_loc()) {
                    %>

                    <div>
                        <a class="btn btn-primary btn-large pull-right" href="mappacerchio.jsp" > Edit the location</a>
                        <h3 >Here is your text description</h3>
                        <p ><jsp:getProperty name="location" property="location_textual"/></p>
                    </div>

                    <%                                } else {
                    %>

                    <div id="loc-not">
                        <a class="btn btn-primary btn-large pull-right" href="mappacerchio.jsp" > Add a location for your photo</a>
                        <p>You don't enter a location! Click the button and add it</p>
                    </div>

                    <%                                }
                    %>

                    <h1>Date</h1>

                    <%
                        if (((Fuzzy_date) session.getAttribute("date")).getType_of_date().equals("none")) {
                    %>

                    <div id="loc-not">
                        <a class="btn btn-primary btn-large pull-right" href="date.jsp" >Add photo's date</a>
                        <p>You don't enter a date! Click the button and add it</p>
                    </div>

                    <%                    } else if (((Fuzzy_date) session.getAttribute("date")).getType_of_date().equals("yes")) {
                    %>

                    <div style="display: none">
                        <input id="date" value="<jsp:getProperty name='date' property='date'/>"/>
                    </div>

                    <div style="margin-top: 30px;">
                        <a class="btn btn-primary btn-large pull-right" href="date.jsp" >Edit photo's date</a>
                        <p><jsp:getProperty name='date' property='date'/></p>
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
                    <%                                } else if (((Fuzzy_date) session.getAttribute("date")).getType_of_date().equals("no")) {
                    %>

                    <div>
                        <a class="btn btn-primary btn-large pull-right" href="date.jsp" >Edit photo's date</a>
                        <h3>Here is your date description</h3>
                        <p><jsp:getProperty name="date" property="description_time"/></p>
                    </div>

                    <%                                } else if (((Fuzzy_date) session.getAttribute("date")).getType_of_date().equals("almost")) {
                    %>
                    <div>
                        <a class="btn btn-primary btn-large pull-right" href="date.jsp" >Edit photo's date</a>
                        <table class="table" style="width: 400px; text-align: center">
                            <%
                                if (!(((Fuzzy_date) session.getAttribute("date")).getDecade() == null)) {
                            %>
                            <tr>
                                <td><p>Decade:</p> </td>
                                <td><p><jsp:getProperty name="date" property="decade"/></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(((Fuzzy_date) session.getAttribute("date")).getYear() == null)) {
                            %>
                            <tr>
                                <td><p>Year:</p> </td>
                                <td><p><jsp:getProperty name="date" property="year"/></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(((Fuzzy_date) session.getAttribute("date")).getSeason() == null)) {
                            %>
                            <tr>
                                <td><p>Season:</p> </td>
                                <td><p><jsp:getProperty name="date" property="season"/></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(((Fuzzy_date) session.getAttribute("date")).getMonth() == null)) {
                            %>
                            <tr>
                                <td><p>Month:</p> </td>
                                <td><p><jsp:getProperty name="date" property="month"/></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(((Fuzzy_date) session.getAttribute("date")).getDay() == null)) {
                            %>
                            <tr>
                                <td><p>Day:</p> </td>
                                <td><p><jsp:getProperty name="date" property="day"/></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(((Fuzzy_date) session.getAttribute("date")).getDay_name() == null)) {
                            %>
                            <tr>
                                <td><p>Day Name:</p> </td>
                                <td><p><jsp:getProperty name="date" property="day_name"/></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(((Fuzzy_date) session.getAttribute("date")).getDay_part() == null)) {
                            %>
                            <tr>
                                <td><p>Day Part:</p> </td>
                                <td><p><jsp:getProperty name="date" property="day_part"/></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(((Fuzzy_date) session.getAttribute("date")).getHour() == null)) {
                            %>
                            <tr>
                                <td><p>hour:</p> </td>
                                <td><p><jsp:getProperty name="date" property="hour"/></p></td>                            
                            </tr>

                            <%                                            }
                                if (!(((Fuzzy_date) session.getAttribute("date")).getMinute() == null)) {
                            %>
                            <tr>
                                <td><p>minute:</p> </td>
                                <td><p><jsp:getProperty name="date" property="minute"/></p></td>                            
                            </tr>
                            <%                                            }
                                if (!(((Fuzzy_date) session.getAttribute("date")).getSecond() == null)) {
                            %>
                            <tr>
                                <td><p>second:</p> </td>
                                <td><p><jsp:getProperty name="date" property="second"/></p></td>                            
                            </tr>
                            <%                                           }

                            %>
                        </table>
                    </div>
                    <%                                }

                    %>
                </div>

            </div>
            <div class="hero-unit" style="margin-top: 100px; width: 823px; margin-left: auto; margin-right: auto;text-align: center;"> 
                <form action="Submit" name="submit">
                    <h2>If everything you enter is correct just click Submit</h2>
                    <button class="btn btn-success btn-large" style="width: 300px" type="submit"> Submit </button>
                </form>
            </div>
        </div>

        <table class="table" style="margin-top: 200px">
            <thead>
            <th>name</th>
            <th>details</th>
        </thead>
        <tr>
            <td>
                url
            </td>
            <td>
                <%
                    out.println(((Media) session.getAttribute("media")).getUrl());
                %>
            </td>
        </tr>
        <tr>
            <td>
                title
            </td>
            <td>
                <%
                    out.println(((Media) session.getAttribute("media")).getTitle());
                %>
            </td>
        </tr>
        <tr>
            <td>
                has location
            </td>
            <td>
                <%
                    out.println(((Location) session.getAttribute("location")).getHas_location());
                %>
            </td>
        </tr>
        <tr>
            <td>
                address
            </td>
            <td>
                <%
                    out.println(((Location) session.getAttribute("location")).getAddress());
                %>
            </td>
        </tr>
        <tr>
            <td>
                latitude
            </td>
            <td>
                <%
                    out.println(((Location) session.getAttribute("location")).getLatitude());
                %>
            </td>
        </tr>
        <tr>
            <td>
                longitude
            </td>
            <td>
                <%
                    out.println(((Location) session.getAttribute("location")).getLongitude());
                %>
            </td>
        </tr>
        <tr>
            <td>
                radius
            </td>
            <td>
                <%
                    out.println(((Location) session.getAttribute("location")).getRadius());
                %>
            </td>
        </tr>
        <tr>
            <td>
                location description boolean
            </td>
            <td>
                <%
                    out.println(((Location) session.getAttribute("location")).getHas_description_loc());
                %>
            </td>
        </tr>
        <tr>
            <td>
                location description text
            </td>
            <td>
                <%
                    out.println(((Location) session.getAttribute("location")).getLocation_textual());
                %>
            </td>
        </tr>
        <tr>
            <td>
                date
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getDate());
                %>
            </td>
        </tr>
        <tr>
            <td>
                exact-date
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getExact_date());
                %>
            </td>
        </tr>
        <tr>
            <td>
                decade
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getDecade());
                %>
            </td>
        </tr>
        <tr>
            <td>
                year
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getYear());
                %>
            </td>
        </tr>
        <tr>
            <td>
                season
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getSeason());
                %>
            </td>
        </tr>
        <tr>
            <td>
                day
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getDay());
                %>
            </td>
        </tr>
        <tr>
            <td>
                dayname
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getDay_name());
                %>
            </td>
        </tr>
        <tr>
            <td>
                day part
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getDay_part());
                %>
            </td>
        </tr>
        <tr>
            <td>
                hour
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getHour());
                %>
            </td>
        </tr>
        <tr>
            <td>
                min
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getMinute());
                %>
            </td>
        </tr>
        <tr>
            <td>
                sec
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getSecond());
                %>
            </td>
        </tr>
        <tr>
            <td>
                time description
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getDescription_time());
                %>
            </td>
        </tr>
        <tr>
            <td>
                has marker
            </td>
            <td>
                <%
                    out.println(((Location) session.getAttribute("location")).getHas_marker());
                %>
            </td>
        </tr>
        <tr>
            <td>
                has circle
            </td>
            <td>
                <%
                    out.println(((Location) session.getAttribute("location")).getHas_circle());
                %>
            </td>
        </tr>
        <tr>
            <td>
                type of date
            </td>
            <td>
                <%
                    out.println(((Fuzzy_date) session.getAttribute("date")).getType_of_date());
                %>
            </td>
        </tr>
    </table>
</body>
</html>
