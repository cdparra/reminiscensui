/**
* javascript functions to post files to a restful service
* (base in jQuery Upload File)
*
*/

$(function () {
    'use strict';
    // Change this to the location of your server-side upload handler:
    var url = window.location.hostname === 'localhost' ?
                '//test.reminiscens.me/lifeapi/upload' : '//test.reminiscens.me/lifeapi/upload';
    $('#fileupload').fileupload({
        url: url,
        dataType: 'json',
		success:function (data) {
			//alert(data.uri);
			document.getElementById("imgInput").innerHTML += "<img style='max-height:200px;max-width:220px;' src='" + "http://test.reminiscens.me/files/SMALL_" + data.filename + "'/><br><br>";
			imgStoriaUrl.push("");
			imgStoriaHashcode.push(data.hashcode);
			
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