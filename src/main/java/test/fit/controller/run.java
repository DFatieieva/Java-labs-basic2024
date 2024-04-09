package controller;
import model.Human;
import model.University;
import model.Sex;

public class Run {
    public static void main(String[] args) {
       Run run = new Run();
       run.createTypicalUniversity();
    }

    public void createTypicalUniversity() {
        UniversityCreator universityCreator = new UniversityCreator();
        Human rector = new Human("Igor", "Black", "", Sex.MALE);
        University myUniversity = universityCreator.create("My University", rector);
    }
}
