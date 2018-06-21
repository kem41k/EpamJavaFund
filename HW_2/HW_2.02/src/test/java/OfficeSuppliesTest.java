import org.junit.Test;
import static org.junit.Assert.*;

public class OfficeSuppliesTest {
    OfficeSupplies suppliesOfJD = OfficeSupplies.newOfficeSupplies("John Dorian", new int[]{0, 0, 0, 0, 0});
    OfficeSupplies suppliesOfCT = OfficeSupplies.newOfficeSupplies("Chris Terk", new int[]{1, 1, 1, 1, 1});

    @Test
    public void addStationery1() {
        assertFalse(suppliesOfJD.addStationery("pen", -5));
    }

    @Test
    public void addStationery2() {
        assertFalse(suppliesOfJD.addStationery("sticky notes", 5));
    }

    @Test
    public void addStationery3() {
        assertTrue(suppliesOfJD.addStationery("pen", 5));
        assertEquals(suppliesOfJD.getStationeryAmount()[0], 5);
    }

    @Test
    public void calculateTotalPrice() {
        assertEquals((int)(suppliesOfCT.calculateTotalPrice() * 100), 665);
    }
}