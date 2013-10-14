// JavaScript Document

function InizializzaMieStorieDecade()
{
	MieStorie.MilleNovecento = [];
	MieStorie.MilleNovecentoDieci = [];
 	MieStorie.MilleNovecentoVenti = [];
	MieStorie.MilleNovecentoTrenta = [];
 	MieStorie.MilleNovecentoQuaranta = [];
	MieStorie.MilleNovecentoCinquanta = [];
 	MieStorie.MilleNovecentoSessanta = [];
	MieStorie.MilleNovecentoSettanta = [];
 	MieStorie.MilleNovecentoOttanta = [];
	MieStorie.MilleNovecentoNovanta = [];
 	MieStorie.Duemila = [];
	MieStorie.DuemilaDieci = [];
	MieStorie.DuemilaVenti = [];
}
	 
function AggiungiMieStoriaDecade(newStory, decade)
{
	switch(parseInt(decade))
	{
		case 1900:
			MieStorie.MilleNovecento.push(newStory);
			break;
		case 1910:
			MieStorie.MilleNovecentoDieci.push(newStory);
			break;
		case 1920:
 			MieStorie.MilleNovecentoVenti.push(newStory);
  			break;
		case 1930:
			MieStorie.MilleNovecentoTrenta.push(newStory);
			break;
		case 1940:
 			MieStorie.MilleNovecentoQuaranta.push(newStory);
  			break;
		case 1950:
			MieStorie.MilleNovecentoCinquanta.push(newStory);
			break;
		case 1960:
 			MieStorie.MilleNovecentoSessanta.push(newStory);
  			break;
		case 1970:
			MieStorie.MilleNovecentoSettanta.push(newStory);
			break;
		case 1980:
 			MieStorie.MilleNovecentoOttanta.push(newStory);
  			break;
		case 1990:
			MieStorie.MilleNovecentoNovanta.push(newStory);
	  		break;
		case 2000:
 			MieStorie.Duemila.push(newStory);
  			break;
		case 2010:
			MieStorie.DuemilaDieci.push(newStory);
	  		break;
		case 2020:
			MieStorie.DuemilaVenti.push(newStory);
	  		break;
	}
}


function ReplaceElement(newStory, vett, index)
{
	vett[index] = newStory;
}

function ModificaMieStoriaDecade(newStory, decade, index)
{
	switch(parseInt(decade))
	{
		case 1900:
			ReplaceElement(newStory, MieStorie.MilleNovecento, index);
			break;
		case 1910:
			ReplaceElement(newStory, MieStorie.MilleNovecentoDieci, index);
			break;
		case 1920:
			ReplaceElement(newStory, MieStorie.MilleNovecentoVenti, index);
  			break;
		case 1930:
			ReplaceElement(newStory, MieStorie.MilleNovecentoTrenta, index);
			break;
		case 1940:
			ReplaceElement(newStory, MieStorie.MilleNovecentoQuaranta, index);
  			break;
		case 1950:
			ReplaceElement(newStory, MieStorie.MilleNovecentoCinquanta, index);
			break;
		case 1960:
			ReplaceElement(newStory, MieStorie.MilleNovecentoSessanta, index);
  			break;
		case 1970:
			ReplaceElement(newStory, MieStorie.MilleNovecentoSettanta, index);
			break;
		case 1980:
			ReplaceElement(newStory, MieStorie.MilleNovecentoOttanta, index);
  			break;
		case 1990:
			ReplaceElement(newStory, MieStorie.MilleNovecentoNovanta, index);
	  		break;
		case 2000:
			ReplaceElement(newStory, MieStorie.Duemila, index);
  			break;
		case 2010:
			ReplaceElement(newStory, MieStorie.DuemilaDieci, index);
	  		break;
		case 2020:
			ReplaceElement(newStory, MieStorie.DuemilaVenti, index);
	  		break;
	}
}
	 
