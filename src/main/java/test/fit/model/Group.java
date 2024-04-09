package model;

public class Group {
    private String name;
    private Human head;

    public Group(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    // Гетери та сетери
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
}
