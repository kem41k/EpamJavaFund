import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class OneDimArray {
    public static void main(String[] args) {
        double[] array = getRandomArray(2 * getN());
        double[] arrayOfSums = getArrayOfSums(array);
        Arrays.sort(arrayOfSums);
        System.out.println("\nMax = " + arrayOfSums[arrayOfSums.length - 1]);
    }

    private static int getN(){
        int n;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try{
                System.out.print("n = ");
                n = Integer.parseInt(reader.readLine());
                if (n > 0)
                    return n;
                else
                    throw new NumberFormatException();
                //break;
            } catch (IOException ex){
                System.out.println("Wrong input! " + ex.getMessage());
            } catch (NumberFormatException numEx){
                System.out.println("Wrong input! N should be a positive integer!\n");
            }
        }
    }

    private static double[] getRandomArray(int n){
        System.out.println("\nArray");
        double[] array = new double[n];
        for (int i = 0; i < n; i++){
            array[i] = Math.random();
            System.out.println("[" + (i+1) + "]\t" + array[i]);
        }
        return array;
    }

    private static double[] getArrayOfSums(double[] baseArray){
        System.out.println("\nArray of sums");
        double array[] = new double[baseArray.length / 2];
        for (int i = 0; i < baseArray.length / 2; i++){
            array[i] = baseArray[i] + baseArray[baseArray.length - 1 - i];
            System.out.println("[" + (i+1) + "]+[" + (baseArray.length - i) + "]\t" + array[i]);
        }
        return array;
    }
}
