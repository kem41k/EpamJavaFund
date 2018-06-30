package Task1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
public class CrazyLogger {
    @Getter private StringBuilder log;

    public void addMessage(String message) {
        LocalDateTime dateTime = LocalDateTime.now();
        log.append(String.format("%s - %s\n", dateTime.format(DateTimeFormatter.ofPattern("dd-MM-YYYY : HH-mm")), message));
    }

    public void printAllMessages() {
        System.out.println(log);
    }

    public StringBuilder getMessageByPhrase(String phrase) {
        StringBuilder result = new StringBuilder("");
        String[] messages = log.toString().split("\n");
        for (String message : messages)
            if (message.contains(phrase))
                result.append(message + "\n");
        return result;
    }

    // Date format: dd-mm-YYYY : hh-mm
    public StringBuilder getMessagesBetweenDates(String dateStart, String dateEnd) {
        StringBuilder result = new StringBuilder("");
        String[] messages = log.toString().split("\n");
        // Search for message with first date
        int firstMessageId = -1;
        for (int i = 0; i < messages.length; i++)
            if (messages[i].contains(dateStart)) {
                firstMessageId = i;
                break;
            }
        if (firstMessageId < 0) return result;
        while (firstMessageId < messages.length &&
                messages[firstMessageId].substring(0, 18).compareTo(dateEnd) <= 0) {
            result.append(messages[firstMessageId] + "\n");
            firstMessageId++;
        }
        return result;
    }
}
