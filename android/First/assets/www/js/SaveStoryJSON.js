// JavaScript Document
function b64toBlob(b64Data, contentType, sliceSize) {
    contentType = contentType || '';
    sliceSize = sliceSize || 1024;

    function charCodeFromCharacter(c) {
        return c.charCodeAt(0);
    }

    var byteCharacters = atob(b64Data);
    var byteArrays = [];

    for (var offset = 0; offset < byteCharacters.length; offset += sliceSize) {
        var slice = byteCharacters.slice(offset, offset + sliceSize);
        var byteNumbers = Array.prototype.map.call(slice, charCodeFromCharacter);
        var byteArray = new Uint8Array(byteNumbers);

        byteArrays.push(byteArray);
    }

    var blob = new Blob(byteArrays, {type: contentType});
    return blob;
}




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
	//alert(decadeStory);
	var editor = $("#editor").data("kendoEditor");
	//alert(editor.value());
	var newStory = new Object;
	
	newStory.headline = titolo.value;
	//newStory.dove = dove.value;
	//newStory.quando = quando.value;	
	newStory.text = editor.value();
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
	
	var textSplit = editor.value().split("src=\"");
	var j = 1;
	//alert(textSplit.length);
	for(i =1;i<textSplit.length;i = i + 2) //ciclo ogni 2 per cercare contenuto del src
	{
		var Imm = new Object;
		var tmp = textSplit[i].split("\""); //estraggo contenuto src
		tmp = tmp[0].split(","); //estraggo solo contenuto senza intestazione "data:image/jpeg;base64,"
		//alert(tmp[1]);
		
		
		
		/*var blob = b64toBlob(tmp[1], "image/jpeg");
		var blobUrl = URL.createObjectURL(blob);
		//alert(blobUrl);
		
		
		
		
		
		var data;

    	data = new FormData();
    	data.append( 'file[]', blob );

    	$.ajax({
        url: 'http://test.reminiscens.me/lifeapi/upload',
		beforeSend: function (request)
            {
                request.setRequestHeader("PLAY_SESSION", sessionKey);
            },
        data: data,
        processData: false,
        type: 'POST',
		//contentType:"multipart/form-data",
		contentType:false,		
		processData:false,
		accepts:"application/json",
		        success: function ( data ) {
            alert( data );
        }
    });*/
		
		
		
		//upload(tmp[1],titolo);
		/*var storage = $.localStorage;
		while(storage.get('url') == null){}
		alert(storage.get('url'));
		tmp = storage.get('url').split("//");
		Imm.url = tmp[0] + "//i." + tmp[1] + ".jpg";*/
		Imm.url = "";
		Imm.type = "photo";
		Imm.category = "photo";
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
	
	/*var storia = JSON.stringify(jsonObj);	
	$("#debug").text(storia);	*/		
	//alert(storia);
	
	
	controlloStampaPagine();
	controlloStampaPagineStorie();
	
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