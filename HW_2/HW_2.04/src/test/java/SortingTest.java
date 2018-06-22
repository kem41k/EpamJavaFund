import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    void sortByName() {
        WritingTool[] basicArray = new WritingTool[6];
        basicArray[0] = Pen.createPen("Parker", 5.75, "black", Pen.Type.STYLUS);
        basicArray[1] = Pencil.createPencil("Kohinoor", 5.90, "grey", Pencil.Hardness.B, false);
        basicArray[2] = Highlighter.createHighlighter("Jet Stick", 5.90, "green", Highlighter.Type.DRY);
        basicArray[3] = Pen.createPen("Parker", 6.90, "blue", Pen.Type.GEL);
        basicArray[4] = Pencil.createPencil("Kohinoor", 6.90, "grey", Pencil.Hardness.H2, true);
        basicArray[5] = Highlighter.createHighlighter("Jet Stick", 1.80, "red", Highlighter.Type.LIQUID);

        WritingTool[] expected = new WritingTool[6];
        expected[0] = basicArray[2];
        expected[1] = basicArray[5];
        expected[2] = basicArray[1];
        expected[3] = basicArray[4];
        expected[4] = basicArray[0];
        expected[5] = basicArray[3];

        assertArrayEquals(expected, Sorting.sortByName(basicArray));
    }

    @Test
    void sortByPrice() {
        WritingTool[] basicArray = new WritingTool[6];
        basicArray[0] = Pen.createPen("Parker", 5.75, "black", Pen.Type.STYLUS);
        basicArray[1] = Pencil.createPencil("Kohinoor", 5.90, "grey", Pencil.Hardness.B, false);
        basicArray[2] = Highlighter.createHighlighter("Jet Stick", 5.90, "green", Highlighter.Type.DRY);
        basicArray[3] = Pen.createPen("Parker", 6.90, "blue", Pen.Type.GEL);
        basicArray[4] = Pencil.createPencil("Kohinoor", 6.90, "grey", Pencil.Hardness.H2, true);
        basicArray[5] = Highlighter.createHighlighter("Jet Stick", 1.80, "red", Highlighter.Type.LIQUID);

        WritingTool[] expected = new WritingTool[6];
        expected[0] = basicArray[5];
        expected[1] = basicArray[0];
        expected[2] = basicArray[1];
        expected[3] = basicArray[2];
        expected[4] = basicArray[3];
        expected[5] = basicArray[4];
        assertArrayEquals(expected, Sorting.sortByPrice(basicArray));
    }

    @Test
    void sortByPriceAndName() {
        WritingTool[] basicArray = new WritingTool[6];
        basicArray[0] = Pen.createPen("Parker", 5.75, "black", Pen.Type.STYLUS);
        basicArray[1] = Pencil.createPencil("Kohinoor", 5.90, "grey", Pencil.Hardness.B, false);
        basicArray[2] = Highlighter.createHighlighter("Jet Stick", 5.90, "green", Highlighter.Type.DRY);
        basicArray[3] = Pen.createPen("Parker", 6.90, "blue", Pen.Type.GEL);
        basicArray[4] = Pencil.createPencil("Kohinoor", 6.90, "grey", Pencil.Hardness.H2, true);
        basicArray[5] = Highlighter.createHighlighter("Jet Stick", 1.80, "red", Highlighter.Type.LIQUID);

        WritingTool[] expected = new WritingTool[6];
        expected[0] = basicArray[5];
        expected[1] = basicArray[0];
        expected[2] = basicArray[2];
        expected[3] = basicArray[1];
        expected[4] = basicArray[4];
        expected[5] = basicArray[3];
        assertArrayEquals(expected, Sorting.sortByTwoParams(basicArray));
    }
}