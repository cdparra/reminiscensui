/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reminiscens.imagewrapper;

/**
 *
 * @author Nicola.Parrello
 */
import com.reminiscens.fromdbpedia.Fuzzy_Date;
import com.reminiscens.fromdbpedia.Location;
import com.reminiscens.fromdbpedia.Time_Interval;
import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FlickrToURL {

    String FlickrSearchQuery_url;
    //String FlickrGetInfoQuery_url;
    String FlickrGetLocationQuery_url;
    String FlickrGetLocationQuery_id;
    //String FlickrGetInfoQuery_secret;
    String FlickrQuery_per_page;
    String FlickrExtraQuery;
    String FlickrExtraGeo;
    String FlickrExtraTags;
    String FlickrExtraTakenDate;
    String minTakenDate;
    String maxTakenDate;
    String FlickrTag;
    String seconds;
    String FlickrMin_Taken_Date;
    String FlickrMax_Taken_Date;
    String FlickrQuery_nojsoncallback;
    String FlickrQuery_format;
    String FlickrQuery_tag;
    String FlickrQuery_key;
    String FlickrApiKey;
    //String FlickrQuery_lat;
    //String FlickrQuery_lon;
    //String FlickrQuery_radius;
    String FlickrQuery_license;
    Collection<Media> photos;
    String qString;

    //public FlickrToURL (String FlickrQuery_url, String FlickrQuery_per_page, String FlickrQuery_nojsoncallback, String FlickrQuery_format, String FlickrQuery_tag, String FlickrQuery_key, String FlickrApiKey) {
    public FlickrToURL() {

        //this.FlickrQuery_url = FlickrQuery_url; //"http://api.flickr.com/services/rest/?method=flickr.photos.search";
        //this.FlickrQuery_per_page = FlickrQuery_per_page; //"&per_page=1";
        //this.FlickrQuery_nojsoncallback = FlickrQuery_nojsoncallback; //"&nojsoncallback=1";
        //this.FlickrQuery_format = FlickrQuery_format; //"&format=json";
        //this.FlickrQuery_tag = FlickrQuery_tag; //"&tags=";
        //this.FlickrQuery_key = FlickrQuery_key; //"&api_key=";

        FlickrSearchQuery_url = "http://api.flickr.com/services/rest/?method=flickr.photos.search";
        //FlickrGetInfoQuery_url = "http://api.flickr.com/services/rest/?method=flickr.photos.getInfo";
        FlickrGetLocationQuery_url = "http://api.flickr.com/services/rest/?method=flickr.photos.geo.getLocation";
        //FlickrSearchForLocQuery_url = "http://api.flickr.com/services/rest/?method=flickr.photos.geo.photosForLocation";

        FlickrGetLocationQuery_id = "&photo_id=";
        //FlickrGetInfoQuery_secret = "&secret=";
        FlickrQuery_per_page = "&per_page=30";
        //FlickrTag;
        seconds = "+00:00:00";
        FlickrExtraQuery = "&extras=";
        FlickrExtraGeo = "geo";
        FlickrExtraTags = "tags";
        FlickrExtraTakenDate = "date_taken";
        FlickrMin_Taken_Date = "&min_taken_date=";
        FlickrMax_Taken_Date = "&max_taken_date=";
        FlickrQuery_nojsoncallback = "&nojsoncallback=1";
        FlickrQuery_format = "&format=json";
        FlickrQuery_license = "&license=1%2C2%2C4%2C5%2C7"; //creative commons
        //FlickrQuery_lat = "&lat=40.661699";
        //FlickrQuery_lon = "&lon=-73.98947";
        //FlickrQuery_radius = "&radius=10";  //radius in km
        FlickrQuery_tag = "&tags=";
        FlickrQuery_key = "&api_key=";
        FlickrApiKey = "b70a9e175b81d1e4cd19fd652f0af12a";

        photos = new HashSet();
    }

    public String queryFlickr(String id) {

        if (id == null) {
            qString =
                    FlickrSearchQuery_url
                    + FlickrQuery_per_page
                    + FlickrQuery_nojsoncallback
                    + FlickrMin_Taken_Date + minTakenDate + seconds
                    + FlickrMax_Taken_Date + maxTakenDate + seconds
                    + FlickrExtraQuery + FlickrExtraGeo + "%2C" + FlickrExtraTags + "%2C" + FlickrExtraTakenDate
                    + FlickrQuery_format
                    + FlickrQuery_license
                    //+ FlickrQuery_lat
                    //+ FlickrQuery_lon
                    //+ FlickrQuery_radius
                    + FlickrQuery_tag + FlickrTag
                    + FlickrQuery_key + FlickrApiKey;
        } else {
            qString =
                    FlickrGetLocationQuery_url
                    + FlickrGetLocationQuery_id + id
                    + FlickrQuery_format + FlickrQuery_nojsoncallback
                    + FlickrQuery_key + FlickrApiKey;
        }

        String qResult = null;

        System.out.println(qString);

        HttpClient httpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(qString);

        try {

            HttpEntity httpEntity = httpClient.execute(httpGet).getEntity();

            if (httpEntity != null) {

                InputStream inputStream = httpEntity.getContent();
                Reader in = new InputStreamReader(inputStream);
                BufferedReader bufferedreader = new BufferedReader(in);
                StringBuilder stringBuilder = new StringBuilder();
                String stringReadLine = null;

                while ((stringReadLine = bufferedreader.readLine()) != null) {

                    stringBuilder.append(stringReadLine + "\n");
                }

                qResult = stringBuilder.toString();

            }

        } catch (ClientProtocolException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return qResult;

    }

    public void parseJSON(String json) {

        if (!photos.isEmpty()) {
            photos.clear();
        }

        String id = null;
        String owner = null;
        String secret = null;
        String server = null;
        String farm = null;
        String title = null;
        String date = null;
        String lat = "0";
        String lon = "0";
        //Double lat = null;
        //Double lon = null;
        String tags = "";

        try {

            JSONObject JsonObject = new JSONObject(json);

            JSONObject Json_photos = JsonObject.getJSONObject("photos");

            JSONArray JsonArray_photo = Json_photos.getJSONArray("photo");

            JSONObject FlickrPhoto = null;
            String url = null;
            Media photo = null;

            for (int i = 0; i < JsonArray_photo.length(); i++) {

                FlickrPhoto = JsonArray_photo.getJSONObject(i);

                id = FlickrPhoto.getString("id");
                owner = FlickrPhoto.getString("owner");
                secret = FlickrPhoto.getString("secret");
                server = FlickrPhoto.getString("server");
                farm = FlickrPhoto.getString("farm");
                title = FlickrPhoto.getString("title");
                lat = FlickrPhoto.getString("latitude");
                lon = FlickrPhoto.getString("longitude");
                tags = FlickrPhoto.getString("tags");
                date = FlickrPhoto.getString("datetaken");

                photo = new Media(id, owner, title, secret);
                photo.setMedia_url(farm, server, id, secret);
                photo.setLocale("ita");

                //date = Time_Interval.formatDate(date);
                Time_Interval time = new Time_Interval();
                Fuzzy_Date startdate = new Fuzzy_Date();

                startdate.splitDate(date);
                startdate.setAccuracy(11);
                startdate.setInterval(time);

                if (startdate.getHour() == startdate.getMinute()
                        && startdate.getMinute() == startdate.getSecond()
                        && startdate.getSecond() == "00") {
                    startdate.setHour(null);
                    startdate.setMinute(null);
                    startdate.setSecond(null);
                    startdate.setAccuracy(9);
                    time.setStart_date(null);
                } else {
                    time.setStart_date(date);
                }

                time.setStart_date(date);
                time.setIs_fuzzy(1);
                time.setPhoto(photo);

                time.setStartdate(startdate);
                photo.setTimeInterval(time);
                Location location = new Location();

                location.setLocale("ita");
                location.setLat(lat.toString());
                location.setLon(lon.toString());

                if (lat.equals("0") && lon.equals("0")) {
                    location.setTextual(FlickrTag);
                }

                photo.setLocation(location);
                location.setPhoto(photo);
                photos.add(photo);
            }

        } catch (JSONException e) {

            e.printStackTrace();

        }
    }

    public void parseGeoJSON(String json, Media photo) {

        String locality = null; // name
        String county = null; // city
        String region = null; // region
        String country = null; // country
        String accuracy = null;

        try {

            JSONObject JsonObject = new JSONObject(json);
            System.out.println(json);

            JSONObject Json_photo = JsonObject.getJSONObject("photo");

            JSONObject Json_photo_data = Json_photo.getJSONObject("location");
            JSONObject Json_locality = Json_photo_data.getJSONObject("locality");
            JSONObject Json_county = Json_photo_data.getJSONObject("county");
            JSONObject Json_region = Json_photo_data.getJSONObject("region");
            JSONObject Json_country = Json_photo_data.getJSONObject("country");

            accuracy = Json_photo_data.getString("accuracy");
            locality = Json_locality.getString("_content");
            county = Json_county.getString("_content");
            region = Json_region.getString("_content");
            country = Json_country.getString("_content");

            photo.getLocation().setCity(county);
            photo.getLocation().setCountry(country);
            photo.getLocation().setRegion(region);
            photo.getLocation().setName(locality);

        } catch (JSONException e) {

            e.printStackTrace();

        }
    }
}
