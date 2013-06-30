package models;

import java.util.List;

import javax.persistence.*;

import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="Works")
public class CreativeWork extends Model {
	
	@Id
    @GeneratedValue
    @Column(name="work_id")
    private Long workId;
	
	/**
	 * @TODO
	 * Map other attributes
	 */

	public static Model.Finder<Long,CreativeWork> find = new Model.Finder(
            Long.class,CreativeWork.class
    );
    
    public static List<CreativeWork> all(){
        return find.all();
    }
    
    public static void create(CreativeWork creativeWork){
        creativeWork.save();
    }
    
    public static CreativeWork createObject(CreativeWork creativeWork){
        creativeWork.save();
        return creativeWork;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static CreativeWork read(Long id){
        return find.byId(id);
    }
	
}
