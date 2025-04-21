package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibrarySQL {
    public static String database_url = "jdbc:sqlite:library.db";

    // Student queries
    public static String checkStudent = "SELECT * FROM student WHERE fullname = ?";
    public static String studentLogin = "SELECT * FROM student WHERE username = ? AND password = ?";

    // Book queries
    public static String getAllBooks = "SELECT * FROM books";
    public static String getBookById = "SELECT * FROM books WHERE id = ?";
    public static String addBook = "INSERT INTO books (title, author, isbn, quantity) VALUES (?, ?, ?, ?)";

    // Loan queries
    public static String borrowBook = "INSERT INTO loans (student_id, book_id, borrow_date, return_date) VALUES (?, ?, ?, ?)";
    public static String returnBook = "UPDATE loans SET returned = 1, actual_return_date = ? WHERE id = ?";


    public static void main(String[] args) {
        testConnection();
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(database_url);
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found", e);
        }
    }

    public static void testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    // Example method to validate student login
    public static boolean validateStudentLogin(String username, String password) {
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(studentLogin)
        ) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Returns true if a matching record is found
            }
        } catch (SQLException e) {
            System.out.println("Login validation error: " + e.getMessage());
            return false;
        }
    }
}