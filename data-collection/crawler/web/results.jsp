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
    String startDate = request.getParameter("date");
    System.out.println(startDate);

    Connection connection = DriverManager.getConnection(
            DB_NAME, DB_USER, DB_PASSWORD);

    Statement st = connection.createStatement();
    ResultSet rs = null;
    if (type.equals("Location") || type.equals("Person")) {
        rs = st.executeQuery("SELECT * FROM reminiscens." + type + ";");
    } else if (type.equals("Time_Interval")) {
        rs = st.executeQuery("SELECT * FROM reminiscens." + type + " WHERE startdate > '" + startDate + "' ;");
    } else if (type.equals("Fuzzy_Date")) {
        rs = st.executeQuery("SELECT * FROM reminiscens." + type + " WHERE exact_date > '" + startDate + "' ;");
    } else {
        rs = st.executeQuery("SELECT * FROM reminiscens." + type + " ta JOIN Time_Interval t ON ta.time_interval_id=t.time_interval_id WHERE t.startdate > '" + startDate + "' ;");
    }
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
                <label>Nell'ambito della ricerca in Location e Person, la data non viene presa in considerazione</label>
                <select name="type">
                    <option value="Media">Media</option>
                    <option value="Event">Events</option>
                    <option value="Person">People</option>
                    <option value="Time_Interval">Time Intervals</option>
                    <option value="Fuzzy_Date">Fuzzy Dates</option>
                    <option value="Location">Locations</option>
                    <option value="Media_Metadata">Media_Metadata</option>
                </select><br>
                <label>Start_date</label><input type="date" name="date"><br>
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
                            String media_id;
                            String media_url;
                            String media_type;
                            String caption;
                            String text;
                            String source;
                            String source_url;
                            String last_update;
                            String is_public;
                            String location;
                            String interval;
                            String locale;
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
                                <th>LOCALE</th>
                            </tr>
                        </thead>
                        <tbody>                          
                            <%
                                while (rs.next()) {

                                    media_id = rs.getString("media_id");
                                    media_url = rs.getString("media_url");
                                    media_type = rs.getString("media_type");
                                    caption = rs.getString("caption");
                                    text = rs.getString("text");
                                    source = rs.getString("source");
                                    source_url = rs.getString("source_url");
                                    last_update = rs.getString("last_update");
                                    is_public = rs.getString("is_public");
                                    location = rs.getString("location_id");
                                    interval = rs.getString("time_interval_id");
                                    locale = rs.getString("locale");
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
                                <td> <%= locale%> </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                    } else if (type.equals("Event")) {
                        String event_id;
                        String headline;
                        String text;
                        String event_type;
                        String source;
                        String source_url;
                        String last_update;
                        String location;
                        String interval;
                        String locale;
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
                                <th>LOCALE</th>
                            </tr>
                        </thead>
                        <tbody>                          
                            <%
                                while (rs.next()) {

                                    event_id = rs.getString("event_id");
                                    headline = rs.getString("headline");
                                    text = rs.getString("text");
                                    event_type = rs.getString("type");
                                    source = rs.getString("source");
                                    source_url = rs.getString("source_url");
                                    last_update = rs.getString("last_update");
                                    location = rs.getString("location_id");
                                    interval = rs.getString("time_interval_id");
                                    locale = rs.getString("locale");
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
                                <td> <%= locale%> </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                    } else if (type.equals("Person")) {
                        String person_id;
                        String user_id;
                        String nickname;
                        String email;
                        String user_type;
                        String lang;
                        String pass;
                        String fullname;
                        String firstname;
                        String middlename;
                        String lastname;
                        String famous;
                        String famous_for;
                        String status;
                        String creator_type;
                        String source;
                        String source_url;
                        String last_update;
                        String locale;
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
                                <th>LOCALE</th>
                            </tr>
                        </thead>
                        <tbody>                          
                            <%
                                while (rs.next()) {

                                    person_id = rs.getString("person_id");
                                    user_id = rs.getString("user_id");
                                    nickname = rs.getString("user_nickname");
                                    email = rs.getString("user_email");
                                    user_type = rs.getString("user_type");
                                    lang = rs.getString("user_lang");
                                    pass = rs.getString("user_password");
                                    fullname = rs.getString("fullname");
                                    firstname = rs.getString("firstname");
                                    middlename = rs.getString("middlename");
                                    lastname = rs.getString("lastname");
                                    famous = rs.getString("famous");
                                    famous_for = rs.getString("famous_for");
                                    status = rs.getString("status");
                                    creator_type = rs.getString("creator_type");
                                    source = rs.getString("source");
                                    source_url = rs.getString("source_url");
                                    last_update = rs.getString("last_update");
                                    locale = rs.getString("locale");
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
                                <td> <%= locale%> </td>
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
                                <th>REGION</th>
                                <th>CITY</th>
                                <th>NEIGHBORHOOD</th>
                                <th>STREET</th>
                                <th>STREET_NUMBER</th>
                                <th>MAP_URL</th>
                                <th>COORDINATES_TRUST</th>
                                <th>TYPE</th>
                                <th>LAT</th>
                                <th>LON</th>
                                <th>LOCALE</th>
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
                                    String region = rs.getString("region");
                                    String city = rs.getString("city");
                                    String neighborhood = rs.getString("neighborhood");
                                    String street = rs.getString("street");
                                    String street_number = rs.getString("street_number");
                                    String map_url = rs.getString("map_url");
                                    String coordinates_trust = rs.getString("coordinates_trust");
                                    String location_type_id = rs.getString("location_type_id");
                                    String lat = rs.getString("lat");
                                    String lon = rs.getString("lon");
                                    String locale = rs.getString("locale");
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
                                <td> <%= region%> </td>
                                <td> <%= city%> </td>
                                <td> <%= neighborhood%> </td>
                                <td> <%= street%> </td>
                                <td> <%= street_number%> </td>
                                <td> <%= map_url%> </td>
                                <td> <%= coordinates_trust%> </td>
                                <td> <%= location_type_id%> </td>
                                <td> <%= lat%> </td>
                                <td> <%= lon%> </td>
                                <td> <%= locale%> </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                    } else if (type.equals("Time_Interval")) {

                        String time_interval_id;
                        String unit;
                        String amount;
                        String startdate;
                        String enddate;
                        String fuzzy;
                        String fuzzy_start;
                        String fuzzy_end;
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

                                    time_interval_id = rs.getString("time_interval_id");
                                    unit = rs.getString("duration_unit");
                                    amount = rs.getString("duration_amount");
                                    startdate = rs.getString("startdate");
                                    enddate = rs.getString("enddate");
                                    fuzzy = rs.getString("is_fuzzy");
                                    fuzzy_start = rs.getString("fuzzy_startdate");
                                    fuzzy_end = rs.getString("fuzzy_enddate");
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

                        String fuzzy_date_id;
                        String textual;
                        String exact_date;
                        String decade;
                        String year;
                        String season;
                        String month;
                        String day;
                        String day_name;
                        String day_part;
                        String hour;
                        String minute;
                        String second;
                        String accuracy;
                        String locale;
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
                                <th>LOCALE</th>
                            </tr>
                        </thead>
                        <tbody>                          
                            <%
                                while (rs.next()) {

                                    fuzzy_date_id = rs.getString("fuzzy_date_id");
                                    textual = rs.getString("textual_date");
                                    exact_date = rs.getString("exact_date");
                                    decade = rs.getString("decade");
                                    year = rs.getString("year");
                                    season = rs.getString("season");
                                    month = rs.getString("month");
                                    day = rs.getString("day");
                                    day_name = rs.getString("day_name");
                                    day_part = rs.getString("day_part");
                                    hour = rs.getString("hour");
                                    minute = rs.getString("minute");
                                    second = rs.getString("second");
                                    accuracy = rs.getString("accuracy");
                                    locale = rs.getString("locale");
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
                                <td> <%= locale%> </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                    } else if (type.equals("Media_Metadata")) {
                        String media_metadata_id;
                        String title;
                        String description;
                        String md_type;
                        String source;
                        String source_url;
                        String relDate;
                        String locale;
                    %>
                    <div><h4>Media_Metadata</h4></div>    
                    <table class="table table-hover" style="margin: auto">
                        <thead>
                            <tr>
                                <th>ID</th>                           
                                <th>TITLE</th>
                                <th>DESCRIPTION</th>
                                <th>TYPE</th>
                                <th>SOURCE</th>
                                <th>SOURCE URL</th>
                                <th>RELEASE DATE</th>
                                <th>LOCALE</th>
                            </tr>
                        </thead>
                        <tbody>                          
                            <%
                                while (rs.next()) {

                                    media_metadata_id = rs.getString("media_metadata_id");
                                    title = rs.getString("title");
                                    description = rs.getString("description");
                                    md_type = rs.getString("type");
                                    source = rs.getString("source");
                                    source_url = rs.getString("source_url");
                                    relDate = rs.getString("releasedate");
                                    locale = rs.getString("locale");
                            %>
                            <tr>
                                <td> <%= media_metadata_id%> </td>
                                <td> <%= title%> </td>
                                <td> <%= description%> </td>
                                <td> <%= md_type%> </td>
                                <td> <%= source%> </td>
                                <td> <%= source_url%> </td>
                                <td> <%= relDate%> </td>
                                <td> <%= locale%> </td>
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

