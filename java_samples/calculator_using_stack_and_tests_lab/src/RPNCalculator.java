import java.util.Scanner;

/**
 * RPN calculator.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class RPNCalculator {
    /**
     * Integer representing the minimum stack size.
     */
    protected static final int MIN_STACK_SIZE = 2;
    private final Stack stack;
    private final int emptyStackSize = 0;

    /**
     * Constructor.
     *
     * @param stackSize Integer number to set the stack size.
     * @throws IllegalArgumentException when stackSize is les than 2.
     */
    public RPNCalculator(final int stackSize) throws IllegalArgumentException {
        if (MIN_STACK_SIZE > stackSize) {
            throw new IllegalArgumentException("Stack size needs to be 2 or greater");
        } else {
            stack = new Stack(stackSize);
        }
    }

    /**
     * Calculate inputted equation and return the result.
     *
     * @param formula String containing the equation to calculate.
     * @return Result of the equations.
     * @throws InvalidOperationTypeException Thrown if a operator that is not + - * / is entered.
     * @throws StackUnderflowException Thrown if stack size is more than number of operands entered.
     * @throws StackOverflowException Thrown if stack size is less than number of operands entered.
     * @throws IllegalArgumentException Thrown if argument is empty.
     */
    public int processFormula(final String formula) throws InvalidOperationTypeException,
            StackUnderflowException, StackOverflowException, IllegalArgumentException {
        Operation operation;
        if (formula == null || formula.length() == emptyStackSize) {
            throw new IllegalArgumentException("Length must be greater than 0, and cannot be null");
        }
        Scanner scanner = new Scanner(formula);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                push(scanner.nextInt());
            } else {
            operation = getOperation(scanner.next().charAt(0));
            perform(operation);
            getResult();
            }
        }
    return stack.peek();
    }

    /**
     * Pushes int operand on top of stack.
     *
     * @param operand Integer operand.
     * @throws StackOverflowException Thrown if no room is available on stack.
     */
    protected void push(final int operand) throws StackOverflowException {
        if (stack.unused() == emptyStackSize) {
            throw new StackOverflowException("no space available on stack");
        }
        stack.push(operand);
    }

    /**
     * Returns Object that performs the operation indicated by symbol.
     *
     * @param symbol Char representing the operator.
     * @return Operation arithmetic operator object that corresponds to char entered.
     * @throws InvalidOperationTypeException Throws when an invalid char is entered.
     */
    protected Operation getOperation(final char symbol) throws InvalidOperationTypeException {
        return switch (symbol) {
            case '+' -> new AdditionOperation();
            case '-' -> new SubtractionOperation();
            case '*' -> new MultiplicationOperation();
            case '/' -> new DivisionOperation();
            default -> throw new InvalidOperationTypeException(symbol);
        };
    }

    /**
     * Returns Integer at the top of the stack.
     *
     * @return Integer number at the top of the stack.
     * @throws StackUnderflowException Throws if stack is empty.
     */
    public int getResult() throws StackUnderflowException {
        if (stack.size() == emptyStackSize) {
            throw new StackUnderflowException("There are no operands!");
        }
        return stack.peek();
    }

    /**
     * Performs the latest operation in equation.
     *
     * @param operation Type of operation to perform.
     * @throws StackUnderflowException Thrown if stack is empty.
     * @throws IllegalArgumentException Thrown if operation is null.
     */
    protected void perform(final Operation operation) throws IllegalArgumentException,
            StackUnderflowException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        int secondOperand = stack.pop();
        int firstOperand = stack.pop();
        int result = operation.perform(firstOperand, secondOperand);
        stack.push(result);
    }
    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     *
     * Example usage: RPNCalculator 10 "1 2 +"
     *
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     *               to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) {

        // Checks for correct number of command line arguments.
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }

        // Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);

        try {
            System.out.println("[" + argv[1] + "] = "
                    + calculator.processFormula(argv[1]));
        } catch (final InvalidOperationTypeException ex) {
            System.err.println("formula can only contain integers, +, -, *, and /");
        } catch (final StackOverflowException ex) {
            System.err.println("too many operands in the formula, increase the stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }
}
