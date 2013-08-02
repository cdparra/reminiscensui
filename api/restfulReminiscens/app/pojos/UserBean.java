package pojos;


import java.io.Serializable;


import play.data.validation.Constraints.Required;

import com.avaje.ebean.validation.NotNull;

import enums.UserType;
import org.joda.time.DateTime;
import utils.JodaDateTime;

public class UserBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6810094935966434080L;

	public Long userId;
	
    @Required 
	@NotNull
    private String email;    
    private String username;
    private String profilePic;
    private String locale = "it_IT";
    private Boolean emailVerified = Boolean.FALSE;
    private Boolean usernameVerified = Boolean.FALSE;
//    private UserType confType =  UserType.TEST;
	private boolean active;
    @JodaDateTime(format="yyyy-MM-dd HH:mm:ss")
    private DateTime creationDate;    
    private String sessionKey;

//	@Required 
//	@NotNull
//	public Long personId;
    private PersonBean person;
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

//	/**
//	 * @return the personId
//	 */
//	public Long getPersonId() {
//		return personId;
//	}
//
//	/**
//	 * @param personId the personId to set
//	 */
//	public void setPersonId(Long personId) {
//		this.personId = personId;
//	}

	public String getCreationDateAsString() {
		return creationDate == null ? null : creationDate.toString("yyyy-MM-dd HH:mm:ss");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		if (locale == null) {
		    this.locale = "it_IT";
		} else {
			this.locale = locale;
		}
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public Boolean getUsernameVerified() {
		return usernameVerified;
	}

	public void setUsernameVerified(Boolean usernameVerified) {
		this.usernameVerified = usernameVerified;
	}

//	public UserType getConfType() {
//		return confType;
//	}
//
//	public void setConfType(UserType confType) {
//		this.confType = confType;
//	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public PersonBean getPerson() {
		return person;
	}

	public void setPerson(PersonBean person) {
		this.person = person;
	}

	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	    
}
