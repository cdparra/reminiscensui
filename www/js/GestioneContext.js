// JavaScript Document
var storage = $.localStorage;
function GetContextId() {
    return storage.get('contextId');
}

function SetContextId(id) {
    storage.set('contextId', id);
}


function InizializzaContextDecadeSchermate(decadeInizialize)
{
	decadeInizialize.story = [];
	decadeInizialize.picture = [];
	decadeInizialize.people = [];
	decadeInizialize.song = [];
	decadeInizialize.tvFilm = [];
}


function InizializzaContextDecade()
{
	Context.MilleNovecento = new Object;
	Context.MilleNovecentoDieci = new Object;
 	Context.MilleNovecentoVenti = new Object;
	Context.MilleNovecentoTrenta = new Object;
 	Context.MilleNovecentoQuaranta = new Object;
	Context.MilleNovecentoCinquanta = new Object;
 	Context.MilleNovecentoSessanta = new Object;
	Context.MilleNovecentoSettanta = new Object;
 	Context.MilleNovecentoOttanta = new Object;
	Context.MilleNovecentoNovanta = new Object;
 	Context.Duemila = new Object;
	Context.DuemilaDieci = new Object;
	Context.DuemilaVenti = new Object;
	
	InizializzaContextDecadeSchermate(Context.MilleNovecento);
	InizializzaContextDecadeSchermate(Context.MilleNovecentoDieci);
	InizializzaContextDecadeSchermate(Context.MilleNovecentoVenti);
	InizializzaContextDecadeSchermate(Context.MilleNovecentoTrenta);
	InizializzaContextDecadeSchermate(Context.MilleNovecentoQuaranta);
	InizializzaContextDecadeSchermate(Context.MilleNovecentoCinquanta);
	InizializzaContextDecadeSchermate(Context.MilleNovecentoSessanta);
	InizializzaContextDecadeSchermate(Context.MilleNovecentoSettanta);
	InizializzaContextDecadeSchermate(Context.MilleNovecentoOttanta);
	InizializzaContextDecadeSchermate(Context.MilleNovecentoNovanta);
	InizializzaContextDecadeSchermate(Context.Duemila);
	InizializzaContextDecadeSchermate(Context.DuemilaDieci);
	InizializzaContextDecadeSchermate(Context.DuemilaVenti);
}

function AggiungiContextDecadeRightCategory(newContext, decadeToPush ,category)
{
	//alert(category);
	switch(category)
	{
		case "STORY":
			//alert(decadeToPush);
			decadeToPush.story.push(newContext);
			break;
		case "PICTURE":
			decadeToPush.picture.push(newContext);
			break;
		case "PEOPLE":
			decadeToPush.people.push(newContext);
			break;
		case "SONG":
			decadeToPush.song.push(newContext);
			break;
	    case "TV":
	        decadeToPush.tvFilm.push(newContext);
	        break;
	    case "FILM":
	        decadeToPush.tvFilm.push(newContext);
	        break;
	}
}
	 
function AggiungiContextDecade(newContext, decade, category)
{
	switch(parseInt(decade))
	{
		case 1900:
			AggiungiContextDecadeRightCategory(newContext, Context.MilleNovecento ,category);
			break;
		case 1910:
			AggiungiContextDecadeRightCategory(newContext, Context.MilleNovecentoDieci ,category);
			break;
		case 1920:
			AggiungiContextDecadeRightCategory(newContext, Context.MilleNovecentoVenti ,category);
  			break;
		case 1930:
			AggiungiContextDecadeRightCategory(newContext, Context.MilleNovecentoTrenta ,category);
			break;
		case 1940:
			AggiungiContextDecadeRightCategory(newContext, Context.MilleNovecentoQuaranta ,category);
  			break;
		case 1950:
			AggiungiContextDecadeRightCategory(newContext, Context.MilleNovecentoCinquanta ,category);
			break;
		case 1960:
			AggiungiContextDecadeRightCategory(newContext, Context.MilleNovecentoSessanta ,category);
  			break;
		case 1970:
			AggiungiContextDecadeRightCategory(newContext, Context.MilleNovecentoSettanta ,category);
			break;
		case 1980:
			AggiungiContextDecadeRightCategory(newContext, Context.MilleNovecentoOttanta ,category);
  			break;
		case 1990:
			AggiungiContextDecadeRightCategory(newContext, Context.MilleNovecentoNovanta ,category);
	  		break;
		case 2000:
			AggiungiContextDecadeRightCategory(newContext, Context.Duemila ,category);
  			break;
		case 2010:
			AggiungiContextDecadeRightCategory(newContext, Context.DuemilaDieci ,category);
	  		break;
		case 2020:
			AggiungiContextDecadeRightCategory(newContext, Context.DuemilaVenti ,category);
	  		break;
	}
}
	 
