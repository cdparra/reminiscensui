package pojos;

import java.io.Serializable;
import java.util.List;

public class TimelineBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3160277988972750900L;

	private PersonBean aboutPerson;
	
	private List<LifeStoryBean> storyList;

	private List<UserBean> curators;
	
	public List<LifeStoryBean> getStoryList() {
		return storyList;
	}

	public void setStoryList(List<LifeStoryBean> storyList) {
		this.storyList = storyList;
	}

	public List<UserBean> getCurators() {
		return curators;
	}

	public void setCurators(List<UserBean> curators) {
		this.curators = curators;
	}

	public PersonBean getAboutPerson() {
		return aboutPerson;
	}

	public void setAboutPerson(PersonBean aboutPerson) {
		this.aboutPerson = aboutPerson;
	}	
}
