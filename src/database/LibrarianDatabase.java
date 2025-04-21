package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

public class LibrarianDatabase {
    private static volatile  LibrarianDatabase instance;

    public static LibrarianDatabase getInstance() {
        if (instance == null) {
            synchronized (LibrarianDatabase.class) {
                if (instance == null) {
                    instance = new LibrarianDatabase();
                }
            }
        }
        return instance;
    }


    public void insertLibrarian(Map<String, String> librarianData) {
        String query = "INSERT INTO librarian (librarian_id, password, full_name, birthdate, home_address, gwa, phone_number, email_address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = LibrarySQL.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            double gwa = Double.parseDouble(librarianData.get("gwa"));
            preparedStatement.setString(1, librarianData.get("librarian_id"));
            preparedStatement.setString(2, librarianData.get("password"));
            preparedStatement.setString(3, librarianData.get("full_name"));
            preparedStatement.setString(4, librarianData.get("birthdate"));
            preparedStatement.setString(5, librarianData.get("home_address"));
            preparedStatement.setDouble(6, gwa);
            preparedStatement.setString(7, librarianData.get("phone_number"));
            preparedStatement.setString(8, librarianData.get("email_address"));

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new librarian was inserted successfully!");

                // Optionally, you can show a success message to the user
                JOptionPane.showMessageDialog(null, "Librarian registered successfully!");
            } else {
                System.out.println("Failed to insert the librarian.");
            }

        } catch (Exception e) {
             e.printStackTrace();
        }
    }
}
