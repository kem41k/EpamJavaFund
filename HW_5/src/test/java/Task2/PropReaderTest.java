package Task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PropReaderTest {

    @Test
    @DisplayName("Method \"getAllProperties\" is correct!")
    void getAllProperties() {
        // FileNotFoundException
        assertNull(PropReader.getPropFromFile("src\\test\\resources\\config1.properties"));

        Map<String, String> expected = new HashMap<>();
        expected.put("database", "javafund");
        expected.put("dbpassword", "ilovejava");
        expected.put("dbuser", "kem41k");
        assertEquals(expected, PropReader.getPropFromFile("src\\test\\resources\\config.properties"));
    }

    @Test
    @DisplayName("Method \"getPropByName\" is correct!")
    void getPropByName() {
        assertNull(PropReader.getPropByName("src\\test\\resources\\config.properties", "creationDate"));
        assertEquals("kem41k", PropReader.getPropByName("src\\test\\resources\\config.properties", "dbuser"));
    }
}