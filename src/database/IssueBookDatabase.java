package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

public class IssueBookDatabase {
    private static volatile IssueBookDatabase instance;

    public static IssueBookDatabase getInstance() {
        if (instance == null) {
            synchronized (IssueBookDatabase.class) {
                if (instance == null) {
                    instance = new IssueBookDatabase();
                }
            }
        }
        return instance;
    }

    public void insertIssueBook(Map<String, String> issueData) {
        String insertQuery = "INSERT INTO issue_books (issue_id, issue_date, return_date, name, isbn, phone_number, email_address, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            int isbn = Integer.parseInt(issueData.get("isbn"));
            preparedStatement.setString(1, issueData.get("issue_id"));
            preparedStatement.setString(2, issueData.get("issue_date"));
            preparedStatement.setString(3, issueData.get("return_date"));
            preparedStatement.setString(4, issueData.get("name"));
            preparedStatement.setInt(5, isbn);
            preparedStatement.setString(6, issueData.get("phone_number"));
            preparedStatement.setString(7, issueData.get("email_address"));
            preparedStatement.setString(8, issueData.get("status"));


            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new book issue was recorded successfully!");
                // Optionally, you can show a success message to the user
                JOptionPane.showMessageDialog(null, "Book issued successfully!");
            } else {
                System.out.println("Failed to record the book issue.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add methods for issuing books, returning books, etc.
}
