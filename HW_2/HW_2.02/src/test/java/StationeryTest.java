import org.junit.Test;

import static org.junit.Assert.*;

public class StationeryTest {

    @Test(expected = NullPointerException.class)
    public void createStationeryNull1() {
        Stationery stationery = Stationery.createStationery(null, 10.5);
    }

    @Test(expected = NullPointerException.class)
    public void createStationeryNull2() {
        Stationery stationery = Stationery.createStationery("Pen", -10.5);
    }

    @Test
    public void createStationeryTest() {
        assertNotNull(Stationery.createStationery("Pen", 10.5));
    }
}