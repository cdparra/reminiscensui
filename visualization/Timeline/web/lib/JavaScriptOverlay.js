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
    
    $(".button_next").click(
        function () {
            var next = tm.getSelected().getNext(true);            
            if(next!=null)
            {
                tm.setSelected(next);
                next.openInfoWindow();
                ApriOverlay();
            //alert(next.getTitle());
            }
        });
    $(".button_prev").click(
        function () {
            var prev = tm.getSelected().getPrev(true);
            if(prev!=null)
            {
                tm.setSelected(prev);
                prev.openInfoWindow();
                ApriOverlay();
            //alert(next.getTitle());
            }
        });
});