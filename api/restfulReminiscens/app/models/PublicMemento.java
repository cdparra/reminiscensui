package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import play.db.ebean.Model;

@Entity
@Table(name="Contex_Index")
public class PublicMemento extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2021927948308276540L;

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

	@Column 
	private Double category;
	
	@ManyToOne
	@MapsId
	@JoinColumn(name="city_id")
	private City closestCity;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="event_id")
	private static Event event;

	@OneToOne
	@MapsId
	@JoinColumn(name="work_id")
	private static CreativeWork creativeWork;

	@OneToOne
	@MapsId
	@JoinColumn(name="media_id")
	private static Media media;

	@Column
	private Integer coordinatesTrust;
	
	@JsonIgnore
	@OneToMany(mappedBy="publicMemento")
	private List<PublicParticipation> publicParticipants;
	
	public static Model.Finder<Long,PublicMemento> find = new Model.Finder<Long, PublicMemento>(
            Long.class,PublicMemento.class
    );
    
    public static List<PublicMemento> all(){
        return find.all();
    }
    
    public static PublicMemento read(Long id){ 
    	PublicMemento pm = find.byId(id);    	
    	return pm;
    }	
    
    public static List<PublicMemento> readByDecade(Long decade){ 
    	List<PublicMemento> pmList = find.where()
				.eq("decade", decade).findList();;    	
    	return pmList;
    }	
    

    public static List<PublicMemento> readByDecadeAndCityId(Long decade, Long cityId){ 
    	List<PublicMemento> pmList = find.where()
				.eq("decade", decade).eq("cityId",cityId).findList();    	
    	return pmList;
    }
    
    public static List<PublicMemento> readByDecadeAndCityIdWithRadius(Long decade, Long cityId,Long radius){ 
    	List<PublicMemento> pmList = find.where()
				.eq("decade", decade).findList();    	
    	
    	List<PublicMemento> finalList = new ArrayList<PublicMemento>();
    	
    	for (PublicMemento publicMemento : pmList) {
    		City closestCity = publicMemento.getClosestCity();
    		Double distance = models.City.getDistance(closestCity.getCityId(), cityId);
			
    		if (distance < radius) {
    			finalList.add(publicMemento);
    		}
		}
    	
    	return finalList;
    }

	public Long getPublicMementoId() {
		return publicMementoId;
	}

	public void setPublicMementoId(Long publicMementoId) {
		this.publicMementoId = publicMementoId;
	}

	public Long getDecade() {
		return decade;
	}

	public void setDecade(Long decade) {
		this.decade = decade;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getCategory() {
		return category;
	}

	public void setCategory(Double category) {
		this.category = category;
	}

	public City getClosestCity() {
		return closestCity;
	}

	public void setClosestCity(City city) {
		this.closestCity = city;
	}

	public static Event getEvent() {
		return event;
	}

	public static void setEvent(Event event) {
		PublicMemento.event = event;
	}

	public static CreativeWork getCreativeWork() {
		return creativeWork;
	}

	public static void setCreativeWork(CreativeWork creativeWork) {
		PublicMemento.creativeWork = creativeWork;
	}

	public static Media getMedia() {
		return media;
	}

	public static void setMedia(Media media) {
		PublicMemento.media = media;
	}

	public Integer getCoordinatesTrust() {
		return coordinatesTrust;
	}

	public void setCoordinatesTrust(Integer coordinates_trust) {
		this.coordinatesTrust = coordinates_trust;
	}

	public List<PublicParticipation> getFamousParticipants() {
		return publicParticipants;
	}

	public void setFamousParticipants(List<PublicParticipation> participants) {
		this.publicParticipants = participants;
	}	

    
}
