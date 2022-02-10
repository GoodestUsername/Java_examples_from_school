/**
 * Interface of operation.
 *
 * @author Eric Dong
 * @version 1.0
 */
public interface Operation {
    /**
     * Returns the symbol of the operation.
     *
     * @return Char symbol of the operation.
     */
    char getSymbol();

    /**
     * Performs the operation.
     *
     * @param operandA First operand.
     * @param operandB Second operand.
     * @return Result of the operation.
     */
    int perform(int operandA, int operandB);
}
