package models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="Event")
public class Event extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5320571988438886312L;

	@Id
    @GeneratedValue
    @Column(name="event_id")
    private Long eventId;

	@Column
	private String headline;

	@Column
	private String text;

	@Column(name = "event_type")
	private String type;

	@Column
	private String source;

	@Column(name = "source_url")
	private String sourceUrl;

	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "last_update")
	private DateTime lastUpdate;

	@Column
	private String locale;

	@ManyToOne
	@MapsId
    @JoinColumn(name="location_id")
	private Location location;

	@ManyToOne
	@MapsId
    @JoinColumn(name="fuzzy_startdate")
	private FuzzyDate startDate;

	@ManyToOne
	@MapsId
    @JoinColumn(name="fuzzy_enddate")
	private FuzzyDate endDate;

	@Column
	private String tags;

	@Column
	private boolean indexed;	
	
	public static Model.Finder<Long,Event> find = new Model.Finder<Long, Event>(
            Long.class,Event.class
    );
    
    public static List<Event> all(){
        return find.all();
    }
    
    public static void create(Event event){
        event.save();
    }
    
    public static Event createObject(Event event){
        event.save();
        return event;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static Event read(Long id){
        return find.byId(id);
    }

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public DateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(DateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public FuzzyDate getStartDate() {
		return startDate;
	}

	public void setStartDate(FuzzyDate startDate) {
		this.startDate = startDate;
	}

	public FuzzyDate getEndDate() {
		return endDate;
	}

	public void setEndDate(FuzzyDate endDate) {
		this.endDate = endDate;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public boolean isIndexed() {
		return indexed;
	}

	public void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}
}
