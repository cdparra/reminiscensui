package controllers;

import java.util.List;

import play.mvc.*;
import play.data.*;
import pojos.PersonBean;
import pojos.RelationshipBean;
import pojos.ResponseStatusBean;
import static play.libs.Json.toJson;

import delegates.PersonDelegate;
import enums.ResponseStatus;

public class Person extends Controller {

	static Form<PersonBean> personForm = Form.form(PersonBean.class);;
	static Form<RelationshipBean> relationshipForm = Form.form(RelationshipBean.class);

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
			ResponseStatusBean res = new ResponseStatusBean(
					ResponseStatus.BADREQUEST,
					"Body of request misses some information or it is malformed");
			return badRequest(toJson(res));
		} else {
			PersonBean personBean = filledForm.get();
			PersonDelegate.getInstance().create(personBean);
			return ok(toJson(personBean));
		}
	}

	public static Result updatePerson(Long id) {
		Form<PersonBean> filledForm = personForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			ResponseStatusBean res = new ResponseStatusBean(
					ResponseStatus.BADREQUEST,
					"Body of request misses some information or it is malformed");
			return badRequest(toJson(res));
		} else {
			PersonBean personBean = filledForm.get();
			try {
				PersonDelegate.getInstance().update(personBean, id);
				return ok(toJson(personBean));
			} catch (Exception e) {
				ResponseStatusBean res = new ResponseStatusBean(
						ResponseStatus.NODATA, "Entity does not exist",
						e.getMessage());
				return badRequest(toJson(res));
			}
		}
	}

	public static Result deletePerson(Long id) {
		try {
			PersonDelegate.getInstance().deletePerson(id);
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
