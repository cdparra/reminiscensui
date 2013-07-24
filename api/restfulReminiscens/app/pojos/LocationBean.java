package pojos;

import java.io.Serializable;

public class LocationBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 134847973176532044L;
	
	private Long locationId;
	private String location_textual; 
	private Integer accuracy;
	private String name;
	private String description;
	private String environment;
	private String continent;
	private String country;
	private String region;
	private String city;
	private String neighborhood;
	private String street;
	private String street_number;
	private String map_url;
	private Integer coordinates_trust;
	private Double lat;
	private Double lon;
	private String locale;
	private Long radius;
	
	
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	public String getLocation_textual() {
		return location_textual;
	}
	public void setLocation_textual(String location_textual) {
		this.location_textual = location_textual;
	}
	public Integer getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Integer accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreet_number() {
		return street_number;
	}
	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}
	public String getMap_url() {
		return map_url;
	}
	public void setMap_url(String map_url) {
		this.map_url = map_url;
	}
	public Integer getCoordinates_trust() {
		return coordinates_trust;
	}
	public void setCoordinates_trust(Integer coordinates_trust) {
		this.coordinates_trust = coordinates_trust;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public Long getRadius() {
		return radius;
	}
	public void setRadius(Long radius) {
		this.radius = radius;
	}
	
	
}
