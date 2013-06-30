package models;

import java.util.List;

import javax.persistence.*;

import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="Context")
public class Context extends Model {
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

	@Column
	private Long city_ratio;

	@Column
	private DateTime date;

	@Column
	private Long date_ratio;
	

    @ManyToMany
    @JoinTable(name="Context_Content",
        joinColumns=
            @JoinColumn(name="context_id", referencedColumnName="context_id"),
        inverseJoinColumns=
            @JoinColumn(name="context_index_id", referencedColumnName="context_index_id")
        )
    public List<PublicMemento> publicMementoList;
	
	
	public static Model.Finder<Long,LifeStory> find = new Model.Finder(
            Long.class,LifeStory.class
    );
    
    public static List<LifeStory> all(){
        return find.all();
    }
    
    public static void create(LifeStory lifestory){
        lifestory.save();
    }
    
    public static LifeStory createObject(LifeStory lifestory){
        lifestory.save();
        return lifestory;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
	
}
