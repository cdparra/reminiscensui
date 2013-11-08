// JavaScript Document

function SaveStoryWithConnection(newStory)
{
	//alert("ciao");
	$.ajax({
        	type: "POST",
			
			beforeSend: function (request)
            {
                request.setRequestHeader("PLAY_SESSION", sessionKey);
            },

			url:GetBaseUrl() + "/lifeapi/lifestory",
        	//url: "http://test.reminiscens.me/lifeapi/lifestory",

        	data: JSON.stringify(newStory),

        	async: false,

        	success: function (data) {
					//alert("yeeee");
        	    //alert(data.lifeStoryId);
        	    //alert(MieStorieVisible[MieStorieVisible.length - 1].synced);
        	    MieStorieVisible = RecuperaMieStorieDecade();
        	    MieStorieVisible[MieStorieVisible.length - 1].synced = true;
        	    MieStorieVisible[MieStorieVisible.length - 1].lifeStoryId = data.lifeStoryId;
        	    for(var i = 0; i<data.mementoList.length; i++) //aggiorno gli ID delle foto delle nuove storie per il salvataggio locale
        	    {
        	        //alert(data.mementoList[i].mementoId);
        	        MieStorieVisible[MieStorieVisible.length - 1].mementoList[i].mementoId = data.mementoList[i].mementoId;
        	    }
        	    
        	    /*stampaMieFoto(0, MieStorieVisible.length);
        	    stampaMieStorie(0, MieStorieVisible.length);
        	    aggiungiEventoFancyBox();*/

        	    var storage = $.localStorage;
        	    storage.set('mieStorie', MieStorie);

        	    AzzeraVariabiliOverlay();


        	    if (decade < firstDecade) {
        	        firstDecade = decade;
        	        CreaTimelineCarousel();
        	    }
        	    AzzeraTimeline();
        	    ScrollCarousel();
        	    document.getElementById(decade).className = "decade-button-selected timeline";
        	    GestioneSchermate(decade);
        	    //MieStorieVisible[MieStorieVisible.length - 1].

        	},
        	error: function (data) {
        	    //alert("error");
        	    console.log("errore");
        	    var storia = new Object;
        	    storia.newStory = newStory;
        	    storia.idStoryModify = -1;
        	    storia.index = MieStorieVisible.length - 1;
        	    storia.decade = newStory.startDate.decade;
        	    var storage = $.localStorage;
        	    var tmp = storage.get('storieNonSync');
        	    tmp.push(storia);
        	    storage.set('storieNonSync', storia);

        	},
        	dataType: "json",
			
			contentType: "application/json"

        });
}

function ModifyStoryWithConnection(newStory, idStoryModify, indexModify)
{
	//alert("ciao");
	$.ajax({
        	type: "PUT",
			
			beforeSend: function (request)
            {
                request.setRequestHeader("PLAY_SESSION", sessionKey);
            },

			url: GetBaseUrl() + "/lifeapi/lifestory/" + idStoryModify,
        	//url: "http://test.reminiscens.me/lifeapi/lifestory/" + idStoryModify,

        	data: JSON.stringify(newStory),

//        	async: false,

        	success: function (data) {
					//alert("yeeee");
        	    //alert(data.lifeStoryId);
        	    MieStorieVisible[indexModify].synced = true;

        	},
        	error: function (data) {
        	    //alert("error");
        	    console.log("errore");
        	    var storia = new Object;
        	    storia.newStory = newStory;
        	    storia.idStoryModify = idStoryModify;
        	    storia.index = indexModify;
        	    storia.decade = newStory.startDate.decade;
        	    var storage = $.localStorage;
        	    var tmp = storage.get('storieNonSync');
        	    tmp.push(storia);
        	    storage.set('storieNonSync', storia);
        	},
        	dataType: "json",
			
			contentType: "application/json"

        });
}

