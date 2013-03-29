RE.Views.Header = Backbone.View.extend({

	initialize : function() {
	},

	events : {
	},

	render : function() {
		this._renderHeader();
	},

	/* Helpers. */

    Templates : {
        "/" : REConfig.Path.templates+"cover.ejs",
		"default" : REConfig.Path.templates+"navbar.ejs"
    }, 
	_renderHeader : function() {
		var self = this;
		var templateURL = this.Templates["default"];
		if (Backbone.history.fragment == "/") {
		    var templateURL = this.Templates["/"];
		}
		console.log("loading template "+templateURL);
		var html = new EJS({
			url : templateURL
		}).render();
		$(this.el).html(html);
	}
	
});