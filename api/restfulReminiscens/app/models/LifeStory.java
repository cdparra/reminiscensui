package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="Life_Event")
public class LifeStory extends Model {

	@Id
    @GeneratedValue
    @Column(name="life_event_id")
    private Long lifeStoryId;
	
	@Required
	@Column
	private String headline;

	@Column
	private String text;
	
	@Column
	private String richtext;

	@Column
	private String type;

	@Column
	private Integer visibility;
	
	@Column(name="contributor_id")
	private Long contributorId;

	@Column
	private DateTime creation_date;
	
	@Column
	private String locale;
	
	@ManyToOne
	@MapsId
    @JoinColumn(name="location_id")
	private Location location;

	@ManyToOne
	@MapsId
	@JoinColumn(name="question_id")
	private Question question;
	
	@ManyToOne
	@MapsId
    @JoinColumn(name="fuzzy_startdate")
	private FuzzyDate startDate;

	@ManyToOne
	@MapsId
    @JoinColumn(name="fuzzy_enddate")
	private FuzzyDate endDate;

	@OneToMany(mappedBy="lifeStory")
	private List<Memento> mementoList;

	@JsonIgnore
	@OneToMany(mappedBy="lifeStory")
	private List<Participation> participationList;
	
	private List<Person> participants;

	public static Model.Finder<Long,LifeStory> find = new Model.Finder(
            Long.class,LifeStory.class
    );
    
    public static List<LifeStory> all(){
        return find.all();
    }
    
    public static void create(LifeStory lifestory){
        lifestory.save();
    }
    
    public static LifeStory createObject(LifeStory lifestory){
        lifestory.save();
        return lifestory;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static LifeStory read(Long id){
        return find.byId(id);
    }

    public static List<LifeStory> readByPerson(Long personId){
    	List<Participation> participationList = Participation.participationByPersonProtagonist(personId);
    	List<LifeStory> lifeStories = new ArrayList<LifeStory> ();
    	for (Participation participation : participationList) {
//			LifeStory ls = LifeStory.read(participation.getLifeStoryId());
    		LifeStory ls = participation.getLifeStory();
			lifeStories.add(ls);
		}
    	return lifeStories;
    }
    
	public List<Memento> getMementoList() {
		return mementoList;
	}

	public void setMementoList(List<Memento> mementoList) {
		this.mementoList = mementoList;
	}


	
	
	/**
	 * @return the lifeStoryId
	 */
	public Long getLifeStoryId() {
		return lifeStoryId;
	}

	/**
	 * @param lifeStoryId the lifeStoryId to set
	 */
	public void setLifeStoryId(Long lifeStoryId) {
		this.lifeStoryId = lifeStoryId;
	}

	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return headline;
	}

	/**
	 * @param headline the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the richtext
	 */
	public String getRichtext() {
		return richtext;
	}

	/**
	 * @param richtext the richtext to set
	 */
	public void setRichtext(String richtext) {
		this.richtext = richtext;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the visibility
	 */
	public Integer getVisibility() {
		return visibility;
	}

	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

	/**
	 * @return the contributorId
	 */
	public Long getContributorId() {
		return contributorId;
	}

	/**
	 * @param contributorId the contributorId to set
	 */
	public void setContributorId(Long contributorId) {
		this.contributorId = contributorId;
	}

	/**
	 * @return the creation_date
	 */
	public DateTime getCreation_date() {
		return creation_date;
	}

	/**
	 * @param creation_date the creation_date to set
	 */
	public void setCreation_date(DateTime creation_date) {
		this.creation_date = creation_date;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return the startDate
	 */
	public FuzzyDate getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(FuzzyDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public FuzzyDate getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(FuzzyDate endDate) {
		this.endDate = endDate;
	}
}
