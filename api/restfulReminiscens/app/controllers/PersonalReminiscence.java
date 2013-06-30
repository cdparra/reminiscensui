package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;


import views.html.*;

public class PersonalReminiscence extends Controller {
  	
	static Form<LifeStory> lifeStoryForm = Form.form(LifeStory.class);
	static Form<Person> personForm = Form.form(Person.class);

	public static Result getPersonAll() {
		 Form<Person> filledForm = personForm.bindFromRequest();
		 return ok(views.html.person.render(Person.all(), filledForm));
	}
	
	public static Result createPerson() {
		 Form<Person> filledForm = personForm.bindFromRequest();
		  if(filledForm.hasErrors()) {
		    return badRequest(
		      views.html.person.render(Person.all(), filledForm)
		    );
		  } else {
		    Person.create(filledForm.get());
		    return redirect(routes.PersonalReminiscence.getPersonTimeline(filledForm.get().getPersonId()));  
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
	
	public static Result getPerson(Long id) {
    	/** @TODO */
		return TODO;
	}

	public static Result getPersonFriends(Long id) {
    	/** @TODO */
		return TODO;
	}

	public static Result getPersonTimeline(Long id) {
		
		 Form<LifeStory> filledForm = lifeStoryForm.bindFromRequest();
		  if(filledForm.hasErrors()) {
		    return badRequest(
		      views.html.timeline.render(LifeStory.all(), filledForm,Person.read(id))
		    );
		  } else {
		    LifeStory.create(filledForm.get());
		    return redirect(routes.PersonalReminiscence.getPersonTimeline(id));  
		  }
		
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
