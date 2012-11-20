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

    public List<RatingCouple<Person,Integer>> people;
    public List<RatingCouple<Event,Integer>> events;
    public List<RatingCouple<Media_Metadata,Integer>> mediaMDs;
    public List<RatingCouple<Media,Integer>> photos;

    public RecommendationSet() {
        people = new ArrayList<RatingCouple<Person,Integer>>();
        events = new ArrayList<RatingCouple<Event,Integer>>();
        mediaMDs = new ArrayList<RatingCouple<Media_Metadata,Integer>>();
        photos = new ArrayList<RatingCouple<Media,Integer>>();
        
        
    }
}
