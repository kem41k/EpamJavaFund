public class OfficeSupplies {
    public static final char current = '$';
    private String stationeryName;
    private double stationeryPrice;
    private int stationeryAmount;

    public OfficeSupplies() {}

    public OfficeSupplies(String stationeryName, double stationeryPrice, int stationeryAmount) {
        this.stationeryName = stationeryName;
        this.stationeryPrice = stationeryPrice;
        this.stationeryAmount = stationeryAmount;
    }

    public String getStationeryName() {
        return stationeryName;
    }

    public double getStationeryPrice() {
        return stationeryPrice;
    }

    public int getStationeryAmount() {
        return stationeryAmount;
    }

    public double calcTotalPrice() {
        return stationeryAmount * stationeryPrice;
    }

    public String getInfo() {
        return String.format("%s \"%s\"\nAmount:\t%d\nPrice:\t%c%.2f\nTotal:\t%c%.2f\n", getClass().getName(), stationeryName, stationeryAmount, current, stationeryPrice, current, calcTotalPrice());
    }
}