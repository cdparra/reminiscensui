/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package np.reminiscens.crawler;

import java.sql.SQLException;
import java.util.Iterator;
import np.reminiscens.crawler.entities.Event;
import np.reminiscens.crawler.entities.Person;

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

        int mode = 0; // 0=eventi 1=persone

        if (mode == 0) {
            crawler.lookUpEvents("1960-01-01", "1965-12-31");
            Iterator i = crawler.events.iterator();
            Event event = null;
            while (i.hasNext()) {
                event = (Event) (i.next());
                int res = db.addEvent(event);
                System.out.println(event.getSource_url());
            }
        } else if (mode == 1) {
            crawler.lookUpPeople("Trento");
            Iterator i = crawler.people.iterator();
            Person person = null;
            while (i.hasNext()) {
                person = (Person) (i.next());
                int res = db.addPerson(person);
                System.out.println(person.getSource_url());
            }
        }

    }
}
