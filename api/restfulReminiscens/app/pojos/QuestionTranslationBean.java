package pojos;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

public class QuestionTranslationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9064036172938322280L;
	
    private Long translationId;
	
    @JsonIgnore
    private QuestionBean question;
	private Long questionId;
	private String question_text;
	private String category;
	private String chapter;
	private String locale;
	
	public Long getTranslationId() {
		return translationId;
	}
	public void setTranslationId(Long translationId) {
		this.translationId = translationId;
	}
	public QuestionBean getQuestion() {
		return question;
	}
	public void setQuestion(QuestionBean question) {
		this.question = question;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestion_text() {
		return question_text;
	}
	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	
}
