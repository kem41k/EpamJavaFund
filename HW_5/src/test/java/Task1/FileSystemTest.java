package Task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    @Test
    void getDirectoryFilesList() {
        assertEquals(30, FileSystem.getDirectoryFilesList("C:\\projects\\EpamJavaFund\\HW_1").size());
        // NoSuchFileException
        assertNull(FileSystem.getDirectoryFilesList("C:\\projects\\EpamJavaFund\\HW_10"));
        // AccessDeniedException
        assertNull(FileSystem.getDirectoryFilesList("C:\\"));
    }

    @Test
    void getFileContent() {
        assertNotEquals("", "C:\\projects\\EpamJavaFund\\HW_1\\HW_1.01\\src\\javase01\\t01\\logic\\Logic.java");
        // NoSuchFileException
        assertEquals("", FileSystem.getFileContent("C:\\projects\\EpamJavaFund\\HW_1\\HW_1.01\\src\\javase01\\t01\\logic\\Logic.jav"));
    }

    @Test
    void createFile() {
        assertTrue(FileSystem.createFile("src/test/resources/file1.txt"));
        // FileAlreadyExistsException
        assertFalse(FileSystem.createFile("src/test/resources/file1.txt"));
        // NoSuchFileException
        assertFalse(FileSystem.createFile("src/test/resources1/file1.txt"));
    }

    @Test
    void deleteFile() {
        assertTrue(FileSystem.deleteFile("src/test/resources/file1.txt"));
        // No file to delete
        assertFalse(FileSystem.deleteFile("src/test/resources/file1.txt"));
    }

    @Test
    void addToFile() {
        // NoSuchFileException
        assertFalse(FileSystem.addToFile("src/test/resources/file1.txt", "Hello!"));

        assertTrue(FileSystem.createFile("src/test/resources/file1.txt"));
        assertTrue(FileSystem.addToFile("src/test/resources/file1.txt", "Hello world!"));
        assertTrue(FileSystem.deleteFile("src/test/resources/file1.txt"));
    }
}