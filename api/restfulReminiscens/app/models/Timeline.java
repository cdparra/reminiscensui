package models;

import java.util.List;

import javax.persistence.*;

import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
public class Timeline extends Model {
	@Id
    @GeneratedValue
    private Long timelineId;

	private Long aboutPersonId;
	
	private List<LifeStory> storyList;

	private List<User> curators;
	
	public static Model.Finder<Long,Timeline> find = new Model.Finder(
            Long.class,Timeline.class
    );
    
}
