// JavaScript Document
function nascondiDiv()
	{
		document.getElementById("Foto").style.display="none";
		document.getElementById("Storie").style.display="none";
		document.getElementById("Canzoni").style.display="none";
		document.getElementById("Famosi").style.display = "none";
		document.getElementById("TvFilm").style.display = "none";
	}

function GestioneSchermate(clickdecade)
{
			nascondiDiv();
			if(clickdecade != null) //per gestire il fatto che la prima volta non ho storie e quindi devo fare vedere
									//la schermata del racconta storie e domande
			{
            	decade = clickdecade;  
			}
			$("#lbldebug").text("Non ci sono ancora storie del " + decade + "!");
			$("#FotoDelTempo").text("Com'era questo posto attorno al " + decade);
			$("#TueFotoDelTempo").text("Le tue foto attorno al " + decade);
			$("#StorieDelTempo").text("Che cosa succedeva nel " + decade);
			$("#TueStorieDelTempo").text("Le tue storie nel " + decade);
			
			downloadQuestion(birthYear,decade);
			
			if(!MiaDecadeIsEmpty())
			{
				MieStorieVisible = RecuperaMieStorieDecade();
				ContextVisible = RecuperaContextDecade();
				//alert(MieStorieVisible[0].headline);				
				/*if(MieStorieVisible.length<2) //caso in cui ci sia da stampare solo una foto o nessuna
				{
					stampaMieFoto(0,MieStorieVisible.length);
					stampaMieStorie(0,MieStorieVisible.length);
				}
				else //caso in cui ci siano almeno 2 foto quindi stampo le prime 2
				{
					stampaMieFoto(0,2);
					stampaMieStorie(0,2);
				}*/
				stampaMieFoto(0,MieStorieVisible.length);
				stampaMieStorie(0,MieStorieVisible.length);
				
				//gestione context
				stampaFotoContext(0, ContextVisible.picture.length);
				stampaStorieContext(0, ContextVisible.story.length);
				stampaCanzoniContext(0, ContextVisible.song.length);
				stampaFamosiContext(0, ContextVisible.people.length);
				stampaTvFilmContext(0, ContextVisible.tvFilm.length);
				
				aggiungiEventoFancyBox();
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
    SetSessionKey("");
    location.href = "index.html";
}


function AzzeraTimeline() {
    var today = new Date();
    var decadeToday = parseInt(today.getFullYear() / 10) * 10;
    for (var i = GetPersonDeacadeBirthDate() ; i <= decadeToday; i = i + 10) {
        document.getElementById(i).className = "decade-button timeline";
    }
}

$(document).ready(function() {
		/*applica la classe active al menù nav bar di bootstrap quando viene cliccato*/
		$('.navbar li').click(function(e) {
			$('.navbar li').removeClass('active');
			var $this = $(this);
			if (!$this.hasClass('active')) {
				$this.addClass('active');
			}
			var tmp = $this.attr("id");
			tmp = tmp.substring(2,tmp.length);
			if(tmp == "Logout")
			{
			    Logout();
			}
			else if(tmp == "Raccontaci")
			{
				ApriOverlay();
			}
			else
			{
				nascondiDiv();
				document.getElementById(tmp).style.display="inherit";
			}
			
			e.preventDefault();
		});		
});