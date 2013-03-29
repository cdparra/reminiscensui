RE.Views.Footer = Backbone.View.extend({

	initialize : function() {
	},

	events : {
	},

	render : function() {
		this._renderFooter();
	},

	/* Helpers. */

    Templates : {
        "/" : REConfig.Path.templates+"footer.ejs",
        "default" : REConfig.Path.templates+"footer.ejs"
    }, 
    
	_renderFooter : function() {
		var self = this;
		var templateURL = this.Templates["default"];
		console.log("loading template "+templateURL);
		var html = new EJS({
			url : templateURL
		}).render();
		$(this.el).html(html);
	}
	
});