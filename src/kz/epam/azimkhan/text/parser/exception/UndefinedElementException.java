package kz.epam.azimkhan.text.parser.exception;

/**
 * Date: 07.06.13
 * Time: 10:42
 */
public class UndefinedElementException extends TextParserException{
    private String elementName;

    public UndefinedElementException(String elementName) {
        this.elementName = elementName;
    }

    public UndefinedElementException(String message, String elementName) {
        super(message);
        this.elementName = elementName;
    }

    public UndefinedElementException(String message, Throwable cause, String elementName) {
        super(message, cause);
        this.elementName = elementName;
    }

    public UndefinedElementException(Throwable cause, String elementName) {
        super(cause);
        this.elementName = elementName;
    }

    public UndefinedElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String elementName) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.elementName = elementName;
    }

    public String getElementName() {
        return elementName;
    }
}
