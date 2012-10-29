<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Reminiscens Data Viewer</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" media="handheld, screen" />
    </head>
    <body>
        <div class="title" style="text-align: center"><h1>Reminiscens Data Viewer</h1></div>
        <div style="text-align: center">
            <form name="data_selector" method="post" action="results.php" style="display: block">
                <select name="type">
                    <option value="Media">Media</option>
                    <option value="Event">Events</option>
                    <option value="Person">People</option>
                    <option value="Time_Interval">Time Intervals</option>
                    <option value="Fuzzy_Date">Fuzzy Dates</option>
                    <option value="Location">Locations</option>
                </select><br>
                <button class="btn btn-primary" type="submit" value="go">Go</button>
            </form>
        </div>
        <div class="row"> 
            <div class="span12" >
                <div>
                    <table class="table table-hover" style="margin: auto">
                        <thead>
                            <tr>
                                <th>ID</th>                           
                                <th>URL</th>
                                <th>TYPE</th>
                                <th>CAPTION</th>
                                <th>TEXT</th>
                                <th>SOURCE</th>
                                <th>SOURCE URL</th>
                                <th>PUBLIC</th>
                                <th>LOCATION</th>
                                <th>TIME INTERVAL</th>
                            </tr>
                        <tbody>
                            <?php
                            $nomehost = "test.lifeparticipation.org";
                            $nomeuser = "nicola";
                            $password = "parrello@lp";
                            $schema = "reminiscens";
                            $type = $_POST['type'];

                            $connessione = mysql_connect($nomehost, $nomeuser, $password);
                            if (!$connessione) {
                                die('Not connected : ' . mysql_error());
                            }

                            $select = mysql_select_db($schema, $connessione);

                            if (!$select) {
                                die('Can\'t use reminiscens : ' . mysql_error());
                            }

                            $query = "SELECT * FROM reminiscens." . $type . ";";
                            $results = mysql_query($query);
                            $num = mysql_numrows($results);
                            mysql_close();
                            $i = 0;
                            if ($num > 0) {
                                while ($i < $num) {

                                    $media_id = mysql_result($results, $i, "media_id");
                                    $media_url = mysql_result($results, $i, "media_url");
                                    $media_type = mysql_result($results, $i, "media_type");
                                    $caption = mysql_result($results, $i, "caption");
                                    $text = mysql_result($results, $i, "text");
                                    $source = mysql_result($results, $i, "source");
                                    $source_url = mysql_result($results, $i, "source_url");
                                    $public = mysql_result($results, $i, "is_public");
                                    $location = mysql_result($results, $i, "location_id");
                                    $interval = mysql_result($results, $i, "time_interval_id");
                                    ?>
                                    <tr>
                                        <td> <?php echo $media_id ?> </td>
                                        <td> <?php echo $media_url ?> </td>
                                        <td> <?php echo $media_type ?> </td>
                                        <td> <?php echo $caption ?> </td>
                                        <td> <?php echo $text ?> </td>
                                        <td> <?php echo $source ?> </td>
                                        <td> <?php echo $source_url ?> </td>
                                        <td> <?php echo $public ?> </td>
                                        <td> <?php echo $location ?> </td>
                                        <td> <?php echo $interval ?> </td>
                                    </tr>
                                    <?php
                                    $i++;
                                }
                            }
                            ?>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
