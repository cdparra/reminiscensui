package models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name = "Media")
public class Media extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5265991469293010222L;


	@Id
	@GeneratedValue
	@Column(name = "media_id")
	private Long mediaId;

	@Column(name = "media_url")
	private String resourceUrl;

	@Column(name = "media_type")
	private String type;

	@Column
	private String headline;

	@Column
	private String text;

	@Column
	private String source;

	@Column(name = "source_url")
	private String sourceUrl;

	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "last_update")
	private DateTime lastUpdate;

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

	@Column
	private String locale;

	@Column
	private String tags;

	@Column
	private boolean indexed;

	public static Model.Finder<Long, Media> find = new Model.Finder<Long, Media>(
			Long.class, Media.class);

	public static List<Media> all() {
		return find.all();
	}

	public static void create(Media media) {
		media.save();
	}

	public static Media createObject(Media media) {
		media.save();
		return media;
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static Media read(Long id) {
		return find.byId(id);
	}

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String mediaUrl) {
		this.resourceUrl = mediaUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String mediaType) {
		this.type = mediaType;
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

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
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
