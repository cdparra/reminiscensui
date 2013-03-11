/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.reminiscens.crawler.entities;

/**
 *
 * @author Nicola
 */
public class RatingCouple<T,Integer> {
    T object;
    Integer rating;
    
    public RatingCouple (T object,Integer rating) {
     this.object=object;  
     this.rating=rating;
    }
     
}
