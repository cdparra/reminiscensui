<?php
//--------------------------------------------------
//This file send data received from JavaScript to CrowdComputer 
//as a solution of a cross-domain interaction.
//This file requires: 
// - send_to_url, 
// - csrftoken,
// - form_data
//sent via POST
//--------------------------------------------------
ini_set("display_errors", 1);
error_reporting(E_ALL);

//set POST variables
$url = $_POST['send_to_url'];
$csrftoken=$_POST['csrftoken'];

$fields = $_POST['form_data'];
$fields_string='';
//url-ify the data for the POST
foreach($fields as $key=>$value) { $fields_string .= $key.'='.$value.'&'; }
rtrim($fields_string,'&');
//--------------------------------------------------
//open connection
$ch = curl_init();
//set the url, number of POST vars, POST data
curl_setopt($ch,CURLOPT_URL,$url);
curl_setopt($ch,CURLOPT_POST,count($fields));
curl_setopt($ch, CURLOPT_HTTPHEADER, array(
	'X-CSRFToken: '.$csrftoken
	)
);
curl_setopt($ch, CURLOPT_COOKIE, 'csrftoken='.$csrftoken);
// returns the response as a string instead of printing it
//curl_setopt($handle, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch,CURLOPT_POSTFIELDS,$fields_string);
//echo $ch;
//execute post
$result = curl_exec($ch);
//close connection
curl_close($ch);
//--------------------------------------------------
?>