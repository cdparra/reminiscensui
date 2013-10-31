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
        //alert(contextList[i].contextId);
        var newContext = new Object;
        //newContext.contextId = contextList[i].contextId;
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
            if (contextList[i].publicMemento.sourceUrl != null)
                newContext.sourceUrl = contextList[i].publicMemento.sourceUrl.replace("'", "%27");
            else
                newContext.sourceUrl = contextList[i].publicMemento.sourceUrl;
            if (contextList[i].publicMemento.resourceUrl != null)
                newContext.resourceUrl = contextList[i].publicMemento.resourceUrl.replace("'", "%27");
            else
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
			    
			    if (isContext) {
			        var contextList = data.publicMementoList;
			        EstraiCampiContext(contextList);
			    }
            }
        	
   		});
}

//function InserisciIndiceFotoContext(index)
//{
//	vettIndexFotoContextVisible.push(index);
//}

function statisticaVIEWS(publicMementoId)
{

    // instead of calling the service, let's just count in a hash table which we will later send in one post 
	// addedd to replace in the future the count on view
    if (views[publicMementoId+""]==null) {
    	views[publicMementoId+""]=1;
    } else {
    	views[publicMementoId+""]++;
    } 
	
    $.ajax({
        type: "POST",
        beforeSend: function (request) {
            request.setRequestHeader("PLAY_SESSION", GetSessionKey());
        },
        url: GetBaseUrl() + "/lifeapi/log/VIEWS/context/" + GetContextId() + "/memento/" + publicMementoId,
        //url: "http://test.reminiscens.me/lifeapi/user/signup",

        data: "{}",

        dataType: "json",
        contentType: "application/json",

      //  async: false,

        success: function (data) {
            //salert("hola");

        },
        error: function (data) {
            console.log("Errore nel passaggio di statistiche");
        }
    });
}

