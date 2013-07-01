package controllers;

import models.LifeStory;
import play.*;
import play.data.*;
import play.mvc.*;
import models.*;

import views.html.*;

public class Application extends Controller {
  
	
	public static Result index() {
		return ok(views.html.index.render("The API is ready"));
	}

}
