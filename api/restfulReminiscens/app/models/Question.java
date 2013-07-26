package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
@Table(name="Question")
public class Question extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 469433174903841938L;
	
	@Id
    @GeneratedValue
    @Column(name="question_id")
    private Long questionId;
	
	@Column(name="question_text")
	private String question;
	
	@Column
	private String category;

	@Column
	private String chapter;

	@Column
	private String locale;

	@Column
	private Integer ranking;

	@Column
	private String source;
	
	@Column
	private Boolean present_tense;

	@Column
	private Integer startdecade;
	
	@Column
	private Integer enddecade; 
	
	@OneToMany(mappedBy="question")
	private List<QuestionTranslation> translations;
	
	/**
	 * @return the questionId
	 */
	public Long getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the question_text
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question_text the question_text to set
	 */
	public void setQuestion(String question_text) {
		this.question = question_text;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the chapter
	 */
	public String getChapter() {
		return chapter;
	}

	/**
	 * @param chapter the chapter to set
	 */
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return the ranking
	 */
	public Integer getRanking() {
		return ranking;
	}

	/**
	 * @param ranking the ranking to set
	 */
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the present_tense
	 */
	public Boolean getPresent_tense() {
		return present_tense;
	}

	/**
	 * @param present_tense the present_tense to set
	 */
	public void setPresent_tense(Boolean present_tense) {
		this.present_tense = present_tense;
	}

	/**
	 * @return the startdecade
	 */
	public Integer getStartdecade() {
		return startdecade;
	}

	/**
	 * @param startdecade the startdecade to set
	 */
	public void setStartdecade(Integer startdecade) {
		this.startdecade = startdecade;
	}

	/**
	 * @return the enddecade
	 */
	public Integer getEnddecade() {
		return enddecade;
	}

	/**
	 * @param enddecade the enddecade to set
	 */
	public void setEnddecade(Integer enddecade) {
		this.enddecade = enddecade;
	}

	/**
	 * @return the translations
	 */
	public List<QuestionTranslation> getTranslations() {
		return translations;
	}

	/**
	 * @param translations the translations to set
	 */
	public void setTranslations(List<QuestionTranslation> translations) {
		this.translations = translations;
	}

	public static Model.Finder<Long,Question> find = new Model.Finder<Long, Question>(
            Long.class,Question.class
    );
    
    public static List<Question> all(){
        return find.all();
    }
    
    public static void create(Question question){
        question.save();
    }
    
    public static Question createObject(Question question){
        question.save();
        return question;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static Question read(Long id){
        return find.byId(id);
    }

	public static List<Question> readByChapter(String chap) {
		List<Question> questionList = find.where()
				.eq("chapter", chap)
				.orderBy("rand()")
				.setMaxRows(3)
				.findList();
		return questionList;
	}
}
