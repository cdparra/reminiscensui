package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class Timeline extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3160277988972750900L;

	@Id
    @GeneratedValue
    private Long timelineId;
	
	private Person aboutPerson;
	
	private List<LifeStory> storyList;

	private List<User> curators;
	
	public static Model.Finder<Long,Timeline> find = new Model.Finder<Long, Timeline>(
            Long.class,Timeline.class
    );
	
	public static Timeline read(Long personId){
		Person p = Person.read(personId);
		Timeline t = new Timeline();
		
		t.setAboutPerson(p);
		t.setStoryList(LifeStory.readByPerson(personId));
		
		
		return t;
	}

	public List<LifeStory> getStoryList() {
		return storyList;
	}

	public void setStoryList(List<LifeStory> storyList) {
		this.storyList = storyList;
	}

	public Person getAboutPerson() {
		return aboutPerson;
	}

	public void setAboutPerson(Person aboutPerson) {
		this.aboutPerson = aboutPerson;
	}

	public List<User> getCurators() {
		return curators;
	}

	public void setCurators(List<User> curators) {
		this.curators = curators;
	}
	    
	
}
