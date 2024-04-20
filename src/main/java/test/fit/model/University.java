package lab_4.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
    private String name;
    private Human head;
    @SerializedName("faculties")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) && Objects.deepEquals(head, that.head) &&
                Objects.deepEquals(faculties, that.faculties);
    }
}
