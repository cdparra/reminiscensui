package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
@Table(name="Country")
public class Country extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8279916434556075304L;

	@Id
    @GeneratedValue
    @Column(name="country_id")
    private Long countryId;	

	@Column
	private String short_name;
	
	@Column
	private String long_name; 

	@Column
	private String iso2;

	@Column
	private String iso3;
	
	@Column
	private String numcode;

	@Column(name="un_member")
	private String un_member;
	
	@Column
	private String calling_code;
	
	@Column
	private String cctld;
	
	@Column
	private String spanish_name;

	@Column
	private String italian_name;
	
	public static Model.Finder<Long,Country> find = new Model.Finder<Long, Country>(
            Long.class,Country.class
    );
    
    public static List<Country> all(){
        return find.all();
    }
    
    public static void create(Country country){
        country.save();
    }
    
    public static Country createObject(Country country){
        country.save();
        return country;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static Country read(Long id){
        return find.byId(id);
    }

	/**
	 * @return the countryId
	 */
	public Long getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the short_name
	 */
	public String getShort_name() {
		return short_name;
	}

	/**
	 * @param short_name the short_name to set
	 */
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	/**
	 * @return the long_name
	 */
	public String getLong_name() {
		return long_name;
	}

	/**
	 * @param long_name the long_name to set
	 */
	public void setLong_name(String long_name) {
		this.long_name = long_name;
	}

	/**
	 * @return the iso2
	 */
	public String getIso2() {
		return iso2;
	}

	/**
	 * @param iso2 the iso2 to set
	 */
	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	/**
	 * @return the iso3
	 */
	public String getIso3() {
		return iso3;
	}

	/**
	 * @param iso3 the iso3 to set
	 */
	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	/**
	 * @return the numcode
	 */
	public String getNumcode() {
		return numcode;
	}

	/**
	 * @param numcode the numcode to set
	 */
	public void setNumcode(String numcode) {
		this.numcode = numcode;
	}

	/**
	 * @return the un_member
	 */
	public String getUn_member() {
		return un_member;
	}

	/**
	 * @param un_member the un_member to set
	 */
	public void setUn_member(String un_member) {
		this.un_member = un_member;
	}

	/**
	 * @return the calling_code
	 */
	public String getCalling_code() {
		return calling_code;
	}

	/**
	 * @param calling_code the calling_code to set
	 */
	public void setCalling_code(String calling_code) {
		this.calling_code = calling_code;
	}

	/**
	 * @return the cctld
	 */
	public String getCctld() {
		return cctld;
	}

	/**
	 * @param cctld the cctld to set
	 */
	public void setCctld(String cctld) {
		this.cctld = cctld;
	}

	/**
	 * @return the spanish_name
	 */
	public String getSpanish_name() {
		return spanish_name;
	}

	/**
	 * @param spanish_name the spanish_name to set
	 */
	public void setSpanish_name(String spanish_name) {
		this.spanish_name = spanish_name;
	}
	
}
