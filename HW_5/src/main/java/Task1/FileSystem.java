package Task1;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

// Adding one line to test github
public class FileSystem {
    public static List<File> getDirectoryFilesList(String path) {
        try {
            return Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (NoSuchFileException ex) {
            System.out.println(String.format("ERROR! Folder \"%s\" does not exist!", path));
            return null;
        } catch (UncheckedIOException ex) {
            System.out.println(String.format("ERROR! Access to \"%s\" is denied!", path));
            return null;
        } catch (IOException ex) {
            System.out.println(String.format("ERROR! IOException while trying to reach \"%s\"!", path));
            return null;
        }
    }

    public static String getFileContent(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)), "UTF-8");
        } catch (NoSuchFileException ex) {
            System.out.println(String.format("ERROR! File \"%s\" does not exist!", path));
            return "";
        } catch (IOException ex) {
            System.out.println(String.format("ERROR! IOException while trying to reach \"%s\"!", path));
            return "";
        }
    }

    public static boolean createFile(String path) {
        try {
            Files.createFile(Paths.get(path));
            return true;
        } catch (NoSuchFileException ex) {
            System.out.println(String.format("ERROR! Folder \"%s\" does not exist, so file can not be created!", path.substring(0, path.lastIndexOf("/"))));
            return false;
        } catch (FileAlreadyExistsException ex) {
            System.out.println(String.format("ERROR! File \"%s\" is already existed!", path));
            return false;
        } catch (IOException ex) {
            System.out.println(String.format("ERROR! File \"%s\" can not be created!", path));
            return false;
        }
    }

    public static boolean deleteFile(String path) {
        try {
            return Files.deleteIfExists(Paths.get(path));
        } catch (IOException ex) {
            System.out.println(String.format("ERROR! IOException while trying to delete \"%s\"!", path));
            return false;
        }
    }

    public static boolean addToFile(String path, String text) {
        try {
            if (Files.notExists(Paths.get(path)))
                throw new NoSuchFileException(path);
            Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (NoSuchFileException ex) {
            System.out.println(String.format("ERROR! File \"%s\" does not exist!", path));
            return false;
        } catch (IOException ex) {
            System.out.println(String.format("ERROR! IOException while trying to write to \"%s\"!", path));
            return false;
        }
    }
}
