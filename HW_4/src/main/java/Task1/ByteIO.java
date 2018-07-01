package Task1;

import lombok.Cleanup;
import java.io.*;
import java.util.HashMap;

public class ByteIO {
    public static final String[] keys = {"abstract ", "continue ", "for ", "new ", "switch ", "assert ", "default ", "goto ",
            "package ", "synchronized ", "boolean ", "do ", "if ", "private ", "this ", "break;", "double ", "implements ",
            "protected ", "throw ", "byte ", "else ", "import ", "public ", "throws ", "case ", "enum ", "instanceof ", "return ",
            "transient ", "catch ", "extends ", "int ", "short ", "try ", "char ", "final ", "interface ", "static ", "void ",
            "class ", "finally ", "long ", "strictfp ", "volatile ", "const ", "float ", "native ", "super ", "while "};
    public static HashMap<String, Integer> keyWords = new HashMap<>();

    public static HashMap<String, Integer> calculateKeyWords()
            throws IOException {
        // File reader
        @Cleanup FileInputStream reader = new FileInputStream("src/main/resources/CrazyLogger.java");
        byte[] fileBytes = reader.readAllBytes();
        String fileText = new String(fileBytes);
        // File writer
        File outFile = new File("src/main/resources/out1.txt");
        outFile.delete();
        @Cleanup FileOutputStream writer = new FileOutputStream("src/main/resources/out1.txt", true);

        // Looking for keywords
        StringBuilder text;
        for (String key : keys) {
            text = new StringBuilder(fileText);
            int counter = 0;
            while (text.toString().contains(key)) {
                counter++;
                int pos = text.indexOf(key);
                text = new StringBuilder(text.substring(pos + key.length() - 1));
            }
            keyWords.put(key, counter);
            if (counter > 0)
                writer.write(String.format("%s=%d\n", key.substring(0,key.length() - 1), counter).getBytes());
        }

        return keyWords;
    }
}