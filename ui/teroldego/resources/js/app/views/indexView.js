RE.Views.Index = Backbone.View.extend({

    Templates : {
        "buttons" : REConfig.Path.templates + "indexButtons.ejs",
        "footer"  : REConfig.Path.templates + "footer.ejs"
    },
    
	initialize : function() {
	},

	events : {
	},

	render : function() {
	    //this._renderCover();
	    this._renderButtons();
	},
	
	_renderButtons : function() {
		var self = this;
		var html = new EJS({
			url : this.Templates["buttons"]
		}).render();
		$(this.el).html(html);
	},
	//_loadGroups : function() {
	//	var self = this;
	//	var organizer = new CA.Collections.OrganizerList();
//
//		organizer.fetch({
//			success : function(collection) {
//				var html = new EJS({
//					url : './scripts/ejs/groups.ejs'
//				}).render({
//					collection : collection.toJSON()
//				});
//
//				$(self.el).find('.groups').html(html);				
//				
//			}
//		});
//	}	

});