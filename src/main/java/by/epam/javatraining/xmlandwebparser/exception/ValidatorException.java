package by.epam.javatraining.xmlandwebparser.exception;

public class ValidatorException extends Exception {

    public ValidatorException() {
    }

    public ValidatorException(Exception e) {
        super(e);
    }

    public ValidatorException(String message) {
        super(message);
    }

    public ValidatorException(String message, Exception e) {
        super(message, e);
    }
}
