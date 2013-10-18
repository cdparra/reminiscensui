function AzzeraVariabiliOverlay()
{
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
			
	$("#city").hide();
	document.getElementById("city").value = "";
	$("#placeName").val("");
	$("#placeName").hide();
	
	$("#year").hide();
	document.getElementById("year").value = 0;
	$("#month").hide();
	document.getElementById("month").value = 0;
	$("#day").hide();
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
		$(".chiudi").click(
        function () {
			if (!confirm('Sicuro di voler uscire dal raccontaci?')) { 
 				return;
			}
			AzzeraVariabiliOverlay()
            /*$('#overlay').fadeOut('fast');
            $('#box').hide();*/
        });       

    //chiusura emergenza 
    $("#overlay").click(
        function () {
			if (!confirm('Sicuro di voler uscire dal raccontaci?')) { 
 				return;
			}
			AzzeraVariabiliOverlay()
            /*$(this).fadeOut('fast');
            $('#box').hide();*/
        });
		});
		
		function CentroOverlay() {
			
    //imposto la finestra sempre in mezzo!!!
    /*var PosX = ($(window).width() - $("#box").width()) / 2;
    var percentualeX = PosX / $(window).width() * 100;
    $("#box").css({
        "left": percentualeX + "%"
    });
    
    //alert
    var PosY = ($(window).height() - $("#box").height()) / 2;
    var percentualeY = PosY / $(window).height() * 100;
    $("#box").css({
        "top": percentualeY + "%"
    });*/
	var width = $("#box").width();
	var PosX = ($(window).width() - width) / 2;
    var percentualeX = PosX / $(window).width() * 100;
    $("#box").css({
        "left": percentualeX + "%"
    });
    
    //alert
	/*var height = $("#box").height() + 50;
    var PosY = ($(window).height() - height) / 2;
    var percentualeY = PosY / $(window).height() * 100;
    $("#box").css({
        "top": percentualeY + "%"
    });*/
	$("#box").css({
        "top": 25
    });
}

function CentroCaricamento() {
			
    //imposto la finestra sempre in mezzo!!!
    var PosX = ($(window).width() - $("#caricamento").width()) / 2;
    var percentualeX = PosX / $(window).width() * 100;
    $("#caricamento").css({
        "left": percentualeX + "%"
    });
    
    //alert
    var PosY = ($(window).height() - $("#caricamento").height()) / 2;
    var percentualeY = PosY / $(window).height() * 100;
    $("#caricamento").css({
        "top": percentualeY + "%"
    });
}

