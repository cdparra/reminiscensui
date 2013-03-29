/**
 * Global variables for configuration of REConfigminiscens
 */
var REConfig = {
    URL : {},
    UIComponent : {},
    Path : {},
	initialize : function() {
	}
};

REConfig.carouselImg = 4;

// 5minutes
REConfig.pollingTimer = 60000;
REConfig.ksid = '';

// Social API Mockup 
REConfig.URL.Person = "api/mockup/person/{0}";
REConfig.URL.PersonList = "api/mockup/person.json";

REConfig.URL.Person.Relation = "api/mockup/person/{0}/Relation{1}";
REConfig.URL.Person.RelationList = "api/mockup/person/{0}/Relation.json";

// Personal Timeline API 
REConfig.URL.PersonLifeEvent = "api/mockup/person/{0}/lifeevent/{0}";
REConfig.URL.PersonTimeline = "api/mockup/person/{0}/timeline";

REConfig.URL.Timeline = "api/mockup/timeline/{0}";
REConfig.URL.TimelineList = "api/mockup/timeline/{0}";

// General Life Events API
REConfig.URL.LifeEvent = "api/mockup/lifeevent/{0}";
REConfig.URL.LifeEventList = "api/mockup/lifeevent.json";

REConfig.URL.Memento = "api/mockup/memento/{0}";
REConfig.URL.MementoList = "api/mockup/memento.json";



// General Elements 

REConfig.UIComponent.centralID = "#reCentral";
REConfig.UIComponent.headerID =  "#reHeader";
REConfig.UIComponent.footerID =  "#reFooter";

// Paths
REConfig.Path.templates = "resources/ejs/"