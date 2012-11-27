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
                width: 350px; 

            }
            .modal p{
                text-align: center;
                font-size: 20px
            }
            form{
                text-align: center;
            }
            p {
                margin-top: 40px
            }

            #fileInput{
                display: none;
            }
            #modal-body-uploaded{
                display: none
            }
            
            #myModalInfo p{
                /* background-image: url('bootstrap/img/old_house.jpg');
                */
                font-size: 26px;
                line-height: 1.5;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div id="sfondo" class="hero-unit">

                <form name="upload" method="get" action="mappacerchio.jsp">
                    <h1> Upload your Photo </h1>      
                    <p id="text"><i class="icon-arrow-right"></i> Select a photo from your library or just Copy the URL of the image in the following bar </p>
                    <input id="submit" type="submit" style="display:none">
                    <input id="fileInput" type="file" onchange="displayImage(this.files[0])">

                    <button class="btn btn-primary" type="button" onclick="document.getElementById('fileInput').click()">Click here to upload from your library</button>                    

                    <input id="url" name="url" autofocus="autofocus" type="text" class="search-query" placeholder="Copy URL here" onchange="readURL();" onblur="readURL();"/>

                    <p> <i class="icon-arrow-right"></i>  And remember to Insert a Title 
                        <input id="title" name="title" type="text" class="search-query" placeholder="Insert Title Here"/>
                    </p>

                    <img id="img" src="#" alt="image not found"/>
                    <div id="next">
                        <button class="btn btn-primary btn-large btn-block" type="button" onclick="return checkOrUpload()"> Submit url</button>
                    </div>
                </form>
            </div>

            <div id="myModalUrl" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Attention</h3>
                </div>
                <div class="modal-body">
                    <p>Please check what you entered because only  jpg, jpeg, png or gif extension ere supported!</p>
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

            <div id="myModalUpload" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
                <div class="modal-header">
                    <h3 id="myModalLabel">Uploading your photo to <strong>Imgur.com</strong></h3>
                </div>
                <div id="modal-body-uploading" class="modal-body">
                    <p>I'm uploading your photo please wait!</p>
                    <div class="progress progress-striped active">
                        <div class="bar" style="width: 100%;"></div>
                    </div>
                </div>
                <div id="modal-body-uploaded" class="modal-body">
                    <p>The photo was succesfully uploaded!</p>
                    <div class="alert alert-info">
                        This is the link of your photo on Imgur.com: <a id="link" target="_blank"></a>
                    </div>
                    <button type="button" class="btn btn-primary btn-large btn-block" onclick="submit()"> Continue </button>               
                </div>
            </div>
            <div id="myModalInfo" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Hello and welcome to CrowdMemories!</h3>
                </div>
                <div class="modal-body">
                    <img src="bootstrap/img/old_house.jpg">
                    <p>
                        We would need photos or images of the world as it was years ago. <br>
                        We kindly ask you to upload a photo and then, 
                        based on what you remember, add some simple information such as the date
                        or the place where it was taken! <br>
                        Thank you for your help! 
                    </p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary btn-block" data-dismiss="modal" aria-hidden="true">Ok continue!</button>
                </div>
            </div>
        </div>
    </body>
</html>