function RecuperaContextDecade()
{
	 vettIndexContextVisible = [];  //devo cancellare gli indici ogni volta che passo a una decade diversa
	 switch(parseInt(decade))
 	 {
		case 1900:
 			return Context.MilleNovecento;
  			break;
		case 1910:
			return Context.MilleNovecentoDieci;
	  		break;
		case 1920:
 			return Context.MilleNovecentoVenti;
  			break;
		case 1930:
			return Context.MilleNovecentoTrenta;
	  		break;
		case 1940:
 			return Context.MilleNovecentoQuaranta;
  			break;
		case 1950:
			return Context.MilleNovecentoCinquanta;
	  		break;
		case 1960:
 			return Context.MilleNovecentoSessanta;
  			break;
		case 1970:
			return Context.MilleNovecentoSettanta;
	  		break;
		case 1980:
 			return Context.MilleNovecentoOttanta;
  			break;
		case 1990:
			return Context.MilleNovecentoNovanta;
	  		break;
		case 2000:
 			return Context.Duemila;
  			break;
		case 2010:
			return Context.DuemilaDieci;
	  		break;
		case 2020:
			return Context.DuemilaVenti;
	  		break;
	}
}

/*function DecadeIsEmpty()
{
	switch(parseInt(decade))
	{
		case 1900:
			if(Context.MilleNovecento.length !=0)
				return false;
  			break;
		case 1910:
			if(Context.MilleNovecentoDieci.length !=0)
				return false;
			break;
		case 1920:
 			if(Context.MilleNovecentoVenti.length !=0)
				return false;
  			break;
		case 1930:
			if(Context.MilleNovecentoTrenta.length !=0)
				return false;
			break;
		case 1940:
			//alert(Context.MilleNovecentoQuaranta.length);
 			if(Context.MilleNovecentoQuaranta.length !=0)
				return false;
  			break;
		case 1950:
			//alert(Context.MilleNovecentoCinquanta.length);
			if(Context.MilleNovecentoCinquanta.length !=0)
				return false;
			break;
		case 1960:
 			if(Context.MilleNovecentoSessanta.length !=0)
				return false;
  			break;
		case 1970:
			if(Context.MilleNovecentoSettanta.length !=0)
				return false;
			break;
		case 1980:
 			if(Context.MilleNovecentoOttanta.length !=0)
				return false;
  			break;
		case 1990:
			if(Context.MilleNovecentoNovanta.length !=0)
				return false;
			break;
		case 2000:
 			if(Context.Duemila.length !=0)
				return false;
  			break;
		case 2010:
			if(Context.DuemilaDieci.length !=0)
				return false;
			break;
		case 2020:
			if(Context.DuemilaVenti.length !=0)
				return false;
			break;
	}
		
	return true;
}*/

