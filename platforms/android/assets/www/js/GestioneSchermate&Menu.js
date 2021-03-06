// JavaScript Document
function nascondiDiv()
	{
		document.getElementById("Foto").style.display="none";
		document.getElementById("Storie").style.display = "none";
		if (isContext) {
		    document.getElementById("Canzoni").style.display = "none";
		    document.getElementById("Famosi").style.display = "none";
		    document.getElementById("TvFilm").style.display = "none";
		}
		if(isContextv2)
		{
		    document.getElementById("divRootRandom").style.display = "inherit";
		    document.getElementById("divRootFotoDelTempo").style.display = "none";
		    document.getElementById("divRootStorieDelTempo").style.display = "none";
		}
	}

function azzeraPagineStatistiche()
{
    indexCarouselFoto = 0;
    indexCarouselStorie = 0;
    indexCarouselCanzoni = 0;
    indexCarouselTv = 0;
    indexCarouselFamosi = 0;
}

function GestioneSchermate(clickdecade)
{
    console.log("gestioneSchermate");
    azzeraPagineStatistiche();
			nascondiDiv();
			if(clickdecade != null) //per gestire il fatto che la prima volta non ho storie e quindi devo fare vedere
									//la schermata del racconta storie e domande
			{
            	decade = clickdecade;  
			}
			$("#lbldebug").text("Non ci sono ancora storie del " + decade + "!");
			$("#FotoDelTempo").text("Foto pubbliche attorno al " + decade);
			$("#CanzoniDelTempo").text("Le canzoni degli anni " + decade);
			$("#FamosiDelTempo").text("Chi era famoso/e' nato attorno al " + decade);
			$("#TVDelTempo").text("La TV e i film attorno al " + decade);
			$("#TueFotoDelTempo").text("Le tue foto attorno al " + decade);
			$("#StorieDelTempo").text("Che cosa succedeva nel " + decade);
			$("#TueStorieDelTempo").text("Le tue storie nel " + decade);
			$("#RandomDelTempo").text("Il contesto delle tue storie nel " + decade);
			
			if(!MiaDecadeIsEmpty())
			{
				MieStorieVisible = RecuperaMieStorieDecade();
				ContextVisible = RecuperaContextDecade();
				stampaMieFoto(0,MieStorieVisible.length);
				stampaMieStorie(0,MieStorieVisible.length);
				
			    //gestione context
				if (isContext) {
				    stampaFotoContext(0, ContextVisible.picture.length);
				    stampaStorieContext(0, ContextVisible.story.length);
				    stampaCanzoniContext(0, ContextVisible.song.length);
				    stampaFamosiContext(0, ContextVisible.people.length);
				    stampaTvFilmContext(0, ContextVisible.tvFilm.length);
				}
				else if (isContextv2)
				{
				    //console.log(ContextVisible.picture.length);
				    stampaContextRandom();
				}
				
				aggiungiEventoFancyBox();
				document.getElementById("Storie").style.display="inherit";
				document.getElementById("Results").style.display="inherit";
				document.getElementById("NoResults").style.display = "none";
				document.getElementById("Caricamento").style.display = "none";
				$('.navbar li').removeClass('active');
				$('#liStorie').addClass('active');
				if (isQuestion) {
				    downloadQuestion(birthYear, decade, 'QuestionNotEmpty');
				}
			}
			else
			{
			    if (isFirstOpen) {
			        document.getElementById("NoResults").style.display = "none";
			        document.getElementById("Results").style.display = "none";
			        document.getElementById("Caricamento").style.display = "inherit";
			    }
			    else {
			        document.getElementById("NoResults").style.display = "inherit";
			        document.getElementById("Results").style.display = "none";
			        document.getElementById("Caricamento").style.display = "none";
			    }
			    if (isQuestion) {
			        downloadQuestion(birthYear, decade, 'QuestionEmpty');
			    }
			}
			
			
			/*if(recupero_id == 1950)
			{
				document.getElementById("Foto").style.display="inherit";
				document.getElementById("Results").style.display="inherit";
				document.getElementById("NoResults").style.display="none";
				$('.navbar li').removeClass('active');
				$('#liFoto').addClass('active');
			}
			else
			{
				document.getElementById("NoResults").style.display="inherit";
				document.getElementById("Results").style.display="none";
			}*/
}

function Logout() {
    if (!confirm('Sicuro di voler uscire?')) {
        return;
    }
    var storage = $.localStorage;
    var storieNonSync = storage.get('storieNonSync');
    if (storieNonSync != null) {
        if (storieNonSync.length > 0) {
            if (!confirm('Ci sono ancora storie da salvare in rete! Sei veramente sicuro i uscire?')) {
                return;
            }
        }
    }
    storage.set('storieNonSync', null);
    statisticheCLOSE();
    //SetSessionKey("");    
    //location.href = "index.html";
}

