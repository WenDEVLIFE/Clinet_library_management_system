package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

public class StudentDatabase {

    private static volatile StudentDatabase instance;

    public static StudentDatabase getInstance() {
        if (instance == null) {
            synchronized (StudentDatabase.class) {
                if (instance == null) {
                    instance = new StudentDatabase();
                }
            }
        }
        return instance;
    }


    public void insertStudent(Map<String, String> studentData) {
        String query = "INSERT INTO student (username, password, full_name, year_and_section, home_address, email_address, student_number, phone_number) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

         try {
             Connection connection = LibrarySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentData.get("username"));
            preparedStatement.setString(2, studentData.get("password"));
            preparedStatement.setString(3, studentData.get("full_name"));
            preparedStatement.setString(4, studentData.get("year_and_section"));
            preparedStatement.setString(5, studentData.get("home_address"));
            preparedStatement.setString(6, studentData.get("email_address"));
            preparedStatement.setString(7, studentData.get("student_number"));
            preparedStatement.setString(8, studentData.get("phone_number"));

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new student was inserted successfully!");

                // Optionally, you can show a success message to the user
                JOptionPane.showMessageDialog(null, "Student registered successfully!");
            } else {
                System.out.println("Failed to insert the student.");
            }
         } catch ( Exception e) {
            e.printStackTrace();
         }
    }
}
