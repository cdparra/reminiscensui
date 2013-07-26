package controllers;

import static play.libs.Json.toJson;
import delegates.LifeStoryDelegate;
import delegates.MementoDelegate;
import enums.ResponseStatus;
import play.mvc.*;
import play.data.*;
import pojos.LifeStoryBean;
import pojos.MementoBean;
import pojos.ResponseStatusBean;

public class LifeStoryControl extends Controller {

	static Form<LifeStoryBean> lifeStoryForm = Form.form(LifeStoryBean.class);
	
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
		Form<LifeStoryBean> filledForm = lifeStoryForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			ResponseStatusBean res = new ResponseStatusBean(
					ResponseStatus.BADREQUEST,
					"Body of request misses some information or it is malformed");
			return badRequest(toJson(res));
		} else {
			LifeStoryBean lifeStoryBean = filledForm.get();
			LifeStoryDelegate.getInstance().create(lifeStoryBean);
			return ok(toJson(lifeStoryBean));
		}
	}

	public static Result updateLifeStory(Long lsid) {
		Form<LifeStoryBean> filledForm = lifeStoryForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			ResponseStatusBean res = new ResponseStatusBean(
					ResponseStatus.BADREQUEST,
					"Body of request misses some information or it is malformed");
			return badRequest(toJson(res));
		} else {
			LifeStoryBean lifeStoryBean = filledForm.get();
			try {
				LifeStoryDelegate.getInstance().update(lifeStoryBean, lsid);
				return ok(toJson(lifeStoryBean));
			} catch (Exception e) {
				ResponseStatusBean res = new ResponseStatusBean(
						ResponseStatus.NODATA, "Entity does not exist",
						e.getMessage());
				return badRequest(toJson(res));
			}
		}	
	}

	public static Result deleteLifeStory(Long lsid) {
		try {
			LifeStoryDelegate.getInstance().deleteLifeStory(lsid);
			ResponseStatusBean res = new ResponseStatusBean(ResponseStatus.OK,
					"Entity deleted with success");
			return ok(toJson(res));
		} catch (Exception e) {
			ResponseStatusBean res = new ResponseStatusBean(
					ResponseStatus.NODATA, "Entity does not exist",
					e.getMessage());
			return badRequest(toJson(res));
		}
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
