package model;

public class IssueBookModel {

    String id;
    String issue_id;
    String issue_date;
    String return_date;
    String name;
    String isbn;
    String phone_number;
    String email_address;
    String status;

    public IssueBookModel(String id, String issue_id, String issue_date, String return_date, String name, String isbn, String phone_number, String email_address, String status) {
        this.id = id;
        this.issue_id = issue_id;
        this.issue_date = issue_date;
        this.return_date = return_date;
        this.name = name;
        this.isbn = isbn;
        this.phone_number = phone_number;
        this.email_address = email_address;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }
    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IssueBookModel{" +
                "id='" + id + '\'' +
                ", issue_id='" + issue_id + '\'' +
                ", issue_date='" + issue_date + '\'' +
                ", return_date='" + return_date + '\'' +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email_address='" + email_address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }



}
