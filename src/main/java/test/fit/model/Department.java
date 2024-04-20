
package lab_4.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private Human head;
    @SerializedName("groups")
    private List<Group> groups;

    public Department() {
    }

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
        groups = new ArrayList<>();
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

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    @Override
    public String toString() {
        return "Department{" + name + ", " + head + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) && Objects.deepEquals(head, that.head) &&
                Objects.deepEquals(groups, that.groups);
    }
}
