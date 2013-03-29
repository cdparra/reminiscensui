define([
    'backbone',
    'text!../../../../templates/timeline.html'
], function (
    Backbone,
    timelineTemplate) {

    var TimelineView = Backbone.View.extend({
        initialize : function() {
        },
        events:{
        },
        
        render : function() {
            this._loadPerson();
            this._loadFriends();
            this._loadTimeline();
            this._renderTimeline();
        },
        
        
        /* Helpers */ 
        _loadPerson : function() {
        },
        
        _loadFriends : function() {
        },

/*        _loadTimeline : function() {
            var self = this;
            var events = new CA.Collections.EventList();

            events.fetch({
                success : function(collection) {
                    var html = new EJS({
                        url : './scripts/ejs/events.ejs'
                    }).render({
                        collection : collection.toJSON()
                    });

                    $(self.el).find('.events').html(html);                
                
                }
            });
        },
        
        _renderTimeline : function() {
            var self = this;
            var html = new EJS({
                url : '../../../../templates/timeline.ejs'
            }).render();
            $(this.el).html(html);
        },

*/
        _renderTimeline:function () {
            var categories = _.uniq(
                _.map(this.model.models, function(model){
                    return model.get('category')
                }, function(item){
                    return item.id
                }));
            utilities.applyTemplate($(this.el), eventsTemplate, {categories:categories, model:this.model})
            $(this.el).find('.item:first').addClass('active');
            $(".collapse").collapse()
            $("a[rel='popover']").popover({trigger:'hover'});
            return this
        },
        update:function () {
            $("a[rel='popover']").popover('hide')
        }
    });
    return  TimelineView;
});