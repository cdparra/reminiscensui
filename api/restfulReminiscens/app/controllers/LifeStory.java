package controllers;

import static play.libs.Json.toJson;
import delegates.LifeStoryDelegate;
import play.mvc.*;
import play.data.*;
import pojos.LifeStoryBean;

public class LifeStory extends Controller {

	static Form<LifeStory> lifeStoryForm = Form.form(LifeStory.class);
	
	public static Result getPersonLifeStoryAll(Long id) {
		/** @TODO */
		return TODO;
	}

	public static Result getProtagonistLifeStoryAll(Long id) {
		/** @TODO */
		return TODO;
	}

	
	public static Result getLifeStory(Long lsid) {
		LifeStoryBean bean = LifeStoryDelegate.getInstance().getLifeStory(lsid);
		return bean != null ? ok(toJson(bean)) : notFound();
	}

	public static Result createLifeStory() {
		/** @TODO */
		return TODO;
	}

	public static Result updateLifeStory(Long lsid) {
		/** @TODO */
		return TODO;
	}

	public static Result deleteLifeStory(Long lsid) {
		/** @TODO */
		return TODO;
	}
	
	// extra services
	public static Result addParticipantToLifeStory(Long lsid, Long id) {
		/** @TODO */
		return TODO;
	}

	public static Result addProtagonistToLifeStory(Long lsid, Long id) {
		/** @TODO */
		return TODO;
	}

	public static Result deletePersonFromLifeStory(Long lsid, Long id) {
		/** @TODO */
		return TODO;
	}

	public static Result addMementoToLifeStory(Long lsid, Long mid) {
		/** @TODO */
		return TODO;
	}
	
	public static Result addNewMementoToLifeStory(Long lsid) {
		/** @TODO */
		return TODO;
	}

}
