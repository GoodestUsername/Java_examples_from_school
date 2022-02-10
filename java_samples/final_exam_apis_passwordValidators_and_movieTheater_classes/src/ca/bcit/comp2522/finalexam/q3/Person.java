package ca.bcit.comp2522.finalexam.q3;

public class Person {
    private int age;
    private boolean hasStudentID;

    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 120;

    private static final int MIN_STUDENT_AGE = 17;
    private static final int MAX_STUDENT_AGE = 25;

    private static final int INFANT_AGE = 5;
    private static final int CHILD_AGE = 12;
    private static final int YOUTH_AGE = 18;
    private static final int SENIOR_AGE = 65;

    public Person(final int anAge) {
        if (MIN_AGE > anAge || anAge > MAX_AGE) {
            throw new IllegalArgumentException ("Too young or too old!");
        }
        this.age = anAge;
    }

    public void setHasStudentID(boolean studentID) {
        if (MAX_STUDENT_AGE >= age && age >= MIN_STUDENT_AGE) {
            hasStudentID = studentID;
        }
        else {
            hasStudentID = false;
        }
    }

    public boolean isStudent() {
        return hasStudentID;
    }

    public boolean isChild() {
        return age <= CHILD_AGE && age > INFANT_AGE;
    }
    public boolean isYouth() {
        return age <= YOUTH_AGE && age > CHILD_AGE && !hasStudentID;
    }
    public boolean isInfant() {
        return age <= INFANT_AGE;
    }
    public boolean isSenior() {
        return age >= SENIOR_AGE;
    }
    public boolean isAdult() {
        return age > YOUTH_AGE && age < SENIOR_AGE;
    }
}
