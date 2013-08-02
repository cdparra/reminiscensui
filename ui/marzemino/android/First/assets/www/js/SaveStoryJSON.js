// JavaScript Document
function salvaStoria(){
	if (!confirm('Sicuro di voler salvare la tua storia?')) { 
 		return;
	}
		
	var storage =$.localStorage;
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
	var quando = datepicker.value();
	var decadeStory = YearToDecade(quando.getFullYear());
	alert(decadeStory);
	var editor = $("#editor").data("kendoEditor");

	var newStory = new Object;
	
	newStory.titolo = titolo.value;
	newStory.dove = dove.value;
	newStory.quando = quando.value;	
	newStory.testo = editor.value();
	
	//var storia = JSON.stringify(jsonObj);	
					
	//alert(storia);
	
	var vettImm = [];
	
	var textSplit = editor.value().split("src=\"");
	
	for(i =1;i<textSplit.length;i = i + 2) //ciclo ogni 2 per cercare contenuto del src
	{
		var Imm = new Object;
		var tmp = textSplit[i].split("\""); //estraggo contenuto src
		tmp = tmp[0].split(","); //estraggo solo contenuto senza intestazione "data:image/jpeg;base64,"
		upload(tmp[1],titolo);
		var storage = $.localStorage;
		while(storage.get('url') == null){
			/*CentroCaricamento();
			$('#overlayCaricamento').fadeIn('fast');
    		$('#caricamento').fadeIn('slow');*/}
		alert(storage.get('url'));
		tmp = storage.get('url').split("//");
		Imm.src = tmp[0] + "//i." + tmp[1] + ".jpg";
		vettImm.push(Imm);
	}
	
	newStory.immagini = vettImm;	//inserisco vettore immagini
	//MieStorie.push(jsonObj);
	AggiungiStoriaDecade(newStory, decadeStory);
	
	/*var storia = JSON.stringify(jsonObj);	
	$("#debug").text(storia);	*/		
	//alert(storia);
	
	
	controlloStampaPagine();
	
	var storage = $.localStorage;
	storage.set('mieStorie',MieStorie);
	
	
	/*$('#overlayCaricamento').fadeOut('fast');
    $('#caricamento').hide();*/
	document.getElementById("titolo").value = "";
	document.getElementById("dove").value = "";
	document.getElementById("quando").value = "";
	$("#editor").data("kendoEditor").value("");
	$('#overlay').fadeOut('fast');
     $('#box').hide();
	
}