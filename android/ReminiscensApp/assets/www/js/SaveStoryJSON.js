// JavaScript Document
function salvaStoria(){
	if (!confirm('Sicuro di voler salvare la tua storia?')) { 
 		return;
	}
		
	//var storage =$.localStorage;
	//alert(storage.get('prova'));
	/*if(storage.get('mieStorie')[0].titolo != null)
	{
		//alert("ciao");
		MieStorie = storage.get('mieStorie');
	}*/
	
	var titolo  = document.getElementById("titolo");
	var dove = document.getElementById("dove");
	//var quando = document.getElementById("quando");
	var datepicker = $("#quando").data("kendoDatePicker");
	/*var quando = datepicker.value();*/
	var decadeStory = YearToDecade(quando.getFullYear());
	//alert(decadeStory);
	var editor = $("#editor").data("kendoEditor");

	var newStory = new Object;
	
	newStory.headline = titolo.value;
	//newStory.dove = dove.value;
	//newStory.quando = quando.value;	
	newStory.text = editor.value();
	//alert(newStory.text);
	newStory.contributorId = personId;
	newStory.locale = "it_IT";
	newStory.location = new Object;
	newStory.location.location_textual = dove.value;
	newStory.startDate = new Object;
	newStory.startDate.exactDate = CostruisciData(datepicker);
	newStory.synced = false;
	
	
	//var storia = JSON.stringify(jsonObj);	
					
	//alert(storia);
	
	var vettImm = [];
	//alert(imgStoria.length);
	
	//var textSplit = editor.value().split("src=\"");
	var j = 1;
	for(var i =0;i<imgStoriaUrl.length;i++) //ciclo ogni 2 per cercare contenuto del src
	{
		/*var Imm = new Object;
		var tmp = textSplit[i].split("\""); //estraggo contenuto src
		tmp = tmp[0].split(","); //estraggo solo contenuto senza intestazione "data:image/jpeg;base64,"
		upload(tmp[1],titolo);
		var storage = $.localStorage;
		while(storage.get('url') == null){}
		alert(storage.get('url'));
		tmp = storage.get('url').split("//");
		Imm.url = tmp[0] + "//i." + tmp[1] + ".jpg";
		Imm.type = "photo";
		Imm.category = "photo";
		Imm.isCover = true;
		Imm.index = j;
		j++;
		Imm.headline = "prova";
		Imm.public_memento = false;
		vettImm.push(Imm);*/
		var Imm = new Object;
		Imm.url = imgStoriaUrl[i];
		Imm.fileHashcode = imgStoriaHashcode[i];
		Imm.thumbnailUrl = imgStoriaFilename[i];
		Imm.type = "photo";
		Imm.category = "PICTURE";
		Imm.isCover = true;
		Imm.index = j;
		j++;
		Imm.headline = "prova";
		Imm.public_memento = false;
		vettImm.push(Imm);		
		
	}
	
	newStory.mementoList = vettImm;	//inserisco vettore immagini
	//MieStorie.push(jsonObj);
	
	SaveStoryWithConnection(newStory);
	

	AggiungiStoriaDecade(newStory, decadeStory);
	
	stampaMieFoto(0,MieStorieVisible.length);
	stampaMieStorie(0,MieStorieVisible.length);
	aggiungiEventoFancyBox();
	
	/*var storia = JSON.stringify(jsonObj);	
	$("#debug").text(storia);	*/		
	//alert(storia);
	
	
	/*controlloStampaPagine();
	controlloStampaPagineStorie();*/
	
	var storage = $.localStorage;
	storage.set('mieStorie',MieStorie);
	
	
	/*$('#overlayCaricamento').fadeOut('fast');
    $('#caricamento').hide();*/
	document.getElementById("titolo").value = "";
	document.getElementById("dove").value = "";
	document.getElementById("quando").value = "";
	document.getElementById("imgInput").innerHTML = "";
	$("#editor").data("kendoEditor").value("");
	$('#overlay').fadeOut('fast');
     $('#box').hide();
	
}