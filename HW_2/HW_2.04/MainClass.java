import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        WritingTool[] tools = new WritingTool[6];
        tools[0] = Pen.createPen("Parker", 5.75, "black", Pen.Type.STYLUS);
        tools[1] = Pencil.createPencil("Kohinoor", 5.90, "grey", Pencil.Hardness.B, false);
        tools[2] = Highlighter.createHighlighter("Jet Stick", 5.90, "green", Highlighter.Type.DRY);
        tools[3] = Pen.createPen("Parker", 6.90, "blue", Pen.Type.GEL);
        tools[4] = Pencil.createPencil("Kohinoor", 6.90, "grey", Pencil.Hardness.H2, true);
        tools[5] = Highlighter.createHighlighter("Jet Stick", 1.80, "red", Highlighter.Type.LIQUID);

        System.out.println("\n======== Sorting by price ========\n");
        Arrays.sort(tools, WritingTool.priceComparator);
        for(WritingTool tool : tools)
            System.out.println(tool.getInfo());

        System.out.println("\n======== Sorting by name ========\n");
        Arrays.sort(tools, WritingTool.nameComparator);
        for(WritingTool tool : tools)
            System.out.println(tool.getInfo());

        System.out.println("\n======== Sorting by price and name ========\n");
        Arrays.sort(tools, WritingTool.priceNameComparator);
        for(WritingTool tool : tools)
            System.out.println(tool.getInfo());


    }
}
