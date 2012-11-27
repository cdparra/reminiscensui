<%-- 
    Document   : index
    Created on : 1-ott-2012, 15.08.43
    Author     : francesco
--%>
<%@page import="crowdMemories.Media"%>
<%@page errorPage="errorPage.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%

    String url = request.getParameter("url");
    String title = request.getParameter("title");

%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <title>Map</title>
        <style type="text/css">

            .hero-unit p{
                text-align: center;
                font-size: 14px;
                line-height: 20px 
            }
            #address{
                width:350px;
            }
            #right{
                width: 350px;
            }
            #search{
                padding: 20px
            }

            #map_canvas { 
                height: 480px;
                width: 540px 
            }

            #sfondo { 
                width: 940px;
                padding-bottom: 760px;
                margin-top: 40px;
                margin-left: auto;
                margin-right: auto;
            }
            .modal p{
                text-align: center;
                font-size: 20px
            }
            #mytext{
                width: 327px; 
                height: 470px;
                margin-top: 20px;
                margin-bottom: 100px;
                resize: none
            }
            #image { 
                max-height: 250px; 
                max-width: 250px;
            }
            #box{
                background-color: white;
                padding: 20px;
            }
        </style>
        <script src="bootstrap/js/jquery-1.8.2.min.js"></script>
        <script type="text/javascript"
                src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAfhwuXTgopU7b9KHaTB9YDZwQ6LdPbLJ8&sensor=false">
        </script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script src="myMapMarkerCircle.js"></script>
        <script type="text/javascript">
           
            function checkDescription(){
                var text = document.getElementById('mytext').value;
               
                if(text == ""){
                    $("#myModalDescription").modal('show');
                    return false;
                }else{
                    return true;
                }  
            }
            
            function checkLocation(){
                var lat = document.getElementById('lat').value;
                var lng = document.getElementById('lng').value;
                
                if(lat == "" ||lng == ""){
                    $("#myModalLocation").modal('show');
                    return false;
                }else{
                    return true;
                }           
            }
            
        </script>

    </head>
    <body onload="initialize()">
        <div class="container">
            <div id="sfondo" class="hero-unit">
                <form method="get" action="date.jsp">
                    <button class="btn btn-mini pull-right" type="submit" name="submit" value="skip"> Skip this <i class="icon-forward"></i></button>
                    <div style="display: none;">
                        <input name="url" value="<%= url%>">
                        <input name="title" value="<%= title%>">
                    </div>
                </form>

                <div id="box" class="hero-unit">
                    <table style="margin-left:auto; margin-right: auto; padding: 10px; width: 70%;">
                        <tbody>
                            <tr>
                                <td>
                                    <img id="image" src="<%=url%>"  class="img-rounded"> 
                                </td>
                                <td>
                                    <h2><%= title%></h2>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <h1 style="margin-bottom: 70px;margin-top: 70px;">Do you remember the location?</h1>
                <div class="span7" >
                    <p><i class="icon-arrow-right"></i> If you remember exactly the location just drag the marker on the map over the location or select with a rightclick on the map the area in which you think it was.</p>
                    <div id="map_canvas" ></div>
                    <div id="search">
                        <p> <i class="icon-arrow-right"></i> You can also search a place!  </p>
                        <input id="address" name="address" class="input-medium search-query" type="text" placeholder="Insert place here" >
                        <input type="button" class="btn btn-primary" value="Search Place" onclick="codeAddress()">

                    </div>

                    <form method="get" action="date.jsp" >
                        <button class="btn btn-success btn-large" type="submit" name="submit" value="map" onclick="return checkLocation()"> Add the location on the map</button>

                        <div style="display: none; margin-top: 652px">
                            <input name="url" value="<%= url%>">
                            <input name="title" value="<%= title%>">
                            <table class="table" style="margin-top: 40px; width: 700px;">
                                <thead>
                                <th>Latitudine</th>
                                <th>Longitudine</th>
                                <th>Radius</th>
                                <th>Indirizzo</th>
                                </thead>
                                <tr>
                                    <td >
                                        <input id="lat" name="lat" type="text" value=""/>
                                    </td>
                                    <td >
                                        <input id="lng" name="lng" type="text" value=""/>
                                    </td>
                                    <td >
                                        <input id="radius" name="radius" type="text" value="0"/>
                                    </td>
                                    <td >
                                        <input id="indirizzo" name="indirizzo" type="text" value=""/>
                                    </td>
                                </tr>
                            </table>
                        </div>

                    </form>
                </div>

                <div id="right" class="span4" >
                    <form method="get" action="date.jsp">
                        <p> <i class="icon-arrow-right"></i> Otherwise you can describe it textually.</p>
                        <textarea id="mytext" name="description" placeholder="Add location textually"></textarea>
                        <button class="btn btn-success btn-large " type="submit" name="submit" value="text" onclick="return checkDescription()"> or add the description </button>

                        <div style="display: none">
                            <input name="url" value="<%= url%>">
                            <input name="title" value="<%= title%>">
                        </div>           

                    </form>
                </div>

            </div>
        </div>

        <div id="myModalDescription" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">Warning!</h3>
            </div>
            <div class="modal-body">
                <p>The description you entered could not be Empty!</p>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</button>
            </div>
        </div>

        <div id="myModalLocation" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">Warning!</h3>
            </div>
            <div class="modal-body">
                <p>Please check the location you entered!</p>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</button>
            </div>
        </div>

    </body>
</html>