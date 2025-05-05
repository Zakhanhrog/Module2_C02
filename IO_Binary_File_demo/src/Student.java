import java.io.DataOutput;
import java.io.Serializable;

public class Student  implements Serializable {
    private String name;
    private int numberPhone;
    private int age;

    public Student(String name, int numberPhone, int age) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.age = age;
    }
    public Student() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void validate(Student student) throws IllegalArgumentException {
        if (student.getName().length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters long");
        }
        if (student.getAge() < 0 || student.getAge() > 120) {
            throw new IllegalArgumentException("Age must be between 1 and 120");
        }
        System.out.println( "Student is validated");
        System.out.println(student);
    }
    @Override
    public String toString() {
        return "Student: " +
                "name: " + name +
                "|| numberPhone: " + numberPhone +
                "|| age: " + age;
    }
}

