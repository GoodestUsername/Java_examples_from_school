package ca.bcit.comp2522.lab01;
import java.util.Random;

/**
 * Represents a race between a tortoise and a hare.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class Race {

    private final Hare hare;
    private final Tortoise tortoise;
    private final Random random = new Random();
    private final int distance;
    private int raceClock = 0;

    /**
     * Constructs an object of type race.
     *
     * @param distance a positive integer.
     */
    public Race(final int distance) {
        this.distance = distance;
        this.hare = new Hare();
        this.tortoise = new Tortoise();
    }

    /**
     * Returns the ticks of the race clock as an integer.
     *
     * @return race clock ticks as an integer.
     */
    public int getRaceClock() { return this.raceClock; }

    /**
     * Sets the clock rate for this Clock.
     *
     * @param raceClock the clock time to set.
     */
    public void setRaceClock(int raceClock) { this.raceClock = raceClock; }


    /**
     * Returns the distance as an integer.
     *
     * @return the distance as an integer.
     */
    public int getDistance() { return this.distance; }

    /**
     * Resets position of hare and tortoise to 0.
     *
     */
    public void reset() {
        hare.setHarePosition(0);
        tortoise.setTortoisePosition(0);
    }

    private String checkHareOrTortoiseWon() {
        if (hare.getHarePosition() > tortoise.getTortoisePosition()) {
            return "Hare";
        }
        else {
            return "Tortoise";
        }
    }

    private boolean isRaceIsOver() {
        return hare.getHarePosition() > getDistance() || tortoise.getTortoisePosition() > getDistance();
    }

    private String race () {
        while (!isRaceIsOver()) {
            boolean hareGoesFirst = random.nextBoolean();
            if (hareGoesFirst) {
                hare.move();
                setRaceClock(getRaceClock() + 1);
                if (isRaceIsOver()) { return checkHareOrTortoiseWon(); }
                tortoise.move();
            }
            else {
                tortoise.move();
                setRaceClock(getRaceClock() + 1);
                if (isRaceIsOver()) { return checkHareOrTortoiseWon(); }
                hare.move();
            }
        }
        return checkHareOrTortoiseWon();
    }

    /**
     * Simulates a race between a tortoise and a hare.
     *
     * @return Winner as a string.
     */
    public String simulateRace() {
        reset();
        return race();
    }
}
