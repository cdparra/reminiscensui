/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reminiscens.fromdbpedia;

import com.reminiscens.imagewrapper.Database;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;

/**
 *
 * @author Nicola.Parrello
 */
public class DbpediaManager {

    public static void main(String[] args) throws SQLException {

        Dbpedia crawler = new Dbpedia();
        Database db = new Database();

        try {
            if (db.connessioneChiusa()) {
                System.out.println("Connessione chiusa");
            } else {
                System.out.println("Connessione aperta");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        crawler.lookUpEvents("1960-01-01", "1965-12-31", null, true);
        
        Iterator i = crawler.events.iterator();

        Timestamp now = null;
        Event event = null;

        while (i.hasNext()) {
            event = (Event) (i.next());
            int res = db.addEvent(event);
            System.out.println(event.getSource_url());
        }
    }
}
