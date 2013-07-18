package pojos;

import java.io.Serializable;


import org.codehaus.jackson.annotate.JsonIgnore;

public class MementoParticipationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4590549776323471789L;
 
	private MentionPersonBean mentionPerson;
	@JsonIgnore
	private MementoBean memento;
	
	public Long getMentionPersonId() {
		return mentionPerson.getMentionPersonId();
	}
	public void setMentionPersonId(Long mentionPersonId) {
		mentionPerson = new MentionPersonBean();
		this.mentionPerson.setMentionPersonId(mentionPersonId);
	}
	public Long getMementoId() {
		return memento.getMementoId();
	}
	public void setMementoId(Long mementoId) {
		this.memento = new MementoBean();
		this.memento.setMementoId(mementoId);
	}
	public MentionPersonBean getMentionPerson() {
		return mentionPerson;
	}
	public void setMentionPerson(MentionPersonBean mentionPerson) {
		this.mentionPerson = mentionPerson;
	}
	public MementoBean getMemento() {
		return memento;
	}
	public void setMemento(MementoBean memento) {
		this.memento = memento;
	}
}
