import java.util.Comparator;

public class SortStudentByKey implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getNumberPhone() - s2.getNumberPhone();
    }
}
