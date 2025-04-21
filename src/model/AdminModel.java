package model;

public class AdminModel {
    final String id;
    final String adminID;
    final String fullname;
    final String keyPassword;
    final String educationAttainment;
    final String phoneNumber;
    final String emailAddress;
    final String homeAddress;
    final String adminNumber;
    final String password;

    public AdminModel(String id, String adminID, String fullname, String keyPassword, String educationAttainment, String phoneNumber, String emailAddress, String homeAddress, String adminNumber, String password) {
        this.id = id;
        this.adminID = adminID;
        this.fullname = fullname;
        this.keyPassword = keyPassword;
        this.educationAttainment = educationAttainment;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.homeAddress = homeAddress;
        this.adminNumber = adminNumber;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getAdminID() {
        return adminID;
    }
    public String getFullname() {
        return fullname;
    }
    public String getKeyPassword() {
        return keyPassword;
    }
    public String getEducationAttainment() {
        return educationAttainment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getAdminNumber() {
        return adminNumber;
    }

    public String getPassword() {
        return password;
    }



    @Override
    public String toString() {
        return "AdminModel{" +
                "id='" + id + '\'' +
                ", adminID='" + adminID + '\'' +
                ", fullname='" + fullname + '\'' +
                ", keyPassword='" + keyPassword + '\'' +
                ", educationAttainment='" + educationAttainment + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", adminNumber='" + adminNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
