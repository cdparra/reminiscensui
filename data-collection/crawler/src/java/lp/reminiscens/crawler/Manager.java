/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.reminiscens.crawler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import lp.reminiscens.crawler.entities.Event;
import lp.reminiscens.crawler.entities.Media;
import lp.reminiscens.crawler.entities.Media_Metadata;
import lp.reminiscens.crawler.entities.Person;
import org.json.JSONException;

/**
 *
 * @author Nicola
 */
public class Manager {

    final int PEOPLE = 0;
    final int EVENTS = 1;
    final int MEDIA = 2;
    final int MEDIAMDS = 3;
    Dbpedia dbpedia;
    FlickrToURL flickr;
    CoordSearcher coord;
    Database db;
    Iterator iter;

    public static void main(String[] args) {
        // TODO code application logic here
        Manager man = new Manager();
        man.coord = new CoordSearcher();
        man.db = new Database();
        //man.search(man.PEOPLE, "1960-01-01", "2010-12-31", "Trento", Dbpedia.ITALIAN);
    }

    public void search(int target, String fromDate, String toDate, String location, String language) {
        switch (target) {

            case 0:
                queryPeople(fromDate, toDate, location, language);
                break;

            case 1:
                queryEvents(fromDate, toDate, location, language);
                break;

            case 2:
                askForPhotos(fromDate, toDate, location, language);
                break;

            case 3:
                queryMediaMDs(language, "BOOK");
                queryMediaMDs(language, "ALBUM");
                queryMediaMDs(language, "SONG");
                queryMediaMDs(language, "SONG");
                break;

            default:
                System.out.println("Impossibile completare la richiesta: scelta non supportata");
                break;
        }
    }

    public void queryPeople(String fromBirthDate, String toBirthDate, String location, String language) {
        dbpedia = new Dbpedia();
        dbpedia.lookUpPeople(fromBirthDate, toBirthDate, location, language);
        iter = dbpedia.people.iterator();
        Person person = null;
        while (iter.hasNext()) {
            person = (Person) (iter.next());
            int res = db.addPerson(person);
            System.out.println(person.getSource_url());
        }
        System.out.println("Sono state aggiunte " + db.newPeople + " nuove persone.");
    }

    public void queryEvents(String fromStartDate, String toStartDate, String location, String language) {
        dbpedia = new Dbpedia();
        dbpedia.lookUpEvents(fromStartDate, toStartDate, location, language);
        dbpedia.lookUpSpaceMissions(null, null, null, language);
        dbpedia.lookUpSportEvents(null, null, null, language);
        iter = dbpedia.events.iterator();
        Event event = null;
        double latitude;
        while (iter.hasNext()) {
            event = (Event) (iter.next());
            if (event.getLocation() != null && event.getLocation().getTextual() != null) {
                try {
                    String out = coord.getJSONByGoogle(event.getLocation().getTextual()); // chiamata alle api di google maps
                    coord.parseGeoJSON(out, event); // parsing del json proveniente dalle api di google maps
                    event.getLocation().setCoordinates_trust(0);
                    event.getLocation().setAccuracy(19);

                } catch (MalformedURLException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }

                latitude = Double.parseDouble(event.getLocation().getLat());
                event.getTimeInterval().getStartdate().calculateSeason(latitude);
                if (event.getTimeInterval().getEnddate() != null) {
                    event.getTimeInterval().getEnddate().calculateSeason(latitude);
                }
            }
            int res = db.addEvent(event);
            System.out.println(event.getSource_url());
        }
        System.out.println("Sono stati aggiunti " + db.newEvents + " nuovi eventi.");
    }

    public void queryMediaMDs(String language, String type) {
        dbpedia = new Dbpedia();
        dbpedia.lookUpMediaMM(language, type);
        iter = dbpedia.mediaMDs.iterator();
        Media_Metadata mediaMD = null;
        double latitude;
        while (iter.hasNext()) {
            mediaMD = (Media_Metadata) (iter.next());
            int res = db.addWork(mediaMD);
            System.out.println(mediaMD.getSource_url());
        }
        System.out.println("Sono stati aggiunti " + db.newWorks + " nuovi lavori (libri, musica, film).");
    }

    public void askForPhotos(String fromTakenDate, String toTakenDate, String tag, String language) {

        flickr = new FlickrToURL();
        flickr.FlickrTag = tag;

        flickr.minTakenDate = fromTakenDate;
        flickr.maxTakenDate = toTakenDate;
        String searchResult = flickr.queryFlickr(null);
        flickr.parseJSON(searchResult);
        iter = flickr.photos.iterator();

        Media photo = null;
        while (iter.hasNext()) {
            photo = (Media) (iter.next());
            System.out.println(photo.dbformatTitle(photo.getCaption()));
            if (photo.getLocation().getLat().equals("0") && photo.getLocation().getLon().equals("0")) {
                try {

                    String out = coord.getJSONByGoogle(tag); // chiamata alle api di google maps
                    coord.parseGeoJSON(out, photo); // parsing del json proveniente dalle api di google maps
                    photo.getLocation().setCoordinates_trust(0);
                    photo.getLocation().setAccuracy(19);

                } catch (MalformedURLException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (!photo.getLocation().isGoogled()) {
                System.out.println("Provo con lat = " + photo.getLocation().getLat() + " e lon = " + photo.getLocation().getLon());
                searchResult = flickr.queryFlickr(photo.getFlickr_photo_id()); // chiamata alle api di flickr
                flickr.parseGeoJSON(searchResult, photo);// parsing del json proveniente dalle api di flickr
                photo.getLocation().setAccuracy(20);
                photo.getLocation().setCoordinates_trust(1);
            }
            int res = db.addMedia(photo);
            System.out.println(photo.getMedia_url());
        }
        System.out.println("Sono state aggiunte " + db.newMedia + " nuove foto.");

    }
}
