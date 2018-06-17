public class MainClass {
    public static void main(String[] args) {
        OfficeSupplies[] officeSupplies = new OfficeSupplies[7];
        officeSupplies[0] = Pen.createPen("Parker", 15.50, 1, "black", Pen.Type.STYLUS);
        officeSupplies[1] = Pen.createPen("Bic", 0.80, 5, "blue", Pen.Type.ROLLERBALL);
        officeSupplies[2] = Pencil.createPencil("Kohinoor", 0.65, 3, "black", Pencil.Hardness.F, true);
        officeSupplies[3] = Pencil.createPencil("Kohinoor", 0.55, 2, "black", Pencil.Hardness.H2, false);
        officeSupplies[4] = Highlighter.createHighlighter("Jet Stick", 2.55, 2, "green", Highlighter.Type.LIQUID);
        officeSupplies[5] = Paper.createPaper("Snow", 7.50, 2, "white", 80, 200);
        officeSupplies[6] = StickNote.createStickNote("Ideas", 2.85, 1, "red", 40, 100, 10);

        System.out.println("==== Newcomer Toolkit ====\n");
        for(OfficeSupplies os: officeSupplies)
            System.out.println(os.getInfo());
    }
}
