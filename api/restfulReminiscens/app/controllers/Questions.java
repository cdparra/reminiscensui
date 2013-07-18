package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import delegates.QuestionDelegate;
import play.mvc.*;
import pojos.QuestionBean;

public class Questions extends Controller {

    public static Result getGeneralQuestionsForYear(Long byear, Long fyear) {
    	/** TODO */
		List<QuestionBean> lp = QuestionDelegate.getInstance().getQuestionsForLifeDecade(byear,fyear);
		return TODO;
	}

	public static Result getGeneralQuestionsForLifeChapter(String chapter) {
		List<QuestionBean> lp = QuestionDelegate.getInstance().getQuestionsForLifeChapter(chapter);
		return lp != null ? ok(toJson(lp)) : notFound();
	}
}