function EstraiCampiContext(contextList) {
    var i = 0;
    while (contextList[i] != null && contextList[i].publicMemento != null) {
        //alert(contextList[i].startLocation.city);
        var newContext = new Object;
        newContext.contextId = contextList[i].contextId;
        newContext.publicMementoId = contextList[i].publicMemento.publicMementoId;
        newContext.headline = contextList[i].publicMemento.headline;
        newContext.text = contextList[i].publicMemento.text;
        newContext.resourceType = contextList[i].publicMemento.resourceType;
        newContext.startDate = new Object;
        if (contextList[i].publicMemento.startDate != null) {
            newContext.startDate.day = contextList[i].publicMemento.startDate.day;
            newContext.startDate.month = contextList[i].publicMemento.startDate.moth;
            newContext.startDate.year = contextList[i].publicMemento.startDate.year;
            newContext.startDate.decade = contextList[i].publicMemento.startDate.decade;
            newContext.startDate.exactDateAsString = contextList[i].publicMemento.startDate.exactDateAsString;
        }
        newContext.startLocation = new Object;
            
        if (contextList[i].publicMemento.startLocation != null) {
            newContext.startLocation.city = contextList[i].publicMemento.startLocation.city;
            newContext.startLocation.region = contextList[i].publicMemento.startLocation.region;
            newContext.startLocation.country = contextList[i].publicMemento.startLocation.country;
            newContext.source = contextList[i].publicMemento.source;
            newContext.sourceUrl = contextList[i].publicMemento.sourceUrl;
            newContext.resourceUrl = contextList[i].publicMemento.resourceUrl;
        }

        AggiungiContextDecade(newContext, contextList[i].decade, contextList[i].category);
        i++;
    }

    //alert(Context.MilleNovecentoNovanta.story[0].text);

    var storage = $.localStorage;
    storage.set('Context', Context);


    ContextVisible = RecuperaContextDecade();

    stampaFotoContext(0, ContextVisible.picture.length);
    stampaStorieContext(0, ContextVisible.story.length);
    stampaCanzoniContext(0, ContextVisible.song.length);
    stampaFamosiContext(0, ContextVisible.people.length);
    stampaTvFilmContext(0, ContextVisible.tvFilm.length);
    aggiungiEventoFancyBox();
    /*stampaMieContext(0,MieContextVisible.length);
    
    //alert(msg.aboutPerson.personId);

    GestioneSchermate(); nn serve chiamare di nuovo gestione schermate in quanto sono gia posizionato 
                        nella schermata corretta*/
}

function ContextFunction()
{
	InizializzaContextDecade();
	$.ajax({
	    type: "GET",
	    url: GetBaseUrl() + "/lifeapi/context/person/"+GetPersonId(),
           	//url: "http://test.reminiscens.me/lifeapi/context/person/"+GetPersonId(),
			beforeSend: function (request)
            {
                request.setRequestHeader("PLAY_SESSION", GetSessionKey());
            },
            processData: false,
            dataType: "json",
			contentType:"application/json",
        	error: function (data) {

        	    alert("errore caricamento context");

        	},
			success: function(data) 
			{
			    //alert(data.contextId);
			    SetContextId(data.contextId);
				//alert("ciao");
				//alert(timeline.aboutPerson.personId );
				var contextList = data.publicMementoList;
				EstraiCampiContext(contextList);
            }
        	
   		});
}

function InserisciIndiceFotoContext(index)
{
	vettIndexFotoContextVisible.push(index);
}

