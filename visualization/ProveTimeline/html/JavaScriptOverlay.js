$(document).ready(function () { //lo carico all' apertura della pag

    

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