function StorySynchronize()
{
    var storage = $.localStorage;
    var storieNonSync = storage.get('storieNonSync');
    //alert(storieNonSync);
    if (storieNonSync != null) {

        while (storieNonSync.length > 0) {
            var storia = storieNonSync.pop();
            if (storia.idStoryModify != -1) //si tratta di una storia modificata
            {
                //alert("ciao");
                $.ajax({
                    type: "PUT",

                    beforeSend: function (request) {
                        request.setRequestHeader("PLAY_SESSION", sessionKey);
                    },

                    url: GetBaseUrl() + "/lifeapi/lifestory/" + storia.idStoryModify,
                    //url: "http://test.reminiscens.me/lifeapi/lifestory/" + idStoryModify,

                    data: JSON.stringify(storia.newStory),

                    //        	async: false,

                    success: function (data) {
                        //alert("yeeee");
                        //alert(data.lifeStoryId);
                        switch (parseInt(storia.decade)) {
                            case 1900:
                                MieStorie.MilleNovecento[storia.index].synced = true;
                                break;
                            case 1910:
                                MieStorie.MilleNovecentoDieci[storia.index].synced = true;
                                break;
                            case 1920:
                                MieStorie.MilleNovecentoVenti[storia.index].synced = true;
                                break;
                            case 1930:
                                MieStorie.MilleNovecentoTrenta[storia.index].synced = true;
                                break;
                            case 1940:
                                MieStorie.MilleNovecentoQuaranta[storia.index].synced = true;
                                break;
                            case 1950:
                                MieStorie.MilleNovecentoCinquanta[storia.index].synced = true;
                                break;
                            case 1960:
                                MieStorie.MilleNovecentoSessanta[storia.index].synced = true;
                                break;
                            case 1970:
                                MieStorie.MilleNovecentoSettanta[storia.index].synced = true;
                                break;
                            case 1980:
                                MieStorie.MilleNovecentoOttanta[storia.index].synced = true;
                                break;
                            case 1990:
                                MieStorie.MilleNovecentoNovanta[storia.index].synced = true;
                                break;
                            case 2000:
                                MieStorie.Duemila[storia.index].synced = true;
                                break;
                            case 2010:
                                MieStorie.DuemilaDieci[storia.index].synced = true;
                                break;
                            case 2020:
                                MieStorie.DuemilaVenti[storia.index].synced = true;
                                break;
                        }
                    },
                    error: function (data) {
                        //alert("error");
                        console.log("errore");
                        var tmp = storage.get('storieNonSync');
                        tmp.push(storia);
                        storage.set('storieNonSync', storia);
                    },
                    dataType: "json",

                    contentType: "application/json"

                });
            }
            else //se si tratta di una storia nuova
            {
                $.ajax({
                    type: "POST",

                    beforeSend: function (request) {
                        request.setRequestHeader("PLAY_SESSION", sessionKey);
                    },

                    url: GetBaseUrl() + "/lifeapi/lifestory",
                    //url: "http://test.reminiscens.me/lifeapi/lifestory",

                    data: JSON.stringify(storia.newStory),

                    //async: false,

                    success: function (data) {
                        //alert("yeeee");
                        //alert(data.lifeStoryId);
                        switch (parseInt(storia.decade)) {
                            case 1900:
                                MieStorie.MilleNovecento[storia.index].synced = true;
                                break;
                            case 1910:
                                MieStorie.MilleNovecentoDieci[storia.index].synced = true;
                                break;
                            case 1920:
                                MieStorie.MilleNovecentoVenti[storia.index].synced = true;
                                break;
                            case 1930:
                                MieStorie.MilleNovecentoTrenta[storia.index].synced = true;
                                break;
                            case 1940:
                                MieStorie.MilleNovecentoQuaranta[storia.index].synced = true;
                                break;
                            case 1950:
                                MieStorie.MilleNovecentoCinquanta[storia.index].synced = true;
                                break;
                            case 1960:
                                MieStorie.MilleNovecentoSessanta[storia.index].synced = true;
                                break;
                            case 1970:
                                MieStorie.MilleNovecentoSettanta[storia.index].synced = true;
                                break;
                            case 1980:
                                MieStorie.MilleNovecentoOttanta[storia.index].synced = true;
                                break;
                            case 1990:
                                MieStorie.MilleNovecentoNovanta[storia.index].synced = true;
                                break;
                            case 2000:
                                MieStorie.Duemila[storia.index].synced = true;
                                break;
                            case 2010:
                                MieStorie.DuemilaDieci[storia.index].synced = true;
                                break;
                            case 2020:
                                MieStorie.DuemilaVenti[storia.index].synced = true;
                                break;
                        }
                    },
                    error: function (data) {
                        //alert("error");
                        console.log("errore");
                        var tmp = storage.get('storieNonSync');
                        tmp.push(storia);
                        storage.set('storieNonSync', storia);

                    },
                    dataType: "json",

                    contentType: "application/json"

                });
            }
        }
    }
}