package models;

import java.util.*;

import play.db.ebean.*;

import javax.persistence.*;

//import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import models.TokenAction.Type;

import be.objectify.deadbolt.core.models.Permission;
import be.objectify.deadbolt.core.models.Role;
import be.objectify.deadbolt.core.models.Subject;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.feth.play.module.pa.providers.oauth2.google.GoogleAuthUser;
import com.feth.play.module.pa.providers.password.UsernamePasswordAuthUser;
import com.feth.play.module.pa.user.AuthUser;
import com.feth.play.module.pa.user.AuthUserIdentity;
import com.feth.play.module.pa.user.EmailIdentity;
import com.feth.play.module.pa.user.ExtendedIdentity;
import com.feth.play.module.pa.user.NameIdentity;
import com.feth.play.module.pa.user.PicturedIdentity;

import enums.Roles;

@Entity
@Table(name="User")
public class User extends Model implements Subject {
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
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationDate;
    
    @Column
	private boolean active;

	@OneToMany(cascade = CascadeType.ALL)
	private List<LinkedAccount> linkedAccounts;
	
	@ManyToMany
	private List<SecurityRole> roles;
    
	@ManyToMany
	private List<UserPermission> permissions;
	
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

	public static User getByEmail(String email) {
		return find.where().eq("email", email).findUnique();
	}

    /* AUTHENTICATION AND AUTHORIZATION */
    
    
	public static boolean existsByAuthUserIdentity(
			final AuthUserIdentity identity) {
		final ExpressionList<User> exp = getAuthUserFind(identity);
		return exp.findRowCount() > 0;
	}

	private static ExpressionList<User> getAuthUserFind(
			final AuthUserIdentity identity) {
		return find.where().eq("active", true)
				.eq("linkedAccounts.providerUserId", identity.getId())
				.eq("linkedAccounts.providerKey", identity.getProvider());
	}

	public static User findByAuthUserIdentity(final AuthUserIdentity identity) {
		if (identity == null) {
			return null;
		}
		if (identity instanceof UsernamePasswordAuthUser) {
			return findByUsernamePasswordIdentity((UsernamePasswordAuthUser) identity);
		} else {
			return getAuthUserFind(identity).findUnique();
		}
	}

	public void merge(final User otherUser) {
		for (final LinkedAccount acc : otherUser.linkedAccounts) {
			this.linkedAccounts.add(LinkedAccount.create(acc));
		}
		// do all other merging stuff here - like resources, etc.

		// deactivate the merged user that got added to this one
		otherUser.active = false;
		Ebean.save(Arrays.asList(new User[] { otherUser, this }));
	}

	public static User create(final AuthUser authUser) {
		User user = new User();
		user.roles = Collections.singletonList(SecurityRole
				.findByRoleName(Roles.MEMBER.toString()));
		
		user.active = true;
		user.linkedAccounts = Collections.singletonList(LinkedAccount
				.create(authUser));
		
		Long userId = null;
		//first we will try to see if the email is sent and find if the user was already part of the system
		if (authUser instanceof EmailIdentity) {
			final EmailIdentity identity = (EmailIdentity) authUser;
			// Remember, even when getting them from FB & Co., emails should be
			// verified within the application as a security breach there might
			// break your security as well!
			user.email = identity.getEmail();
			user.email_verified = false;
			
			userId = User.getByEmail(identity.getEmail())!= null ? User.getByEmail(identity.getEmail()).getUserId():null;
			
		}

		
		Person person = new Person();

		if (authUser instanceof NameIdentity) {
			final NameIdentity identity = (NameIdentity) authUser;
			final String name = identity.getName();
			if (name != null) {
				person.setFirstname(name);
			}
		}
		
		if (authUser instanceof PicturedIdentity) {
			final PicturedIdentity identity = (PicturedIdentity) authUser;
			final String picture = identity.getPicture();
			if (picture != null) {
				user.profile_pic = picture;
			}
		}
		
		if (authUser instanceof ExtendedIdentity) {
			final ExtendedIdentity identity = (ExtendedIdentity) authUser;
			if (identity.getFirstName() != null) {
				person.setFirstname(identity.getFirstName());
			}
			person.setLastname(identity.getLastName());
			if(identity.getGender() != null && !"".trim().equals(identity.getGender()))
			person.setGender(identity.getGender().substring(0,1));

		}
		
		/** 
		 * TODO
		 * - ADD BIRTHDATE AND BIRTHPLACE TO THE AUTHUSERIDENTITY
		 * - CHECK IF THE PERSON RECORD ALREADY EXIST AND ASSOCIATE WITH IT
		 * - CREATE THE CITY OF BIRTH
		 */
		
		//always the email is going to be validated by google
		if (authUser instanceof GoogleAuthUser) {
			user.setEmailValidated(true);
		}
		
		user.setPerson(person);
		
		if(userId != null){
			user.update(userId);
		}else{
			user.save();
		}
		
		return user;
	}

