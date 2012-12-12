<%-- 
    Document   : index
    Created on : Nov 14, 2012, 10:57:32 AM
    Author     : J
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/index.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <link href="bootstrap/css/select2.css" media="screen" rel="stylesheet" type="text/css">
        <script src="bootstrap/js/select2.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
        <script type="text/javascript">
            $(document).ready(function(){
                $('#combobox1').select2();
                $('#combobox2').select2();
            });
        </script>
    </head>
    <body>
        <div style="width: 1024px;text-align: center;margin-right: auto; margin-left: auto;">
            <div id="header" style="width: 800px; margin-right: auto; margin-left: auto; padding: 5px; text-align: center;">
                <img src="images/layout/cover-flatten.png" />
            </div>
            <form action="checkAttributi.jsp" method="post">
                <h3 style="color: white">Persona 1  :</h3> <!--<input name="persona1" font-names="Comic Sans MS" size=15 type="text" />-->
                <select id="combobox1" name="combobox1" style="width:300px">
                    <option value="Fantozzi">Ugo Fantozzi</option>
                    <option value="Kessler">Bruno Kessler</option>
                    <option value="Parra">Ygnacio Parra</option>
                </select>
                <br />
                <br />
                <h3 style="color: white">Persona 2  : </h3>
                <select id="combobox2" name="combobox2" style="width:300px">
                    <option value="Kessler">Bruno Kessler</option>
                    <option value="Fantozzi">Ugo Fantozzi</option>
                    <option value="Parra">Ygnacio Parra</option>
                </select> 
                <br />
                <br /><br />
                <input class='btn btn-large btn-primary' type="submit" value="Timeline">
            </form>
        </div>
    </body>
</html>