function stampaFotoContext(inizio, fine)
{
	//alert(inizio + "  " + fine);
	
	//var i;
	//document.getElementById("divFotoDelTempo").innerHTML = "";
	//for (i=inizio; i<fine; i++) { 		
	//	if(ContextVisible.picture[i].resourceUrl != null)
	//	{
	//		//alert(MieStorieVisible[i].mementoList.length);
	//		InserisciIndiceFotoContext(i);
	//		document.getElementById("divFotoDelTempo").innerHTML += "<div class='immaginiFoto'><a class='fancyboxFotoContext' rel='gallery1' href='" + ContextVisible.picture[i].resourceUrl + "' title='" + ContextVisible.picture[i].headline + "' > <img style='max-width:195px;max-height:140px;' src='" + ContextVisible.picture[i].resourceUrl + "' alt='' /> </a></br></div>"
				
	//	}
	//	else
	//	{
	//	}
	//}



	document.getElementById("carouselDivFotoDelTempo").innerHTML = "";
	var indice = 0;
	var nPagina = 0;
	var visualizzati = 0;
	var stringaDiv = "";
    //document.getElementById("carouselDivMieFotoDelTempo").innerHTML += "<div id='divMieFotoDelTempo" + nPagina + "' class='item active'>";
	while (ContextVisible.picture[indice] != null) {
	    if (ContextVisible.picture[indice].resourceUrl != null)
	    {
	        //alert(MieStorieVisible[i].mementoList.length);
	        InserisciIndiceFotoContext(indice);
	        stringaDiv += "<div class='immaginiFoto'><a class='fancyboxFotoContext' rel='gallery1' href='" + ContextVisible.picture[indice].resourceUrl + "' title='" + ContextVisible.picture[indice].headline + "' > <img style='max-width:225px;max-height:200px;' src='" + ContextVisible.picture[indice].resourceUrl + "' alt='' /> </a></br></div>"

	    }
	    else
	    {
	    }

	    visualizzati++;
	    if (visualizzati == 4) {
	        visualizzati = 0;
	        if (nPagina == 0) {
	            document.getElementById("carouselDivFotoDelTempo").innerHTML += "<div class='item active'>" + stringaDiv + "</div>";
	        }
	        else {
	            document.getElementById("carouselDivFotoDelTempo").innerHTML += "<div class='item'>" + stringaDiv + "</div>";
	        }

	        nPagina++;
	        stringaDiv = "";
	    }


	    indice++;
	}

	if (stringaDiv != "") {
	    if (nPagina == 0) {
	        document.getElementById("carouselDivFotoDelTempo").innerHTML += "<div class='item active'>" + stringaDiv + "</div>";
	    }
	    else {
	        document.getElementById("carouselDivFotoDelTempo").innerHTML += "<div class='item'>" + stringaDiv + "</div>";
	    }
    }


    //document.getElementById("divFotoDelTempo").innerHTML = "";
    //var indice = 0;
    //var nPagina = 0;
    //var visualizzati = 0;
    //var stringaDiv = "";
    //var stringaDivEle = "<div class='carousel-inner'>";
    ////document.getElementById("carouselDivMieFotoDelTempo").innerHTML += "<div id='divMieFotoDelTempo" + nPagina + "' class='item active'>";
    //while (ContextVisible.picture[indice] != null) {
    //    if (ContextVisible.picture[indice].resourceUrl != null) {
    //        //alert(MieStorieVisible[i].mementoList.length);
    //        InserisciIndiceFotoContext(indice);
    //        stringaDiv += "<div class='immaginiFoto'><a class='fancyboxFotoContext' rel='gallery1' href='" + ContextVisible.picture[indice].resourceUrl + "' title='" + ContextVisible.picture[indice].headline + "' > <img style='max-width:225px;max-height:200px;' src='" + ContextVisible.picture[indice].resourceUrl + "' alt='' /> </a></br></div>"

    //    }
    //    else {
    //    }

    //    visualizzati++;
    //    if (visualizzati == 4) {
    //        visualizzati = 0;
    //        if (nPagina == 0) {
    //            stringaDivEle += "<div class='item active'>" + stringaDiv + "</div>";
    //        }
    //        else {
    //            stringaDivEle += "<div class='item'>" + stringaDiv + "</div>";
    //        }

    //        nPagina++;
    //        stringaDiv = "";
    //    }


    //    indice++;
    //}

    //if (stringaDiv != "") {
    //    if (nPagina == 0) {
    //        stringaDivEle += "<div class='item active'>" + stringaDiv + "</div>";
    //    }
    //    else {
    //        stringaDivEle += "<div class='item'>" + stringaDiv + "</div>";
    //    }
    //}

    //stringaDivEle += "</div>";

    //document.getElementById("divFotoDelTempo").innerHTML += stringaDivEle;

    //document.getElementById("divFotoDelTempo").innerHTML += "<a class='carousel-control left' href='#divFotoDelTempo' data-slide='prev'>&lsaquo;</a> <a class='carousel-control right' href='#divFotoDelTempo' data-slide='next'>&rsaquo;</a>";

	$('.carousel').carousel({
        number: nPagina
	});
}

