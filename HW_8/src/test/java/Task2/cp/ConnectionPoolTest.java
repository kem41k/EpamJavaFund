package Task2.cp;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConnectionPoolTest {

    String GET_STUDENTS_SQL = "select id, name, group_id from students";

    String ID_FIELD = "id";
    String NAME_FIELD = "name";
    String GROUP_ID_FIELD = "group_id";

    @Test
    @SneakyThrows
    void get() {
        @Cleanup val connection = ConnectionPool.fromProps().get();
        @Cleanup val statement = connection.createStatement();
        @Cleanup val resultSet = statement.executeQuery(GET_STUDENTS_SQL);
        assertTrue(resultSet.next());
        assertEquals(resultSet.getInt(ID_FIELD), 1);
        assertEquals(resultSet.getString(NAME_FIELD), "Вася Пупкин");
        assertEquals(resultSet.getInt(GROUP_ID_FIELD), 123456);
    }
}