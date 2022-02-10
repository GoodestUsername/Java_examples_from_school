/**
 * Addition operation.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class AdditionOperation extends AbstractOperation {
    private static final char ADDITION_CODE = '+';
    /**
     * Constructor.
     */
    public AdditionOperation() {
        super(ADDITION_CODE);
    }
    /**
     * Returns the result of the addition operation as an int.
     *
     * @param operandA First operand.
     * @param operandB Second operand.
     * @return Integer result of the operation.
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA + operandB;
    }
}
