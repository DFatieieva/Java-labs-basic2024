package View;

import com.google.gson.*;
import Controller.HumanCreator;
import Model.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonParser {
    private static final String FILE_NAME = "university.json";

    public static void writeJson(University university) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(convertUniversityToJson(university), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JsonObject convertUniversityToJson(University university) {
        JsonObject universityJson = new JsonObject();
        universityJson.addProperty("name", university.getName());

        JsonObject universityHead = new JsonObject();
        universityHead.addProperty("firstName", university.getHead().getFirstName());
        universityHead.addProperty("lastName", university.getHead().getLastName());
        universityHead.addProperty("patronymic", university.getHead().getPatronymic());
        universityHead.addProperty("sex", university.getHead().getSex().toString());
        universityJson.add("head", universityHead);

        JsonArray facultiesJson = new JsonArray();
        for (Faculty faculty : university.getFaculties()) {
            JsonObject facultyJson = new JsonObject();
            facultyJson.addProperty("name", faculty.getName());

            JsonObject facultyHead = new JsonObject();
            facultyHead.addProperty("firstName", faculty.getHead().getFirstName());
            facultyHead.addProperty("lastName", faculty.getHead().getLastName());
            facultyHead.addProperty("patronymic", faculty.getHead().getPatronymic());
            facultyHead.addProperty("sex", faculty.getHead().getSex().toString());
            facultyJson.add("head", facultyHead);

            JsonArray departmentsJson = new JsonArray();
            for (Department department : faculty.getDepartments()) {
                JsonObject departmentJson = new JsonObject();
                departmentJson.addProperty("name", department.getName());

                JsonObject departmentHead = new JsonObject();
                departmentHead.addProperty("firstName", department.getHead().getFirstName());
                departmentHead.addProperty("lastName", department.getHead().getLastName());
                departmentHead.addProperty("patronymic", department.getHead().getPatronymic());
                departmentHead.addProperty("sex", department.getHead().getSex().toString());
                departmentJson.add("head", departmentHead);

                JsonArray groupsJson = new JsonArray();
                for (Group group : department.getGroups()) {
                    JsonObject groupJson = new JsonObject();
                    groupJson.addProperty("name", group.getName());

                    JsonObject groupHead = new JsonObject();
                    groupHead.addProperty("firstName", group.getHead().getFirstName());
                    groupHead.addProperty("lastName", group.getHead().getLastName());
                    groupHead.addProperty("patronymic", group.getHead().getPatronymic());
                    groupHead.addProperty("sex", group.getHead().getSex().toString());
                    groupJson.add("head", groupHead);

                    JsonArray studentsJson = new JsonArray();
                    for (Student student : group.getStudents()) {
                        JsonObject studentJson = new JsonObject();
                        studentJson.addProperty("firstName", student.getFirstName());
                        studentJson.addProperty("lastName", student.getLastName());
                        studentJson.addProperty("patronymic", student.getPatronymic());
                        studentJson.addProperty("sex", student.getSex().toString());
                        studentsJson.add(studentJson);
                    }
                    groupJson.add("students", studentsJson);
                    groupsJson.add(groupJson);
                }
                departmentJson.add("groups", groupsJson);
                departmentsJson.add(departmentJson);
            }
            facultyJson.add("departments", departmentsJson);
            facultiesJson.add(facultyJson);
        }
        universityJson.add("faculties", facultiesJson);
        return universityJson;
    }

    public static University readJson(){
        University university = null;

        try (FileReader reader = new FileReader(FILE_NAME)) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(reader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            String universityName = jsonObject.get("name").getAsString();
            JsonObject universityHead = jsonObject.get("head").getAsJsonObject();
            String firstNameU = universityHead.get("firstName").getAsString();
            String lastNameU = universityHead.get("lastName").getAsString();
            String patronymicU = universityHead.get("patronymic").getAsString();
            Sex sexU = Sex.valueOf(universityHead.get("sex").getAsString());

            university = new University(universityName, HumanCreator.createHuman(firstNameU, lastNameU, patronymicU, sexU));

            JsonArray facultiesJson = jsonObject.getAsJsonArray("faculties");
            for (JsonElement facultyElement : facultiesJson) {
                JsonObject facultyObject = facultyElement.getAsJsonObject();
                String facultyName = facultyObject.get("name").getAsString();

                JsonObject facultyHead = facultyObject.get("head").getAsJsonObject();
                String firstNameF = facultyHead.get("firstName").getAsString();
                String lastNameF = facultyHead.get("lastName").getAsString();
                String patronymicF = facultyHead.get("patronymic").getAsString();
                Sex sexF = Sex.valueOf(facultyHead.get("sex").getAsString());

                Faculty faculty = new Faculty(facultyName, HumanCreator.createHuman(firstNameF, lastNameF, patronymicF, sexF));

                JsonArray departmentsJson = facultyObject.getAsJsonArray("departments");
                for (JsonElement departmentElement : departmentsJson) {
                    JsonObject departmentObject = departmentElement.getAsJsonObject();
                    String departmentName = departmentObject.get("name").getAsString();

                    JsonObject departmentHead = departmentObject.get("head").getAsJsonObject();
                    String firstNameD = departmentHead.get("firstName").getAsString();
                    String lastNameD = departmentHead.get("lastName").getAsString();
                    String patronymicD = departmentHead.get("patronymic").getAsString();
                    Sex sexD = Sex.valueOf(departmentHead.get("sex").getAsString());

                    Department department = new Department(departmentName, HumanCreator.createHuman(firstNameD, lastNameD, patronymicD, sexD));

                    JsonArray groupsJson = departmentObject.getAsJsonArray("groups");
                    for (JsonElement groupElement : groupsJson) {
                        JsonObject groupObject = groupElement.getAsJsonObject();
                        String groupName = groupObject.get("name").getAsString();

                        JsonObject groupHead = groupObject.get("head").getAsJsonObject();
                        String firstNameG = groupHead.get("firstName").getAsString();
                        String lastNameG = groupHead.get("lastName").getAsString();
                        String patronymicG = groupHead.get("patronymic").getAsString();
                        Sex sexG = Sex.valueOf(groupHead.get("sex").getAsString());

                        Group group = new Group(groupName, HumanCreator.createHuman(firstNameG, lastNameG, patronymicG, sexG));

                        JsonArray studentsJson = groupObject.getAsJsonArray("students");

                        for (JsonElement studentElement : studentsJson) {
                            JsonObject studentObject = studentElement.getAsJsonObject();
                            String firstName = studentObject.get("firstName").getAsString();
                            String lastName = studentObject.get("lastName").getAsString();
                            String patronymic = studentObject.get("patronymic").getAsString();
                            String sex = studentObject.get("sex").getAsString();
                            Student student = new Student(firstName, lastName, patronymic, Sex.valueOf(sex), group);

                            group.addStudent(student);
                        }

                        department.addGroup(group);
                    }

                    faculty.addDepartment(department);
                }

                university.addFaculty(faculty);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return university;
    }
}
