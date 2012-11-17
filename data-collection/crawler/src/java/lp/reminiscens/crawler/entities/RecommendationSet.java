/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.reminiscens.crawler.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicola
 */
public class RecommendationSet {

    public List<Person> people;
    public List<Event> events;
    public List<Media_Metadata> mediaMDs;
    public List<Media> photos;

    public RecommendationSet() {
        people = new ArrayList<Person>();
        events = new ArrayList<Event>();
        mediaMDs = new ArrayList<Media_Metadata>();
        photos = new ArrayList<Media>();
    }
}
