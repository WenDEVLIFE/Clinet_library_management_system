package database;

import model.BookModel;
import model.BorrowBookModel;
import model.PendingBorrowModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BookDatabase {

    private static volatile BookDatabase instance;

    public static BookDatabase getInstance() {
        if (instance == null) {
            synchronized (BookDatabase.class) {
                if (instance == null) {
                    instance = new BookDatabase();
                }
            }
        }
        return instance;
    }

    public void insertBook(Map<String, String> bookData) {
        String insertQuery = "INSERT INTO books (book_title, book_author, date_publish, book_genre, isbn, status) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            int isbn = Integer.parseInt(bookData.get("isbn"));
            preparedStatement.setString(1, bookData.get("book_title"));
            preparedStatement.setString(2, bookData.get("book_author"));
            preparedStatement.setString(3, bookData.get("date_published"));
            preparedStatement.setString(4, bookData.get("book_genre"));
            preparedStatement.setInt(5, isbn);
            preparedStatement.setString(6,"Available");

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new book was inserted successfully!");
                // Optionally, you can show a success message to the user
                JOptionPane.showMessageDialog(null, "Book registered successfully!");
            } else {
                System.out.println("Failed to insert the book.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public List<BookModel> getBooks(){
        String query = "SELECT * FROM books";
        List<BookModel> bookList = new ArrayList<>();

        try{
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String book_id = resultSet.getString("book_id");
                String book_title = resultSet.getString("book_title");
                String book_author = resultSet.getString("book_author");
                String book_genre = resultSet.getString("book_genre");
                String date_published = resultSet.getString("date_publish");
                String isbn = resultSet.getString("isbn");
                String status = resultSet.getString("status");

                BookModel bookModel = new BookModel(book_id, book_title, book_author, book_genre, date_published, isbn, status);
                bookList.add(bookModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookList;
   }

    public List<BookModel> getBooksAvailable(){
        String query = "SELECT * FROM books WHERE status = 'Available'";
        List<BookModel> bookList = new ArrayList<>();

        try{
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String book_id = resultSet.getString("book_id");
                String book_title = resultSet.getString("book_title");
                String book_author = resultSet.getString("book_author");
                String book_genre = resultSet.getString("book_genre");
                String date_published = resultSet.getString("date_publish");
                String isbn = resultSet.getString("isbn");
                String status = resultSet.getString("status");

                BookModel bookModel = new BookModel(book_id, book_title, book_author, book_genre, date_published, isbn, status);
                bookList.add(bookModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookList;
    }

    public void deleteBook(String bookID) {
        String deleteQuery = "DELETE FROM books WHERE book_id = ?";

        try {
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, bookID);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully!");
                JOptionPane.showMessageDialog(null, "Book deleted successfully!");
            } else {
                System.out.println("Failed to delete the book.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBook(String bookID, Map<String, String> bookData) {

        String updateQuery = "UPDATE books SET book_title = ?, book_author = ?, date_publish = ?, book_genre = ?, isbn = ? WHERE book_id = ?";

        try {
            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setString(1, bookData.get("book_title"));
            preparedStatement.setString(2, bookData.get("book_author"));
            preparedStatement.setString(3, bookData.get("date_published"));
            preparedStatement.setString(4, bookData.get("book_genre"));
            preparedStatement.setString(5, bookData.get("isbn"));
            preparedStatement.setString(6, bookID);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Book updated successfully!");
                JOptionPane.showMessageDialog(null, "Book updated successfully!");
            } else {
                System.out.println("Failed to update the book.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrowBook(String userid, String bookTitle, String isbn, String studentName, String studentNum, String borrowedDate, String returnDate) {
        String checkQuery = "SELECT COUNT(*) FROM borrow_books WHERE user_id = ? AND isbn = ? AND book_title = ? AND student_number = ?";
        String queryBorrow = "INSERT INTO borrow_books (user_id, book_title, isbn, student_name, student_number, borrow_date, return_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        String updateStatusQuery = "UPDATE books SET status = 'Not Available' WHERE isbn = ?";

        try (Connection connection = LibrarySQL.getConnection()) {
            connection.setAutoCommit(false); // Start transaction

            // Check if the user has already borrowed the book
            try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
                checkStatement.setString(1, userid);
                checkStatement.setString(2, isbn);
                checkStatement.setString(3, bookTitle);
                checkStatement.setString(4, studentNum);
                ResultSet resultSet = checkStatement.executeQuery();

                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "You have already borrowed this book.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Insert the borrow record
            try (PreparedStatement borrowStatement = connection.prepareStatement(queryBorrow)) {
                borrowStatement.setString(1, userid);
                borrowStatement.setString(2, bookTitle);
                borrowStatement.setString(3, isbn);
                borrowStatement.setString(4, studentName);
                borrowStatement.setString(5, studentNum);
                borrowStatement.setString(6, borrowedDate);
                borrowStatement.setString(7, returnDate);

                int rowsInserted = borrowStatement.executeUpdate();
                if (rowsInserted <= 0) {
                    connection.rollback(); // Rollback transaction if insertion fails
                    JOptionPane.showMessageDialog(null, "Failed to borrow the book.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Update the book status to "Not Available"
            try (PreparedStatement updateStatusStatement = connection.prepareStatement(updateStatusQuery)) {
                updateStatusStatement.setString(1, isbn);
                int rowsUpdated = updateStatusStatement.executeUpdate();
                if (rowsUpdated <= 0) {
                    connection.rollback(); // Rollback transaction if update fails
                    JOptionPane.showMessageDialog(null, "Failed to update book status.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            connection.commit(); // Commit transaction
            JOptionPane.showMessageDialog(null, "Book borrowed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BorrowBookModel> getBorrowedBooks(String userid) {

        String query = "SELECT * FROM borrow_books WHERE user_id = ?";
        List<BorrowBookModel> borrowedBooks = new ArrayList<>();

        try{

            Connection connection = LibrarySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String borrow_id = resultSet.getString("borrow_id");
                String user_id = resultSet.getString("user_id");
                String book_title = resultSet.getString("book_title");
                String isbn = resultSet.getString("isbn");
                String student_name = resultSet.getString("student_name");
                String student_number = resultSet.getString("student_number");
                String borrow_date = resultSet.getString("borrow_date");
                String return_date = resultSet.getString("return_date");


                BorrowBookModel bookModel = new BorrowBookModel(borrow_id, user_id, book_title, student_name, student_number, isbn, borrow_date, return_date);
                borrowedBooks.add(bookModel);



            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return borrowedBooks;
    }

    public List<PendingBorrowModel> getBorrowBookWithDueStatus(String userid) {
        String query = "SELECT borrow_id, book_title, return_date FROM borrow_books WHERE user_id = ?";
        List<PendingBorrowModel> pendingBorrowList = new ArrayList<>();

        try (Connection connection = LibrarySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Bind the user_id parameter
            preparedStatement.setString(1, userid);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String borrowId = resultSet.getString("borrow_id");
                    String bookTitle = resultSet.getString("book_title");
                    String returnDateStr = resultSet.getString("return_date");

                    // Parse the return date
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    Date returnDate = dateFormat.parse(returnDateStr);
                    Date currentDate = new Date();

                    // Calculate the difference in days
                    long diffInMillis = returnDate.getTime() - currentDate.getTime();
                    long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);

                    // Determine the due status
                    String dueStatus;
                    if (diffInDays == 0) {
                        dueStatus = "Today";
                    } else if (diffInDays > 0) {
                        dueStatus = diffInDays + " days left";
                    } else {
                        dueStatus = Math.abs(diffInDays) + " day(s) ago";
                    }

                    // Add to the list
                    pendingBorrowList.add(new PendingBorrowModel(borrowId, bookTitle, dueStatus));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pendingBorrowList;
    }
}
