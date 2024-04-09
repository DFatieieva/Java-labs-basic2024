package Controller;
import Model.Human;
import Model.Sex;

public class HumanCreator {
    public static Human createHuman(String firstName, String lastName, String patronymic, Sex gender){
        return new Human(firstName, lastName, patronymic, gender) {};
    }
}
