import lombok.AllArgsConstructor;
import lombok.Getter;

public class Paper extends OfficeSupplies {
    @Getter private String stationeryColor;
    @Getter private int stationeryBaseWeight;
    @Getter private int stationeryPackAmount;

    public Paper(String name, double price, int amount, String stationeryColor, int stationeryBaseWeight, int stationeryPackAmount) {
        super(name, price, amount);
        this.stationeryColor = stationeryColor;
        this.stationeryBaseWeight = stationeryBaseWeight;
        this.stationeryPackAmount = stationeryPackAmount;
    }

    public static Paper createPaper(String name, double price, int amount, String stationeryColor, int stationeryBaseWeight, int stationeryPackAmount)
            throws NullPointerException {
        if (price < 0)
            throw new NullPointerException("ERROR! Price can not be negative number!");
        if (amount < 0)
            throw new NullPointerException("ERROR! Amount can not be negative number!");
        if (stationeryBaseWeight < 35)
            throw new NullPointerException("ERROR! There is no paper with such base weight!");
        if (stationeryPackAmount <= 0)
            throw new NullPointerException("ERROR! Amount of paper in a pack should be positive number!");
        return new Paper(name, price, amount, stationeryColor, stationeryBaseWeight, stationeryPackAmount);
    }

    public String getInfo() {
        return String.format("%s \"%s\"\nColor:\t%s\nBase weight:\t%s g/cm2\nAmount in a pack:\t%s\nPacks amount:\t%d\nPrice:\t%c%.2f\nTotal:\t%c%.2f\n", getClass().getName(), this.getStationeryName(), stationeryColor, stationeryBaseWeight, stationeryPackAmount, this.getStationeryAmount(), current, this.getStationeryPrice(), current, this.calcTotalPrice());
    }
}
