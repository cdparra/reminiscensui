package pojos;


import java.io.Serializable;
import java.util.List;

import org.joda.time.DateTime;

import utils.JodaDateTime;

public class ContextBean  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3980159110846013300L;

    private Long contextId;
	private String title;
	private String subtitle;
	private Long personForId;
	private CityBean cityFor;
	private Long cityRatio;
	@JodaDateTime(format = "yyyy-MM-dd HH:mm:ss")
	private DateTime date;
	private Long dateRatio;
	private List<ContextContentBean> publicContextContent;
	public Long getContextId() {
		return contextId;
	}
	public void setContextId(Long contextId) {
		this.contextId = contextId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public Long getPersonForId() {
		return personForId;
	}
	public void setPersonForId(Long personForId) {
		this.personForId = personForId;
	}
	public CityBean getCityFor() {
		return cityFor;
	}
	public void setCityFor(CityBean cityFor) {
		this.cityFor = cityFor;
	}
	public Long getCityRatio() {
		return cityRatio;
	}
	public void setCityRatio(Long cityRatio) {
		this.cityRatio = cityRatio;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public Long getDateRatio() {
		return dateRatio;
	}
	public void setDateRatio(Long dateRatio) {
		this.dateRatio = dateRatio;
	}
	public List<ContextContentBean> getPublicContextContent() {
		return publicContextContent;
	}
	public void setPublicContextContent(
			List<ContextContentBean> publicContextContent) {
		this.publicContextContent = publicContextContent;
	}	
}
