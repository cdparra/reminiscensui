function AzzeraVariabiliOverlay()
{
	InizializzaValueLocationAndDate();
	
	//azzero variabili immagini
	imgStoriaUrl = [];
	imgStoriaHashcode = [];
	imgStoriaFilename = [];
	
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
        "top": 50
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

//controllo se la finestra è stata ridimensionata con jquery
jQuery(window).bind('resize', function () {
    CentroOverlay();
	CentroCaricamento();
});

function ApriOverlay(clicked_id) {
	//alert(clicked_id);
	idStoryModify = null;
	isModify = false;
	indexModify = null;
	
	if(clicked_id == null)
	{
		$("#titleBox").html("raccontaci la tua storia");
	}
	else
	{
		//alert(document.getElementById(clicked_id).innerHTML);
		$("#titleBox").html(document.getElementById(clicked_id).innerHTML);
		//downloadQuestion(birthYear,decade);
	}
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
	for(var i = 0; i< MieStorieVisible[index].mementoList.length; i++)
	{
		imgStoriaUrl.push("");
		imgStoriaHashcode.push(MieStorieVisible[index].mementoList[i].fileHashcode);
		imgStoriaFilename.push(MieStorieVisible[index].mementoList[i].thumbnailUrl);
		document.getElementById("imgInput").innerHTML += "<img style='max-height:200px;max-width:220px;' src='" + GetBaseUrl() + "/files/SMALL_" + MieStorieVisible[index].mementoList[i].thumbnailUrl + "'/><br><br>";
	}
	
	if(MieStorieVisible[index].text!= null)
	{
		var editor = $("#editor").data("kendoEditor");
		editor.value(MieStorieVisible[index].text);
	}
	
	//location
	if(MieStorieVisible[index].location.country == "Italia")
	{
		document.getElementById("country").value = 1;
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