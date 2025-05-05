import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Student student = new Student();
        Result result = getResult();
        try{
            student.setName(result.name());
            student.setNumberPhone(result.numberPhone());
            student.setAge(result.age());
            Student.validate(student);
        }catch (IllegalArgumentException e){
            System.out.println("Du lieu nhap vao khong hop le");
        }finally {
            System.out.println("Hoan thanh!");
        }
        writeFileStudent(student);
        try {
            readFileStudent();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Doc file thanh cong!");
            System.gc();
        }
    }

    private static Result getResult() {
        int numberPhone;
        int age;
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        name = scanner.nextLine();
        System.out.println("Nhap so dien thoai: ");
        numberPhone = scanner.nextInt();
        System.out.println("Nhap tuoi: ");
        age = scanner.nextInt();
        Result result = new Result(name, numberPhone, age);
        return result;
    }

    private record Result(String name, int numberPhone, int age) {
    }

    public static void writeFileStudent(Student student) {
        File file = new File("/Users/ngogiakhanh/Documents/Module 2/IO_Binary_File_demo/src/OutputStudent.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.close();
            fos.close();
            System.out.println("Da xong!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Hoan thanh ghi file");
        }
    }
    public static void readFileStudent() throws IOException {
        File file = new File("/Users/ngogiakhanh/Documents/Module 2/IO_Binary_File_demo/src/OutputStudent.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student student= (Student) ois.readObject(); // khong phai khoi tao moi
            System.out.println(student);
            ois.close();
            fis.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}