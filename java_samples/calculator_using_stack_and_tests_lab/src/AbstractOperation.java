/**
 * Abstract class of operation.
 *
 * @author Eric Dong
 * @version 1.0
 */
abstract class AbstractOperation implements Operation {
    /**
     * Char operation type.
     */
    protected char operationType;
    /**
     * Sets this operation type to entered.
     *
     * @param operationType Char operation.
     */
    AbstractOperation(final char operationType) {
        this.operationType = operationType;
    }
    /**
     * Return operation type.
     *
     * @return Char representing operation type.
     */
    public final char getSymbol() {
        return operationType;
    }
}
