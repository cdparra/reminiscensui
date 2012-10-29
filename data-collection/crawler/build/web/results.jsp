<%-- 
    Document   : results
    Created on : 21-ott-2012, 19.57.21
    Author     : Nicola.Parrello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver");%>

<%
    final String DB_USER = "reminiscens";
    final String DB_NAME = "jdbc:mysql://test.lifeparticipation.org:3306/reminiscens";
    final String DB_PASSWORD = "timeline@lp2012";
    String type = request.getParameter("type");
    Connection connection = DriverManager.getConnection(
            DB_NAME, DB_USER, DB_PASSWORD);

    Statement statement = connection.createStatement();
    ResultSet rs =
            statement.executeQuery("SELECT * FROM reminiscens." + type + ";");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Reminiscens Data Viewer</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" media="handheld, screen">
    </head>
    <body>
        <div class="title" style="text-align: center"><h1>Reminiscens Data Viewer</h1></div>
        <div style="text-align: center">
            <form name="data_selector" method="post" action="results.jsp" style="display: block">
                <select name="type">
                    <option value="Media">Media</option>
                    <option value="Event">Events</option>
                    <option value="Person">People</option>
                    <option value="Time_Interval">Time Intervals</option>
                    <option value="Fuzzy_Date">Fuzzy Dates</option>
                    <option value="Location">Locations</option>
                </select><br>
                <button class="btn btn-primary" type="submit" value="go">Go</button>
            </form>
        </div>
        <div class="row">
            <div class="span1">
            </div>
            <div class="span12" >
                <div>
                    <%
                        if (type.equals("Media")) {
                    %>
                    <div><h4>Media</h4></div>                       
                    <table class="table table-hover" style="margin: auto">
                        <thead>
                            <tr>
                                <th>ID</th>                           
                                <th>URL</th>
                                <th>TYPE</th>
                                <th>CAPTION</th>
                                <th>TEXT</th>
                                <th>SOURCE</th>
                                <th>SOURCE URL</th>
                                <th>LAST UPDATE</th>
                                <th>PUBLIC</th>
                                <th>LOCATION</th>
                                <th>TIME INTERVAL</th>
                            </tr>
                        </thead>
                        <tbody>                          
                            <%
                                while (rs.next()) {

                                    String media_id = rs.getString("media_id");
                                    String media_url = rs.getString("media_url");
                                    String media_type = rs.getString("media_type");
                                    String caption = rs.getString("caption");
                                    String text = rs.getString("text");
                                    String source = rs.getString("source");
                                    String source_url = rs.getString("source_url");
                                    String last_update = rs.getString("last_update");
                                    String is_public = rs.getString("is_public");
                                    String location = rs.getString("location_id");
                                    String interval = rs.getString("time_interval_id");
                            %>
                            <tr>
                                <td> <%= media_id%> </td>
                                <td> <%= media_url%> </td>
                                <td> <%= media_type%> </td>
                                <td> <%= caption%> </td>
                                <td> <%= text%> </td>
                                <td> <%= source%> </td>
                                <td> <%= source_url%> </td>
                                <td> <%= last_update%> </td>
                                <td> <%= is_public%> </td>
                                <td> <%= location%> </td>
                                <td> <%= interval%> </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                    } else if (type.equals("Event")) {
                    %>
                    <div><h4>Event</h4></div>    
                    <table class="table table-hover" style="margin: auto">
                        <thead>
                            <tr>
                                <th>ID</th>                           
                                <th>HEADLINE</th>
                                <th>TEXT</th>
                                <th>TYPE</th>
                                <th>SOURCE</th>
                                <th>SOURCE URL</th>
                                <th>LAST UPDATE</th>
                                <th>LOCATION</th>
                                <th>TIME INTERVAL</th>
                            </tr>
                        </thead>
                        <tbody>                          
                            <%
                                while (rs.next()) {

                                    String event_id = rs.getString("event_id");
                                    String headline = rs.getString("headline");
                                    String text = rs.getString("text");
                                    String event_type = rs.getString("type");
                                    String source = rs.getString("source");
                                    String source_url = rs.getString("source_url");
                                    String last_update = rs.getString("last_update");
                                    String location = rs.getString("location_id");
                                    String interval = rs.getString("time_interval_id");
                            %>
                            <tr>
                                <td> <%= event_id%> </td>
                                <td> <%= headline%> </td>
                                <td> <%= text%> </td>
                                <td> <%= event_type%> </td>
                                <td> <%= source%> </td>
                                <td> <%= source_url%> </td>
                                <td> <%= last_update%> </td>
                                <td> <%= location%> </td>
                                <td> <%= interval%> </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                    } else if (type.equals("Person")) {
                    %>
                    <div><h4>Person</h4></div>    
                    <table class="table table-hover" style="margin: auto">
                        <thead>
                            <tr>
                                <th>ID</th>                           
                                <th>USER ID</th>
                                <th>USERNAME</th>
                                <th>EMAIL</th>
                                <th>TYPE</th>
                                <th>LANG</th>
                                <th>PASSWORD</th>
                                <th>FULLNAME</th>
                                <th>FIRSTNAME</th>
                                <th>MIDDLENAME</th>
                                <th>LASTNAME</th>
                                <th>FAMOUS</th>
                                <th>FAMOUS FOR</th>
                                <th>STATUS</th>
                                <th>CREATOR TYPE</th>
                                <th>SOURCE</th>
                                <th>SOURCE URL</th>                           
                                <th>LAST UPDATE</th>
                            </tr>
                        </thead>
                        <tbody>                          
                            <%
                                while (rs.next()) {

                                    String person_id = rs.getString("person_id");
                                    String user_id = rs.getString("user_id");
                                    String nickname = rs.getString("user_nickname");
                                    String email = rs.getString("user_email");
                                    String user_type = rs.getString("user_type");
                                    String lang = rs.getString("user_lang");
                                    String pass = rs.getString("user_password");
                                    String fullname = rs.getString("fullname");
                                    String firstname = rs.getString("firstname");
                                    String middlename = rs.getString("middlename");
                                    String lastname = rs.getString("lastname");
                                    String famous = rs.getString("famous");
                                    String famous_for = rs.getString("famous_for");
                                    String status = rs.getString("status");
                                    String creator_type = rs.getString("creator_type");
                                    String source = rs.getString("source");
                                    String source_url = rs.getString("source_url");
                                    String last_update = rs.getString("last_update");
                            %>
                            <tr>
                                <td> <%= person_id%> </td>
                                <td> <%= user_id%> </td>
                                <td> <%= nickname%> </td>
                                <td> <%= email%> </td>
                                <td> <%= user_type%> </td>
                                <td> <%= lang%> </td>
                                <td> <%= pass%> </td>
                                <td> <%= fullname%> </td>
                                <td> <%= firstname%> </td>
                                <td> <%= middlename%> </td>
                                <td> <%= lastname%> </td>
                                <td> <%= famous%> </td>
                                <td> <%= famous_for%> </td>
                                <td> <%= status%> </td>
                                <td> <%= creator_type%> </td>
                                <td> <%= source%> </td>
                                <td> <%= source_url%> </td>
                                <td> <%= last_update%> </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                    } else if (type.equals("Location")) {
                    %>
                    <div><h4>Location</h4></div>    
                    <table class="table table-hover" style="margin: auto">
                        <thead>
                            <tr>
                                <th>ID</th>                           
                                <th>TEXTUAL</th>
                                <th>ACCURACY</th>
                                <th>NAME</th>
                                <th>DESCRIPTION</th>
                                <th>ENVIRONMENT</th>
                                <th>CONTINENT</th>
                                <th>COUNTRY</th>
                                <th>CITY</th>
                                <th>NEIGHBORHOOD</th>
                                <th>TYPE</th>
                                <th>LAT</th>
                                <th>LON</th>
                            </tr>
                        </thead>
                        <tbody>                          
                            <%
                                while (rs.next()) {

                                    String location_id = rs.getString("location_id");
                                    String textual = rs.getString("location_textual");
                                    String accuracy = rs.getString("accuracy");
                                    String name = rs.getString("name");
                                    String description = rs.getString("description");
                                    String environment = rs.getString("environment");
                                    String continent = rs.getString("continent");
                                    String country = rs.getString("country");
                                    String city = rs.getString("city");
                                    String neighborhood = rs.getString("neighborhood");
                                    String location_type_id = rs.getString("location_type_id");
                                    String lat = rs.getString("lat");
                                    String lon = rs.getString("lon");
                            %>
                            <tr>
                                <td> <%= location_id%> </td>
                                <td> <%= textual%> </td>
                                <td> <%= accuracy%> </td>
                                <td> <%= name%> </td>
                                <td> <%= description%> </td>
                                <td> <%= environment%> </td>
                                <td> <%= continent%> </td>
                                <td> <%= country%> </td>
                                <td> <%= city%> </td>
                                <td> <%= neighborhood%> </td>
                                <td> <%= location_type_id%> </td>
                                <td> <%= lat%> </td>
                                <td> <%= lon%> </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                    } else if (type.equals("Time_Interval")) {
                    %>
                    <div><h4>Time_Interval</h4></div>    
                    <table class="table table-hover" style="margin: auto">
                        <thead>
                            <tr>
                                <th>ID</th>                           
                                <th>UNIT</th>
                                <th>AMOUNT</th>
                                <th>START</th>
                                <th>END</th>
                                <th>IS FUZZY</th>
                                <th>FUZZY START</th>
                                <th>FUZZY END</th>
                            </tr>
                        </thead>
                        <tbody>                          
                            <%
                                while (rs.next()) {

                                    String time_interval_id = rs.getString("time_interval_id");
                                    String unit = rs.getString("duration_unit");
                                    String amount = rs.getString("duration_amount");
                                    String startdate = rs.getString("startdate");
                                    String enddate = rs.getString("enddate");
                                    String fuzzy = rs.getString("is_fuzzy");
                                    String fuzzy_start = rs.getString("fuzzy_startdate");
                                    String fuzzy_end = rs.getString("fuzzy_enddate");
                            %>
                            <tr>
                                <td> <%= time_interval_id%> </td>
                                <td> <%= unit%> </td>
                                <td> <%= amount%> </td>
                                <td> <%= startdate%> </td>
                                <td> <%= enddate%> </td>
                                <td> <%= fuzzy%> </td>
                                <td> <%= fuzzy_start%> </td>
                                <td> <%= fuzzy_end%> </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                    } else if (type.equals("Fuzzy_Date")) {
                    %>
                    <div><h4>Fuzzy_Date</h4></div>    
                    <table class="table table-hover" style="margin: auto">
                        <thead>
                            <tr>
                                <th>ID</th>                           
                                <th>TEXTUAL</th>
                                <th>EXACT DATE</th>
                                <th>DECADE</th>
                                <th>YEAR</th>
                                <th>SEASON</th>
                                <th>MONTH</th>
                                <th>DAY</th>
                                <th>DAY NAME</th>
                                <th>DAY PART</th>
                                <th>HOUR</th>
                                <th>MINUTE</th>
                                <th>SECOND</th>
                                <th>ACCURACY</th>
                            </tr>
                        </thead>
                        <tbody>                          
                            <%
                                while (rs.next()) {

                                    String fuzzy_date_id = rs.getString("fuzzy_date_id");
                                    String textual = rs.getString("textual_date");
                                    String exact_date = rs.getString("exact_date");
                                    String decade = rs.getString("decade");
                                    String year = rs.getString("year");
                                    String season = rs.getString("season");
                                    String month = rs.getString("month");
                                    String day = rs.getString("day");
                                    String day_name = rs.getString("day_name");
                                    String day_part = rs.getString("day_part");
                                    String hour = rs.getString("hour");
                                    String minute = rs.getString("minute");
                                    String second = rs.getString("second");
                                    String accuracy = rs.getString("accuracy");
                            %>
                            <tr>
                                <td> <%= fuzzy_date_id%> </td>
                                <td> <%= textual%> </td>
                                <td> <%= exact_date%> </td>
                                <td> <%= decade%> </td>
                                <td> <%= year%> </td>
                                <td> <%= season%> </td>
                                <td> <%= month%> </td>
                                <td> <%= day%> </td>
                                <td> <%= day_name%> </td>
                                <td> <%= day_part%> </td>
                                <td> <%= hour%> </td>
                                <td> <%= minute%> </td>
                                <td> <%= second%> </td>
                                <td> <%= accuracy%> </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                        }
                    %>
                </div>
            </div>
            <div class="span1">
            </div>
        </div>
    </body>
</html>

