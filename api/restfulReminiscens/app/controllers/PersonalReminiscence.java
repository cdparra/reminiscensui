package controllers;

import java.util.List;

import play.mvc.*;
import play.data.*;
import play.data.validation.Constraints.Validator;
import pojos.PersonBean;	
import pojos.ResponseStatusBean;
import models.*;
import static play.libs.Json.toJson;


import delegates.PersonDelegate;
import enums.ResponseStatus;


public class PersonalReminiscence extends Controller {
  	
	static Form<LifeStory> lifeStoryForm = Form.form(LifeStory.class);
	static Form<PersonBean> personForm = Form.form(PersonBean.class);

	public static Result getPersonAll() {
		List<PersonBean> lp = PersonDelegate.getInstance().getAll();
		return lp != null ? ok(toJson(lp)) : notFound();
	}
	
	public static Result getPerson(Long id) {
		PersonBean bean = PersonDelegate.getInstance().getPerson(id);
		return bean != null ? ok(toJson(bean)) : notFound();
	}
	
	public static Result createPerson() {
		 Form<PersonBean> filledForm = personForm.bindFromRequest();		 
		if (filledForm.hasErrors()) {
			return badRequest(toJson(new ResponseStatusBean(
					ResponseStatus.BADREQUEST,
					"Body of request misses some information or is malformed")));
		} else {
			PersonBean personBean = filledForm.get();
			//Validator<PersonBean> v = play.data.validation.Validation.getValidator();
			PersonDelegate.getInstance().create(personBean);

			return ok();
		}
	}

	public static Result updatePerson(Long id) {
		/** @TODO */
		return TODO;
	}

	public static Result deletePerson(Long id) {
		/** @TODO */
		return TODO;
	}

	public static Result getPersonFriends(Long id) {
		/** @TODO */
		return TODO;
	}

	public static Result getPersonTimeline(Long id) {
		Timeline tl = Timeline.read(id);
		return ok(toJson(tl));
	}

	public static Result synchronizePersonTimeline(Long id) {
		/** @TODO */
		return TODO;
	}

	public static Result getLifeStory(Long id, Long lsid) {
		/** @TODO */
		return TODO;
	}

	public static Result createLifeStory(Long id) {
		/** @TODO */
		return TODO;
	}

	public static Result updateLifeStory(Long id, Long lsid) {
		/** @TODO */
		return TODO;
	}

	public static Result deleteLifeStory(Long id, Long lsid) {
		/** @TODO */
		return TODO;
	}

	public static Result getMementoAll(Long id) {
		/** @TODO */
		return TODO;
	}

	public static Result getMemento(Long id, Long mid) {
		/** @TODO */
		return TODO;
	}

	public static Result createMemento(Long id, Long mid) {
		/** @TODO */
		return TODO;
	}

	public static Result updateMemento(Long id, Long mid) {
		/** @TODO */
		return TODO;
	}

	public static Result deleteMemento(Long id, Long mid) {
		/** @TODO */
		return TODO;
	}

}
