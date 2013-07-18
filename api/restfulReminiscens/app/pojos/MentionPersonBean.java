package pojos;


import java.io.Serializable;

public class MentionPersonBean  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8616821877476181917L;

	private Long mentionPersonId;
    private String fullname;
    private String relationship;
    private PersonBean person;
    
	public Long getMentionPersonId() {
		return mentionPersonId;
	}
	public void setMentionPersonId(Long mentionPersonid) {
		this.mentionPersonId = mentionPersonid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public PersonBean getPerson() {
		return person;
	}
	public void setPerson(PersonBean person) {
		this.person = person;
	}
}
