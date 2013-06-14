package kz.epam.azimkhan.text.exception;

/**
 * Exception 
 * @author azimkhan
 *
 */
public class TextAccessException extends Exception{

	
	private static final long serialVersionUID = -373349127017711324L;

	/**
	 * 
	 */
	public TextAccessException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TextAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public TextAccessException(String message) {
		super(message);
		
	}
	

}
