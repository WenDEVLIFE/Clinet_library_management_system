package model;

public class PendingBorrowModel {
    String id;
    String bookTitle;
    String dueStatus;


    public PendingBorrowModel(String id, String bookTitle, String dueStatus) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.dueStatus = dueStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getDueStatus() {
        return dueStatus;
    }

    public void setDueStatus(String dueStatus) {
        this.dueStatus = dueStatus;
    }

    @Override
    public String toString() {
        return "PendingBorrowModel{" +
                "id='" + id + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", dueStatus='" + dueStatus + '\'' +
                '}';
    }


}
