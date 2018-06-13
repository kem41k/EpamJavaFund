public class Classes {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();

        System.out.println("\n=== Initial state ===\n");
        notebook.addRecord(new Record("This is my first record!"));
        notebook.addRecord(new Record("And here is my second record."));
        notebook.addRecord(new Record("Wow! My third record is here!"));
        notebook.addRecord(new Record("Record No4. I hope there is enough space in my notebook!"));
        notebook.addRecord(new Record("Odd record. I should delete it later."));
        notebook.addRecord(new Record("My last record!"));
        notebook.printNotebook();

        System.out.println("\n=== Delete two records. New state: ===\n");
        notebook.deleteRecord(-1);
        notebook.deleteRecord(4);
        notebook.printNotebook();

        System.out.println("\n=== Edit two records. New state ===\n");
        notebook.editRecord(10, "New text for this record!");
        notebook.editRecord(3, "I've done last task in this homework!");
        notebook.printNotebook();
    }
}
