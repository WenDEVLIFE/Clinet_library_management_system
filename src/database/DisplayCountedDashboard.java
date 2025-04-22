package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayCountedDashboard {

    private static volatile DisplayCountedDashboard instance;

    public static DisplayCountedDashboard getInstance() {
        if (instance == null) {
            synchronized (DisplayCountedDashboard.class) {
                if (instance == null) {
                    instance = new DisplayCountedDashboard();
                }
            }
        }
        return instance;
    }


    public int getNumberOfBooks() {
        String query = "SELECT COUNT(*) FROM books WHERE status = 'Available'";
        int count = 0;

        try (Connection connection = LibrarySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                count = resultSet.getInt(1); // Retrieve the count from the first column
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving the number of books: " + e.getMessage());
        }

        return count;
    }

    public int getNumberOfIssuedBooks() {
        String query = "SELECT COUNT(*) FROM issue_books WHERE status IN ('AVAILABLE', 'NOT AVAILABLE', 'OVERDUE', 'MISSING')";
        int count = 0;

        try (Connection connection = LibrarySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                count = resultSet.getInt(1); // Retrieve the count from the first column
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving the number of issued books: " + e.getMessage());
        }

        return count;
    }

    public int getNumberOfReturnedBooks() {
        String query = "SELECT COUNT(*) FROM issue_books WHERE status = 'Returned'";
        int count = 0;

        try (Connection connection = LibrarySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                count = resultSet.getInt(1); // Retrieve the count from the first column
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving the number of returned books: " + e.getMessage());
        }

        return count;
    }

    public int getNumberOfOverdueBooks() {
        String query = "SELECT COUNT(*) FROM issue_books WHERE TRIM(LOWER(status)) = 'overdue'";
        int count = 0;

        try (Connection connection = LibrarySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                count = resultSet.getInt(1); // Retrieve the count from the first column
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving the number of overdue books: " + e.getMessage());
        }

        return count;
    }

    public int getNumberOfStudents() {
        String query = "SELECT COUNT(*) FROM student";
        int count = 0;

        try (Connection connection = LibrarySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                count = resultSet.getInt(1); // Retrieve the count from the first column
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving the number of students: " + e.getMessage());
        }

        return count;
    }

    public int getNumberOfLibrarians() {
        String query = "SELECT COUNT(*) FROM librarian";
        int count = 0;

        try (Connection connection = LibrarySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                count = resultSet.getInt(1); // Retrieve the count from the first column
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving the number of librarians: " + e.getMessage());
        }

        return count;
    }

    public int getNumberOfAdmins() {
        String query = "SELECT COUNT(*) FROM admin";
        int count = 0;

        try (Connection connection = LibrarySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                count = resultSet.getInt(1); // Retrieve the count from the first column
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving the number of admins: " + e.getMessage());
        }

        return count;
    }
}
