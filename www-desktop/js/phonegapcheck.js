function onLoad() {
	if (navigator.userAgent
			.match(/(iPhone|iPod|iPad|Android|BlackBerry|IEMobile)/)) {
		document.addEventListener("deviceready", onDeviceReady, false);
	} else {
		//onDeviceReady(); //this is the browser
	}
}

function onDeviceReady() {
	//navigator.notification.alert("PhoneGap is working!!");
}