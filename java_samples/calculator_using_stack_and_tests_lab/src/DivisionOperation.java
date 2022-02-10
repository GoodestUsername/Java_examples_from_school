/**
 * Division operation.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class DivisionOperation extends AbstractOperation {
    private static final char DIVISION_CODE = '/';
    /**
     * Constructor.
     */
    public DivisionOperation() {
        super(DIVISION_CODE);
    }
    /**
     * Returns the result of the division operation as an int.
     *
     * @param operandA First operand.
     * @param operandB Second operand.
     * @return Integer result of the operation.
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA / operandB;
    }
}
