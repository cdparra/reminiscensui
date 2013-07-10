package exceptions;

public class EntityDoesNotExist extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7978166321444260519L;

	public EntityDoesNotExist(String msg) {
		super(msg);
	}

	public EntityDoesNotExist() {
	}

}
