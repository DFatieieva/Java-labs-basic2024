package model;
import java.util.ArrayList;
import java.util.List;

public class GroupCreator 
{
    public Group createGroup(int studentCount, int maxCapacity) {
        Group group = new Group();
        StudentCreator studentCreator = new StudentCreator();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(studentCreator.createTypicalStudent());
        }
        group.setStudents(students);
        group.setMaxCapacity(maxCapacity);
        return group;
    }

    public Group createTypicalGroup() {
        return createGroup(3, 10);
    }
}
