public class Stationery {
    private String name;
    private double price;

    private Stationery() {}

    private Stationery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static Stationery createStationery(String name, double price) throws NullPointerException {
        if (name == null || price < 0)
            throw new NullPointerException("ERROR! The \'name\' is null and\\or the price is negative!");
        return new Stationery(name, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}