function initializeMapMarker() {
    //var latlng = new google.maps.LatLng(41.901514, 12.4607737);
                
    var lat = document.getElementById("lat").value;
    var lng = document.getElementById("lng").value;
    var latlng = new google.maps.LatLng(lat,lng);
   
    var mapOptions = {
        zoom: 8,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
                
    var map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
                
    var marker = new google.maps.Marker({
        map: map,
        position: latlng
    });         
};
            
function initializeMapCircle() {
    //var latlng = new google.maps.LatLng(41.901514, 12.4607737);
                
    var lat = document.getElementById("lat").value;
    var lng = document.getElementById("lng").value;
    var latlng = new google.maps.LatLng(lat,lng);
   
    var mapOptions = {
        zoom: 8,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
                
    var map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
                
    var radius = parseInt(document.getElementById("radius").value);
                                   
    circle = new google.maps.Circle({
        center: latlng,
        map: map,
        //editable: true, //e non editable
        visible:true, //dovrebbe essere true di default
        strokeColor: "#FF0000",
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: "#FF0000",
        fillOpacity: 0.35,
        radius: radius
    });         
               
};
            
function loadScriptMapMarker() {
    var script = document.createElement("script");
    script.type = "text/javascript";
    script.src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyAfhwuXTgopU7b9KHaTB9YDZwQ6LdPbLJ8&sensor=false&callback=initializeMapMarker";
                    
    document.body.appendChild(script);
};
            
function loadScriptMapCircle() {
    var script = document.createElement("script");
    script.type = "text/javascript";
    script.src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyAfhwuXTgopU7b9KHaTB9YDZwQ6LdPbLJ8&sensor=false&callback=initializeMapCircle";
                    
    document.body.appendChild(script);
};