function RecuperaMieStorieDecade()
{
	 vettIndexMieStorieVisible = [];  //devo cancellare gli indici ogni volta che passo a una decade diversa
	 switch(parseInt(decade))
 	 {
		case 1900:
 			return MieStorie.MilleNovecento;
  			break;
		case 1910:
			return MieStorie.MilleNovecentoDieci;
	  		break;
		case 1920:
 			return MieStorie.MilleNovecentoVenti;
  			break;
		case 1930:
			return MieStorie.MilleNovecentoTrenta;
	  		break;
		case 1940:
 			return MieStorie.MilleNovecentoQuaranta;
  			break;
		case 1950:
			return MieStorie.MilleNovecentoCinquanta;
	  		break;
		case 1960:
 			return MieStorie.MilleNovecentoSessanta;
  			break;
		case 1970:
			return MieStorie.MilleNovecentoSettanta;
	  		break;
		case 1980:
 			return MieStorie.MilleNovecentoOttanta;
  			break;
		case 1990:
			return MieStorie.MilleNovecentoNovanta;
	  		break;
		case 2000:
 			return MieStorie.Duemila;
  			break;
		case 2010:
			return MieStorie.DuemilaDieci;
	  		break;
		case 2020:
			return MieStorie.DuemilaVenti;
	  		break;
	}
}

function MiaDecadeIsEmpty()
{
	switch(parseInt(decade))
	{
		case 1900:
			if(MieStorie.MilleNovecento.length !=0)
				return false;
  			break;
		case 1910:
			if(MieStorie.MilleNovecentoDieci.length !=0)
				return false;
			break;
		case 1920:
 			if(MieStorie.MilleNovecentoVenti.length !=0)
				return false;
  			break;
		case 1930:
			if(MieStorie.MilleNovecentoTrenta.length !=0)
				return false;
			break;
		case 1940:
			//alert(MieStorie.MilleNovecentoQuaranta.length);
 			if(MieStorie.MilleNovecentoQuaranta.length !=0)
				return false;
  			break;
		case 1950:
			//alert(MieStorie.MilleNovecentoCinquanta.length);
			if(MieStorie.MilleNovecentoCinquanta.length !=0)
				return false;
			break;
		case 1960:
 			if(MieStorie.MilleNovecentoSessanta.length !=0)
				return false;
  			break;
		case 1970:
			if(MieStorie.MilleNovecentoSettanta.length !=0)
				return false;
			break;
		case 1980:
 			if(MieStorie.MilleNovecentoOttanta.length !=0)
				return false;
  			break;
		case 1990:
			if(MieStorie.MilleNovecentoNovanta.length !=0)
				return false;
			break;
		case 2000:
 			if(MieStorie.Duemila.length !=0)
				return false;
  			break;
		case 2010:
			if(MieStorie.DuemilaDieci.length !=0)
				return false;
			break;
		case 2020:
			if(MieStorie.DuemilaVenti.length !=0)
				return false;
			break;
	}
		
	return true;
}


