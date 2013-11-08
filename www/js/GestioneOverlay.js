function AzzeraVariabiliOverlay() {
	InizializzaValueLocationAndDate();

	//azzero variabili immagini
	imgStoriaUrl = [];
	imgStoriaHashcode = [];
	imgStoriaFilename = [];
	imgStoriaUrlHtml = [];
	imgStoriaModifyId = [];
	imgStoriaModifyMementoId = [];

	decadeSelect = "";
	yearSelect = "";
	monthSelect = "";
	daySelect = "";
	countrySelect = "";
	placeNameSelect = "";
	citySelect = "";

	//$("#city").hide();
	document.getElementById("country").value = "";
	document.getElementById("region").value = "";
	document.getElementById("city").value = "";
	$("#placeName").val(""); // Why sometimes using JQuery and some others document.getElementById?
	//$("#placeName").hide();

	//$("#year").hide();
	document.getElementById("year").value = 0;
	//$("#month").hide();
	document.getElementById("month").value = 0;
	//$("#day").hide();
	document.getElementById("day").value = 0;

	document.getElementById("titolo").value = "";
	//document.getElementById("dove").value = "";
	//document.getElementById("quando").value = "";
	document.getElementById("imgInput").innerHTML = "";
	var editor = $("#editor").data("kendoEditor");
	editor.value("");

	//public memento
	headline = $("#headline").val("");
	$("#text").val("");
	$("#countryPublic").val("");
	$("#regionPublic").val("");
	$("#cityPublic").val("");
	$("#yearPublic").val("");
	$("#monthPublic").val("");
	$("#dayPublic").val("");
	$("#resourceUrl").val("");
	$("#author").val("");
	$("#category").val("SONG");
	$("#sourceUrl").val("");
	$("#resourceType").val("IMAGE");

	document.getElementById("divPrivateMemento").style.display = "inherit";
	document.getElementById("divPublicMemento").style.display = "none";

	//azzero switch
	$('#raccontaci-switch').bootstrapSwitch('setState', true);
	$('#overlay').fadeOut('fast');
	$('#box').hide();
}

$(document).ready(function() {
	$(".chiudi").click(function() {
		if (!confirm('Sicuro di voler uscire dal raccontaci?')) {
			return;
		}
		AzzeraVariabiliOverlay();

		/*
		 * $('#overlay').fadeOut('fast'); $('#box').hide();
		 */
	});

	// chiusura emergenza
	$("#overlay").click(function() {
		if (!confirm('Sicuro di voler uscire dal raccontaci?')) {
			return;
		}
		AzzeraVariabiliOverlay();
		/*
		 * $(this).fadeOut('fast'); $('#box').hide();
		 */
	});
});

function CentroOverlay() {

	// imposto la finestra sempre in mezzo!!!
	/*
	 * var PosX = ($(window).width() - $("#box").width()) / 2; var percentualeX =
	 * PosX / $(window).width() * 100; $("#box").css({ "left": percentualeX +
	 * "%" });
	 * 
	 * //alert var PosY = ($(window).height() - $("#box").height()) / 2; var
	 * percentualeY = PosY / $(window).height() * 100; $("#box").css({ "top":
	 * percentualeY + "%" });
	 */
	/*var width = $("#box").width();
	var PosX = ($(window).width() - width) / 2;
	var percentualeX = PosX / $(window).width() * 100;
	$("#box").css({
	    "left": percentualeX + "%"
	});*/

	//alert
	/*var height = $("#box").height() + 50;
	var PosY = ($(window).height() - height) / 2;
	var percentualeY = PosY / $(window).height() * 100;
	$("#box").css({
	    "top": percentualeY + "%"
	});*/
	/*$("#box").css({
	    "top": 25
	});*/
}

function CentroCaricamento() {

	//imposto la finestra sempre in mezzo!!!
	var PosX = ($(window).width() - $("#caricamento").width()) / 2;
	var percentualeX = PosX / $(window).width() * 100;
	$("#caricamento").css({
		"left" : percentualeX + "%"
	});

	//alert
	var PosY = ($(window).height() - $("#caricamento").height()) / 2;
	var percentualeY = PosY / $(window).height() * 100;
	$("#caricamento").css({
		"top" : percentualeY + "%"
	});
}

//controllo se la finestra stata ridimensionata con jquery
jQuery(window).bind('resize', function() {
	CentroOverlay();
	CentroCaricamento();
});

