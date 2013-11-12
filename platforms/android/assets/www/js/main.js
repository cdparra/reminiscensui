/**
 * Main application javascript script of the reminiscens UI. 
 * 
 * This file is loaded on the main.html and makes all the calls to the reminiscens API
 * and loads all the data in the timeline
 * 
 * 
 */

/**
 * Function called to create the event listener that will fire when the mobile 
 * device is ready for phonegap
 */
function onLoad() {
	document.addEventListener("deviceready", onDeviceReady, true);
}

/**
 * when the mobile device is ready, this function will make the main configurations
 */
function onDeviceReady() {
	console.log("PhoneGap is working!!");
	pictureSource = navigator.camera.PictureSourceType;
	destinationType = navigator.camera.DestinationType;
}

/**
 * Attaching the editor elemento to the kendoEditor value
 */
function editor() {
	var editor = $("#editor").data("kendoEditor");
	//alert(editor.value());
	$("#debug").text(editor.value());
}

var tokern;							// 
var Context = new Object;			// object containing the context model
var MieStorie = new Object;			// object containing the stories of the person in the timeline
var NumeroPaginaMieStorie = 0;	
var NumeroPaginaMieFoto = 0;
var decade;
var MieStorieVisible = [];			// object containing currently visible stories
var ContextVisible = new Object;	
var sessionKey;
var personId;
var imgStoriaUrl = [];
var imgStoriaUrlHtml = [];
var imgStoriaHashcode = [];
var imgStoriaFilename = [];
var imgStoriaThumbnailUrl = [];
var imgStoriaModifyId = [];
var imgStoriaModifyMementoId = [];
var firstDeacade;
var personalQuestion = [];
var decadeQuestion = [];
var decadeSelect = "";
var yearSelect = "";
var monthSelect = "";
var daySelect = "";
var vettIndexMieStorieVisible = [];
var vettIndexFotoContextVisible = [];
var cities = [];
var isModify = false;
var idStoryModify = null;
var indexModify;
var idContextRaccontaci = null;
var birthYear;
var isFirstOpen = true;

//statistiche
var indexCarouselFoto = 0;
var indexCarouselStorie = 0;
var indexCarouselCanzoni = 0;
var indexCarouselTv = 0;
var indexCarouselFamosi = 0;
var indexCarouselRandom = 0;
var views = {};
var detailViews = {};
1

//"responsive"
var numFotoPerPag;
var isContext = true;
var isQuestion = true;
var isContextv2 = false;

var titleBox;

var timer;

function statisticheDETAILVIEWS(publicMementoId) {
	// instead of calling the service, let's just count in a hash table which we will later send in one post 
	if (detailViews[publicMementoId + ""] == null) {
		detailViews[publicMementoId + ""] = 1;
	} else {
		detailViews[publicMementoId + ""]++;
	}
	///log/DETAILVIEWS/context/{context_id}/memento/{public_memento_id}
	$.ajax({
		type : "POST",
		beforeSend : function(request) {
			request.setRequestHeader("PLAY_SESSION", GetSessionKey());
		},
		url : GetBaseUrl() + "/lifeapi/log/DETAILVIEWS/context/"
				+ GetContextId() + "/memento/" + publicMementoId,
		data : "{}",
		dataType : "json",
		contentType : "application/json",
		//      async: false,
		success : function(data) {
			//          alert("hola");
		},
		error : function(data) {
			//alert("Errore nel passaggio di statistiche");
			console.log("Errore nel passaggio di statistiche");
		}
	});
}

