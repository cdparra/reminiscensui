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
	var width = $("#box").width() + 100;
	var PosX = ($(window).width() - width) / 2;
    var percentualeX = PosX / $(window).width() * 100;
    $("#box").css({
        "left": percentualeX + "%"
    });
    
    //alert
	var height = $("#box").height() + 50;
    var PosY = ($(window).height() - height) / 2;
    var percentualeY = PosY / $(window).height() * 100;
    $("#box").css({
        "top": percentualeY + "%"
    });
}

//controllo se la finestra è stata ridimensionata con jquery
jQuery(window).bind('resize', function () {
    CentroOverlay();
});

function ApriOverlay() { 
    CentroOverlay();
    $('#overlay').fadeIn('fast');
    $('#box').fadeIn('slow');
}