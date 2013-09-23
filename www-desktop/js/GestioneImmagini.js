// JavaScript Document
function upload(file,titolo) {  //devo passare la codifica del file (in base64 senza intestazione) e il titolo
    var storage = $.localStorage;
	storage.set('url',null);
	// Let's build a FormData object
    var fd = new FormData();
    fd.append("image", file); // Append the file
	fd.append("type","base64");
                
    // Get your own key: http://api.imgur.com/ 
    fd.append("key", "140fcf2c8db71a9d6dec87f05a52eb34");   
    fd.append("title",titolo);
	
                
    // Create the XHR 
    var xhr = new XMLHttpRequest();
 
    xhr.addEventListener("error", transferFailed, false);
    xhr.addEventListener("abort", transferCanceled, false);
               
    xhr.open("POST", "http://api.imgur.com/2/upload.json"); 
    
	//esegue quando ottengo la risposta in json
    xhr.onload = function() {
        //ok finito il caricamento faccio il resto
        var obj = JSON.parse(xhr.responseText);  
		//alert(obj.upload.links.imgur_page);
		
		storage.set('url',obj.upload.links.imgur_page);
    }
	   
	// ora mando i dati del formdata
    xhr.send(fd);
       
}
function transferFailed(evt) {
    alert("An error occurred while transferring the file.");
}
 
function transferCanceled(evt) {
    alert("The transfer has been canceled by the user.");
}

function getBase64Image(url) {
    var canvas = document.createElement("canvas");
    
    var img = new Image();
	img.src = url;	
    canvas.width = img.width;
    canvas.height = img.height;
	
	var ctx = canvas.getContext("2d");
    ctx.drawImage(img, 0, 0);
	
    //non serve l'intestazione(data:image/jpeg;base64)!!!
	var data;
	try {
        var data = canvas.toDataURL('image/jpeg', 0.9).split(',')[1];
    } catch(e) {
        var data = canvas.toDataURL().split(',')[1];
    }
	//alert(data);    
	return data;    
    
}

function EliminaIntestazioneDataImg(data)
{
	var tmp = data.split(",");
	data = tmp[1];
	alert(data);
}