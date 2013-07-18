package models;

import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import play.db.ebean.Model;

@Entity
@Table(name="Question_Trans")
public class QuestionTranslation extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5429566886392202046L;

	@Id
    @GeneratedValue
    @Column(name="question_trans_id")
    private Long translationId;
	
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;
	
    @Column(name="question_id")
    private Long questionId;

	@Column
	private String question_text;
	
	@Column
	private String category;

	@Column
	private String chapter;

	@Column
	private String locale;

	@Column
	private Boolean fixed;
	
	public static Model.Finder<Long,QuestionTranslation> find = new Model.Finder<Long, QuestionTranslation>(
            Long.class,QuestionTranslation.class
    );
    
    public static List<QuestionTranslation> all(){
        return find.all();
    }
    
    public static void create(QuestionTranslation question){
        question.save();
    }
    
    /**
	 * @return the translationId
	 */
	public Long getTranslationId() {
		return translationId;
	}

	/**
	 * @param translationId the translationId to set
	 */
	public void setTranslationId(Long translationId) {
		this.translationId = translationId;
	}

	/**
	 * @return the question_text
	 */
	public String getQuestion_text() {
		return question_text;
	}

	/**
	 * @param question_text the question_text to set
	 */
	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
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
	 * @return the question_id
	 */
	public Long getQuestionId() {
		return questionId;
	}

	/**
	 * @param question_id the question_id to set
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the fixed
	 */
	public Boolean getFixed() {
		return fixed;
	}

	/**
	 * @param fixed the fixed to set
	 */
	public void setFixed(Boolean fixed) {
		this.fixed = fixed;
	}

	public static QuestionTranslation createObject(QuestionTranslation question){
        question.save();
        return question;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static QuestionTranslation read(Long id){
        return find.byId(id);
    }

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
