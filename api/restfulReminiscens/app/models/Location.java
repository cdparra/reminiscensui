package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
@Table(name="Location")
public class Location extends Model {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 775165124786881924L;

	@Id
    @GeneratedValue
    @Column(name="location_id")
    private Long locationId;
	
	@Column
	private String location_textual;
	
	@Column 
	private Integer accuracy;
	
	@Column
	private String name;
	
	@Column
	private String description;

	@Column
	private String environment;

	@Column
	private String continent;

	@Column
	private String country;

	@Column
	private String region;

	@Column
	private String city;

	@Column
	private String neighborhood;

	@Column
	private String street;

	@Column
	private String street_number;

	@Column
	private String map_url;
	
	@Column
	private Integer coordinates_trust;

	@Column
	private Double lat;
	
	@Column
	private Double lon;

	@Column
	private String locale;
	
	@Column
	private Long radius;
	

	public static Model.Finder<Long,Location> find = new Model.Finder<Long, Location>(
            Long.class,Location.class
    );
    
    public static List<Location> all(){
        return find.all();
    }
    
    public static void create(Location person){
        person.save();
    }
    
    public static Location createIfNotExist(Location location) {
		Long id = location.getLocationId();
		Location existing = null;
		if (id != null) {
			existing = read(id);
			if (existing != null) {
				return existing;
			}
		} 
		location.save();
		return location;
	}
    
    public static Location createObject(Location person){
        person.save();
        return person;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static Location read(Long id){
        return find.byId(id);
    }

	/**
	 * @return the locationId
	 */
	public Long getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	/**
	 * @return the location_textual
	 */
	public String getLocation_textual() {
		return location_textual;
	}

	/**
	 * @param location_textual the location_textual to set
	 */
	public void setLocation_textual(String location_textual) {
		this.location_textual = location_textual;
	}

	/**
	 * @return the accuracy
	 */
	public Integer getAccuracy() {
		return accuracy;
	}

	/**
	 * @param accuracy the accuracy to set
	 */
	public void setAccuracy(Integer accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	/**
	 * @return the continent
	 */
	public String getContinent() {
		return continent;
	}

	/**
	 * @param continent the continent to set
	 */
	public void setContinent(String continent) {
		this.continent = continent;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the neighborhood
	 */
	public String getNeighborhood() {
		return neighborhood;
	}

	/**
	 * @param neighborhood the neighborhood to set
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the street_number
	 */
	public String getStreet_number() {
		return street_number;
	}

	/**
	 * @param street_number the street_number to set
	 */
	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	/**
	 * @return the map_url
	 */
	public String getMap_url() {
		return map_url;
	}

	/**
	 * @param map_url the map_url to set
	 */
	public void setMap_url(String map_url) {
		this.map_url = map_url;
	}

	/**
	 * @return the coordinates_trust
	 */
	public Integer getCoordinates_trust() {
		return coordinates_trust;
	}

	/**
	 * @param coordinates_trust the coordinates_trust to set
	 */
	public void setCoordinates_trust(Integer coordinates_trust) {
		this.coordinates_trust = coordinates_trust;
	}

	
	/**
	 * @return the lat
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public Double getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(Double lon) {
		this.lon = lon;
	}

	/**
	 * @return the locate
	 */
	public String getLocate() {
		return locale;
	}

	/**
	 * @param locate the locate to set
	 */
	public void setLocate(String locate) {
		this.locale = locate;
	}

	/**
	 * @return the radius
	 */
	public Long getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(Long radius) {
		this.radius = radius;
	}

	
}
