package exceptions;

public class UserAlreadyInvitedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7978166321444260519L;

	public UserAlreadyInvitedException(String msg) {
		super(msg);
	}

	public UserAlreadyInvitedException() {
	}

}
