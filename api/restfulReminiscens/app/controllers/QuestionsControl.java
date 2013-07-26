package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import delegates.QuestionDelegate;
import play.mvc.*;
import pojos.QuestionBean;

public class QuestionsControl extends Controller {

    public static Result getGeneralQuestionsForYear(Integer byear, Integer fyear) {
		List<QuestionBean> lp = QuestionDelegate.getInstance().getQuestionsForLifeDecade(byear,fyear);
		return lp != null ? ok(toJson(lp)) : notFound();
	}

	public static Result getGeneralQuestionsForLifeChapter(String chapter) {
		List<QuestionBean> lp = QuestionDelegate.getInstance().getQuestionsForLifeChapter(chapter);
		return lp != null ? ok(toJson(lp)) : notFound();
	}
}