function Timeline()
{	
	//alert(sessionKey);	
	InizializzaMieStorieDecade();
    /*$.getJSON("http://test.reminiscens.me/lifeapi/person/3/timeline",function(timeline)*/	
	$.ajax({
        type:"GET",
        beforeSend: function (request)
        {
           request.setRequestHeader("PLAY_SESSION", sessionKey);
        },
        url:GetBaseUrl() + "/lifeapi/person/"+personId+"/timeline",
        //url: "http://test.reminiscens.me/lifeapi/person/"+personId+"/timeline",
		//url: "http://test.reminiscens.me/lifeapi/person/"+3+"/timeline",
        //data: "json=" + escape(JSON.stringify(createRequestObject)),
        processData: false,
        dataType: "json",
		contentType:"application/json",
       	error: function (data) {

       	    alert("errore caricamento timeline");

       	},
		success: function(timeline) 
		{
			//alert(timeline.aboutPerson.personId );
			var storyList = timeline.storyList;
			
			var i = 0;
			while(storyList[i] != null)
			{
				//alert(storyList[i].storyId);
				var mementoList = storyList[i].mementoList;
				var j = 0;
				var newStory = new Object;
				newStory.lifeStoryId = storyList[i].lifeStoryId;
				newStory.headline = storyList[i].headline;
				newStory.location = new Object;
				if (storyList[i].location != null) {
				    newStory.location.country = storyList[i].location.country;
				    newStory.location.city = storyList[i].location.city;
				    newStory.location.region = storyList[i].location.region;
				    newStory.location.placeName = storyList[i].location.placeName;
				}
				newStory.startDate = new Object;
				newStory.startDate.exactDate = storyList[i].startDate.exactDateAsString;
				newStory.startDate.decade = storyList[i].startDate.decade;
				newStory.startDate.year = storyList[i].startDate.year;
				newStory.startDate.month = storyList[i].startDate.month;
				newStory.startDate.day = storyList[i].startDate.day;
				newStory.text = storyList[i].text;
				var vettImm = [];
				while(mementoList[j] != null)
				{						
					if(mementoList[j].category == "PICTURE")
					{
						//alert(mementoList[j].url);						
						var Imm = new Object;
						Imm.url = mementoList[j].url;
						Imm.fileHashcode = mementoList[j].fileHashcode;
						Imm.thumbnailUrl = mementoList[j].thumbnailUrl;
						//alert(Imm.src);s
						vettImm.push(Imm);							
					}						
					j++;
				}
				newStory.mementoList = vettImm;
				AggiungiMieStoriaDecade(newStory, storyList[i].startDate.decade);
				//MieStorie.push(newStory);
				i++;
			}
				
			var storage = $.localStorage;
			storage.set('mieStorie',MieStorie);
				
			
			firstDecade = GetFirstDecade(GetPersonDeacadeBirthDate()); //recupero la prima decade che compare nella timeline (guardo la prima che ha una storia raccontata)
			//alert(firstDecade);
			decade = firstDecade;
			CreaTimelineCarousel();
			MieStorieVisible = RecuperaMieStorieDecade();
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
			aggiungiEventoFancyBox();
	/*);
}*/
			//alert(msg.aboutPerson.personId);
			isFirstOpen = false;
			
			GestioneSchermate();
           }
        	
	});
}


function InserisciIndiceMieStorieConFoto(index)
{
	vettIndexMieStorieVisible.push(index);
}

