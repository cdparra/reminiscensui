<%-- 
    Document   : index
    Created on : 1-ott-2012, 15.08.43
    Author     : francesco
--%>
<%@page import="crowdMemories.Media"%>
<%@page errorPage="errorPage.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
//<jsp:useBean id="media" scope="session" class="crowdMemories.Media" ></jsp:useBean>

    session.setAttribute("user_name", "user");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Page</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <script src="bootstrap/js/jquery-1.8.2.min.js"></script>
        <script src="./bootstrap/js/bootstrap.js"></script>
        <script src="uploadscript.js"></script>

        <style type="text/css">
            #next { 
                position: relative;
                margin-top: 60px;
            }
            #sfondo { 
                width: 940px;
                height: 500px ; 
                margin-top: 40px;
                margin-left: auto;
                margin-right: auto;
            }
            #left{
                margin-top: 20px;
            }
            #right{
                margin-top: 20px;
            }
            #url{
                width: 550px;
            }
            #inputbar{
                margin-top: 30px;
            }
            #img{
                display: none; 
                max-height: 360px;
                margin-top: 20px
            }
            #label{
                display: block;
                text-align: center;
                font-size: 22px;
                padding: 8px 5px 8px;
                margin-top: 50px
            }
            #title{
                margin-top: 10px;
                width: 272px   
            }
            .modal p{
                text-align: center;
                font-size: 20px
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div id="sfondo" class="hero-unit">

                <form name="upload" method="post">
                    <h1> Upload your Photo </h1>
                    <div id="inputbar" class="dropdown">
                        <a id="upl-button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#" style="width: 300px">Upload photo from your library</a>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel" style="background-color: #eeeeee; width: 327px">
                            <li>
                                <input id="filepath" name="filepath" type="file" onchange="getURL(this);" style="margin-left: 10px">
                            </li>
                        </ul>
                        <input id="url" name="url" type="text" class="search-query pull-right" placeholder="or paste URL here" onchange="readURL();" />
                    </div>
                    <div id="left" class="span7"> 
                        <img id="img" src="#" alt="image not found"/>
                    </div>
                    <div id="right" class="span4"> 
                        <span id="label" class="label label-important">Insert title here</span>
                        <input id="title" name="title" type="text" class="search-query" placeholder="Insert Title Here"/>
                        <button id="next" class="btn btn-success btn-large pull-left" type="submit"> Submit url</button>

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

        <%

            String url = request.getParameter("url");
            String title = request.getParameter("title");

            try {

                boolean check = true;

                if (url.equals("")) {
                    check = false;
                }

                if (title.equals("")) {
                    check = false;
                }

                if (check) {
                    Media media = new Media();

                    media.setTitle(title);
                    media.setUrl(url);
                    media.setSource_url(url);
                    session.setAttribute("media", media);

                    response.sendRedirect("mappacerchio.jsp");
                } else {
        %>
        <script type="text/javascript">
            $("#myModalSubmit").modal('show');     
        </script>
        <%                    }
            } catch (Exception e) {
            }

        %>
    </body>
</html>