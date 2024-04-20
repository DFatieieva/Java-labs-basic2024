import fit.Controller.*;
import fit.Model.*;
import fit.View.GsonParser;

public class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        University university = UniversityCreator.createUniversity("НТУ\"Дніпровська Політехніка\"",
                HumanCreator.createHuman("Олександр", "Азюковський", "Олександрович", Sex.MALE));
        Faculty faculty = FacultyCreator.createFaculty("Факультет інформаційних технологій",
                HumanCreator.createHuman("Марина", "Гудима", "Василіївна", Sex.FEMALE));
        university.addFaculty(faculty);
        Department department = DepartmentCreator.createDepartment("Кафедра інформаційних технологій",
                HumanCreator.createHuman("Олена", "Кобзар", "Павлівна", Sex.MALE));
        faculty.addDepartment(department);

        Human head = HumanCreator.createHuman("Володимир", "Манєвський", "Дмитрійович", Sex.MALE);
        Group group1 = GroupCreator.createGroup("126-20-1", head);
        Group group2 = GroupCreator.createGroup("126-20-2", head);
        Group group3 = GroupCreator.createGroup("126-20-3", head);
        department.addGroup(group1);
        department.addGroup(group2);
        department.addGroup(group3);

        Student student11 = StudentCreator.createStudent("Діана", "Фатєєва", "Олегівна",
                Sex.FEMALE, group1);
        Student student12 = StudentCreator.createStudent("Олег", "Сдобніков", "Олегович",
                Sex.FEMALE, group1);
        Student student13 = StudentCreator.createStudent("Марина", "Павлюк", "Генадіївна",
                Sex.FEMALE, group1);
        Student student21 = StudentCreator.createStudent("Марія", "Помазан", "Олегівна",
                Sex.MALE, group2);
        Student student22 = StudentCreator.createStudent("Дмитро", "Зеленський", "Дмитрович",
                Sex.MALE, group2);
        Student student31 = StudentCreator.createStudent("Аліна", "Верба", "Владиславівна",
                Sex.FEMALE, group2);
        Student student32 = StudentCreator.createStudent("Паша", "Висоцький", "Дмитрович",
                Sex.MALE, group3);
        group1.addStudent(student11);
        group1.addStudent(student12);
        group1.addStudent(student13);
        group2.addStudent(student21);
        group2.addStudent(student22);
        group3.addStudent(student31);
        group3.addStudent(student32);

        GsonParser.writeJson(university);
        System.out.println(university.equals(GsonParser.readJson()));
    }
}
