package models;

import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;
import org.codehaus.jackson.annotate.*;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.avaje.ebean.ExpressionList;

@Entity
@Table(name="Person")
public class Person extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7045811975198960968L;

	@Id
    @GeneratedValue
    @Column(name="person_id")
    private Long personId;	

	@Required
	@Column
	private String firstname;

	@Required
	@Column
	private String lastname;
	
	@Temporal(TemporalType.DATE)
	@Column 
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime birthdate;

	@Temporal(TemporalType.DATE)
	@Column
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime deathdate;
	
	@Column
	private String gender;

	@ManyToOne
	@MapsId
    @JoinColumn(name="birthplace_id")
	private City birthplace;
	
	@OneToOne
	@MapsId
    @JoinColumn(name="famous_id")
	private FamousPerson famous;
	
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
//	@JsonIgnore
//	private List<LifeStory> lifeStories;
//		
	public static Model.Finder<Long,Person> find = new Model.Finder<Long, Person>(
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
    

    public static Person searchByFullname(String fullname){
    	ExpressionList<Person> el = find.where();
    	el.raw("CONCAT(firstname,' ',lastname) = ?",fullname);
        return el.findUnique();
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
}