function stampaMieFoto(inizio, fine)
{
	//alert(inizio + "  " + fine);
	
	/*var i;
	document.getElementById("divMieFotoDelTempo").innerHTML = "";
	//document.getElementById("divMieFotoDelTempo").innerHTML += "<button id='indietro' onClick='indietro'>Indietro</button> <button id='avanti' onClick='avanti'>Avanti</button></br>";
	for (i=inizio; i<fine; i++) { 		
		//alert(MieStorie[i].immagini[0].src);
		//alert(MieStorieVisible[i].mementoList.length);
	    if (MieStorieVisible[i].mementoList.length > 0) {
	        //alert(MieStorieVisible[i].mementoList.length);
	        InserisciIndiceMieStorieConFoto(i);
	        if (MieStorieVisible[i].mementoList[0].thumbnailUrl == null) {
	            document.getElementById("divMieFotoDelTempo").innerHTML += "<div class='immaginiFoto'><a class='fancyboxMieStorie' rel='gallery2' href='" + MieStorieVisible[i].mementoList[0].url + "' title='" + MieStorieVisible[i].headline + "' > <img style='max-width:195px;max-height:140px;' src='" + MieStorieVisible[i].mementoList[0].url + "' alt='' /> </a></br></div>";
	        }
	        else  //stampo attraverso hashcode
	        {
	            document.getElementById("divMieFotoDelTempo").innerHTML += "<div class='immaginiFoto'><a class='fancyboxMieStorie' rel='gallery2' href='" + GetBaseUrl() + "/file/" + "LARGE_" + MieStorieVisible[i].mementoList[0].thumbnailUrl + "' title='" + MieStorieVisible[i].headline + "' > <img style='max-width:195px;max-height:140px;' src='" + GetBaseUrl() + "/lifeapi/file/" + MieStorieVisible[i].mementoList[0].fileHashcode + "/SMALL" + "' alt='' /> </a></br></div>";
	        }

	    }
	    else {
	    }
	}*/

    document.getElementById("containerCarouselMieFotoDelTempo").innerHTML = "";
    var indice = 0;
    var nPagina = 0;
    var visualizzati = 0;
    var stringaDivCarousel = "<div id='divMieFotoDelTempo' class='carousel slide'>";
    var stringaDivEle = "<div class='carousel-inner'>";
    var stringaDiv = "";
    //document.getElementById("carouselDivMieFotoDelTempo").innerHTML += "<div id='divMieFotoDelTempo" + nPagina + "' class='item active'>";
    while(MieStorieVisible[indice] != null)
    {
        //alert(MieStorieVisible[indice].mementoList.length);
        if (MieStorieVisible[indice].mementoList.length > 0) {
            for (var i = 0; i < MieStorieVisible[indice].mementoList.length; i++) {
                //alert(MieStorieVisible[i].mementoList.length);
                InserisciIndiceMieStorieConFoto(indice);
                if (MieStorieVisible[indice].mementoList[i].thumbnailUrl == null) {
                    if (MieStorieVisible[indice].mementoList[i].url != "") {
                        stringaDiv += "<div class='immaginiFoto'><a class='fancyboxMieStorie' rel='gallery2' href='" + MieStorieVisible[indice].mementoList[i].url + "' title='" + MieStorieVisible[indice].headline + "' > <img style='max-width:225px;max-height:200px;' src='" + MieStorieVisible[indice].mementoList[i].url + "' alt='' /> </a></br></div>";
                    }
                    else {
                        visualizzati--;
                    }

                    //document.getElementById("carouselDivMieFotoDelTempo").innerHTML += "<div class='immaginiFoto'><a class='fancyboxMieStorie' rel='gallery2' href='" + MieStorieVisible[indice].mementoList[0].url + "' title='" + MieStorieVisible[indice].headline + "' > <img style='max-width:215px;max-height:190px;' src='" + MieStorieVisible[indice].mementoList[0].url + "' alt='' /> </a></br></div></br></br>";
                }
                else  //stampo attraverso hashcode
                {
                    stringaDiv += "<div class='immaginiFoto'><a class='fancyboxMieStorie' rel='gallery2' href='" + GetBaseUrl() + "/file/" + "LARGE_" + MieStorieVisible[indice].mementoList[i].thumbnailUrl + "' title='" + MieStorieVisible[indice].headline + "' > <img style='max-width:225px;max-height:200px;' src='" + GetBaseUrl() + "/lifeapi/file/" + MieStorieVisible[indice].mementoList[i].fileHashcode + "/SMALL" + "' alt='' /> </a></br></div>";
                    //document.getElementById("carouselDivMieFotoDelTempo").innerHTML += "<div class='immaginiFoto'><a class='fancyboxMieStorie' rel='gallery2' href='" + GetBaseUrl() + "/file/" + "LARGE_" + MieStorieVisible[indice].mementoList[0].thumbnailUrl + "' title='" + MieStorieVisible[indice].headline + "' > <img style='max-width:215px;max-height:190px;' src='" + GetBaseUrl() + "/lifeapi/file/" + MieStorieVisible[indice].mementoList[0].fileHashcode + "/SMALL" + "' alt='' /> </a></br></div></br></br>";
                }


                visualizzati++;
                if (visualizzati == 4) {
                    visualizzati = 0;
                    if (nPagina == 0) {
                        stringaDivEle += "<div class='item active'>" + stringaDiv + "</div>";
                    }
                    else {
                        stringaDivEle += "<div class='item'>" + stringaDiv + "</div>";
                    }

                    nPagina++;
                    stringaDiv = "";
                }
            }
        }

        indice++;
    }

    if(stringaDiv != "")
    {
        if (nPagina == 0) {
            stringaDivEle += "<div class='item active'>" + stringaDiv + "</div>";
        }
        else {
            stringaDivEle += "<div class='item'>" + stringaDiv + "</div>";
        }
    }
    stringaDivEle += "</div>";

    stringaDivCarousel += stringaDivEle;

    stringaDivCarousel += "<a class='carousel-control left' href='#divMieFotoDelTempo' data-slide='prev'>&lsaquo;</a> <a class='carousel-control right' href='#divMieFotoDelTempo' data-slide='next'>&rsaquo;</a>";
    stringaDivCarousel += "</div>";

    document.getElementById("containerCarouselMieFotoDelTempo").innerHTML = stringaDivCarousel;

    $('.carousel').carousel({
        interval: false
    });
}


