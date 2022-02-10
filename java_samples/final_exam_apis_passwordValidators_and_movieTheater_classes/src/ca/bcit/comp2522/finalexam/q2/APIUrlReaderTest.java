package ca.bcit.comp2522.finalexam.q2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit tests for APIUrlReader
 *
 */
public class APIUrlReaderTest {

    private final long TOTAL_APIS = 650;
    private final long COUNT_NO_AUTH = 306;
    private final long COUNT_HTTPS = 563;
    private final long COUNT_ANIMAL_APIS = 13;

    @Test
    public void testTotal() {
        APIUrlReader reader = new APIUrlReader();

        assertEquals(TOTAL_APIS, reader.getCountAPIs());
    }

    @Test
    public void testCountNoAuth() {
        APIUrlReader reader = new APIUrlReader();

        assertEquals(COUNT_NO_AUTH, reader.getCountNoAuth());
    }

    @Test
    public void testCountHTTPS() {
        APIUrlReader reader = new APIUrlReader();

        assertEquals(COUNT_HTTPS, reader.getCountHTTPS());
    }

    @Test
    public void testCountAnimalAPIs() {
        APIUrlReader reader = new APIUrlReader();

        assertEquals(COUNT_ANIMAL_APIS, reader.getCountAnimalAPIs());
    }
}

