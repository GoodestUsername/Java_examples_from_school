import java.util.Iterator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Driver {
    public static <E> void main(String[] args) {
//        MyCustomArrayList<Integer> ints = new MyCustomArrayList<>();
//
//        ints.add(5);
//        ints.add(7);
//
//        for (Integer i : ints) {
//            System.out.println("int: "+i);
//        }
//
//        for(Iterator<Integer> iter = ints.reverseIterator(); iter.hasNext();) {
//            Integer i = iter.next();
//            System.out.println("int: "+i);
//        }
        int MEDIUM = 20;
        int SMALL = 10;
        ArraySet<Integer> testArraySet = new ArraySet<Integer>();
        ArraySet<Integer> otherArraySet = new ArraySet<Integer>();
        Random random = new Random();

        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }

        int removed = 0;

        for (int i = 0; i < SMALL; ++i) {
            if (testArraySet.remove(random.nextInt(MEDIUM))) {
                removed++;
            }
        }
        Object[] arr = testArraySet.toArray();
        System.out.println("arr.length:" + arr.length + "med - removed:" + (MEDIUM - removed));
        assertEquals(arr.length, (MEDIUM - removed));
    }
}