package controller;

import lab_4.Model.Human;
import lab_4.Model.University;

public class UniversityCreator {
    public static University createUniversity(String name, Human head) {
        return new University(name, head);
    }
}
