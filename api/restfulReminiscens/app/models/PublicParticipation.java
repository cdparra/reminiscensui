package models;

import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import play.db.ebean.Model;

@Entity
@Table(name="Public_Participant")
public class PublicParticipation extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9000709644175989610L;

    @Column(name="famous_id")
    private Long famousPersonId;
	
    @Column(name="context_index_id")
	private Long publicMementoId;
	
	//@PrimaryKeyJoinColumn(name="EMPLOYEEID", referencedColumnName="ID")
	  /* if this JPA model doesn't create a table for the "PROJ_EMP" entity,
	  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
	  *  @JoinColumn(name = "employeeId", updatable = false, insertable = false)
	  * or 
	  */
	@JsonIgnore	
	@ManyToOne
	@JoinColumn(name = "famous_id", updatable = false, insertable = false)
	private FamousPerson famousPerson;	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "context_index_id", updatable = false, insertable = false)
	private PublicMemento publicMemento;	
	

	public static Model.Finder<Long,PublicParticipation> find = new Finder<Long, PublicParticipation>(
            Long.class,PublicParticipation.class
    );
    
    public static List<PublicParticipation> all(){
        return find.all();
    }
    
    public static void create(PublicParticipation participation){
        participation.save();
    }
    
    public static PublicParticipation createObject(PublicParticipation participation){
        participation.save();
        return participation;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static PublicParticipation read(Long id){
        return find.byId(id);
    }
	
	public static List<PublicParticipation> participationByPerson(
			Long famousPersonId) {		
		List<PublicParticipation> participationList = find.where()
				.eq("famousPersonId", famousPersonId).findList();
		return participationList;
	}
	
	public static List<PublicParticipation> participationByPublicMemento(
			Long publicMementoId) {		
		List<PublicParticipation> participationList = find.where()
				.eq("publicMementoId", publicMementoId).findList();
		return participationList;
	}

	public Long getFamousPersonId() {
		return famousPersonId;
	}

	public void setFamousPersonId(Long famousPersonId) {
		this.famousPersonId = famousPersonId;
	}

	public Long getPublicMementoId() {
		return publicMementoId;
	}

	public void setPublicMementoId(Long publicMementoId) {
		this.publicMementoId = publicMementoId;
	}

	public FamousPerson getFamousPerson() {
		return famousPerson;
	}

	public void setFamousPerson(FamousPerson famousPerson) {
		this.famousPerson = famousPerson;
	}

	public PublicMemento getPublicMemento() {
		return publicMemento;
	}

	public void setPublicMemento(PublicMemento publicMemento) {
		this.publicMemento = publicMemento;
	}
}
