/**
* javascript functions to post files to a restful service
* (base in jQuery Upload File)
*
*/

$(function () {
    'use strict';
    // Change this to the location of your server-side upload handler:
    var baseUrl = window.location.hostname === 'localhost' ?
                '//localhost/lifeapi' : '//test.reminiscens.me/lifeapi';
    var url = baseUrl+'/upload';

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
		headers:
		{
			"PLAY_SESSION":"618b4ad9aa13ff7bd4b785e71eb8d9bbd937d561-pa.u.exp%3A1377189637632%00pa.p.id%3Apassword%00pa.u.id%3Acdparra%40gmail.com"
		},
		success:function (data) {
			//alert(data.uri);
			$('#thumbnail').html("<img src='" + data.thumbnailURI + "'/><br><br>");
			$('#medium').html("<img src='" + data.mediumURI + "'/><br><br>");
			$('#large').html("<img src='" + data.largeURI + "'/><br><br>");
			$('#original').html("<img src='" + data.uri + "'/><br><br>");
			
//			$.ajax({
//				type: "GET",
//				url: "http://localhost/lifeapi/file/" + data.hashcode + "/thumbnail", 
//				beforeSend: function(request) {
//					request.setRequestHeader("PLAY_SESSION", "618b4ad9aa13ff7bd4b785e71eb8d9bbd937d561-pa.u.exp%3A1377189637632%00pa.p.id%3Apassword%00pa.u.id%3Acdparra%40gmail.com");
//				}
//			}).done(function(data) {
//					$('#getFileTest').html("<img src='data:image/jpeg;base64,"+data+"' />");
//			});

			$('#getFileTest').html("<img src="+baseUrl+"/file/" + data.hashcode + "/thumbnail'/><br><br>");
			
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