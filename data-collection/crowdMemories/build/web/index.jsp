<%-- 
    Document   : index
    Created on : 1-ott-2012, 15.08.43
    Author     : francesco
--%>
<%@page errorPage="errorPage.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    session.setAttribute("user_name", null);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <title>Welcome Page</title>
        <style type="text/css">
            #image { 
                display: block;
                margin-left: auto;
                margin-right: auto;
                margin-top: 60px; 
            }
            #start-now { 
                display: block;
                margin-left: auto;
                margin-right: auto; 
                width: 300px;
                margin-top: 80px;
            }
            #sfondo { 
                width: 940px;
                height: 500px ; 
                margin-top: 40px;
                margin-left: auto;
                margin-right: auto;
            }

            input[type="number"]{
                width: 150px;
                margin-bottom: 0px;
            }

            /*non fa apparire le frecce su e giu in chrome*/
            input[type='number']::-webkit-outer-spin-button,
            input[type='number']::-webkit-inner-spin-button {
                -webkit-appearance: none;
                margin: 0;
            }

            .hero-unit p {
                font-size: 15px;
                font-weight: 200;
                line-height: 20px;
                color: inherit;
                text-align: center;
            }
            #album{
                background-color: white;
                background-color: white;
                margin-top: -70px;
                margin-right: -20px;
                padding: 15px;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <div id="sfondo" class="hero-unit">
                <h1> Welcome to CrowdMemories </h1>
                <img id="image" src="bootstrap/img/upload-fill-submit.jpg" class="img-rounded">
                <form name="start" method="get" action="Album_check">
                    <button id="start-now" class="btn btn-success btn-large" type="submit"> 
                        Start Now
                    </button>
                    <div id="album" class="pull-right" >
                        <p> ALBUM NUMBER HERE 
                        </p>
                        <input name="album_id" type="number">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
