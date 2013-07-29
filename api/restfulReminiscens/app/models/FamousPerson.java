package models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="Famous_Person")
public class FamousPerson extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7758981950323371564L;

	@Id
    @GeneratedValue
    @Column(name="famous_id")
    private Long famousId;
	
	@Column
	private String fullname;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column(name="famous_for")
	private String famousFor;

	@Column
	private String source;

	@Column(name="source_url")
	private String sourceUrl;

	@Column
	private String locale;

	@Column(name="picture_url")
	private String resourceUrl;

	@Column
	private String status;

	@Column
	private String tags;

	@Column(name="creator_type")
	private String creatorType;

	@Temporal(TemporalType.DATE)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="creation_date")
	private DateTime creationDate;

	@Temporal(TemporalType.DATE)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="last_update")
	private DateTime lastUpdate;

	@Column
	private boolean indexed;
	
	@ManyToOne
	@MapsId
    @JoinColumn(name="birthdate_fuzzy_id")
	private FuzzyDate birthDate;

	@ManyToOne
	@MapsId
    @JoinColumn(name="deathdate_fuzzy_id")
	private FuzzyDate deathDate;
	
	@ManyToOne
	@MapsId
    @JoinColumn(name="birthplace_id")
	private Location birhplace;
	
	@ManyToOne
	@MapsId
    @JoinColumn(name="deathplace_id")
	private Location deathplace;
	
	@ManyToOne
	@MapsId
    @JoinColumn(name="nationality_country_id")
	private Country country;
	
	
	public static Model.Finder<Long,FamousPerson> find = new Finder<Long, FamousPerson>(
            Long.class,FamousPerson.class
    );
    
    public static List<FamousPerson> all(){
        return find.all();
    }
    
    public static void create(FamousPerson famousPerson){
        famousPerson.save();
    }
    
    public static FamousPerson createObject(FamousPerson famousPerson){
        famousPerson.save();
        return famousPerson;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static FamousPerson read(Long id){
        return find.byId(id);
    }

	public Long getFamousId() {
		return famousId;
	}

	public void setFamousId(Long famousId) {
		this.famousId = famousId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFamousFor() {
		return famousFor;
	}

	public void setFamousFor(String famousFor) {
		this.famousFor = famousFor;
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

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String pictureUrl) {
		this.resourceUrl = pictureUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatorType() {
		return creatorType;
	}

	public void setCreatorType(String creatorType) {
		this.creatorType = creatorType;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(DateTime dateAdded) {
		this.creationDate = dateAdded;
	}

	public DateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(DateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public boolean isIndexed() {
		return indexed;
	}

	public void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}

	public FuzzyDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(FuzzyDate birthDate) {
		this.birthDate = birthDate;
	}

	public FuzzyDate getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(FuzzyDate deathDate) {
		this.deathDate = deathDate;
	}

	public Location getBirhplace() {
		return birhplace;
	}

	public void setBirhplace(Location birhplace) {
		this.birhplace = birhplace;
	}

	public Location getDeathplace() {
		return deathplace;
	}

	public void setDeathplace(Location deathplace) {
		this.deathplace = deathplace;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
}