	public static void merge(final AuthUser oldUser, final AuthUser newUser) {
		User.findByAuthUserIdentity(oldUser).merge(
				User.findByAuthUserIdentity(newUser));
	}

	public Set<String> getProviders() {
		final Set<String> providerKeys = new HashSet<String>(
				linkedAccounts.size());
		for (final LinkedAccount acc : linkedAccounts) {
			providerKeys.add(acc.getProviderKey());
		}
		return providerKeys;
	}

	public static void addLinkedAccount(final AuthUser oldUser,
			final AuthUser newUser) {
		final User u = User.findByAuthUserIdentity(oldUser);
		u.linkedAccounts.add(LinkedAccount.create(newUser));
		u.save();
	}

	/**
	 * used by authentication, it will return only active users
	 * @param email
	 * @return the active user
	 */
	public static User findByEmail(final String email) {
		return getEmailUserFind(email).findUnique();
	}

	private static ExpressionList<User> getEmailUserFind(final String email) {
		return find.where().eq("active", true).eq("email", email);
	}

	public LinkedAccount getAccountByProvider(final String providerKey) {
		return LinkedAccount.findByProviderKey(this, providerKey);
	}
	
	public static User findByUsernamePasswordIdentity(
			final UsernamePasswordAuthUser identity) {
		return getUsernamePasswordAuthUserFind(identity).findUnique();
	}
	
	private static ExpressionList<User> getUsernamePasswordAuthUserFind(
			final UsernamePasswordAuthUser identity) {
		return getEmailUserFind(identity.getEmail()).eq(
				"linkedAccounts.providerKey", identity.getProvider());
	}
	
	public void resetPassword(final UsernamePasswordAuthUser authUser,
			final boolean create) {
		// You might want to wrap this into a transaction
		this.changePassword(authUser, create);
		TokenAction.deleteByUser(this, Type.PASSWORD_RESET);
	}
	
	public void changePassword(final UsernamePasswordAuthUser authUser,
			final boolean create) {
		LinkedAccount a = this.getAccountByProvider(authUser.getProvider());
		if (a == null) {
			if (create) {
				a = LinkedAccount.create(authUser);
				a.setUser(this);
			} else {
				throw new RuntimeException(
						"Account not enabled for password usage");
			}
		}
		a.setProviderUserId(authUser.getHashedPassword());
		a.save();
	}
	
	@Transactional
	public static void verify(final User unverified) {
		// You might want to wrap this into a transaction
//		Model..em().getTransaction()
		User user = User.read(unverified.getUserId());
		user.setEmailValidated(true);
		user.save();
//		user.update(unverified.getId());
		TokenAction.deleteByUser(unverified, Type.EMAIL_VERIFICATION);
	}

	@Override
	public String getIdentifier()
	{
		return Long.toString(userId);
	}

    
    
    /* GETTERS AND SETTERS */
    
    
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

	public boolean isEmailValidated() {
		return this.email_verified;
	}

	public void setEmailValidated(boolean emailValidated) {
		this.email_verified= emailValidated;
	}

	public List<LinkedAccount> getLinkedAccounts() {
		return linkedAccounts;
	}

	public void setLinkedAccounts(List<LinkedAccount> linkedAccounts) {
		this.linkedAccounts = linkedAccounts;
	}

	@Override
	public List<? extends Role> getRoles() {
		return roles;
	}
	
	public void addSecurityRole(SecurityRole role){
		roles.add(role);
	}
	
	public void resetSecurityRole(SecurityRole role){
		roles = Collections.singletonList(role);
	}

	@Override
	public List<? extends Permission> getPermissions() {
		return this.permissions;
	}

    
}
