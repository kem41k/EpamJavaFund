public class Paper extends OfficeSupplies {
    private String stationeryColor;
    private int stationeryBaseWeight;
    private int stationeryPackAmount;

    public Paper(String name, double price, int amount, String stationeryColor, int stationeryBaseWeight, int stationeryPackAmount) {
        super(name, price, amount);
        this.stationeryColor = stationeryColor;
        this.stationeryBaseWeight = stationeryBaseWeight;
        this.stationeryPackAmount = stationeryPackAmount;
    }

    public String getStationeryColor() {
        return stationeryColor;
    }

    public int getStationeryBaseWeight() {
        return stationeryBaseWeight;
    }

    public int getStationeryPackAmount() {
        return stationeryPackAmount;
    }

    public static Paper createPaper(String name, double price, int amount, String stationeryColor, int stationeryBaseWeight, int stationeryPackAmount) {
        if (price < 0) {
            System.out.println("ERROR! Price can not be negative number!");
            return null;
        }
        if (amount < 0) {
            System.out.println("ERROR! Amount can not be negative number!");
            return null;
        }
        if (stationeryBaseWeight < 35) {
            System.out.println("ERROR! There is no paper with such base weight!");
            return null;
        }
        if (stationeryPackAmount <= 0) {
            System.out.println("ERROR! Amount of paper in a pack should be positive number!");
            return null;
        }
        return new Paper(name, price, amount, stationeryColor, stationeryBaseWeight, stationeryPackAmount);
    }

    public String getInfo() {
        return String.format("%s \"%s\"\nColor:\t%s\nBase weight:\t%s g/cm2\nAmount in a pack:\t%s\nPacks amount:\t%d\nPrice:\t%c%.2f\nTotal:\t%c%.2f\n", getClass().getName(), this.getStationeryName(), stationeryColor, stationeryBaseWeight, stationeryPackAmount, this.getStationeryAmount(), current, this.getStationeryPrice(), current, this.calcTotalPrice());
    }
}
