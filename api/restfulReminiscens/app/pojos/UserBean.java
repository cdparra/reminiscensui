package pojos;


import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;

import play.data.validation.Constraints.Required;

import com.avaje.ebean.validation.NotNull;

import enums.UserType;

import utils.JodaDateTime;

public class UserBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6810094935966434080L;

	public Long userId;
	
	@Required 
	@NotNull
	public Long personId;
    private PersonBean person;
    private String nickname;
    
    @Required 
	@NotNull
    private String email;
    private String lang = "it_IT";
    private Boolean email_verified = Boolean.FALSE;
    private Boolean nickname_verified = Boolean.FALSE;
    private String profile_pic;
    @JsonIgnore
    private String cryptpass;
    private UserType conf_type =  UserType.TEST;
    
    @JodaDateTime(format="yyyy-MM-dd HH:mm:ss")
    private DateTime creationDate;

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
	public PersonBean getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(PersonBean person) {
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
	public UserType getConfType() {
		return conf_type;
	}

	/**
	 * @param conf_type the conf_type to set
	 */
	public void setConfType(UserType conf_type) {
		this.conf_type = conf_type;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public String getCreationDateAsString() {
		return creationDate == null ? null : creationDate.toString("yyyy-MM-dd HH:mm:ss");
	}

	public void setCreationDate(DateTime creation_date) {
		this.creationDate = creation_date;
	}
    
}
