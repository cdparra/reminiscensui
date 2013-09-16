/**
 * Main application file for Reminiscens app
 */

/*
 * function createCORSRequest(method, url){ var xhr = new XMLHttpRequest();
 * 
 * if ("withCredentials" in xhr){ xhr.open(method, url, true);
 * xhr.setRequestHeader("Content-Type", "application/json"); } else if (typeof
 * XDomainRequest != "undefined"){ xhr = new XDomainRequest(); xhr.open(method,
 * url); xhr.setRequestHeader("Content-Type", "application/json"); } else { xhr =
 * null; } return xhr; }
 */

$(document)
		.ready(
				function() {

					// var storage =$.localStorage;
					/*
					 * if(storage.get('mieStorie')[0].titolo == null) {
					 * //alert("ciao"); MieStorie = []; }
					 */
					/*
					 * yourModule .config(function($httpProvider){ delete
					 * $httpProvider.defaults.headers.common['X-Requested-With'];
					 * });
					 */
					/*
					 * $.ajax({ type: "get", crossDomain: true, url:
					 * "http://test.reminiscens.me/lifeapi/person/3/timeline" ,
					 * datatype: "jsonp", contentType: "application/json;
					 * charset=utf-8", error: function(request,error){
					 * alert(error); }, success: function(request) {
					 * alert(request); } });
					 */

					/*
					 * $.getJSON(
					 * 'http://test.reminiscens.me/lifeapi/person/3/timeline',
					 * function ( data ) { alert ( data ); } );
					 */

					/*
					 * var request = createCORSRequest("get",
					 * "http://test.reminiscens.me/lifeapi/person/3/timeline");
					 * 
					 * if (request){ request.onload = function(){
					 * alert(this.responseText); }; request.send(); }
					 */

					var jsonObj = new Object;

					jsonObj.titolo = "Foto 1";
					jsonObj.dove = "";
					jsonObj.quando = "";
					jsonObj.testo = "2 ottobre 1950 - nasce il fumetto Charlie Brown, dalla penna di Charles M. Schulz...";

					var vettImm = [];
					var Imm = new Object;
					Imm.src = "img/comera1.jpg";
					vettImm.push(Imm);
					jsonObj.immagini = vettImm;
					Storie.push(jsonObj);

					// alert(Storie[0].titolo);

					var jsonObj = new Object;

					jsonObj.titolo = "Foto 2";
					jsonObj.dove = "";
					jsonObj.quando = "";
					jsonObj.testo = "09 maggio 1950 - Nasce la comunit��  europea...";

					var vettImm = [];
					var Imm = new Object;
					Imm.src = "img/comera3.jpg";
					vettImm.push(Imm);
					jsonObj.immagini = vettImm;
					Storie.push(jsonObj);

					var jsonObj = new Object;

					jsonObj.titolo = "Foto 3";
					jsonObj.dove = "";
					jsonObj.quando = "";
					jsonObj.testo = "26 gennaio 1950 - L'india diventa una repubblica..";

					var vettImm = [];
					var Imm = new Object;
					Imm.src = "img/comera2.jpg";
					vettImm.push(Imm);
					jsonObj.immagini = vettImm;
					Storie.push(jsonObj);

					//<a class="fancybox" rel="gallery1" href="img/tuefoto1.jpg" title="Foto 1"> <img src="img/tuefoto1.jpg" alt="" /> </a> 
					// alert(Storie[0].immagini[0].src);
					/*
					 * <div class="immagini"> <div class="text"> 26 gennaio 1950 -
					 * L'india diventa una repubblica </div> <img
					 * src="img/comera2.jpg" /> </div>
					 */
					for (i = 0; i < Storie.length; i++) {
						document.getElementById("divFotoDelTempo").innerHTML += "<a class='fancybox' rel='gallery1' href='"
								+ Storie[i].immagini[0].src
								+ "' title='"
								+ Storie[i].titolo
								+ "' > <img src='"
								+ Storie[i].immagini[0].src
								+ "' alt='' /> </a>";
						document.getElementById("divStorieDelTempo").innerHTML += "<div class='immagini'><div class='text'>"
								+ Storie[i].testo
								+ "</div><a class='fancybox' rel='gallery2' href='"
								+ Storie[i].immagini[0].src
								+ "' title='"
								+ Storie[i].titolo
								+ "' > <img src='"
								+ Storie[i].immagini[0].src
								+ "' alt='' /> </a></div>";
					}

					Login();
					getTimeline();

					/*$(".fancybox").fancybox({
						'showCloseButton'	: false,
						afterLoad : function() {
								this.title = "<div><h1>" + Storie[this.index].titolo +"</h1> <h5>" + Storie[this.index].testo + "</h5> </div>";
							//this.title = "<div><h1>" + "hola" +"</h1> </div>";
						},
						'helpers' : { 
							title : { type : 'inside' }
						} // helpers
					});*/
				});