function stampaFotoContext(inizio, fine)
{    
    document.getElementById("containerCarouselFotoDelTempo").innerHTML = "";
    //document.getElementById("divFotoDelTempo").innerHTML = "";
    var indice = 0;
    var nPagina = 0;
    var visualizzati = 0;    
    var stringaDivCarousel = "<div id='divFotoDelTempo' class='carousel slide'>";
    var stringaDivEle = "<div class='carousel-inner'>";
    var stringaDiv = "";
    //alert(ContextVisible.picture.length);
    //document.getElementById("carouselDivMieFotoDelTempo").innerHTML += "<div id='divMieFotoDelTempo" + nPagina + "' class='item active'>";
    while (ContextVisible.picture[indice] != null) {
        if (ContextVisible.picture[indice].resourceUrl != null) {
            //alert(MieStorieVisible[i].mementoList.length);
            //alert(indice);
            //InserisciIndiceFotoContext(indice);
            var imageGet = GetImage(ContextVisible.picture[indice].publicMementoId, true);
            if (imageGet != null) {
                stringaDiv += "<div class='immaginiFoto'><a class='fancyboxFotoContext' rel='gallery1' href='" + imageGet + "' title='" + ContextVisible.picture[indice].headline + "' > <img style='max-width:225px;max-height:200px;' src='" + imageGet + "' alt='' /> </a></br></div>";
            }
            else {
                stringaDiv += "<div class='immaginiFoto'><a class='fancyboxFotoContext' rel='gallery1' href='" + ContextVisible.picture[indice].resourceUrl + "' title='" + ContextVisible.picture[indice].headline + "' > <img id='ContextFotoMementoId" + indice + "' style='max-width:225px;max-height:200px;' src='" + ContextVisible.picture[indice].resourceUrl + "' alt='' /> </a></br></div>";
                //GetSetImage(ContextVisible.picture[indice].publicMementoId, null, ContextVisible.picture[indice].resourceUrl, "ContextFotoMementoId", true);
            }
            if(nPagina == 0)
            {
                //siccome faccio sempre vedere prima le foto quelle delle prima pagina posso metterle come statistica VIEWS
                statisticaVIEWS(ContextVisible.picture[indice].publicMementoId);
            }
        }
        else {
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

    stringaDivCarousel += "<a class='carousel-control left' href='#divFotoDelTempo' data-slide='prev'>&lsaquo;</a> <a class='carousel-control right' href='#divFotoDelTempo' data-slide='next'>&rsaquo;</a>";
    stringaDivCarousel += "</div>";

    document.getElementById("containerCarouselFotoDelTempo").innerHTML = stringaDivCarousel;


    $('#divFotoDelTempo').carousel({
        interval: false
    });

    $("#divFotoDelTempo").bind("slid", function () {
        //alert( "ciao" );
        //document.getElementById("item2").innerHTML = "ciao";
        indexCarouselFoto++;

        if (indexCarouselFoto > nPagina)
            indexCarouselFoto = 0;

        for(var i = indexCarouselFoto * 4; i < ((indexCarouselFoto * 4) + 4); i++)
        {
            if (ContextVisible.picture[i] == null) {
                //alert(indexCarouselFoto);
                break;
            }
            else {
                statisticaVIEWS(ContextVisible.picture[i].publicMementoId);
            }
        }
        
    });

    /*var image = document.getElementById("ContextFotoMementoId0");
    if (image.addEventListener) {
        image.addEventListener('load', function () {
            var result = image.getAttribute('src');
            try {
                //localStorage.set(id, result);
                var storage = $.localStorage;
                var immaginiPubbliche = storage.get("immaginiPubbliche");
                immaginiPubbliche[id] = result;
                storage.set("immaginiPubbliche", immaginiPubbliche);
            }
            catch (e) {
                console.log("Storage failed: " + e);
            }
        });
    } else {
        // it's IE!
        image.attachEvent('onload', function () {
        });
    }*/

    /*$("#ContextFotoMementoId0").load(function () {
        //alert(e.target.result);
        //alert($("#ContextFotoMementoId0").attr('src'));
        /*var array = [];
        array.push("http://www.elisabistocchi.org/wp-content/uploads/2010/07/wallpaper_gattone.jpg");
        var blob = new Blob([array], { type: "image/png" });
        var FR = new FileReader();
        FR.onload = function(e)
        {
            //alert("ciao");
            //alert(e.target.result);
            var result = e.target.result;
            var img = document.getElementById("provaImgLocale");
            img.setAttribute('src', result);
        }
        FR.readAsDataURL(blob);
        //FR.readAsText($("#ContextFotoMementoId0").attr('src'));

        alert(getBase64Image(document.getElementById("ContextFotoMementoId0")));
    });*/
}

/*function getBase64Image(img) {
    // Create an empty canvas element
    var canvas = document.createElement("canvas");
    canvas.width = img.width;
    canvas.height = img.height;

    // Copy the image contents to the canvas
    var ctx = canvas.getContext("2d");
    ctx.drawImage(img, 0, 0);

    // Get the data-URL formatted image
    // Firefox supports PNG and JPEG. You could check img.src to
    // guess the original format, but be aware the using "image/jpg"
    // will re-encode the image.
    var dataURL = canvas.toDataURL("image/png");

    return dataURL.replace(/^data:image\/(png|jpg);base64,/, "");
}*/

function stampaStorieContext(inizio, fine)
{
    document.getElementById("containerCarouselStorieDelTempo").innerHTML = "";
    var indice = 0;
    var nPagina = 0;
    var visualizzati = 0;
    var stringaDivCarousel = "<div id='divStorieDelTempo' class='carousel slide'>";
    var stringaDivEle = "<div class='carousel-inner'>";
    var stringaDiv = "";
    var margin = 23;
    //document.getElementById("carouselDivMieFotoDelTempo").innerHTML += "<div id='divMieFotoDelTempo" + nPagina + "' class='item active'>";
    while (ContextVisible.story[indice] != null) {
    	// these variables are added to avoid nulls from being printed
    	var story = ContextVisible.story[indice];
    	var h = story.headline == null ? "" : story.headline;
    	var t = story.text == null ? "" : story.text;
    	var tipo = story.resourceType;
    	var startDate = story.startDate.exactDateAsString == null ? story.startDate.decade : story.startDate.exactDateAsString.replace("00:00:00",""); 
    	var startLocation =  story.startLocation.country == null ? 
    			"" : story.startLocation.region == null ? 
    					story.startLocation.country : story.startLocation.city == null ? 
    							story.startLocation.region +", " +story.startLocation.country : 
    							story.startLocation.region + "," + story.startLocation.region + ", " + story.startLocation.country;

        if (story.resourceUrl != null)
        {
            stringaDiv += "<div style='float:left;width:440px; border-style:solid;border-width:2px;border-color:#000; height:200px; margin-left:" + margin + "px; margin-right:" + margin + "px; margin-bottom:5px;'>";
            stringaDiv += "<a class='fancyboxStorieContext linkStorie' rel='gallery3' href='" + story.resourceUrl + "' title='prova'>";
            stringaDiv += "<h4>" + h + "</h4>";
            stringaDiv += "<h5 style='float:left; margin-top:-5px; margin-left:3px;'>" + startDate + "</h5>";
            stringaDiv += "<h5 style='float: right; margin-top: -5px; margin-right:3px;'>" + startLocation + "</h5><br><br>";
            stringaDiv += "<p style='float:left; text-align:justify; padding:3px 3px 3px 3px;width:438px;'><img style='float:right;max-width:115px;max-height:115px; padding:3px 3px 3px 3px;' src='" + story.resourceUrl + "' alt='' />" + t.substring(0, 300) + "...</p>";
            stringaDiv += "</a></div>";

            //stringaDiv += "<div style='float:left;width:440px; border-style:solid;border-width:2px;border-color:#000; height:200px; margin-left:" + margin + "px; margin-right:" + margin + "px; margin-bottom:5px;'>";
            //stringaDiv += "	<div style=' float:left; width:110px; text-align:center; height:200px;'><h5>" 
            //stringaDiv += startDate + "</h5>" + "<h5>" + startLocation+ "</h5></div><div style=' float:left;width:216px; text-align:center;background: rgba(0,0,0,0.7);";
            //stringaDiv += "color: #FFF;height:196px; padding: 2px; text-align:left;'><h5 style='text-align:center;'>" + h + "</h5><h7>" + t.substring(0, 120) + "...</h7>";
            //stringaDiv += "</div>	<div style='float:left;width:110px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:200px; line-height:200px; ";
            //stringaDiv += "vertical-align:middle;'><img style='max-width:110px;max-height:180px;' src='" + story.resourceUrl + "' alt='' /></div></div>";
        }
        else
        {
            //stringaDiv += "<div style='float:left;width:440px; border-style:solid;border-width:2px;border-color:#000; height:200px; margin-left:" + margin + "px; margin-right:" + margin + "px; margin-bottom:5px;'>";
            //stringaDiv += "<div style=' float:left; width:110px; text-align:center; height:200px;'><h5>" + startDate + "</h5>" + "<h5>" + startLocation + "</h5>";
            //stringaDiv += "</div><div style=' float:left;width:216px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:196px; padding: 2px; ";
            //stringaDiv += "text-align:left;'><h5 style='text-align:center;'>" + h + "</h5><font size='2'>" + t.substring(0, 120) + "...</font></div>";
            //stringaDiv += "<div style='float:left;width:110px; text-align:center;background: rgba(0,0,0,0.7);color: #FFF;height:200px; line-height:200px; ";
            //stringaDiv += "vertical-align:middle;'><img style='max-width:110px;max-height:180px;' src='" + "images/story-book.jpg" + "' alt='' /></div></div>";

            stringaDiv += "<div style='float:left;width:440px; border-style:solid;border-width:2px;border-color:#000; height:200px; margin-left:" + margin + "px; margin-right:" + margin + "px; margin-bottom:5px;'>";
            stringaDiv += "<a class='fancyboxStorieContext linkStorie' rel='gallery3' href='images/story-book.jpg' title='prova'>";
            stringaDiv += "<h4>" + h + "</h4>";
            stringaDiv += "<h5 style='float:left; margin-top:-5px; margin-left:3px;'>" + startDate + "</h5>";
            stringaDiv += "<h5 style='float: right; margin-top: -5px; margin-right:3px;'>" + startLocation + "</h5><br><br>";
            stringaDiv += "<p style='line-height: 1.5em;float:left; text-align:justify; padding:3px 3px 3px 3px;width:438px;'><img style='float:right;max-width:115px;max-height:115px; padding:3px 3px 3px 3px;' src='" + "images/story-book.jpg" + "' alt='' />" + t.substring(0, 300) + "...</p>";
            stringaDiv += "</a></div>";
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

    stringaDivCarousel += "<a class='carousel-control left' href='#divStorieDelTempo' data-slide='prev'>&lsaquo;</a> <a class='carousel-control right' href='#divStorieDelTempo' data-slide='next'>&rsaquo;</a>";
    stringaDivCarousel += "</div>";

    document.getElementById("containerCarouselStorieDelTempo").innerHTML = stringaDivCarousel;

    $('#divStorieDelTempo').carousel({
        interval: false
    });

    $("#divStorieDelTempo").bind("slid", function () {
        //alert( "ciao" );
        //document.getElementById("item2").innerHTML = "ciao";
        indexCarouselStorie++;

        if (indexCarouselStorie > nPagina)
            indexCarouselStorie = 0;

        for (var i = indexCarouselStorie * 2; i < ((indexCarouselStorie * 2) + 2) ; i++) {
            if (ContextVisible.story[i] == null) {
                //alert(indexCarouselStorie);
                break;
            }
            else {
                statisticaVIEWS(ContextVisible.story[i].publicMementoId);
            }
        }

    });
}


var playersCanzoni = [];
var videoCanzoni = [];
function stampaCanzoniContext(inizio, fine)
{
    document.getElementById("containerCarouselCanzoniDelTempo").innerHTML = "";
    var indice = 0;
    var nPagina = 0;
    var visualizzati = 0;
    var stringaDivCarousel = "<div id='divCanzoniDelTempo' class='carousel slide'>";
    var stringaDivEle = "<div class='carousel-inner'>";
    var stringaDiv = "";
    
    while (ContextVisible.song[indice] != null) {
        var song = ContextVisible.song[indice];
        var h = song.headline == null ? "" : song.headline;
        var t = song.text == null ? "" : song.text;
        var tipo = song.resourceType;
	
        if (song.resourceUrl != null)
        {
            if (tipo == "VIDEO") {
                //estraggo il video id di ogni filmato youtube e lo salvo in un vettore
                var regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=)([^#\&\?]*).*/;
                var match = song.resourceUrl.match(regExp);
                if (match && match[2].length == 11) {
                    //alert(match[2]);
                    videoCanzoni.push(match[2]);
                } else {
                }
                stringaDiv += "<div style='margin: 0px 40px 0px 40px;float:left;max-width:420px;'><div id='songCarousel" + song.publicMementoId + "'></div>";
                stringaDiv += "<h3>" + h + "</h3><h7 style='text-align:center;'>" + t + "</h7>";
                stringaDiv += "</div>";
                playersCanzoni.push(song.publicMementoId);
            }
            else
            {
                if(tipo == "IMAGE")
                {
                    stringaDiv += "<div style='align: center; margin: 0px 40px 0px 40px;float:left;width:420px;'>";
                    stringaDiv += "<img style='max-width:500px; max-height:300px;margin-top:30px;' src='" + song.resourceUrl;
                    stringaDiv += "' class='round'/><h5>" + h + "</h5><h7>" + t + "</h7>";
                    stringaDiv += "</div>";
                }
            }
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

    stringaDivCarousel += "<a class='carousel-control left' href='#divCanzoniDelTempo' data-slide='prev'>&lsaquo;</a> <a class='carousel-control right' href='#divCanzoniDelTempo' data-slide='next'>&rsaquo;</a>";
    stringaDivCarousel += "</div>";

    document.getElementById("containerCarouselCanzoniDelTempo").innerHTML = stringaDivCarousel;

    for (var i = 0; i < videoCanzoni.length; i++) {
        var player = new YT.Player("songCarousel" + playersCanzoni[i], {
            height: '315',
            width: '420',
            videoId: videoCanzoni[i],
            events: {
                //'onReady': onPlayerReady,
                'onStateChange': onPlayerStateChangeCanzoni
            }
        });
    }
    

    $('#divCanzoniDelTempo').carousel({
        interval: false
    });
    $("#divCanzoniDelTempo").bind("slid", function () {
        //alert( "ciao" );
        //document.getElementById("item2").innerHTML = "ciao";
        indexCarouselCanzoni++;

        if (indexCarouselCanzoni > nPagina)
            indexCarouselCanzoni = 0;

        for (var i = indexCarouselCanzoni * 2; i < ((indexCarouselCanzoni * 2) + 2) ; i++) {
            if (ContextVisible.song[i] == null) {
                //alert(indexCarouselCanzoni);
                break;
            }
            else {
                statisticaVIEWS(ContextVisible.song[i].publicMementoId);
            }
        }

    });

}

// when video play
function onPlayerStateChangeCanzoni(event) {
    if (event.data === 1) {
        var url = event.target.getVideoUrl();

        var regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=)([^#\&\?]*).*/;
        var match = url.match(regExp);
        if (match && match[2].length == 11) {
            //alert(match[2]);
            var i = 0;
            while (match[2] != videoCanzoni[i])
            {
                i++;
            }
            statisticheDETAILVIEWS(playersCanzoni[i]);
        } else {
        }

    }
}

function stampaFamosiContext(inizio, fine)
{
    document.getElementById("containerCarouselFamosiDelTempo").innerHTML = "";
    var indice = 0;
    var nPagina = 0;
    var visualizzati = 0;
    var stringaDivCarousel = "<div id='divFamosiDelTempo' class='carousel slide'>";
    var stringaDivEle = "<div class='carousel-inner'>";
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
                stringaDivEle += "<div class='item active'>" + stringaDiv + "</div>";
            }
            else {
                stringaDivEle += "<div class='item'>" + stringaDiv + "</div>";
            }

            nPagina++;
            stringaDiv = "";
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

    stringaDivCarousel += "<a class='carousel-control left' href='#divFamosiDelTempo' data-slide='prev'>&lsaquo;</a> <a class='carousel-control right' href='#divFamosiDelTempo' data-slide='next'>&rsaquo;</a>";
    stringaDivCarousel += "</div>";

    document.getElementById("containerCarouselFamosiDelTempo").innerHTML = stringaDivCarousel;

    $('#divFamosiDelTempo').carousel({
        interval: false
    });

    $("#divFamosiDelTempo").bind("slid", function () {
        //alert( "ciao" );
        //document.getElementById("item2").innerHTML = "ciao";
        indexCarouselFamosi++;

        if (indexCarouselFamosi > nPagina)
            indexCarouselFamosi = 0;

        for (var i = indexCarouselFamosi * 2; i < ((indexCarouselFamosi * 2) + 2) ; i++) {
            if (ContextVisible.people[i] == null) {
                //alert(indexCarouselCanzoni);
                break;
            }
            else {
                statisticaVIEWS(ContextVisible.people[i].publicMementoId);
            }
        }

    });
	
}

var playersTv = [];
var videoTv = [];
function stampaTvFilmContext(inizio, fine) {
    document.getElementById("containerCarouselTVDelTempo").innerHTML = "";
    var indice = 0;
    var nPagina = 0;
    var visualizzati = 0;
    var stringaDivCarousel = "<div id='divTVDelTempo' class='carousel slide'>";
    var stringaDivEle = "<div class='carousel-inner'>";
    var stringaDiv = "";
    while (ContextVisible.tvFilm[indice] != null) {
    	var tvFilm = ContextVisible.tvFilm[indice];
    	var h = tvFilm.headline == null ? "" : tvFilm.headline;
    	var t = tvFilm.text == null ? "" : tvFilm.text;
    	var tipo = tvFilm.resourceType;

    	if (tvFilm.resourceUrl != null)
        {
    		//var url = "";
    		//stringaDiv += "<div style='align: center; margin: 0px 40px 0px 40px;float:left;width:420px;'>";
    		//if (tipo=="IMAGE") {
    		//	url = tvFilm.resourceUrl;
    		//	stringaDiv += "<img style='max-width:500px; max-height:300px;margin-top:30px;' src='" + url;
    		//	stringaDiv +="' class='round'/><h4>" + h + "</h4><h6>" + t + "</h6>";
    		//} else {
    		//    //alert("ciao");
    		//	/*url = tvFilm.resourceUrl.replace('watch?v=', 'embed/');
    		//	stringaDiv += "<iframe width='420' height='315' src='" + url + "' frameborder='0' allowfullscreen style='margin-top:30px;'></iframe><h5>"; 
    		//	stringaDiv += h + "</h5><h7 style='text-align:center;'>" + t + "</h7>";*/
    		//    var regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=)([^#\&\?]*).*/;
    		//    var match = tvFilm.resourceUrl.match(regExp);
    		//    if (match && match[2].length == 11) {
    		//        //alert(match[2]);
    		//        videoTv.push(match[2]);
    		//    } else {
    		//    }
    		//    stringaDiv += "<div id='tvCarousel" + tvFilm.publicMementoId + "'></div>";
    		//    stringaDiv += "<h3>" + h + "</h3><h7 style='text-align:center;'>" + t + "</h7>";
    		//    playersTv.push(tvFilm.publicMementoId);
    		//}
    		//stringaDiv += "</div>";

    		if (tipo == "VIDEO") {
    		    //estraggo il video id di ogni filmato youtube e lo salvo in un vettore
    		    var regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=)([^#\&\?]*).*/;
    		    var match = tvFilm.resourceUrl.match(regExp);
    		    if (match && match[2].length == 11) {
    		        //alert(match[2]);
    		        videoTv.push(match[2]);
    		    } else {
    		    }
    		    stringaDiv += "<div style='margin: 0px 40px 0px 40px;float:left;max-width:420px;'><div id='tvCarousel" + tvFilm.publicMementoId + "'></div>";
    		    stringaDiv += "<h3>" + h + "</h3><h7 style='text-align:center;'>" + t + "</h7>";
    		    stringaDiv += "</div>";
    		    playersTv.push(tvFilm.publicMementoId);
    		}
    		else {
    		    if (tipo == "IMAGE") {
    		        stringaDiv += "<div style='align: center; margin: 0px 40px 0px 40px;float:left;width:420px;'>";
    		        stringaDiv += "<img style='max-width:500px; max-height:300px;margin-top:30px;' src='" + tvFilm.resourceUrl;
    		        stringaDiv += "' class='round'/><h5>" + h + "</h5><h7>" + t + "</h7>";
    		        stringaDiv += "</div>";
    		    }
    		}
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
                stringaDivEle += "<div class='item active'>" + stringaDiv + "</div>";
            }
            else {
                stringaDivEle += "<div class='item'>" + stringaDiv + "</div>";
            }

            nPagina++;
            stringaDiv = "";
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

    stringaDivCarousel += "<a class='carousel-control left' href='#divTVDelTempo' data-slide='prev'>&lsaquo;</a> <a class='carousel-control right' href='#divTVDelTempo' data-slide='next'>&rsaquo;</a>";
    stringaDivCarousel += "</div>";

    document.getElementById("containerCarouselTVDelTempo").innerHTML = stringaDivCarousel;

    for (var i = 0; i < videoTv.length; i++) {
        //alert(playersTv[i]);
        var player = new YT.Player("tvCarousel" + playersTv[i], {
            height: '315',
            width: '420',
            videoId: videoTv[i],
            events: {
                //'onReady': onPlayerReady,
                'onStateChange': onPlayerStateChangeTv
            }
        });
    }
    
    $('#divTVDelTempo').carousel({
        interval: false
    });

    $("#divTVDelTempo").bind("slid", function () {
        //alert( "ciao" );
        //document.getElementById("item2").innerHTML = "ciao";
        indexCarouselTv++;

        if (indexCarouselTv > nPagina)
            indexCarouselTv = 0;

        for (var i = indexCarouselTv * 2; i < ((indexCarouselTv * 2) + 2) ; i++) {
            if (ContextVisible.tvFilm[i] == null) {
                //alert(indexCarouselCanzoni);
                break;
            }
            else {
                statisticaVIEWS(ContextVisible.tvFilm[i].publicMementoId);
            }
        }

    });
}

// when video play
function onPlayerStateChangeTv(event) {
    if (event.data === 1) {
        var url = event.target.getVideoUrl();

        var regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=)([^#\&\?]*).*/;
        var match = url.match(regExp);
        if (match && match[2].length == 11) {
            //alert(match[2]);
            var i = 0;
            while (match[2] != videoTv[i]) {
                i++;
            }
            statisticheDETAILVIEWS(playersTv[i]);
        } else {
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

//        async: false,

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

//        async: false,

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


function player_state_changed(state) {
    /* This event is fired whenever the player's state changes.
       Possible values are:
       - unstarted (-1)
       - ended (0)
       - playing (1)
       - paused (2) 
       - buffering (3)
       - video cued (5). 
       When the SWF is first loaded it will broadcast an unstarted (-1) event.
       When the video is cued and ready to play it will broadcast a video cued event (5).
    */

    alert("ciao");
    if (state == 1 || state == 2) {
        alert('the "play" button *might* have been clicked');
    }

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
