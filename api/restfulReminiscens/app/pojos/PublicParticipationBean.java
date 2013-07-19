package pojos;


import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

public class PublicParticipationBean  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3980159110846013300L;
    private Long famousPersonId;
	private Long publicMementoId;
	private FamousPersonBean famousPerson;	
	@JsonIgnore
	private PublicMementoBean publicMemento;	
	
	public Long getFamousPersonId() {
		return famousPersonId;
	}
	public void setFamousPersonId(Long famousPersonId) {
		this.famousPersonId = famousPersonId;
	}
	public Long getPublicMementoId() {
		return publicMementoId;
	}
	public void setPublicMementoId(Long publicMementoId) {
		this.publicMementoId = publicMementoId;
	}
	public FamousPersonBean getFamousPerson() {
		return famousPerson;
	}
	public void setFamousPerson(FamousPersonBean famousPerson) {
		this.famousPerson = famousPerson;
	}
	public PublicMementoBean getPublicMemento() {
		return publicMemento;
	}
	public void setPublicMemento(PublicMementoBean publicMemento) {
		this.publicMemento = publicMemento;
	}
}
