package models;

import java.util.List;

import javax.persistence.*;

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
    @Column(name="famous_person_id")
    private Long famousId;
	
	/**
	 * @TODO
	 * Map other attributes
	 */

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
	
}
