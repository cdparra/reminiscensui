/**
* javascript functions to post files to a restful service
* (base in jQuery Upload File)
*
*/

function win(r) {
    //console.log("Code = " + r.responseCode);
    alert("Response = " + r.response);
    //console.log("Sent = " + r.bytesSent);
}

function fail(error) {
    alert("An error has occurred: Code = " = error.code);
    console.log("upload error source " + error.source);
    console.log("upload error target " + error.target);
}


function uploadPhoto(imageURI) {
    var options = new FileUploadOptions();
    options.fileKey = "file";
    options.fileName = imageURI.substr(imageURI.lastIndexOf('/') + 1);
    options.mimeType = "image/jpeg";

    var params = new Object();
    params.value1 = "test";
    params.value2 = "param";

    var headers = { 'PLAY_SESSION': GetSessionKey() };

    //options.params = params;
    options.headers = headers;

    var ft = new FileTransfer();
    ft.upload(imageURI, GetBaseUrl() + "/lifeapi/upload", win, fail, options);
}


$(function () {
    'use strict';
    // Change this to the location of your server-side upload handler:
    /*var url = window.location.hostname === 'localhost' ?
                '//test.reminiscens.me/lifeapi/upload' : '//test.reminiscens.me/lifeapi/upload';*/
    $('#fileupload').fileupload({
        //url: url,
        url: GetBaseUrl() + "/lifeapi/upload",
        dataType: 'json',
		success:function (data) {
			//alert(data.uri);
		    document.getElementById("imgInput").innerHTML += "<img style='max-height:200px;max-width:220px;' src='" + GetBaseUrl() + "/files/SMALL_" + data.filename + "'/><br><br>";
			imgStoriaUrl.push("");
			imgStoriaHashcode.push(data.hashcode);
			imgStoriaFilename.push(data.filename);
			
			$('#progress .bar').css(
                'width',
                0 + '%'
            );
        },
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css(
                'width',
                progress + '%'
            );
        }
		/*send:function (e, data) {
   				data.headers
		}*/
		//forceIframeTransport:true
    }).prop('disabled', !$.support.fileInput)
        .parent().addClass($.support.fileInput ? undefined : 'disabled');
});