package model;

public class LibraryModel {
    final String id;
    final String librarianId;
    final String fullName;
    final String password;
    final String birthdate;
    final String homeAddress;
    final String gwa;
    final String phoneNumber;
    final String emailAddress;

    public LibraryModel(String id, String librarianId, String fullName, String password, String birthdate, String homeAddress, String gwa, String phoneNumber, String emailAddress) {
        this.id = id;
        this.librarianId = librarianId;
        this.fullName = fullName;
        this.password = password;
        this.birthdate = birthdate;
        this.homeAddress = homeAddress;
        this.gwa = gwa;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getId() {
        return id;
    }
    public String getLibrarianId() {
        return librarianId;
    }
    public String getFullName() {
        return fullName;
    }
    public String getPassword() {
        return password;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public String getHomeAddress() {
        return homeAddress;
    }
    public String getGwa() {
        return gwa;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "LibraryModel{" +
                "id='" + id + '\'' +
                ", librarianId='" + librarianId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", gwa='" + gwa + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

}
