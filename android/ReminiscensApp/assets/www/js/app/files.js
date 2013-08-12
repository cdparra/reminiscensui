/**
* javascript functions to post files to a restful service
* (base in jQuery Upload File)
*
*/

$(function () {
    'use strict';
    // Change this to the location of your server-side upload handler:
    var url = window.location.hostname === 'localhost' ?
                '//test.reminiscens.me/lifeapi/upload' : '//test.reminiscens.me/lifeapi/upload/';
    $('#fileupload').fileupload({
        url: url,
        dataType: 'json',
		/*handleRequest: function (request)
            {
                request.setRequestHeader("PLAY_SESSION", sessionKey);
            },*/
        /*done: function (e, data) {
			$('#progress .bar').css(
                'width',
                0 + '%'
            )
			//alert(e.uri);
            $.each(data.result.files, function (index, file) {
                //$('<p/>').text(file.name).appendTo('#files');
				//alert(file.uri);
            });
        },*/
		/*headers:
		{
			"PLAY_SESSION":sessionKey,
		},*/
		success:function (data) {
			//alert(data.uri);
			document.getElementById("imgInput").innerHTML += "<img style='max-height:200px;max-width:220px;' src='" + data.uri + "'/><br><br>";
			imgStoria.push(data.uri);
			
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