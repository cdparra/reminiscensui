function CentroOverlay() {
    //imposto la finestra sempre in mezzo!!!
    var PosX = ($(window).width() - $("#box").width()) / 2;
    var percentualeX = PosX / $(window).width() * 100;
    //alert(percentualeX);
    $("#box").css({ "left": percentualeX + "%" });
}

//controllo se la finestra è stata ridimensionata con jquery
jQuery(window).bind('resize', function () {
    CentroOverlay();
});

function ApriOverlay(a) {
    CentroOverlay();
    //riporto i 2 div nella posizione originale(all' inizio) ad ogni aperture dell' overlay
    jQuery("div.split_dx").animate({ scrollTop: 0 });
    jQuery("div.split_sx").animate({ scrollTop: 0 });
    //!!!recupero info titolo con get selected e guardo il suo titolo per creare overlay dinamico
    $(".titolo_box").text(tm.getSelected().getTitle()); //assegno il titolo appena recuperato all' overlay
    $(".testo-box").text(tm.getSelected().getTitle());
    var split = tm.getSelected().getInfoHtml().split("/"); //come fare la split!!
    var nomeImmOverlay;
    //alert(a[0]);
    for (i = 0; i < split.length; i++) {
        if (split[i] == "imgPersonaggi") {
            var splitNome = split[i + 1].split(".");
            nomeImmOverlay = splitNome[0] + "_big" + ".jpg";
            break;
        }
    }
    //da notare che jQuery funziona come i css (#->id, .->classi)
    $("#img_overlay").attr("src", "../images/imgPersonaggi/" + nomeImmOverlay);

    //ora che ho modificato tutti i campi dinamicamente posso mostrare l' overlay
    $("#apri").click(
        function () {
            $('#overlay').fadeIn('fast');
            $('#box').fadeIn('slow');
        });
}

function CambioScalaTimelineGiorno() {
    tm.changeTimeIntervals(TimeMap.intervals.day);
}
function CambioScalaTimelineAnno() {
    tm.changeTimeIntervals(TimeMap.intervals.yr);
}
function CambioScalaTimelineMese() {
    tm.changeTimeIntervals(TimeMap.intervals.mon);
}
function CambioScalaTimelineDecade() {
    tm.changeTimeIntervals(TimeMap.intervals.dec);
}
function toggleDataset(dsid, toggle) {
    if (toggle) {
        tm.datasets[dsid].show();
    } else {
        tm.datasets[dsid].hide();
    }
}