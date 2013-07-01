package models;

import java.util.List;

import javax.persistence.*;

import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="Media")
public class Media extends Model {
	
	@Id
    @GeneratedValue
    @Column(name="media_id")
    private Long mediaId;
	
	/**
	 * @TODO
	 * Map other attributes
	 */

	public static Model.Finder<Long,Media> find = new Model.Finder(
            Long.class,Media.class
    );
    
    public static List<Media> all(){
        return find.all();
    }
    
    public static void create(Media media){
        media.save();
    }
    
    public static Media createObject(Media media){
        media.save();
        return media;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static Media read(Long id){
        return find.byId(id);
    }
	
}
