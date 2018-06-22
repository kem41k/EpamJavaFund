public class Pencil extends WritingTool{
    public enum Hardness {
        B,
        HB,
        F,
        H,
        H2
    }

    private Hardness stationeryHardness;
    private boolean hasEraser;

    private Pencil(String name, double price, int amount, String color, Hardness stationeryHardness, boolean hasEraser) {
        super(name, price, amount, color);
        this.stationeryHardness = stationeryHardness;
        this.hasEraser = hasEraser;
    }

    public static Pencil createPencil(String name, double price, int amount, String color, Hardness stationeryHardness, boolean hasEraser)
            throws NullPointerException {
        if (price < 0)
            throw new NullPointerException("ERROR! Price can not be negative number!");
        if (amount < 0)
            throw new NullPointerException("ERROR! Amount can not be negative number!");
        return new Pencil(name, price, amount, color, stationeryHardness, hasEraser);
    }

    public String getInfo() {
        return String.format("%s \"%s\"\nColor:\t%s\nHardness:\t%s\nHas eraser:\t%b\nAmount:\t%d\nPrice:\t%c%.2f\nTotal:\t%c%.2f\n", getClass().getName(), this.getStationeryName(), this.getStationeryColor(), stationeryHardness, hasEraser, this.getStationeryAmount(), current, this.getStationeryPrice(), current, this.calcTotalPrice());
    }
}