function ApriOverlay(clicked_id) {
	//se per caso apro l'overlay da un bottone Raccontaci! nella galleria fancybox
	parent.$.fancybox.close();

	//inizializzo la decade con la decade dove mi trovo
	document.getElementById("decade").value = ((decade - 1900) / 10) + 1;
	VisualizzaYear();

	//alert(clicked_id);
	idStoryModify = null;
	isModify = false;
	indexModify = null;

	if (clicked_id == null) {
		$("#titleBox").html("raccontaci la tua storia");
	} else if (clicked_id == "QuestionNotEmpty"
			|| clicked_id == "QuestionEmpty") //caso in cui arrivo da una domanda
	{
		//alert(clicked_id);
		$("#titleBox").html(document.getElementById(clicked_id).innerHTML);
		cameToQuestion = true;
		//switch (clicked_id)
		//{
		//    case "QuestionNotEmpty":
		//        cameToQuestion = true;
		//        break;
		//    case "QuestionNotEmpty":
		//        cameToQuestion = true;
		//        break;
		//}
		//alert("question: " + idQuestion);
		//downloadQuestion(birthYear,decade);
	} else //caso in cui arrivo da un context
	{
		idContextRaccontaci = clicked_id;
		//alert(idContextRaccontaci);
	}
	titleBox = document.getElementById("titleBox").innerHTML;
	CentroOverlay();
	$('#overlay').fadeIn('fast');
	$('#box').fadeIn('slow');
}

function ApriOverlayModifica(index) {
	idStoryModify = MieStorieVisible[index].lifeStoryId;
	isModify = true;
	indexModify = index;

	//controllo se avevo risposto a una domanda
	//alert(MieStorieVisible[index].questionId);
	if (MieStorieVisible[index].questionId != null) {
		$.ajax({
			type : "GET",
			async : false,
			beforeSend : function(request) {
				request.setRequestHeader("PLAY_SESSION", GetSessionKey());
			},
			url : GetBaseUrl() + "/lifeapi/question/"
					+ MieStorieVisible[index].questionId,
			success : function(data) {
				console.log("Reading question related to story '"+MieStorieVisible[index].headline+"'");
				$("#titleBox").html(data.translations[0].question_text);
			},
			error : function(data) {
				console.log("Errore nel recupero della domanda");
			}
		});
	}

	parent.$.fancybox.close(); //chiudo la galleria
	document.getElementById("titolo").value = MieStorieVisible[index].headline;
	//alert(MieStorieVisible[index].mementoList.length);
	document.getElementById("imgInput").innerHTML = "";
	for (var i = 0; i < MieStorieVisible[index].mementoList.length; i++) {
		//alert(MieStorieVisible[index].mementoList[i].thumbnailUrl);
		imgStoriaUrl.push(MieStorieVisible[index].mementoList[i].url);
		imgStoriaHashcode
				.push(MieStorieVisible[index].mementoList[i].fileHashcode);
		imgStoriaFilename.push(MieStorieVisible[index].mementoList[i].fileName);
		imgStoriaUrlHtml.push(GetBaseUrl() + "/files/SMALL_"
				+ MieStorieVisible[index].mementoList[i].fileName);
		imgStoriaModifyMementoId
				.push(MieStorieVisible[index].mementoList[i].mementoId);
		imgStoriaModifyId.push(MieStorieVisible[index].lifeStoryId);
		document.getElementById("imgInput").innerHTML += "<div id='"
				+ "divImg"
				+ i
				+ "' style='float:left; margin:15px; position:relative; display:inline-block;'><a class='fancyboxRaccontaci' rel='gallery2' href='"
				+ GetBaseUrl()
				+ "/files/LARGE_"
				+ MieStorieVisible[index].mementoList[i].fileName
				+ "' > <img style=' max-height:200px;max-width:200px;' src='"
				+ GetBaseUrl()
				+ "/files/SMALL_"
				+ MieStorieVisible[index].mementoList[i].fileName
				+ "' /></a><img src='images/Ximm.png' style='position:absolute;right:-12.5px; top:-12.5px;  cursor:pointer;' onclick='eliminaImmagine("
				+ i + "," + index + ")'/></div>";
	}
	aggiungiEventoFancyBox();

	if (MieStorieVisible[index].text != null) {
		var editor = $("#editor").data("kendoEditor");
		editor.value(MieStorieVisible[index].text);
	}

	//location
	if (MieStorieVisible[index].location.country != null) {
		document.getElementById("country").value = MieStorieVisible[index].location.country;
		//VisualizzaCity();
	}
	if (MieStorieVisible[index].location.region != null) {
		//$('#city').fadeIn('fast');		
		document.getElementById("region").value = MieStorieVisible[index].location.region;
		//VisualizzaPlaceName();
	}
	if (MieStorieVisible[index].location.city != null) {
		//$('#city').fadeIn('fast');		
		document.getElementById("city").value = MieStorieVisible[index].location.city;
		//VisualizzaPlaceName();
	}
	if (MieStorieVisible[index].location.placeName != null) {

		document.getElementById("placeName").value = MieStorieVisible[index].location.placeName;
	}

	//date
	//alert(MieStorieVisible[index].startDate.decade);
	document.getElementById("decade").value = (MieStorieVisible[index].startDate.decade - 1900) / 10 + 1;
	VisualizzaYear();

	if (MieStorieVisible[index].startDate.year != null) {
		document.getElementById("year").value = (MieStorieVisible[index].startDate.year - MieStorieVisible[index].startDate.decade) + 1;
		VisualizzaMonth();
	}

	if (MieStorieVisible[index].startDate.month != null) {
		document.getElementById("month").value = MieStorieVisible[index].startDate.month;
		VisualizzaDay();
	}

	if (MieStorieVisible[index].startDate.day != null) {
		document.getElementById("day").value = MieStorieVisible[index].startDate.day;
	}

	CentroOverlay();
	$('#overlay').fadeIn('fast');
	$('#box').fadeIn('slow');
}

