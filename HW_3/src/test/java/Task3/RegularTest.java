package Task3;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularTest {

    @Test
    @SneakyThrows
    void getImgReferences() {
        System.out.println(Regular.getImgReferences());
    }

    @Test
    @SneakyThrows
    void checkImgRefOrder() {
        assertFalse(Regular.checkImgRefOrder());
    }
}