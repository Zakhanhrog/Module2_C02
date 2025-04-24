import java.util.*;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int numberPhone;

    public Student(String name, int age, int numberPhone) {
        this.name = name;
        this.age = age;
        this.numberPhone = numberPhone;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return "Student [" +
                "name: " + name +
                ", age: " + age +
                ", numberPhone: " + numberPhone +
                " ]";
    }

    @Override
    public int compareTo(Student o) {
//        return this.name.compareTo(o.name);
        return this.numberPhone - o.numberPhone;
    }

}

