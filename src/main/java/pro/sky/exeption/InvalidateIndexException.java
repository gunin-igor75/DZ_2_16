package pro.sky.exeption;

public class InvalidateIndexException extends RuntimeException{
    public InvalidateIndexException() {
    }

    public InvalidateIndexException(String message) {
        super(message);
    }

    public InvalidateIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidateIndexException(Throwable cause) {
        super(cause);
    }

    public InvalidateIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
