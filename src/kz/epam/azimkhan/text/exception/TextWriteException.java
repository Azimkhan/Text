package kz.epam.azimkhan.text.exception;

/**
 * Date: 11.06.13
 * Time: 17:37
 */
public class TextWriteException extends Exception{
    
	private static final long serialVersionUID = -1742546539096117606L;

	public TextWriteException() {
    }

    public TextWriteException(String message) {
        super(message);
    }

    public TextWriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextWriteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
