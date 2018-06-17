public class Highlighter extends WritingTool {
    public enum Type {
        DRY,
        GEL,
        LIQUID
    }

    private Type stationeryType;

    private Highlighter(String name, double price, int amount, String color, Type stationeryType) {
        super(name, price, amount, color);
        this.stationeryType = stationeryType;
    }

    public static Highlighter createHighlighter(String name, double price, int amount, String color, Type stationeryType) {
        if (price < 0) {
            System.out.println("ERROR! Price can not be negative number!");
            return null;
        }
        if (amount < 0) {
            System.out.println("ERROR! Amount can not be negative number!");
            return null;
        }
        return new Highlighter(name, price, amount, color, stationeryType);
    }

    public String getInfo() {
        return String.format("%s \"%s\"\nColor:\t%s\nType:\t%s\nAmount:\t%d\nPrice:\t%c%.2f\nTotal:\t%c%.2f\n", getClass().getName(), this.getStationeryName(), this.getStationeryColor(), stationeryType, this.getStationeryAmount(), current, this.getStationeryPrice(), current, this.calcTotalPrice());
    }
}
