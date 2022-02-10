/**
 * Stack of integers.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class Stack {
    private static final int MIN_ARRAY_SIZE = 1;
    private final int[]stackValues;
    private int count;
    private final int initialCount = 0;
    private final int initialCountOffset = MIN_ARRAY_SIZE;
    /**
     * Constructor for stack.
     *
     * @param arraySize Size of array to initialize.
     * @throws IllegalArgumentException Thrown if array size is less than 1.
     */
    public Stack(final int arraySize) throws IllegalArgumentException {
        if (MIN_ARRAY_SIZE > arraySize) {
            throw new IllegalArgumentException("Array must be greater than 1");
        }
        this.stackValues = new int[arraySize];
        this.count = initialCount;
    }

    /**
     * Returns the capacity of stack.
     *
     * @return Integer value of stack capacity.
     */
    public int capacity() {
        return stackValues.length;
    }

    /**
     * Return integer of how many items are in stack.
     *
     * @return How many items are in stack.
     */
    public int size() {
        return count;
    }

    /**
     * Return unused slots in stack as int.
     *
     * @return unused slots in stack as int
     */
    public int unused() {
        return stackValues.length - count;
    }

    /**
     * Pushes the passed in value on top of stack.
     * @param value Integer to push on top of stack.
     * @throws StackOverflowError Thrown if stack is full.
     */
    public void push(final int value) throws StackOverflowError {
        if (stackValues.length == count) {
            throw new StackOverflowError("this stack is full!");
        }
        stackValues[count] = value;
        count++;
    }

    /**
     * Returns top of stack and decrements count.
     *
     * @return Integer at the top of stack.
     * @throws StackUnderflowException Thrown if stack is empty.
     */
    public int pop() throws StackUnderflowException {
        if (count == initialCount) {
            throw new StackUnderflowException("Cannot call Stack.pop() on empty stack!");
        }
        int temp = stackValues[count - initialCountOffset];
        count--;
        return temp;
    }

    /**
     * Returns top of stack.
     *
     * @return Integer at the top of stack.
     * @throws StackUnderflowException Thrown when stack is empty.
     */
    public int peek() throws StackUnderflowException {
        if (count == initialCount) {
            throw new StackUnderflowException("Cannot call Stack.pop() on empty stack!");
        }
        return stackValues[count - initialCountOffset];
    }
}
