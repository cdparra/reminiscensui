package pojos;

import java.io.Serializable;
import java.util.List;

import org.joda.time.DateTime;

import utils.JodaDateTime;


public class LifeStoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -962352695398206053L;

    private Long lifeStoryId;
	private String headline;
	private String text;
	private String richtext;
	private String type;
	private Integer visibility;
	private Long contributorId;
	@JodaDateTime(format = "yyyy-MM-dd HH:mm:ss")
	private DateTime creationDate;
	private String locale;
	private LocationBean location;
	private QuestionBean question;
	private FuzzyDateBean startDate;
	private FuzzyDateBean endDate;
	private boolean synced = true;
	private List<ParticipationBean> participationList;
	private List<MementoBean> mementoList;
	
//	
//	private List<PersonBean> participants;
	
	/**
	 * @return the lifeStoryId
	 */
	public Long getLifeStoryId() {
		return lifeStoryId;
	}

	/**
	 * @param lifeStoryId the lifeStoryId to set
	 */
	public void setLifeStoryId(Long lifeStoryId) {
		this.lifeStoryId = lifeStoryId;
	}

	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return headline;
	}

	/**
	 * @param headline the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the richtext
	 */
	public String getRichtext() {
		return richtext;
	}

	/**
	 * @param richtext the richtext to set
	 */
	public void setRichtext(String richtext) {
		this.richtext = richtext;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the visibility
	 */
	public Integer getVisibility() {
		return visibility;
	}

	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

	/**
	 * @return the contributorId
	 */
	public Long getContributorId() {
		return contributorId;
	}

	/**
	 * @param contributorId the contributorId to set
	 */
	public void setContributorId(Long contributorId) {
		this.contributorId = contributorId;
	}

	/**
	 * @return the creation_date
	 */
	public DateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creation_date the creation_date to set
	 */
	public void setCreationDate(DateTime creation_date) {
		this.creationDate = creation_date;
	}

	public String getCreationDateAsString () {
		return creationDate == null ? null : creationDate.toString("yyyy-MM-dd HH:mm:ss");
	}
	
	
	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}


	/**
	 * @return the startDate
	 */
	public FuzzyDateBean getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(FuzzyDateBean startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public FuzzyDateBean getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(FuzzyDateBean endDate) {
		this.endDate = endDate;
	}

	public LocationBean getLocation() {
		return location;
	}

	public void setLocation(LocationBean location) {
		this.location = location;
	}

	public QuestionBean getQuestion() {
		return question;
	}

	public void setQuestion(QuestionBean question) {
		this.question = question;
	}

	public boolean isSynced() {
		return synced;
	}

	public void setSynced(boolean synced) {
		this.synced = synced;
	}

	public List<ParticipationBean> getParticipationList() {
		return participationList;
	}

	public void setParticipationList(List<ParticipationBean> participationList) {
		this.participationList = participationList;
	}

	public List<MementoBean> getMementoList() {
		return mementoList;
	}

	public void setMementoList(List<MementoBean> mementoList) {
		this.mementoList = mementoList;
	}
}
