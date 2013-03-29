RE.Routers.Home = Backbone.Router.extend({
	routes : {
		"/start" : "startProfile",
		"/explore" : "exploreTimeline",
		"*path"	: "notFound"
			
	},
	
	startProfile : function() {
		console.log("home start profile");
		var header = new RE.Views.Home({
			el : '#header'
		});
		
		header.render();
		_displayRegisterForm();
		
	},

	_displayRegisterForm : function() {
		console.log("display register form");
		
		var home = new RE.Views.RegisterForm({
			el : '#reIndex'
		});
		
		home.render();
	},
	
	notFound : function() {
		window.location.hash = "#/";
	}
});