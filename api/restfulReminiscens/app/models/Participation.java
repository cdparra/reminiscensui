package models;

import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import play.db.ebean.Model;

@Entity
@Table(name="Participant")
public class Participation extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9000709644175989610L;

	@Id
    @GeneratedValue
    @Column(name="participation_id")
    private Long participationId;

//    @Column(name="person_id")
////	@ManyToOne
////	@JoinColumn(name = "person_id", updatable = false, insertable = false)
//    private Long personId;
//	
//    @Column(name="life_event_id")
////	@ManyToOne
////	@JoinColumn(name = "life_event_id", updatable = false, insertable = false)
//	private Long lifeStoryId;
	
	@Column(name="focus")
	private boolean isProtagonist;

	@Column(name="contributor_id")
	private Long contributorId;
	
	//@PrimaryKeyJoinColumn(name="EMPLOYEEID", referencedColumnName="ID")
	  /* if this JPA model doesn't create a table for the "PROJ_EMP" entity,
	  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
	  *  @JoinColumn(name = "employeeId", updatable = false, insertable = false)
	  * or 
	  */


	@ManyToOne
	@JoinColumn(name = "person_id", updatable = true, insertable = true)
	private Person person;	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "life_event_id", updatable = true, insertable = true)
	private LifeStory lifeStory;	
	
	
	public static Model.Finder<Long,Participation> find = new Finder<Long, Participation>(
            Long.class,Participation.class
    );
    
    public static List<Participation> all(){
        return find.all();
    }
    
    public static void create(Participation participation){
        participation.save();
    }
    
    public static Participation createObject(Participation participation){
        participation.save();
        return participation;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static Participation read(Long id){
        return find.byId(id);
    }

	public static List<Participation> participationByPersonProtagonist(
			Long personId) {
		Person p = Person.read(personId);
		List<Participation> participationList = find.where()
				.eq("person", p).eq("isProtagonist", "1").findList();
		return participationList;
	}
	
	public static List<Participation> participationByPerson(
			Long personId) {		
		Person p = Person.read(personId);
		List<Participation> participationList = find.where()
				.eq("person", p).findList();
		return participationList;
	}
	
	// Check again
	public static List<Participation> participationByLifeStory(
			Long lifeStoryId) {		
		LifeStory ls = LifeStory.read(lifeStoryId);
		List<Participation> participationList = find.where()
				.eq("lifeStory", ls).findList();
		return participationList;
	}
	
	// Check again
	public static List<Participation> protagonistsOfLifeStory(
			Long lifeStoryId) {
			LifeStory ls = LifeStory.read(lifeStoryId);
		List<Participation> participationList = find.where()
				.eq("lifeStory", ls).eq("isProtagonist", "1").findList();
		return participationList;
	}

	/**
	 * @return the participationId
	 */
	public Long getParticipationId() {
		return participationId;
	}

	/**
	 * @param participationId the participationId to set
	 */
	public void setParticipationId(Long participationId) {
		this.participationId = participationId;
	}

//	/**
//	 * @return the personId
//	 */
//	public Long getPersonId() {
//		return personId;
//	}
//
//	/**
//	 * @param personId the personId to set
//	 */
//	public void setPersonId(Long personId) {
//		this.personId = personId;
//	}
//
//	/**
//	 * @return the lifeEventId
//	 */
//	public Long getLifeStoryId() {
//		return lifeStoryId;
//	}
//
//	/**
//	 * @param lifeEventId the lifeEventId to set
//	 */
//	public void setLifeStoryId(Long lifeEventId) {
//		this.lifeStoryId = lifeEventId;
//	}

	/**
	 * @return the isProtagonist
	 */
	public boolean isProtagonist() {
		return isProtagonist;
	}

	/**
	 * @param isProtagonist the isProtagonist to set
	 */
	public void setProtagonist(boolean isProtagonist) {
		this.isProtagonist = isProtagonist;
	}

	/**
	 * @return the contributor
	 */
	public Long getContributorId() {
		return contributorId;
	}

	/**
	 * @param contributor the contributor to set
	 */
	public void setContributorId(Long contributor) {
		this.contributorId = contributor;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the lifeStory
	 */
	public LifeStory getLifeStory() {
		return lifeStory;
	}

	/**
	 * @param lifeStory the lifeStory to set
	 */
	public void setLifeStory(LifeStory lifeStory) {
		this.lifeStory = lifeStory;
	}
}