function stampaStorieContext(inizio, fine)
{
    document.getElementById("carouselDivStorieDelTempo").innerHTML = "";
    var indice = 0;
    var nPagina = 0;
    var visualizzati = 0;
    var stringaDiv = "";
    //document.getElementById("carouselDivMieFotoDelTempo").innerHTML += "<div id='divMieFotoDelTempo" + nPagina + "' class='item active'>";
    while (ContextVisible.story[indice] != null) {
    	// these variables are added to avoid nulls from being printed
    	var story = ContextVisible.story[indice];
    	var h = story.headline == null ? "" : story.headline;
    	var t = story.text == null ? "" : story.text;
    	var tipo = story.resourceType
    	var startDate = story.startDate.exactDateAsString == null ? startDate.decade : story.startDate.exactDateAsString; 
    	var startLocation =  story.startLocation.country == null ? 
    			"" : story.startLocation.region == null ? 
    					story.startLocation.country : story.startLocation.city == null ? 
    							story.startLocation.region +", " +story.startLocation.country : 
    							story.startLocation.region +","+story.startLocation.region +", " +story.startLocation.country ;

        if (story.resourceUrl != null)
        {
            stringaDiv += "<div style=' width:440px; border-style:solid;border-width:2px;border-color:#000; height:140px; margin-left:15px; margin-bottom:5px;'>"
            stringaDiv += "	<div style=' float:left; width:110px; text-align:center; height:140px;'><h5>" 
            stringaDiv += startDate + "</h5>" + "<h5>" + startLocation+ "</h5></div><div style=' float:left;width:216px; text-align:center;background: rgba(0,0,0,0.7);";
            stringaDiv += "color: #FFF;height:136px; padding: 2px; text-align:left;'><h5 style='text-align:center;'>" + h + "</h5><h7>" + t.substring(0, 120) + "...</h7>";
            stringaDiv += "</div>	<div style='float:left;width:110px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:140px; line-height:140px; ";
            stringaDiv += "vertical-align:middle;'><img style='max-width:110px;max-height:120px;' src='" + story.resourceUrl + "' alt='' /></div></div>";
        }
        else
        {
            stringaDiv += "<div style=' width:440px; border-style:solid;border-width:2px;border-color:#000; height:140px; margin-left:15px; margin-bottom:5px;'>";
            stringaDiv += "<div style=' float:left; width:110px; text-align:center; height:140px;'><h5>" + startDate + "</h5>" + "<h5>" + startLocation + "</h5>";
            stringaDiv += "</div><div style=' float:left;width:216px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:136px; padding: 2px; ";
            stringaDiv += "text-align:left;'><h5 style='text-align:center;'>" + h + "</h5><font size='2'>" + t.substring(0, 120) + "...</font></div>";
            stringaDiv += "<div style='float:left;width:110px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:140px; line-height:140px; ";
            stringaDiv += "vertical-align:middle;'><img style='max-width:110px;max-height:120px;' src='" + "images/story-book.jpg" + "' alt='' /></div></div>";
        }

        visualizzati++;
        if (visualizzati == 2) {
            visualizzati = 0;
            if (nPagina == 0) {
                document.getElementById("carouselDivStorieDelTempo").innerHTML += "<div class='item active'>" + stringaDiv + "</div>";
            }
            else {
                document.getElementById("carouselDivStorieDelTempo").innerHTML += "<div class='item'>" + stringaDiv + "</div>";
            }

            nPagina++;
            stringaDiv = "";
        }
        indice++;
    }

    if (stringaDiv != "") {
        if (nPagina == 0) {
            document.getElementById("carouselDivStorieDelTempo").innerHTML += "<div class='item active'>" + stringaDiv + "</div>";
        }
        else {
            document.getElementById("carouselDivStorieDelTempo").innerHTML += "<div class='item'>" + stringaDiv + "</div>";
        }
    }

    /*$('#divFotoDelTempo').carousel({
        number:nPagina
    });*/
}

