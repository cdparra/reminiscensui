// JavaScript Document
function salvaStoria(){
	var titolo  = document.getElementById("titolo");
	var dove = document.getElementById("dove");
	var quando = document.getElementById("quando");
	var editor = $("#editor").data("kendoEditor");

	var jsonObj = new Object;
	
	jsonObj.titolo = titolo.value;
	jsonObj.dove = dove.value;
	jsonObj.quando = quando.value;
	jsonObj.testo = editor.value();
	
	//var storia = JSON.stringify(jsonObj);	
					
	//alert(storia);
	
	var ObjImm = [];
	
	var textSplit = editor.value().split("src=\"");
	
	for(i =1;i<textSplit.length;i = i + 2) //ciclo ogni 2 per cercare contenuto del src
	{
		var tmp = textSplit[i].split("\""); //estraggo contenuto src
		tmp = tmp[0].split(","); //estraggo solo contenuto senza intestazione "data:image/jpeg;base64,"
		upload(tmp[1],titolo);
		var storage = $.localStorage;
		while(storage.get('url') == null){}
		alert(storage.get('url'));
		//ObjImm.push({"src":tmp[1]});
	}
	
	jsonObj.immagini = ObjImm;	//inserisco vettore immagini
	
	var storia = JSON.stringify(jsonObj);	
	$("#debug").text(storia);			
	//alert(storia);
	
	var storage = $.localStorage;
	storage.set('prova',jsonObj);
}