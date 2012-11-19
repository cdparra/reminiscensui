<%-- 
    Document   : index
    Created on : 1-ott-2012, 15.08.43
    Author     : francesco
--%>
<%@page import="crowdMemories.Media"%>
<%@page errorPage="errorPage.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Page</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <script src="bootstrap/js/jquery-1.8.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script src="uploadscriptOnlyUrl.js"></script>

        <style type="text/css">
            #sfondo { 
                width: 940px;
                margin-top: 40px;
                margin-left: auto;
                margin-right: auto;
                padding-bottom: 30px
            }
            #url{
                width: 550px;
            }
            #img{

                display: none; 
                margin-top: 20px;
            }
            #next{
                display: none;
                padding: 30px;
                padding-bottom: 0px
            }
            #title{
                width: 272px   
            }
            .modal p{
                text-align: center;
                font-size: 20px
            }
            form{
                text-align: center;
            }
            #text{
                margin-top: 50px
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div id="sfondo" class="hero-unit">

                <form name="upload" method="get" action="mappacerchio.jsp">
                    <h1> Upload your Photo </h1>      
                    <p id="text">Copy the URL of your image in the following bar and please Insert a Title</p>
                    <input id="url" name="url" autofocus="autofocus" type="text" class="search-query" placeholder="Copy URL here" onchange="readURL();" onblur="readURL();"/>
                    <input id="title" name="title" type="text" class="search-query" placeholder="Insert Title Here"/>
                    <img id="img" src="#" alt="image not found"/>
                    <div id="next">
                        <button class="btn btn-primary btn-large btn-block" type="submit" onclick="return check()"> Submit url</button>
                    </div>
                </form>
            </div>

            <div id="myModalUrl" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Attention</h3>
                </div>
                <div class="modal-body">
                    <p>Please check the url you entered because only  jpg, jpeg or png extension ere supported!</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</button>
                </div>
            </div>

            <div id="myModalSubmit" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Attention</h3>
                </div>
                <div class="modal-body">
                    <p>You forgot to enter something. Please check before submit!</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</button>
                </div>
            </div>
        </div>

    </body>
</html>