function aggiungiEventoFancyBox() {
	$(".fancyboxFotoContext")
			.fancybox(
					{
						'showCloseButton' : false,
						afterLoad : function(current, previous) {
							//alert(this.index);
							//alert(vettIndexFotoContextVisible[this.index]);
							this.title = "<div><h1>"
									+ ContextVisible.picture[this.index].headline
									+ "</h1><h5>"
									+ ContextVisible.picture[this.index].text
									+ "</h5> <span> Ti viene in mente qualcosa? </span> <button class='btn btn-primary' onClick='ApriOverlay("
									+ ContextVisible.picture[this.index].publicMementoId
									+ ");'>Raccontaci!</button> </div>";
							statisticheDETAILVIEWS(ContextVisible.picture[this.index].publicMementoId);
						},
						'helpers' : {
							title : {
								type : 'inside'
							}
						}
					// helpers
					});

	$(".fancyboxStorieContext")
			.fancybox(
					{
						'showCloseButton' : false,
						afterLoad : function(current, previous) {
							//alert(this.index);
							//alert(vettIndexFotoContextVisible[this.index]);
							this.title = "<div><h1>"
									+ ContextVisible.story[this.index].headline
									+ "</h1><h5>"
									+ ContextVisible.story[this.index].text
									+ "</h5> <span> Ti viene in mente qualcosa? </span> <button class='btn btn-primary' onClick='ApriOverlay("
									+ ContextVisible.story[this.index].publicMementoId
									+ ");'>Raccontaci!</button> </div>";
							statisticheDETAILVIEWS(ContextVisible.story[this.index].publicMementoId);
						},
						'helpers' : {
							title : {
								type : 'inside'
							}
						}
					// helpers
					});

	$(".fancyboxMieFoto")
			.fancybox(
					{
						'showCloseButton' : false,
						afterLoad: function () {
							console.log(vettIndexMieStorieVisible[this.index]);
							this.title = "<div><h1>"
									+ MieStorieVisible[vettIndexMieStorieVisible[this.index]].headline
									+ "</h1><h5>"
									+ MieStorieVisible[vettIndexMieStorieVisible[this.index]].text
									+ "</h5><br>  <button class='btn btn-primary' onClick='ApriOverlayModifica("
									+ vettIndexMieStorieVisible[this.index]
									+ ");'>Modifica</button>&nbsp;"
									+ "<button class='btn btn-danger' onClick='DeleteStory("
									+ this.index
									+ ");'>Cancella la Storia</button></div>";
						},
						'helpers' : {
							title : {
								type : 'inside'
							}
						}
					// helpers
					});

	$(".fancyboxMieStorie")
			.fancybox(
					{
						'showCloseButton' : false,
						afterLoad : function() {
							this.title = "<div><h1>"
									+ MieStorieVisible[this.index].headline
									+ "</h1><h5>"
									+ MieStorieVisible[this.index].text
									+ "</h5><br>  <button class='btn btn-primary' onClick='ApriOverlayModifica("
									+ this.index
									+ ");'>Modifica</button>&nbsp;"
									+ "<button class='btn btn-danger' onClick='DeleteStory("
									+ this.index
									+ ");'>Cancella la Storia</button></div>";
							//this.title = "<div><h1>" + "hola" +"</h1> </div>";
						},
						'helpers' : {
							title : {
								type : 'inside'
							}
						}
					// helpers
					});

	$(".fancyboxRaccontaci").fancybox({
		'showCloseButton' : false
	/*afterLoad: function () {
	    this.title = "<div><h1>" + MieStorieVisible[this.index].headline + "</h1><h5>" + MieStorieVisible[this.index].text + "</h5><br>  <button class='btn btn-primary' onClick='ApriOverlayModifica(" + this.index + ");'>Modifica</button></div>";
	    //this.title = "<div><h1>" + "hola" +"</h1> </div>";
	},*/
	/*'helpers': {
	    title: { type: 'inside' }
	}*/// helpers
	});
}

/*$(document).ready(function() {
    var cities = [];
    var idCities = [];
    var tmp = $.getJSON('json/cities.json',function(tmp)
    { //return timeline             
        for (var i = 0; i < tmp.length; i++) {
            //alert(tmp[i].name);
            cities.push(tmp[i].name);
            idCities.push(tmp[i].cityId);
        }
        
        $('#dove').autocomplete({
            source:cities,
            minLength: 3 
        });     
    
    });
    
});*/

