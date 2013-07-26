package pojos;


import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import enums.MementoType;


public class MementoBean  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3980159110846013300L;

    private Long mementoId;
    @JsonIgnore
	private LifeStoryBean lifeStory;
	private String headline;
	private String text;
	private String type;
	private String url;
	private String thumbnailUrl;
	private String category;
	private Boolean isCover;
	private Long position;
	private Boolean publicMemento;
	private LocationBean location;
	private FuzzyDateBean startDate;
	private List<MentionPersonBean> participants;

//	Fields in Database not exposed through API
//	private String source;
//	private String sourceUrl;
//	private FuzzyDateBean endDate;
//	private QuestionBean question;

	public Long getMementoId() {
		return mementoId;
	}
	public void setMementoId(Long mementoId) {
		this.mementoId = mementoId;
	}
	public LifeStoryBean getLifeStory() {
		return lifeStory;
	}
	public void setLifeStory(LifeStoryBean lifeStory) {
		this.lifeStory = lifeStory;
	}
	public Long getLifeStoryId() {
		return lifeStory.getLifeStoryId();
	}
	public void setLifeStoryId(Long lifeStoryId) {
		this.lifeStory = new LifeStoryBean();
		this.lifeStory.setLifeStoryId(lifeStoryId);
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
//	public String getSource() {
//		return source;
//	}
//	public void setSource(String source) {
//		this.source = source;
//	}
//	public String getSourceUrl() {
//		return sourceUrl;
//	}
//	public void setSourceUrl(String sourceUrl) {
//		this.sourceUrl = sourceUrl;
//	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Boolean getIsCover() {
		return isCover;
	}
	public void setIsCover(Boolean isCover) {
		this.isCover = isCover;
	}
	public Long getPosition() {
		return position;
	}
	public void setPosition(Long index) {
		this.position = index;
	}
	public Boolean getPublicMemento() {
		return publicMemento;
	}
	public void setPublicMemento(Boolean publicMemento) {
		this.publicMemento = publicMemento;
	}
	public LocationBean getLocation() {
		return location;
	}
	public void setLocation(LocationBean location) {
		this.location = location;
	}
	public FuzzyDateBean getStartDate() {
		return startDate;
	}
	public void setStartDate(FuzzyDateBean startDate) {
		this.startDate = startDate;
	}
//	public FuzzyDateBean getEndDate() {
//		return endDate;
//	}
//	public void setEndDate(FuzzyDateBean endDate) {
//		this.endDate = endDate;
//	}
//	public QuestionBean getQuestion() {
//		return question;
//	}
//	public void setQuestion(QuestionBean question) {
//		this.question = question;
//	}
	public List<MentionPersonBean> getParticipants() {
		return participants;
	}
	public void setParticipants(List<MentionPersonBean> participants) {
		this.participants = participants;
	}

}
