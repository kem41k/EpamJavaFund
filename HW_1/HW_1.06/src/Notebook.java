import java.util.ArrayList;

/**
 * Class 'Notebook'.
 *
 * @author Kamil Yagafarov
 */
public class Notebook {
    /** The notebook with records. */
    private ArrayList<Record> notebook;

    /**
     * Constructor without parameters.
     */
    public Notebook() {
        notebook = new ArrayList<Record>();
    }

    /**
     * Adds new record to a notebook.
     *
     * @param newRecord
     */
    public void addRecord(Record newRecord) {
        notebook.add(newRecord);
    }

    /**
     * Deletes i-th record from notebook.
     *
     * @param i number of record
     */
    public void deleteRecord(int i) {
        try{
            notebook.remove(i);
            System.out.println("Record #" + i + " was deleted!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Error! " + ex.getMessage() + ". Record #" + i + " was NOT deleted!");
        }
    }

    /**
     * Edites i-th record from notebook.
     *
     * @param i number of record.
     */
    public void editRecord(int i, String newText) {
        try {
            notebook.set(i, new Record(newText));
            System.out.println("Record #" + i + " was edited!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Error! " + ex.getMessage() + ". Record #" + i + " was NOT edited!");
        }
    }

    /**
     * Prints all records from notebook.
     */
    public void printNotebook() {
        for (int i = 0; i < notebook.size(); i++){
            System.out.print("#" + i + ". ");
            notebook.get(i).printRecord();
        }
    }
}
