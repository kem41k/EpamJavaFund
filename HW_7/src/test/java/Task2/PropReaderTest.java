package Task2;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class PropReaderTest {

    String expectedRes1;
    String expectedRes2;
    String expectedRes3;

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

    @Test
    @DisplayName("Method \"synchronisationTest\" is correct!")
    @SneakyThrows
    void synchronisationTest() {
        Runnable task1 = () -> {expectedRes1 = PropReader.getPropByName("src\\test\\resources\\config.properties", "database");};
        Runnable task2 = () -> {expectedRes2 = PropReader.getPropByName("src\\test\\resources\\config.properties", "dbpassword");};
        Runnable task3 = () -> {expectedRes3 = PropReader.getPropByName("src\\test\\resources\\config.properties", "dbuser");};
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        assertEquals("javafund", expectedRes1);
        assertEquals("ilovejava", expectedRes2);
        assertEquals("kem41k", expectedRes3);
    }
}