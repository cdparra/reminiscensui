$(document).ready(function() {		
		$(".chiudi").click(
        function () {
            $('#overlay').fadeOut('fast');
            $('#box').hide();
        });       

    //chiusura emergenza 
    $("#overlay").click(
        function () {
            $(this).fadeOut('fast');
            $('#box').hide();
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