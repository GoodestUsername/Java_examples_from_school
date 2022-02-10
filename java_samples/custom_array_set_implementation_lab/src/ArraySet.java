import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * ArraySet implementation implemented using Set<E>.
 *
 * @author Eric Dong
 * @version 1.0
 * @param <E> Type.
 */
public class ArraySet<E> implements Set<E> {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * The capacity.
     */
    private int capacity = DEFAULT_CAPACITY;
    /**
     * The arraySet itself.
     */
    private E[] myData;
    /**
     * The size of the ArrayList (the number of elements it contains).
     *
     */
    private int size = 0;
    /**
     * Constructs an empty ArraySet with an initial capacity of ten.
     */
    @SuppressWarnings("unchecked")
    public ArraySet() {
        this.myData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Returns the number of elements in the arraySet.
     * @return Number of elements in the arraySet as an int.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns whether or not the arraySet is empty.
     * @return Whether the arraySet is empty or not.testContainsReturnsTrueSmallSetInLargeSet
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds the  element to the arraySet.
     * @param e The element to add.
     * @return Whether or not the add was successful.
     */
    @Override
    public boolean add(final E e) {
        if (e == null) {
            throw new IllegalArgumentException("Cannot add NULL");
        }
        if (size != 0 && capacity == size) {
            this.capacity *= 2;
            this.myData = Arrays.copyOf(myData, capacity);
        }
        if (!contains(e)) {
            this.myData[size] = e;
            this.size += 1;
            return true;
        }
        return false;
    }

    /**
     * Removes the inputted object from the arraySet.
     * @param o The object to remove.
     * @return Whether or not the operation was successful.
     */
    @Override
    public boolean remove(final Object o) {
        if (size != 0) {
            for (int i = 0; i != size; i++) {
                if (myData[i].equals(o)) {
                    myData[i] = myData[size - 1];
                    size -= 1;
                    this.myData = Arrays.copyOf(myData, capacity);
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Clears the arraySet.
     */
    @Override
    public void clear() {
        this.myData = Arrays.copyOf(myData, 0);
        size = 0;
    }
    /**
     * Checks if the arraySet contains the specified element.
     * @param o The object to check for.
     * @return Whether or not the element is in the arraySet.
     */
    @Override
    public boolean contains(final Object o) {
        if (size != 0) {
            for (int i = 0; i != size; i++) {
                if (myData[i].equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Returns an iterator for the arraySet.
     * @return The iterator for the arraySet.
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                E nextObject = myData[currentIndex];
                currentIndex++;
                return nextObject;
            }
        };
        return iterator;
    }
    /**
     * Returns an array of objects version of the arraySet.
     * @return Array of objects version of the arraySet.
     */
    @Override
    public Object[] toArray() {
        return (Object[]) Arrays.copyOf(myData, size);
    }
    /**
     * Array of primitive types version of the arraySet.
     *
     * @param a The array to put the arraySet elements into.
     * @param <T> The type of primitive of the array.
     * @return The array of primitives.
     */
    @Override
    public <T> T[] toArray(final T[] a) {
        for (int i = 0; i != size; i++) {
            a[i] = (T) myData[i];
        }
        return a;
    }
    /**
     * Checks if the arraySet contains all the elements of the passed in collection.
     * @param c The collection to check for.
     * @return Whether or not it contains all the elements in the collection.
     */
    @Override
    public boolean containsAll(final Collection<?> c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Adds all the elements in the collection to the arraySet.
     *
     * @param c The collection.
     * @return Whether all the elements were added in.
     */
    @Override
    public boolean addAll(final Collection<? extends E> c) {
        for (E elem : c) {
            if (!add(elem)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Removes all elements in arraySet that are not in the collection.
     * @param c The collection.
     * @return Whether or not any element was not removed.
     */
    @Override
    public boolean retainAll(final Collection<?> c) {
        boolean retainedAll = true;
        int oldSize = size;
        for (int i = 0; i != oldSize; i++) {
            if (!c.contains(myData[i])) {
                remove(myData[i]);
                retainedAll = false;
            }
        }
        return retainedAll;
    }
    /**
     * Removes all elements from arraySet that are in the collection.
     * @param c the collection.
     * @return Whether or not all the matching elements have been removed from the arraySet.
     */
    @Override
    public boolean removeAll(final Collection<?> c) {
        boolean removedAll = true;
        int oldSize = size;
        for (int i = 0; i != oldSize; i++) {
            if (c.contains(myData[i])) {
                remove(myData[i]);
            } else {
                removedAll = false;
            }
        }
        return removedAll;
    }
}
