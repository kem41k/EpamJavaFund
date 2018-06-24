import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;

public class StudentGroupTest {
    StudentGroup[] groups;

    @Before
    public void Init() {
        groups = new StudentGroup[3];

        groups[0] = new StudentGroup(StudentGroup.SubjectName.COMPUTER_SCIENCE, StudentGroup.MarkType.Double);
        groups[0].addStudentProgress("John Snow", new Mark(3.9));
        groups[0].addStudentProgress("Jamie Lannister", new Mark(3.75));
        groups[0].addStudentProgress("Prince Dorian", new Mark(2.99));
        groups[0].addStudentProgress("Ned Stark", new Mark(5.0));
        groups[0].addStudentProgress("Sam Tarly", new Mark(4.95));
        groups[0].addStudentProgress("Night King", new Mark(3.48));
        groups[0].addStudentProgress("Deyeneris", new Mark(4.17));

        groups[1] = new StudentGroup(StudentGroup.SubjectName.GEOMETRY, StudentGroup.MarkType.Integer);
        groups[1].addStudentProgress("John Snow", new Mark(3));
        groups[1].addStudentProgress("Tirion Lannister", new Mark(2));
        groups[1].addStudentProgress("Arya Stark", new Mark(4));
        groups[1].addStudentProgress("Deyeneris", new Mark(5));
        groups[1].addStudentProgress("Prince Dorian", new Mark(4));
        groups[1].addStudentProgress("Sam Tarly", new Mark(5));
        groups[1].addStudentProgress("Teon Greyjoy", new Mark(1));

        groups[2] = new StudentGroup(StudentGroup.SubjectName.HISTORY, StudentGroup.MarkType.Double);
        groups[2].addStudentProgress("John Snow", new Mark(4.2));
        groups[2].addStudentProgress("Jamie Lannister", new Mark(4.88));
        groups[2].addStudentProgress("Tirion Lannister", new Mark(2.76));
        groups[2].addStudentProgress("Arya Stark", new Mark(3.98));
        groups[2].addStudentProgress("Ned Stark", new Mark(4.07));
    }

    @Test
    public void addStudentProgress() {
        assertFalse(groups[0].addStudentProgress("John Snow", new Mark(4)));           // Wrong type
        assertFalse(groups[1].addStudentProgress("Jamie Lannister", new Mark(3.75)));  // Wrong type
    }

    @Test
    public void getProgressByName() {
        // John Snow
        HashMap<StudentGroup.SubjectName, Mark> expected = new HashMap<>();
        expected.put(StudentGroup.SubjectName.HISTORY, new Mark(4.2));
        expected.put(StudentGroup.SubjectName.COMPUTER_SCIENCE, new Mark(3.9));
        expected.put(StudentGroup.SubjectName.GEOMETRY, new Mark(3));

        HashMap<StudentGroup.SubjectName, Mark> actual = StudentGroup.getProgressByName("John Snow", groups);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        actual.keySet().stream().forEach((key) -> {
            assertEquals(actual.get(key).toString(), expected.get(key).toString());
        });
    }
}