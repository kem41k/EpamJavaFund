import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class Loops {
    public static void main(String[] args) {
        System.out.println("Lower bound:");
        double a = readFromConsole("a");

        System.out.println("\nUpper bound:");
        double b;
        while (true){
            b = readFromConsole("b");
            if (b <= a)
                System.out.println("Wrong input! Upper bound should be larger than lower bound!");
            else
                break;
        }

        System.out.println("\nStep:");
        double h;
        while (true){
            h = readFromConsole("h");
            if (h > b - a)
                System.out.println("Wrong input! Step should not be larger than (b - a) value!");
            else if (h <= 0)
                System.out.println("Wrong input! Step should not be larger than zero!");
            else
                break;
        }

        System.out.println("\n        x       |        F(x)    ");
        while (a < b){
            System.out.printf("%15.6f | %15.6f\n", a, Math.tan(2 * a) - 3);
            a += h;
        }
        System.out.printf("%15.6f | %15.6f\n", b, Math.tan(2 * b) - 3);
    }

    private static double readFromConsole(String variableName){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print(variableName + " = ");
                return Double.parseDouble(reader.readLine());
            } catch (IOException ex) {
                System.out.println("Wrong input! " + ex.getMessage());
            } catch (NumberFormatException numEx) {
                System.out.println("Wrong input! Write a double value!");
            }
        }
    }
}