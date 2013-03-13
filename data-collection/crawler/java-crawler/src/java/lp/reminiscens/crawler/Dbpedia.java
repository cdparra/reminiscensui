package lp.reminiscens.crawler;

import com.hp.hpl.jena.query.*;
import java.util.Collection;
import java.util.HashSet;
import lp.reminiscens.crawler.entities.Event;
import lp.reminiscens.crawler.entities.Fuzzy_Date;
import lp.reminiscens.crawler.entities.Location;
import lp.reminiscens.crawler.entities.Media_Metadata;
import lp.reminiscens.crawler.entities.Person;
import lp.reminiscens.crawler.entities.Person_Profile;
import lp.reminiscens.crawler.entities.Time_Interval;

public class Dbpedia {

    Collection<Event> events;
    Collection<Person> people;
    Collection<Media_Metadata> mediaMDs;
    private String sparqlService = "http://dbpedia.org/sparql";
    final static String ENGLISH = "en";
    final static String ITALIAN = "it";

    public Dbpedia() {

        events = new HashSet<Event>();
        people = new HashSet<Person>();
        mediaMDs = new HashSet<Media_Metadata>();
    }

    public String formatDate(String date) {
        if (date != null) {
            String formattedDate = date.substring(0, 10);
            return formattedDate;
        } else {
            return null;
        }
    }

    public String formatStringLocale(String string) {
        if (string != null) {
            String formattedString = string.substring(0, string.length() - 3);
            return formattedString;
        } else {
            return null;
        }
    }

    public String formatLocationToUrl(String location) {

        if (location != null) {
            return location.replaceAll(" ", "_");
        } else {
            return null;
        }
    }

    public void lookUpMediaMM(String language, String type) {

        if (!mediaMDs.isEmpty()) {
            mediaMDs.clear();
        }

        String sparql = null;

        if (type.equals("ALBUM")) {
            sparql = "SELECT *"
                    + "WHERE {"
                    + "?work a <http://dbpedia.org/ontology/Album> ."
                    + "?work <http://www.w3.org/2000/01/rdf-schema#label> ?title ."
                    + "?work <http://dbpedia.org/ontology/abstract> ?descr ."
                    + "?work <http://purl.org/dc/terms/subject> <http://dbpedia.org/resource/Category:Italian-language_albums> ."
                    + "{"
                    + "?work <http://dbpedia.org/ontology/releaseDate> ?relDate ."
                    + "}"
                    + "UNION {"
                    + "?work <http://dbpedia.org/property/released> ?relDate_1"
                    + "}"
                    + "FILTER (lang(?title)='" + language + "' && lang(?descr)='" + language + "')"
                    + "}";
        } else if (type.equals("BOOK")) {
            sparql = "SELECT *"
                    + "WHERE {"
                    + "?work a <http://dbpedia.org/ontology/Book> ."
                    + "?work <http://www.w3.org/2000/01/rdf-schema#label> ?title ."
                    + "?work <http://dbpedia.org/ontology/abstract> ?descr ."
                    + "{"
                    + "?work <http://dbpedia.org/property/pubDate> ?relDate ."
                    + "}"
                    + "UNION {"
                    + "?work <http://dbpedia.org/property/released> ?relDate_1"
                    + "}"
                    + "FILTER (lang(?title)='" + language + "' && lang(?descr)='" + language + "')"
                    + "}";
        } else if (type.equals("SONG")) {
            sparql = "SELECT *"
                    + "WHERE {"
                    + "?work a <http://dbpedia.org/ontology/Song> ."
                    + "?work <http://www.w3.org/2000/01/rdf-schema#label> ?title ."
                    + "?work <http://dbpedia.org/ontology/abstract> ?descr ."
                    + "{"
                    + "?work <http://dbpedia.org/ontology/releaseDate> ?relDate ."
                    + "}"
                    + "UNION {"
                    + "?work <http://dbpedia.org/property/released> ?relDate_1"
                    + "}"
                    + "FILTER (lang(?title)='" + language + "' && lang(?descr)='" + language + "')"
                    + "}";
        } else if (type.equals("FILM")) {
            sparql = "SELECT *"
                    + "WHERE {"
                    + "?work a <http://dbpedia.org/ontology/Film> ."
                    + "?work <http://www.w3.org/2000/01/rdf-schema#label> ?title ."
                    + "?work <http://dbpedia.org/ontology/abstract> ?descr ."
                    + "{"
                    + "?work <http://dbpedia.org/ontology/releaseDate> ?relDate ."
                    + "}"
                    + "UNION {"
                    + "?work <http://dbpedia.org/property/released> ?relDate_1"
                    + "}"
                    + "FILTER (lang(?title)='" + language + "' && lang(?descr)='" + language + "')"
                    + "}";
        }

        ParameterizedSparqlString paramQuery = new ParameterizedSparqlString(sparql);

        Query query = paramQuery.asQuery();

        QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlService, query);
        ResultSet results = qexec.execSelect();

