import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TwoDimArray {
    public static void main(String[] args) {
        fillArray(getN());
    }

    private static int getN(){
        int n;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try{
                System.out.print("n = ");
                n = Integer.parseInt(reader.readLine());
                if (n <= 0)
                    throw new NumberFormatException();
                else
                    return n;
            } catch (IOException ex){
                System.out.println("Wrong input! " + ex.getMessage());
            } catch (NumberFormatException numEx){
                System.out.println("Wrong input! N should be a positive integer!\n");
            }
        }
    }

    private static void fillArray(int n){
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][i] = 1;
                array[i][n - 1 - i] = 1;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
