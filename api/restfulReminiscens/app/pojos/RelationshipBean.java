package pojos;

import java.io.Serializable;

import play.data.validation.Constraints.Required;


public class RelationshipBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7045811975198960968L;

    private Long relationshipId;	
	
    @Required
    private Long personToId;	

    @Required
    private Long personFromId;	

    private Boolean directed = Boolean.FALSE;
    
    private Boolean toIsCurator = Boolean.FALSE;
    
    private Boolean fromIsCurator = Boolean.FALSE;
    

    @Required
	private String roleTo;

    @Required
	private String roleFrom;
    
    private String network = "FRIENDS";
    	
    private PersonBean personTo;	
	
	private PersonBean personFrom;	
        
	public Long getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}

	public PersonBean getPersonTo() {
		return personTo;
	}

	public void setPersonTo(PersonBean personTo) {
		this.personTo = personTo;
	}

	public PersonBean getPersonFrom() {
		return personFrom;
	}

	public void setPersonFrom(PersonBean personFrom) {
		this.personFrom = personFrom;
	}

	public Boolean getDirected() {
		return directed;
	}

	public void setDirected(Boolean directed) {
		this.directed = directed;
	}
	
	public String getRoleTo() {
		return roleTo;
	}

	public void setRoleTo(String roleTo) {
		this.roleTo = roleTo;
	}

	public String getRoleFrom() {
		return roleFrom;
	}

	public void setRoleFrom(String roleFrom) {
		this.roleFrom = roleFrom;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public Boolean getToIsCurator() {
		return toIsCurator;
	}

	public void setToIsCurator(Boolean toIsCurator) {
		this.toIsCurator = toIsCurator;
	}

	public Boolean getFromIsCurator() {
		return fromIsCurator;
	}

	public void setFromIsCurator(Boolean fromIsCurator) {
		this.fromIsCurator = fromIsCurator;
	}

	public Long getPersonToId() {
		return personToId;
	}

	public void setPersonToId(Long personToId) {
		this.personToId = personToId;
	}

	public Long getPersonFromId() {
		return personFromId;
	}

	public void setPersonFromId(Long personFromId) {
		this.personFromId = personFromId;
	}
}
