RE.Routers.Home = Backbone.Router.extend({
	routes : {
		"/" : "displayHome",
		"/start" : "startProfile",
		"*path"	: "notFound"
			
	},
	
	displayHome : function() {
		console.log("display");
		var home = new RE.Views.Home({
			el : '.page'
		});
		
		home.render();
	},

	displayHome : function() {
		console.log("display");
		var home = new RE.Views.Home({
			el : '.page'
		});
		
		home.render();
	},
	
	notFound : function() {
		window.location.hash = "#/";
	}
});