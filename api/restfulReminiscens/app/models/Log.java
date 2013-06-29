package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
@Table(name="log")
public class Log extends Model{
    
    @Id
    @GeneratedValue
    public Long id;
    
    @Column(length=300)
    public String action;
    
    public Date time;
    
    @ManyToOne
    @JoinColumn(name="userid")
    public User user;
}
