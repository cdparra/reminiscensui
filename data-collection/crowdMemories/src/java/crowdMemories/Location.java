/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdMemories;

/**
 *
 * @author francesco
 */
public class Location implements java.io.Serializable {

    private String location_id;
    private String location_textual;
    private String address;
    private String latitude;
    private String longitude;
    private String radius;
    private Boolean has_marker;
    private Boolean has_circle;
    private Boolean has_description_loc;
    private Boolean has_location;
    private Media media;

    public Location() {
        has_marker = false;
        has_circle = false;
        has_description_loc = false;
        has_location = false;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getLocation_textual() {
        return location_textual;
    }

    public void setLocation_textual(String location_textual) {
        this.location_textual = location_textual;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public Boolean getHas_marker() {
        return has_marker;
    }

    public void setHas_marker(Boolean has_marker) {
        this.has_marker = has_marker;
    }

    public Boolean getHas_circle() {
        return has_circle;
    }

    public void setHas_circle(Boolean has_circle) {
        this.has_circle = has_circle;
    }

    public Boolean getHas_description_loc() {
        return has_description_loc;
    }

    public void setHas_description_loc(Boolean has_description_loc) {
        this.has_description_loc = has_description_loc;
    }

    public void clear_point_on_map() {
        address = null;
        latitude = null;
        longitude = null;
        radius = null;
    }

    public void clear_location_textual() {
        location_textual = null;
    }

    public Boolean getHas_location() {
        return has_location;
    }

    public void setHas_location(Boolean has_location) {
        this.has_location = has_location;
    }
    
}