function CreaTimelineCarousel()
{
    //<div id="timelineCarousel" class="carousel slide">
    //            <div class="carousel-inner">
    //                <!--<div id="timeline1" class="item active">
    //            </div>
    //            <div id="timeline2" class="item">
    //            </div>
    //            <div id="timeline3" class="item">
    //            </div>-->
    //            </div>
    //            <a class="carousel-control left" href="#timelineCarousel" data-slide="prev">&lsaquo;</a>
    //            <a class="carousel-control right" href="#timelineCarousel" data-slide="next">&rsaquo;</a>
    //        </div>    
    var today = new Date();
    var decadeToday = parseInt(today.getFullYear() / 10) * 10;
    var numeroSchermateTimeline = (((decadeToday - firstDecade) / 10) +1) / 6;
    var decadeCorrente = firstDecade;
    var stringCarousel = "<div id='timelineCarousel' class='carousel slide' style='width: 1020px; height: 112px;'><div class='carousel-inner'>";
    if (numeroSchermateTimeline <= 1)
        numeroSchermateTimeline = 1;
    else if (numeroSchermateTimeline > 1 && numeroSchermateTimeline <= 2)
        numeroSchermateTimeline = 2;
    else
        numeroSchermateTimeline = 3;
    for (var i = 1; i <= numeroSchermateTimeline; i++)
    {
        if (i == 1)
            stringCarousel += "<div id='timeline" + i + "' class='item active'></div>";
        else
            stringCarousel += "<div id='timeline" + i + "' class='item'></div>";
    }
    stringCarousel += "</div>";
    stringCarousel += "<a class='carousel-control left' href='#timelineCarousel' data-slide='prev'>&lsaquo;</a> <a class='carousel-control right' href='#timelineCarousel' data-slide='next'>&rsaquo;</a>";
    stringCarousel += "</div>";
    document.getElementById("containerTimelineCarousel").innerHTML = stringCarousel;
    for (var i = 1; i <= numeroSchermateTimeline; i++) {
        for (var j = 0; j < 6; j++) {
            if (decadeCorrente <= decadeToday) {
                document.getElementById("timeline" + i).innerHTML += "<div class='decade-button timeline' id='" + decadeCorrente + "'><div class='decade-btn-border'></div><div class='decade-button-text'>" + decadeCorrente + "</div><div class='decade-btn-ruler-line1'></div><div class='decade-btn-ruler-line2'></div><div class='decade-btn-ruler-line3'></div><div class='decade-btn-ruler-line4'></div><div class='decade-btn-ruler-line5'></div><div class='decade-btn-ruler-line6'></div><div class='decade-btn-ruler-line7'></div><div class='decade-btn-ruler-line8'></div><div class='decade-btn-ruler-line9'></div><div class='decade-btn-ruler-line10'></div><div class='decade-btn-border-bottom'></div></div>";
            }
            else {
                document.getElementById("timeline" + i).innerHTML += "<div style='cursor: pointer;' class='decade-button'><div class='decade-btn-border'></div><div class='decade-button-text'></div><div class='decade-btn-ruler-line1'></div><div class='decade-btn-ruler-line2'></div><div class='decade-btn-ruler-line3'></div><div class='decade-btn-ruler-line4'></div><div class='decade-btn-ruler-line5'></div><div class='decade-btn-ruler-line6'></div><div class='decade-btn-ruler-line7'></div><div class='decade-btn-ruler-line8'></div><div class='decade-btn-ruler-line9'></div><div class='decade-btn-ruler-line10'></div><div class='decade-btn-border-bottom'></div></div>";
            }
            decadeCorrente += 10;
        }

    }

    $('.carousel').carousel({
        interval: false
    });
    $(".carousel").bind("slide", function () {
        //alert( "ciao" );
        //document.getElementById("item2").innerHTML = "ciao";
    });

    $(".carousel").bind("slid", function () {
        //alert( "ciao" );
        //document.getElementById("item2").innerHTML = "ciao";
    });

    document.getElementById(firstDecade).className = "decade-button-selected timeline";

    $('.timeline').click(function () {
        AzzeraTimeline();
        document.getElementById($(this).attr("id")).className = "decade-button-selected timeline";
        GestioneSchermate($(this).attr("id"));
    });
}

function AzzeraTimeline() {
    var today = new Date();
    var decadeToday = parseInt(today.getFullYear() / 10) * 10;
    //alert(decadeToday);
    for (var i = firstDecade ; i <= decadeToday; i = i + 10) {
        document.getElementById(i).className = "decade-button timeline";
    }
}

function ScrollCarousel()
{
    var today = new Date();
    var decadeToday = parseInt(today.getFullYear() / 10) * 10;
    var numeroSchermateTimeline = (((decadeToday - firstDecade) / 10)+1) / 6;
    if (numeroSchermateTimeline <= 1)
        numeroSchermateTimeline = 1;
    else if (numeroSchermateTimeline > 1 && numeroSchermateTimeline <= 2)
        numeroSchermateTimeline = 2;
    else
        numeroSchermateTimeline = 3;
    //alert(numeroSchermateTimeline);
    //alert(firstDecade);
    //alert(decade);
    for(var i = 1; i<= numeroSchermateTimeline;i++)
    {
        if (decade < (firstDecade + i * 60))
        {
            //alert(i - 1);
            $('#timelineCarousel').carousel(i - 1);
            break;
        }
            
    }
}

function ReloadReminiscens() {
	window.location.reload(true);
}

function statisticheCLOSE()
{
    ///log/CLOSE/user/{user_id}
    $.ajax({
        type: "POST",
        beforeSend: function (request) {
            request.setRequestHeader("PLAY_SESSION", GetSessionKey());
        },
        url: GetBaseUrl() + "/lifeapi/log/CLOSE/user/" + GetPersonId(),
        //url: "http://test.reminiscens.me/lifeapi/user/signup",

        data: "{}",

        dataType: "json",
        contentType: "application/json",

        async: false,

        success: function (data) {
            //salert("hola");
            SetSessionKey("");
            location.href = "index.html";

        },
        error: function (data) {
            alert("Errore nel passaggio di statistiche CLOSE");
        }
    });
}
