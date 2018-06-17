public class Highlighter extends WritingTool {
    public enum Type {
        DRY,
        GEL,
        LIQUID
    }

    private Type type;

    private Highlighter(String name, double price, String color, Type type) {
        super(name, price, color);
        this.type = type;
    }

    public static Highlighter createHighlighter(String name, double price, String color, Type type) {
        if (price < 0) {
            System.out.println("ERROR! Price can not be negative number!");
            return null;
        }
        return new Highlighter(name, price, color, type);
    }

    public String getInfo() {
        return String.format("%-25s: $%.2f, color: %s, type: %s", getClass().getName() + "\"" + this.getName() + "\"", this.getPrice(), this.getColor(), type);
    }
}
