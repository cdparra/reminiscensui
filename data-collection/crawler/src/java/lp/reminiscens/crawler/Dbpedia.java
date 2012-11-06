package lp.reminiscens.crawler;

import com.hp.hpl.jena.query.*;
import java.util.Collection;
import java.util.HashSet;
import lp.reminiscens.crawler.entities.Event;
import lp.reminiscens.crawler.entities.Fuzzy_Date;
import lp.reminiscens.crawler.entities.Location;
import lp.reminiscens.crawler.entities.Person;
import lp.reminiscens.crawler.entities.Person_Profile;
import lp.reminiscens.crawler.entities.Time_Interval;

public class Dbpedia {

    Collection<Event> events;
    Collection<Person> people;
    private String sparqlService = "http://dbpedia.org/sparql";
    final static String ENGLISH = "en";
    final static String ITALIAN = "it";

    public Dbpedia() {

        events = new <Event> HashSet();
        people = new <Person> HashSet();
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

    public void lookUpEvents(String fromStartDate, String toStartDate, String locationName, String language) {

        if (!events.isEmpty()) {
            events.clear();
        }

        String sparql = "PREFIX xsd:  <http://www.w3.org/2001/XMLSchema#>"
                + "SELECT *"
                + "WHERE {"
                + "?event a <http://dbpedia.org/ontology/Event> ."
                + "?event <http://www.w3.org/2000/01/rdf-schema#label> ?title ."
                + "?event <http://dbpedia.org/ontology/startDate> ?startDate ."
                + "OPTIONAL {"
                + "?event <http://dbpedia.org/ontology/location> ?location ."
                + "?event <http://dbpedia.org/ontology/endDate> ?endDate ."
                + "}"
                + "FILTER((?startDate >= '" + fromStartDate + "'^^xsd:date) && (?startDate <= '" + toStartDate + "'^^xsd:date)"
                + "&& (lang(?title)='" + language + "'))"
                + "}";

        ParameterizedSparqlString paramQuery = new ParameterizedSparqlString(sparql);
        //paramQuery.setLiteral("start", fromStartDate);
        //paramQuery.setLiteral("end", toStartDate);
        //paramQuery.setLiteral("language", language);

        Query query = paramQuery.asQuery();

        QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlService, query);
        ResultSet results = qexec.execSelect();


        String eventAttribute = "event";
        String startDateAttribute = "startDate";
        String titleAttribute = "title";
        String locationAttribute = "location";
        String endDateAttribute = "endDate";
        String endDate = null;
        String locationUrl = null;

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
            event.setSource_url(event_url);

            interval = new Time_Interval();
            interval.setStart_date(startDate);
            interval.setEnd_date(endDate);
            interval.setEvent(event);
            interval.setIs_fuzzy(1);
            event.setTimeInterval(interval);

            start = new Fuzzy_Date();
            start.setSeasonLimits();
            start.setExact_date(startDate);
            start.splitDate(startDate);
            start.setAccuracy(9);
            start.setInterval(interval);
            interval.setStartdate(start);

            if (endDate != null) {
                end = new Fuzzy_Date();
                end.setSeasonLimits();
                end.setExact_date(endDate);
                end.splitDate(endDate);
                end.setAccuracy(9);
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

    public void lookUpPeople(String fromBirthDate, String toBirthDate, String locationName, String language) {

        if (!people.isEmpty()) {
            people.clear();
        }
        System.out.println(locationName);
        String sparql = "PREFIX foaf: <http://xmlns.com/foaf/0.1/> "
                + "PREFIX owl: <http://dbpedia.org/ontology/> "
                + "PREFIX xsd:  <http://www.w3.org/2001/XMLSchema#> "
                + "PREFIX dbprop:  <http://dbpedia.org/property/> "
                + "SELECT ?person ?nome ?cognome ?descr ?birthDate ?birthPlace "
                + "?deathDate ?deathPlace ?nationality"
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
        //paramQuery.setLiteral("from", fromBirthDate);
        //paramQuery.setLiteral("to", toBirthDate);
        //paramQuery.setLiteral("location", formatLocationToUrl(locationName));
        //paramQuery.setLiteral("language", language);

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