function stampaCanzoniContext(inizio, fine)
{
    document.getElementById("carouselDivCanzoniDelTempo").innerHTML = "";
    var indice = 0;
    var nPagina = 0;
    var visualizzati = 0;
    var stringaDiv = "";
    while (ContextVisible.song[indice] != null) {
    	var song = ContextVisible.song[indice];
    	var h = song.headline == null ? "" : song.headline;
    	var t = song.text == null ? "" : song.text;
    	var tipo = song.resourceType;
	
        if (song.resourceUrl != null)
        {
            //replace necessario per permettere di introdurre contenuti di youtube sul sito
            var url = song.resourceUrl.replace('watch?v=', 'embed/');
                stringaDiv += "<div id='songCarousel'"+song.publicMementoId+ "style='margin: 0px 40px 0px 40px;float:left;max-width:420px;'>";
            stringaDiv += "<iframe width='420' height='315' src='" + url + "' frameborder='0' allowfullscreen style='margin-top:30px;'></iframe><h3>";
            stringaDiv += h +"</h3><h7 style='text-align:center;'>" + t + "</h7>";
            stringaDiv += "</div>";
            //document.getElementById("divCanzoni" + numeroDiv).innerHTML += "<iframe width='420' height='315' src='" + "http://www.youtube.com/embed/XVXzlPqViXA?autoplay=true" + "' frameborder='0' allowfullscreen style='margin-top:30px;'></iframe><h3>" + ContextVisible.song[i].headline +"</h3>";

            //$("'songCarousel'"+song.publicMementoId).click(postDetailViews(song.publicMementoId));
        }
        

        visualizzati++;
        if (visualizzati == 2) {
            visualizzati = 0;
            if (nPagina == 0) {
                document.getElementById("carouselDivCanzoniDelTempo").innerHTML += "<div class='item active'>" + stringaDiv + "</div>";
            }
            else {
                document.getElementById("carouselDivCanzoniDelTempo").innerHTML += "<div class='item'>" + stringaDiv + "</div>";
            }

            nPagina++;
            stringaDiv = "";
        }
        indice++;
    }

    if (stringaDiv != "") {
        if (nPagina == 0) {
            document.getElementById("carouselDivCanzoniDelTempo").innerHTML += "<div class='item active'>" + stringaDiv + "</div>";
        }
        else {
            document.getElementById("carouselDivCanzoniDelTempo").innerHTML += "<div class='item'>" + stringaDiv + "</div>";
        }
    }
}


function stampaFamosiContext(inizio, fine)
{
	document.getElementById("carouselDivFamosiDelTempo").innerHTML = "";
    var indice = 0;
    var nPagina = 0;
    var visualizzati = 0;
    var stringaDiv = "";
    while (ContextVisible.people[indice] != null) {
    	var h = ContextVisible.people[indice].headline == null ? "" : ContextVisible.people[indice].headline;
    	var t = ContextVisible.people[indice].text == null ? "" : ContextVisible.people[indice].text;
        if (ContextVisible.people[indice].resourceUrl != null)
        {
            stringaDiv += "<div style='align: center; margin: 0px 40px 0px 40px;float:left;width:420px;'>";
            stringaDiv += "<img style='max-width:500px; max-height:300px;margin-top:30px;' src='" + ContextVisible.people[indice].resourceUrl;
            stringaDiv +="' class='round'/><h5>" + h + "</h5><h7>" + t + "</h7>";
            stringaDiv += "</div>";
        } else {
            stringaDiv += "<div style='align: center; margin: 0px 40px 0px 40px;float:left;width:420px;'>";
            stringaDiv += "<img style='max-width:500px; max-height:300px;margin-top:30px;' src='" + "images/profilo.png";
            stringaDiv +="' class='round'/><h5>" + h + "</h5><h7>" + t + "</h7>";
            stringaDiv += "</div>";
        	
        }

        visualizzati++;
        if (visualizzati == 2) {
            visualizzati = 0;
            if (nPagina == 0) {
                document.getElementById("carouselDivFamosiDelTempo").innerHTML += "<div class='item active'>" + stringaDiv + "</div>";
            }
            else {
                document.getElementById("carouselDivFamosiDelTempo").innerHTML += "<div class='item'>" + stringaDiv + "</div>";
            }

            nPagina++;
            stringaDiv = "";
        }
        indice++;
    }

    if (stringaDiv != "") {
        if (nPagina == 0) {
            document.getElementById("carouselDivCanzoniDelTempo").innerHTML += "<div class='item active'>" + stringaDiv + "</div>";
        }
        else {
            document.getElementById("carouselDivCanzoniDelTempo").innerHTML += "<div class='item'>" + stringaDiv + "</div>";
        }
    }
	
}

