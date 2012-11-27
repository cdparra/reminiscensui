<%-- 
    Document   : timeline
    Created on : Nov 14, 2012, 4:38:41 PM
    Author     : J
--%>

<%@page import="mypackage.Stringa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Timeline</title>
        <script type="text/javascript" src="http://maps.google.com/maps/api/js?v=3.9&amp;sensor=false"></script>
        <script type="text/javascript" src="lib/jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="lib/mxn/mxn.js?(googlev3)"></script>
        <script type="text/javascript" src="lib/timeline-2.3.0.js"></script>
        <script src="src/timemap.js" type="text/javascript"></script>
        <script src="src/manipulation.js" type="text/javascript"></script>

        <link href="css/StyleOverlay.css" rel="stylesheet" />
        <script type="text/javascript" src="lib/JavaScriptOverlay.js"></script>
        <link href="css/index.css" rel="stylesheet" />

        <!--bootstrap-->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <link href="bootstrap/css/bootstrap-toggle-buttons.css" rel="stylesheet" />
        <script type="text/javascript" src="bootstrap/js/jquery.toggle.buttons.js"></script>

        <!--overlapping-->
        <script type="text/javascript" src="lib/oms.min.js"></script>

        <!--gestione pagina-->
        <script type="text/javascript" src="lib/Gestione.js"></script>
        <%
            //creo l' oggetto stringa a cui farò creare la stringa json
            Stringa stringa = new Stringa();
            //creo la stringa json
            String[] param = stringa.creazioneStringa(request.getParameter("id1"),request.getParameter("id2"));
        %>
        <script type="text/javascript">
            var tm;
            var oms;
            $(function () {
                // make a custom map style
                var styledMapType = new google.maps.StyledMapType([
                    {
                        featureType: "water",
                        elementType: "all",
                        stylers: [
                            { saturation: 0 },
                            { lightness: 100 }
                        ]
                    },
                    {
                        featureType: "all",
                        elementType: "all",
                        stylers: [
                            { saturation: -100 }
                        ]
                    }
                ], {
                    name: "white"
                });
                //bottone read more nei bubble delle descrizioni
                
                //inizializzazione TimeMap
                tm = TimeMap.init(<%=param[0]%>);
                // set the map to our custom style
                var gmap = tm.getNativeMap();
                gmap.mapTypes.set("white", styledMapType);
                gmap.setMapTypeId("white");

                //gestione overlapping
                //!!!usare sempre getNativeMap che ritorna l' oggetto mappa!
                //con il secondo parametro faccio in mondo che lo spyderfly rimanga anche dopo il clik (devo cliccare sulla mappa per farlo scomparire)
                oms = new OverlappingMarkerSpiderfier(gmap, { markersWontMove: true, keepSpiderfied: true });

                oms.addListener('click', function (marker) {
                    tm.getSelected().openInfoWindow();
                });
                oms.addListener('spiderfy', function (markers) {
                    //tm.getSelected().closeInfoWindow();				
                });
                oms.addListener('unspiderfy', function (markers) {
                    //tm.getSelected().closeInfoWindow();
                });
                //recupero il vettore di tutti gli item!!
                var a = tm.getItems();
                for (var i = 0; i < a.length; i++) {
                    //devo prenderli dentro tutti!!!! con getNativePlacemark() recupero il marker di ogni Item della TimeMap!!!
                    a[i].closeInfoWindow();
                    oms.addMarker(a[i].getNativePlacemark());  // <-- here
                }

                //devo inizializzare i toggle-button!
                $('.toggle-button-class').toggleButtons({
                    width: 220,
                    label: {
                        enabled: "Show",
                        disabled: "Not Show"
                    }
                });
            });
        </script>
    </head>
    <body>
        <div id="container" style="width: 1024px; margin-right: auto; margin-left: auto;">
            <div id="header" style="width: 800px; margin-right: auto; margin-left: auto; padding: 5px; text-align: center;">
                <img src="images/layout/cover-flatten.png" />
            </div>
            <!--div necessari per l' overlay-->
            <div class="overlay" id="overlay" style="display: none;"></div>
            <!--contenuto overlay-->

            <div id="box">                
                <div class="split_sx">
                    <h1 class="titolo_box"></h1>
                    <p class="testo_box"></p>
                    <img id="img_overlay" src="" />                    
                    <!--				<hr />-->
                </div>
                <div class="split_dx">
                    <!--<h3>Immagini del tempo</h3>-->
                    <!--<p>Prova</p>-->
                    <div class="tabbable">
                        <!-- Only required for left/right tabs -->
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#eventi" data-toggle="tab">Eventi</a></li>
                            <li><a href="#immagini" data-toggle="tab">Immagini</a></li>
                            <li><a href="#video" data-toggle="tab">Video</a></li>
                            <li><a href="#confronto" data-toggle="tab">Confronto</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="eventi">
                                <p>
                                    Il Concilio di Trento o Concilio Tridentino fu il XIX concilio ecumenico della Chiesa cattolica, 
                                    aperto da papa Paolo III nel 1545 e chiuso, dopo numerose interruzioni, nel 1563. Con questo 
                                    concilio venne definita la riforma della Chiesa cattolica (Controriforma) e la reazione alle 
                                    dottrine del calvinismo e luteranesimo (Riforma protestante), con il fine di rafforzare l'autorità papale, 
                                    seriamente minacciata dalla diffusione del luteranesimo. Fu un concilio importante per la storia della Chiesa
                                    cattolica, tanto che l'aggettivo "tridentino" viene usato ancora oggi per definire alcuni aspetti
                                    caratteristici della Chiesa cattolica ereditati da questo concilio e mantenuti per i successivi tre 
                                    secoli, fino ai concili Vaticano I e Vaticano II.
                                </p>
                            </div>
                            <div class="tab-pane" id="immagini" style="padding:5px;">
                                <!--<img src="../images/imgOverlay/1956_06Congr.jpg" />
                                <br />
                                <br />
                                <img src="../images/imgOverlay/7145486.jpg" />
                                <br />
                                <br />
                                <img src="../images/imgOverlay/955d_35.jpg" />
                                <br />
                                <br />
                                <img src="../images/imgOverlay/inaugurazione.jpg" />-->
                            </div>
                            <div class="tab-pane" id="video" style="margin-right: auto; margin-left: auto; padding: 5px; text-align: center;">
                                <p>Breve video sul concilio di Trento</p>
                                <iframe width="350" height="200" src="http://www.youtube.com/embed/4Vhzc4ayx3M" frameborder="0" allowfullscreen></iframe>
                            </div>
                            <div class="tab-pane" id="confronto" style="padding:5px;">
                                <div id="Lista1" class="tabbable tabs-left">
                                    <h3><%=request.getParameter("id1")%></h3>
                                     <%=param[1]%>
                                </div>
                                <div id="Lista2" class="tabbable tabs-left">
                                    <h3><%=request.getParameter("id2")%></h3>
                                     <%=param[2]%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--<p class="chiudi">X</p>-->
                <img src="images/layout/Button_prev.png" class="button_prev" />
                <img src="images/layout/Button_next.png" class="button_next" />
                <img src="images/layout/X.png" class="chiudi" />
            </div>
            <!--fine box-->


            <div id="info" style="text-align: center; padding: 5px;">
                <br />
                <!--<h1 style="color: white">Prova timeline</h1>-->
                <!--<p class="lead" style="color: white">Prova timeline</p>-->

                <div>
                    <button class="btn-large btn-primary" onclick="CambioScalaTimelineGiorno()">Giorno-Mese</button>&nbsp&nbsp&nbsp
                    <button class="btn-large btn-primary" onclick="CambioScalaTimelineMese()">Mese-Anno</button>&nbsp&nbsp&nbsp
                    <button class="btn-large btn-primary" onclick="CambioScalaTimelineAnno()">Anno-Decade</button>&nbsp&nbsp&nbsp
                    <button class="btn-large btn-primary" onclick="CambioScalaTimelineDecade()">Decade-Secolo</button>&nbsp&nbsp&nbsp
                    <br />
                </div>

                <br />
                <h2 style="color: white;"><%=request.getParameter("id1")%> & <%=request.getParameter("id2")%></h2>

                <!--<p style="color: white">Show:</p>-->
                <div style="float: left; width: 50%;">
                    <!--cambiato il metodo on click con onchange e usato l' attributo for per allineare la label sopra al toggle-button-->
                    <label for="checkbox1" style="color: white"><%=request.getParameter("id1")%></label>
                    <div class="toggle-button-class">
                        <input id="checkbox1" type="checkbox" onchange="toggleDataset('Linea temporale <%=request.getParameter("id1")%>','<%=request.getParameter("id1")%>', this.checked);" checked="checked" />
                    </div>
                </div>
                <div style="float: left; width: 50%;">
                    <label for="checkbox1" style="color: white"><%=request.getParameter("id2")%></label>
                    <div class="toggle-button-class">
                        <input id="checkbox2" type="checkbox" onchange="toggleDataset('Linea temporale <%=request.getParameter("id2")%>','<%=request.getParameter("id2")%>', this.checked);" checked="checked" />
                    </div>
                </div>

                <br />   
            </div>

            <!--bisogna aggiungere clear:left altrimenti la mappa viene allineata a sx come i div sopra-->
            <div id="timemap" style="clear: left;">
                <div id="mapcontainer" style="border-width:5px;border-bottom:solid;">
                    <div id="map" style="-moz-border-radius: 10px 10px 0px 0px; -webkit-border-radius: 10px 10px 0px 0px; border-radius: 10px 10px 0px 0px;">
                    </div>
                    
                </div>
                <div id="timelinecontainer">
                    <div id="timeline" style="-moz-border-radius: 0px 0px 10px 10px; -webkit-border-radius: 0px 0px 10px 10px; border-radius: 0px 0px 10px 10px;"></div>
                </div>
            </div>            
        </div>
    </body>
</html>
