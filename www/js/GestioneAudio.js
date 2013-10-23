// A button will call this function
//
function captureAudio() {
    console.log("Starting to capture audio...");
    navigator.device.capture.captureAudio(captureSuccess, captureError, { limit: 1 });
    console.log("Audio captured...");
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


// When audio registration was successful
function captureSuccess(mediaFiles) {
    var i, path, len;
    console.log("L'audio funziona");
    console.log("--> Files count: "+mediaFiles.length);
    for (i = 0, len = mediaFiles.length; i < len; i = i + 1) {
        path = mediaFiles[i].fullPath;
        console.log("--> File to upload: "+path);
        uploadAudio(mediaFiles[i]);
    }
}

// Called if something bad happens on recording audio
function captureError(error) {
    var msg = "An error occurred during capture: " + error.code;
    console.log(msg);
}


function onFail(message) {
    navigator.notification.alert(
                                 "E' successo un'errore: " + message, // message
                                 function () { /* do nothing */ },    // callback
                                 "Audio non registrato",              // title
                                 "Ho capito"                          // buttonName
                                 );
    console.log("Errore in upload audio: "+message);
}

function winAudio(r) {
    console.log("Code = " + r.responseCode);
    console.log("Response = " + r.response);
    console.log("Sent = " + r.bytesSent);
    var data = JSON.parse(r.response);
    
    console.log("L'audio funziona");
    console.log("Audio Filename: "+data.filename);
    console.log("Audio Hashcode: "+data.hashcode);
    
    // TODO: Qua, dovremo gestire una potenziale lista di registrazioni
    // tutte elencate qui sotto
    // e aggiungere questi come memento alla storia
    document.getElementById("play").style["visibility"]="";
    document.getElementById("stop").style["visibility"]="";
    
    var urlaudio = GetBaseUrl() + "/files/" + data.filename;
    console.log("Audio URL: "+urlaudio);
    imgStoriaUrl.push(urlaudio);
    imgStoriaHashcode.push(data.hashcode);
    imgStoriaFilename.push(data.filename);
}

function failAudio(error) {
    navigator.notification.alert(
                                 "E' successo un'errore: " + message, // message
                                 function () { /* do nothing */ },    // callback
                                 "Audio non registrato",              // title
                                 "Ho capito"                          // buttonName
                                 );
    console.log("Errore in upload audio: "+message);
    console.log("upload error source " + error.source);
    console.log("upload error target " + error.target);
}


function uploadAudio(mediaFile) {
    var options = new FileUploadOptions();
    options.fileKey = "file";
    options.fileName = mediaFile.fullPath.substr(mediaFile.fullPath.lastIndexOf('/') + 1);
    
    // TODO: control what is the type in android
    options.mimeType="audio/wav";
    //alert(mediaFile.fullPath);
    var headers = { 'PLAY_SESSION': GetSessionKey() };

    //options.params = params;
    options.headers = headers;

    var ft = new FileTransfer();
    
    var url = GetBaseUrl() + "/lifeapi/upload";
    console.log("Uploading audio file to: "+url);
    console.log("--> File to upload: "+mediaFile.fullPath);
    console.log("--> Name of File to upload: "+options.fileName);
    ft.upload(mediaFile.fullPath, url, winAudio, failAudio, options);
}