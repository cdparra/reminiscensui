package pojos;


import java.io.Serializable;

import org.joda.time.DateTime;

import utils.JodaDateTime;

public class CreativeWorkBean  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3980159110846013300L;

	private Long workId;

	// Knowledge Base Resources common attributes
	private String headline;
	private String text;	
	private String type;
	private String source;
	private String sourceUrl;
	private String resourceUrl;
	private String locale;
	private String tags;
	private boolean indexed;	
	private FuzzyDateBean startDate;
	@JodaDateTime(format = "yyyy-MM-dd HH:mm:ss")
	private DateTime lastUpdate;

	// Knowledge Base Creative Work Resources specific attributes
	private String author;
	private CountryBean authorCountry;
	private String collection;
	
	public Long getWorkId() {
		return workId;
	}
	public void setWorkId(Long workId) {
		this.workId = workId;
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSourceUrl() {
		return sourceUrl;
	}
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	public String getResourceUrl() {
		return resourceUrl;
	}
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public boolean isIndexed() {
		return indexed;
	}
	public void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}
	public FuzzyDateBean getStartDate() {
		return startDate;
	}
	public void setStartDate(FuzzyDateBean startDate) {
		this.startDate = startDate;
	}
	public DateTime getLastUpdate() {
		return lastUpdate;
	}
	public String getLastUpdateAsString () {
		return lastUpdate == null ? null : lastUpdate.toString("yyyy-MM-dd HH:mm:ss");
	}
	public void setLastUpdate(DateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public CountryBean getAuthorCountry() {
		return authorCountry;
	}
	public void setAuthorCountry(CountryBean authorCountry) {
		this.authorCountry = authorCountry;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	

}
