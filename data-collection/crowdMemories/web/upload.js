$(document).ready(function(){
    $("#myModalInfo").modal('show');
})

function displayImage(file) {
   
    if (!file || !file.type.match(/image.*/)){
        document.getElementById('fileInput').value = null;
        document.getElementById('url').value = null;
        $("#myModalUrl").modal('show');
        $("#img").hide();
        $("#next").hide();
        return;
    }
    
    //ok è un immagine la faccio vedere
    document.getElementById('url').value = null;    
    var reader = new FileReader(); 
    reader.onload = function (e) {  
        $("#img").attr('src', e.target.result);
        $("#img").show();
        $("#next").show();    
    }

    reader.readAsDataURL(file);
}

function readURL(){
    
    document.getElementById('fileInput').value = null;
      
    var URL = document.getElementById('url').value;
    if(!(URL == "")){              
        var n = URL.split(".").pop().toLowerCase();
        if((n == "jpg")||(n=="jpeg")||(n=="png")) {    
            $("#img").attr('src', URL);
            $("#img").show();
            $("#next").show();        
        } else{ 
            $("#myModalUrl").modal('show');
            $("#img").hide();
            $("#next").hide();
            document.getElementById('url').value = null; 
        }       
    }else{
        $("#img").hide();
        $("#next").hide();
    }
}

function check(){
    var url = document.getElementById('url').value;
    var title = document.getElementById('title').value;
    
    if((url == "")||(title == "")){
        $("#myModalSubmit").modal('show');
        return false;
    }else{ 
        return true;
    }
}

function checkOrUpload(){
    //se non ha inserito il titolo ferma tutto
    var titolo = document.getElementById('title').value;
    if(titolo == ""||titolo == null){
        $("#myModalSubmit").modal('show');
        return;
    }
    
    //controllo che non siano entrambi vuoti
    var url = document.getElementById('url').value;
    var fileInput = document.getElementById('fileInput').value;
    if(url == "" && fileInput == null){
        $("#myModalSubmit").modal('show');   
        return;
    }
    
    //se c'è l'url nella barra faccio submit di quello
    if(!(url == "")){
        document.getElementById('submit').click();
    }
    
    //ok non c'è perciò faccio l'upload
    var file = document.getElementById('fileInput');
    
    upload(file.files[0],titolo);  
}


function stopRKey(evt) {
    var evt = (evt) ? evt : ((event) ? event : null);
    var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
    if (evt.keyCode == 13) {
        if(document.getElementById('url').value != ""){
            readURL();
        }   
        return false;
    }
}
document.onkeypress = stopRKey;  

function submit(){
    document.getElementById('submit').click();
}
           
function upload(file,titolo) {
    // file is from a <input> tag //or from Drag'n Drop
    // Is the file an image?
    if (!file || !file.type.match(/image.*/)) {
        return false;
    }

    // It is!
    $("#myModalUpload").modal({
        backdrop: 'static', //non fa chiudere il modal al click 
        show: true 
    // keyboard: true  //chiude il modal quando esc è premuto
    });
    
    // Let's build a FormData object
    var fd = new FormData();
    fd.append("image", file); // Append the file
                
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
        
        document.getElementById('url').value = obj.upload.links.original;
        document.getElementById('link').href =  obj.upload.links.imgur_page;
        document.getElementById('link').innerHTML = "<strong> "+obj.upload.links.imgur_page+"</strong>";
        
        $("#modal-body-uploading").hide();
        $("#modal-body-uploaded").show();
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
       