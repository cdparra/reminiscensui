/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package np.reminiscens.crawler;

import com.hp.hpl.jena.query.*;
import java.util.Collection;
import java.util.HashSet;
import np.reminiscens.crawler.entities.Event;
import np.reminiscens.crawler.entities.Fuzzy_Date;
import np.reminiscens.crawler.entities.Location;
import np.reminiscens.crawler.entities.Person;
import np.reminiscens.crawler.entities.Time_Interval;
//import com.hp.hpl.jena.sparql.engine.binding.*;

/**
 *
 * @author Nicola.Parrello
 */
public class Dbpedia {

    Collection<Event> events;
    Collection<Person> people;
    private String sparqlService = "http://dbpedia.org/sparql";

    public Dbpedia() {

        events = new <Event> HashSet();
        people = new <Person> HashSet();
    }

    /**
     * @param args the command line arguments
     */
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

    // SE LA CHIAMO CON searchEndDate=false, ALLORA NELLA QUERY INSERIRO' NULL
    public void lookUpEvents(String fromStartDate, String toStartDate) {

        if (!events.isEmpty()) {
            events.clear();
        }

        //CERCO startDate, location e title DI EVENTI (CHE HANNO TUTTI I CAMPI)

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
                + "&& (lang(?title)='en'))"
                + "}";
        
        

        Query query = QueryFactory.create(sparql);

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
            start.setExact_date(startDate);
            start.splitDate(startDate);
            start.setAccuracy(9);
            start.setInterval(interval);
            interval.setStartdate(start);

            if (endDate != null) {
                end = new Fuzzy_Date();
                end.setExact_date(endDate);
                end.splitDate(startDate);
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
            events.add(event);
        }
        qexec.close();
    }

    public void lookUpPeople(String locationName) {

        if (!people.isEmpty()) {
            people.clear();
        }

        String sparql = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>"
                + "PREFIX owl: <http://dbpedia.org/ontology/>"
                + "SELECT ?person ?nome ?cognome ?descr ?birthDate ?birthPlace"
                + " ?deathDate ?deathPlace" + "WHERE {"
                + "?person a owl:Person ."
                + "?person foaf:givenName ?nome ."
                + "?person foaf:surname ?cognome ."
                + "?person owl:abstract ?descr ."
                + "?person owl:birthDate ?birthDate ."
                + "?person owl:birthPlace ?birthPlace ."
                + "OPTIONAL {?person owl:deathDate ?deathDate ."
                + "?person owl:deathPlace ?deathPlace .}"
                + "?person owl:birthPlace  <http://dbpedia.org/resource/" + this.formatLocationToUrl(locationName) + "> ."
                + "FILTER (lang(?descr)='en')"
                + "}";

        Query query = QueryFactory.create(sparql);

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

        String person_url = null;
        String firstname = null;
        String lastname = null;
        String description = null;
        String birthDate = null;
        String deathDate = null;
        String birthPlace = null;
        String deathPlace = null;
        Location location;
        Time_Interval interval;
        Fuzzy_Date start;
        Fuzzy_Date end;

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

            if (qs.get(deathDateAttribute) != null) {
                deathDate = qs.get(deathDateAttribute).toString();
                deathDate = formatDate(deathDate);
            }
            birthPlace = qs.get(birthPlaceAttribute).toString();
            birthPlace=Person.formatLocation(birthPlace);

            if (qs.get(deathPlaceAttribute) != null) {
                deathPlace = qs.get(deathPlaceAttribute).toString();
                deathPlace=person.formatLocation(deathPlace);
            }

            person = new Person();
            person.setFirstName(firstname);
            person.setLastName(lastname);
            person.setFamous(true);
            person.setFamous_for(description);
            person.setSource("dbpedia");
            person.setSource_url(person_url);
            person.setCreator_type("SYSTEM");
            person.setLocale("en");

            people.add(person);
        }

        qexec.close();
    }
}
