/**
 * timeline.js
 * Reminiscens Timeline functions
 * 
 */

//var reminiscensAPI = "http://test.reminiscens.me/lifeapi";
var reminiscensAPI = "http://localhost/lifeapi/api";

function onLoad() {
	document.addEventListener("deviceready", onDeviceReady, true);
}
function onDeviceReady() {
	// navigator.notification.alert("PhoneGap is working!!");
}
function editor() {
	var editor = $("#editor").data("kendoEditor");
	// alert(editor.value());
	$("#debug").text(editor.value());
}

function storage() {
	/*
	 * var storage =$.localStorage; //alert(storage.get('prova')); //var obj =
	 * JSON.parse(storage.get('prova')); alert(storage.get('prova').titolo);
	 * //$("#debug").text(storage.get('prova'));
	 */

	// EliminaIntestazioneDataImg();
	// alert();
}

var tokern;
var Storie = [];
var MieStorie = [];

function Login() {
	// var passSha1 = $.sha1($("#password").val());
	var passSha1 = $.sha1("");
	var sessionData = new Object;
	sessionData.name = "reminiscens";
	// sessionData.authString = $("#email").val() + "!_-_!" + passSha1;
	sessionData.authString = "" + "!_-_!" + passSha1;

	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'http://reminiscens.apiary.io/api/session');
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4) {
			if (typeof cb !== "undefined") {
				cb(this);
			}
		} else {
			// alert('Status: '+this.status+'\nHeaders:
			// '+JSON.stringify(this.getAllResponseHeaders())+'\nBody: '+this.
			// responseText);
			// alert(this.responseText);
			/*
			 * var obj = JSON.parse(this.responseText);
			 * alert(obj.Session.auth_token);
			 */
		}
	};
	xhr
			.send("{  \n    \"Service\":{\n        \"name\": \"reminiscens\"\n        \"authString\": \""
					+ sessionData.authString + "\"  \n    }\n}");
}

