package pojos;

import java.io.Serializable;

public class ParticipationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4590549776323471789L;

    private Long participationId;

    private Long personId;
	
	private Long lifeStoryId;
	
	private boolean isProtagonist;

//	private UserBean contributor;
//	
//	private PersonBean person;	
//	
//	private LifeStoryBean lifeStory;	
	

	/**
	 * @return the participationId
	 */
	public Long getParticipationId() {
		return participationId;
	}

	/**
	 * @param participationId the participationId to set
	 */
	public void setParticipationId(Long participationId) {
		this.participationId = participationId;
	}

	/**
	 * @return the personId
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @return the lifeEventId
	 */
	public Long getLifeStoryId() {
		return lifeStoryId;
	}

	/**
	 * @param lifeEventId the lifeEventId to set
	 */
	public void setLifeStoryId(Long lifeEventId) {
		this.lifeStoryId = lifeEventId;
	}

	/**
	 * @return the isProtagonist
	 */
	public boolean isProtagonist() {
		return isProtagonist;
	}

	/**
	 * @param isProtagonist the isProtagonist to set
	 */
	public void setProtagonist(boolean isProtagonist) {
		this.isProtagonist = isProtagonist;
	}
}
