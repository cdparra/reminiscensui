function getURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            var file = document.getElementById('filepath').value;
            var n = file.split(".").pop().toLowerCase();
                        
            if((n == "jpg")||(n=="jpeg")||(n=="png")||(n=="gif")) {
                $("#img").attr('src', e.target.result);
                $("#img").show();
                document.getElementById('url').value = null;
            } 
            else{
                $("#myModalUrl").modal('show');
                document.getElementById('filepath').value = null;
            }
        }   
        //non so bene che faccia
        reader.readAsDataURL(input.files[0]);
    }
}
                  
function readURL(){
    var URL = document.getElementById('url').value;
                  
    var n = URL.split(".").pop().toLowerCase();
    if((n == "jpg")||(n=="jpeg")||(n=="png")) {
        $("#img").attr('src', URL);
        $("#img").show();
        document.getElementById('filepath').value = null;
    } else{
        
        $("#myModalUrl").modal('show');
        document.getElementById('url').value = null;
    
    }       
}
            
function stopRKey(evt) {
    var evt = (evt) ? evt : ((event) ? event : null);
    var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
    if (evt.keyCode == 13) {
        return false;
    }
}
document.onkeypress = stopRKey;           
           