function stampaMieStorie(inizio, fine)
{
	//alert(inizio + "  " + fine);
	
	//var i;
	//document.getElementById("divMieStorieDelTempo").innerHTML = "";
	////document.getElementById("divMieStorieDelTempo").innerHTML += "<button id='indietro' onClick='indietroStorie()'>Indietro</button> <button id='avanti' onClick='avantiStorie()'>Avanti</button></br>";
	//for (i=inizio; i<fine; i++) { 
						
	//	//alert(MieStorie[i].immagini[0].src);
	//	var testo;
	//	if(MieStorieVisible[i].text!=null)
	//	{
	//		testo = MieStorieVisible[i].text.substring(0,120) + "...";
	//	} 
	//	else {
	//		testo = "";
	//	}
	//	if(MieStorieVisible[i].mementoList[0] != null)
	//	{
	//		if(MieStorieVisible[i].mementoList[0].fileHashcode == null)
	//		{
	//			document.getElementById("divMieStorieDelTempo").innerHTML += "<div style=' width:440px; border-style:solid;border-width:2px;border-color:#000; height:140px; margin-left:15px; margin-bottom:5px;'><div style=' float:left; width:110px; text-align:center; height:140px;'><h5>" + MieStorieVisible[i].startDate.exactDate + "</h5>" + "<h5>" + MieStorieVisible[i].location.country + "</h5>" + "<h5>" + MieStorieVisible[i].location.city + "</h5></div><div style=' float:left;width:216px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:136px; padding: 2px; text-align:left;'><h5 style='text-align:center;'>" + MieStorieVisible[i].headline + "</h5><font size='2'>" + testo + "</font></div>	<div style='float:left;width:110px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:140px; line-height:140px; vertical-align:middle;'><img style='max-width:110px;' src='" + MieStorieVisible[i].mementoList[0].url + "' alt='' /></div></div>";
	//			/*document.getElementById("divMieStorieDelTempo").innerHTML += "<div class='immagini'><div style='line-height:200px;max-height:200px;width:220px;float: left;'> <a class='fancyboxMieStorie' rel='gallery4' href='" + MieStorieVisible[i].mementoList[0].url + "' title='" + MieStorieVisible[i].headline + "' > <img style='vertical-align:middle;max-height:200px;max-width:220px;' src='" + MieStorieVisible[i].mementoList[0].url + "' alt='' /> </a></div><div class='text'>" + MieStorieVisible[i].text +"</div></div>";*/
	//		}
	//		else
	//		{
	//		    document.getElementById("divMieStorieDelTempo").innerHTML += "<div style=' width:440px; border-style:solid;border-width:2px;border-color:#000; height:140px; margin-left:15px; margin-bottom:5px;'><div style=' float:left; width:110px; text-align:center; height:140px;'><h5>" + MieStorieVisible[i].startDate.exactDate + "</h5>" + "<h5>" + MieStorieVisible[i].location.country + "</h5>" + "<h5>" + MieStorieVisible[i].location.city + "</h5></div><div style=' float:left;width:216px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:136px; padding: 2px; text-align:left;'><h5 style='text-align:center;'>" + MieStorieVisible[i].headline + "</h5><font size='2'>" + testo + "</font></div>	<div style='float:left;width:110px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:140px; line-height:140px; vertical-align:middle;'><img style='max-width:110px;' src='" + GetBaseUrl() + "/lifeapi/file/" + MieStorieVisible[i].mementoList[0].fileHashcode + "/THUMBNAIL' alt='' /></div></div>";
	//		    /*document.getElementById("divMieStorieDelTempo").innerHTML += "<div class='immagini'><div style='line-height:200px;max-height:200px;width:220px;float: left;'> <a class='fancyboxMieStorie' rel='gallery4' href='" + "http://test.reminiscens.me/file/" + "LARGE_" + MieStorieVisible[i].mementoList[0].thumbnailUrl + "' title='" + MieStorieVisible[i].headline + "' > <img style='vertical-align:middle;max-height:200px;max-width:220px;' src='" + GetBaseUrl() + "/lifeapi/file/" + MieStorieVisible[i].mementoList[0].Hashcode + "/THUMBNAIL" + "' alt='' /> </a></div><div class='text'>" + MieStorieVisible[i].text +"</div></div>";*/
	//		}
	//	}
	//	else
	//	{
	//		document.getElementById("divMieStorieDelTempo").innerHTML += "<div style=' width:440px; border-style:solid;border-width:2px;border-color:#000; height:140px; margin-left:15px; margin-bottom:5px;'><div style=' float:left; width:110px; text-align:center; height:140px;'><h5>" + MieStorieVisible[i].startDate.exactDate + "</h5>" + "<h5>" + MieStorieVisible[i].location.country + "</h5>" +	"<h5>" + MieStorieVisible[i].location.city + "</h5></div><div style=' float:left;width:216px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:136px; padding: 2px; text-align:left;'><h5 style='text-align:center;'>" + MieStorieVisible[i].headline + "</h5><font size='2'>" + testo + "</font></div>	<div style='float:left;width:110px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:140px; line-height:140px; vertical-align:middle;'><img style='max-width:110px;' src='" + "images/story-book.jpg" + "' alt='' /></div></div>";
	//		/*document.getElementById("divMieStorieDelTempo").innerHTML += "<div class='immagini'><div style='line-height:200px;max-height:200px;width:220px;float: left;'> <a class='fancyboxMieStorie' rel='gallery4' href='" + "images/story-book.jpg" + "' title='" + MieStorieVisible[i].headline + "' > <img style='vertical-align:middle;max-height:200px;max-width:220px;' src='" + "images/story-book.jpg" + "' alt='' /> </a></div><div class='text'>" + MieStorieVisible[i].text +"</div></div>";*/
	//	}
	//}

    document.getElementById("containerCarouselMieStorieDelTempo").innerHTML = "";
	var indice = 0;
	var nPagina = 0;
	var visualizzati = 0;
	var stringaDivCarousel = "<div id='divMieStorieDelTempo' class='carousel slide'>";
	var stringaDivEle = "<div class='carousel-inner'>";
	var stringaDiv = "";
    //document.getElementById("carouselDivMieFotoDelTempo").innerHTML += "<div id='divMieFotoDelTempo" + nPagina + "' class='item active'>";
	while (MieStorieVisible[indice] != null) {
	    if (MieStorieVisible[indice].mementoList.length > 0) {
	        var testo;
	        if (MieStorieVisible[indice].text != null)
	        {
	            testo = MieStorieVisible[indice].text.substring(0,120) + "...";
	        }
	        else {
	            testo = "";
	        }

	        if (MieStorieVisible[indice].mementoList[0] != null)
	        {
	            if (MieStorieVisible[indice].mementoList[0].fileHashcode == null)
	            {
	                stringaDiv += "<div style=' width:440px; border-style:solid;border-width:2px;border-color:#000; height:140px; margin-left:15px; margin-bottom:5px;'><div style=' float:left; width:110px; text-align:center; height:140px;'><h5>" + MieStorieVisible[indice].startDate.exactDate + "</h5>" + "<h5>" + MieStorieVisible[indice].location.country + "</h5>" + "<h5>" + MieStorieVisible[indice].location.city + "</h5></div><div style=' float:left;width:216px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:136px; padding: 2px; text-align:left;'><h5 style='text-align:center;'>" + MieStorieVisible[indice].headline + "</h5><font size='2'>" + testo + "</font></div>	<div style='float:left;width:110px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:140px; line-height:140px; vertical-align:middle;'><img style='max-width:110px;max-height:120px;' src='" + MieStorieVisible[indice].mementoList[0].url + "' alt='' /></div></div>";
	            	/*document.getElementById("divMieStorieDelTempo").innerHTML += "<div class='immagini'><div style='line-height:200px;max-height:200px;width:220px;float: left;'> <a class='fancyboxMieStorie' rel='gallery4' href='" + MieStorieVisible[i].mementoList[0].url + "' title='" + MieStorieVisible[i].headline + "' > <img style='vertical-align:middle;max-height:200px;max-width:220px;' src='" + MieStorieVisible[i].mementoList[0].url + "' alt='' /> </a></div><div class='text'>" + MieStorieVisible[i].text +"</div></div>";*/
	            }
	            else
	            {
	                stringaDiv += "<div style=' width:440px; border-style:solid;border-width:2px;border-color:#000; height:140px; margin-left:15px; margin-bottom:5px;'><div style=' float:left; width:110px; text-align:center; height:140px;'><h5>" + MieStorieVisible[indice].startDate.exactDate + "</h5>" + "<h5>" + MieStorieVisible[indice].location.country + "</h5>" + "<h5>" + MieStorieVisible[indice].location.city + "</h5></div><div style=' float:left;width:216px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:136px; padding: 2px; text-align:left;'><h5 style='text-align:center;'>" + MieStorieVisible[indice].headline + "</h5><font size='2'>" + testo + "</font></div>	<div style='float:left;width:110px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:140px; line-height:140px; vertical-align:middle;'><img style='max-width:110px;max-height:120px;' src='" + GetBaseUrl() + "/lifeapi/file/" + MieStorieVisible[indice].mementoList[0].fileHashcode + "/THUMBNAIL' alt='' /></div></div>";
	            	/*document.getElementById("divMieStorieDelTempo").innerHTML += "<div class='immagini'><div style='line-height:200px;max-height:200px;width:220px;float: left;'> <a class='fancyboxMieStorie' rel='gallery4' href='" + "http://test.reminiscens.me/file/" + "LARGE_" + MieStorieVisible[i].mementoList[0].thumbnailUrl + "' title='" + MieStorieVisible[i].headline + "' > <img style='vertical-align:middle;max-height:200px;max-width:220px;' src='" + GetBaseUrl() + "/lifeapi/file/" + MieStorieVisible[i].mementoList[0].Hashcode + "/THUMBNAIL" + "' alt='' /> </a></div><div class='text'>" + MieStorieVisible[i].text +"</div></div>";*/
	            }
	        }
	        else
	        {
	            stringaDiv += "<div style=' width:440px; border-style:solid;border-width:2px;border-color:#000; height:140px; margin-left:15px; margin-bottom:5px;'><div style=' float:left; width:110px; text-align:center; height:140px;'><h5>" + MieStorieVisible[indice].startDate.exactDate + "</h5>" + "<h5>" + MieStorieVisible[indice].location.country + "</h5>" + "<h5>" + MieStorieVisible[indice].location.city + "</h5></div><div style=' float:left;width:216px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:136px; padding: 2px; text-align:left;'><h5 style='text-align:center;'>" + MieStorieVisible[indice].headline + "</h5><font size='2'>" + testo + "</font></div>	<div style='float:left;width:110px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:140px; line-height:140px; vertical-align:middle;'><img style='max-width:110px;max-height:120px;' src='" + "images/story-book.jpg" + "' alt='' /></div></div>";
	            /*document.getElementById("divMieStorieDelTempo").innerHTML += "<div class='immagini'><div style='line-height:200px;max-height:200px;width:220px;float: left;'> <a class='fancyboxMieStorie' rel='gallery4' href='" + "images/story-book.jpg" + "' title='" + MieStorieVisible[i].headline + "' > <img style='vertical-align:middle;max-height:200px;max-width:220px;' src='" + "images/story-book.jpg" + "' alt='' /> </a></div><div class='text'>" + MieStorieVisible[i].text +"</div></div>";*/
	        }

	        visualizzati++;
	        if (visualizzati == 2) {
	            visualizzati = 0;
	            if (nPagina == 0) {
	                stringaDivEle += "<div class='item active'>" + stringaDiv + "</div>";
	            }
	            else {
	                stringaDivEle += "<div class='item'>" + stringaDiv + "</div>";
	            }

	            nPagina++;
	            stringaDiv = "";
	        }

	    }

	    indice++;
	}

	if (stringaDiv != "") {
	    if (nPagina == 0) {
	        stringaDivEle += "<div class='item active'>" + stringaDiv + "</div>";
	    }
	    else {
	        stringaDivEle += "<div class='item'>" + stringaDiv + "</div>";
	    }
	}

	stringaDivEle += "</div>";

	stringaDivCarousel += stringaDivEle;

	stringaDivCarousel += "<a class='carousel-control left' href='#divMieStorieDelTempo' data-slide='prev'>&lsaquo;</a> <a class='carousel-control right' href='#divMieStorieDelTempo' data-slide='next'>&rsaquo;</a>";
	stringaDivCarousel += "</div>";

	document.getElementById("containerCarouselMieStorieDelTempo").innerHTML = stringaDivCarousel;

	$('.carousel').carousel({
	    interval: false
	});
}