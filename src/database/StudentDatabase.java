package database;

import model.StudentModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public List<StudentModel> getStudent() {
        List<StudentModel> students = new ArrayList<>();
        String query = "SELECT * FROM student";

        try {
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String userid = resultSet.getString("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String yearAndSection = resultSet.getString("year_and_section");
                String homeAddress = resultSet.getString("home_address");
                String emailAddress = resultSet.getString("email_address");
                String studentNumber = resultSet.getString("student_number");
                String phoneNumber = resultSet.getString("phone_number");
                String fullName = resultSet.getString("full_name");

                StudentModel student = new StudentModel(
                        userid, username, password, fullName, yearAndSection,
                        homeAddress, emailAddress, studentNumber, phoneNumber
                );
                students.add(student);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading students: " + e.getMessage());
        }

        return students;
    }
}
