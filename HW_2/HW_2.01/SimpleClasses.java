// Useful link: https://habr.com/post/168195/

public class SimpleClasses {
    public static void main(String[] args) {
        Pen pen1 = new Pen("Parker", Color.BLUE, Type.BALLPOINT);
        Pen pen2 = pen1;
        Pen pen3 = new Pen("Parker", Color.BLUE, Type.BALLPOINT);
        Pen pen4 = new Pen("Parker", Color.BLACK, Type.GEL);

        System.out.println("Pens:\n1) " + pen1.toString() + "\n2) " + pen2.toString() + "\n3) " + pen3.toString()  + "\n4) " + pen4.toString() + "\n");

        System.out.println("pen1 equals pen2: " + pen1.equals(pen2));
        System.out.println("pen1 equals pen3: " + pen1.equals(pen3));
        System.out.println("pen1 equals pen4: " + pen1.equals(pen4) + "\n");

        System.out.println("pen1 hash code: " + pen1.hashCode());
        System.out.println("pen2 hash code: " + pen2.hashCode());
        System.out.println("pen3 hash code: " + pen3.hashCode());
        System.out.println("pen4 hash code: " + pen4.hashCode());
    }

    public enum Color {
        BLUE,
        BLACK,
        RED
    }

    public enum Type {
        BALLPOINT,
        ROLLERBALL,
        FOUNTAIN,
        FELTTIP,
        GEL,
        STYLUS,
        NONE
    }
    public static class Pen {
        private String penProducer;
        private Color penColor;
        private Type penType;

        public Pen() {
            this.penProducer = "noname";
            this.penColor = Color.BLACK;
            this.penType = Type.NONE;
        }

        public Pen(String penProducer, Color penColor, Type penType) {
            this.penProducer = penProducer;
            this.penColor = penColor;
            this.penType = penType;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;

            Pen somePen = (Pen)obj;
            if (penProducer != somePen.penProducer)
                return false;
            if (penColor != somePen.penColor)
                return false;
            if (penType != somePen.penType)
                return false;
            return true;
        }

        @Override
        public int hashCode() {
            return (int)(penProducer.hashCode() + penColor.hashCode() + penType.hashCode());
        }

        @Override
        public String toString() {
            return getClass().getName() + " @ Producer: " + penProducer + ", color: " + penColor.toString() + ", type: " + penType.toString();
        }
    }
}
