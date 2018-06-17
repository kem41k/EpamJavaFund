import java.time.LocalDateTime;

/**
 * Class 'Notebook record'.
 *
 * @author Kamil Yagafarov
 */
public class Record {
    /** The date of current record. */
    private LocalDateTime recordDate;
    /** The text of current record. */
    private StringBuffer recordText;

    /**
     * Constructor with parameters.
     *
     * The constructor creates new object with two fields. One of them is a timestamp generated automatically,
     * another is a record text.
     *
     * @param record_ record text
     */
    public Record(String record_){
        this.recordDate = LocalDateTime.now();
        this.recordText = new StringBuffer(record_);
    }

    /**
     * Prints current record in console.
     */
    public void printRecord() {
        System.out.println("Date: " + recordDate + "\nRecord: " + recordText + "\n");
    }
}