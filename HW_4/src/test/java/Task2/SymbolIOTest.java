package Task2;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class SymbolIOTest {
    HashMap<String, Integer> expected;

    @BeforeEach
    void setUp() {
        String[] keys = {"abstract ", "continue ", "for ", "new ", "switch ", "assert ", "default ", "goto ",
                "package ", "synchronized ", "boolean ", "do ", "if ", "private ", "this ", "break;", "double ", "implements ",
                "protected ", "throw ", "byte ", "else ", "import ", "public ", "throws ", "case ", "enum ", "instanceof ", "return ",
                "transient ", "catch ", "extends ", "int ", "short ", "try ", "char ", "final ", "interface ", "static ", "void ",
                "class ", "finally ", "long ", "strictfp ", "volatile ", "const ", "float ", "native ", "super ", "while "};
        expected = new HashMap<>();
        for(String key : keys)
            expected.put(key, 0);
    }

    @Test
    @SneakyThrows
    void calculateKeyWords() {
        expected.put("for ", 3);
        expected.put("new ", 2);
        expected.put("package ", 1);
        expected.put("if ", 3);
        expected.put("private ", 1);
        expected.put("break;", 1);
        expected.put("import ", 5);
        expected.put("public ", 5);
        expected.put("return ", 3);
        expected.put("int ", 2);
        expected.put("void ", 2);
        expected.put("class ", 1);
        expected.put("while ", 1);
        assertEquals(expected, SymbolIO.calculateKeyWords());
    }
}