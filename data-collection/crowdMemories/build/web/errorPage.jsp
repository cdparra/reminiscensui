<%-- 
    Document   : errorPage
    Created on : 12-nov-2012, 16.01.03
    Author     : franz
--%>
<%@page isErrorPage="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.getSession().invalidate();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <title>Error</title>

        <style type="text/css">
            #sfondo { 
                text-align: center;
                margin-top: 40px;
                padding: 40px;
                margin-left: auto;
                margin-right: auto;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div id="sfondo" class="hero-unit">
                <h1>Sorry!</h1>
                <p>An error occured! Sorry!</p>
                <a class="btn btn-primary" href="index.jsp">Please try to upload again</a>
            </div>
        </div>
    </body>
</html>
