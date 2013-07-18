package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
@Table(name="Famous_Person_Biography")
public class FamousPersonBio extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7758981950323371564L;

	@Id
    @GeneratedValue
    @Column(name="bio_id")
    private Long bioId;
	
	@Column
	private String bio;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="famous_id")
	private FamousPerson famousPerson;
	
	/**
	 * @TODO
	 * Map other attributes
	 */

	public static Model.Finder<Long,FamousPersonBio> find = new Finder<Long, FamousPersonBio>(
            Long.class,FamousPersonBio.class
    );
    
    public static List<FamousPersonBio> all(){
        return find.all();
    }
    
    public static void create(FamousPersonBio famousPerson){
        famousPerson.save();
    }
    
    public static FamousPersonBio createObject(FamousPersonBio famousPerson){
        famousPerson.save();
        return famousPerson;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static FamousPersonBio read(Long id){
        return find.byId(id);
    }

	public Long getBioId() {
		return bioId;
	}

	public void setBioId(Long bioId) {
		this.bioId = bioId;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public FamousPerson getFamousPerson() {
		return famousPerson;
	}

	public void setFamousPerson(FamousPerson famousPerson) {
		this.famousPerson = famousPerson;
	}

}
