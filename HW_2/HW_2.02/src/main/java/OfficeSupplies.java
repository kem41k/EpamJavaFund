import java.util.ArrayList;

public class OfficeSupplies {
    public static final char current = '$';
    public static final ArrayList<Stationery> stationeryList;
    static {
        stationeryList = new ArrayList<>();
        stationeryList.add(Stationery.createStationery("pen", 1.50));
        stationeryList.add(Stationery.createStationery("pencil", 0.75));
        stationeryList.add(Stationery.createStationery("clip", 0.05));
        stationeryList.add(Stationery.createStationery("paper", 0.10));
        stationeryList.add(Stationery.createStationery("stapler", 4.25));
    }

    private String employeeName;
    // Number of respective stationery, e.g. {0, 2, 0, 0, 1} means 2 pencils and 1 stapler
    private int[] stationeryAmount;

    public OfficeSupplies(String employeeName, int[] stationeryAmount) {
        this.employeeName = employeeName;
        this.stationeryAmount = stationeryAmount;
    }

    public String getInfo(){
        int i = 0;
        StringBuffer info = new StringBuffer(this.employeeName + "\n");
        for(Stationery stationery : stationeryList)
            info.append(String.format("\t%-10s %d\n", stationery.getName(), stationeryAmount[i++]));
        return info.toString();
    }

    public int[] getStationeryAmount() {
        return stationeryAmount;
    }

    /**
     * Static factory method.
     *
     * @param employeeName name of employee
     * @param stationeryAmount number of respective stationery, e.g. {0, 2, 0, 0, 1} means 2 pencils and 1 stapler
     * @return a set of office supplies or null
     */
    public static OfficeSupplies newOfficeSupplies(String employeeName, int[] stationeryAmount) throws NullPointerException {
        if (employeeName == null)
            throw new NullPointerException("ERROR! Write an employee name correctly!");
        if (stationeryAmount == null)
            throw new NullPointerException("ERROR! There should be a stationery amount array!");
        if (stationeryAmount.length != stationeryList.size())
            throw new NullPointerException("ERROR! An object was not created, because input array should have " + stationeryList.size() + " elements!");
        for (int i = 0; i < stationeryAmount.length; i++)
            if (stationeryAmount[i] < 0)
                throw new NullPointerException("ERROR! Amount of each stationery should be nonnegative!");

        return new OfficeSupplies(employeeName, stationeryAmount);
    }

    public boolean addStationery(String name, int amount) {
        if (amount <= 0)
            return false;
        for (int i = 0; i < stationeryList.size(); i++)
            if (stationeryList.get(i).getName().equals(name)) {
                stationeryAmount[i] += amount;
                return true;
            }
        return false;
    }

    public double calculateTotalPrice() {
        System.out.println(this.getInfo());
        double totalPrice = 0;
        for(int i = 0; i < stationeryList.size(); i++)
            totalPrice += stationeryList.get(i).getPrice() * stationeryAmount[i];
        return totalPrice;
    }
}
