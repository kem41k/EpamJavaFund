package Task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        System.out.println("==== This is a WhatsApp F.A.Q. ====");

        String country = "";
        String language = "";
        int localeNum = readInt("Please, choose language (1 - EN, 2 - RU, default is EN): ");
        switch (localeNum) {
            case 1:
                country = "US";
                language = "en";
                break;
            case 2:
                country = "RU";
                language = "ru";
                break;
            default:
                country = "US";
                language = "en";
        }

        ResourceBundle rb = ResourceBundle.getBundle("question", new Locale(language, country));
        System.out.println(rb.getString("l0"));
        Set<String> keys = rb.keySet();

        int questionNum = -1;
        while (true) {
            System.out.println("\n====" + rb.getString("l1") + "====");
            for (String key : keys)
                if (key.contains("q"))
                    System.out.println(key.substring(1) + ") " + rb.getString(key));
            questionNum = readInt(rb.getString("l2"));
            if (questionNum >= 1 && questionNum <= (keys.size() - 4) / 2)
                System.out.println(String.format("\nQ: %s\nA: %s", rb.getString("q" + questionNum), rb.getString("a" + questionNum)));
            else
                System.out.println(rb.getString("l3"));
        }

    }

    public static int readInt(String text) {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print(text);
                return Integer.parseInt(bufferRead.readLine());
            } catch (IOException ex) {
                System.out.println("Wrong input! " + ex.getMessage());
            } catch (NumberFormatException numEx) {
                System.out.println("Wrong input! Write an integer value!\n");
            }
        }
    }
}