        String workAttribute = "work";
        String releaseDateAttribute = "relDate";
        String releaseDateAttribute_1 = "relDate_1";
        String titleAttribute = "title";
        String descrAttribute = "desc";
        String description = null;

        String work_url = null;
        String releaseDate = null;
        String title = null;
        Time_Interval interval;
        Fuzzy_Date start;

        Media_Metadata mediaMD = null;
        while (results.hasNext()) {
            QuerySolution qs = results.next();
            work_url = qs.get(workAttribute).toString();
            if (qs.get(releaseDateAttribute) == null) {
                releaseDate = qs.get(releaseDateAttribute_1).toString();
            } else {
                releaseDate = qs.get(releaseDateAttribute).toString();
            }
            if (releaseDate.substring(0, 4).matches("^([1-2][0-9][0-9][0-9])") && releaseDate.length() > 4) {
                releaseDate = formatDate(releaseDate);
            }

            title = qs.get(titleAttribute).toString();
            description = qs.get(descrAttribute).toString();

            if (releaseDate.substring(0, 4).matches("^([1-2][0-9][0-9][0-9])")) {

                if (Integer.parseInt(releaseDate.substring(0, 4)) > 1900) {

                    mediaMD = new Media_Metadata();
                    mediaMD.setSource("dbpedia");
                    mediaMD.setTitle(formatStringLocale(title));
                    mediaMD.setDescription(formatStringLocale(description));
                    mediaMD.setType(type);
                    mediaMD.setSource_url(work_url);

                    interval = new Time_Interval();
                    interval.setStart_date(releaseDate);
                    interval.setMediaMD(mediaMD);
                    interval.setIs_fuzzy(1);
                    mediaMD.setReleaseDate(interval);

                    start = new Fuzzy_Date();
                    start.setSeasonLimits();
                    start.splitDate(releaseDate);
                    start.setInterval(interval);
                    interval.setStartdate(start);

                    mediaMD.setLocale(language);

                    mediaMDs.add(mediaMD);
                }
            }
        }
        qexec.close();
    }

    public void lookUpEvents(String fromStartDate, String toStartDate, String locationName, String language) {

        String sparql = "PREFIX xsd:  <http://www.w3.org/2001/XMLSchema#>"
                + "SELECT *"
                + "WHERE {"
                + "?event a <http://dbpedia.org/ontology/Event> ."
                + "?event <http://www.w3.org/2000/01/rdf-schema#label> ?title ."
                + "?event <http://dbpedia.org/ontology/abstract> ?desc ."
                + "?event <http://dbpedia.org/ontology/startDate> ?startDate ."
                + "OPTIONAL {"
                + "?event <http://dbpedia.org/ontology/location> ?location ."
                + "?event <http://dbpedia.org/ontology/endDate> ?endDate ."
                + "}"
                + "FILTER((?startDate >= '" + fromStartDate + "'^^xsd:date) && (?startDate <= '" + toStartDate + "'^^xsd:date)"
                + "&& (lang(?title)='" + language + "') && (lang(?desc)='" + language + "'))"
                + "}";

        ParameterizedSparqlString paramQuery = new ParameterizedSparqlString(sparql);

        Query query = paramQuery.asQuery();

        QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlService, query);
        ResultSet results = qexec.execSelect();

        String eventAttribute = "event";
        String startDateAttribute = "startDate";
        String titleAttribute = "title";
        String locationAttribute = "location";
        String endDateAttribute = "endDate";
        String descrAttribute = "desc";
        String endDate = null;
        String locationUrl = null;
        String description = null;

        String event_url = null;
        String startDate = null;
        String title = null;
        Location location;
        Time_Interval interval;
        Fuzzy_Date start;
        Fuzzy_Date end;

        Event event = null;
        while (results.hasNext()) {
            QuerySolution qs = results.next();
            event_url = qs.get(eventAttribute).toString();
            startDate = qs.get(startDateAttribute).toString();
            startDate = formatDate(startDate);
            title = qs.get(titleAttribute).toString();
            description = qs.get(descrAttribute).toString();
            if (qs.get(endDateAttribute) != null) {
                endDate = qs.get(endDateAttribute).toString();
                endDate = formatDate(endDate);
            }

            if (qs.get(locationAttribute) != null) {
                locationUrl = qs.get(locationAttribute).toString();
            }

            event = new Event();
            event.setSource("dbpedia");
            event.setHeadline(formatStringLocale(title));
            event.setText(description);
            event.setType("GENERAL");
            event.setSource_url(event_url);

            interval = new Time_Interval();
            interval.setStart_date(startDate);
            interval.setEnd_date(endDate);
            interval.setEvent(event);
            interval.setIs_fuzzy(1);
            event.setTimeInterval(interval);

            start = new Fuzzy_Date();
            start.setSeasonLimits();
            start.splitDate(startDate);
            start.setInterval(interval);
            interval.setStartdate(start);

            if (endDate != null) {
                end = new Fuzzy_Date();
                end.setSeasonLimits();
                end.splitDate(endDate);
                end.setInterval(interval);
                interval.setEnddate(end);
            }
            if (locationUrl != null) {
                location = new Location();
                location.setTextual(Event.formatLocation(locationUrl));
                location.setEvent(event);
                location.setAccuracy(3);
                event.setLocation(location);
            }
            event.setLocale(language);

            events.add(event);
        }
        qexec.close();
    }

    public void lookUpSpaceMissions(String fromStartDate, String toStartDate, String locationName, String language) {

        String sparql = "SELECT DISTINCT *"
                + "WHERE {"
                + "?event a <http://dbpedia.org/ontology/SpaceMission> ."
                + "?event <http://www.w3.org/2000/01/rdf-schema#label> ?title ."
                + "?event <http://dbpedia.org/ontology/abstract> ?descr ."
                + "?event <http://dbpedia.org/ontology/launchDate> ?launchDate ."
                + "?event <http://dbpedia.org/ontology/landingDate> ?landingDate ."
                + "FILTER (lang(?title)='" + language + "' && lang(?descr)='" + language + "')"
                + "}";

        ParameterizedSparqlString paramQuery = new ParameterizedSparqlString(sparql);

        Query query = paramQuery.asQuery();

        QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlService, query);
        ResultSet results = qexec.execSelect();

        String eventAttribute = "event";
        String launchDateAttribute = "launchDate";
        String landingDateAttribute = "landingDate";
        String titleAttribute = "title";
        //String locationAttribute = "location";
        String descrAttribute = "desc";
        String landingDate = null;
        String description = null;

        String event_url = null;
        String launchDate = null;
        String title = null;
        Location location;
        Time_Interval interval;
        Fuzzy_Date start;
        Fuzzy_Date end;

        Event event = null;
        while (results.hasNext()) {
            QuerySolution qs = results.next();
            event_url = qs.get(eventAttribute).toString();
            launchDate = qs.get(launchDateAttribute).toString();
            launchDate = formatDate(launchDate);
            landingDate = qs.get(landingDateAttribute).toString();
            landingDate = formatDate(landingDate);
            title = qs.get(titleAttribute).toString();
            description = qs.get(descrAttribute).toString();

            event = new Event();
            event.setSource("dbpedia");
            event.setHeadline(formatStringLocale(title));
            event.setText(description);
            event.setType("SPACE_MISSION");
            event.setSource_url(event_url);

            interval = new Time_Interval();
            interval.setStart_date(launchDate);
            interval.setEnd_date(landingDate);
            interval.setEvent(event);
            interval.setIs_fuzzy(1);
            event.setTimeInterval(interval);

            start = new Fuzzy_Date();
            start.setSeasonLimits();
            start.splitDate(launchDate);
            start.setInterval(interval);
            interval.setStartdate(start);

            end = new Fuzzy_Date();
            end.setSeasonLimits();
            end.splitDate(landingDate);
            end.setInterval(interval);
            interval.setEnddate(end);

            event.setLocale(language);

            events.add(event);
        }
        qexec.close();
    }

    public void lookUpSportEvents(String fromStartDate, String toStartDate, String locationName, String language) {

        String sparql = "SELECT DISTINCT *"
                + "WHERE {"
                + "?event a <http://dbpedia.org/ontology/SportsEvent> ."
                + "?event <http://www.w3.org/2000/01/rdf-schema#label> ?title ."
                + "?event <http://dbpedia.org/ontology/abstract> ?descr ."
                + "?event <http://dbpedia.org/ontology/date> ?date ."
                + "?event <http://dbpedia.org/ontology/city> ?city."
                + "FILTER (lang(?title)='" + language + "' && lang(?descr)='" + language + "')"
                + "}";

        ParameterizedSparqlString paramQuery = new ParameterizedSparqlString(sparql);

        Query query = paramQuery.asQuery();

        QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlService, query);
        ResultSet results = qexec.execSelect();

        String eventAttribute = "event";
        String dateAttribute = "date";
        String titleAttribute = "title";
        String cityAttribute = "city";
        String descrAttribute = "desc";
        String city = null;

        String event_url = null;
        String date = null;
        String title = null;
        String description = null;
        Location location;
        Time_Interval interval;
        Fuzzy_Date start;
        Fuzzy_Date end;

        Event event = null;
        while (results.hasNext()) {
            QuerySolution qs = results.next();
            event_url = qs.get(eventAttribute).toString();
            date = qs.get(dateAttribute).toString();
            date = formatDate(date);
            title = qs.get(titleAttribute).toString();
            description = qs.get(descrAttribute).toString();
            city = qs.get(cityAttribute).toString();
        }

        event = new Event();
        event.setSource("dbpedia");
        event.setHeadline(formatStringLocale(title));
        event.setText(description);
        event.setType("SPORT_EVENT");
        event.setSource_url(event_url);

        interval = new Time_Interval();
        interval.setStart_date(date);
        interval.setEvent(event);
        interval.setIs_fuzzy(1);
        event.setTimeInterval(interval);

        start = new Fuzzy_Date();
        start.setSeasonLimits();
        start.splitDate(date);
        start.setInterval(interval);
        interval.setStartdate(start);

        location = new Location();
        location.setTextual(Event.formatLocation(city));
        location.setEvent(event);
        location.setAccuracy(3);
        event.setLocation(location);

        event.setLocale(language);

        events.add(event);


        qexec.close();
    }

    public void lookUpPeople(String fromBirthDate, String toBirthDate, String locationName, String language) {

        if (!people.isEmpty()) {
            people.clear();
        }
        System.out.println(locationName);
        String sparql = "PREFIX foaf: <http://xmlns.com/foaf/0.1/> "
                + "PREFIX owl: <http://dbpedia.org/ontology/> "
                + "PREFIX xsd:  <http://www.w3.org/2001/XMLSchema#> "
                + "PREFIX dbprop:  <http://dbpedia.org/property/> "
                + "SELECT *"
                + "WHERE { "
                + "?person a owl:Person . "
                + "?person foaf:givenName ?nome . "
                + "?person foaf:surname ?cognome . "
                + "?person owl:abstract ?descr . "
                + "?person owl:birthDate ?birthDate . "
                + "?person owl:birthPlace ?birthPlace . "
                + "OPTIONAL {?person owl:deathDate ?deathDate . "
                + "?person dbprop:nationality ?nationality . "
                + "?person owl:deathPlace ?deathPlace .} "
                + "?person owl:birthPlace  <http://dbpedia.org/resource/" + formatLocationToUrl(locationName) + "> . "
                // + "FILTER((?birthDate >= '?from'^^xsd:date) && (?birthDate <= '?to'^^xsd:date) "
                // + "&& (lang(?descr)='?language')) "
                + "FILTER (lang(?descr)='" + language + "') "
                + "}";

        ParameterizedSparqlString paramQuery = new ParameterizedSparqlString(sparql);

        Query query = paramQuery.asQuery();

        QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlService, query);
        ResultSet results = qexec.execSelect();

        String personAttribute = "person";
        String nameAttribute = "nome";
        String surnameAttribute = "cognome";
        String descrAttribute = "descr";
        String birthDateAttribute = "birthDate";
        String deathDateAttribute = "deathDate";
        String birthPlaceAttribute = "birthPlace";
        String deathPlaceAttribute = "deathPlace";
        String nationalityAttribute = "nationality";

        String person_url = null;
        String firstname = null;
        String lastname = null;
        String description = null;
        String birthDate = null;
        String deathDate = null;
        String birthPlace = null;
        String deathPlace = null;
        String nationality = null;
        Location location;
        Time_Interval interval;
        Fuzzy_Date start;
        Fuzzy_Date end;
        Person_Profile data;

        Person person = null;
        while (results.hasNext()) {
            QuerySolution qs = results.next();
            person_url = qs.get(personAttribute).toString();
            firstname = qs.get(nameAttribute).toString();
            firstname = formatStringLocale(firstname);
            lastname = qs.get(surnameAttribute).toString();
            lastname = formatStringLocale(lastname);
            description = qs.get(descrAttribute).toString();
            description = formatStringLocale(description);
            birthDate = qs.get(birthDateAttribute).toString();
            birthDate = formatDate(birthDate);

            if (qs.get(nationalityAttribute) != null) {
                nationality = qs.get(nationalityAttribute).toString();
                nationality = formatStringLocale(nationality);
            }

            if (qs.get(deathDateAttribute) != null) {
                deathDate = qs.get(deathDateAttribute).toString();
                deathDate = formatDate(deathDate);
            }
            birthPlace = qs.get(birthPlaceAttribute).toString();
            birthPlace = Person.formatLocation(birthPlace);

            if (qs.get(deathPlaceAttribute) != null) {
                deathPlace = qs.get(deathPlaceAttribute).toString();
                deathPlace = person.formatLocation(deathPlace);
            }

            //PERSON_PROFILE
            data = new Person_Profile();
            data.setBirthDate(birthDate);
            data.setDeathDate(deathDate);
            data.setNationality(nationality);

            person = new Person();
            person.setFirstName(firstname);
            person.setLastName(lastname);
            person.setFamous(true);
            person.setFamous_for(description);
            person.setSource("dbpedia");
            person.setSource_url(person_url);
            person.setCreator_type("SYSTEM");
            person.setLocale(language);

            people.add(person);
        }

        qexec.close();
    }
}