function InizializzaValueLocationAndDate() {
	document.getElementById("decade").innerHTML = "";
	var j = 1;
	document.getElementById("decade").innerHTML += "<option value='" + 0 + "'>"
			+ "decade" + "</option>";
	for (var i = 1900; i <= 2020; i = i + 10) {
		document.getElementById("decade").innerHTML += "<option value='" + j
				+ "'>" + i + "</option>";
		j++;
	}

	document.getElementById("country").innerHTML = "";
	document.getElementById("country").innerHTML += "<option value='" + 0
			+ "'>" + "nazione" + "</option>";
	document.getElementById("country").innerHTML += "<option value='" + 1
			+ "'>" + "Italia" + "</option>";

	//inizializzo le citta in raccontaci
	/*var tmp = $.getJSON('json/cities.json', function (tmp) { //return timeline                
	    for (var i = 0; i < tmp.length; i++) {
	        //alert(tmp[i].name);
	        cities.push(tmp[i].name);
	        //idCities.push(tmp[i].cityId);
	    }

	    $('#city').autocomplete({
	        source: cities,
	        minLength: 3,
	        messages: {
	            noResults: '',
	            results: function () { }
	        }
	    });

	});*/

	//inizializza lista mesi in raccontaci
	document.getElementById("month").innerHTML = "";
	document.getElementById("month").innerHTML += "<option value='" + 0 + "'>"
			+ "mese" + "</option>";
	/*var tmp = $.getJSON('json/month.json', function (tmp) { //return timeline               
	    for (var i = 1; i < tmp.length + 1; i++) {
	        document.getElementById("month").innerHTML += "<option value='" + i + "'>" + tmp[i - 1].name + "</option>";
	    }
	});*/
	for (var i = 1; i <= 12; i++) {
		document.getElementById("month").innerHTML += "<option value='" + i
				+ "'>" + i + "</option>";
	}

	document.getElementById("day").innerHTML += "<option value='" + 0 + "'>"
			+ "giorno" + "</option>";
}

