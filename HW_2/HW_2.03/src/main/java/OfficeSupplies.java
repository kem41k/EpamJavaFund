import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class OfficeSupplies {
    public static final char current = '$';
    @Getter private String stationeryName;
    @Getter private double stationeryPrice;
    @Getter private int stationeryAmount;

    public OfficeSupplies() {}

    public double calcTotalPrice() {
        return stationeryAmount * stationeryPrice;
    }

    public String getInfo() {
        return String.format("%s \"%s\"\nAmount:\t%d\nPrice:\t%c%.2f\nTotal:\t%c%.2f\n", getClass().getName(), stationeryName, stationeryAmount, current, stationeryPrice, current, calcTotalPrice());
    }
}