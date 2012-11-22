/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.reminiscens.crawler.entities;

import java.sql.Timestamp;

/**
 *
 * @author Nicola.Parrello
 */
public class Event {

    private int event_id;
    private String headline;
    private String type;
    private String text;
    private String source;
    private String source_url;
    private String locationName;
    private Timestamp last_update;
    private Location location;
    private Time_Interval timeInterval;
    private String locale;

    public Event(){}
    
    public Event(String source, String source_url, String headline, String startDate, String endDate, String location) {

        this.source_url = source_url;
        this.source = source;
        this.headline = headline;

    }

    public static String formatLocation(String locationUrl) {

        char[] charArray = locationUrl.toCharArray();

        for (int i = 0; i < locationUrl.length(); i++) {
            if ((charArray[i] == 'r') && (charArray[i + 1] == 'c') && (charArray[i + 2] == 'e')) {
                return locationUrl.substring(i + 4, locationUrl.length());
            }
        }

        return "Wrong location url";

    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Time_Interval getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(Time_Interval timeInterval) {
        this.timeInterval = timeInterval;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getEvent_id() {
        return event_id;
    }
    
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSource() {
        return source;
    }

    public String getSource_url() {
        return source_url;
    }

    public String getType() {
        return type;
    }

}
