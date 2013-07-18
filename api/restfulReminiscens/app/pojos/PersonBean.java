package pojos;


import java.io.Serializable;
import utils.JodaDateTime;
import play.data.validation.Constraints.*;

import org.joda.time.DateTime;

import com.avaje.ebean.validation.NotNull;

public class PersonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1821474864754424620L;
	
	private Long personId;	
	@Required 
	@NotNull
	private String firstname;	
	@Required
	@NotNull
	private String lastname;

	@JodaDateTime(format = "yyyy-MM-dd HH:mm:ss")
	private DateTime birthdate;

	@JodaDateTime(format = "yyyy-MM-dd HH:mm:ss")
	private DateTime deathdate;
	
	private String gender;
	private CityBean birthplace;
	private FamousPersonBean famous;
	private Long famousId;
	
	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public DateTime getBirthdate() {
		return birthdate;
	}
	
	public String getBirthdateAsString() {
		return birthdate != null ? birthdate.toString("yyyy-MM-dd HH:mm:ss") : null;
	}

	public void setBirthdate(DateTime birthdate) {
		this.birthdate = birthdate;
	}

	public DateTime getDeathdate() {
		return deathdate;
	}

	public String getDeathdateAsString() {
		return deathdate != null ? deathdate.toString("yyyy-MM-dd HH:mm:ss") : null;
	}
	
	public void setDeathdate(DateTime deathdate) {
		this.deathdate = deathdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public CityBean getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(CityBean birthplace) {
		this.birthplace = birthplace;
	}

	public Long getFamousId() {
		return famousId;
	}

	public void setFamousId(Long famousId) {
		this.famousId = famousId;
	}

	public FamousPersonBean getFamous() {
		return famous;
	}

	public void setFamous(FamousPersonBean famous) {
		this.famous = famous;
	}		
}
