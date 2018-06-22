public class Pen extends WritingTool {
    public enum Type {
        BALLPOINT,
        ROLLERBALL,
        FOUNTAIN,
        FELT_TIP,
        GEL,
        STYLUS
    }

    private Type type;

    private Pen(String name, double price, String color, Type type) {
        super(name, price, color);
        this.type = type;
    }

    public static Pen createPen(String name, double price, String color, Type type) throws NullPointerException {
        if (price < 0)
            throw new NullPointerException("ERROR! Price can not be negative number!");
        return new Pen(name, price, color, type);
    }

    public String getInfo() {
        return String.format("%-25s: $%.2f, color: %s, type: %s", getClass().getName() + " \"" + this.getName() + "\"", this.getPrice(), this.getColor(), type);
    }
}
