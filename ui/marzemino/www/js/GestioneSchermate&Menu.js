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
            var recupero_id = $(this).attr("id");  
			$("#lbldebug").text("Non ci sono ancora storie del " + recupero_id + "!");
			$("#FotoDelTempo").text("Com'era questo posto attorno al " + recupero_id);
			$("#TueFotoDelTempo").text("Le tue foto attorno al " + recupero_id);
			$("#StorieDelTempo").text("Che cosa succedeva nel " + recupero_id);
			$("#TueStorieDelTempo").text("Le tue storie nel " + recupero_id);
			if(recupero_id == 1950)
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
			}
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