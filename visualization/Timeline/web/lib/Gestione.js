function CentroOverlay() {
    //imposto la finestra sempre in mezzo!!!
    var PosX = ($(window).width() - $("#box").width()) / 2;
    var percentualeX = PosX / $(window).width() * 100;
    $("#box").css({ "left": percentualeX + "%" });
}

//controllo se la finestra è stata ridimensionata con jquery
jQuery(window).bind('resize', function () {
    CentroOverlay();
});

function ApriOverlay() {    
    CentroOverlay();
    //riporto i 2 div nella posizione originale(all' inizio) ad ogni aperture dell' overlay
    jQuery("div.split_dx").animate({ scrollTop: 0 });
    jQuery("div.split_sx").animate({ scrollTop: 0 });
    //!!!recupero info titolo con get selected e guardo il suo titolo per creare overlay dinamico
    $(".titolo_box").text(tm.getSelected().getTitle()); //assegno il titolo appena recuperato all' overlay
    //$(".testo_box").text(tm.getSelected().getTitle());
    var split = tm.getSelected().getInfoHtml().split("</br>");
    //recupero la descrizione
    $(".testo_box").text(split[0]);
    //recupero l'immagine
    split = tm.getSelected().getInfoHtml().split("src='");
    split = split[1].split("'");
    $("#img_overlay").attr("src", split[0]);

    //ora che ho modificato tutti i campi dinamicamente posso mostrare l' overlay
    $("#apri").click(
        function () {
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
function toggleDataset(dsid, toggle) {
    if (toggle) {
        oms.unspiderfy(); //faccio ritonare tutti i marker al loro posto
        tm.datasets[dsid].show();
    } else {
        oms.unspiderfy(); //faccio ritonare tutti i marker al loro posto
        tm.datasets[dsid].hide();
    }
}