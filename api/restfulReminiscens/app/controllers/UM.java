package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class UM extends Controller {
  
    public static Result index() {
    	/** @TODO */
        return ok(index.render("Reminiscens RESTful API is ready!"));
    }
    

    public static Result getUsers() {
    	/** @TODO */
        return TODO;
    }

    public static Result getUser(Long uid) {
    	/** @TODO */
        return TODO;
    }

    public static Result createUser() {
    	/** @TODO */
        return TODO;
    }    
     
   public static Result updateUser(Long uid) {
   	/** @TODO */
        return TODO;
    }

   public static Result deleteUser(Long uid) {
   	/** @TODO */
       return TODO;
   }

   public static Result getSessions() {
   	/** @TODO */
       return TODO;
   }

   public static Result createSession() {
   	/** @TODO */
       return TODO;
   }
   

   public static Result updateSession(Long sid) {
   	/** @TODO */
       return TODO;
   }

   public static Result deleteSession(Long sid) {
   	/** @TODO */
       return TODO;
   }
}
