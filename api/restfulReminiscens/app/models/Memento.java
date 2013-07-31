package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import play.db.ebean.Model;

@Entity
@Table(name = "Memento")
public class Memento extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8995430233086145999L;

	@Id
	@GeneratedValue
	@Column(name = "memento_id")
	private Long mementoId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "life_event_id")
	private LifeStory lifeStory;

	@Column
	private String headline;

	@Column
	private String text;

	@Column
	private String type;

	@Column(name = "credit")
	private String source;

	@Column(name = "credit_url")
	private String sourceUrl;

	@Column
	private String url;

	@Column(name = "thumbnail_url")
	private String thumbnailUrl;

	@Column
	private String category;

	@Column(name = "is_cover")
	private Boolean isCover;

	@Column
	private Long position;

	@Column(name = "public_memento")
	private Boolean publicMemento;

	@ManyToOne
	@MapsId
	@JoinColumn(name = "location_id")
	private Location location;

	@ManyToOne
	@MapsId
	@JoinColumn(name = "fuzzy_startdate")
	private FuzzyDate startDate;

	@ManyToOne
	@MapsId
	@JoinColumn(name = "fuzzy_enddate")
	private FuzzyDate endDate;

	@ManyToOne
	@MapsId
	@JoinColumn(name = "question_id")
	private Question question;

	// @OneToMany(mappedBy="memento")
	// private List<MementoParticipation> participantList;

	@ManyToMany
	@JoinTable(name = "Participant_Memento", 
		joinColumns = { 
			@JoinColumn(name = "memento_id", referencedColumnName = "memento_id", updatable = true, insertable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "mention_person_id", referencedColumnName = "mention_person_id", updatable = true, insertable = true) 
		})
	private List<MentionPerson> participants;

	public static Model.Finder<Long, Memento> find = new Model.Finder<Long, Memento>(
			Long.class, Memento.class);

	public static List<Memento> all() {
		return find.all();
	}

	// TODO Improve efficiency of this process by improving mapping so that 
	// MentionPerson.mentionPersonId generates automatically
	public static void create(Memento memento) {
		List<MentionPerson> participantList = memento.getParticipants();
		List<MentionPerson> newParticipantList = new ArrayList<MentionPerson>();

		if (participantList != null && !participantList.isEmpty()) {			
			for (MentionPerson mentionPerson : participantList) {
				Long mentionPersonId = mentionPerson.getMentionPersonId();
				if (mentionPersonId != null) {
					MentionPerson mp = models.MentionPerson
							.read(mentionPersonId);
					if (mp == null) {
						models.MentionPerson.create(mentionPerson);
					} else {
						mentionPerson = mp;
					}	
				} else {
					MentionPerson mp = models.MentionPerson
							.searchByFullname(
									mentionPerson.getFullname());
					
					if (mp == null) {
						models.MentionPerson.create(mentionPerson);
					} else {
						mentionPerson = mp;
					}
				}

				newParticipantList.add(mentionPerson);
			}
		}
		memento.setParticipants(newParticipantList);
		memento.save();
	}

	public static Memento createObject(Memento memento) {
		memento.save();
		return memento;
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static Memento read(Long id) {
		return find.byId(id);
	}

	public static List<Memento> getAllStoryMementoByPersonId(Long personId) {
		List<Participation> participationList = models.Participation
				.participationByPersonProtagonist(personId);
		List<Memento> mementoList = new ArrayList<Memento>();

		for (Participation part : participationList) {
			List<Memento> partialList = part.getLifeStory().getMementoList();
			mementoList.addAll(partialList);
		}
		return mementoList;
	}

	public static List<Memento> getAllMentionMementoByPersonId(Long personId) {
		List<MementoParticipation> participationList = models.MementoParticipation
				.readByPerson(personId);
		List<Memento> mementoList = new ArrayList<Memento>();

		for (MementoParticipation part : participationList) {
			Memento memento = part.getMemento();
			mementoList.add(memento);
		}
		return mementoList;
	}

	public Long getMementoId() {
		return mementoId;
	}

	public void setMementoId(Long mementoId) {
		this.mementoId = mementoId;
	}

	public LifeStory getLifeStory() {
		return lifeStory;
	}

	public void setLifeStory(LifeStory lifeStory) {
		this.lifeStory = lifeStory;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getIsCover() {
		return isCover;
	}

	public void setIsCover(Boolean isCover) {
		this.isCover = isCover;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long index) {
		this.position = index;
	}

	public Boolean getPublicMemento() {
		return publicMemento;
	}

	public void setPublicMemento(Boolean publicMemento) {
		this.publicMemento = publicMemento;
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<MentionPerson> getParticipants() {
		return participants;
	}

	public void setParticipants(List<MentionPerson> participants) {
		this.participants = participants;
	}

}
