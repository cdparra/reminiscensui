package controllers;


import play.mvc.*;
import static play.libs.Json.toJson;


public class Timeline extends Controller {

	

	public static Result getPersonTimeline(Long id) {
		/** TODO */
		models.Timeline tl = models.Timeline.read(id);
		return ok(toJson(tl));
	}

	public static Result synchronizePersonTimeline(Long id) {
		/** @TODO */
		return TODO;
	}

}
