package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import org.codehaus.jackson.annotate.*;
import org.joda.time.DateTime;



@Entity
@Table(name="Person")
public class Person extends Model {

	@Id
    @GeneratedValue
    @Column(name="person_id")
    private Long personId;
	
	@Column
	private String fullname; 
	
	@Column
	private String firstname;

	@Column
	private String lastname;
	
	@Column 
	@Temporal(TemporalType.DATE)
	private DateTime birthdate;
	
	@OneToOne
	@MapsId
    @JoinColumn(name="birthdate_fuzzy_id")
	private FuzzyDate fuzzy_birthdate;

	@Column
	private DateTime deathdate;
	
	@OneToOne
	@MapsId
    @JoinColumn(name="deathdate_fuzzy_id")
	private FuzzyDate fuzzy_deathdate;
	
	@ManyToOne
	@MapsId
    @JoinColumn(name="birthplace_id")
	private City birthplace;

	@ManyToOne
	@MapsId
    @JoinColumn(name="nationality_country_id")
	private Country nation;
	
	@Column
	private String gender;
	
//	@OneToOne
//	@MapsId
//    @JoinColumn(name="famous_id")
//	private FamousPerson famous;
	
	@Column(name="famous_id")
	private Long famousId;

	@JsonIgnore
	@OneToMany(mappedBy="person")
	private List<Participation> participationList;
	
	
//	@ManyToMany
//	  @JoinTable(
//	      name="Participant",
//	      joinColumns={@JoinColumn(name="person_id", referencedColumnName="person_id")},
//	      inverseJoinColumns={@JoinColumn(name="life_event_id", referencedColumnName="life_event_id")})
	@JsonIgnore
	private List<LifeStory> lifeStories;
//		
	public static Model.Finder<Long,Person> find = new Model.Finder(
            Long.class,Person.class
    );
    
    public static List<Person> all(){
        return find.all();
    }
    
    public static void create(Person person){
        person.save();
    }
    
    public static Person createObject(Person person){
        person.save();
        return person;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static Person read(Long id){
        return find.byId(id);
    }
    
	/**
	 * @return the personId
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the birthdate
	 */
	public DateTime getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(DateTime birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the fuzzy_birthdate
	 */
	public FuzzyDate getFuzzy_birthdate() {
		return fuzzy_birthdate;
	}

	/**
	 * @param fuzzy_birthdate the fuzzy_birthdate to set
	 */
	public void setFuzzy_birthdate(FuzzyDate fuzzy_birthdate) {
		this.fuzzy_birthdate = fuzzy_birthdate;
	}

	/**
	 * @return the deathdate
	 */
	public DateTime getDeathdate() {
		return deathdate;
	}

	/**
	 * @param deathdate the deathdate to set
	 */
	public void setDeathdate(DateTime deathdate) {
		this.deathdate = deathdate;
	}

	/**
	 * @return the fuzzy_deathdate
	 */
	public FuzzyDate getFuzzy_deathdate() {
		return fuzzy_deathdate;
	}

	/**
	 * @param fuzzy_deathdate the fuzzy_deathdate to set
	 */
	public void setFuzzy_deathdate(FuzzyDate fuzzy_deathdate) {
		this.fuzzy_deathdate = fuzzy_deathdate;
	}

	/**
	 * @return the birthplace
	 */
	public City getBirthplace() {
		return birthplace;
	}

	/**
	 * @param birthplace the birthplace to set
	 */
	public void setBirthplace(City birthplace) {
		this.birthplace = birthplace;
	}

	/**
	 * @return the nation
	 */
	public Country getNation() {
		return nation;
	}

	/**
	 * @param nation the nation to set
	 */
	public void setNation(Country nation) {
		this.nation = nation;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the famous
	 */
//	public FamousPerson getFamous() {
//		return famous;
//	}

	/**
	 * @param famous the famous to set
	 */
//	public void setFamous(FamousPerson famous) {
//		this.famous = famous;
//	}

	/**
	 * @return the famousId
	 */
	public Long getFamousId() {
		return famousId;
	}

	/**
	 * @param isfamous the isfamous to set
	 */
	public void setFamousId(Long famousId) {
		this.famousId = famousId;
	}

	public List<Participation> getParticipationList() {
		return participationList;
	}

	public void setParticipationList(List<Participation> participationList) {
		this.participationList = participationList;
	}

	public List<LifeStory> getLifeStories() {
		return lifeStories;
	}

	public void setLifeStories(List<LifeStory> lifeStories) {
		this.lifeStories = lifeStories;
	}
	
	
}
