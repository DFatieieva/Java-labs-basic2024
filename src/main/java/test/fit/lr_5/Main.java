package lr_5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = searchByMonth(Month.MAY);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> searchByMonth(Month month){
        List<Student> list = DatabaseQueryExecutor.getStudents();
        List<Student> students = new ArrayList<>();
        for (Student student : list) {
            if (student.getDateOfBirth().getMonth() == month.ordinal()) {
                students.add(student);
            }
        }

        return students;
    }
}
