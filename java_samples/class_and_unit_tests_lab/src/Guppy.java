import java.util.Objects;

/**
 * Represents a generation of guppies.
 *
 * @author Eric Dong
 * @version 1.0
 */

public class Guppy {

    /**
     * Constant int representing minimum generation number for a fish.
     */
    public static final int FIRST_GENERATION = 0;
    /**
     * Constant int representing max age + 1 in weeks required for a fish to be considered young.
     */
    public static final int MINIMUM_AGE_IN_WEEKS = 0;
    /**
     * Constant int representing the minimum age in weeks for a fish to be a fish.
     */
    public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;
    /**
     * Constant int representing the min age in weeks required for a fish to be considered mature.
     */
    public static final int MATURE_FISH_AGE_IN_WEEKS = 30;
    /**
     * Constant int representing the Maximum age in weeks for a fish.
     */
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;
    /**
     * Constant double representing the minimum water in ML required for a fish.
     */
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;
    /**
     * Default value of genus.
     */
    public static final String DEFAULT_GENUS = "Poecilia";
    /**
     * Default value of genus.
     */
    public static final String DEFAULT_SPECIES = "reticulata";
    /**
     * Default value of healthCoefficient.
     */
    public static final double  DEFAULT_HEALTH_COEFFICIENT = 0.5;
    /**
     * Symbolic Constant double representing the minimum value of healthCoefficient.
     */
    public static final double  MINIMUM_HEALTH_COEFFICIENT = 0.0;
    /**
     * Symbolic Constant double representing the Maximum water in ML required for a fish.
     */
    public static final double  MAXIMUM_HEALTH_COEFFICIENT = 1.0;

    private static int numberOfGuppiesBorn = 0;
    private final String genus;
    private final String species;
    private int ageInWeeks;
    private final boolean isFemale;
    private final int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;

    /**
     * Constructs an object of type Guppy with default values.
     */
    public Guppy() {
        ageInWeeks = MINIMUM_AGE_IN_WEEKS;
        generationNumber = FIRST_GENERATION;
        genus = DEFAULT_GENUS;
        species = DEFAULT_SPECIES;
        isFemale = true;
        isAlive = true;
        healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        incrementNumberOfGuppiesBorn();
    }

    /**
     * Constructs an object of type Guppy with parameter values.
     *
     * @param newGenus a string.
     * @param newSpecies a string.
     * @param newAgeInWeeks an int.
     * @param newIsFemale a boolean.
     * @param newGenerationNumber an int.
     * @param newHealthCoefficient a double.
     */
    public Guppy(final String newGenus, final String newSpecies, final int newAgeInWeeks,
                 final boolean newIsFemale, final int newGenerationNumber,
                 final double newHealthCoefficient) {
        isAlive = true;
        if (checkStringForNullAndEmpty(newGenus)) {
            genus = toTitleCase(newGenus.trim());
        } else {
            genus = DEFAULT_GENUS;
        }
        if (checkStringForNullAndEmpty(newSpecies)) {
            species = newSpecies.toLowerCase().trim();
        } else {
            species = DEFAULT_SPECIES;
        }
        isFemale = newIsFemale;
        handleLogicForAgeInWeeksInConstructor(newAgeInWeeks);
        generationNumber = Math.max(FIRST_GENERATION, newGenerationNumber);
        handleLogicForNewHealthCoefficientInConstructor(newHealthCoefficient);
        incrementNumberOfGuppiesBorn();
    }
    private boolean checkStringForNullAndEmpty(final String str) {
        return str != null && !str.isBlank();
    }
    private void handleLogicForAgeInWeeksInConstructor(final int newAgeInWeeks) {
        if (MINIMUM_AGE_IN_WEEKS > newAgeInWeeks) {
            ageInWeeks = MINIMUM_AGE_IN_WEEKS;
        } else {
            ageInWeeks = Math.min(newAgeInWeeks, MAXIMUM_AGE_IN_WEEKS);
        }
    }

