package ca.bcit.comp2522.lab01;
import java.util.Random;

/**
 * Represents a tortoise that can race.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class Tortoise {

    private int position = 0;

    private final Random random = new Random();

    /**
     * Returns position of tortoise as an int.
     *
     * @return position of tortoise as an int.
     */
    public int getTortoisePosition() {
        return this.position;
    }

    /**
     * Sets the position of this tortoise to a positive integer.
     *
     * @param newPosition the position to set.
     */
    public void setTortoisePosition(final int newPosition) {
        this.position = newPosition;
    }

    /**
     * Returns boolean of whether this object and another object is the same.
     *
     * @param obj Object to check.
     * @return Boolean, true if the same, false if not.
     */
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (this == obj) { return true; }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Tortoise other = (Tortoise) obj;
        return (other.getTortoisePosition() == this.getTortoisePosition());
    }

    /**
     * Retuns new position of tortoise after it has been moved, tortoise has a 90% chance to move 4 up, 10% chance 1 up.
     *
     * @return new position of tortoise.
     */
    public int move() {
        int TortoiseDecision = random.nextInt(10) + 1;
        switch (TortoiseDecision) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9 -> setTortoisePosition(getTortoisePosition() + 4);
            default -> setTortoisePosition(getTortoisePosition() + 1);
        }
        return getTortoisePosition();
    }
}
