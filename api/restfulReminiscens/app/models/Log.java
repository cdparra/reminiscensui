package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="log")
public class Log extends Model{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8324336942908626934L;

	@Id
    @GeneratedValue
    @Column(name="log_id")
    private Long id;
    
    @Column(length=300)
    private String action;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime time;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    //Getters & Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }
    
}
