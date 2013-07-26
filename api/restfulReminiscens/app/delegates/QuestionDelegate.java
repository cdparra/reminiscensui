package delegates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import enums.QuestionChapter;

import pojos.QuestionBean;
import utils.PlayDozerMapper;

public class QuestionDelegate {

	static final Map<Integer, String> questionChapterDecades  = new HashMap<Integer, String>();
	
	static {
		questionChapterDecades.put(0, "Childhood");
		questionChapterDecades.put(1, "Childhood");
		questionChapterDecades.put(2, "Childhood"); // ALSO YOUTH
		questionChapterDecades.put(3, "Youth");
		questionChapterDecades.put(4, "Adulthood");
		questionChapterDecades.put(5, "Adulthood");
		questionChapterDecades.put(6, "Adulthood");
		questionChapterDecades.put(7, "Oldage");
		questionChapterDecades.put(8, "Oldage");
		questionChapterDecades.put(9, "Oldage");
	}
	
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
		
		// Add some random questions for alltimes 
		addAllTimesQuestions(pojosQuestions);
		return pojosQuestions;
	}
	
	private static void addAllTimesQuestions(List<QuestionBean> pojosQuestions) {
		List<models.Question> modelQuestions = models.Question.readByChapter("All times");
		List<QuestionBean> allTimeQuestions = new ArrayList<QuestionBean>();
		for (models.Question question : modelQuestions) {
			QuestionBean questionBean = PlayDozerMapper.getInstance().map(
					question, QuestionBean.class);
			allTimeQuestions.add(questionBean);
		}
		pojosQuestions.addAll(allTimeQuestions);
	}

	public static List<QuestionBean> getQuestionsForLifeDecade(Integer birthYear, Integer focusYear) {
		Integer focusDecade = ((focusYear - birthYear) % 100)/10;
		String chapter = questionChapterDecades.get(focusDecade);
		return getQuestionsForLifeChapter(chapter);
	}

}
