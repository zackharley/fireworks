// TODO Add object name that throws Exception
/**
 * An Exception thrown by the  object if parameters are not legal.
 * <ul>
 * <li>The time interval must be larger than 0 and less than or equal to 0.05</li>
 * </ul>
 * @author Zackery Harley
 * @version 1.0
 */
public class IllegalTimeIntervalException extends Exception {
	
	private static final long serialVersionUID = 8266203176967408366L;

	/**
	 * Supplies a default message.
	 */
	public IllegalTimeIntervalException() {
		super("Illegal parameter calue supplied to  object.");
	}
	
	/**
	 * Passes along the message supplied to the exception.
	 * @param message A more specific message.
	 */
	public IllegalTimeIntervalException(String message) {
		super(message);
	}
	
} // end IllegalTimeIntervalException
