package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
@Table(name="Session")
public class Session extends Model{
    
    @Id
    @GeneratedValue
    @Column(name="session_id")
    public Long id;
    
    public Integer status;
    
    @Column(name="start_timestamp")
    public Date startDate;
    
    @Column(name="expiration")
    public Date expiration;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    public User user;

    
    public static Model.Finder<Long,Session> find = new Model.Finder(
            Long.class,Session.class
    );
    
    public static List<Session> all(){
        return find.all();
    }
    
    public static List<Session> findByCourse(Long courseId) {
        return Session.find.where()
            .eq("course.id", courseId)
            .findList();
    }
    
    public static void create(Session session, Long courseId){
        session.user = User.find.ref(courseId);
        session.save();
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static Session read(Long id){
        return find.byId(id);
    }
    
}
