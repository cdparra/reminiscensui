package models;

import java.util.List;

import javax.persistence.*;

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
	
	/**
	 * @TODO
	 * Map other attributes
	 */


	private List<FamousPerson> participants;

	@Column
	private String headline;

	@Column
	private String text;

	@Column
	private String type;

	private String category="story";

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
    @JoinColumn(name="fuzzy_startdate")
	private FuzzyDate startDate;

	@ManyToOne
	@MapsId
    @JoinColumn(name="fuzzy_enddate")
	private FuzzyDate endDate;
	
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

	public List<FamousPerson> getParticipants() {
		return participants;
	}

	public void setParticipants(List<FamousPerson> participants) {
		this.participants = participants;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
