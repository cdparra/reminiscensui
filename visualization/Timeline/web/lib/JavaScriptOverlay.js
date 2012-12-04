

//quando chiudo overlay faccio vedere InfoHtml legato all' ultimo elemento selezionato'
function chiudiOverlay()
{
    tm.setSelected(selected);
    tm.getSelected().openInfoWindow();
}

//se l'elemento è visibile nello scorrimento avanti/indietro
function elementoVisibile(item)
{
    tm.setSelected(item);    
    selected = tm.getSelected();
    ApriOverlay();
}

//se l'elemento non è visibile nello scorrimento avanti/indietro
function elementoNonVisibile(item)
{
    item.scrollToStart(false);
                    
    oms.unspiderfy();
    tm.setSelected(item);
    selected = tm.getSelected();
    ApriOverlay(); 
}

$(document).ready(function () { //lo carico all' apertura della pag
    $(".chiudi").click(
        function () {
            $('#overlay').fadeOut('fast');
            $('#box').hide();
            chiudiOverlay();
        });

    //chiusura emergenza 
    $("#overlay").click(
        function () {
            $(this).fadeOut('fast');
            $('#box').hide();
            chiudiOverlay();
        });
    
    $(".button_next").click(
        function () {
            var next = selected.getNext(true);            
            if(next!=null) //controllo che ci sia un elemento successivo
            {
                if(next.onVisibleTimeline()) //controllo che sia visibile sulla timeline
                {
                    elementoVisibile(next);
                }
                else
                { //se non è visibile la scorro fino all'elemento
                    elementoNonVisibile(next);                     
                }
            //alert(next.getTitle());
            }
        });
    $(".button_prev").click(
        function () {
            var prev = selected.getPrev(true);
            if(prev!=null)//controllo che ci sia un elemento precedente
            {                
                if(prev.onVisibleTimeline())
                {
                    elementoVisibile(prev);
                }
                else//se non è visibile la scorro fino all'elemento
                {
                    elementoNonVisibile(prev);
                }
            //alert(next.getTitle());
            }
        });
});