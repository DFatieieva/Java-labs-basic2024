package lab_3.Model;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private Human head;
    private List<Faculty> faculties;

    public University() {
    }

    public University(String name, Human head) {
        this.name = name;
        this.head = head;
        faculties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }

    @Override
    public String toString() {
        return "University{" + name + ", " + head + '}';
    }
}