function eliminaImmagine(index, indexStoriaVisible) {
	console.log(index);
	if (!confirm('Sicuro di voler eliminare l\'immagine?')) {
		return;
	}
	imgStoriaUrl.splice(index, 1);
	imgStoriaUrlHtml.splice(index, 1);
	imgStoriaHashcode.splice(index, 1);
	imgStoriaFilename.splice(index, 1);

	document.getElementById("imgInput").innerHTML = "";

	for (var i = 0; i < imgStoriaFilename.length; i++) {
		console.log(imgStoriaFilename[i]);
		document.getElementById("imgInput").innerHTML += "<div id='"
				+ "divImg"
				+ i
				+ "' style='float:left; margin:15px; position:relative; display:inline-block;'><a class='fancyboxRaccontaci' rel='gallery2' href='"
				+ GetBaseUrl()
				+ "/files/LARGE_"
				+ imgStoriaFilename[i]
				+ "' > <img style=' max-height:200px;max-width:200px;' src='"
				+ GetBaseUrl()
				+ "/files/SMALL_"
				+ imgStoriaFilename[i]
				+ "' /></a><img src='images/Ximm.png' style='position:absolute;right:-12.5px; top:-12.5px;  cursor:pointer;' onclick='eliminaImmagine("
				+ i + "," + indexStoriaVisible + ")'/></div>";
		//aggiungiEventoFancyBox();
	}
	aggiungiEventoFancyBox();

	if (isModify) //devo eliminare la foto solo se sto modificando perche' solo in questo caso la ho gia' caricata sul server precedentemente
	{
		// ADD HERE THE CALL TO DELETE /lifestory/{id}/memento/{id memento}
		$.ajax({
			type : "DELETE",
			beforeSend : function(request) {
				request.setRequestHeader("PLAY_SESSION", GetSessionKey());
			},
			url : GetBaseUrl() + "/lifeapi/lifestory/"
					+ imgStoriaModifyId[index] + "/memento/"
					+ imgStoriaModifyMementoId[index],
			//url: "http://test.reminiscens.me/lifeapi/user/signup",

			data : "{}",

			dataType : "json",
			contentType : "application/json",

			//        async: false,

			success : function(data) {
				console.log("La foto si e' cancellata con sucesso!");
				imgStoriaModifyMementoId.splice(index, 1);
				imgStoriaModifyId.splice(index, 1);
				MieStorieVisible[indexStoriaVisible].mementoList.splice(index,
						1);

				stampaMieFoto(0, MieStorieVisible.length);
				stampaMieStorie(0, MieStorieVisible.length);
				aggiungiEventoFancyBox();

				var storage = $.localStorage;
				storage.set('mieStorie', MieStorie);

				//alert("hola");
			},
			error : function(data) {
				console.log("Errore nella cancellazione dell'immagine");
			}

		});
	}

}



/**
 * Function to call the API of deleting stories
 * 
 */
function DeleteStory(index) {
	idStory = MieStorieVisible[index].lifeStoryId;
	console.log("Request to delete the story "+idStory);
	if (!confirm("Sicuro di voler eliminare la storia '"+MieStorieVisible[index].headline+"'?")) {
		console.log("CANCELLED: request to delete the story "+idStory);
		return;
	}
	parent.$.fancybox.close(); //chiudo la galleria
	aggiungiEventoFancyBox();

	$.ajax({
		type : "DELETE",
		beforeSend : function(request) {
			request.setRequestHeader("PLAY_SESSION", GetSessionKey());
		},
		url : GetBaseUrl() + "/lifeapi/lifestory/" + idStory,
		data : "{}",
		dataType : "json",
		contentType : "application/json",
		async: false,
		success : function(data) {
			console.log("La storia si e' cancellata con sucesso!");
			console.log("Cancellando storia del array locale...");
			MieStorieVisible.splice(index, 1);
			stampaMieFoto(0, MieStorieVisible.length);
			stampaMieStorie(0, MieStorieVisible.length);
			aggiungiEventoFancyBox();
			var storage = $.localStorage;
			storage.set('mieStorie', MieStorie);
		},
		error : function(data) {
			console.log("Errore nella cancellazione dell'immagine");
		}

	});
	
	
	//CentroOverlay();
	//$('#overlay').fadeIn('fast');
	//$('#box').fadeIn('slow');
}


//function SwitchOverlay(switchTo)
//{
//    if(switchTo == "divPrivateMemento")
//    {
//        document.getElementById("divPrivateMemento").style.display = "inherit";
//        document.getElementById("divPublicMemento").style.display = "none";
//    }
//    else
//    {
//        document.getElementById("divPrivateMemento").style.display = "none";
//        document.getElementById("divPublicMemento").style.display = "inherit";
//    }
//}