package models;

import java.util.List;

import javax.persistence.*;

import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="Contex_Index")
public class PublicMemento extends Model {

	@Id
    @GeneratedValue
    @Column(name="context_index_id")
    private Long publicMementoId;

	@Column
	private Long decade;
	
	@Column 
	private Long year;
	
	@Column 
	private Double distance;
	
	@ManyToOne
	@MapsId
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="event_id")
	private static Event event;

	@OneToOne
	@MapsId
	@JoinColumn(name="works_id")
	private static CreativeWork creativeWork;

	@OneToOne
	@MapsId
	@JoinColumn(name="media_id")
	private static Media media;

	@Column
	private Integer coordinates_trust;
	
	/** 
	 * attributes that are exposed through API
	 * 
	 */
	
	private Long contextMementoId;
	
	private String url;

	private String thumbnail_url;
	
	private List<FamousPerson> participants;

	private String headline;

	private String text;

	private String type;

	private String category;

	private String credit;

	private String credit_url;

	private Location location;
	
	private FuzzyDate startDate;

	private FuzzyDate endDate;
	
	public static Model.Finder<Long,PublicMemento> find = new Model.Finder(
            Long.class,PublicMemento.class
    );
    
    public static List<PublicMemento> all(){
        return find.all();
    }
//    
//    public static void create(PublicMemento publicMemento){
//        publicMemento.save();
//    }
    
//    public static PublicMemento createObject(PublicMemento publicMemento){
//        publicMemento.save();
//        return publicMemento;
//    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static PublicMemento read(Long id){ 

    	PublicMemento pm = find.byId(id);

    	
    	if (pm.event != null) {
        	/** @TODO copy event attributes */
        } else if (pm.creativeWork != null) {
        	/** @TODO copy event attributes */        	
        } else {
        	/** @TODO copy event attributes */        	
        }
    	
    	return pm;
    }

	/**
	 * @return the publicMementoId
	 */
	public Long getPublicMementoId() {
		return publicMementoId;
	}

	/**
	 * @param publicMementoId the publicMementoId to set
	 */
	public void setPublicMementoId(Long publicMementoId) {
		this.publicMementoId = publicMementoId;
	}

	/**
	 * @return the decade
	 */
	public Long getDecade() {
		return decade;
	}

	/**
	 * @param decade the decade to set
	 */
	public void setDecade(Long decade) {
		this.decade = decade;
	}

	/**
	 * @return the year
	 */
	public Long getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Long year) {
		this.year = year;
	}

	/**
	 * @return the distance
	 */
	public Double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Double distance) {
		this.distance = distance;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the coordinates_trust
	 */
	public Integer getCoordinates_trust() {
		return coordinates_trust;
	}

	/**
	 * @param coordinates_trust the coordinates_trust to set
	 */
	public void setCoordinates_trust(Integer coordinates_trust) {
		this.coordinates_trust = coordinates_trust;
	}

	/**
	 * @return the contextMementoId
	 */
	public Long getContextMementoId() {
		return contextMementoId;
	}

	/**
	 * @param contextMementoId the contextMementoId to set
	 */
	public void setContextMementoId(Long contextMementoId) {
		this.contextMementoId = contextMementoId;
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
	 * @return the participants
	 */
	public List<FamousPerson> getParticipants() {
		return participants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(List<FamousPerson> participants) {
		this.participants = participants;
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
