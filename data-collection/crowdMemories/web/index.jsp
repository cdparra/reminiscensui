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
        </style>
    </head>
    <body>
        <div class="container">
            <div id="sfondo" class="hero-unit">
                <h1> Welcome to CrowdMemories </h1>
                <img id="image" src="bootstrap/img/upload-fill-submit.jpg" class="img-rounded">
                <a id="start-now" class="btn btn-success btn-large" href="upload.jsp"> 
                    Start Now
                </a>
            </div>
        </div>
    </body>
</html>
