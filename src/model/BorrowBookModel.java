package model;

public class BorrowBookModel {
    String id;
    String userid;
    String bookTitle;
    String studentName;
    String studentNum;
    String isbn;
    String borrowedDate;
    String returnDate;

    public BorrowBookModel(String id, String userid, String bookTitle, String studentName, String studentNum, String isbn, String borrowedDate, String returnDate) {
        this.id = id;
        this.userid = userid;
        this.bookTitle = bookTitle;
        this.studentName = studentName;
        this.studentNum = studentNum;
        this.isbn = isbn;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getStudentName() {
        return studentName;
    }


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowBookModel{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", isbn='" + isbn + '\'' +
                ", borrowedDate='" + borrowedDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
