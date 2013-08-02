// JavaScript Document
function nascondiDiv()
	{
		document.getElementById("Foto").style.display="none";
		document.getElementById("Storie").style.display="none";
		document.getElementById("Canzoni").style.display="none";
		document.getElementById("Famosi").style.display="none";
	}

$(document).ready(function() {
	$('.timeline').click(function(){
			nascondiDiv();
            decade = $(this).attr("id");  
			$("#lbldebug").text("Non ci sono ancora storie del " + decade + "!");
			$("#FotoDelTempo").text("Com'era questo posto attorno al " + decade);
			$("#TueFotoDelTempo").text("Le tue foto attorno al " + decade);
			$("#StorieDelTempo").text("Che cosa succedeva nel " + decade);
			$("#TueStorieDelTempo").text("Le tue storie nel " + decade);
			
			if(!DecadeIsEmpty())
			{
				MieStorieVisible = RecuperaStorieDecade();
				//alert(MieStorieVisible[0].titolo);				
				if(MieStorieVisible.length<2) //caso in cui ci sia da stampare solo una foto o nessuna
				{
					stampaMieFoto(0,MieStorieVisible.length);
					stampaMieStorie(0,MieStorieVisible.length);
				}
				else //caso in cui ci siano almeno 2 foto quindi stampo le prime 2
				{
					stampaMieFoto(0,2);
					stampaMieStorie(0,2);
				}
				aggiungiEventoFancyBox()
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
        });
		/*applica la classe active al menù nav bar di bootstrap quando viene cliccato*/
		$('.navbar li').click(function(e) {
			$('.navbar li').removeClass('active');
			var $this = $(this);
			if (!$this.hasClass('active')) {
				$this.addClass('active');
			}
			var tmp = $this.attr("id");
			tmp = tmp.substring(2,tmp.length);
			if(tmp == "Raccontaci")
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