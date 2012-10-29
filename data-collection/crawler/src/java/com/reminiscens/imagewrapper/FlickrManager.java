/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reminiscens.imagewrapper;

import com.reminiscens.coordinates.CoordSearcher;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 *
 * @author Nicola.Parrello
 */
public class FlickrManager {

    Database db;
    FlickrToURL downloader;
    CoordSearcher coord = new CoordSearcher();

    public static void main(String[] args) throws SQLException {

        FlickrManager manager = new FlickrManager();

        manager.downloader = new FlickrToURL();

        manager.db = new Database();

        try {
            if (manager.db.connessioneChiusa()) {
                System.out.println("Connessione chiusa");
            } else {
                System.out.println("Connessione aperta");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        manager.askForPhotos("trento");
        manager.askForPhotos("rovereto");
        manager.askForPhotos("pergine");

        manager.db.con.close();
    }

    public void askForPhotos(String tag) {

        downloader.FlickrTag = tag;

        for (int i = 1940; i < 2010; i = i + 10) { //REALE

            downloader.minTakenDate = i + "-01-01";
            downloader.maxTakenDate = (i + 9) + "-12-31";
            String searchResult = downloader.queryFlickr(null);
            downloader.parseJSON(searchResult);
            Iterator iter = downloader.photos.iterator();

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
                        Logger.getLogger(FlickrManager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(FlickrManager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FlickrManager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JSONException ex) {
                        Logger.getLogger(FlickrManager.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (!photo.getLocation().isGoogled()) {
                    System.out.println("Provo con lat = " + photo.getLocation().getLat() + " e lon = " + photo.getLocation().getLon());
                    searchResult = downloader.queryFlickr(photo.getFlickr_photo_id()); // chiamata alle api di flickr
                    downloader.parseGeoJSON(searchResult, photo);// parsing del json proveniente dalle api di flickr
                    photo.getLocation().setAccuracy(20);
                    photo.getLocation().setCoordinates_trust(1);
                }
                int res = db.addMedia(photo);
                System.out.println(photo.getMedia_url());
            }
        }
    }
}
