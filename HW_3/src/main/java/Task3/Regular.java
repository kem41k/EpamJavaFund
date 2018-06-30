package Task3;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.MULTILINE;

public class Regular {
    public Path filePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("attachment.html").getFile());
        return file.toPath();
    }

    public static StringBuilder getImgReferences() throws Exception {
        StringBuilder result = new StringBuilder();
        String text = new String(Files.readAllBytes(new Regular().filePath()), "windows-1251");
        Pattern pattern = Pattern.compile("[^.!?>]*([Рр]ис\\.|[Рр]исун)[^.!?]*[.!?]");
        Matcher matcher = pattern.matcher(text);
        int i = 1;
        while (matcher.find())
            result.append(i++ + ") " + matcher.group().trim() + "\n");
        return result;
    }

    public static boolean checkImgRefOrder() throws Exception{
        // Get image references
        StringBuilder result = new StringBuilder();
        String text = getImgReferences().toString();
        Pattern pattern = Pattern.compile("([Рр]ис. |[Рр]исунке )[\\d]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
            result.append(matcher.group() + " ");

        // Check references for order
        String[] references = result.toString().split(" ");
        int maxImageRef = 1;
        for (int i = 1; i < references.length; i += 2)  // Each second element is a number reference
        {
            int diff = Integer.parseInt(references[i]) - maxImageRef;
            System.out.println(Integer.parseInt(references[i]) + "-" + maxImageRef + "=" + diff);
            if (diff == 1)
                maxImageRef++;
            else if (diff > 1)
                return false;
        }
        return true;
    }
}
