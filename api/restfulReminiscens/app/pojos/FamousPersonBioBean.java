package pojos;

import java.io.Serializable;

public class FamousPersonBioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9064036172938322280L;
    private Long bioId;
	private String bio;
	private FamousPersonBean famousPerson;
	
	public Long getBioId() {
		return bioId;
	}
	public void setBioId(Long bioId) {
		this.bioId = bioId;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public FamousPersonBean getFamousPerson() {
		return famousPerson;
	}
	public void setFamousPerson(FamousPersonBean famousPerson) {
		this.famousPerson = famousPerson;
	}
		
}

