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
    console.log("Using this API URL: "+localBaseUrl);
	if (localBaseUrl == null || localBaseUrl=="") {
        if (window.location.hostname == "http://base.reminiscens.me") {
            localBaseUrl = "http://base.reminiscens.me";
        } else {
            localBaseUrl = "http://test.reminiscens.me";
        }
        
		console.log("Setting API URL to: "+localBaseUrl);
        SetBaseUrl(localBaseUrl);
	}
	
    console.log("Login with: "+localBaseUrl+Reminiscens.apiRes+Reminiscens.userRes+Reminiscens.loginRes)
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

				    //controllo che versione dell'app devo visualizzare salvando che opzione ha scelto l'utente
					if (document.getElementById('version_1').checked) {
					    SetAppVersion(1);
					} else if (document.getElementById('version_2').checked) {
					    SetAppVersion(2);
					} else if (document.getElementById('version_3').checked) {
					    SetAppVersion(3);
					} else {
					    SetAppVersion(4);
					}

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

function statisticaOPEN() {
    //alert(GetPersonId());
    $.ajax({
        type: "POST",
        beforeSend: function (request) {
            request.setRequestHeader("PLAY_SESSION", GetSessionKey());
        },
        url: GetBaseUrl() + "/lifeapi/log/OPEN/user/" + GetPersonId(),
        //url: "http://test.reminiscens.me/lifeapi/user/signup",

        data: "{}",

        dataType: "json",
        contentType: "application/json",

        async: false,

        success: function (data) {
            //salert("hola");

        },
        error: function (data) {
            alert("Errore nel passaggio di statistiche OPEN");
        }
    });
}
