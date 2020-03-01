package by.epam.javatraining.xmlandwebparser.exception;

public class BuilderException extends Exception{

    public BuilderException() {
    }

    public BuilderException(Exception e) {
        super(e);
    }

    public BuilderException(String message) {
        super(message);
    }

    public BuilderException(String message, Exception e) {
        super(message, e);
    }
}
