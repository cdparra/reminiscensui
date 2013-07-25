// JavaScript Document
function salvaStoria(){
	if (!confirm('Sicuro di voler salvare la tua storia?')) { 
 		return;
	}
		
	var storage =$.localStorage;
	//alert(storage.get('prova'));
	if(storage.get('mieStorie')[0].titolo != null)
	{
		//alert("ciao");
		MieStorie = storage.get('mieStorie');
	}
	
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
	
	jsonObj.immagini = vettImm;	//inserisco vettore immagini
	MieStorie.push(jsonObj);
	
	/*var storia = JSON.stringify(jsonObj);	
	$("#debug").text(storia);	*/		
	//alert(storia);
	
	var storage = $.localStorage;
	storage.set('mieStorie',MieStorie);
	 
	document.getElementById("divMieFotoDelTempo").innerHTML = "";
	document.getElementById("divMieStorieDelTempo").innerHTML = "";
	for (i=0; i<MieStorie.length; i++) { 
			//alert(MieStorie[i].immagini[0].src);
			if(MieStorie[i].immagini[0] != null)
			{
				document.getElementById("divMieStorieDelTempo").innerHTML += "<a class='fancybox' rel='gallery2' href='" + MieStorie[i].immagini[0].src + "' title='" + MieStorie[i].titolo + "' > <img src='" + MieStorie[i].immagini[0].src + "' alt='' /> </a>";
				document.getElementById("divMieFotoDelTempo").innerHTML += "<a class='fancybox' rel='gallery1' href='" + MieStorie[i].immagini[0].src + "' title='" + MieStorie[i].titolo + "' > <img src='" + MieStorie[i].immagini[0].src + "' alt='' /> </a>";
			}
			else
			{
				document.getElementById("divMieStorieDelTempo").innerHTML += "<a class='fancybox' rel='gallery2' href='" + "images/no_image.png" + "' title='" + MieStorie[i].titolo + "' > <img src='" + "images/no_image.png" + "' alt='' /> </a>";
				document.getElementById("divMieFotoDelTempo").innerHTML += "<a class='fancybox' rel='gallery1' href='" + "images/no_image.png" + "' title='" + MieStorie[i].titolo + "' > <img src='" + "images/no_image.png" + "' alt='' /> </a>";
			}
			//document.getElementById("divMieFotoDelTempo").innerHTML += "<img src='" + "http://imgur.com/Bu8asfw" + "' alt='' />";
	}
	
	//document.getElementById("divMieFotoDelTempo").innerHTML += "<img src='http://i.imgur.com/gvouoaN.jpg' alt='' />";
	$(".fancybox").fancybox({
		'showCloseButton'	: false,
		afterLoad : function() {
			if(Storie.length>this.index)
			{
    			this.title = "<div><h1>" + Storie[this.index].titolo +"</h1><h5>" + Storie[this.index].testo + "</h5>  </div>";
			}
			else
			{
				this.title = "<div><h1>" + MieStorie[this.index - Storie.length].titolo + "</h1><h5>" + MieStorie[this.index - Storie.length].testo + "</h5>  </div>";
			}
			//this.title = "<div><h1>" + "hola" +"</h1> </div>";
   		},
		'helpers' : { 
    		title : { type : 'inside' }
   		} // helpers
	});
	
	
	/*$('#overlayCaricamento').fadeOut('fast');
    $('#caricamento').hide();*/
	document.getElementById("titolo").value = "";
	document.getElementById("dove").value = "";
	document.getElementById("quando").value = "";
	$("#editor").data("kendoEditor").value("");
	$('#overlay').fadeOut('fast');
     $('#box').hide();
	
}