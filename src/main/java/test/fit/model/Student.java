package model;


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
}
