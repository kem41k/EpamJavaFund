// Outer class
@ClassPreamble(
        author = "Kamil Yagafarov",
        date = "20/06/2018",
        currentRevision = 2,
        lastModyfied = "23/06/2018"
)
public class AtomicBoat {
    private String name;
    private int passengersCapacity;
    private DrivingEngine engine;

    // Inner class
    @ClassPreamble(
            author = "Kamil Yagafarov",
            date = "20/06/2018",
            currentRevision = 1,
            lastModyfied = "21/06/2018"
    )
    class DrivingEngine {
        private String model;
        private int power;
        private double temperature;
        private boolean isActivated;

        public DrivingEngine(String model, int power, double temperature) {
            this.model = model;
            this.power = power;
            this.temperature = temperature;
        }

        public void startEngine() {
            if (!isActivated) {
                isActivated = true;
                System.out.println(String.format("The driving engine model \"%s\" was started!", model));
            }
            else {
                System.out.println("The driving engine has been already started!");
            }
        }
    }

    public DrivingEngine getEngine() {
        return engine;
    }

    public AtomicBoat(String name, int passengersCapacity, String engineModel, int enginePower, double engineTemperature ) {
        this.name = name;
        this.passengersCapacity = passengersCapacity;
        this.engine = new DrivingEngine(engineModel, enginePower, engineTemperature);
    }

    public boolean startSailing() {
        System.out.println("Trying to start sailing...");
        if(!engine.isActivated) {
            System.out.println("The engine \"" + engine.model + "\"" + " is not yet activated!");
            return false;
        }
        System.out.println("Let's sail on \"" + name + "\"!");
        System.out.println("                |    |    |");
        System.out.println("               )_)  )_)  )_)");
        System.out.println("              )___))___))___)\\");
        System.out.println("             )____)____)_____)\\");
        System.out.println("           _____|____|____|____\\\\\\__");
        System.out.println("  ---------\\                   /---------");
        System.out.println("    ^^^^^ ^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("      ^^^^      ^^^^     ^^^    ^^");
        System.out.println("           ^^^^      ^^^");
        return true;
    }

    @Override
    public String toString() {
        return String.format("Boat name: \"%s\" (%d passengers), engine \"%s\" (%d kW, %.2f °C)", name, passengersCapacity, engine.model, engine.power, engine.temperature);
    }
}
