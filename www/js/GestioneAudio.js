// JavaScript source code


function captureSuccess(mediaFiles) {
    var i, len;
    for (i = 0, len = mediaFiles.length; i < len; i += 1) {
        uploadAudio(mediaFiles[i]);
    }
}

// Called if something bad happens.
// 
function captureError(error) {
    var msg = 'An error occurred during capture: ' + error.code;
    navigator.notification.alert(msg, null, 'Uh oh!');
}

// A button will call this function
//
function captureAudio() {
    navigator.device.capture.captureAudio(captureSuccess, captureError, { limit: 1 });
    // Unconmment for server version
    // Launch device audio recording application, 
    // allowing user to capture up to 2 audio clips
	//if (navigator.userAgent
	//		.match(/(iPhone|iPod|iPad|Android|BlackBerry|IEMobile)/)) {
	//    navigator.device.capture.captureAudio(captureSuccess, captureError, { limit: 1 });
	//} else {
	//	record();
	//}
}


function onFail(message) {
    alert('Failed because: ' + message);
}


function winAudio(r) {
    //console.log("Code = " + r.responseCode);
    //alert("Response = " + r.response);
    //console.log("Sent = " + r.bytesSent);
	
	console.log("L'audio funziona");
}

function failAudio(error) {
    alert("An error has occurred: Code = " = error.code);
    console.log("upload error source " + error.source);
    console.log("upload error target " + error.target);
}


function uploadAudio(mediaFile) {
    var options = new FileUploadOptions();
    options.fileKey = "file";
    options.fileName = imageURI.substr(mediaFile.fullPath.lastIndexOf('/') + 1);

    //alert(mediaFile.fullPath);
    var headers = { 'PLAY_SESSION': GetSessionKey() };

    //options.params = params;
    options.headers = headers;

    var ft = new FileTransfer();
    ft.upload(mediaFile.fullPath, "http://test.reminiscens.me" + "/lifeapi/upload", winAudio, failAudio, options);
}