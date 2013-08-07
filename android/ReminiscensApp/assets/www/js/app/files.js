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
        done: function (e, data) {
            $.each(data.result.files, function (index, file) {
                $('<p/>').text(file.name).appendTo('#files');
            });
        },
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css(
                'width',
                progress + '%'
            );
        }
    }).prop('disabled', !$.support.fileInput)
        .parent().addClass($.support.fileInput ? undefined : 'disabled');
});

//$(function () {
//    'use strict';
//    // Change this to the location of your server-side upload handler:
//    var url = window.location.hostname === 'localhost' ?
//                '//test.reminiscens.me/lifeapi/upload' : '//test.reminiscens.me/lifeapi/upload/';
//    
////    var aFileParts = ["<a id=\"a\"><b id=\"b\">hey!<\/b><\/a>"];
////    var oMyBlob = new Blob(aFileParts, { "type" : "text\/xml" });    
////
////    var fileList = [];
////    fileList.push(oMyBlob);
////
////    $('#fileupload').fileupload('send', {files: fileList});
////    
//
//    $('#fileupload').fileupload({
//        url: url,
//      dataType: 'json',
//        done: function (e, data) {
//            $.each(data.result.files, function (index, file) {
//                $('<p/>').text(file.name).appendTo('#files');
//            });
//        },
//        progressall: function (e, data) {
//            var progress = parseInt(data.loaded / data.total * 100, 10);
//            $('#progress .bar').css(
//                'width',
//                progress + '%'
//            );
//        }
//    }).prop('disabled', !$.support.fileInput)
//        .parent().addClass($.support.fileInput ? undefined : 'disabled');
//    
//    $('#fileupload').fileupload('send', {files: fileList});
//    //$('#fileupload').fileupload('add', {files: filesList});
//});