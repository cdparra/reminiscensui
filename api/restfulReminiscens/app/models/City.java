package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;
import utils.LocationUtilities;

@Entity
@Table(name="City")
public class City extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7427940699391709658L;

	@Id
    @GeneratedValue
    @Column(name="city_id")
    private Long cityId;
	
	@Column(name="city_name")
	private String name; 
	
	@Column
	private String region;
	
	@ManyToOne
	@MapsId
    @JoinColumn(name="country_id")
	private Country country;
	
	@Column
	private Double lat;
	
	@Column
	private Double lon;
	
	public static Model.Finder<Long,City> find = new Model.Finder<Long, City>(
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
    
    public static List<City> readByCountry(Long countryId){
        return find.where().eq("country.countryId", countryId).findList();
    }

    public static List<City> readByCountryName(String countryName){
        return find.where().eq("country.short_name", countryName).findList();
    }
    
    public static List<City> readNewById(Long lastCityId){
        return find.where().gt("cityId", lastCityId).findList();
    }
    
    public static List<City> findByName(String name){
    	@SuppressWarnings("unchecked")
		List<City> result = (List<City>) find.where()
    			.ilike("name", "%"+name+"%")
    			.findPagingList(25)
    			.getPage(1);
    	return result;
    }
    
    public static Double getDistance(Long city1, Long city2) {
    	City c1 = models.City.read(city1);
    	City c2 = models.City.read(city2);
    	
    	return LocationUtilities.distFrom(c1.getLat(), c1.getLon(), c2.getLat(), c2.getLon());
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
