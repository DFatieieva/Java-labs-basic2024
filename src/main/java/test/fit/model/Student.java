package model;

public class Student extends Human {
    private String studentId; // Додаткове поле для студента

    public Student(String name, String surname, String patronymic, Sex gender, String studentId) {
        super(name, surname, patronymic, gender);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
