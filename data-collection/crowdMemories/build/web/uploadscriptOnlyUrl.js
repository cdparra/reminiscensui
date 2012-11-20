function readURL(){
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
