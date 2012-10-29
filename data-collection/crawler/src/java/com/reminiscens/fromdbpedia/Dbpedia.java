/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reminiscens.fromdbpedia;

import com.hp.hpl.jena.query.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
//import com.hp.hpl.jena.sparql.engine.binding.*;

/**
 *
 * @author Nicola.Parrello
 */
public class Dbpedia {

    Collection<Event> events;
    private String sparqlService = "http://dbpedia.org/sparql";

    public Dbpedia() {

        events = new HashSet();
    }

    /**
     * @param args the command line arguments
     */
    public String formatDate(String date) {

        String formattedDate = date.substring(0, 10);
        return formattedDate;
    }

    public String formatTitle(String title) {

        String formattedTitle = title.substring(0, title.length() - 3);
        return formattedTitle;
    }

    public String formatLocationToUrl(String location) {

        if (location != null) {
            return location.replaceAll(" ", "_");
        } else {
            return null;
        }
    }

    // SE LA CHIAMO CON searchEndDate=false, ALLORA NELLA QUERY INSERIRO' NULL
    public void lookUpEvents(String fromStartDate, String toStartDate, String locationName, boolean searchEndDate) {

        if (!events.isEmpty()) {
            events.clear();
        }

        //CERCO startDate, location e title DI EVENTI (CHE HANNO TUTTI I CAMPI)

        String sparql = "PREFIX xsd:  <http://www.w3.org/2001/XMLSchema#>"
                + "SELECT *"
                + "WHERE {"
                + "?event a <http://dbpedia.org/ontology/Event> ."
                //+ "?event <http://dbpedia.org/ontology/location> ?location ."
                + "?event <http://www.w3.org/2000/01/rdf-schema#label> ?title ."
                + "?event <http://dbpedia.org/ontology/startDate> ?startDate .";

        if (searchEndDate) {
            sparql += "?event <http://dbpedia.org/ontology/endDate> ?endDate .";
        }

        //CERCO startDate e title DI EVENTI AVVENUTI A "location" (CHE HANNO ENTRAMBI I CAMPI)
        if (locationName != null) {
            sparql += "?event <http://dbpedia.org/ontology/location> <http://dbpedia.org/resource/" + this.formatLocationToUrl(locationName) + "> ."
                    + "FILTER (lang(?title)='en')";
        } else {
            sparql += "FILTER((?startDate >= '" + fromStartDate + "'^^xsd:date) && (?startDate <= '" + toStartDate + "'^^xsd:date)"
                    + "&& (lang(?title)='en'))";
        }


        sparql += "}";

        Query query = QueryFactory.create(sparql);

        QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlService, query);
        ResultSet results = qexec.execSelect();

        String eventAttribute = "event";
        String startDateAttribute = "startDate";
        String titleAttribute = "title";
        String locationAttribute = null;
        String endDateAttribute = null;
        String endDate = null;
        String locationUrl = null;

        if (searchEndDate) {
            endDateAttribute = "endDate";
        }

        if (locationName != null) {
            locationAttribute = "location";
        }
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
            if (searchEndDate) {
                endDate = qs.get(endDateAttribute).toString();
                endDate = formatDate(endDate);
            }
            if (locationName != null) {
                locationUrl = qs.get(locationAttribute).toString();
            }

            if (event_url != null || startDate != null || title != null || (endDate != null && searchEndDate)) {
                event = new Event();
                event.setSource("dbpedia");
                event.setHeadline(formatTitle(title));
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

                if (searchEndDate) {
                    end = new Fuzzy_Date();
                    end.setExact_date(endDate);
                    end.splitDate(startDate);
                    end.setAccuracy(9);
                    end.setInterval(interval);
                    interval.setEnddate(end);
                }
                if (locationName != null) {
                    location = new Location();
                    location.setTextual(locationName);
                    location.setEvent(event);
                    location.setAccuracy(3);
                    event.setLocation(location);
                }
                events.add(event);
                System.out.println("start:    " + startDate);
                System.out.println("end:    " + endDate);
            }
        }

        qexec.close();
    }
}