function Timeline() {
	/*
	 * var xhr = new XMLHttpRequest(); //test.reminiscens.me/lifeapi
	 * xhr.open("get",
	 * "http://test.reminiscens.me/lifeapi/person/3/timeline",true);
	 * //xhr.setRequestHeader("Accept", "application/json");
	 * xhr.setRequestHeader("Content-Type", "application/json");
	 * //xhr.setRequestHeader("Access-Control-Allow-Origin",
	 * "test.reminiscens.me");
	 */

	var xhr = new XMLHttpRequest(); //test.reminiscens.me/lifeapi
	xhr.open("get", "http://test.reminiscens.me/lifeapi/person/3/timeline",
			true);
	//xhr.setRequestHeader("Accept", "application/json");
	xhr.setRequestHeader("Content-Type", "application/json");
	//xhr.setRequestHeader("Access-Control-Allow-Origin",
	// "test.reminiscens.me");

	xhr.onreadystatechange = function() {
		if (this.readyState == 4) {
			if (typeof cb !== "undefined") {
				cb(this);
			} else {
				// alert('Status: '+this.status+'\nHeaders:
				// '+JSON.stringify(this.getAllResponseHeaders())+'\nBody:
				// '+this.responseText);
				alert('Status: ' + this.status + '\nHeaders: '
						+ JSON.stringify(this.getAllResponseHeaders())
						+ '\nBody: ' + this.responseText);
				// alert(this.responseText);
				var timeline = JSON.parse(this.responseText);
				// alert
				// (timeline.Timeline.storyList[0].storyId);
				var storyList = timeline.Timeline.storyList;

				document.getElementById("divMieFotoDelTempo").innerHTML = "";
				var i = 0;
				while (storyList[i] != null) {
					// alert(storyList[i].storyId);
					var mementoList = storyList[i].mementoList;
					var j = 0;
					var tmp = new Object;
					tmp.titolo = storyList[i].text;
					tmp.dove = "";
					tmp.quando = storyList[i].startDate;
					var vettImm = [];
					while (mementoList[j] != null) {
						if (mementoList[j].type == "photo") {
							// alert(mementoList[j].url);

							tmp.testo = mementoList[j].headline; // !!!!!da
							// sistemare
							// perche
							// devo
							// salvare
							// la
							// descizione
							// di
							// ogni
							// immagine!
							var Imm = new Object;
							Imm.src = mementoList[j].url;
							vettImm.push(Imm);

							/*
							 * document.getElementById("divMieFotoDelTempo").innerHTML += "<a
							 * class='fancybox' rel='gallery1'
							 * href='" + mementoList[j].url + "'
							 * title='" + storyList[i].text + "' >
							 * <img src='" + mementoList[j].url + "'
							 * alt='' /> </a>";
							 */

						}
						j++;
					}
					tmp.immagini = vettImm;
					MieStorie.push(tmp);
					i++;
				}

				document.getElementById("divMieFotoDelTempo").innerHTML = "";
				document.getElementById("divMieStorieDelTempo").innerHTML = "";
				for (i = 0; i < MieStorie.length; i++) {

					// alert(MieStorie[i].immagini[0].src);
					if (MieStorie[i].immagini[0] != null) {
						document.getElementById("divMieStorieDelTempo").innerHTML += "<a class='fancybox' rel='gallery2' href='"
								+ MieStorie[i].immagini[0].src
								+ "' title='"
								+ MieStorie[i].titolo
								+ "' > <img src='"
								+ MieStorie[i].immagini[0].src
								+ "' alt='' /> </a>";
						document.getElementById("divMieFotoDelTempo").innerHTML += "<a class='fancybox' rel='gallery1' href='"
								+ MieStorie[i].immagini[0].src
								+ "' title='"
								+ MieStorie[i].titolo
								+ "' > <img src='"
								+ MieStorie[i].immagini[0].src
								+ "' alt='' /> </a>";
					} else {
						document.getElementById("divMieStorieDelTempo").innerHTML += "<a class='fancybox' rel='gallery2' href='"
								+ "images/no_image.png"
								+ "' title='"
								+ MieStorie[i].titolo
								+ "' > <img src='"
								+ "images/no_image.png" + "' alt='' /> </a>";
						document.getElementById("divMieFotoDelTempo").innerHTML += "<a class='fancybox' rel='gallery1' href='"
								+ "images/no_image.png"
								+ "' title='"
								+ MieStorie[i].titolo
								+ "' > <img src='"
								+ "images/no_image.png" + "' alt='' /> </a>";
					}
					// document.getElementById("divMieFotoDelTempo").innerHTML
					// += "<img src='" +
					// "http://imgur.com/Bu8asfw" + "' alt=''
					// />";
				}

				var storage = $.localStorage;
				storage.set('mieStorie', MieStorie);

				$(".fancybox").fancybox(
						{
							'showCloseButton' : false,
							afterLoad : function() {
								if (Storie.length > this.index) {
									this.title = "<div><h1>"
											+ Storie[this.index].titolo
											+ "</h1><h5>"
											+ Storie[this.index].testo
											+ "</h5>  </div>";
								} else {
									this.title = "<div><h1>"
											+ MieStorie[this.index
													- Storie.length].titolo
											+ "</h1><h5>"
											+ MieStorie[this.index
													- Storie.length].testo
											+ "</h5>  </div>";
								}
								// this.title =
								// "<div><h1>" + "hola"
								// +"</h1> </div>";
							},
							'helpers' : {
								title : {
									type : 'inside'
								}
							}
						// helpers
						});
			}
		}
	};

	xhr
			.send("{ \n \"Session\":{\n \"auth_token\":\"054b13b875efac0604bfa8f21ab92dc26e1e34f5\"\n}");
}

function getTimeline() {
	var timelineAPI = reminiscensAPI + "/person/3/timeline";

	var jqxhr = $.getJSON(timelineAPI, function(data) {  
		console.log( "success" );
		// implement here the loading of the timeline
	})
	.done(function() { console.log( "second success" ); })
	.fail(function() { console.log( "error" ); })
	.always(function() { console.log( "complete" ); });;


}
