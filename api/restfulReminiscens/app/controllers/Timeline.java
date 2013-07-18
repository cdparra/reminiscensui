package controllers;

import delegates.TimelineDelegate;
import enums.ResponseStatus;
import play.data.Form;
import play.mvc.*;
import pojos.ResponseStatusBean;
import pojos.TimelineBean;
import static play.libs.Json.toJson;


public class Timeline extends Controller {
	static Form<TimelineBean> timelineForm = Form.form(TimelineBean.class);
	
	public static Result getPersonTimeline(Long id) {
		TimelineBean bean = TimelineDelegate.getInstance().getTimeline(id);
		return bean != null ? ok(toJson(bean)) : notFound();
	}
	
	public static Result getPersonTimelineWithLimits(Long id, Long from, Long to) {
		TimelineBean bean = TimelineDelegate.getInstance().getTimelineWithLimits(id, from, to);
		return bean != null ? ok(toJson(bean)) : notFound();
	}

	public static Result synchronizePersonTimeline(Long id) {
		Form<TimelineBean> filledForm = timelineForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			ResponseStatusBean res = new ResponseStatusBean(
					ResponseStatus.BADREQUEST,
					"Body of request misses some information or it is malformed");
			return badRequest(toJson(res));
		} else {
			TimelineBean timelineBean = filledForm.get();
			TimelineDelegate.getInstance().synchronize(timelineBean);
			return ok(toJson(timelineBean));
		}
	}
}
