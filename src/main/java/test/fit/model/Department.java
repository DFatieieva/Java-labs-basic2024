package model;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Group> groups;
    private Human head;

    public Department(String name) {
        this.name = name;
        this.groups = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
    }

    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }
}
