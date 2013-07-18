package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import delegates.UserDelegate;
import enums.ResponseStatus;
import play.data.Form;
import play.mvc.*;
import pojos.UserBean;
import pojos.ResponseStatusBean;


public class User extends Controller {
 
	static Form<UserBean> userForm = Form.form(UserBean.class);
	
	public static Result getUsers() {
    	List<UserBean> listUsers = UserDelegate.getInstance().getAll();
		return listUsers != null ? ok(toJson(listUsers)) : notFound();
    }

    public static Result getUser(Long uid) {
    	UserBean bean = UserDelegate.getInstance().getUser(uid);
		return bean != null ? ok(toJson(bean)) : notFound();
    }

    public static Result createUser() {
    	Form<UserBean> filledForm = userForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			ResponseStatusBean res = new ResponseStatusBean(
					ResponseStatus.BADREQUEST,
					"Body of request misses some information or it is malformed");
			return badRequest(toJson(res));
		} else {
			UserBean userBean = filledForm.get();
			UserDelegate.getInstance().create(userBean);
			return ok(toJson(userBean));
		}
    }    
     
   public static Result updateUser(Long uid) {
		Form<UserBean> filledForm = userForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			ResponseStatusBean res = new ResponseStatusBean(
					ResponseStatus.BADREQUEST,
					"Body of request misses some information or it is malformed");
			return badRequest(toJson(res));
		} else {
			UserBean userBean = filledForm.get();
			try {
				UserDelegate.getInstance().update(userBean, uid);
				return ok(toJson(userBean));
			} catch (Exception e) {
				ResponseStatusBean res = new ResponseStatusBean(
						ResponseStatus.NODATA, "Entity does not exist",
						e.getMessage());
				return badRequest(toJson(res));
			}
		}
    }

   public static Result deleteUser(Long uid) {
		try {
			UserDelegate.getInstance().deleteUser(uid);
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


}
