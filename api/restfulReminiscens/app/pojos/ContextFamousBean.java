package pojos;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

public class ContextFamousBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6003319629318118220L;
	
	private Long contextId;
	private Long publicMementoId;
	@JsonIgnore
	private ContextBean context;	
	private FamousPersonBean famousPerson;
	
	public Long getContextId() {
		return contextId;
	}
	public void setContextId(Long contextId) {
		this.contextId = contextId;
	}
	public Long getPublicMementoId() {
		return publicMementoId;
	}
	public void setPublicMementoId(Long publicMementoId) {
		this.publicMementoId = publicMementoId;
	}
	public ContextBean getContext() {
		return context;
	}
	public void setContext(ContextBean context) {
		this.context = context;
	}
	public FamousPersonBean getFamousPerson() {
		return famousPerson;
	}
	public void setFamousPerson(FamousPersonBean famousPerson) {
		this.famousPerson = famousPerson;
	}

}
