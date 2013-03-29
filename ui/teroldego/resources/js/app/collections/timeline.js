/**
 * Module for the LifeEvents collection
 */
define([
    // Backbone and the collection element type are dependencies
    'backbone',
    'app/models/lifeevent'
], function (Backbone, LifeEvent) {
    /**
     *  Here we define the LifeEvents collection
     *  We will use it for CRUD operations on LifeEvents
     */
    var Timeline = Backbone.Collection.extend({
        url:"timeline", // the URL for performing CRUD operations
        model: LifeEvent,
        id:"id", // the 'id' property of the model is the identifier
        comparator:function (model) {
            return model.get('category').id;
        }
    });
    return Timeline;
});