package database;

import model.IssueBookModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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

    public List<IssueBookModel> getIssueBook() {
        String query = "SELECT * FROM issue_books";
        List<IssueBookModel> issueBooks = new ArrayList<>();

        try {
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("book_id");
                String issue_id = resultSet.getString("issue_id");
                String issue_date = resultSet.getString("issue_date");
                String return_date = resultSet.getString("return_date");
                String name = resultSet.getString("name");
                String isbn = resultSet.getString("isbn");
                String phone_number = resultSet.getString("phone_number");
                String email_address = resultSet.getString("email_address");
                String status = resultSet.getString("status");

                IssueBookModel issueBookModel = new IssueBookModel(id, issue_id, issue_date, return_date, name, isbn, phone_number, email_address, status);
                issueBooks.add(issueBookModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return issueBooks;
    }

    // Add methods for issuing books, returning books, etc.

}
