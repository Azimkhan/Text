package kz.epam.azimkhan.text.parser.exception;

/**
 * Date: 07.06.13
 * Time: 1:35
 */
public class TextParserException extends Exception{
    public TextParserException() {
    }

    public TextParserException(String message) {
        super(message);
    }

    public TextParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextParserException(Throwable cause) {
        super(cause);
    }

    public TextParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
