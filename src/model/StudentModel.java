package model;

public class StudentModel {

    final String userid;
    final String username;
    final String password;
    final String fullname;
    final String yearAndSection;
    final String homeAddress;
    final String emailAddress;
    final String studentNumber;
    final String phoneNumber;


    public StudentModel(String userid, String username, String fullname, String password, String yearAndSection, String homeAddress, String emailAddress, String studentNumber, String phoneNumber) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.yearAndSection = yearAndSection;
        this.homeAddress = homeAddress;
        this.emailAddress = emailAddress;
        this.studentNumber = studentNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }



    public String getYearAndSection() {
        return yearAndSection;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", yearAndSection='" + yearAndSection + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
