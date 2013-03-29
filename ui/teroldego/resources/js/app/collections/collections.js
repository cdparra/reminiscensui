CA.Collections.EventList = Backbone.Collection.extend({
	model : CA.Models.Event,
	url : CA.URL.EventList
});

CA.Collections.OrganizerList = Backbone.Collection.extend({
	model : CA.Models.Organizer,
	url : CA.URL.OrganizerList
});