// JavaScript Document
function salvaStoria(){
	if (!confirm('Sicuro di voler salvare la tua storia?')) { 
 		return;
	}
	
	var titolo  = document.getElementById("titolo");	
	
	if(titolo.value == "")
	{
		alert("Inserire un titolo per la storia!");
		return;
	}
	
	if(document.getElementById("decade").value == 0)
	{
		alert("Inserire almeno la decade!");
		return;
	}
	
	if(document.getElementById("country").value == "")
	{
		alert("Inserire almeno la nazione!");
		return;
	}

	var newStory = new Object;
	
	newStory.headline = titolo.value;
	newStory.contributorId = personId;
	newStory.locale = "it_IT";
	var editor = $("#editor").data("kendoEditor");
	newStory.text = editor.value();

    //controllo se sono arrivato da una domanda e inserisco l'id della domanda in caso affermativo
	if (cameToQuestion) {
	    alert(idQuestion);
	    newStory.questionId = idQuestion;
	    isQuestion = false;  //azzero l'id della domanda
	}

    //controllo se arrivo da un raccontaci dentro un memento del contesto
	if (idContextRaccontaci != null)
	{
	    newStory.publicMementoId = idContextRaccontaci;
	    idContextRaccontaci = null;
	}
	
	/*if(document.getElementById("placeName").value != "")
	{
		placeNameSelect = document.getElementById("placeName").value;
	}*/
	newStory.location = new Object;
	newStory.location.country = document.getElementById("country").value;
	
	if (document.getElementById("city").value != "")
	{
	    newStory.location.city = document.getElementById("city").value;	    
	}
	if (document.getElementById("region").value != null) {
	    newStory.location.region = document.getElementById("region").value;	    
	}
	if (document.getElementById("placeName").value != "") {
	    newStory.location.placeName = document.getElementById("placeName").value;
	}
	newStory.location.locale = "it_IT";	
	
	
	/*if (document.getElementById("day").value != 0)
	{
		daySelect = parseInt(document.getElementById("day").item(document.getElementById("day").value).text);
	}*/
	newStory.startDate = new Object;
	var decadeSelect = parseInt(document.getElementById("decade").item(document.getElementById("decade").value).text);
	var yearSelect = null, monthSelect = null, daySelect = null;
	newStory.startDate.decade = decadeSelect;
	decade = decadeSelect;
	if (document.getElementById("year").value != 0)
	{
	    yearSelect = parseInt(document.getElementById("year").item(document.getElementById("year").value).text);
		newStory.startDate.year = yearSelect;		
	}
	if (document.getElementById("month").value != 0) {
	    monthSelect = parseInt(document.getElementById("month").value);
	    newStory.startDate.month = monthSelect;	    
	}
	if (document.getElementById("day").value != 0) {
	    daySelect = parseInt(document.getElementById("day").item(document.getElementById("day").value).text);
	    newStory.startDate.day = daySelect;
	    if (yearSelect != null && monthSelect != null && daySelect != null)
            newStory.startDate.exactDate = yearSelect + "-" + monthSelect + "-" + daySelect + " " + "00:00:00";
	}
	newStory.startDate.locale = "it_IT";
	
	newStory.synced = false;
	
	var vettImm = [];
	var j = 1;
	for(var i =0;i<imgStoriaUrl.length;i++) //ciclo ogni 2 per cercare contenuto del src
	{
		var Imm = new Object;
		Imm.url = imgStoriaUrl[i];
		Imm.fileHashcode = imgStoriaHashcode[i];
		Imm.thumbnailUrl = imgStoriaThumbnailUrl[i];
		Imm.fileName = imgStoriaFilename[i];
		Imm.type = "photo";
		Imm.category = "PICTURE";
		var extension = Imm.fileName.substr(Imm.fileName.lastIndexOf('.') + 1);
        if (extension=="wav") {
            Imm.type = "audio";
            Imm.category = "AUDIO";
        }
		if (i == 0) {
		    Imm.isCover = true;
		}
		Imm.index = j;
		j++;
		Imm.headline = "prova";
		Imm.public_memento = false;
		vettImm.push(Imm);		
		
	}
	
	newStory.mementoList = vettImm;	//inserisco vettore immagini
	
	//alert(JSON.stringify(newStory));
	if(isModify) //se sto eseguendo una modifica
	{
	    ModificaMieStoriaDecade(newStory, decadeSelect, indexModify);
		if(idStoryModify!=null)
		{
			ModifyStoryWithConnection(newStory, idStoryModify, indexModify);
			newStory.lifeStoryId = idStoryModify;
		}		
	}
	else //se sto raccontando una nuova storia
	{
	    AggiungiMieStoriaDecade(newStory, decadeSelect);
		SaveStoryWithConnection(newStory);		
	}
	
	
	//MieStorieVisible = RecuperaMieStorieDecade();
	//stampaMieFoto(0,MieStorieVisible.length);
	//stampaMieStorie(0,MieStorieVisible.length);
	//aggiungiEventoFancyBox();

	AggiornaContext(newStory.location.country, newStory.location.city, newStory.location.region, newStory.location.locale, newStory.startDate.decade);
	
	//var storage = $.localStorage;
	//storage.set('mieStorie',MieStorie);
	
	AzzeraVariabiliOverlay();

	
	//if (decade < firstDecade)
	//{
	//    firstDecade = decade;
	//    CreaTimelineCarousel();	    	    
	//}
	//AzzeraTimeline();
	//ScrollCarousel();
	//document.getElementById(decade).className = "decade-button-selected timeline";
	//GestioneSchermate(decade);
}