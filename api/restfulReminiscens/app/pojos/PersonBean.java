package pojos;


import java.io.Serializable;
import utils.JodaDateTime;

import org.joda.time.DateTime;

public class PersonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1821474864754424620L;
	
	private Long personId;	
	private String firstname;
	private String lastname;

	@JodaDateTime(format = "yyyy-MM-dd HH:mm:ss")
	private DateTime birthdate;

	@JodaDateTime(format = "yyyy-MM-dd HH:mm:ss")
	private DateTime deathdate;
	
	private String gender;
	private CityBean birthplace;
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
		return birthdate != null ? birthdate.toString("yyyy-mm-dd HH:mm:ss") : null;
	}

	public void setBirthdate(DateTime birthdate) {
		this.birthdate = birthdate;
	}

	public DateTime getDeathdate() {
		return deathdate;
	}

	public String getDeathdateAsString() {
		return deathdate != null ? deathdate.toString("yyyy-mm-dd HH:mm:ss") : null;
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

//	public List<ParticipationBean> getParticipationList() {
//		return participationList;
//	}
	
//	@OneToOne
//	@MapsId
//    @JoinColumn(name="deathdate_fuzzy_id")
//	private FuzzyDate fuzzy_deathdate;
//	
//	@ManyToOne
//	@MapsId
//    @JoinColumn(name="birthplace_id")
//	private City birthplace;
//
//	@ManyToOne
//	@MapsId
//    @JoinColumn(name="nationality_country_id")
//	private Country nation;
	
//	private String gender;
	
//	@OneToOne
//	@MapsId
//    @JoinColumn(name="famous_id")
//	private FamousPerson famous;
	
//	private Long famousId;

//	@JsonIgnore
//	@OneToMany(mappedBy="person")
//	private List<Participation> participationList;
	
	
//	@ManyToMany
//	  @JoinTable(
//	      name="Participant",
//	      joinColumns={@JoinColumn(name="person_id", referencedColumnName="person_id")},
//	      inverseJoinColumns={@JoinColumn(name="life_event_id", referencedColumnName="life_event_id")})
//	@JsonIgnore
//	private List<LifeStory> lifeStories;
//		

		
}
