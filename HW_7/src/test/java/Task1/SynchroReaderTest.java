package Task1;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SynchroReaderTest {

    List<Transaction> expectedReceipts;
    List<Transaction> expectedExpences;
    List<Transaction> actualReceipts;
    List<Transaction> actualExpences;

    @BeforeEach
    void setUp() {
        expectedReceipts = new ArrayList<>();
        expectedReceipts.add(new Transaction("0123456789", "1234567890", "$100.00", "2018-07-08 11:22:54"));
        expectedReceipts.add(new Transaction("0123456789", "2345678901", "$250.50", "2018-07-08 12:32:04"));
        expectedReceipts.add(new Transaction("0123456789", "0123456788", "$10.15", "2018-07-08 19:02:41"));

        expectedExpences = new ArrayList<>();
        expectedExpences.add(new Transaction("4567890123", "0123456789", "$0.17", "2018-07-08 17:09:33"));
        expectedExpences.add(new Transaction("5678901234", "0123456789", "$1,456.78", "2018-07-08 18:22:54"));
    }

    @Test
    @SneakyThrows
    void Variant1() {
        Runnable task1 = () -> { actualReceipts = SynchroReader.getTransactionsWithLock("0123456789", true);};
        Runnable task2 = () -> { actualExpences = SynchroReader.getTransactionsWithLock("0123456789", false);};

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertEquals(expectedReceipts, actualReceipts);
        assertEquals(expectedExpences, actualExpences);
    }

    @Test
    @SneakyThrows
    void Variant2() {
        Runnable task1 = () -> { actualReceipts = SynchroReader.getTransactionsWithConcurrent("0123456789", true);};
        Runnable task2 = () -> { actualExpences = SynchroReader.getTransactionsWithConcurrent("0123456789", false);};

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertEquals(expectedReceipts, actualReceipts);
        assertEquals(expectedExpences, actualExpences);
    }
}