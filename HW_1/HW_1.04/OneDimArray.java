import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class OneDimArray {
    public static void main(String[] args) {
        int n = getN();
        double[] array = getRandomArray(2 * n);
        double[] arrayOfSums = getArrayOfSums(array);
        Arrays.sort(arrayOfSums);
        System.out.println("\nMax = " + arrayOfSums[arrayOfSums.length - 1]);
    }

    public static int getN(){
        int n;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try{
                System.out.print("n = ");
                n = Integer.parseInt(reader.readLine());
                if (n > 0)
                    return n;
                else
                    System.out.println("Wrong input! N should be positive integer!\n");
                //break;
            } catch (IOException ex){
                ex.printStackTrace();
            } catch (NumberFormatException numEx){
                System.out.println("Wrong input! N should be positive integer!\n");
            }
        }
    }

    public static double[] getRandomArray(int n){
        System.out.println("\nArray");
        double[] array = new double[n];
        for (int i = 0; i < n; i++){
            array[i] = Math.random();
            System.out.println("[" + (i+1) + "]\t" + array[i]);
        }
        return array;
    }

    public static double[] getArrayOfSums(double[] baseArray){
        System.out.println("\nArray of sums");
        double array[] = new double[baseArray.length / 2];
        for (int i = 0; i < baseArray.length / 2; i++){
            array[i] = baseArray[i] + baseArray[baseArray.length - 1 - i];
            System.out.println("[" + (i+1) + "]+[" + (baseArray.length - i) + "]\t" + array[i]);
        }
        return array;
    }
}
