/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.reminiscens.crawler;

import java.util.Iterator;
import lp.reminiscens.crawler.entities.Event;
import lp.reminiscens.crawler.entities.Location;
import lp.reminiscens.crawler.entities.Media;
import lp.reminiscens.crawler.entities.Media_Metadata;
import lp.reminiscens.crawler.entities.Person;
import lp.reminiscens.crawler.entities.RecommendationSet;
import lp.reminiscens.crawler.entities.Time_Interval;

/**
 *
 * @author Nicola
 */
public class RecommendationEngine {

    Database db;
    Iterator iter;

    public RecommendationEngine() {
        db = new Database();
    }

    public RecommendationSet getRecommendations(Event myEvent) {
        RecommendationSet result = new RecommendationSet();

        result.events = db.getEvents();
        iter = result.events.listIterator();
        Event event;
        while (iter.hasNext()) {
            event = (Event) iter.next();
            if (!isRelated(myEvent.getTimeInterval(), event.getTimeInterval(), myEvent.getLocation(), event.getLocation(), "EVENT")) {
                result.events.remove(event);
            }
        }

        result.mediaMDs = db.getMDs();
        iter = result.mediaMDs.listIterator();
        Media_Metadata mediaMD;
        while (iter.hasNext()) {
            mediaMD = (Media_Metadata) iter.next();
            if (!isRelated(myEvent.getTimeInterval(), mediaMD.getReleaseDate(), null, null, "MEDIA_METADATA")) {
                result.mediaMDs.remove(mediaMD);
            }
        }

        result.people = db.getPeople();
        iter = result.people.listIterator();
        Person person;
        boolean response=true;
        while (iter.hasNext()) {
            person = (Person) iter.next();
            if (person.getPerson_Profile.getDeathDate() != null && person.getPerson_Profile.getDeathPlace() != null) {
                response = isRelated(myEvent.getTimeInterval(), person.getPerson_Profile().getBirthDate(), myEvent.getLocation(), person.getBirthPlace, "PERSON")
                        || isRelated(myEvent.getTimeInterval(), person.getPerson_Profile().getDeathDate(), myEvent.getLocation(), person.getDeathPlace, "PERSON");
            } else {
                response = isRelated(myEvent.getTimeInterval(), person.getPerson_Profile().getBirthDate(), myEvent.getLocation(), person.getBirthPlace, "PERSON");
            }
            if (!response) {
                result.people.remove(person);
            }
        }

        result.photos = db.getMedia();
        iter = result.photos.listIterator();
        Media photo;
        while (iter.hasNext()) {
            photo = (Media) iter.next();
            if (!isRelated(myEvent.getTimeInterval(), photo.getTimeInterval(), myEvent.getLocation(), photo.getLocation(), "PHOTO")) {
                result.photos.remove(photo);
            }
        }

        return result;
    }

    public boolean isRelated(Time_Interval time1, Time_Interval time2, Location space1, Location space2, String type) {
        int year1 = Integer.parseInt(time1.getStartdate().getYear());
        int year2 = Integer.parseInt(time2.getStartdate().getYear());
        if (Math.abs(year1 - year2) <= 5) {
            if (space1 != null && space2 != null && !type.equalsIgnoreCase("MEDIA_METADATA")) {
                if (space1.getCountry().equals(space2.getCountry())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
