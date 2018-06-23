import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtomicBoatTest {
    AtomicBoat boat = new AtomicBoat("MyBoat", 100, "ATOM3000", 1250, 250);

    @Test
    void startSailing1() {
        assertFalse(boat.startSailing());
    }

    @Test
    void startSailing2() {
        boat.getEngine().startEngine();
        assertTrue(boat.startSailing());
    }
}