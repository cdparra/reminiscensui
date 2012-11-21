<%-- 
    Document   : date
    Created on : 10-ott-2012, 17.37.11
    Author     : francesco
--%>

<%@page import="crowdMemories.Location"%>
<%@page errorPage="errorPage.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    String url = request.getParameter("url");
    String title = request.getParameter("title");
    String button = request.getParameter("submit");
    String lat = null;
    String lng = null;
    String radius = null;
    String indirizzo = null;
    String description = null;

    if (button.equals("map")) {

        lat = request.getParameter("lat");
        lng = request.getParameter("lng");
        radius = request.getParameter("radius");
        indirizzo = request.getParameter("indirizzo");

    } else if (button.equals("text")) {

        description = request.getParameter("description");
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Date Page</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <link href="jquery-ui-1.9.0.custom/css/smoothness/jquery-ui-1.9.0.custom.min.css" rel="stylesheet"/>

        <script src="bootstrap/js/jquery-1.8.2.min.js"></script>
        <script src="jquery-ui-1.9.0.custom/js/jquery-ui-1.9.0.custom.min.js"></script>
        <script src="date.js"></script>

        <style type="text/css">
            #yesdiv{
                display: none
            }
            #almostdiv{
                display: none
            }
            #eventdiv{
                display: none
            }
            #nodiv{
                display: none
            }
            #description{
                resize: none;
                margin-left: auto;
                margin-right: auto;
                width: 700px;
                height: 100px
            }
            .span5 form {
                margin: 0 0 0px;
            }

            #sfondo { 
                width: 940px;
                margin-top: 40px;
                margin-left: auto;
                margin-right: auto;
            }
            #image { 
                display: block;
                margin-left: auto;
                margin-right: auto;
                max-height: 500px; 
                max-width: 750px;
                margin-bottom: 40px;
                margin-top: 40px
            }
        </style>
        <script type="text/javascript">
            function check(input){
                var num = input.value;
                if(isNaN(num)){
                    alert("Please enter a number!");   
                    input.value = null;
                }  
            }
        </script>
    </head>
    <body>
        <div class="container">
            <div id="sfondo" class="hero-unit">
                <form method="get" action="menu.jsp">
                    <button class="btn btn-mini pull-right" type="submit" name="submit" value="skip"> Skip this <i class="icon-forward"></i></button>
                    <div style="display: none;">
                        <input name="url" value="<%= url%>">
                        <input name="title" value="<%= title%>">
                        <input name="lat" value="<%= lat%>">
                        <input name="lng" value="<%= lng%>">
                        <input name="radius" value="<%= radius%>">
                        <input name="indirizzo" value="<%= indirizzo%>">
                        <input name="description" value="<%= description%>">
                        <input name="loctype" value="<%=button%>">
                    </div>
                </form>
                <h1>Do you remember the date?</h1>

                <img id="image" src="<%=url%>"  class="img-rounded">

                <div style="margin-top: 15px">

                    <button id="yes" class="btn btn-large btn-success btn-block">Yes, sure!</button>

                    <div id="yesdiv">
                        <form action="menu.jsp">
                            <button name="submit" value="yes" class="btn btn-success btn-large pull-right" type="submit" style="margin-left: 540px;"> Submit </button>
                            Date: <input name="datepicker" type="text" id="datepicker" placeholder="click here to view calendar" readonly="readonly"/>
                            <%
                                if (button.equals("map")) {
                            %>
                            <div style="display:none">
                                <input name="url" value="<%= url%>">
                                <input name="title" value="<%= title%>">
                                <input name="lat" value="<%= lat%>">
                                <input name="lng" value="<%= lng%>">
                                <input name="radius" value="<%= radius%>">
                                <input name="indirizzo" value="<%= indirizzo%>">
                                <input name="loctype" value="<%=button%>">
                            </div>
                            <%
                            } else if (button.equals("text")) {
                            %>
                            <div style="display:none">
                                <input name="url" value="<%= url%>">
                                <input name="title" value="<%= title%>">
                                <input name="description" value="<%= description%>">
                                <input name="loctype" value="<%=button%>">
                            </div>
                            <%
                            } else if (button.equals("skip")) {
                            %>
                            <div style="display:none">
                                <input name="url" value="<%= url%>">
                                <input name="title" value="<%= title%>">
                                <input name="loctype" value="<%=button%>">
                            </div>
                            <%
                                }
                            %>
                        </form>
                    </div>

                    <button id="almost" class="btn btn-large btn-primary btn-block" >Almost</button>

                    <div id="almostdiv">
                        <form action="menu.jsp">
                            <p style="text-align: center; padding-top: 5px">Just enter what you remember</p>
                            <button name="submit" value="almost" class="btn btn-primary btn-large pull-right" type="submit"> Submit </button>
                            <table>
                                <tr>
                                    <td>
                                        <table class="table">
                                            <tr>
                                                <td><p>Decade:</p></td>
                                                <td><input id="decade" name="decade" type="text" placeholder="1980" value="" onchange="check(this)"/></td>                            
                                            </tr>
                                            <tr>
                                                <td><p>Year:</p></td>
                                                <td><input name="year" type="text" placeholder="1986" value="" onchange="check(this)"/></td>                            
                                            </tr>
                                            <tr>
                                                <td><p>Season:</p> </td>
                                                <td>
                                                    <select name="season">
                                                        <option selected value="">Select Season</option>
                                                        <option value="Winter">Winter</option>
                                                        <option value="Spring">Spring</option>
                                                        <option value="Summer">Summer</option>
                                                        <option value="Autumn">Autumn</option>
                                                    </select>
                                                </td>                            
                                            </tr>
                                            <tr>
                                                <td><p>Month:</p> </td>
                                                <td>
                                                    <select name="month">
                                                        <option selected value="">Select Month</option>
                                                        <option value="01">January</option>
                                                        <option value="02">February</option>
                                                        <option value="03">March</option>
                                                        <option value="04">April</option>
                                                        <option value="05">May</option>
                                                        <option value="06">June</option>
                                                        <option value="07">July</option>
                                                        <option value="08">August</option>
                                                        <option value="09">September</option>
                                                        <option value="10">October</option>
                                                        <option value="11">November</option>
                                                        <option value="12">December</option>
                                                    </select>
                                                </td>                                                                  
                                            </tr>
                                        </table>
                                    </td>
                                    <td>
                                        <table class="table">
                                            <tr>
                                                <td><p>Day:</p> </td>
                                                <td>
                                                    <select name="day">
                                                        <option selected value="">Select Day</option>
                                                        <option value="1">1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                        <option value="6">6</option>
                                                        <option value="7">7</option>
                                                        <option value="8">8</option>
                                                        <option value="9">9</option>
                                                        <option value="10">10</option>
                                                        <option value="11">11</option>
                                                        <option value="12">12</option>
                                                        <option value="13">13</option>
                                                        <option value="14">14</option>
                                                        <option value="15">15</option>
                                                        <option value="16">16</option>
                                                        <option value="17">17</option>
                                                        <option value="18">18</option>
                                                        <option value="19">19</option>
                                                        <option value="20">20</option>
                                                        <option value="21">21</option>
                                                        <option value="22">22</option>
                                                        <option value="23">23</option>
                                                        <option value="24">24</option>
                                                        <option value="25">25</option>
                                                        <option value="26">26</option>
                                                        <option value="27">27</option>
                                                        <option value="28">28</option>
                                                        <option value="29">29</option>
                                                        <option value="30">30</option>
                                                        <option value="31">31</option>
                                                    </select> 
                                                </td>                            
                                            </tr>
                                            <tr>
                                                <td><p>Day Name:</p> </td>
                                                <td>
                                                    <select name="day_name">
                                                        <option selected value="">Select Day Name</option>
                                                        <option value="Monday">Monday</option>
                                                        <option value="Tuesday">Tuesday</option>
                                                        <option value="Wednesday">Wednesday</option>
                                                        <option value="Thursday">Thursday</option>
                                                        <option value="Friday">Friday</option>
                                                        <option value="Saturday">Saturday</option>
                                                        <option value="Sunday">Sunday</option>
                                                    </select>
                                                </td>                     
                                            </tr>
                                            <tr>
                                                <td><p>Day Part:</p></td>
                                                <td>
                                                    <select name="day_part">
                                                        <option selected value="">Select Day Part</option>
                                                        <option value="early morning">Early morning</option>
                                                        <option value="morning">Morning</option>
                                                        <option value="midday">Midday</option>
                                                        <option value="afternoon">Afternoon</option>
                                                        <option value="evening">Evening</option>
                                                        <option value="night">Night</option>
                                                        <option value="midnight">Midnight</option>
                                                        <option value="late night">Late night</option>
                                                    </select>
                                                </td>                            
                                            </tr>
                                            <tr>
                                                <td><p>Time:</p></td>
                                                <td>
                                                    <select name="hour" style="max-width: 70px;">
                                                        <option selected value="">hh</option>
                                                        <option value="00">00</option>
                                                        <option value="01">01</option>
                                                        <option value="02">02</option>
                                                        <option value="03">03</option>
                                                        <option value="04">04</option>
                                                        <option value="05">05</option>
                                                        <option value="06">06</option>
                                                        <option value="07">07</option>
                                                        <option value="08">08</option>
                                                        <option value="09">09</option>
                                                        <option value="10">10</option>
                                                        <option value="11">11</option>
                                                        <option value="12">12</option>
                                                        <option value="13">13</option>
                                                        <option value="14">14</option>
                                                        <option value="15">15</option>
                                                        <option value="16">16</option>
                                                        <option value="17">17</option>
                                                        <option value="18">18</option>
                                                        <option value="19">19</option>
                                                        <option value="20">20</option>
                                                        <option value="21">21</option>
                                                        <option value="22">22</option>
                                                        <option value="23">23</option>
                                                    </select> 
                                                    <select name="minute" style="max-width: 70px;">
                                                        <option selected value="">mm</option>
                                                        <option value="00">00</option>
                                                        <option value="01">01</option>
                                                        <option value="02">02</option>
                                                        <option value="03">03</option>
                                                        <option value="04">04</option>
                                                        <option value="05">05</option>
                                                        <option value="06">06</option>
                                                        <option value="07">07</option>
                                                        <option value="08">08</option>
                                                        <option value="09">09</option>
                                                        <option value="10">10</option>
                                                        <option value="11">11</option>
                                                        <option value="12">12</option>
                                                        <option value="13">13</option>
                                                        <option value="14">14</option>
                                                        <option value="15">15</option>
                                                        <option value="16">16</option>
                                                        <option value="17">17</option>
                                                        <option value="18">18</option>
                                                        <option value="19">19</option>
                                                        <option value="20">20</option>
                                                        <option value="21">21</option>
                                                        <option value="22">22</option>
                                                        <option value="23">23</option>
                                                        <option value="24">24</option>
                                                        <option value="25">25</option>
                                                        <option value="26">26</option>
                                                        <option value="27">27</option>
                                                        <option value="28">28</option>
                                                        <option value="29">29</option>
                                                        <option value="30">30</option>
                                                        <option value="31">31</option>                                                    
                                                        <option value="32">32</option>                                                      
                                                        <option value="33">33</option>
                                                        <option value="34">34</option>
                                                        <option value="35">35</option>
                                                        <option value="36">36</option>
                                                        <option value="37">37</option>
                                                        <option value="38">38</option>
                                                        <option value="39">39</option>
                                                        <option value="40">40</option>
                                                        <option value="41">41</option>
                                                        <option value="42">42</option>
                                                        <option value="43">43</option>
                                                        <option value="44">44</option>
                                                        <option value="45">45</option>
                                                        <option value="46">46</option>
                                                        <option value="47">47</option>
                                                        <option value="48">48</option>
                                                        <option value="49">49</option>
                                                        <option value="50">50</option>
                                                        <option value="51">51</option>
                                                        <option value="52">52</option>
                                                        <option value="53">53</option>
                                                        <option value="54">54</option>
                                                        <option value="55">55</option>
                                                        <option value="56">56</option>
                                                        <option value="57">57</option>
                                                        <option value="58">58</option>
                                                        <option value="59">59</option>
                                                    </select> 
                                                    <select name="second" style="max-width: 70px ">
                                                        <option selected value="">ss</option>
                                                        <option value="00">00</option>
                                                        <option value="01">01</option>
                                                        <option value="02">02</option>
                                                        <option value="03">03</option>
                                                        <option value="04">04</option>
                                                        <option value="05">05</option>
                                                        <option value="06">06</option>
                                                        <option value="07">07</option>
                                                        <option value="08">08</option>
                                                        <option value="09">09</option>
                                                        <option value="10">10</option>
                                                        <option value="11">11</option>
                                                        <option value="12">12</option>
                                                        <option value="13">13</option>
                                                        <option value="14">14</option>
                                                        <option value="15">15</option>
                                                        <option value="16">16</option>
                                                        <option value="17">17</option>
                                                        <option value="18">18</option>
                                                        <option value="19">19</option>
                                                        <option value="20">20</option>
                                                        <option value="21">21</option>
                                                        <option value="22">22</option>
                                                        <option value="23">23</option>
                                                        <option value="24">24</option>
                                                        <option value="25">25</option>
                                                        <option value="26">26</option>
                                                        <option value="27">27</option>
                                                        <option value="28">28</option>
                                                        <option value="29">29</option>
                                                        <option value="30">30</option>
                                                        <option value="31">31</option>                                                    
                                                        <option value="32">32</option>                                                      
                                                        <option value="33">33</option>
                                                        <option value="34">34</option>
                                                        <option value="35">35</option>
                                                        <option value="36">36</option>
                                                        <option value="37">37</option>
                                                        <option value="38">38</option>
                                                        <option value="39">39</option>
                                                        <option value="40">40</option>
                                                        <option value="41">41</option>
                                                        <option value="42">42</option>
                                                        <option value="43">43</option>
                                                        <option value="44">44</option>
                                                        <option value="45">45</option>
                                                        <option value="46">46</option>
                                                        <option value="47">47</option>
                                                        <option value="48">48</option>
                                                        <option value="49">49</option>
                                                        <option value="50">50</option>
                                                        <option value="51">51</option>
                                                        <option value="52">52</option>
                                                        <option value="53">53</option>
                                                        <option value="54">54</option>
                                                        <option value="55">55</option>
                                                        <option value="56">56</option>
                                                        <option value="57">57</option>
                                                        <option value="58">58</option>
                                                        <option value="59">59</option>
                                                    </select> 
                                                                                                    </td>                            
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>  
                            <%
                                if (button.equals("map")) {
                            %>
                            <div style="display:none">
                                <input name="url" value="<%= url%>">
                                <input name="title" value="<%= title%>">
                                <input name="lat" value="<%= lat%>">
                                <input name="lng" value="<%= lng%>">
                                <input name="radius" value="<%= radius%>">
                                <input name="indirizzo" value="<%= indirizzo%>">
                                <input name="loctype" value="<%=button%>">
                            </div>
                            <%
                            } else if (button.equals("text")) {
                            %>
                            <div style="display:none">
                                <input name="url" value="<%= url%>">
                                <input name="title" value="<%= title%>">
                                <input name="description" value="<%= description%>">
                                <input name="loctype" value="<%=button%>">
                            </div>
                             <%
                            } else if (button.equals("skip")) {
                            %>
                            <div style="display:none">
                                <input name="url" value="<%= url%>">
                                <input name="title" value="<%= title%>">
                                <input name="loctype" value="<%=button%>">
                            </div>
                            <%
                                }
                            %>
                        </form>
                    </div>

                    <button id="no" class="btn btn-large btn-danger btn-block">No</button>

                    <div id="nodiv">
                        <form action="menu.jsp" >
                            <textarea id="description" name="description" placeholder="Try to write date textually" ></textarea>
                            <button name="submit" value="no" class="btn btn-danger btn-large pull-right" type="submit"> Submit </button>
                            <%
                                if (button.equals("map")) {
                            %>
                            <div style="display:none">
                                <input name="url" value="<%= url%>">
                                <input name="title" value="<%= title%>">
                                <input name="lat" value="<%= lat%>">
                                <input name="lng" value="<%= lng%>">
                                <input name="radius" value="<%= radius%>">
                                <input name="indirizzo" value="<%= indirizzo%>">
                                <input name="loctype" value="<%=button%>">
                            </div>
                            <%
                            } else if (button.equals("text")) {
                            %>
                            <div style="display:none">
                                <input name="url" value="<%= url%>">
                                <input name="title" value="<%= title%>">
                                <input name="description" value="<%= description%>">
                                <input name="loctype" value="<%=button%>">
                            </div>
                             <%
                            } else if (button.equals("skip")) {
                            %>
                            <div style="display:none">
                                <input name="url" value="<%= url%>">
                                <input name="title" value="<%= title%>">
                                <input name="loctype" value="<%=button%>">
                            </div>
                            <%
                                }
                            %>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

