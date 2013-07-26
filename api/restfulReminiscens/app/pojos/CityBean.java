package pojos;

import java.io.Serializable;

public class CityBean  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3980159110846013300L;

	private Long cityId;
	private String name; 
	private CountryBean country;
	private Double lat;
	private Double lon;

//	Fields in database not exposed through this API
//	private String region;

	
	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CountryBean getCountry() {
		return country;
	}

	public void setCountry(CountryBean country) {
		this.country = country;
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
	
//	public String getRegion() {
//		return region;
//	}
//
//	public void setRegion(String region) {
//		this.region = region;
//	}	
}
