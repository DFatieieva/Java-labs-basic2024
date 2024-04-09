package model;

public class Human {
    private String name;
    private String surname;
    private String patronymic;
    private Sex gender;

    public Human(String name, String surname, String patronymic, Sex gender) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
    }

    // Гетери та сетери
    public String getFirstName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return surname;
    }

    public void setLastName(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return patronymic;
    }

    public void setMiddleName(String patronymic) {
        this.patronymic = patronymic;
    }

    public Sex getSex() {
        return gender;
    }

    public void setSex(Sex gender) {
        this.gender = gender;
    }
}
