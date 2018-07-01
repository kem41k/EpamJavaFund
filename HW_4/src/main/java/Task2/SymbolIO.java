package Task2;

import lombok.Cleanup;
import java.io.*;
import java.util.HashMap;

public class SymbolIO {
    public static final String[] keys = {"abstract ", "continue ", "for ", "new ", "switch ", "assert ", "default ", "goto ",
            "package ", "synchronized ", "boolean ", "do ", "if ", "private ", "this ", "break;", "double ", "implements ",
            "protected ", "throw ", "byte ", "else ", "import ", "public ", "throws ", "case ", "enum ", "instanceof ", "return ",
            "transient ", "catch ", "extends ", "int ", "short ", "try ", "char ", "final ", "interface ", "static ", "void ",
            "class ", "finally ", "long ", "strictfp ", "volatile ", "const ", "float ", "native ", "super ", "while "};
    public static HashMap<String, Integer> keyWords = new HashMap<>();

    public static HashMap<String, Integer> calculateKeyWords()
            throws IOException {
        // File reader
        @Cleanup FileReader reader = new FileReader("src/main/resources/CrazyLogger.java");
        StringBuilder fileText = new StringBuilder();
        while (reader.ready())
            fileText.append((char)reader.read());
        // File writer
        File outFile = new File("src/main/resources/out2.txt");
        outFile.delete();
        @Cleanup FileWriter writer = new FileWriter("src/main/resources/out2.txt", true);

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
                writer.write(String.format("%s=%d\n", key.substring(0,key.length() - 1), counter));
        }

        return keyWords;
    }
}
