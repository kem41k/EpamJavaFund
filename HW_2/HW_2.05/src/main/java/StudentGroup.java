import lombok.Getter;
import java.util.HashMap;

public class StudentGroup {
    public static enum SubjectName {
        MATH,
        PHYSICS,
        ASTRONOMY,
        GEOMETRY,
        COMPUTER_SCIENCE,
        LITERATURE,
        HISTORY
    }

    public static enum MarkType {
        Integer,
        Double
    }

    @Getter private SubjectName subjectName;
    @Getter private MarkType markType;
    @Getter private HashMap<String, Mark> academicProgress;

    public StudentGroup(SubjectName subjectName, MarkType markType) {
        this.subjectName = subjectName;
        this.markType = markType;
        academicProgress = new HashMap<>();
    }

    @Override
    public String toString() {
        return String.format("%-20s %s", subjectName.toString(), markType.toString());
    }

    public boolean addStudentProgress(String studentName, Mark studentMark) {
        // Wrong type
        if (!studentMark.getMark().getClass().getName().substring(10).equals(markType.toString()))
            return false;
        academicProgress.put(studentName, studentMark);
        return true;
    }

    public static HashMap<SubjectName, Mark> getProgressByName(String name, StudentGroup[] groups) {
        HashMap<SubjectName, Mark> progress = new HashMap<>();
        for (StudentGroup group : groups) {
            Mark groupMark = group.getAcademicProgress().get(name);
            if (groupMark != null)
                progress.put(group.subjectName, groupMark);
        }
        return progress;
    }
}
