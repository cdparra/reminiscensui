package pojos;

import java.io.Serializable;

import org.joda.time.DateTime;


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
	private DateTime creation_date;
	private String locale;
	private LocationBean location;
	private QuestionBean question;
	private FuzzyDateBean startDate;
	private FuzzyDateBean endDate;

//	private List<MementoBean> mementoList;
//	private List<ParticipationBean> participationList;
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
	public DateTime getCreation_date() {
		return creation_date;
	}

	/**
	 * @param creation_date the creation_date to set
	 */
	public void setCreation_date(DateTime creation_date) {
		this.creation_date = creation_date;
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
}
