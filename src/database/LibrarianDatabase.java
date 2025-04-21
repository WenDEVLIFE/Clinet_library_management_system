package database;

import model.LibraryModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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

    public List<LibraryModel> getLibrarian(){

         List <LibraryModel> librarianList =  new ArrayList<>();
        String query = "SELECT * FROM librarian";

        try {
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("user_id");
                String librarianId = resultSet.getString("librarian_id");
                String fullName = resultSet.getString("full_name");
                String password = resultSet.getString("password");
                String birthdate = resultSet.getString("birthdate");
                String homeAddress = resultSet.getString("home_address");
                String gwa = String.valueOf(resultSet.getDouble("gwa"));
                String phoneNumber = resultSet.getString("phone_number");
                String emailAddress = resultSet.getString("email_address");

                LibraryModel librarianModel = new LibraryModel(id, librarianId, fullName, password, birthdate, homeAddress, gwa, phoneNumber, emailAddress);

                librarianList.add(librarianModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return librarianList;

    }
}
