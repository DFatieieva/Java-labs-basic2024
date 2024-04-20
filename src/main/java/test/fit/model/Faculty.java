package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private Human head;
    @SerializedName("departments")
    private List<Department> departments;

    public Faculty() {
    }

    public Faculty(String name, Human head) {
        this.name = name;
        this.head = head;
        departments = new ArrayList<>();
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department){
        departments.add(department);
    }

    @Override
    public String toString() {
        return "Faculty{" + name + ", " + head + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) && Objects.deepEquals(head, faculty.head) &&
                Objects.deepEquals(departments, faculty.departments);
    }
}