//controllo se la finestra stata ridimensionata con jquery
jQuery(window).bind('resize', function () {
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
	
	if(clicked_id == null)
	{
		$("#titleBox").html("raccontaci la tua storia");
	}
	else if (clicked_id == "FirstDecadeQuestionEmpty" || clicked_id == "SecondDecadeQuestionEmpty" ||
            clicked_id == "FirstPersonalQuestionEmpty" || clicked_id == "SecondPersonalQuestionEmpty" ||
        clicked_id == "DecadeQuestionNotEmpty" || clicked_id == "PersonalQuestionNotEmpty") //caso in cui arrivo da una domanda
	{
		//alert(clicked_id);
	    $("#titleBox").html(document.getElementById(clicked_id).innerHTML);
	    switch (clicked_id)
	    {
	        case "FirstDecadeQuestionEmpty":
	            idQuestion = vettIdQuestions[0];
                break;
	        case "SecondDecadeQuestionEmpty":
	            idQuestion = vettIdQuestions[1];
	            break;
	        case "FirstPersonalQuestionEmpty":
	            idQuestion = vettIdQuestions[2];
	            break;
	        case "SecondPersonalQuestionEmpty":
	            idQuestion = vettIdQuestions[3];
	            break;
	        case "DecadeQuestionNotEmpty":
	            idQuestion = vettIdQuestions[4];
	            break;
	        case "PersonalQuestionNotEmpty":
	            idQuestion = vettIdQuestions[5];
	            break;
	    }
	    //alert("question: " + idQuestion);
		//downloadQuestion(birthYear,decade);
	}
	else //caso in cui arrivo da un context
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
	
	parent.$.fancybox.close();  //chiudo la galleria
	document.getElementById("titolo").value = MieStorieVisible[index].headline;
    //alert(MieStorieVisible[index].mementoList.length);
	document.getElementById("imgInput").innerHTML = "<br><br>";
	for(var i = 0; i< MieStorieVisible[index].mementoList.length; i++)
	{
	    //alert(MieStorieVisible[index].mementoList[i].thumbnailUrl);
	    imgStoriaUrl.push(MieStorieVisible[index].mementoList[i].url);
		imgStoriaHashcode.push(MieStorieVisible[index].mementoList[i].fileHashcode);
		imgStoriaFilename.push(MieStorieVisible[index].mementoList[i].thumbnailUrl);
		imgStoriaUrlHtml.push(GetBaseUrl() + "/files/SMALL_" + MieStorieVisible[index].mementoList[i].thumbnailUrl);
		imgStoriaModifyMementoId.push(MieStorieVisible[index].mementoList[i].mementoId);
		imgStoriaModifyId.push(MieStorieVisible[index].lifeStoryId);
		document.getElementById("imgInput").innerHTML += "<div id='" + "divImg" + i + "' style='position: relative; display: inline-block;'><img style=' max-height:200px;max-width:220px;' src='" + GetBaseUrl() + "/files/SMALL_" + MieStorieVisible[index].mementoList[i].fileName + "' /><img src='images/Ximm.png' style='position:absolute;right:-12.5px; top:-12.5px;  cursor:pointer;' onclick='eliminaImmagine(" + i + ")'/></div><br><br>";
        
	}
	
	if(MieStorieVisible[index].text!= null)
	{
		var editor = $("#editor").data("kendoEditor");
		editor.value(MieStorieVisible[index].text);
	}
	
	//location
	if(MieStorieVisible[index].location.country != null)
	{
	    document.getElementById("country").value = MieStorieVisible[index].location.country;
		VisualizzaCity();
	}
	if(MieStorieVisible[index].location.city != null)
	{
		//$('#city').fadeIn('fast');		
		document.getElementById("city").value = MieStorieVisible[index].location.city;
		VisualizzaPlaceName();
	}
	if(MieStorieVisible[index].location.placeName != null)
	{
		
		document.getElementById("placeName").value = MieStorieVisible[index].location.placeName;
	}
	
	//date
	//alert(MieStorieVisible[index].startDate.decade);
	document.getElementById("decade").value = (MieStorieVisible[index].startDate.decade - 1900)/10 + 1;
	VisualizzaYear();
	
	if(MieStorieVisible[index].startDate.year != null)
	{		
		document.getElementById("year").value = (MieStorieVisible[index].startDate.year - MieStorieVisible[index].startDate.decade) + 1;
		VisualizzaMonth();
	}
	
	if(MieStorieVisible[index].startDate.month != null)
	{		
		document.getElementById("month").value = MieStorieVisible[index].startDate.month;
		VisualizzaDay();
	}
	
	if(MieStorieVisible[index].startDate.day != null)
	{		
		document.getElementById("day").value = MieStorieVisible[index].startDate.day;
	}	
			
	CentroOverlay();
    $('#overlay').fadeIn('fast');
    $('#box').fadeIn('slow');	
}


function eliminaImmagine(index)
{
    if (!confirm('Sicuro di voler eliminare l\'immagine?')) {
        return;
    }
    imgStoriaUrl.splice(index,1);
    imgStoriaUrlHtml.splice(index, 1);
    imgStoriaHashcode.splice(index, 1);
    imgStoriaFilename.splice(index, 1);

    document.getElementById("imgInput").innerHTML = "<br /><br />";

    for(var i = 0;i< imgStoriaUrl.length;i++)
    {
        document.getElementById("imgInput").innerHTML += "<div id='" + "divImg" + i + "' style='position: relative; display: inline-block;'><img style=' max-height:200px;max-width:220px;' src='" + imgStoriaUrlHtml[i] + "' /><img src='images/Ximm.png' style='position:absolute;right:-12.5px; top:-12.5px;  cursor:pointer;' onclick='eliminaImmagine(" + i + ")'/></div><br><br>";
    }

    if(isModify) //devo eliminare la foto solo se sto modificando perchè solo in questo caso la ho già caricata sul server precedentemente
    {        
        // ADD HERE THE CALL TO DELETE /lifestory/{id}/memento/{id memento}
        $.ajax({
            type: "DELETE",
            beforeSend: function (request) {
                request.setRequestHeader("PLAY_SESSION", GetSessionKey());
            },
            url: GetBaseUrl() + "/lifeapi/lifestory/" + imgStoriaModifyId[index] + "/memento/" + imgStoriaModifyMementoId[index],
            //url: "http://test.reminiscens.me/lifeapi/user/signup",

            data: "{}",

            dataType: "json",
            contentType: "application/json",

            //        async: false,

            success: function (data) {
                alert("La foto si è cancellata con sucesso!");
                imgStoriaModifyMementoId.splice(index, 1);
                imgStoriaModifyId.splice(index, 1);
                //alert("hola");
            },
            error: function (data) {
                alert("Errore nella cancellazione dell'immagine");
            }

        });
    }
    
    
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
