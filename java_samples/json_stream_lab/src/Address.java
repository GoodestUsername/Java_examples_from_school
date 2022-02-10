import java.util.Objects;
import java.util.Random;

/**
 * Address object.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class Address {
    private static final int HOUSE_NUM_BOUNDARY = 10001;
    private static final int STREET_NUM_BOUNDARY = 101;
    private static final int POSTAL_NUM_BOUNDARY = 10;
    private int houseNumber;
    private String streetName;
    private String city;
    private String province;
    private String country;
    private String postalCode;

    /**
     * Constructor with no parameters.
     */
    public Address() {
    }

    /**
     * Constructor with all parameters.
     * @param houseNumber House number as int.
     * @param streetName Street name as String.
     * @param city City name as String.
     * @param province Province name as String.
     * @param country Country name as String.
     * @param postalCode Postal Code as String.
     */
    public Address(final int houseNumber, final String streetName, final String city,
            final String province, final String country, final String postalCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.province = province;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }
    /**
     * Returns house number as int.
     * @return House number.
     */
    public int getHouseNumber() {
        return houseNumber;
    }
    /**
     * Sets the house number.
     * @param houseNumber New house number.
     */
    public void setHouseNumber(final int houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Gets the street name.
     * @return Street name as String.
     */
    public String getStreetName() {
        return streetName;
    }
    /**
     * Sets the street name.
     * @param streetName The new street name.
     */
    public void setStreetName(final String streetName) {
        this.streetName = streetName;
    }
    /**
     * Gets the city name.
     * @return city name as String.
     */
    public String getCity() {
        return city;
    }
    /**
     * Sets the city name.
     * @param city New city name.
     */
    public void setCity(final String city) {
        this.city = city;
    }
    /**
     * Gets the province name.
     * @return Province name as string.
     */
    public String getProvince() {
        return province;
    }
    /**
     * Sets the province name.
     * @param province New province name.
     */
    public void setProvince(final String province) {
        this.province = province;
    }
    /**
     * Gets the country name.
     * @return Country name as string.
     */
    public String getCountry() {
        return country;
    }
    /**
     * Sets the country.
     * @param country New country as string.
     */
    public void setCountry(final String country) {
        this.country = country;
    }
    /**
     * Gets the postal code.
     * @return Gets the postal code.
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * Sets the postal code.
     * @param postalCode The postal code to set.
     */
    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }
    /**
     * String representation of address.
     * @return String representation of address.
     */
    @Override
    public java.lang.String toString() {
        return "Address{"
                + "houseNumber=" + houseNumber
                + ", streetName='" + streetName + '\''
                + ", city='" + city + '\''
                + ", province='" + province + '\''
                + ", country='" + country + '\''
                + ", postalCode='" + postalCode + '\''
                + '}';
    }
    /**
     * Compares equality of this object.
     * @param o Object to compare to.
     * @return Boolean value of equality comparison.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return houseNumber == address.houseNumber
                && Objects.equals(streetName, address.streetName)
                && Objects.equals(city, address.city)
                && Objects.equals(province, address.province)
                && Objects.equals(country, address.country)
                && Objects.equals(postalCode, address.postalCode);
    }
    /**
     * Returns hash code of object.
     * @return Integer hashCode of object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(houseNumber, streetName, city, province, country, postalCode);
    }

    /**
     * Returns address with random city, house number, city, and postal code.
     * @return Random Address object.
     */
    public Address getRandomAddress() {
        Random random = new Random();
        String city = random.nextBoolean() ? "Vancouver" : "Richmond";
        String postalCode =
                  "V" + random.nextInt(POSTAL_NUM_BOUNDARY) + "T"
                  + random.nextInt(POSTAL_NUM_BOUNDARY) + "R" + random.nextInt(POSTAL_NUM_BOUNDARY);
        return new Address(random.nextInt(HOUSE_NUM_BOUNDARY),
                random.nextInt(STREET_NUM_BOUNDARY) + " St.",
                city, "BC", "Canada", postalCode);
    }
}
