import java.util.ArrayList;

public class Office {
    public static void main(String[] args) {
        OfficeSupplies set1 = OfficeSupplies.newOfficeSupplies(null, null);
        set1 = OfficeSupplies.newOfficeSupplies("John", null);
        set1 = OfficeSupplies.newOfficeSupplies("John", new int[6]);
        set1 = OfficeSupplies.newOfficeSupplies("John", new int[] {1, 2, -3, 4, 5});
        set1 = OfficeSupplies.newOfficeSupplies("John", new int[] {1, 2, 3, 4, 5});
        System.out.println(set1.getInfo());

        OfficeSupplies set2 = OfficeSupplies.newOfficeSupplies("Mike", new int[] {2, 3, 4, 0, 10});
        System.out.println(set2.getInfo());

        OfficeSupplies set3 = OfficeSupplies.newOfficeSupplies("Bob", new int[] {10, 22, 30, 4, 1});
        System.out.println(set3.getInfo());

        set1.addStationery("pen", 5);
        set2.addStationery("notebook", 6);
        set3.addStationery("paper", 10);

        set1.calculateTotalPrice();
        set2.calculateTotalPrice();
        set3.calculateTotalPrice();
    }

    public static class Stationery {
        private String name;
        private double price;

        public Stationery(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public static class OfficeSupplies {
        public static final char current = '$';
        public static final ArrayList<Stationery> stationeryList;
        static {
            stationeryList = new ArrayList<>();
            stationeryList.add(new Stationery("pen", 1.50));
            stationeryList.add(new Stationery("pencil", 0.75));
            stationeryList.add(new Stationery("clip", 0.05));
            stationeryList.add(new Stationery("paper", 0.10));
            stationeryList.add(new Stationery("stapler", 4.25));
        }

        private String employeeName;
        private int[] stationeryAmount;

        private OfficeSupplies() {
            employeeName = "noname";
            stationeryAmount = new int[stationeryList.size()];
        }

        /**
         * Private constructor with parameters.
         *
         * @param employeeName name of employee
         * @param stationeryAmount number of respective stationery, e.g. {0, 2, 0, 0, 1} means 2 pencils and 1 stapler
         */
        private OfficeSupplies(String employeeName, int[] stationeryAmount) {
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

        /**
         * Static factory method.
         *
         * @param employeeName name of employee
         * @param stationeryAmount number of respective stationery, e.g. {0, 2, 0, 0, 1} means 2 pencils and 1 stapler
         * @return a set of office supplies or null
         */
        public static OfficeSupplies newOfficeSupplies(String employeeName, int[] stationeryAmount) {
            if (employeeName == null) {
                System.out.println("ERROR! Write an employee name correctly!\n");
                return null;
            }
            if (stationeryAmount == null) {
                System.out.println("ERROR! There should be a stationery amount array!\n");
                return null;
            }
            if (stationeryAmount.length != stationeryList.size()) {
                System.out.println("ERROR! An object was not created, because input array should have " + stationeryList.size() + " elements!\n");
                return null;
            }
            for (int i = 0; i < stationeryAmount.length; i++)
                if (stationeryAmount[i] < 0) {
                    System.out.println("ERROR! Amount of each stationery should be nonnegative!\n");
                    return null;
                }
            System.out.println("New set of office supplies was SUCCESSFULLY created!\n");
            return new OfficeSupplies(employeeName, stationeryAmount);
        }

        public void addStationery(String name, int amount) {
            if (amount <= 0) {
                System.out.println("ERROR! Write a positive amount of stationery!");
                return;
            }
            for (int i = 0; i < stationeryList.size(); i++)
                if (stationeryList.get(i).name.equals(name)) {
                    stationeryAmount[i] += amount;
                    System.out.println(employeeName + " gets " + amount + " " + name + "(s)");
                    return;
                }
            System.out.println("ERROR! There is no \"" + name + "\" in office supplies base!");
        }

        public void calculateTotalPrice() {
            System.out.println(this.getInfo());
            double totalPrice = 0;
            for(int i = 0; i < stationeryList.size(); i++)
                totalPrice += stationeryList.get(i).price * stationeryAmount[i];
            System.out.println("Total price: " + current + totalPrice + "\n");
        }
    }
}
