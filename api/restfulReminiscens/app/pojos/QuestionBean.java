package pojos;

import java.io.Serializable;
import java.util.List;

public class QuestionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9064036172938322280L;
	
    private Long questionId;
	private String question;
	private String category;
	private String chapter;
	private String locale;
	private Integer ranking;
	private List<QuestionTranslationBean> translations;
	
//	Fields in database not exposed through API
//	private String source;
//	private Boolean present_tense;
//	private Integer startdecade;
//	private Integer enddecade; 
	
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question_text) {
		this.question = question_text;
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
	public Integer getRanking() {
		return ranking;
	}
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
//	public String getSource() {
//		return source;
//	}
//	public void setSource(String source) {
//		this.source = source;
//	}
//	public Boolean getPresent_tense() {
//		return present_tense;
//	}
//	public void setPresent_tense(Boolean present_tense) {
//		this.present_tense = present_tense;
//	}
//	public Integer getStartdecade() {
//		return startdecade;
//	}
//	public void setStartdecade(Integer startdecade) {
//		this.startdecade = startdecade;
//	}
//	public Integer getEnddecade() {
//		return enddecade;
//	}
//	public void setEnddecade(Integer enddecade) {
//		this.enddecade = enddecade;
//	}
	public List<QuestionTranslationBean> getTranslations() {
		return translations;
	}
	public void setTranslations(List<QuestionTranslationBean> translations) {
		this.translations = translations;
	}
	
	
	
}
