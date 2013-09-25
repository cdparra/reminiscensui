// JavaScript source code
var pictureSource;   // picture source
var destinationType; // sets the format of returned value 

// Called when a photo is successfully retrieved
//
function onPhotoDataSuccess(imageData) {
    //alert(imageData);
    uploadPhoto(imageData);
}

// Called when a photo is successfully retrieved
//
function onPhotoURISuccess(imageURI) {
    // Uncomment to view the image file URI 
    // console.log(imageURI);

    // Get image handle
    //
    var largeImage = document.getElementById('largeImage');

    // Unhide image elements
    //
    largeImage.style.display = 'block';

    // Show the captured photo
    // The inline CSS rules are used to resize the image
    //
    largeImage.src = imageURI;
}

// A button will call this function
//
function capturePhoto() {
    // Take picture using device camera and retrieve image as base64-encoded string
    /*navigator.camera.getPicture(onPhotoDataSuccess, onFail, {
        quality: 50
    });*/
    navigator.camera.getPicture(uploadPhoto,
                                        function (message) { alert('get picture failed'); },
                                        {
                                            quality: 50,
                                            //destinationType: navigator.camera.DestinationType.FILE_URI,
                                            //sourceType: navigator.camera.PictureSourceType.PHOTOLIBRARY
                                        }
                                        );

}

// A button will call this function
//
function capturePhotoEdit() {
    // Take picture using device camera, allow edit, and retrieve image as base64-encoded string  
    navigator.camera.getPicture(onPhotoDataSuccess, onFail, {
        quality: 20, allowEdit: true,
        destinationType: destinationType.DATA_URL
    });
}

// A button will call this function
//
function getPhoto(source) {
    // Retrieve image file location from specified source
    navigator.camera.getPicture(onPhotoURISuccess, onFail, {
        quality: 50,
        destinationType: destinationType.FILE_URI,
        sourceType: source
    });
}

// Called if something bad happens.
// 
function onFail(message) {
    alert('Failed because: ' + message);
}


function win(r) {
    //console.log("Code = " + r.responseCode);
    //alert("Response = " + r.response);
    //console.log("Sent = " + r.bytesSent);
    var data = JSON.parse(r.response);

    alert(data.filename);
    //alert("ciao");
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