function stampaTvFilmContext(inizio, fine) {
    document.getElementById("carouselDivTVDelTempo").innerHTML = "";
    var indice = 0;
    var nPagina = 0;
    var visualizzati = 0;
    var stringaDiv = "";
    while (ContextVisible.tvFilm[indice] != null) {
    	var tvFilm = ContextVisible.tvFilm[indice];
    	var h = tvFilm.headline == null ? "" : tvFilm.headline;
    	var t = tvFilm.text == null ? "" : tvFilm.text;
    	var tipo = tvFilm.resourceType;

    	if (tvFilm.resourceUrl != null)
        {
    		var url = "";
    		stringaDiv += "<div style='align: center; margin: 0px 40px 0px 40px;float:left;width:420px;'>";
    		if (tipo=="IMAGE") {
    			url = tvFilm.resourceUrl;
    			stringaDiv += "<img style='max-width:500px; max-height:300px;margin-top:30px;' src='" + url;
    			stringaDiv +="' class='round'/><h4>" + h + "</h4><h6>" + t + "</h6>";
    		} else {
    			url = tvFilm.resourceUrl.replace('watch?v=', 'embed/');
    			stringaDiv += "<iframe width='420' height='315' src='" + url + "' frameborder='0' allowfullscreen style='margin-top:30px;'></iframe><h5>"; 
    			stringaDiv += h + "</h5><h7 style='text-align:center;'>" + t + "</h7>";
    		}
            stringaDiv += "</div>";
        } else {
            stringaDiv += "<div style='align: center; margin: 0px 40px 0px 40px;float:left;width:420px;'>";
            stringaDiv += "<img style='max-width:500px; max-height:300px;margin-top:30px;' src='" + "images/profilo.png";
            stringaDiv +="' class='round'/><h5>" + h + "</h5><h7>" + t + "</h7>";
            stringaDiv += "</div>";
        	
        }

        visualizzati++;
        if (visualizzati == 2) {
            visualizzati = 0;
            if (nPagina == 0) {
                document.getElementById("carouselDivTVDelTempo").innerHTML += "<div class='item active'>" + stringaDiv + "</div>";
            }
            else {
                document.getElementById("carouselDivTVDelTempo").innerHTML += "<div class='item'>" + stringaDiv + "</div>";
            }

            nPagina++;
            stringaDiv = "";
        }
        indice++;
    }

    if (stringaDiv != "") {
        if (nPagina == 0) {
            document.getElementById("carouselDivTVDelTempo").innerHTML += "<div class='item active'>" + stringaDiv + "</div>";
        }
        else {
            document.getElementById("carouselDivTVDelTempo").innerHTML += "<div class='item'>" + stringaDiv + "</div>";
        }
    }
}

function CreaContext() {
    $.ajax({
        type: "POST",
        beforeSend: function (request) {
            request.setRequestHeader("PLAY_SESSION", GetSessionKey());
        },        
        url: GetBaseUrl() + "/lifeapi/context/person/" + GetPersonId(),
        //url: "http://test.reminiscens.me/lifeapi/user/signup",

        data: "{}",

        dataType: "json",
        contentType: "application/json",

        async: false,

        success: function (data) {
            //salert("hola");

        },
        error: function (data) {
            alert("Errore nella creazione del context personale");
        }
    });
}

function AggiornaContext(country, city, region, locale, decade) {
    var contextData = new Object();
    contextData.country = country;
    contextData.region = region;
    contextData.city = city;
    contextData.locale = locale;
    $.ajax({
        type: "PUT",
        beforeSend: function (request) {
            request.setRequestHeader("PLAY_SESSION", GetSessionKey());
        },
        url: GetBaseUrl() + "/lifeapi/context/" + GetContextId() + "/" + decade + "/location",
        //url: "http://test.reminiscens.me/lifeapi/user/signup",

        data: JSON.stringify(contextData),

        dataType: "json",
        contentType: "application/json",

        async: false,

        success: function (data) {
            //salert("hola");
            var contextList = data.publicMementoList;
            EstraiCampiContext(contextList);

        },
        error: function (data) {
            alert("Errore nell'aggiornamento del context personale");
        }

    });
}

/*$(document).ready(function() {	
	/*$.ajax({
            type:"GET",
           	url: "http://test.reminiscens.me/lifeapi/context/person/"+GetPersonId(),
			beforeSend: function (request)
            {
                request.setRequestHeader("PLAY_SESSION", GetSessionKey());
            },
            processData: false,
            dataType: "json",
			contentType:"application/json",
        	error: function (data) {

        	    //alert("error");

        	},
			success: function(timeline) 
			{
				alert("ciao");
            }
        	
   		});*/
	
//})