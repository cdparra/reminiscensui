package models;

import java.util.*;

import play.db.ebean.*;
import providers.MyUsernamePasswordAuthUser;
import utils.PlayDozerMapper;

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
import com.feth.play.module.pa.user.NameIdentity;
import com.feth.play.module.pa.user.PicturedIdentity;

import enums.Roles;

@Entity
@Table(name = "User")
public class User extends Model implements Subject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 822847283908287240L;

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	public Long userId;

	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "person_id")
	private Person person;

	@Column(length = 60, name = "nickname")
	private String username;

	@Column(length = 50)
	private String email;

	@Column(length = 45, name = "lang")
	private String locale;

	@Column(name = "email_verified")
	private Boolean emailVerified;

	@Column(name = "nickname_verified")
	private Boolean usernameVerified;

	@Column(name = "profile_pic")
	private String profilePic;
	//
	// @Column
	// private String cryptpass;

	@Column(name = "conf_type")
	private String confType;

	@Temporal(TemporalType.DATE)
	@Column(name = "creation_date")
	// @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime creationDate;

	@Column
	private boolean active;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<LinkedAccount> linkedAccounts;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "User_Security_Roles", 
		joinColumns = { 
			@JoinColumn(name = "user_id", referencedColumnName = "user_id", updatable = true, insertable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "role_id", updatable = true, insertable = true) 
		})
	private List<SecurityRole> roles;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "User_User_Permission", 
	joinColumns = { 
		@JoinColumn(name = "user_id", referencedColumnName = "user_id", updatable = true, insertable = true) }, 
		inverseJoinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "permission_id", updatable = true, insertable = true) 
	})
	private List<UserPermission> permissions;

	public static Model.Finder<Long, User> find = new Model.Finder<Long, User>(
			Long.class, User.class);

	public static List<User> all() {
		return find.all();
	}

	public static void create(User user) {
		user.save();
	}

	public static User createObject(User user) {
		user.save();
		return user;
	}

	// Lazy delete, just making an user inactive
	public static void delete(Long id) {
		User u = find.ref(id);
		u.setActive(false);
		u.update();
	}

	public static User read(Long id) {
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
		/*
		 * 0. Zero step, create a new User instance
		 */
		User user = new User();

		/*
		 * 1. We start by already adding the role MEMBER and a LINKEDACCOUNT to
		 * the user instance to be created
		 */
		user.roles = Collections.singletonList(SecurityRole
				.findByRoleName(Roles.MEMBER.toString()));
		user.linkedAccounts = Collections.singletonList(LinkedAccount
				.create(authUser));
		user.active = true;
		Long userId = null;

		/*
		 * 2. Second, we will try to see if the email is sent and find if the
		 * user is already part of the system
		 */
		if (authUser instanceof EmailIdentity) {
			final EmailIdentity identity = (EmailIdentity) authUser;
			/*
			 * Remember, even when getting them from FB & Co., emails should be
			 * verified within the application as a security breach there might
			 * break your security as well!
			 */
			user.email = identity.getEmail();
			user.emailVerified = false;
			userId = User.getByEmail(identity.getEmail()) != null ? User
					.getByEmail(identity.getEmail()).getUserId() : null;

		}

		/*
		 * 3. Third, we create a new Person instance to associate to this user
		 */
		if (authUser instanceof MyUsernamePasswordAuthUser) {
			final MyUsernamePasswordAuthUser identity = (MyUsernamePasswordAuthUser) authUser;

			if (identity.getPerson() != null) {
				models.Person p = PlayDozerMapper.getInstance().map(
						identity.getPerson(), Person.class);
				user.setPerson(p);
			} else {
				user.setPerson(null);
			}
		}

		/*
		 * 4. If part of the signup form there is also a name, and the person bean does not have the name on it
		 *    add this name as Firstname
		 */
		if (authUser instanceof NameIdentity) {
			final NameIdentity identity = (NameIdentity) authUser;
			final String name = identity.getName();
			if (user.getPerson() != null && user.getPerson().getFirstname()==null) {
				user.getPerson().setFirstname(name);
			}
		}


		/*
		 * 5. If the picture URL is also set on the User form, add the picture to the user
		 */
		if (authUser instanceof PicturedIdentity) {
			final PicturedIdentity identity = (PicturedIdentity) authUser;
			final String picture = identity.getPicture();
			if (picture != null) {
				user.profilePic = picture;
			}
		}

//		if (authUser instanceof ExtendedIdentity) {
//			final ExtendedIdentity identity = (ExtendedIdentity) authUser;
//			if (identity.getFirstName() != null) {
//				person.setFirstname(identity.getFirstName());
//			}
//			person.setLastname(identity.getLastName());
//			if (identity.getGender() != null
//					&& !"".trim().equals(identity.getGender()))
//				person.setGender(identity.getGender().substring(0, 1));
//
//		}


		/*
		 * 6. always the email is going to be validated by google
		 */
		if (authUser instanceof GoogleAuthUser) {
			user.setEmailValidated(true);
		}


		/*
		 * 7. Generate the username
		 */
		
		user.setUsername(models.User.generateUsername(user.getEmail()));

		/*
		 * 8. Create the new user
		 */
		if (userId != null) {
			user.update(userId);
		} else {
			user.save();
		}

		return user;
	}

	private static String generateUsername(String email) {
		String newUsername = email.split("@")[0];
		int count = models.User.usernameExists(newUsername);
		if (count>0) {
			newUsername += (count++);
		}
		return newUsername;
	}

	private static int usernameExists(String newUsername) {
		return find.where().eq("active", true)
				.like("username","%"+newUsername+"%")
				.findList().size();
	}

	// TODO chek everything from here
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
	 * 
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
		// Model..em().getTransaction()
		User user = User.read(unverified.getUserId());
		user.setEmailValidated(true);
		user.save();
		// user.update(unverified.getId());
		TokenAction.deleteByUser(unverified, Type.EMAIL_VERIFICATION);
	}

	@Override
	public String getIdentifier() {
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
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person
	 *            the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the nickname
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param nickname
	 *            the nickname to set
	 */
	public void setUsername(String nickname) {
		this.username = nickname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the lang
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param lang
	 *            the lang to set
	 */
	public void setLocale(String lang) {
		this.locale = lang;
	}

	/**
	 * @return the email_verified
	 */
	public Boolean getEmailVerified() {
		return emailVerified;
	}

	/**
	 * @param email_verified
	 *            the email_verified to set
	 */
	public void setEmailVerified(Boolean email_verified) {
		this.emailVerified = email_verified;
	}

	/**
	 * @return the nickname_verified
	 */
	public Boolean getUsernameVerified() {
		return usernameVerified;
	}

	/**
	 * @param nickname_verified
	 *            the nickname_verified to set
	 */
	public void setUsernameVerified(Boolean nickname_verified) {
		this.usernameVerified = nickname_verified;
	}

	/**
	 * @return the profile_pic
	 */
	public String getProfilePic() {
		return profilePic;
	}

	/**
	 * @param profile_pic
	 *            the profile_pic to set
	 */
	public void setProfilePic(String profile_pic) {
		this.profilePic = profile_pic;
	}

	// /**
	// * @return the cryptpass
	// */
	// public String getCryptpass() {
	// return cryptpass;
	// }
	//
	// /**
	// * @param cryptpass the cryptpass to set
	// */
	// public void setCryptpass(String cryptpass) {
	// this.cryptpass = cryptpass;
	// }

	/**
	 * @return the conf_type
	 */
	public String getConfType() {
		return confType;
	}

	/**
	 * @param conf_type
	 *            the conf_type to set
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
		return this.emailVerified;
	}

	public void setEmailValidated(boolean emailValidated) {
		this.emailVerified = emailValidated;
	}

	public List<LinkedAccount> getLinkedAccounts() {
		return linkedAccounts;
	}

	public void setLinkedAccounts(List<LinkedAccount> linkedAccounts) {
		this.linkedAccounts = linkedAccounts;
	}

	// Auxiliary SETTERS and GETTERS

	/**
	 * @return the personId
	 */
	public Long getPersonId() {
		if (this.person != null) {
			return this.person.getPersonId();
		} else {
			return null;
		}

	}

	/**
	 * @param personId
	 *            the personId to set
	 */
	public void setPersonId(Long personId) {
		if (this.person == null) {
			this.person = new Person();
		}
		this.person.setPersonId(personId);
	}

	@Override
	public List<? extends Role> getRoles() {
		return roles;
	}

	public void addSecurityRole(SecurityRole role) {
		roles.add(role);
	}

	public void resetSecurityRole(SecurityRole role) {
		roles = Collections.singletonList(role);
	}

	@Override
	public List<? extends Permission> getPermissions() {
		return this.permissions;
	}

	public static void deleteForce(Long uid) {
		find.ref(uid).delete();
	}
}
