import lombok.Getter;

public class WritingTool extends OfficeSupplies{
    @Getter private String stationeryColor;

    public WritingTool(String name, double price, int amount, String stationeryColor) {
        super(name, price, amount);
        this.stationeryColor = stationeryColor;
    }

    public String getStationeryColor() {
        return stationeryColor;
    }

    public String getInfo() {
        return String.format("%s \"%s\"\nColor:\t%s\nAmount:\t%d\nPrice:\t%c%.2f\nTotal:\t%c%.2f\n", getClass().getName(), this.getStationeryName(), stationeryColor, this.getStationeryAmount(), current, this.getStationeryPrice(), current, this.calcTotalPrice());
    }
}
