package Controller;
import Model.Human;
import Model.University;

public class UniversityCreator {
    public static University createUniversity(String name, Human head) {
        return new University(name, head);
    }
}
