package kz.epam.azimkhan.text.exception;

/**
 * Date: 11.06.13
 * Time: 17:36
 */
public class TextReadException extends Exception{
    public TextReadException() {
    }

    public TextReadException(String message) {
        super(message);
    }

    public TextReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
