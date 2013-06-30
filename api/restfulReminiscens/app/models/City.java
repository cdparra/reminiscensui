package models;

import java.util.List;

import javax.persistence.*;

import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="City")
public class City extends Model {

	@Id
    @GeneratedValue
    @Column(name="person_id")
    private Long cityId;
	
	@Column
	private String name; 
	
	@Column
	private String region;

	@Column(name="country")
	private String countryName;
	
	@ManyToOne
	@MapsId
    @JoinColumn(name="country_id")
	private Country country;
	
	@Column
	private Double lat;
	
	@Column
	private Double lon;
	
	public static Model.Finder<Long,City> find = new Model.Finder(
            Long.class,City.class
    );
    
    public static List<City> all(){
        return find.all();
    }
    
    public static void create(City city){
        city.save();
    }
    
    public static City createObject(City city){
        city.save();
        return city;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static City read(Long id){
        return find.byId(id);
    }

	/**
	 * @return the cityId
	 */
	public Long getCityId() {
		return cityId;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
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
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
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
	
	
}
