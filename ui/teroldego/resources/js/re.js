/**
 * The dynamic structure of Reminiscens' application is inside the variable 
 * RE including routers, collections, models, views, etc. 
 */
var RE = {
	Auth : {},
	URL : {},
	Lang : {},
	Routers : {},
	Collections : {},
	Models : {},
	Views : {},
	Utils : {},
	Helpers : {},
	Config : REConfig,
	
	// Function called to load the HomePage
	index : function() {			
	    console.log("reminiscens starting routers");
		new RE.Routers.Index();	
		Backbone.history.start();
	}
};

function displayLogin(accessToken){      
    var baseLoginURL = '/api/um/resources/session'
    var request = {
        name : 'facebook',
        authString : accessToken
    };

    $.ajax({
        type : 'POST',
        url : baseLoginURL,
        contentType : 'application/json',
        data : JSON.stringify(request),
        success : function(data) {
            localStorage.sessionId = data.id;
            /*
             * start routing only if success
             */ 
             Backbone.history.start();
        },
        dataType : 'json',
        error : function(e) {
            /* Called when there is an error. */
            consoleLog("Sync error: " + e.message);         
        }
    });
    
}