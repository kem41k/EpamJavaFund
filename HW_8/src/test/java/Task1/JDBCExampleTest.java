package Task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JDBCExampleTest {

    @Test
    void dbInit() {
        JDBCExample.dbInit();
    }

    @Test
    void updateMovie() {
        JDBCExample.updateMovie(2, "Fear and Loathing in SPb", "Kamil Yagafarov", 2018);
        assertEquals(JDBCExample.getMovie(2), "\"Fear and Loathing in SPb\", Kamil Yagafarov (2018)");
    }

    @Test
    void getMovie() {
        assertEquals(JDBCExample.getMovie(1), "\"The Terminator\", James Francis Cameron (1984)");
    }
}