$(document).ready(
				function() {
					//se e' la prima volta che entro nell'app devo creare l'oggetto immaginiLocali per salavare le immagini in locale
					var localStorage = $.localStorage;
					var immaginiPrivate = localStorage.get("immaginiPrivate");
					var immaginiPubbliche = localStorage.get("immaginiPubbliche");
					if (immaginiPrivate == null)
						localStorage.set("immaginiPrivate", new Object());
					if (immaginiPubbliche == null)
						localStorage.set("immaginiPubbliche", new Object());

					//timer
					timer = setInterval(function() {
						StorySynchronize();
					}, 1000 * 60 * 5);

					//switch
					$('#raccontaci-switch')
							.on(
									'switch-change',
									function(e, data) {
										var $el = $(data.el), value = data.value;
										//console.log(value);
										if (value) //storia personale
										{
											document
													.getElementById("divPrivateMemento").style.display = "inherit";
											document
													.getElementById("divPublicMemento").style.display = "none";
											//$("#salva").click(salvaStoria());
											document.getElementById("salva").onclick = function() {
												salvaStoria();
											};
											document.getElementById("titleBox").innerHTML = titleBox;
										} else //storia pubblica
										{
											document
													.getElementById("divPrivateMemento").style.display = "none";
											document
													.getElementById("divPublicMemento").style.display = "inherit";
											//$("#salva").click(PostMemento());
											document.getElementById("salva").onclick = function() {
												PostMemento()
											};
											document.getElementById("titleBox").innerHTML = "Raccontaci una storia pubblica";
										}
									});

					//initializePublicMementoConnection();
					InizializzaValueLocationAndDate();

					//gestisco la visualizzazione a seconda della versione della App scelta dall'utente
					if (GetAppVersion() == 1) {
						//non faccio niente
						numFotoPerPag = 4;
					} else if (GetAppVersion() == 2) {
						//nascondo le domande
						/*document.getElementById("divFirstDecadeQuestionEmpty").style.display = "none";
						document.getElementById("divSecondDecadeQuestionEmpty").style.display = "none";
						document.getElementById("divFirstPersonalQuestionEmpty").style.display = "none";
						document.getElementById("divSecondPersonalQuestionEmpty").style.display = "none";
						document.getElementById("divDecadeQuestionNotEmpty").style.display = "none";
						document.getElementById("idPersonalQuestionNotEmpty").style.display = "none";*/
						document.getElementById("divQuestionNotEmpty").style.display = "none";
						document.getElementById("divQuestionEmpty").style.display = "none";

						//sistemo il css
						$(".divFoto").css({
							"margin-top" : 30 + "px"

						});
						$(".divCanzoni").css({
							"margin-top" : 30 + "px"

						});

						numFotoPerPag = 4;
						isQuestion = false;
					} else if (GetAppVersion() == 3) {
						//nascondo il contesto
						document.getElementById("divRootFotoDelTempo").style.display = "none";
						document.getElementById("divRootStorieDelTempo").style.display = "none";
						document.getElementById("Canzoni").style.display = "none";
						document.getElementById("TvFilm").style.display = "none";
						document.getElementById("Famosi").style.display = "none";

						//sistemo il css
						$(".divFoto").css({
							"width" : 1000 + "px"
						});

						numFotoPerPag = 8;
						isContext = false;
					} else if (GetAppVersion() == 4) {
						/*document.getElementById("divFirstDecadeQuestionEmpty").style.display = "none";
						document.getElementById("divSecondDecadeQuestionEmpty").style.display = "none";
						document.getElementById("divFirstPersonalQuestionEmpty").style.display = "none";
						document.getElementById("divSecondPersonalQuestionEmpty").style.display = "none";
						document.getElementById("divDecadeQuestionNotEmpty").style.display = "none";
						document.getElementById("idPersonalQuestionNotEmpty").style.display = "none";*/
						document.getElementById("divQuestionNotEmpty").style.display = "none";
						document.getElementById("divQuestionEmpty").style.display = "none";

						document.getElementById("divRootFotoDelTempo").style.display = "none";
						document.getElementById("divRootStorieDelTempo").style.display = "none";
						document.getElementById("Canzoni").style.display = "none";
						document.getElementById("TvFilm").style.display = "none";
						document.getElementById("Famosi").style.display = "none";

						//sistemo il css
						$(".divFoto").css({
							"margin-top" : 30 + "px"

						});
						$(".divCanzoni").css({
							"margin-top" : 30 + "px"

						});
						$(".divFoto").css({
							"width" : 1000 + "px"
						});

						numFotoPerPag = 8;
						isContext = false;
						isQuestion = false;
					} else if (GetAppVersion() == 5) { //versione con contesto random e mostro anche domande
					    document.getElementById("Canzoni").style.display = "none";
					    document.getElementById("TvFilm").style.display = "none";
					    document.getElementById("Famosi").style.display = "none";

					    numFotoPerPag = 4;
					    isContextv2 = true;
					    isContext = false;
					    
					} else if (GetAppVersion() == 6) {
					    document.getElementById("divQuestionNotEmpty").style.display = "none";
					    document.getElementById("divQuestionEmpty").style.display = "none";

					    document.getElementById("Canzoni").style.display = "none";
					    document.getElementById("TvFilm").style.display = "none";
					    document.getElementById("Famosi").style.display = "none";

					    numFotoPerPag = 4;
					    isContextv2 = true;
					    isContext = false;

					    //sistemo il css
					    $(".divFoto").css({
					        "margin-top": 30 + "px"

					    });
					    $(".divCanzoni").css({
					        "margin-top": 30 + "px"

					    });
					}



					//inserisco nel menu' le voci canzoni, famosi, tv se visualizzo il contesto
					//<li id="liCanzoni"><a href="#">Canzoni</a></li>
					//                    <li id="liFamosi"><a href="#">Famosi</a></li>
					//                    <li id="liTvFilm"><a href="#">TV/Film</a></li>
					//<li id="liRaccontaci"><a href="#">Raccontaci</a></li>
					//<li id="liLogout"><a href="#">Esci</a></li>
					//<li id="liRefresh"><a href="#">Aggiorna</a></li>
					if (isContext) {
						document.getElementById("ulMenu").innerHTML += "<li id='liCanzoni'><a href='#'>Canzoni</a></li>";
						document.getElementById("ulMenu").innerHTML += "<li id='liFamosi'><a href='#'>Famosi</a></li>";
						document.getElementById("ulMenu").innerHTML += "<li id='liTvFilm'><a href='#'>TV/Film</a></li>";
						//document.getElementById("ulMenu").innerHTML += "<li id='liRaccontaci'><a href='#'>Raccontaci</a></li>";
						//document.getElementById("ulMenu").innerHTML += "<li id='liLogout'><a href='#'>Esci</a></li>";
						//document.getElementById("ulMenu").innerHTML += "<li id='liRefresh'><a href='#'>Aggiorna</a></li>";
					}
					//else
					//{
					//    document.getElementById("ulMenu").innerHTML += "<li id='liRaccontaci'><a href='#'>Raccontaci</a></li>";
					//    document.getElementById("ulMenu").innerHTML += "<li id='liLogout'><a href='#'>Esci</a></li>";
					//    document.getElementById("ulMenu").innerHTML += "<li id='liRefresh'><a href='#'>Aggiorna</a></li>";
					//}

					/*applica la classe active al menu nav bar di bootstrap quando viene cliccato*/
					$('.navbar li')
							.click(
									function(e) {
										$('.navbar li').removeClass('active');
										var $this = $(this);
										if (!$this.hasClass('active')) {
											$this.addClass('active');
										}
										var tmp = $this.attr("id");
										tmp = tmp.substring(2, tmp.length);
										if (tmp == "Logout") {
											Logout();
										} else if (tmp == "Raccontaci") {
											ApriOverlay();
										} else if (tmp == "Refresh") {
											ReloadReminiscens();
										} else {
											nascondiDiv();
											document.getElementById(tmp).style.display = "inherit";
											//gestione statistiche
											if (isContext) {
												switch (tmp) {
												case "Foto":
													for (var i = indexCarouselFoto * 4; i < ((indexCarouselFoto * 4) + 4); i++) {
														if (ContextVisible.picture[i] == null) {
															//alert(indexCarouselFoto);
															break;
														} else {
															statisticaVIEWS(ContextVisible.picture[i].publicMementoId);
														}
													}
													break;
												case "Storie":
													for (var i = indexCarouselStorie * 2; i < ((indexCarouselStorie * 2) + 2); i++) {
														if (ContextVisible.story[i] == null) {
															//alert(indexCarouselFoto);
															break;
														} else {
															statisticaVIEWS(ContextVisible.story[i].publicMementoId);
														}
													}
													break;
												case "Canzoni":
													for (var i = indexCarouselCanzoni * 2; i < ((indexCarouselCanzoni * 2) + 2); i++) {
														if (ContextVisible.song[i] == null) {
															//alert(indexCarouselFoto);
															break;
														} else {
															statisticaVIEWS(ContextVisible.song[i].publicMementoId);
														}
													}
													break;
												case "TvFilm":
													for (var i = indexCarouselTv * 2; i < ((indexCarouselTv * 2) + 2); i++) {
														if (ContextVisible.tvFilm[i] == null) {
															//alert(indexCarouselFoto);
															break;
														} else {
															statisticaVIEWS(ContextVisible.tvFilm[i].publicMementoId);
														}
													}
													break;
												case "Famosi":
													for (var i = indexCarouselFamosi * 2; i < ((indexCarouselFamosi * 2) + 2); i++) {
														if (ContextVisible.people[i] == null) {
															//alert(indexCarouselFoto);
															break;
														} else {
															statisticaVIEWS(ContextVisible.people[i].publicMementoId);
														}
													}
													break;
												}
											}
										}

										e.preventDefault();
									});

					//var storage =$.localStorage;
					sessionKey = GetSessionKey();
					personId = GetPersonId();
					birthYear = GetPersonYearBirthDate();

					$.ajaxSetup({
						beforeSend : function(xhr) {
							xhr.setRequestHeader("PLAY_SESSION", sessionKey);
						}
					});
					//alert(birthYear);
					//alert(personId);
					//alert(sessionKey);        

					//decade = 1940;
					decade = GetPersonDeacadeBirthDate();
					//alert(decade);
					$("#lbldebug").text(
							"Non ci sono ancora storie del " + decade + "!");
					$("#FotoDelTempo").text(
							"Foto pubbliche attorno al " + decade);
					$("#TueFotoDelTempo").text(
							"Le tue foto attorno al " + decade);
					$("#StorieDelTempo").text(
							"Che cosa succedeva nel " + decade);
					$("#TueStorieDelTempo").text("Le tue storie nel " + decade);

					//Login();
					Timeline();

					if (isContext || isContextv2) {
					    ContextFunction();
					}

					//firstDecade = GetFirstDecade(GetPersonDeacadeBirthDate()); //recupero la prima decade che compare nella timeline (guardo la prima che ha una storia raccontata)
					//alert(firstDecade);

					//CreaTimelineCarousel(firstDecade);

					//decade = firstDeacade;
					//downloadQuestion(birthYear, decade);

					//GestioneSchermate(firstDecade);
				});

