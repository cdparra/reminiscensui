package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.db.ebean.Model;

@Entity
@Table(name="Mentioned_Person")
public class MentionPerson extends Model{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8324336942908626934L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="mention_person_id")
    private Long mentionPersonId;
    
    @Column
    private String fullname;
 
    @Column
    private String relationship;
    
    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;
    
    @ManyToMany(mappedBy="participants")
    private List<Memento> memento;

    public static Model.Finder<Long, MentionPerson> find = new Finder<Long, MentionPerson>(
			Long.class, MentionPerson.class);
    
    
    public static List<MentionPerson> all(){
        return find.all();
    }
    
    public static void create(MentionPerson mentionPerson){
    	models.Person p = models.Person.searchByFullname(mentionPerson.getFullname());
    	if (p!=null) {
    		mentionPerson.setPerson(p);
    	}
        mentionPerson.save();
    }
    
    public static MentionPerson createObject(MentionPerson mentionPerson){
        mentionPerson.save();
        return mentionPerson;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static MentionPerson read(Long id){
        return find.byId(id);
    }
    
    public static MentionPerson readFirstByPersonId(Long personId){
    	List<MentionPerson> list = readByPersonId(personId);
    	return (list !=null && !list.isEmpty()) ? list.get(0) : null;
    }
    
    public static List<MentionPerson> readByPersonId(Long personId){
    	Person p = models.Person.read(personId);
    	if (p == null) {
    		return null;
    	} else {
    		List<MentionPerson> list = find.where().eq("person", p).findList();
    		return list;
    	}
    }
    
    public static MentionPerson fullSearchByAttributes(String fullname, String relationship) {
    	
    	ExpressionList<MentionPerson> el = find.where();
    	
    	if (fullname != null && fullname != "") {
    		el = el.eq("fullname", fullname);
    	}
    
    	if (relationship != null && relationship != "") {
    		el = el.eq("relationship", relationship);
    	}
    	MentionPerson result = el.findUnique();	
    	return result;
    }

    
	public Long getMentionPersonId() {
		return mentionPersonId;
	}

	public void setMentionPersonId(Long mentionPersonid) {
		this.mentionPersonId = mentionPersonid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person user) {
		this.person = user;
	}
}
