package ca.bcit.comp2522.finalexam.q3;

import java.util.Collections;
import java.util.HashSet;

public class MovieOrder {
    private static final int NUMBER_OF_ADULTS_IN_FAMILY = 2;
    private static final int MIN_NUMBER_OF_CHILDREN_IN_FAMILY = 1;
    private static final int MAX_NUMBER_OF_CHILDREN_IN_FAMILY = 1;

    public enum DayType {
        NORMAL,
        DISCOUNT
    }
    public enum DayOfWeek {
        MONDAY (DayType.NORMAL),
        TUESDAY (DayType.DISCOUNT),
        WEDNESDAY (DayType.DISCOUNT),
        THURSDAY (DayType.DISCOUNT),
        FRIDAY (DayType.NORMAL),
        SATURDAY (DayType.NORMAL),
        SUNDAY (DayType.NORMAL);

        private DayType type;

        private DayOfWeek(DayType aType) {
            type = aType;
        }
        public boolean isDiscount() {
            return type == DayType.DISCOUNT;
        }
    }

    private HashSet<Coupon> coupons;
    private HashSet<Person> people;
    private DayOfWeek day;

    public MovieOrder(DayOfWeek aDay) {
        people = new HashSet<>();
        coupons = new HashSet<>();
        day = aDay;
    }

    public void addCoupon(Coupon aCoupon) {
        coupons.add(aCoupon);
    }

    public void addPerson(Person aPerson) {
        people.add(aPerson);
    }

    public boolean isDiscountDay(DayOfWeek day) {
        return day.isDiscount();
    }

    public boolean isFamily(long adults, long children) {
        return adults == NUMBER_OF_ADULTS_IN_FAMILY
                && children >= MIN_NUMBER_OF_CHILDREN_IN_FAMILY
                && children <= MAX_NUMBER_OF_CHILDREN_IN_FAMILY;
    }

    public boolean doesOrderContainWildChildren(long adults, long children) {
        return children != 0 && adults == 0;
    }

    public double getMaxCouponDiscount() {
        double maxCouponDiscount = 0;

        for (Coupon coupon : coupons) {
            if (coupon.getAmountOff() > maxCouponDiscount) {
                maxCouponDiscount = coupon.getAmountOff();
            }
        }
        return maxCouponDiscount;
    }

    public long getNumberOfYouth() {
        return people.stream().filter(Person::isYouth).count();
    }

    public long getNumberOfChildren() {
        return people.stream().filter(Person::isChild).count();
    }

    public long getNumberOfAdults() {
        return people.stream().filter(Person::isAdult).count();
    }

    public long getNumberOfSeniors() {
        return people.stream().filter(Person::isSenior).count();
    }

    public long getNumberOfStudents() {
        return people.stream().filter(Person::isStudent).count();
    }

    public double getTotalPrice(long children, long adults, long seniors, long students, long youth) {
        long total = 0;

        if (isDiscountDay(day)) {
            total += adults * MoviePrice.ADULT_DISCOUNT_DAY_PRICE;
        }
        else {
            total += adults * MoviePrice.ADULT_PRICE;
        }
        return total + children * MoviePrice.CHILD_PRICE
                + seniors * MoviePrice.SENIOR_PRICE
                + students * MoviePrice.STUDENT_PRICE
                + youth * MoviePrice.YOUTH_PRICE;
    }

    public double calculatePrice() throws StrayChildrenException {
        double total = 0;

        long children = getNumberOfChildren();
        long youth = getNumberOfYouth();
        long adults = getNumberOfAdults();
        long seniors = getNumberOfSeniors();
        long students = getNumberOfStudents();
        long responsibleAdults = adults + seniors;

        if (doesOrderContainWildChildren(responsibleAdults, children)){
            throw new StrayChildrenException("Call Social Services!");
        }

        if (isFamily(adults, children) && !isDiscountDay(day)) {
            total = MoviePrice.FAMILY_PRICE;
            adults -= NUMBER_OF_ADULTS_IN_FAMILY;
            children = 0;
        }
        total = total + getTotalPrice(children, adults, seniors, students, youth) - getMaxCouponDiscount();
        if (0 > total) {
            return 0;
        }
        return total;
    }
}
