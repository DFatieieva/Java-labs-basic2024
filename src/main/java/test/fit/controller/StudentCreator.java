package controller;

import model.Group;
import model.Sex;
import model.Student;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String patronymic, Sex sex, Group group){
        return new Student(firstName, lastName, patronymic, sex, group);
    }
}
