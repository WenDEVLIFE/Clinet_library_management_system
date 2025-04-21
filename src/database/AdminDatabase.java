package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
