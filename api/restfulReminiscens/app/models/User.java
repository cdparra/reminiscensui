package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
@Table(name="vsg_user")
public class User extends Model {
    
    @Id
    @GeneratedValue
    @Column(name="user_id")
    public Long id;
    
    @Column(length=50, name="user_email")
    public String email;
    
    
    public static Model.Finder<Long,User> find = new Model.Finder(
            Long.class,User.class
    );
    
    public static List<User> all(){
        return find.all();
    }
    
    public static void create(User user){
        user.save();
    }
    
    public static User createObject(User user){
        user.save();
        return user;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static User read(Long id){
        return find.byId(id);
    }
    
}
