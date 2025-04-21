package model;

public class BookModel {
    final String book_id;
    final String book_title;
    final String book_author;
    final String book_genre;
    final String date_published;
    final String isbn;
    final String status;

    public BookModel(String book_id, String book_title, String book_author, String book_genre, String date_published, String isbn, String status) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_genre = book_genre;
        this.date_published = date_published;
        this.isbn = isbn;
        this.status = status;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_genre() {
        return book_genre;
    }

    public void setBook_genre(String book_genre) {
        this.book_genre = book_genre;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "book_id='" + book_id + '\'' +
                ", book_title='" + book_title + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_genre='" + book_genre + '\'' +
                ", date_published='" + date_published + '\'' +
                ", isbn='" + isbn + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
