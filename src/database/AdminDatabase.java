package database;

import model.AdminModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminDatabase {

    private static volatile AdminDatabase instance;

    public static AdminDatabase getInstance() {
        if (instance == null) {
            synchronized (AdminDatabase.class) {
                if (instance == null) {
                    instance = new AdminDatabase();
                }
            }
        }
        return instance;
    }


    public void insertAdmin(Map<String, String> adminData) {

        String query = "INSERT INTO admin (admin_id, password, full_name, key_pass, education_attainment, phone_number, email_address, home_address, admin_number) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = LibrarySQL.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, adminData.get("admin_id"));
            preparedStatement.setString(2, adminData.get("password"));
            preparedStatement.setString(3, adminData.get("full_name"));
            preparedStatement.setString(4, adminData.get("key_password"));
            preparedStatement.setString(5, adminData.get("education_attainment"));
            preparedStatement.setString(6, adminData.get("phone_number"));
            preparedStatement.setString(7, adminData.get("email_address"));
            preparedStatement.setString(8, adminData.get("home_address"));
            preparedStatement.setString(9, adminData.get("admin_number"));

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new admin was inserted successfully!");

                // Optionally, you can show a success message to the user
                JOptionPane.showMessageDialog(null, "Admin registered successfully!");
            } else {
                System.out.println("Failed to insert the admin.");
            }

        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    public List<AdminModel> getAdmin(){
        List <AdminModel> adminList = new ArrayList<>();
        String query = "SELECT * FROM admin";

        try {
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("user_id");
                String adminID = resultSet.getString("admin_id");
                String fullname = resultSet.getString("full_name");
                String keyPassword = resultSet.getString("key_pass");
                String educationAttainment = resultSet.getString("education_attainment");
                String phoneNumber = resultSet.getString("phone_number");
                String emailAddress = resultSet.getString("email_address");
                String password = resultSet.getString("password");
                String homeAddress = resultSet.getString("home_address");
                String adminNumber = resultSet.getString("admin_number");

                AdminModel adminModel = new AdminModel(id, adminID, fullname, keyPassword, educationAttainment, phoneNumber, emailAddress, homeAddress, adminNumber, password);
                // Add the adminModel to a list or process it as needed
                adminList.add(adminModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return adminList;
    }

    public void deleteAdmin(String adminID) {
        String query = "DELETE FROM admin WHERE admin_id = ?";

        try {
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, adminID);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Admin deleted successfully!");
                JOptionPane.showMessageDialog(null, "Admin deleted successfully!");
            } else {
                System.out.println("Failed to delete the admin.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAdmin(String adminID, Map<String, String> adminData) {
        String query = "UPDATE admin SET password = ?, full_name = ?, key_pass = ?, education_attainment = ?, phone_number = ?, email_address = ?, home_address = ?, admin_number = ? WHERE admin_id = ?";

        try {
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, adminData.get("password"));
            preparedStatement.setString(2, adminData.get("full_name"));
            preparedStatement.setString(3, adminData.get("key_pass"));
            preparedStatement.setString(4, adminData.get("education_attainment"));
            preparedStatement.setString(5, adminData.get("phone_number"));
            preparedStatement.setString(6, adminData.get("email_address"));
            preparedStatement.setString(7, adminData.get("home_address"));
            preparedStatement.setString(8, adminData.get("admin_number"));
            preparedStatement.setString(9, adminID);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Admin updated successfully!");
                JOptionPane.showMessageDialog(null, "Admin updated successfully!");
            } else {
                System.out.println("Failed to update the admin.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
