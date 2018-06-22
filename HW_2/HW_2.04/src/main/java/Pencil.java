public class Pencil extends WritingTool{
    public enum Hardness {
        B,
        HB,
        F,
        H,
        H2
    }

    private Hardness hardness;
    private boolean hasEraser;

    private Pencil(String name, double price, String color, Hardness hardness, boolean hasEraser) {
        super(name, price, color);
        this.hardness = hardness;
        this.hasEraser = hasEraser;
    }

    public static Pencil createPencil(String name, double price, String color, Hardness hardness, boolean hasEraser) throws NullPointerException {
        if (price < 0)
            throw new NullPointerException("ERROR! Price can not be negative number!");
        return new Pencil(name, price, color, hardness, hasEraser);
    }

    public String getInfo() {
        return String.format("%-25s: $%.2f, color: %s, hardness: %s, eraser: %b", getClass().getName() + " \"" + this.getName() + "\"", this.getPrice(), this.getColor(), hardness, hasEraser);
    }
}
