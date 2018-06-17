import java.util.Comparator;

public abstract class WritingTool /*implements Comparator<WritingTool>*/ {
    private String name;
    private double price;
    private String color;

    public static Comparator<WritingTool> nameComparator = new Comparator<WritingTool>() {
        @Override
        public int compare(WritingTool o1, WritingTool o2) {
            String name1 = o1.name.toLowerCase();
            String name2 = o2.name.toLowerCase();
            return name1.compareTo(name2);
        }
    };

    public static Comparator<WritingTool> priceComparator = new Comparator<WritingTool>() {
        @Override
        public int compare(WritingTool o1, WritingTool o2) {
            double price1 = o1.getPrice();
            double price2 = o2.getPrice();
            return (int)(price1 - price2);
        }
    };

    public static Comparator<WritingTool> priceNameComparator = new Comparator<WritingTool>() {
        @Override
        public int compare(WritingTool o1, WritingTool o2) {
            // Comparing by price
            double price1 = o1.getPrice();
            double price2 = o2.getPrice();
            if (price1 < price2)
                return -1;
            else if (price2 > price1)
                return 1;

            // Comparing by names, if prices are equal
            String name1 = o1.name.toLowerCase();
            String name2 = o2.name.toLowerCase();
            return name1.compareTo(name2);
        }
    };

    public WritingTool(String name, double price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public abstract String getInfo();
}
