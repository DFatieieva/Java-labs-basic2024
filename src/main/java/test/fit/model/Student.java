package model;

import java.util.Objects;

public class Student extends Human {
    private Group group;

    public Student(){
        super();
    }
    public Student(String firstName, String lastName, String patronymic, Sex sex, Group group) {
        super(firstName, lastName, patronymic, sex);
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(group.getName(), student.group.getName()) &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(patronymic, student.patronymic) &&
                sex == student.sex;
    }
}
