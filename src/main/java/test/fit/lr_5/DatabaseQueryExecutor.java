package lr_5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryExecutor {
    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("student_id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setPatronymic(resultSet.getString("patronymic"));
                student.setDateOfBirth(resultSet.getDate("date_of_birth"));
                student.setCardNumber(resultSet.getString("student_card_number"));
                students.add(student);
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }

        return students;
    }
}
