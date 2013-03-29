RE.Views.Home = Backbone.View.extend({

	initialize : function() {
		
	},

	events : {
	},

	render : function() {
		this._renderHeader();
	},

	/* Helpers. */

	_renderHeader : function() {
		var self = this;

		var html = new EJS({
			url : './resources/ejs/navbar.ejs'
		}).render();

		$(this.el).html(html);
	}
});


RE.Views.RegisterForm = Backbone.View.extend({

	initialize : function() {
	},

	events : {
	},

	render : function() {
		this._renderRegisterForm();
	},

	/* Helpers. */

	_renderRegisterForm : function() {
		var self = this;

		var html = new EJS({
			url : './resources/ejs/register.ejs'
		}).render();

		$(this.el).html(html);
	}
});