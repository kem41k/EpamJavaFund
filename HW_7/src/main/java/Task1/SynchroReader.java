package Task1;

import lombok.Cleanup;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static javax.xml.stream.XMLStreamConstants.*;

public class SynchroReader {

    // Gets receipts if true and expences otherwise
    public static List<Transaction> getTransactions(String accountNumber, boolean option) {
        List<Transaction> list = new ArrayList<>();
        String text;
        Transaction currTransaction = null;
        XMLInputFactory factory = XMLInputFactory.newFactory();
        try {
            @Cleanup XMLStreamReader reader = factory.createXMLStreamReader(
                    new FileInputStream(new File("src\\test\\resources\\MoneyTransactions.xml")));
            String tagName = null;

            while (reader.hasNext()) {
                switch (reader.next()) {
                    case START_ELEMENT:
                        if ((tagName = reader.getLocalName()).equals("transaction"))
                            currTransaction = new Transaction();
                        break;
                    case CHARACTERS:
                        if (!(text = reader.getText().trim()).isEmpty())
                            switch (tagName) {
                                case "from":
                                    currTransaction.setAccountFrom(text);
                                    break;
                                case "to":
                                    currTransaction.setAccountTo(text);
                                    break;
                                case "amount":
                                    currTransaction.setAmount(text);
                                    break;
                                case "date":
                                    currTransaction.setDate(text);
                                    break;
                            }
                        break;
                    case END_ELEMENT:
                        if ((tagName = reader.getLocalName()).equals("transaction")) {
                            if ((option && currTransaction.getAccountFrom().equals(accountNumber)) ||
                                    !option && currTransaction.getAccountTo().equals(accountNumber))
                                list.add(currTransaction);
                        }

                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (XMLStreamException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    // Synchronization with synchronized keyword
    private static Object lock1 = new Object();

    public static List<Transaction> getTransactionsWithLock(String accountNumber, boolean option) {
        List<Transaction> result = null;
        synchronized (lock1) {
            result = getTransactions(accountNumber, option);
        }
        return result;
    }

    // Synchronization with java.util.concurrent
    private static Lock lock2 = new ReentrantLock();

    public static List<Transaction> getTransactionsWithoutLock(String accountNumber, boolean option) {
        List<Transaction> result = null;
        lock2.lock();
        result = getTransactions(accountNumber, option);
        lock2.unlock();
        return result;
    }
}
