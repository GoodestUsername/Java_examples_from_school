/**
 * InvalidOperationTypeException.
 * @author Eric Dong.
 * @version 1.0
 */
public class InvalidOperationTypeException extends Exception {
    /**
     * Constructor for InvalidOperationTypeException.
     * @param msg Message of exception.
     */
    public InvalidOperationTypeException(final char msg) {
        super(String.valueOf(msg));
    }
}
