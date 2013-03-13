/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdMemories;

import java.sql.Timestamp;

/**
 *
 * @author francesco
 */
public class Media implements java.io.Serializable {

    private String media_id;
    private String url;
    private String source;
    private String source_url;
    private String type;
    private String title;
    private Timestamp last_update;
    private Location location;
    private Fuzzy_date fuzzy_startdate;

    public Media() {
        source = "crowd";
        type = "photo";
    }

    public Fuzzy_date getFuzzy_startdate() {
        return fuzzy_startdate;
    }

    public void setFuzzy_startdate(Fuzzy_date fuzzy_startdate) {
        this.fuzzy_startdate = fuzzy_startdate;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location loc) {
        this.location = loc;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public void setUrl(String s) {
        url = s;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String s) {
        title = s;
    }

    public String getTitle() {
        return title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }
}