/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

  
var geocoder;
var map;
var marker;
var latlng;
var circle;
           
function initialize() {
    geocoder = new google.maps.Geocoder();
                
    latlng = new google.maps.LatLng(41.901514, 12.4607737);
                
    var mapOptions = {
        zoom: 8,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
               
    map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
   
    marker = new google.maps.Marker({
        position: latlng,
        map: map,
        draggable: true,
        visible:true
    }); 
      
    circle = new google.maps.Circle({
        //center: latlng,
        //map: map,
        editable: true,
        visible:true,
        strokeColor: "#FF0000",
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: "#FF0000",
        fillOpacity: 0.35,
        radius: 10000
    });   
      
    google.maps.event.addListener(marker, 'dragend', function(event) {                    
        map.panTo(event.latLng);
        
        document.getElementById("lat").value = marker.getPosition().lat();
        document.getElementById("lng").value = marker.getPosition().lng();
        getMarkerLocationInfo(event.latLng);
    });  
     
    google.maps.event.addListener(map, 'click', function(event) {
        marker.setPosition(event.latLng);
        
        if(marker.getMap() == null){
            marker.setMap(map);
            circle.setMap(null);
            document.getElementById("radius").value = null;
        }
        
        // map.panTo(event.latLng);
        document.getElementById("lat").value = marker.getPosition().lat();
        document.getElementById("lng").value = marker.getPosition().lng();
        getMarkerLocationInfo(event.latLng);
        
    });  
      
    google.maps.event.addListener(map, 'rightclick', function(event) {
        circle.setCenter(event.latLng);
        
        if(circle.getMap() == null){
            circle.setMap(map);
            marker.setMap(null);
            document.getElementById("radius").value = circle.getRadius();
        } 
               
        document.getElementById("lat").value = circle.getCenter().lat();
        document.getElementById("lng").value = circle.getCenter().lng();
       
    // getMarkerLocationInfo(event.latLng);
    });
    
    google.maps.event.addListener(circle,'radius_changed',function(){
        document.getElementById("radius").value = circle.getRadius();
    });
         
    google.maps.event.addListener(circle,'center_changed',function(){
        document.getElementById("lat").value = circle.getCenter().lat();
        document.getElementById("lng").value = circle.getCenter().lng();
        getMarkerLocationInfo(circle.getCenter());        
    });
             
                
    if(navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
                       
            var pos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
            map.setCenter(pos);
            marker.setPosition(pos);
            circle.setCenter(pos);
          
            document.getElementById("lat").value = pos.lat();
            document.getElementById("lng").value = pos.lng();
        //getMarkerLocationInfo(pos);
            
        }, function() {
            handleNoGeolocation(true);
        });
    }
    else {
        // Browser doesn't support Geolocation
        handleNoGeolocation(false);
    }
}        
           
function handleNoGeolocation(errorFlag) {
    //var latlng = new google.maps.LatLng(-34.397, 150.644);
    if (errorFlag) {
        var content = 'Error: The Geolocation service failed.';
    } else {
        var content = 'Error: Your browser doesn\'t support geolocation.';
    }
    var options = {
        map: map,
        position: latlng,
        content: content
    };
               
    var infowindow = new google.maps.InfoWindow(options);
    map.setCenter(options.position);
}
           
function codeAddress() {
    var address = document.getElementById("address").value;
    geocoder.geocode( {
        'address': address
    }, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            //prendo il primo risultato che mi ritorna            
            map.panTo(results[0].geometry.location);
            marker.setPosition(results[0].geometry.location);

            document.getElementById("lat").value = marker.getPosition().lat();
            document.getElementById("lng").value = marker.getPosition().lng();                             
            getMarkerLocationInfo(results[0].geometry.location);                        
        } else {
            alert("Geocode was not successful for the following reason: " + status);
        }
    });
} 
            
function getMarkerLocationInfo(location){
                                           
    geocoder.geocode({
        'latLng': location
    }, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            if (results[0]) {                   
              
                /* for(var i in results[0].address_components){
                   console.log(i+" : " +results[0].address_components[i].types[0]+" : "+results[0].address_components[i].long_name);   
                }
               */            
                document.getElementById('indirizzo').value = results[0].formatted_address ;
             
            }
        } else {
            alert("Geocoder failed due to: " + status);
        }
    });
}

// google.maps.event.addDomListener(window, 'load', initialize);


