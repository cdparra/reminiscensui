package models;

import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="Memento")
public class Memento extends Model {

	@Id
    @GeneratedValue
    @Column(name="memento_id")
    private Long mementoId;
	

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="life_event_id")
	private LifeStory lifeStory;
	
	@Column(name="life_event_id")
	private Long lifeStoryId;
	
	@Column
	private String url;

	@Column
	private String thumbnail_url;
	
	@Column
	private String type;

	@Column
	private String category;

	@Column(name="is_cover")
	private Boolean isCover;

	@Column
	private Integer index;

	@Column
	private String headline;

	@Column
	private String text;

	@Column
	private Boolean public_memento;

	@Column
	private String credit;

	@Column
	private String credit_url;

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

	public static Model.Finder<Long,Memento> find = new Model.Finder(
            Long.class,Memento.class
    );
    
    public static List<Memento> all(){
        return find.all();
    }
    
    public static void create(Memento memento){
        memento.save();
    }
    
    public static Memento createObject(Memento memento){
        memento.save();
        return memento;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static Memento read(Long id){
        return find.byId(id);
    }

	/**
	 * @return the mementoId
	 */
	public Long getMementoId() {
		return mementoId;
	}

	/**
	 * @param mementoId the mementoId to set
	 */
	public void setMementoId(Long mementoId) {
		this.mementoId = mementoId;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the thumbnail_url
	 */
	public String getThumbnail_url() {
		return thumbnail_url;
	}

	/**
	 * @param thumbnail_url the thumbnail_url to set
	 */
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
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
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the isCover
	 */
	public Boolean getIsCover() {
		return isCover;
	}

	/**
	 * @param isCover the isCover to set
	 */
	public void setIsCover(Boolean isCover) {
		this.isCover = isCover;
	}

	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
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
	 * @return the public_memento
	 */
	public Boolean getPublic_memento() {
		return public_memento;
	}

	/**
	 * @param public_memento the public_memento to set
	 */
	public void setPublic_memento(Boolean public_memento) {
		this.public_memento = public_memento;
	}

	/**
	 * @return the credit
	 */
	public String getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(String credit) {
		this.credit = credit;
	}

	/**
	 * @return the credit_url
	 */
	public String getCredit_url() {
		return credit_url;
	}

	/**
	 * @param credit_url the credit_url to set
	 */
	public void setCredit_url(String credit_url) {
		this.credit_url = credit_url;
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

	public LifeStory getLifeStory() {
		return lifeStory;
	}

	public void setLifeStory(LifeStory lifeStory) {
		this.lifeStory = lifeStory;
	}
	
}