    private void handleLogicForNewHealthCoefficientInConstructor(
            final double newHealthCoefficient) {
        if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        } else if (MINIMUM_HEALTH_COEFFICIENT > newHealthCoefficient) {
            isAlive = false;
            healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
        } else {
            healthCoefficient = newHealthCoefficient;
        }
    }

    private String toTitleCase(final String str) {
        if (str.isBlank()) {
            return str;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }
        StringBuilder titleCase = new StringBuilder();
        char firstChar = Character.toUpperCase(str.charAt(0));
        titleCase.append(firstChar);
        titleCase.append(str.substring(1).toLowerCase());
        return titleCase.toString();
    }
    private void incrementNumberOfGuppiesBorn() {
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
    }

    /**
     * Increment ageInWeeks by 1, then sets isAlive to false if ageInWeeks
     * is greater than MATURE_FISH_AGE_IN_WEEKS.
     *
     */
    public void incrementAge() {
        if (ageInWeeks > MATURE_FISH_AGE_IN_WEEKS) {
            isAlive = false;
        } else {
            ageInWeeks++;
        }
    }
    /**
     * Return minimum generation number as an int.
     *
     * @return minimum generation number.
     */
    public static int getFirstGeneration() {
        return FIRST_GENERATION;
    }
    /**
     * Return minimum age in weeks as an int.
     *
     * @return minimum age in weeks.
     */
    public static int getMinimumAgeInWeeks() {
        return MINIMUM_AGE_IN_WEEKS;
    }

    /**
     * Return genus of fish as string.
     *
     * @return genus of fish.
     */
    public String getGenus() {
        return genus;
    }

    /**
     * Return species of fish as string.
     *
     * @return species of fish.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Return ageInWeeks as int.
     *
     * @return ageInWeeks.
     */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    /**
     * Set the ageInWeeks to parameter if its less than the maximum and more than 0.
     *
     * @param ageInWeeks ageInWeeks as an int to set.
     */
    public void setAgeInWeeks(final int ageInWeeks) {
        if (isAlive & MAXIMUM_AGE_IN_WEEKS >= ageInWeeks & ageInWeeks >= MINIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = ageInWeeks;
        }
    }

    /**
     * Return isFemale as bool.
     *
     * @return isFemale.
     */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * Return generationNumber as an int.
     *
     * @return generationNumber.
     */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * Return isAlive as bool.
     *
     * @return isAlive.
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * Set isAlive to false if isAlive is true and passed parameter is false, do nothing otherwise.
     * @param isAlive boolean.
     */
    public void setIsAlive(final boolean isAlive) {
        if (this.isAlive) {
            this.isAlive = isAlive;
        }
    }

    /**
     * Return healthCoefficient as a double.
     *
     * @return healthCoefficient.
     */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    /**
     * Set healthCoefficient to parameter if its greater than the minimum and less than the maximum.
     *
     * @param healthCoefficient double to set healthCoefficient to.
     */
    public void setHealthCoefficient(final double healthCoefficient) {
        if (isAlive & healthCoefficient >= MINIMUM_HEALTH_COEFFICIENT
                & MAXIMUM_HEALTH_COEFFICIENT >= healthCoefficient) {
            this.healthCoefficient = healthCoefficient;
        }
    }

    /**
     * Return identificationNumber as an int.
     *
     * @return identificationNumber.
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Return numberOfGuppiesBorn as an int.
     *
     * @return numberOfGuppiesBorn.
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * Return the volume of water needed as a double in millimeters depending on ageInWeeks value.
     *
     * @return water needed based on the size of ageInWeeks.
     */
    public double getVolumeNeeded() {
        final double maxAgeWaterMultiplier = 1.5;
        final double waterVolumeForDeadFish = 0.0;

        if (!isAlive) {
            return waterVolumeForDeadFish;
        } else if (YOUNG_FISH_AGE_IN_WEEKS > ageInWeeks) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (MATURE_FISH_AGE_IN_WEEKS >= ageInWeeks) {
            return MINIMUM_WATER_VOLUME_ML * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;
        } else {
            return MINIMUM_WATER_VOLUME_ML * maxAgeWaterMultiplier;
        }
    }

    /**
     * Set the healthCoefficient to itself + parameter, sets isAlive to false
     * depending on value of parameter.
     *
     * @param delta double to add to healthCoefficient.
     */
    public void changeHealthCoefficient(final double delta) {
        healthCoefficient += delta;
        if (MINIMUM_HEALTH_COEFFICIENT >= healthCoefficient) {
            healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
            isAlive = false;
        } else if (healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        }
    }

    /**
     * Return this object represented as a string.
     *
     * @return This objects variables as a string.
     */
    @Override
    public String toString() {
        return "Guppy{"
                + "genus='" + genus + '\''
                + ", species='" + species + '\''
                + ", ageInWeeks=" + ageInWeeks
                + ", isFemale=" + isFemale
                + ", generationNumber=" + generationNumber
                + ", isAlive=" + isAlive
                + ", healthCoefficient=" + healthCoefficient
                + ", identificationNumber=" + identificationNumber
                + '}';
    }

    /**
     * Return true if parameter is equal to this object, false otherwise.
     *
     * @param obj an object to compare equality.
     *
     * @return true if parameter is equivalent to this object, false otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj.getClass() == this.getClass())) {
            return false;
        }
        Guppy other = (Guppy) obj;
        return ageInWeeks == other.ageInWeeks
                && isFemale == other.isFemale
                && isAlive == other.isAlive
                && Double.compare(other.healthCoefficient, healthCoefficient) == 0
                && Objects.equals(genus, other.genus)
                && Objects.equals(species, other.species);
    }

    /**
     * Returns a hashCode for this object.
     *
     * @return hashCode as an int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(genus, species, ageInWeeks, isFemale, isAlive, healthCoefficient);
    }
}
