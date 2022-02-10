package ca.bcit.comp2522.lab01;
import java.util.Random;

/**
 * Represents a hare that can race.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class Hare {

    private int position = 0;

    private final Random random = new Random();

    /**
     * Returns position of hare as an int.
     *
     * @return position of hare as an int.
     */
    public int getHarePosition() {
        return this.position;
    }

    /**
     * Sets the position of this hare to a positive integer.
     *
     * @param newPosition the position to set.
     */
    public void setHarePosition(final int newPosition) {
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
        Hare other = (Hare) obj;
        return (other.getHarePosition() == this.getHarePosition());
     }

    /**
     * Retuns new position of hare after it has been moved, hare has a 20% chance not move, 10% chance to move +9
     * , 10% chance to move -12 positions, 30% chance to move 1 position, 30% chance to move -2 positions.
     *
     * @return new position of hare.
     */
    public int move() {
        int hareDecision = random.nextInt(10) + 1;
        switch (hareDecision) {
            case 1, 2 -> setHarePosition(getHarePosition());
            case 3 -> setHarePosition(getHarePosition() + 9);
            case 4 -> setHarePosition(getHarePosition() + -12);
            case 5, 6, 7 -> setHarePosition(getHarePosition() + -1);
            default -> setHarePosition(getHarePosition() + -2);
        }
        return getHarePosition();
    }
}
