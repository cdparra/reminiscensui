package models;

import java.util.*;

import play.db.ebean.*;
import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="User")
public class User extends Model {
    /**
	 * 
	 */
	private static final long serialVersionUID = 822847283908287240L;

	@Id
    @GeneratedValue
    @Column(name="user_id")
    public Long userId;
 
    @Column(name="person_id")
    public Long personId;

    @OneToOne
    @MapsId
    @JoinColumn(name="person_id")
    private Person person;
    
    @Column(length=60)
    private String nickname;
    
    @Column(length=50)
    private String email;
    
    @Column(length=45)
    private String lang;
    
    @Column
    private Boolean email_verified;
    
    @Column
    private Boolean nickname_verified;

    @Column
    private String profile_pic;
    
    @Column
    private String cryptpass;

    @Column(name="conf_type")
    private String confType;
    
    @Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationDate;
    
    public static Model.Finder<Long,User> find = new Model.Finder<Long, User>(
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

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the personId
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * @return the email_verified
	 */
	public Boolean getEmail_verified() {
		return email_verified;
	}

	/**
	 * @param email_verified the email_verified to set
	 */
	public void setEmail_verified(Boolean email_verified) {
		this.email_verified = email_verified;
	}

	/**
	 * @return the nickname_verified
	 */
	public Boolean getNickname_verified() {
		return nickname_verified;
	}

	/**
	 * @param nickname_verified the nickname_verified to set
	 */
	public void setNickname_verified(Boolean nickname_verified) {
		this.nickname_verified = nickname_verified;
	}

	/**
	 * @return the profile_pic
	 */
	public String getProfile_pic() {
		return profile_pic;
	}

	/**
	 * @param profile_pic the profile_pic to set
	 */
	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}

	/**
	 * @return the cryptpass
	 */
	public String getCryptpass() {
		return cryptpass;
	}

	/**
	 * @param cryptpass the cryptpass to set
	 */
	public void setCryptpass(String cryptpass) {
		this.cryptpass = cryptpass;
	}

	/**
	 * @return the conf_type
	 */
	public String getConfType() {
		return confType;
	}

	/**
	 * @param conf_type the conf_type to set
	 */
	public void setConfType(String conf_type) {
		this.confType = conf_type;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}
    
}
