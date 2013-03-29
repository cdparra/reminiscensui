/**
 * Shortcut alias definitions - will come in handy when declaring dependencies
 * Also, they allow you to keep the code free of any knowledge about library
 * locations and versions
 */
 
 
require.config({
    paths: {
        jquery:'lib/jquery-1.8.0.min',
        underscore:'lib/underscore-min',
        text:'lib/text',
        i18n:'lib/i18n',
        //domready:'lib/domReady',
        bootstrap: 'lib/bootstrap.min',
        backbone: 'lib/backbone-min',
        ejs: 'lib/ejs_production',
        timelinejs: 'lib/timelines/timelinejs/js/timeline-min',
        datepicker: 'lib/datepicker/js/bootstrap-datepicker'
        
        /*utilities: 'app/utilities',*/
        //router
    }
});

// Backbone is not AMD-ready, so a individual module is declared
define("backbone", [
    // the order plugin is used to ensure that the modules are loaded in the right order
    'jquery',
    'underscore',
    'lib/backbone-min'], function(){ 
        return Backbone;
});

// Now we declare all the dependencies
require([
    'jquery',
    'underscore',
    'backbone',
    'ejs',
    'text',
    'i18n',
    'bootstrap',
], function(){
    console.log('all loaded')
});