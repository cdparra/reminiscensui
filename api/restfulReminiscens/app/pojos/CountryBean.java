package pojos;

import java.io.Serializable;

public class CountryBean  implements Serializable {

	private static final long serialVersionUID = -7405860737685958872L;

	private Long countryId;	

	private String short_name;
	
	private String long_name; 

	private String iso2;

	private String iso3;
	
	private String numcode;

	private String un_member;
	
	private String calling_code;
	
	private String cctld;
	
	private String spanish_name;

	private String italian_name;

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getLong_name() {
		return long_name;
	}

	public void setLong_name(String long_name) {
		this.long_name = long_name;
	}

	public String getIso2() {
		return iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getNumcode() {
		return numcode;
	}

	public void setNumcode(String numcode) {
		this.numcode = numcode;
	}

	public String getUn_member() {
		return un_member;
	}

	public void setUn_member(String un_member) {
		this.un_member = un_member;
	}

	public String getCalling_code() {
		return calling_code;
	}

	public void setCalling_code(String calling_code) {
		this.calling_code = calling_code;
	}

	public String getCctld() {
		return cctld;
	}

	public void setCctld(String cctld) {
		this.cctld = cctld;
	}

	public String getSpanish_name() {
		return spanish_name;
	}

	public void setSpanish_name(String spanish_name) {
		this.spanish_name = spanish_name;
	}

	public String getItalian_name() {
		return italian_name;
	}

	public void setItalian_name(String italian_name) {
		this.italian_name = italian_name;
	}
	
	/** 
	 * TODO 
	 * @Column
	 * private String italian_name;
	 */
	
	
}
