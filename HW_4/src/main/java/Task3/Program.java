package Task3;

import lombok.Cleanup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        @Cleanup FileInputStream reader = new FileInputStream("src/main/resources/in3.txt");
        String text = new String(reader.readAllBytes(), "UTF-8");

        File outFile = new File("src/main/resources/out3.txt");
        outFile.delete();
        @Cleanup FileOutputStream writer = new FileOutputStream("src/main/resources/out3.txt");
        writer.write(text.getBytes("UTF-16"));
    }
}