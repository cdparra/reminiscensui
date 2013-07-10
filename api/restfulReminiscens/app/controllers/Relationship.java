package controllers;

import java.util.List;

import play.mvc.*;
import play.data.*;
import pojos.RelationshipBean;
import pojos.ResponseStatusBean;
import static play.libs.Json.toJson;

import delegates.RelationshipDelegate;
import enums.ResponseStatus;

public class Relationship extends Controller {

	static Form<RelationshipBean> relationshipForm = Form
			.form(RelationshipBean.class);

	public static Result getPersonRelationships(Long id) {
		List<RelationshipBean> relationships = RelationshipDelegate
				.getInstance().getPersonRelationships(id);
		return relationships != null ? ok(toJson(relationships)) : notFound();
	}

	public static Result getPersonCurators(Long id) {
		List<RelationshipBean> relationships = RelationshipDelegate
				.getInstance().getPersonCurators(id);
		return relationships != null ? ok(toJson(relationships)) : notFound();
	}

	public static Result addRelationship() {
		Form<RelationshipBean> filledForm = relationshipForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			ResponseStatusBean res = new ResponseStatusBean(
					ResponseStatus.BADREQUEST,
					"Body of request misses some information or it is malformed");
			return badRequest(toJson(res));
		} else {
			RelationshipBean relBean = filledForm.get();
			RelationshipDelegate.getInstance().create(relBean);
			return ok(toJson(relBean));
		}
	}

	public static Result updateRelationship(Long id) {
		Form<RelationshipBean> filledForm = relationshipForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			ResponseStatusBean res = new ResponseStatusBean(
					ResponseStatus.BADREQUEST,
					"Body of request misses some information or it is malformed");
			return badRequest(toJson(res));
		} else {
			RelationshipBean relationshipBean = filledForm.get();
			try {
				RelationshipDelegate.getInstance().update(relationshipBean, id);
				return ok(toJson(relationshipBean));
			} catch (Exception e) {
				ResponseStatusBean res = new ResponseStatusBean(
						ResponseStatus.NODATA, "Entity does not exist",
						e.getMessage());
				return badRequest(toJson(res));
			}
		}
	}

	public static Result deleteRelationship(Long id) {
		try {
			RelationshipDelegate.getInstance().deleteRelationship(id);
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
