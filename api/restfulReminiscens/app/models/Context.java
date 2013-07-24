package models;

import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="Context")
public class Context extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2568314759877540078L;

	@Id
    @GeneratedValue
    @Column(name="context_id")
    private Long contextId;

	@Column
	private String title;
	
	@Column
	private String subtitle;
	
	@Column
	private Long personForId;
	
	@ManyToOne
	@MapsId
	@JoinColumn(name="city_for_id")
	private City cityFor;

	@Column(name="city_ratio")
	private Long cityRatio;

	@Column
	private DateTime date;

	@Column
	private Long dateRatio;
	
//
//    @ManyToMany
//    @JoinTable(name="Context_Content",
//        joinColumns=
//            @JoinColumn(name="context_id", referencedColumnName="context_id"),
//        inverseJoinColumns=
//            @JoinColumn(name="context_index_id", referencedColumnName="context_index_id")
//        )
//    public List<PublicMemento> publicMementoList;
	
	@JsonIgnore
	@OneToMany(mappedBy="context")
	private List<ContextContent> publicContextContent;

	
	public static Model.Finder<Long,Context> find = new Model.Finder<Long, Context>(
            Long.class,Context.class
    );
    
    public static List<Context> all(){
        return find.all();
    }
    
    public static void create(Context context){
        context.save();
    }
    
    public static Context createObject(Context context){
        context.save();
        return context;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static void update(Long id){
        find.ref(id).update();
    }

    public static Context findByPerson(Long personId) {
    	Context contextOfPerson = find.where()
				.eq("personForId", personId).findUnique();
		return contextOfPerson;
    }
    
    public static List<Context> findByCity(Long cityId) {
    	List<Context> contextsForCity = find.where()
				.eq("cityForId", cityId).findList();
		return contextsForCity;
    }

	public Long getContextId() {
		return contextId;
	}

	public void setContextId(Long contextId) {
		this.contextId = contextId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Long getPersonForId() {
		return personForId;
	}

	public void setPersonForId(Long personForId) {
		this.personForId = personForId;
	}

	public City getCityFor() {
		return cityFor;
	}

	public void setCityFor(City cityFor) {
		this.cityFor = cityFor;
	}

	public Long getCityRatio() {
		return cityRatio;
	}

	public void setCityRatio(Long cityRatio) {
		this.cityRatio = cityRatio;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public Long getDateRatio() {
		return dateRatio;
	}

	public void setDateRatio(Long dateRatio) {
		this.dateRatio = dateRatio;
	}

	public List<ContextContent> getPublicContextContent() {
		return publicContextContent;
	}

	public void setPublicContextContent(List<ContextContent> publicContextContent) {
		this.publicContextContent = publicContextContent;
	}
}
