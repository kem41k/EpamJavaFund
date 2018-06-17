import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Sequence {
    public static void main(String[] args) {
        double eps = getEpsilon();
        double element = 1;
        int n = 1;
        while(element >= eps){
            element = 1 / Math.pow(n + 1, 2);
            System.out.println("a[" + n++ + "] = " + element);
        }
        System.out.println("Answer: n = " + --n);
    }

    private static double getEpsilon() {
        double input = -1;
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a double value from (0;1) interval:");
        while (true){
            try {
                System.out.print("eps = ");
                input = Double.parseDouble(bufferRead.readLine());
                if (input > 0 && input < 1)
                    return input;
                else
                    System.out.println("Wrong input! Epsilon should be from (0;1) interval!\n");
            }
            catch(IOException ex) {
                System.out.println("Wrong input! " + ex.getMessage());
            }
            catch (NumberFormatException numEx) {
                System.out.println("Wrong input! Epsilon should be a double value!\n");
            }
        }
    }
}