function YearToDecade(anno) {
	var tmp = anno / 10;
	//alert(parseInt(tmp));
	return parseInt(tmp) * 10;
}

function VisualizzaYear() {
    //console.log("visualizzayear()");
	//alert(document.getElementById("decade").item(document.getElementById("decade").value).text);
	//alert(document.getElementById("decade").value);
	if (document.getElementById("decade").value != 0) {
		document.getElementById("year").innerHTML = "";
		var decadeSelect = parseInt(document.getElementById("decade").item(document.getElementById("decade").value).text);
		var j = 1;
		document.getElementById("year").innerHTML += "<option value='" + 0
				+ "'>" + "anno" + "</option>";
		for (var i = decadeSelect; i <= decadeSelect + 9; i++) {
			document.getElementById("year").innerHTML += "<option value='" + j
					+ "'>" + i + "</option>";
			j++;
		}
		$('#year').fadeIn('slow');
	}
}

function VisualizzaMonth() {
	//alert(document.getElementById("decade").item(document.getElementById("decade").value).text);
	if (document.getElementById("year").value != 0) {
		//yearSelect = parseInt(document.getElementById("year").item(document.getElementById("year").value).text);
		$('#month').fadeIn('slow');
	}
}

function VisualizzaDay() {
	//alert(document.getElementById("decade").item(document.getElementById("decade").value).text);
	if (document.getElementById("month").value != 0) {
		document.getElementById("day").innerHTML = "";
		var monthSelect = parseInt(document.getElementById("month").value);
		var j = 1;
		document.getElementById("day").innerHTML += "<option value='" + 0
				+ "'>" + "giorno" + "</option>";
		/*for(var i = 1;i <= 31;i++)
		{
		    document.getElementById("day").innerHTML += "<option value='" + i +"'>" + i + "</option>";
		    j++;
		}*/
		switch (monthSelect) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			for (var i = 1; i <= 31; i++) {
				document.getElementById("day").innerHTML += "<option value='"
						+ i + "'>" + i + "</option>";
				j++;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			for (var i = 1; i <= 30; i++) {
				document.getElementById("day").innerHTML += "<option value='"
						+ i + "'>" + i + "</option>";
				j++;
			}
			break;
		case 2:
			for (var i = 1; i <= 28; i++) {
				document.getElementById("day").innerHTML += "<option value='"
						+ i + "'>" + i + "</option>";
				j++;
			}
			break;
		}

		$('#day').fadeIn('slow');
	}
}

