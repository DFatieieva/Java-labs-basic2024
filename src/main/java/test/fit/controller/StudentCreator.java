package controller;
import model.Group;
import model.Sex;
import model.Student;

public class StudentCreator {
    public static Student createStudent(String name, String surname, String patronymic, Sex gender, Group group) {
        Student student = new Student(patronymic, patronymic, patronymic, gender);
        student.setName(name);
        student.setSurname(surname);
        student.setPatronymic(patronymic);
        student.setSex(gender);
        student.setGroup(group);
        return student;
    }
}
