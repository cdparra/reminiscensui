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

	private Person aboutPerson;
	
	private List<LifeStory> storyList;

	private List<User> curators;
	
	public static Model.Finder<Long,Timeline> find = new Model.Finder<Long, Timeline>(
            Long.class,Timeline.class
    );
	
	public static Timeline readByPerson(Long personId){
		Person p = Person.read(personId);
		Timeline t = new Timeline();
		t.setAboutPerson(p);
		t.setStoryList(LifeStory.readByPerson(personId));
		return t;
	}

	public static Timeline readByPersonWithLimits(Long personId, Long from, Long to){
		Person p = Person.read(personId);
		Timeline t = new Timeline();
		t.setAboutPerson(p);
		t.setStoryList(LifeStory.readByPersonWithLimits(personId, from, to));
		return t;
	}
	public static Timeline synchronize(Timeline t) {
		// 1. Create/Update stories in the timeline, sent from the client
		List<LifeStory> storyList = t.getStoryList();
		for (LifeStory lifeStory : storyList) {
			if (lifeStory.getLifeStoryId() != null && lifeStory.isSynchronized()) {
				lifeStory.update();
			} else {
				models.LifeStory.create(lifeStory);
			}
		}
		
		// 2. Get Updated Timeline of stories
		// TODO optimize by adding query to get only stories that aren't in client

		List<LifeStory> storyListServer = LifeStory.readByPerson(t.getAboutPerson().getPersonId());
		t.setStoryList(storyListServer);
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