function VisualizzaCity() {
	//if (document.getElementById("country").value != 0) {
	//    //document.getElementById("city").innerHTML = "";
	//    countrySelect = document.getElementById("country").item(document.getElementById("country").value).text;
	//    /*document.getElementById("city").innerHTML += "<option value='" + 0 +"'>" + "citta + "</option>";
	//    var cities = $.getJSON('json/cities.json',function(cities)
	//    { //return timeline

	//        //alert(tmp.length);    
	//        for (var i = 1; i < 40+1; i++) {
	//            document.getElementById("city").innerHTML += "<option value='" + i +"'>" + cities[i-1].name + "</option>";
	//        }
	//    });*/
	//    $('#city').fadeIn('slow');
	//}

	countrySelect = $("#country").val();
	$('#city').fadeIn('slow');
}

function ControllaEsistenzaCitta() {
	for (var i = 0; i < cities.length; i++) {
		if ($("#city").val() == cities[i])
			return true;
	}
	return false;
}

function VisualizzaPlaceName() {
	//if (ControllaEsistenzaCitta()) {
	//citySelect = document.getElementById("city").item(document.getElementById("city").value).text;
	citySelect = $("#city").val();
	$('#placeName').fadeIn('slow');
	//}
}

function Prova() {
	//$('#divMieFotoDelTempo').carousel(2);
	//$('centrale').scrollLeft('5000px');
	/*var myCont = document.getElementById ("divRoot");
	myCont.scrollTop += 100;*/
	//alert('ciao');
	//$("#divMieFotoDelTempo").carousel('next');
}
