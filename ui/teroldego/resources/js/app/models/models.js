/**
 * Event Model
 */

CA.Models.Event = Backbone.Model.extend({
	initialize : function() {
	},

	url : function() {
		return CA.URL.Events.replace("{0}", this.id);
	}
});


CA.Models.Organizer = Backbone.Model.extend({
	initialize : function() {
	},

	url : function() {
		return CA.URL.Organizer.replace("{0}", this.id);
	}
});