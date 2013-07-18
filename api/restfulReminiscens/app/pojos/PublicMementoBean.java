package pojos;


import java.io.Serializable;
import java.util.List;

public class PublicMementoBean  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3980159110846013300L;
   
	private Long publicMementoId;
	private Long decade;
	private Long year;
	private Double distance; 
	private Double category;
	private CityBean closestCity;
	private Integer coordinatesTrust;
	private static EventBean event;
	private static CreativeWorkBean creativeWork;
	private static MediaBean media;
	private List<PublicParticipationBean> publicParticipants;
	
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
	public CityBean getClosestCity() {
		return closestCity;
	}
	public void setClosestCity(CityBean closestCity) {
		this.closestCity = closestCity;
	}
	public Integer getCoordinatesTrust() {
		return coordinatesTrust;
	}
	public void setCoordinatesTrust(Integer coordinatesTrust) {
		this.coordinatesTrust = coordinatesTrust;
	}
	public static EventBean getEvent() {
		return event;
	}
	public static void setEvent(EventBean event) {
		PublicMementoBean.event = event;
	}
	public static CreativeWorkBean getCreativeWork() {
		return creativeWork;
	}
	public static void setCreativeWork(CreativeWorkBean creativeWork) {
		PublicMementoBean.creativeWork = creativeWork;
	}
	public static MediaBean getMedia() {
		return media;
	}
	public static void setMedia(MediaBean media) {
		PublicMementoBean.media = media;
	}
	public List<PublicParticipationBean> getPublicParticipants() {
		return publicParticipants;
	}
	public void setPublicParticipants(List<PublicParticipationBean> publicParticipants) {
		this.publicParticipants = publicParticipants;
	}
	
		
}
