package kz.epam.azimkhan.text.exception;

/**
 * Date: 07.06.13
 * Time: 1:35
 */
public class TextParseException extends Exception{
    public TextParseException() {
    }

    public TextParseException(String message) {
        super(message);
    }

    public TextParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
