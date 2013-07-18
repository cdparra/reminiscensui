package delegates;

import java.util.ArrayList;
import java.util.List;

import pojos.QuestionBean;
import utils.PlayDozerMapper;

public class QuestionDelegate {

	public static QuestionDelegate getInstance() {
		return new QuestionDelegate();
	}

	public List<QuestionBean> getAll() {
		List<models.Question> modelQuestions = models.Question.all();
		List<QuestionBean> pojosQuestions = new ArrayList<QuestionBean>();
		for (models.Question question : modelQuestions) {
			QuestionBean questionBean = PlayDozerMapper.getInstance().map(
					question, QuestionBean.class);
			pojosQuestions.add(questionBean);
		}
		return pojosQuestions;
	}

	public QuestionBean getQuestion(Long id) {
		models.Question question = models.Question.read(id);
		if (question != null) {
			QuestionBean questionBean = PlayDozerMapper.getInstance().map(
					question, QuestionBean.class);
			return questionBean;
		} else {
			return null;
		}
	}

	public void create(QuestionBean questionBean) {
		models.Question question = PlayDozerMapper.getInstance().map(
				questionBean, models.Question.class);
		models.Question.create(question);
		question = models.Question.read(question.getQuestionId());
		PlayDozerMapper.getInstance().map(question, questionBean);
	}

	public void update(QuestionBean bean, Long id) {
		models.Question question = PlayDozerMapper.getInstance().map(bean,
				models.Question.class);
		question.update(id);
		question = models.Question.read(question.getQuestionId());
		PlayDozerMapper.getInstance().map(question, bean);
	}

	public void deleteQuestion(Long id) {
		models.Question.delete(id);
	}

	public static List<QuestionBean> getQuestionsForLifeChapter(String chapter) {
		List<models.Question> modelQuestions = models.Question.readByChapter(chapter);
		List<QuestionBean> pojosQuestions = new ArrayList<QuestionBean>();
		for (models.Question question : modelQuestions) {
			QuestionBean questionBean = PlayDozerMapper.getInstance().map(
					question, QuestionBean.class);
			pojosQuestions.add(questionBean);
		}
		return pojosQuestions;
	}
	
	public static List<QuestionBean> getQuestionsForLifeDecade(Long birthYear, Long focusYear) {
		//TODO
		return null;
	}

}
