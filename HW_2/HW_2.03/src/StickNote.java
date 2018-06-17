public class StickNote extends Paper {
    private int stationerySize;

    private StickNote(String name, double price, int amount, String stationeryColor, int stationeryBaseWeight, int stationeryPackAmount, int stationerySize) {
        super(name, price, amount, stationeryColor, stationeryBaseWeight, stationeryPackAmount);
        this.stationerySize = stationerySize;
    }

    public static StickNote createStickNote(String name, double price, int amount, String stationeryColor, int stationeryBaseWeight, int stationeryPackAmount, int stationerySize) {
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
        if (stationerySize < 10) {
            System.out.println("ERROR! There is no stick notes with such size!");
            return null;
        }
        return new StickNote(name, price, amount, stationeryColor, stationeryBaseWeight, stationeryPackAmount, stationerySize);
    }

    public String getInfo() {
        return String.format("%s \"%s\"\nColor:\t%s\nBase weight:\t%s g/cm2\nSize:\t%dx%d cm\nAmount in a pack:\t%d\nPacks amount:\t%d\nPrice:\t%c%.2f\nTotal:\t%c%.2f\n", getClass().getName(), this.getStationeryName(), this.getStationeryColor(), this.getStationeryBaseWeight(), stationerySize, stationerySize, this.getStationeryPackAmount(), this.getStationeryAmount(), current, this.getStationeryPrice(), current, this.calcTotalPrice());
    }
}
