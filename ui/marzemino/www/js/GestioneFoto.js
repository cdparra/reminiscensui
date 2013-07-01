// JavaScript Document
var pictureSource;   // picture source
    var destinationType; // sets the format of returned value 

    // Wait for Cordova to connect with the device
    //
    document.addEventListener("deviceready",onDeviceReady,false);

    // Cordova is ready to be used!
    //
    function onDeviceReady() {
        pictureSource=navigator.camera.PictureSourceType;
        destinationType=navigator.camera.DestinationType;
    }

				function capturePhoto() {
      // Take picture using device camera and retrieve image as base64-encoded string
      navigator.camera.getPicture(onPhotoDataSuccess, onFail, { quality: 50,
        destinationType: destinationType.DATA_URL });
    }
	
	function onFail(message) {
      alert('Failed because: ' + message);
    }
	
	function onPhotoDataSuccess(imageData) {
		var editor = $("#editor").data("kendoEditor");
		var tmp = editor.value();
		
      editor.value(tmp + "<br/><img src='" + "data:image/jpeg;base64," + imageData + "' style='display:block;margin-left:auto;margin-right:auto;width:80px;height:80px' /><br/>");
    }