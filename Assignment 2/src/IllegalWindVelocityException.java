// TODO Add object name that throws Exception
/**
 * An Exception thrown by the  object if parameters are not legal.
 * <ul>
 * <li>The wind velocity must between -20 and 20</li>
 * </ul>
 * @author Zackery Harley
 * @version 1.0
 */
public class IllegalWindVelocityException extends Exception {

	private static final long serialVersionUID = 3546546658244645636L;

	/**
	 * Supplies a default message.
	 */
	public IllegalWindVelocityException() {
		super("Illegal parameter calue supplied to  object.");
	}
	
	/**
	 * Passes along the message supplied to the exception.
	 * @param message A more specific message.
	 */
	public IllegalWindVelocityException(String message) {
		super(message);
	}
	
} // end IllegalWindVelocityException
