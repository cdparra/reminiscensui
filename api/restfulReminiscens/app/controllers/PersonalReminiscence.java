package controllers;

import java.util.List;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import play.libs.Json;
import static play.libs.Json.toJson;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import org.joda.time.DateTime;


import views.html.*;

public class PersonalReminiscence extends Controller {
  	
	static Form<LifeStory> lifeStoryForm = Form.form(LifeStory.class);
	static Form<Person> personForm = Form.form(Person.class);

	public static Result getPersonAll() {
		List<Person> lp = Person.all();	
		return ok(toJson(lp));
	}
	
	public static Result createPerson() {
		 //Form<Person> filledForm = personForm.bindFromRequest();
		 
		 JsonNode json = request().body().asJson();
		 String firstname = json.findPath("firstname").getTextValue();
		 String lastname = json.findPath("lastname").getTextValue();
		 String birthdate= json.findPath("birthdate").getTextValue();
		 String birthplace = json.findPath("birthplace").getTextValue();
		 
		 if (firstname == null || lastname == null || birthdate == null || birthplace == null) {
			 ResponseStatus response = new ResponseStatus();
			 response.setStatus_code(new Long(51));
			 response.setStatus_message("The resource you are trying to create is incomplete");
			 
			 return badRequest(toJson(response));
		 }
			 
		 Person p = new Person();
		 p.setFirstname(firstname);
		 p.setLastname(lastname);
		 p.setBirthdate(DateTime.parse(birthdate));
		 
		 City c = City.findByName(birthplace).get(0);
		 
		 if (c == null ) {
			 ResponseStatus response = new ResponseStatus();
			 response.setStatus_code(new Long(51));
			 response.setStatus_message("Birthplace does not exist");
			 
			 return badRequest(toJson(response));
		 }
		 
		 p.setBirthplace(c);
		 
		 p = Person.createObject(p);
		 
		 return ok(toJson(p));
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
		Person p = Person.read(id);
		return ok(toJson(p));
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
