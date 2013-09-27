function onLoad() {
	document.addEventListener("deviceready", onDeviceReady, true);
}
function onDeviceReady() {
	console.log("PhoneGap is working!!");
}
function Redirect() {
	location.href = "registra.html";
}

// A word of notice: avoid alerts as much as possible. 
// use console.log instead
function Login() {
	var sessionData = new Object;
	sessionData.email = $("#email").val();
	sessionData.password = $("#password").val();
	
	var localBaseUrl = GetBaseUrl();
	
	if (localBaseUrl == null || localBaseUrl=="") {
		localBaseUrl = "http://test.reminiscens.me";
	}
	
	$.ajax({
				type : "POST",
				//url: "http://test.reminiscens.me/lifeapi/user/login",
				//url : "http://base.reminiscens.me/lifeapi/user/login",
				url : localBaseUrl+Reminiscens.apiRes+Reminiscens.userRes+Reminiscens.loginRes,
				data : JSON.stringify(sessionData),
				async : false,
				success : function(data) {
					SetSessionKey(data.sessionKey);
					SetPersonId(data.person.personId);
					SetPersonBirthDate(data.person.birthdateAsString);
					SetPersonDeacadeBirthDate(parseInt(data.person.birthdateAsString
							.split('-')[0] / 10) * 10);
					SetPersonYearBirthDate(data.person.birthdateAsString
							.split('-')[0]);
					location.href = "main.html";

				},
				error : function(data) {
					alert("L'email o la password inseriti sono sbagliati");

				},
				dataType : "json",
				contentType : "application/json"
			});
}

//var app = {
//	// Application Constructor
//	initialize : function() {
//		this.bindEvents();
//	},
//	// Bind Event Listeners
//	//
//	// Bind any events that are required on startup. Common events are:
//	// 'load', 'deviceready', 'offline', and 'online'.
//	bindEvents : function() {
//		document.addEventListener('deviceready', this.onDeviceReady, true);
//	},
//	// deviceready Event Handler
//	//
//	// The scope of 'this' is the event. In order to call the 'receivedEvent'
//	// function, we must explicity call 'app.receivedEvent(...);'
//	onDeviceReady : function() {
//		app.receivedEvent('deviceready');
//		pictureSource = navigator.camera.PictureSourceType;
//		destinationType = navigator.camera.DestinationType;
//	},
//	// Update DOM on a Received Event
//	receivedEvent : function(id) {
//		//        var parentElement = document.getElementById(id);
//		//        var listeningElement = parentElement.querySelector('.listening');
//		//        var receivedElement = parentElement.querySelector('.received');
//
//		//        listeningElement.setAttribute('style', 'display:none;');
//		//        receivedElement.setAttribute('style', 'display:block;');
//
//		console.log('Received Event: ' + id);
//	}
//};
