function CentroOverlay() {
    //imposto la finestra sempre in mezzo!!!
    var PosX = ($(window).width() - $("#box").width()) / 2;
    var percentualeX = PosX / $(window).width() * 100;
    $("#box").css({
        "left": percentualeX + "%"
    });
    
    //alert
    var PosY = ($(window).height() - $("#box").height()) / 2;
    var percentualeY = PosY / $(window).height() * 100;
    $("#box").css({
        "top": percentualeY + "%"
    });
}

//controllo se la finestra è stata ridimensionata con jquery
jQuery(window).bind('resize', function () {
    CentroOverlay();
});

function ApriOverlay(id, visualizzaConfronto) { 
    CentroOverlay();
    //riporto i 2 div nella posizione originale(all' inizio) ad ogni aperture dell' overlay
    jQuery("div.split_dx").animate({
        scrollTop: 0
    });
    jQuery("div.split_sx").animate({
        scrollTop: 0
    });
    //!!!recupero info titolo con get selected e guardo il suo titolo per creare overlay dinamico
    $(".titolo_box").text(tm.getSelected().getTitle()); //assegno il titolo appena recuperato all' overlay
    //$(".testo_box").text(tm.getSelected().getTitle());
    var split = tm.getSelected().getInfoHtml().split("</br>");
    split = split[0].split("</h3>"); 
    //recupero la descrizione
    $(".testo_box").text(split[1]);
    //recupero l'immagine
    split = tm.getSelected().getInfoHtml().split("src='");
    split = split[1].split("'");
    $("#img_overlay").attr("src", split[0]);
    
    //gestione visualizzazione corretta del confronto (devo far vedere l' altra persona)
    $('#Lista' + visualizzaConfronto).show();
    $('#Lista' + id).hide();
    
    //ora che ho modificato tutti i campi dinamicamente posso mostrare l' overlay
    $("#apri").click(
        function () {
            if(tm.getSelected()!=null)
            {
                selected = tm.getSelected();
            }
            $('#overlay').fadeIn('fast');
            $('#box').fadeIn('slow');            
        });
}
//metodi per la gestione della scala della timeline
function CambioScalaTimelineGiorno() {
    oms.unspiderfy(); //faccio ritonare tutti i marker al loro posto
    tm.changeTimeIntervals(TimeMap.intervals.day);
}
function CambioScalaTimelineAnno() {
    oms.unspiderfy(); //faccio ritonare tutti i marker al loro posto
    tm.changeTimeIntervals(TimeMap.intervals.yr);
}
function CambioScalaTimelineMese() {
    oms.unspiderfy(); //faccio ritonare tutti i marker al loro posto
    tm.changeTimeIntervals(TimeMap.intervals.mon);
}
function CambioScalaTimelineDecade() {
    oms.unspiderfy(); //faccio ritonare tutti i marker al loro posto
    tm.changeTimeIntervals(TimeMap.intervals.dec);
}
//metodo per la gestione dei togglebutton
function toggleDataset(linea,id, toggle) {
    if (toggle) {
        oms.unspiderfy(); //faccio ritonare tutti i marker al loro posto
        tm.datasets[linea].show();
        tm.datasets[id].show();
    } else {
        oms.unspiderfy(); //faccio ritonare tutti i marker al loro posto
        tm.datasets[linea].hide();
        tm.datasets[id].hide();
    }
}
//metodo utilizzato per applicare il metodo unspiderfy quando vado a cambiare la data nella lineatemporale
function raggruppa()
{
    oms.unspiderfy();
}