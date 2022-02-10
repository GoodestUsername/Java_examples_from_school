package ca.bcit.comp2522.lab01;

/**
 * Represents multiple races between a tortoise and a hare.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class Driver {

    /**
     *
     *
     * @param races Positive integer that represents amount of times to race.
     * @param length Positive integer that represents length of race track.
     * @return Return a formatted string that details who won the race the most, and how many times each animal won.
     */
    public static String simulateRaces(final int races, final int length) {

        Race race = new Race(length);
        int hareWins = 0;
        int tortoiseWins = 0;

        for (int racesCompleted = 0; races > racesCompleted; racesCompleted++) {
            if (race.simulateRace().equals("Hare")) {
                hareWins++;
            } else {
                tortoiseWins++;
            }
        }

        String winnerOfMostRaces = hareWins > tortoiseWins ? "Hare" : "Tortoise";

        return winnerOfMostRaces + " won most of the time, Hare won " + hareWins + " times, Tortoise won "
                + tortoiseWins + " times " + ", all races took " + race.getRaceClock() + " clock ticks to elapse.";
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println(simulateRaces(1, 100));
        System.out.println(simulateRaces(100, 100));
        System.out.println(simulateRaces(100, 1000));
    }
}
