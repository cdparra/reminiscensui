/**
* javascript functions to post files to a restful service
* (base in jQuery Upload File)
*
*/
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
            document.getElementById("imgInput").innerHTML += "<div id='" + "divImg" + imgStoriaUrl.length + "' style='position: relative; display: inline-block;'><img style=' max-height:200px;max-width:220px;' src='" + GetBaseUrl() + "/files/SMALL_" + data.filename + "' /><img src='images/Ximm.png' style='position:absolute;right:-12.5px; top:-12.5px;  cursor:pointer;' onclick='eliminaImmagine(" + imgStoriaUrl.length + ")'/></div><br><br>";
            imgStoriaHashcode.push(data.hashcode);
			imgStoriaFilename.push(data.filename);
			imgStoriaUrl.push(data.uri);
			imgStoriaUrlHtml.push(GetBaseUrl() + "/files/SMALL_" + data.filename);
			
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