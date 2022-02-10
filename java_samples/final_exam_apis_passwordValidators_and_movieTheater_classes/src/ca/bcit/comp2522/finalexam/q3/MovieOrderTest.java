package ca.bcit.comp2522.finalexam.q3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MovieOrderTest {

    private static final String TEST_VERSION = "V1.1";
    private static final int FAMILY_PASS_PRICE = 50;

    private static final int INFANT_AGE_FOR_UNIT_TESTS = 1;
    private static final int CHILD_AGE_FOR_UNIT_TESTS = 7;
    private static final int YOUTH_AGE_FOR_UNIT_TESTS = 14;
    private static final int ADULT_AGE_FOR_UNIT_TESTS = 19;
    private static final int SENIOR_AGE_FOR_UNIT_TESTS = 66;
    private static final int STUDENT_AGE_FOR_UNIT_TESTS = 18;

    @Test
    public void testGivesLargestDiscount() throws StrayChildrenException {
        MovieOrder order = new MovieOrder(MovieOrder.DayOfWeek.FRIDAY);

        Person student = new Person(STUDENT_AGE_FOR_UNIT_TESTS);
        student.setHasStudentID(true);

        order.addPerson(student);

        order.addCoupon(new Coupon(0.5));
        order.addCoupon(new Coupon(10));
        assertEquals(2.50, order.calculatePrice());
    }

    @Test
    public void testStudent() throws StrayChildrenException {
        MovieOrder order = new MovieOrder(MovieOrder.DayOfWeek.FRIDAY);

        Person student = new Person(STUDENT_AGE_FOR_UNIT_TESTS);
        student.setHasStudentID(true);
        order.addPerson(student);

        assertEquals(12.50, order.calculatePrice());
    }

    @Test
    public void testStudentWithYouth() throws StrayChildrenException {
        MovieOrder order = new MovieOrder(MovieOrder.DayOfWeek.FRIDAY);

        Person student = new Person(STUDENT_AGE_FOR_UNIT_TESTS);
        student.setHasStudentID(true);

        Person youth = new Person(YOUTH_AGE_FOR_UNIT_TESTS);

        order.addPerson(youth);
        order.addPerson(student);

        assertEquals(25.50, order.calculatePrice());
    }
    @Test
    public void testAdultAndChild() throws StrayChildrenException {
        MovieOrder order = new MovieOrder(MovieOrder.DayOfWeek.FRIDAY);
        order.addPerson(new Person(CHILD_AGE_FOR_UNIT_TESTS));
        order.addPerson(new Person(ADULT_AGE_FOR_UNIT_TESTS));

        assertEquals(30, order.calculatePrice());
    }
    @Test
    public void testFamilyPassForDiscountDays() throws StrayChildrenException {
        MovieOrder order = new MovieOrder(MovieOrder.DayOfWeek.TUESDAY);
        order.addPerson(new Person(CHILD_AGE_FOR_UNIT_TESTS));
        order.addPerson(new Person(ADULT_AGE_FOR_UNIT_TESTS));
        order.addPerson(new Person(ADULT_AGE_FOR_UNIT_TESTS));

        assertEquals(30, order.calculatePrice());
    }
    @Test
    public void testFamilyPassForNoAdditionalFamilyMembers() throws StrayChildrenException {
        MovieOrder order = new MovieOrder(MovieOrder.DayOfWeek.FRIDAY);
        order.addPerson(new Person(CHILD_AGE_FOR_UNIT_TESTS));
        order.addPerson(new Person(ADULT_AGE_FOR_UNIT_TESTS));
        order.addPerson(new Person(ADULT_AGE_FOR_UNIT_TESTS));

        assertEquals(FAMILY_PASS_PRICE, order.calculatePrice());
    }
    @Test
    public void testFamilyPassForAdditionalFamilyMembers() throws StrayChildrenException {
        MovieOrder order = new MovieOrder(MovieOrder.DayOfWeek.SUNDAY);
        order.addPerson(new Person(CHILD_AGE_FOR_UNIT_TESTS));
        order.addPerson(new Person(ADULT_AGE_FOR_UNIT_TESTS));
        order.addPerson(new Person(ADULT_AGE_FOR_UNIT_TESTS));
        order.addPerson(new Person(SENIOR_AGE_FOR_UNIT_TESTS));

        assertEquals(60, order.calculatePrice());
    }
    @Test
    public void testBadGroupTooYoung() {
        MovieOrder order = new MovieOrder(MovieOrder.DayOfWeek.FRIDAY);
        order.addPerson(new Person(10));
        order.addPerson(new Person(8));

        Exception exception = assertThrows(StrayChildrenException.class, () -> {
                    order.calculatePrice();
                }
        );
    }

}
