package database;

import group3_finalproject_omp.ADMIN;
import group3_finalproject_omp.LIBRARIAN;
import group3_finalproject_omp.MAIN;
import group3_finalproject_omp.STUDENT;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDatabase {

    private static volatile  LoginDatabase instance;

    public static LoginDatabase getInstance() {
        if (instance == null) {
            synchronized (LoginDatabase.class) {
                if (instance == null) {
                    instance = new LoginDatabase();
                }
            }
        }
        return instance;
    }

    // This is for login the student
    public void loginStudent(String username, String password, MAIN main) {
        String query = "SELECT * FROM student WHERE username = ? AND password = ?";

        try{
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Login successful for student: " + username);
                JOptionPane.showMessageDialog(null, "Login successful for student: " + username);
                // Proceed to the next step, e.g., open the student dashboard
                STUDENT dashbaord = new STUDENT();
                dashbaord.setVisible(true);
                main.dispose();
            } else {
                System.out.println("Invalid credentials for student: " + username);
                JOptionPane.showMessageDialog(null, "Invalid Username and Password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    // This is for login the admin
    public void loginAdmin(String username, String password, String keycard, MAIN main) {
        String query = "SELECT * FROM admin WHERE admin_id = ? AND password = ? AND key_pass = ?";

        try {
            int keycardInt = Integer.parseInt(keycard);
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, keycardInt);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Retrieve additional admin information
                String adminId = resultSet.getString("admin_id");
                String fullName = resultSet.getString("full_name");

                System.out.println("Login successful for admin: " + username);
                JOptionPane.showMessageDialog(null, "Welcome " + fullName + "!");

                // Create admin dashboard and pass admin information
                ADMIN dashboard = new ADMIN();
                // Assuming ADMIN class has methods to set these values
                dashboard.setAdminId(adminId);
                dashboard.setFullName(fullName);

                dashboard.setVisible(true);
                main.dispose();
            } else {
                System.out.println("Invalid credentials for admin: " + username);
                JOptionPane.showMessageDialog(null, "Invalid Admin ID, Password, and Keycard Number.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Keycard must be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // This is for login the librarian
        public void loginLibrarian(String username, String password, MAIN main) {
            String query = "SELECT * FROM librarian WHERE librarian_id = ? AND password = ?";

            try {
                Connection connection = LibrarySQL.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // Retrieve additional admin information
                    String adminId = resultSet.getString("librarian_id");
                    String fullName = resultSet.getString("full_name");

                    System.out.println("Login successful for admin: " + username);
                    JOptionPane.showMessageDialog(null, "Welcome " + fullName + "!");

                    JOptionPane.showMessageDialog(main, "Login successful!");
                    LIBRARIAN dashbaord = new LIBRARIAN();
                    dashbaord.setVisible(true);
                    main.dispose();
                } else {
                    System.out.println("Invalid credentials for admin: " + username);
                    JOptionPane.showMessageDialog(null, "Invalid Admin ID, Password, and Keycard Number.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Keycard must be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
    }

}
