/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group3_finalproject_omp;

import database.*;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yuuki
 */
public class ADMIN extends javax.swing.JFrame {

    String fullname;
    String adminID;
    DefaultTableModel model;
    DefaultTableModel model1;
    DefaultTableModel model2;
    DefaultTableModel model3;
    DefaultTableModel model4;
    DefaultTableModel model5;

    List<StudentModel> studentList;
    List<LibraryModel> librarianList;
    List<AdminModel> adminModelList;
    List<BookModel> bookList;
    List<IssueBookModel> issueBookList;
    List<IssueBookModel> returnBookList;

    int numberOfAvailableBooks;
    int numberOfIssuedBooks;
    int numberOfReturnedBooks;
    int numberOfOverdueBooks;
    int numberOfStudents;
    int numberOfLibrarians;
    int numberOfAdmins;
    
    static String adminId;
    /**
     * Creates new form ADMIN
     */
    public ADMIN(String adminId) {
        ADMIN.adminId = adminId;
        initComponents();
         setIconImage(new ImageIcon(getClass().getResource("/ADM/omp(red).png")).getImage());
         
        jP_ADM_DASHBOARD.setVisible(true);
        jP_ADM_MANAGE_BOOKS.setVisible(false);
        jP_ADM_MANAGE_USERS.setVisible(false);
        jP_ADM_ACCOUNT.setVisible(false);
        
        ADD_BOOK_PANEL.setVisible(false);
        ISSUE_BOOK_PANEL.setVisible(false);
        RETURN_BOOK_PANEL.setVisible(false);
        
        ADMIN_ACCOUNT_PANEL.setVisible(false);
        LIBRARIAN_ACCOUNT_PANEL.setVisible(false);
        STUDENT_ACCOUNT_PANEL.setVisible(false);

        String[] columns = {"ID", "Username", "FullName" ,"Student Number", "Email", "Phone Number", "Home Address", "Year and Section", "Password"};
        model = new DefaultTableModel(columns, 0);
        ST_TABLE.setModel(model);

// Disable auto-resizing to allow horizontal scrolling
        ST_TABLE.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        LoadStudent();

        String[] columns1 = {"Librarian ID", "Full Name", "Password","Birthdate", "Home Address", "GWA", "Phone Number", "Email Address"};
        model1 = new DefaultTableModel(columns1, 0);
        LB_TABLE.setModel(model1);
// Disable auto-resizing to allow horizontal scrolling
        LB_TABLE.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        LoadLibrarian();

        String[] columns2 = {"Admin ID", "Full Name", "Key Password", "Education Attainment", "Phone Number", "Email Address", "Home Address", "Admin Number", "Password"};
        model2 = new DefaultTableModel(columns2, 0);
        AD_TABLE.setModel(model2);

        LoadAdmin();


        String [] columns3 = {"Book ID", "Title", "Author", "Genre", "Date Published", "ISBN", "Status"};
        model3 = new DefaultTableModel(columns3, 0);
        AB_TABLE.setModel(model3);

        LoadBook();

        String [] columns4 = {"Issue ID", "Issue Date", "Return Date", "Name", "ISBN", "Phone Number", "Email Address", "Status"};
        model4 = new DefaultTableModel(columns4, 0);
        IB_TABALE.setModel(model4);

        LoadIssueBook();

         String [] columns5 = {"Issue ID", "Issue Date", "Return Date", "Name", "ISBN", "Phone Number", "Status"};
        model5 = new DefaultTableModel(columns5, 0);
        RB_TABLE.setModel(model5);

        LoadReturnBook();

        initializeDashboard();
    }

    void initializeDashboard(){
        numberOfAvailableBooks = DisplayCountedDashboard.getInstance().getNumberOfBooks();
        numberOfIssuedBooks = DisplayCountedDashboard.getInstance().getNumberOfIssuedBooks();
        numberOfReturnedBooks = DisplayCountedDashboard.getInstance().getNumberOfReturnedBooks();
        numberOfOverdueBooks = DisplayCountedDashboard.getInstance().getNumberOfOverdueBooks();
        numberOfStudents = DisplayCountedDashboard.getInstance().getNumberOfStudents();
        numberOfLibrarians = DisplayCountedDashboard.getInstance().getNumberOfLibrarians();
        numberOfAdmins = DisplayCountedDashboard.getInstance().getNumberOfAdmins();
        NUMBER_AVAIL_BOOK.setText(String.valueOf(numberOfAvailableBooks));
        NUMBER_ISSUED_BOOK.setText(String.valueOf(numberOfIssuedBooks));
        NUMBER_RETURNED_BOOK.setText(String.valueOf(numberOfReturnedBooks));
        NUMBER_OVERDUE.setText(String.valueOf(numberOfOverdueBooks));
        jLabel2.setText(String.valueOf(numberOfOverdueBooks));
        NUMBER_STUDENTS.setText(String.valueOf(numberOfStudents));
        NUMBER_LIBRARIANS.setText(String.valueOf(numberOfLibrarians));
        NUMBER_ADMINS.setText(String.valueOf(numberOfAdmins));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ADM_SETTING = new javax.swing.JLabel();
        ADM_NOTIF = new javax.swing.JLabel();
        jP_ADM_DASHBOARD = new javax.swing.JPanel();
        NUMBER_RETURNED_BOOK = new javax.swing.JLabel();
        NUMBER_ISSUED_BOOK = new javax.swing.JLabel();
        NUMBER_AVAIL_BOOK = new javax.swing.JLabel();
        BOOKS_BOOKS_BOOKS = new javax.swing.JLabel();
        NUMBER_STUDENTS = new javax.swing.JLabel();
        STUDENTS_PANEL = new javax.swing.JLabel();
        NUMBER_LIBRARIANS = new javax.swing.JLabel();
        LIBRARIANS_PANEL = new javax.swing.JLabel();
        NUMBER_ADMINS = new javax.swing.JLabel();
        NUMBER_OVERDUE = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        OVERDUE_BOOKMARK = new javax.swing.JLabel();
        OVERDUE_PANEL = new javax.swing.JLabel();
        DASHBAORD_LAYOUT = new javax.swing.JLabel();
        jP_ADM_MANAGE_BOOKS = new javax.swing.JPanel();
        BUTTON_ADD_BOOK = new javax.swing.JLabel();
        BUTTON_ISSUE_BOOK = new javax.swing.JLabel();
        BUTTON_RETURN_BOOK = new javax.swing.JLabel();
        ADD_BOOK_PANEL = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AB_TABLE = new javax.swing.JTable();
        AB_BOOK_TITLE = new javax.swing.JTextField();
        AB_BOOK_AUTHOR = new javax.swing.JTextField();
        AB_BOOK_GENRE = new javax.swing.JTextField();
        AB_DATE_PUB = new javax.swing.JTextField();
        AB_ISBN = new javax.swing.JTextField();
        AB_ADD = new javax.swing.JButton();
        AB_EDIT = new javax.swing.JButton();
        AB_CLEAR = new javax.swing.JButton();
        AB_DELETE = new javax.swing.JButton();
        ADD_BOOK_LAYOUT = new javax.swing.JLabel();
        RETURN_BOOK_PANEL = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        RB_TABLE = new javax.swing.JTable();
        RB_ISSUEID = new javax.swing.JTextField();
        RB_ISSUEDATE = new javax.swing.JTextField();
        RB_RETURNDATE = new javax.swing.JTextField();
        RB_ISBN = new javax.swing.JTextField();
        RB_NAME = new javax.swing.JTextField();
        RB_PHONENUMBER = new javax.swing.JTextField();
        RB_BOOKSTATUS = new javax.swing.JTextField();
        IS_EDIT1 = new javax.swing.JButton();
        IS_CLEAR1 = new javax.swing.JButton();
        RETURN_BOOK_LAYOUT = new javax.swing.JLabel();
        ISSUE_BOOK_PANEL = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        IB_TABALE = new javax.swing.JTable();
        IB_ISBN = new javax.swing.JTextField();
        IB_NAME = new javax.swing.JTextField();
        IB_PHONENUMBER = new javax.swing.JTextField();
        IB_EMAILADD = new javax.swing.JTextField();
        IB_ISSUEID = new javax.swing.JTextField();
        IB_ISSUEDATE = new javax.swing.JTextField();
        IB_RETURNDATE = new javax.swing.JTextField();
        IB_COMBO = new javax.swing.JComboBox<>();
        IS_ADD = new javax.swing.JButton();
        IS_EDIT = new javax.swing.JButton();
        IS_CLEAR = new javax.swing.JButton();
        IS_DELETE = new javax.swing.JButton();
        ISSUE_BOOK_LAYOUT = new javax.swing.JLabel();
        jP_ADM_MANAGE_USERS = new javax.swing.JPanel();
        STUDENT_ACCOUNT_PANEL = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ST_TABLE = new javax.swing.JTable();
        ST_FULLNAME = new javax.swing.JTextField();
        ST_STNUMBER = new javax.swing.JTextField();
        ST_YEARSEC = new javax.swing.JTextField();
        ST_PHONENUM = new javax.swing.JTextField();
        ST_HOMEADD = new javax.swing.JTextField();
        ST_EMAILADD = new javax.swing.JTextField();
        ST_USERNAME = new javax.swing.JTextField();
        ST_PASSWORD = new javax.swing.JPasswordField();
        ST_CONFIRMPASS = new javax.swing.JPasswordField();
        ST_CREATE = new javax.swing.JButton();
        ST_EDIT = new javax.swing.JButton();
        ST_CLEAR = new javax.swing.JButton();
        ST_REMOVE = new javax.swing.JButton();
        ST_BACKGROUND_LAYOUT = new javax.swing.JLabel();
        LIBRARIAN_ACCOUNT_PANEL = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        LB_TABLE = new javax.swing.JTable();
        LB_FULLNAME = new javax.swing.JTextField();
        LB_BIRTHDATE = new javax.swing.JTextField();
        LB_PHONENUM = new javax.swing.JTextField();
        LB_HOMEADD = new javax.swing.JTextField();
        LB_GWA = new javax.swing.JTextField();
        LB_EMAILADD = new javax.swing.JTextField();
        LB_LIBID = new javax.swing.JTextField();
        LB_PASSWORD = new javax.swing.JPasswordField();
        LB_CONFIRMPASS = new javax.swing.JPasswordField();
        LB_CREATE = new javax.swing.JButton();
        LB_EDIT = new javax.swing.JButton();
        LB_CLEAR = new javax.swing.JButton();
        LB_REMOVE = new javax.swing.JButton();
        LB_BACKGROUND_LAYOUT = new javax.swing.JLabel();
        ADMIN_ACCOUNT_PANEL = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        AD_TABLE = new javax.swing.JTable();
        AD_FULLNAME = new javax.swing.JTextField();
        AD_CREATE = new javax.swing.JButton();
        AD_EDIT = new javax.swing.JButton();
        AD_CLEAR = new javax.swing.JButton();
        AD_REMOVE = new javax.swing.JButton();
        AD_HOMEADD = new javax.swing.JTextField();
        AD_PHONENUM = new javax.swing.JTextField();
        AD_EDUCATTAIN = new javax.swing.JTextField();
        AD_KEYPASS = new javax.swing.JTextField();
        AD_ADMINNUM = new javax.swing.JTextField();
        AD_EMAILADD = new javax.swing.JTextField();
        AD_ADMINID = new javax.swing.JTextField();
        AD_PASSWORD = new javax.swing.JPasswordField();
        AD_CONFIRMPASS = new javax.swing.JPasswordField();
        AD_BACKGROUND_LAYOUT = new javax.swing.JLabel();
        BUTTON_STUDENT = new javax.swing.JLabel();
        BUTTON_LIBRARIAN = new javax.swing.JLabel();
        BUTTON_ADMIN = new javax.swing.JLabel();
        jP_ADM_ACCOUNT = new javax.swing.JPanel();
        ADM_EDIT_BUTTON = new javax.swing.JLabel();
        ADM_ACCOUNT_LAYOUT = new javax.swing.JLabel();
        ADM_DASHBOARD = new javax.swing.JLabel();
        ADM_MANAGE_BOOK = new javax.swing.JLabel();
        ADM_MANAGE_USER = new javax.swing.JLabel();
        ADM_ACCOUNT = new javax.swing.JLabel();
        ADM_LOGOUT = new javax.swing.JLabel();
        ADM_DIVIDER = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin | One More Page");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 254, 252));
        setLocation(new java.awt.Point(380, 180));
        setMinimumSize(new java.awt.Dimension(1190, 695));
        setResizable(false);
        setSize(new java.awt.Dimension(1190, 695));

        jPanel1.setBackground(new java.awt.Color(255, 254, 252));
        jPanel1.setMinimumSize(new java.awt.Dimension(1190, 695));
        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 695));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ADM_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADMIN_SETTING.png"))); // NOI18N
        jPanel1.add(ADM_SETTING, new org.netbeans.lib.awtextra.AbsoluteConstraints(1121, 26, -1, -1));

        ADM_NOTIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADMIN_NOTIF.png"))); // NOI18N
        jPanel1.add(ADM_NOTIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1066, 26, -1, -1));

        jP_ADM_DASHBOARD.setBackground(new java.awt.Color(255, 254, 252));
        jP_ADM_DASHBOARD.setMinimumSize(new java.awt.Dimension(1190, 695));
        jP_ADM_DASHBOARD.setOpaque(false);
        jP_ADM_DASHBOARD.setPreferredSize(new java.awt.Dimension(980, 700));
        jP_ADM_DASHBOARD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NUMBER_RETURNED_BOOK.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        NUMBER_RETURNED_BOOK.setText("0");
        jP_ADM_DASHBOARD.add(NUMBER_RETURNED_BOOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 240, -1, -1));

        NUMBER_ISSUED_BOOK.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        NUMBER_ISSUED_BOOK.setText("0");
        jP_ADM_DASHBOARD.add(NUMBER_ISSUED_BOOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, -1, -1));

        NUMBER_AVAIL_BOOK.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        NUMBER_AVAIL_BOOK.setText("0");
        jP_ADM_DASHBOARD.add(NUMBER_AVAIL_BOOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        BOOKS_BOOKS_BOOKS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_BOOK_DB.png"))); // NOI18N
        jP_ADM_DASHBOARD.add(BOOKS_BOOKS_BOOKS, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 144, -1, -1));

        NUMBER_STUDENTS.setBackground(new java.awt.Color(245, 245, 245));
        NUMBER_STUDENTS.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        NUMBER_STUDENTS.setForeground(new java.awt.Color(245, 245, 245));
        NUMBER_STUDENTS.setText("0");
        jP_ADM_DASHBOARD.add(NUMBER_STUDENTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 520, -1, -1));

        STUDENTS_PANEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_STUDENT_DB.png"))); // NOI18N
        jP_ADM_DASHBOARD.add(STUDENTS_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 424, -1, -1));

        NUMBER_LIBRARIANS.setBackground(new java.awt.Color(245, 245, 245));
        NUMBER_LIBRARIANS.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        NUMBER_LIBRARIANS.setForeground(new java.awt.Color(245, 245, 245));
        NUMBER_LIBRARIANS.setText("0");
        jP_ADM_DASHBOARD.add(NUMBER_LIBRARIANS, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 520, -1, -1));

        LIBRARIANS_PANEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_LIBRARIAN_DB.png"))); // NOI18N
        jP_ADM_DASHBOARD.add(LIBRARIANS_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 424, -1, -1));

        NUMBER_ADMINS.setBackground(new java.awt.Color(245, 245, 245));
        NUMBER_ADMINS.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        NUMBER_ADMINS.setForeground(new java.awt.Color(245, 245, 245));
        NUMBER_ADMINS.setText("0");
        jP_ADM_DASHBOARD.add(NUMBER_ADMINS, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 520, -1, -1));

        NUMBER_OVERDUE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_ADMIN_DB.png"))); // NOI18N
        jP_ADM_DASHBOARD.add(NUMBER_OVERDUE, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 424, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(233, 120, 181));
        jLabel2.setText("0");
        jP_ADM_DASHBOARD.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 465, -1, -1));

        OVERDUE_BOOKMARK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_BOOKMARK.png"))); // NOI18N
        jP_ADM_DASHBOARD.add(OVERDUE_BOOKMARK, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 422, -1, -1));

        OVERDUE_PANEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_OVERDUEBOOKS.png"))); // NOI18N
        jP_ADM_DASHBOARD.add(OVERDUE_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 424, -1, -1));

        DASHBAORD_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_DAHSBOARD_FRAME.png"))); // NOI18N
        jP_ADM_DASHBOARD.add(DASHBAORD_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jP_ADM_DASHBOARD, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 0, 980, 700));

        jP_ADM_MANAGE_BOOKS.setBackground(new java.awt.Color(255, 254, 252));
        jP_ADM_MANAGE_BOOKS.setMinimumSize(new java.awt.Dimension(980, 675));
        jP_ADM_MANAGE_BOOKS.setOpaque(false);
        jP_ADM_MANAGE_BOOKS.setPreferredSize(new java.awt.Dimension(980, 675));
        jP_ADM_MANAGE_BOOKS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BUTTON_ADD_BOOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEBOOK/ADD BOOK (SPINE).png"))); // NOI18N
        BUTTON_ADD_BOOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BUTTON_ADD_BOOKMouseClicked(evt);
            }
        });
        jP_ADM_MANAGE_BOOKS.add(BUTTON_ADD_BOOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 68, -1, -1));

        BUTTON_ISSUE_BOOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEBOOK/ISSUE BOOK (SPINE).png"))); // NOI18N
        BUTTON_ISSUE_BOOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BUTTON_ISSUE_BOOKMouseClicked(evt);
            }
        });
        jP_ADM_MANAGE_BOOKS.add(BUTTON_ISSUE_BOOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 242, -1, -1));

        BUTTON_RETURN_BOOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEBOOK/RETURN BOOK (SPINE).png"))); // NOI18N
        BUTTON_RETURN_BOOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BUTTON_RETURN_BOOKMouseClicked(evt);
            }
        });
        jP_ADM_MANAGE_BOOKS.add(BUTTON_RETURN_BOOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 415, -1, -1));

        ADD_BOOK_PANEL.setMinimumSize(new java.awt.Dimension(980, 675));
        ADD_BOOK_PANEL.setOpaque(false);
        ADD_BOOK_PANEL.setPreferredSize(new java.awt.Dimension(900, 675));
        ADD_BOOK_PANEL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 254, 252));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        jScrollPane1.setFocusable(false);

        AB_TABLE.setBackground(new java.awt.Color(255, 254, 252));
        AB_TABLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        AB_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        AB_TABLE.setFocusable(false);
        AB_TABLE.setGridColor(new java.awt.Color(153, 0, 0));
        AB_TABLE.setRequestFocusEnabled(false);
        AB_TABLE.setSelectionBackground(new java.awt.Color(153, 0, 0));
        AB_TABLE.setSelectionForeground(new java.awt.Color(255, 153, 153));
        jScrollPane1.setViewportView(AB_TABLE);

        ADD_BOOK_PANEL.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 794, 260));

        AB_BOOK_TITLE.setBackground(new java.awt.Color(248, 243, 232));
        AB_BOOK_TITLE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        AB_BOOK_TITLE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AB_BOOK_TITLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ADD_BOOK_PANEL.add(AB_BOOK_TITLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 466, 246, 30));

        AB_BOOK_AUTHOR.setBackground(new java.awt.Color(248, 243, 232));
        AB_BOOK_AUTHOR.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        AB_BOOK_AUTHOR.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AB_BOOK_AUTHOR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ADD_BOOK_PANEL.add(AB_BOOK_AUTHOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 533, 246, 30));

        AB_BOOK_GENRE.setBackground(new java.awt.Color(248, 243, 232));
        AB_BOOK_GENRE.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        AB_BOOK_GENRE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AB_BOOK_GENRE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ADD_BOOK_PANEL.add(AB_BOOK_GENRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 600, 246, 30));

        AB_DATE_PUB.setBackground(new java.awt.Color(248, 243, 232));
        AB_DATE_PUB.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        AB_DATE_PUB.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AB_DATE_PUB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ADD_BOOK_PANEL.add(AB_DATE_PUB, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 466, 246, 30));

        AB_ISBN.setBackground(new java.awt.Color(248, 243, 232));
        AB_ISBN.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        AB_ISBN.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AB_ISBN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ADD_BOOK_PANEL.add(AB_ISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 533, 246, 30));

        AB_ADD.setBackground(new java.awt.Color(255, 166, 166));
        AB_ADD.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        AB_ADD.setForeground(new java.awt.Color(110, 15, 7));
        AB_ADD.setText("ADD");
        AB_ADD.setBorder(null);
        AB_ADD.setFocusPainted(false);
        AB_ADD.setFocusable(false);
        AB_ADD.setRequestFocusEnabled(false);
        AB_ADD.setRolloverEnabled(false);
        AB_ADD.setVerifyInputWhenFocusTarget(false);
        AB_ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AB_ADDActionPerformed(evt);
            }
        });
        ADD_BOOK_PANEL.add(AB_ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 453, 131, 30));

        AB_EDIT.setBackground(new java.awt.Color(255, 166, 166));
        AB_EDIT.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        AB_EDIT.setForeground(new java.awt.Color(110, 15, 7));
        AB_EDIT.setText("EDIT");
        AB_EDIT.setBorder(null);
        AB_EDIT.setFocusPainted(false);
        AB_EDIT.setFocusable(false);
        AB_EDIT.setRequestFocusEnabled(false);
        AB_EDIT.setRolloverEnabled(false);
        AB_EDIT.setVerifyInputWhenFocusTarget(false);
        AB_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AB_EDITActionPerformed(evt);
            }
        });
        ADD_BOOK_PANEL.add(AB_EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 497, 131, 30));

        AB_CLEAR.setBackground(new java.awt.Color(255, 166, 166));
        AB_CLEAR.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        AB_CLEAR.setForeground(new java.awt.Color(110, 15, 7));
        AB_CLEAR.setText("CLEAR");
        AB_CLEAR.setBorder(null);
        AB_CLEAR.setFocusPainted(false);
        AB_CLEAR.setFocusable(false);
        AB_CLEAR.setRequestFocusEnabled(false);
        AB_CLEAR.setRolloverEnabled(false);
        AB_CLEAR.setVerifyInputWhenFocusTarget(false);
        AB_CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AB_CLEARActionPerformed(evt);
            }
        });
        ADD_BOOK_PANEL.add(AB_CLEAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 541, 131, 30));

        AB_DELETE.setBackground(new java.awt.Color(110, 15, 7));
        AB_DELETE.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        AB_DELETE.setForeground(new java.awt.Color(255, 166, 166));
        AB_DELETE.setText("DELETE");
        AB_DELETE.setBorder(null);
        AB_DELETE.setFocusPainted(false);
        AB_DELETE.setFocusable(false);
        AB_DELETE.setRequestFocusEnabled(false);
        AB_DELETE.setRolloverEnabled(false);
        AB_DELETE.setVerifyInputWhenFocusTarget(false);
        AB_DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AB_DELETEActionPerformed(evt);
            }
        });
        ADD_BOOK_PANEL.add(AB_DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 585, 131, 30));

        ADD_BOOK_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEBOOK/ADM_ADDBOOK_FRAME.png"))); // NOI18N
        ADD_BOOK_PANEL.add(ADD_BOOK_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jP_ADM_MANAGE_BOOKS.add(ADD_BOOK_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        RETURN_BOOK_PANEL.setMinimumSize(new java.awt.Dimension(980, 675));
        RETURN_BOOK_PANEL.setOpaque(false);
        RETURN_BOOK_PANEL.setPreferredSize(new java.awt.Dimension(980, 675));
        RETURN_BOOK_PANEL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 254, 252));
        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        jScrollPane3.setFocusable(false);

        RB_TABLE.setBackground(new java.awt.Color(255, 254, 252));
        RB_TABLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        RB_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        RB_TABLE.setFocusable(false);
        RB_TABLE.setGridColor(new java.awt.Color(153, 0, 0));
        RB_TABLE.setRequestFocusEnabled(false);
        RB_TABLE.setSelectionBackground(new java.awt.Color(153, 0, 0));
        RB_TABLE.setSelectionForeground(new java.awt.Color(255, 153, 153));
        jScrollPane3.setViewportView(RB_TABLE);

        RETURN_BOOK_PANEL.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 794, 260));

        RB_ISSUEID.setBackground(new java.awt.Color(248, 243, 232));
        RB_ISSUEID.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        RB_ISSUEID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        RB_ISSUEID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        RETURN_BOOK_PANEL.add(RB_ISSUEID, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 462, 219, 25));

        RB_ISSUEDATE.setBackground(new java.awt.Color(248, 243, 232));
        RB_ISSUEDATE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        RB_ISSUEDATE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        RB_ISSUEDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        RETURN_BOOK_PANEL.add(RB_ISSUEDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 514, 219, 25));

        RB_RETURNDATE.setBackground(new java.awt.Color(248, 243, 232));
        RB_RETURNDATE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        RB_RETURNDATE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        RB_RETURNDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        RETURN_BOOK_PANEL.add(RB_RETURNDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 566, 219, 25));

        RB_ISBN.setBackground(new java.awt.Color(248, 243, 232));
        RB_ISBN.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        RB_ISBN.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        RB_ISBN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        RETURN_BOOK_PANEL.add(RB_ISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 618, 219, 25));

        RB_NAME.setBackground(new java.awt.Color(248, 243, 232));
        RB_NAME.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        RB_NAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        RB_NAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        RETURN_BOOK_PANEL.add(RB_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 462, 219, 25));

        RB_PHONENUMBER.setBackground(new java.awt.Color(248, 243, 232));
        RB_PHONENUMBER.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        RB_PHONENUMBER.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        RB_PHONENUMBER.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        RETURN_BOOK_PANEL.add(RB_PHONENUMBER, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 514, 219, 25));

        RB_BOOKSTATUS.setBackground(new java.awt.Color(248, 243, 232));
        RB_BOOKSTATUS.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        RB_BOOKSTATUS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        RB_BOOKSTATUS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        RETURN_BOOK_PANEL.add(RB_BOOKSTATUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 566, 219, 25));

        IS_EDIT1.setBackground(new java.awt.Color(255, 166, 166));
        IS_EDIT1.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        IS_EDIT1.setForeground(new java.awt.Color(110, 15, 7));
        IS_EDIT1.setText("RETURN");
        IS_EDIT1.setBorder(null);
        IS_EDIT1.setFocusPainted(false);
        IS_EDIT1.setFocusable(false);
        IS_EDIT1.setRequestFocusEnabled(false);
        IS_EDIT1.setRolloverEnabled(false);
        IS_EDIT1.setVerifyInputWhenFocusTarget(false);
        IS_EDIT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IS_EDIT1ActionPerformed(evt);
            }
        });
        RETURN_BOOK_PANEL.add(IS_EDIT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 505, 131, 30));

        IS_CLEAR1.setBackground(new java.awt.Color(255, 166, 166));
        IS_CLEAR1.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        IS_CLEAR1.setForeground(new java.awt.Color(110, 15, 7));
        IS_CLEAR1.setText("CLEAR");
        IS_CLEAR1.setBorder(null);
        IS_CLEAR1.setFocusPainted(false);
        IS_CLEAR1.setFocusable(false);
        IS_CLEAR1.setRequestFocusEnabled(false);
        IS_CLEAR1.setRolloverEnabled(false);
        IS_CLEAR1.setVerifyInputWhenFocusTarget(false);
        IS_CLEAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IS_CLEAR1ActionPerformed(evt);
            }
        });
        RETURN_BOOK_PANEL.add(IS_CLEAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 549, 131, 30));

        RETURN_BOOK_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEBOOK/ADM_RETURNBOOK_FRAME.png"))); // NOI18N
        RETURN_BOOK_PANEL.add(RETURN_BOOK_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jP_ADM_MANAGE_BOOKS.add(RETURN_BOOK_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ISSUE_BOOK_PANEL.setMinimumSize(new java.awt.Dimension(980, 675));
        ISSUE_BOOK_PANEL.setOpaque(false);
        ISSUE_BOOK_PANEL.setPreferredSize(new java.awt.Dimension(980, 675));
        ISSUE_BOOK_PANEL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 254, 252));
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        jScrollPane2.setFocusable(false);

        IB_TABALE.setBackground(new java.awt.Color(255, 254, 252));
        IB_TABALE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        IB_TABALE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        IB_TABALE.setFocusable(false);
        IB_TABALE.setGridColor(new java.awt.Color(153, 0, 0));
        IB_TABALE.setRequestFocusEnabled(false);
        IB_TABALE.setSelectionBackground(new java.awt.Color(153, 0, 0));
        IB_TABALE.setSelectionForeground(new java.awt.Color(255, 153, 153));
        jScrollPane2.setViewportView(IB_TABALE);

        ISSUE_BOOK_PANEL.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 794, 260));

        IB_ISBN.setBackground(new java.awt.Color(248, 243, 232));
        IB_ISBN.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        IB_ISBN.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        IB_ISBN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ISSUE_BOOK_PANEL.add(IB_ISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 462, 219, 25));

        IB_NAME.setBackground(new java.awt.Color(248, 243, 232));
        IB_NAME.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        IB_NAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        IB_NAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ISSUE_BOOK_PANEL.add(IB_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 514, 219, 25));

        IB_PHONENUMBER.setBackground(new java.awt.Color(248, 243, 232));
        IB_PHONENUMBER.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        IB_PHONENUMBER.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        IB_PHONENUMBER.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ISSUE_BOOK_PANEL.add(IB_PHONENUMBER, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 566, 219, 25));

        IB_EMAILADD.setBackground(new java.awt.Color(248, 243, 232));
        IB_EMAILADD.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        IB_EMAILADD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        IB_EMAILADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ISSUE_BOOK_PANEL.add(IB_EMAILADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 618, 219, 25));

        IB_ISSUEID.setBackground(new java.awt.Color(248, 243, 232));
        IB_ISSUEID.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        IB_ISSUEID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        IB_ISSUEID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ISSUE_BOOK_PANEL.add(IB_ISSUEID, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 462, 219, 25));

        IB_ISSUEDATE.setBackground(new java.awt.Color(248, 243, 232));
        IB_ISSUEDATE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        IB_ISSUEDATE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        IB_ISSUEDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ISSUE_BOOK_PANEL.add(IB_ISSUEDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 514, 219, 25));

        IB_RETURNDATE.setBackground(new java.awt.Color(248, 243, 232));
        IB_RETURNDATE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        IB_RETURNDATE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        IB_RETURNDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        ISSUE_BOOK_PANEL.add(IB_RETURNDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 566, 219, 25));

        IB_COMBO.setBackground(new java.awt.Color(248, 243, 232));
        IB_COMBO.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        IB_COMBO.setForeground(new java.awt.Color(110, 15, 7));
        IB_COMBO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AVAILABLE", "NOT AVAILABLE", "OVERDUE", "MISSING" }));
        IB_COMBO.setBorder(null);
        IB_COMBO.setFocusable(false);
        ISSUE_BOOK_PANEL.add(IB_COMBO, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 618, 219, 25));

        IS_ADD.setBackground(new java.awt.Color(255, 166, 166));
        IS_ADD.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        IS_ADD.setForeground(new java.awt.Color(110, 15, 7));
        IS_ADD.setText("ADD");
        IS_ADD.setBorder(null);
        IS_ADD.setFocusPainted(false);
        IS_ADD.setFocusable(false);
        IS_ADD.setRequestFocusEnabled(false);
        IS_ADD.setRolloverEnabled(false);
        IS_ADD.setVerifyInputWhenFocusTarget(false);
        IS_ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IS_ADDActionPerformed(evt);
            }
        });
        ISSUE_BOOK_PANEL.add(IS_ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 461, 131, 30));

        IS_EDIT.setBackground(new java.awt.Color(255, 166, 166));
        IS_EDIT.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        IS_EDIT.setForeground(new java.awt.Color(110, 15, 7));
        IS_EDIT.setText("EDIT");
        IS_EDIT.setBorder(null);
        IS_EDIT.setFocusPainted(false);
        IS_EDIT.setFocusable(false);
        IS_EDIT.setRequestFocusEnabled(false);
        IS_EDIT.setRolloverEnabled(false);
        IS_EDIT.setVerifyInputWhenFocusTarget(false);
        IS_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IS_EDITActionPerformed(evt);
            }
        });
        ISSUE_BOOK_PANEL.add(IS_EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 505, 131, 30));

        IS_CLEAR.setBackground(new java.awt.Color(255, 166, 166));
        IS_CLEAR.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        IS_CLEAR.setForeground(new java.awt.Color(110, 15, 7));
        IS_CLEAR.setText("CLEAR");
        IS_CLEAR.setBorder(null);
        IS_CLEAR.setFocusPainted(false);
        IS_CLEAR.setFocusable(false);
        IS_CLEAR.setRequestFocusEnabled(false);
        IS_CLEAR.setRolloverEnabled(false);
        IS_CLEAR.setVerifyInputWhenFocusTarget(false);
        IS_CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IS_CLEARActionPerformed(evt);
            }
        });
        ISSUE_BOOK_PANEL.add(IS_CLEAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 549, 131, 30));

        IS_DELETE.setBackground(new java.awt.Color(110, 15, 7));
        IS_DELETE.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        IS_DELETE.setForeground(new java.awt.Color(255, 166, 166));
        IS_DELETE.setText("DELETE");
        IS_DELETE.setBorder(null);
        IS_DELETE.setFocusPainted(false);
        IS_DELETE.setFocusable(false);
        IS_DELETE.setRequestFocusEnabled(false);
        IS_DELETE.setRolloverEnabled(false);
        IS_DELETE.setVerifyInputWhenFocusTarget(false);
        IS_DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IS_DELETEActionPerformed(evt);
            }
        });
        ISSUE_BOOK_PANEL.add(IS_DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 593, 131, 30));

        ISSUE_BOOK_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEBOOK/ADM_ISSUEBOOK_FRAME.png"))); // NOI18N
        ISSUE_BOOK_PANEL.add(ISSUE_BOOK_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jP_ADM_MANAGE_BOOKS.add(ISSUE_BOOK_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jP_ADM_MANAGE_BOOKS, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 0, 980, 700));

        jP_ADM_MANAGE_USERS.setBackground(new java.awt.Color(255, 254, 252));
        jP_ADM_MANAGE_USERS.setMinimumSize(new java.awt.Dimension(980, 675));
        jP_ADM_MANAGE_USERS.setOpaque(false);
        jP_ADM_MANAGE_USERS.setPreferredSize(new java.awt.Dimension(980, 675));
        jP_ADM_MANAGE_USERS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        STUDENT_ACCOUNT_PANEL.setMinimumSize(new java.awt.Dimension(980, 675));
        STUDENT_ACCOUNT_PANEL.setOpaque(false);
        STUDENT_ACCOUNT_PANEL.setPreferredSize(new java.awt.Dimension(900, 675));
        STUDENT_ACCOUNT_PANEL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(255, 254, 252));
        jScrollPane4.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        jScrollPane4.setFocusable(false);

        ST_TABLE.setBackground(new java.awt.Color(255, 254, 252));
        ST_TABLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(205, 151, 4)));
        ST_TABLE.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ST_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ST_TABLE.setFocusable(false);
        ST_TABLE.setGridColor(new java.awt.Color(204, 204, 0));
        ST_TABLE.setRequestFocusEnabled(false);
        ST_TABLE.setSelectionBackground(new java.awt.Color(205, 151, 4));
        ST_TABLE.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane4.setViewportView(ST_TABLE);

        STUDENT_ACCOUNT_PANEL.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 123, 350, 473));

        ST_FULLNAME.setBackground(new java.awt.Color(248, 243, 232));
        ST_FULLNAME.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        ST_FULLNAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ST_FULLNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        ST_FULLNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ST_FULLNAMEActionPerformed(evt);
            }
        });
        STUDENT_ACCOUNT_PANEL.add(ST_FULLNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 292, 25));

        ST_STNUMBER.setBackground(new java.awt.Color(248, 243, 232));
        ST_STNUMBER.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        ST_STNUMBER.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ST_STNUMBER.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        STUDENT_ACCOUNT_PANEL.add(ST_STNUMBER, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 255, 140, 25));

        ST_YEARSEC.setBackground(new java.awt.Color(248, 243, 232));
        ST_YEARSEC.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        ST_YEARSEC.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ST_YEARSEC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        STUDENT_ACCOUNT_PANEL.add(ST_YEARSEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 255, 140, 25));

        ST_PHONENUM.setBackground(new java.awt.Color(248, 243, 232));
        ST_PHONENUM.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        ST_PHONENUM.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ST_PHONENUM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        STUDENT_ACCOUNT_PANEL.add(ST_PHONENUM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 292, 25));

        ST_HOMEADD.setBackground(new java.awt.Color(248, 243, 232));
        ST_HOMEADD.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        ST_HOMEADD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ST_HOMEADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        STUDENT_ACCOUNT_PANEL.add(ST_HOMEADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 365, 292, 25));

        ST_EMAILADD.setBackground(new java.awt.Color(248, 243, 232));
        ST_EMAILADD.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        ST_EMAILADD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ST_EMAILADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        STUDENT_ACCOUNT_PANEL.add(ST_EMAILADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 292, 25));

        ST_USERNAME.setBackground(new java.awt.Color(248, 243, 232));
        ST_USERNAME.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        ST_USERNAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ST_USERNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        STUDENT_ACCOUNT_PANEL.add(ST_USERNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 516, 292, 25));

        ST_PASSWORD.setBackground(new java.awt.Color(248, 243, 232));
        ST_PASSWORD.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        ST_PASSWORD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        STUDENT_ACCOUNT_PANEL.add(ST_PASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 571, 140, 25));

        ST_CONFIRMPASS.setBackground(new java.awt.Color(248, 243, 232));
        ST_CONFIRMPASS.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        ST_CONFIRMPASS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        STUDENT_ACCOUNT_PANEL.add(ST_CONFIRMPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 571, 140, 25));

        ST_CREATE.setBackground(new java.awt.Color(255, 243, 148));
        ST_CREATE.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        ST_CREATE.setForeground(new java.awt.Color(205, 151, 4));
        ST_CREATE.setText("CREATE");
        ST_CREATE.setBorder(null);
        ST_CREATE.setFocusPainted(false);
        ST_CREATE.setFocusable(false);
        ST_CREATE.setRequestFocusEnabled(false);
        ST_CREATE.setRolloverEnabled(false);
        ST_CREATE.setVerifyInputWhenFocusTarget(false);
        ST_CREATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ST_CREATEActionPerformed(evt);
            }
        });
        STUDENT_ACCOUNT_PANEL.add(ST_CREATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 618, 120, 30));

        ST_EDIT.setBackground(new java.awt.Color(255, 243, 148));
        ST_EDIT.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        ST_EDIT.setForeground(new java.awt.Color(205, 151, 4));
        ST_EDIT.setText("EDIT");
        ST_EDIT.setToolTipText("");
        ST_EDIT.setBorder(null);
        ST_EDIT.setFocusPainted(false);
        ST_EDIT.setFocusable(false);
        ST_EDIT.setRequestFocusEnabled(false);
        ST_EDIT.setRolloverEnabled(false);
        ST_EDIT.setVerifyInputWhenFocusTarget(false);
        ST_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ST_EDITActionPerformed(evt);
            }
        });
        STUDENT_ACCOUNT_PANEL.add(ST_EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 618, 120, 30));

        ST_CLEAR.setBackground(new java.awt.Color(255, 243, 148));
        ST_CLEAR.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        ST_CLEAR.setForeground(new java.awt.Color(205, 151, 4));
        ST_CLEAR.setText("CLEAR");
        ST_CLEAR.setBorder(null);
        ST_CLEAR.setFocusPainted(false);
        ST_CLEAR.setFocusable(false);
        ST_CLEAR.setRequestFocusEnabled(false);
        ST_CLEAR.setRolloverEnabled(false);
        ST_CLEAR.setVerifyInputWhenFocusTarget(false);
        ST_CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ST_CLEARActionPerformed(evt);
            }
        });
        STUDENT_ACCOUNT_PANEL.add(ST_CLEAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 618, 120, 30));

        ST_REMOVE.setBackground(new java.awt.Color(212, 188, 3));
        ST_REMOVE.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        ST_REMOVE.setForeground(new java.awt.Color(153, 153, 0));
        ST_REMOVE.setText("REMOVE");
        ST_REMOVE.setBorder(null);
        ST_REMOVE.setFocusPainted(false);
        ST_REMOVE.setFocusable(false);
        ST_REMOVE.setRequestFocusEnabled(false);
        ST_REMOVE.setRolloverEnabled(false);
        ST_REMOVE.setVerifyInputWhenFocusTarget(false);
        ST_REMOVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ST_REMOVEActionPerformed(evt);
            }
        });
        STUDENT_ACCOUNT_PANEL.add(ST_REMOVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 618, 120, 30));

        ST_BACKGROUND_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEUSER/ADM_STUDENT_ACC_FRAME.png"))); // NOI18N
        STUDENT_ACCOUNT_PANEL.add(ST_BACKGROUND_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 27, -1, -1));

        jP_ADM_MANAGE_USERS.add(STUDENT_ACCOUNT_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        LIBRARIAN_ACCOUNT_PANEL.setMinimumSize(new java.awt.Dimension(980, 675));
        LIBRARIAN_ACCOUNT_PANEL.setOpaque(false);
        LIBRARIAN_ACCOUNT_PANEL.setPreferredSize(new java.awt.Dimension(900, 675));
        LIBRARIAN_ACCOUNT_PANEL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setBackground(new java.awt.Color(255, 254, 252));
        jScrollPane5.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        jScrollPane5.setFocusable(false);

        LB_TABLE.setBackground(new java.awt.Color(255, 254, 252));
        LB_TABLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(205, 151, 4)));
        LB_TABLE.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        LB_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        LB_TABLE.setFocusable(false);
        LB_TABLE.setGridColor(new java.awt.Color(204, 204, 0));
        LB_TABLE.setRequestFocusEnabled(false);
        LB_TABLE.setSelectionBackground(new java.awt.Color(205, 151, 4));
        LB_TABLE.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane5.setViewportView(LB_TABLE);

        LIBRARIAN_ACCOUNT_PANEL.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 123, 350, 473));

        LB_FULLNAME.setBackground(new java.awt.Color(248, 243, 232));
        LB_FULLNAME.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        LB_FULLNAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        LB_FULLNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        LIBRARIAN_ACCOUNT_PANEL.add(LB_FULLNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 292, 25));

        LB_BIRTHDATE.setBackground(new java.awt.Color(248, 243, 232));
        LB_BIRTHDATE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        LB_BIRTHDATE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        LB_BIRTHDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        LIBRARIAN_ACCOUNT_PANEL.add(LB_BIRTHDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 255, 140, 25));

        LB_PHONENUM.setBackground(new java.awt.Color(248, 243, 232));
        LB_PHONENUM.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        LB_PHONENUM.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        LB_PHONENUM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        LIBRARIAN_ACCOUNT_PANEL.add(LB_PHONENUM, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 255, 140, 25));

        LB_HOMEADD.setBackground(new java.awt.Color(248, 243, 232));
        LB_HOMEADD.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        LB_HOMEADD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        LB_HOMEADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        LIBRARIAN_ACCOUNT_PANEL.add(LB_HOMEADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 292, 25));

        LB_GWA.setBackground(new java.awt.Color(248, 243, 232));
        LB_GWA.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        LB_GWA.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        LB_GWA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        LIBRARIAN_ACCOUNT_PANEL.add(LB_GWA, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 365, 292, 25));

        LB_EMAILADD.setBackground(new java.awt.Color(248, 243, 232));
        LB_EMAILADD.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        LB_EMAILADD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        LB_EMAILADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        LIBRARIAN_ACCOUNT_PANEL.add(LB_EMAILADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 461, 292, 25));

        LB_LIBID.setBackground(new java.awt.Color(248, 243, 232));
        LB_LIBID.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        LB_LIBID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        LB_LIBID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        LIBRARIAN_ACCOUNT_PANEL.add(LB_LIBID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 516, 292, 25));

        LB_PASSWORD.setBackground(new java.awt.Color(248, 243, 232));
        LB_PASSWORD.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        LB_PASSWORD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        LIBRARIAN_ACCOUNT_PANEL.add(LB_PASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 571, 140, 25));

        LB_CONFIRMPASS.setBackground(new java.awt.Color(248, 243, 232));
        LB_CONFIRMPASS.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        LB_CONFIRMPASS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        LIBRARIAN_ACCOUNT_PANEL.add(LB_CONFIRMPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 571, 140, 25));

        LB_CREATE.setBackground(new java.awt.Color(255, 243, 148));
        LB_CREATE.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        LB_CREATE.setForeground(new java.awt.Color(205, 151, 4));
        LB_CREATE.setText("CREATE");
        LB_CREATE.setBorder(null);
        LB_CREATE.setFocusPainted(false);
        LB_CREATE.setFocusable(false);
        LB_CREATE.setRequestFocusEnabled(false);
        LB_CREATE.setRolloverEnabled(false);
        LB_CREATE.setVerifyInputWhenFocusTarget(false);
        LB_CREATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LB_CREATEActionPerformed(evt);
            }
        });
        LIBRARIAN_ACCOUNT_PANEL.add(LB_CREATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 618, 120, 30));

        LB_EDIT.setBackground(new java.awt.Color(255, 243, 148));
        LB_EDIT.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        LB_EDIT.setForeground(new java.awt.Color(205, 151, 4));
        LB_EDIT.setText("EDIT");
        LB_EDIT.setToolTipText("");
        LB_EDIT.setBorder(null);
        LB_EDIT.setFocusPainted(false);
        LB_EDIT.setFocusable(false);
        LB_EDIT.setRequestFocusEnabled(false);
        LB_EDIT.setRolloverEnabled(false);
        LB_EDIT.setVerifyInputWhenFocusTarget(false);
        LB_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LB_EDITActionPerformed(evt);
            }
        });
        LIBRARIAN_ACCOUNT_PANEL.add(LB_EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 618, 120, 30));

        LB_CLEAR.setBackground(new java.awt.Color(255, 243, 148));
        LB_CLEAR.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        LB_CLEAR.setForeground(new java.awt.Color(205, 151, 4));
        LB_CLEAR.setText("CLEAR");
        LB_CLEAR.setBorder(null);
        LB_CLEAR.setFocusPainted(false);
        LB_CLEAR.setFocusable(false);
        LB_CLEAR.setRequestFocusEnabled(false);
        LB_CLEAR.setRolloverEnabled(false);
        LB_CLEAR.setVerifyInputWhenFocusTarget(false);
        LB_CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LB_CLEARActionPerformed(evt);
            }
        });
        LIBRARIAN_ACCOUNT_PANEL.add(LB_CLEAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 618, 120, 30));

        LB_REMOVE.setBackground(new java.awt.Color(212, 188, 3));
        LB_REMOVE.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        LB_REMOVE.setForeground(new java.awt.Color(153, 153, 0));
        LB_REMOVE.setText("REMOVE");
        LB_REMOVE.setBorder(null);
        LB_REMOVE.setFocusPainted(false);
        LB_REMOVE.setFocusable(false);
        LB_REMOVE.setRequestFocusEnabled(false);
        LB_REMOVE.setRolloverEnabled(false);
        LB_REMOVE.setVerifyInputWhenFocusTarget(false);
        LB_REMOVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LB_REMOVEActionPerformed(evt);
            }
        });
        LIBRARIAN_ACCOUNT_PANEL.add(LB_REMOVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 618, 120, 30));

        LB_BACKGROUND_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEUSER/ADM_LIBRARIAN_ACC_FARME.png"))); // NOI18N
        LIBRARIAN_ACCOUNT_PANEL.add(LB_BACKGROUND_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 27, -1, -1));

        jP_ADM_MANAGE_USERS.add(LIBRARIAN_ACCOUNT_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        ADMIN_ACCOUNT_PANEL.setMinimumSize(new java.awt.Dimension(980, 675));
        ADMIN_ACCOUNT_PANEL.setOpaque(false);
        ADMIN_ACCOUNT_PANEL.setPreferredSize(new java.awt.Dimension(900, 675));
        ADMIN_ACCOUNT_PANEL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setBackground(new java.awt.Color(255, 254, 252));
        jScrollPane6.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 104, 104)));
        jScrollPane6.setFocusable(false);

        AD_TABLE.setBackground(new java.awt.Color(255, 254, 252));
        AD_TABLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(205, 151, 4)));
        AD_TABLE.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        AD_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        AD_TABLE.setFocusable(false);
        AD_TABLE.setGridColor(new java.awt.Color(204, 204, 0));
        AD_TABLE.setRequestFocusEnabled(false);
        AD_TABLE.setSelectionBackground(new java.awt.Color(205, 151, 4));
        AD_TABLE.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane6.setViewportView(AD_TABLE);

        ADMIN_ACCOUNT_PANEL.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 142, 692, 130));

        AD_FULLNAME.setBackground(new java.awt.Color(248, 243, 232));
        AD_FULLNAME.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        AD_FULLNAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AD_FULLNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        ADMIN_ACCOUNT_PANEL.add(AD_FULLNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 348, 293, 30));

        AD_CREATE.setBackground(new java.awt.Color(255, 243, 148));
        AD_CREATE.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        AD_CREATE.setForeground(new java.awt.Color(205, 151, 4));
        AD_CREATE.setText("CREATE");
        AD_CREATE.setBorder(null);
        AD_CREATE.setFocusPainted(false);
        AD_CREATE.setFocusable(false);
        AD_CREATE.setRequestFocusEnabled(false);
        AD_CREATE.setRolloverEnabled(false);
        AD_CREATE.setVerifyInputWhenFocusTarget(false);
        AD_CREATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AD_CREATEActionPerformed(evt);
            }
        });
        ADMIN_ACCOUNT_PANEL.add(AD_CREATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 609, 120, 30));

        AD_EDIT.setBackground(new java.awt.Color(255, 243, 148));
        AD_EDIT.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        AD_EDIT.setForeground(new java.awt.Color(205, 151, 4));
        AD_EDIT.setText("EDIT");
        AD_EDIT.setToolTipText("");
        AD_EDIT.setBorder(null);
        AD_EDIT.setFocusPainted(false);
        AD_EDIT.setFocusable(false);
        AD_EDIT.setRequestFocusEnabled(false);
        AD_EDIT.setRolloverEnabled(false);
        AD_EDIT.setVerifyInputWhenFocusTarget(false);
        AD_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AD_EDITActionPerformed(evt);
            }
        });
        ADMIN_ACCOUNT_PANEL.add(AD_EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 609, 120, 30));

        AD_CLEAR.setBackground(new java.awt.Color(255, 243, 148));
        AD_CLEAR.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        AD_CLEAR.setForeground(new java.awt.Color(205, 151, 4));
        AD_CLEAR.setText("CLEAR");
        AD_CLEAR.setBorder(null);
        AD_CLEAR.setFocusPainted(false);
        AD_CLEAR.setFocusable(false);
        AD_CLEAR.setRequestFocusEnabled(false);
        AD_CLEAR.setRolloverEnabled(false);
        AD_CLEAR.setVerifyInputWhenFocusTarget(false);
        AD_CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AD_CLEARActionPerformed(evt);
            }
        });
        ADMIN_ACCOUNT_PANEL.add(AD_CLEAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 609, 120, 30));

        AD_REMOVE.setBackground(new java.awt.Color(205, 151, 4));
        AD_REMOVE.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        AD_REMOVE.setForeground(new java.awt.Color(255, 245, 51));
        AD_REMOVE.setText("REMOVE");
        AD_REMOVE.setBorder(null);
        AD_REMOVE.setFocusPainted(false);
        AD_REMOVE.setFocusable(false);
        AD_REMOVE.setRequestFocusEnabled(false);
        AD_REMOVE.setRolloverEnabled(false);
        AD_REMOVE.setVerifyInputWhenFocusTarget(false);
        AD_REMOVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AD_REMOVEActionPerformed(evt);
            }
        });
        ADMIN_ACCOUNT_PANEL.add(AD_REMOVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 609, 120, 30));

        AD_HOMEADD.setBackground(new java.awt.Color(248, 243, 232));
        AD_HOMEADD.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        AD_HOMEADD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AD_HOMEADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        ADMIN_ACCOUNT_PANEL.add(AD_HOMEADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 413, 293, 30));

        AD_PHONENUM.setBackground(new java.awt.Color(248, 243, 232));
        AD_PHONENUM.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        AD_PHONENUM.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AD_PHONENUM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        ADMIN_ACCOUNT_PANEL.add(AD_PHONENUM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 476, 293, 30));

        AD_EDUCATTAIN.setBackground(new java.awt.Color(248, 243, 232));
        AD_EDUCATTAIN.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        AD_EDUCATTAIN.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AD_EDUCATTAIN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        ADMIN_ACCOUNT_PANEL.add(AD_EDUCATTAIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 543, 293, 30));

        AD_KEYPASS.setBackground(new java.awt.Color(248, 243, 232));
        AD_KEYPASS.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        AD_KEYPASS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AD_KEYPASS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        ADMIN_ACCOUNT_PANEL.add(AD_KEYPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 348, 139, 30));

        AD_ADMINNUM.setBackground(new java.awt.Color(248, 243, 232));
        AD_ADMINNUM.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        AD_ADMINNUM.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AD_ADMINNUM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        ADMIN_ACCOUNT_PANEL.add(AD_ADMINNUM, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 348, 139, 30));

        AD_EMAILADD.setBackground(new java.awt.Color(248, 243, 232));
        AD_EMAILADD.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        AD_EMAILADD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AD_EMAILADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        ADMIN_ACCOUNT_PANEL.add(AD_EMAILADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 413, 293, 30));

        AD_ADMINID.setBackground(new java.awt.Color(248, 243, 232));
        AD_ADMINID.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        AD_ADMINID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AD_ADMINID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        ADMIN_ACCOUNT_PANEL.add(AD_ADMINID, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 478, 293, 30));

        AD_PASSWORD.setBackground(new java.awt.Color(248, 243, 232));
        AD_PASSWORD.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        AD_PASSWORD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        ADMIN_ACCOUNT_PANEL.add(AD_PASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 543, 139, 30));

        AD_CONFIRMPASS.setBackground(new java.awt.Color(248, 243, 232));
        AD_CONFIRMPASS.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        AD_CONFIRMPASS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 167, 20)));
        ADMIN_ACCOUNT_PANEL.add(AD_CONFIRMPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 543, 139, 30));

        AD_BACKGROUND_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEUSER/ADM_ADMIN_ACC_FRAME.png"))); // NOI18N
        ADMIN_ACCOUNT_PANEL.add(AD_BACKGROUND_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 27, -1, -1));

        jP_ADM_MANAGE_USERS.add(ADMIN_ACCOUNT_PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        BUTTON_STUDENT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEUSER/STUDENT ACCOUNT (SPINE).png"))); // NOI18N
        BUTTON_STUDENT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BUTTON_STUDENTMouseClicked(evt);
            }
        });
        jP_ADM_MANAGE_USERS.add(BUTTON_STUDENT, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 68, -1, -1));

        BUTTON_LIBRARIAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEUSER/LIBRARIAN ACCOUNT (SPINE).png"))); // NOI18N
        BUTTON_LIBRARIAN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BUTTON_LIBRARIANMouseClicked(evt);
            }
        });
        jP_ADM_MANAGE_USERS.add(BUTTON_LIBRARIAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 242, -1, -1));

        BUTTON_ADMIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM_MANAGEUSER/ADMIN ACCOUNT(SPINE).png"))); // NOI18N
        BUTTON_ADMIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BUTTON_ADMINMouseClicked(evt);
            }
        });
        jP_ADM_MANAGE_USERS.add(BUTTON_ADMIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 403, -1, -1));

        jPanel1.add(jP_ADM_MANAGE_USERS, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 0, 980, 700));

        jP_ADM_ACCOUNT.setBackground(new java.awt.Color(255, 254, 252));
        jP_ADM_ACCOUNT.setMaximumSize(new java.awt.Dimension(980, 700));
        jP_ADM_ACCOUNT.setMinimumSize(new java.awt.Dimension(980, 700));
        jP_ADM_ACCOUNT.setOpaque(false);
        jP_ADM_ACCOUNT.setPreferredSize(new java.awt.Dimension(980, 700));
        jP_ADM_ACCOUNT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ADM_EDIT_BUTTON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/AD_EDIT_BUTTON.png"))); // NOI18N
        jP_ADM_ACCOUNT.add(ADM_EDIT_BUTTON, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 441, -1, -1));

        ADM_ACCOUNT_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/AD_ACCOUNT_FRAME.png"))); // NOI18N
        jP_ADM_ACCOUNT.add(ADM_ACCOUNT_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jP_ADM_ACCOUNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 0, -1, -1));

        ADM_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_DASHBOARD_ACTIVE.png"))); // NOI18N
        ADM_DASHBOARD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADM_DASHBOARDMouseClicked(evt);
            }
        });
        jPanel1.add(ADM_DASHBOARD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 97, -1, -1));

        ADM_MANAGE_BOOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_MANAGEBOOK.png"))); // NOI18N
        ADM_MANAGE_BOOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADM_MANAGE_BOOKMouseClicked(evt);
            }
        });
        jPanel1.add(ADM_MANAGE_BOOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 163, -1, -1));

        ADM_MANAGE_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_MANAGEUSER.png"))); // NOI18N
        ADM_MANAGE_USER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADM_MANAGE_USERMouseClicked(evt);
            }
        });
        jPanel1.add(ADM_MANAGE_USER, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 229, -1, -1));

        ADM_ACCOUNT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_ACCOUNT.png"))); // NOI18N
        ADM_ACCOUNT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADM_ACCOUNTMouseClicked(evt);
            }
        });
        jPanel1.add(ADM_ACCOUNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 295, -1, -1));

        ADM_LOGOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_LOGOUT.png"))); // NOI18N
        ADM_LOGOUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADM_LOGOUTMouseClicked(evt);
            }
        });
        jPanel1.add(ADM_LOGOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 616, -1, -1));

        ADM_DIVIDER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADM_MAIN_DIVIDER.png"))); // NOI18N
        jPanel1.add(ADM_DIVIDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADM_LOGOUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADM_LOGOUTMouseClicked
        int response = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to logout?",
        "Confirm Logout",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            MAIN main = new MAIN();
            main.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ADM_LOGOUTMouseClicked

    private void ADM_DASHBOARDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADM_DASHBOARDMouseClicked
        jP_ADM_DASHBOARD.setVisible(true);
        jP_ADM_MANAGE_BOOKS.setVisible(false);
        jP_ADM_MANAGE_USERS.setVisible(false);
        jP_ADM_ACCOUNT.setVisible(false);
        
        ADM_DASHBOARD.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_DASHBOARD_ACTIVE.png")));
        ADM_MANAGE_BOOK.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_MANAGEBOOK.png")));
        ADM_MANAGE_USER.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_MANAGEUSER.png")));
        ADM_ACCOUNT.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_ACCOUNT.png")));
    }//GEN-LAST:event_ADM_DASHBOARDMouseClicked

    private void ADM_MANAGE_BOOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADM_MANAGE_BOOKMouseClicked
        jP_ADM_MANAGE_BOOKS.setVisible(true);
        ADD_BOOK_PANEL.setVisible(true);
        jP_ADM_DASHBOARD.setVisible(false);
        jP_ADM_MANAGE_USERS.setVisible(false);
        jP_ADM_ACCOUNT.setVisible(false);
        
        ADM_MANAGE_BOOK.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_MANAGEBOOK_ACTIVE.png")));
        ADM_DASHBOARD.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_DASHBOARD.png")));
        ADM_MANAGE_USER.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_MANAGEUSER.png")));
        ADM_ACCOUNT.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_ACCOUNT.png")));
    }//GEN-LAST:event_ADM_MANAGE_BOOKMouseClicked

    private void BUTTON_ISSUE_BOOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUTTON_ISSUE_BOOKMouseClicked
        ISSUE_BOOK_PANEL.setVisible(true);
        ADD_BOOK_PANEL.setVisible(false);
        RETURN_BOOK_PANEL.setVisible(false);
    }//GEN-LAST:event_BUTTON_ISSUE_BOOKMouseClicked

    private void BUTTON_RETURN_BOOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUTTON_RETURN_BOOKMouseClicked
        RETURN_BOOK_PANEL.setVisible(true);
        ADD_BOOK_PANEL.setVisible(false);
        ISSUE_BOOK_PANEL.setVisible(false);
    }//GEN-LAST:event_BUTTON_RETURN_BOOKMouseClicked

    private void BUTTON_ADD_BOOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUTTON_ADD_BOOKMouseClicked
        ADD_BOOK_PANEL.setVisible(true);
        ISSUE_BOOK_PANEL.setVisible(false);
        RETURN_BOOK_PANEL.setVisible(false);
    }//GEN-LAST:event_BUTTON_ADD_BOOKMouseClicked

    private void BUTTON_STUDENTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUTTON_STUDENTMouseClicked
        STUDENT_ACCOUNT_PANEL.setVisible(true);
        LIBRARIAN_ACCOUNT_PANEL.setVisible(false);
        ADMIN_ACCOUNT_PANEL.setVisible(false);
        LoadStudent();
    }//GEN-LAST:event_BUTTON_STUDENTMouseClicked

    private void BUTTON_LIBRARIANMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUTTON_LIBRARIANMouseClicked
        LIBRARIAN_ACCOUNT_PANEL.setVisible(true);
        STUDENT_ACCOUNT_PANEL.setVisible(false);
        ADMIN_ACCOUNT_PANEL.setVisible(false);
    }//GEN-LAST:event_BUTTON_LIBRARIANMouseClicked

    private void BUTTON_ADMINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUTTON_ADMINMouseClicked
        ADMIN_ACCOUNT_PANEL.setVisible(true);
        LIBRARIAN_ACCOUNT_PANEL.setVisible(false);
        STUDENT_ACCOUNT_PANEL.setVisible(false);
    }//GEN-LAST:event_BUTTON_ADMINMouseClicked

    private void ADM_MANAGE_USERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADM_MANAGE_USERMouseClicked
        jP_ADM_MANAGE_USERS.setVisible(true);
        STUDENT_ACCOUNT_PANEL.setVisible(true);
        jP_ADM_MANAGE_BOOKS.setVisible(false);
        jP_ADM_DASHBOARD.setVisible(false);
        jP_ADM_ACCOUNT.setVisible(false);
        
        ADM_MANAGE_USER.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_MANAGEUSER_ACTIVE.png")));
        ADM_MANAGE_BOOK.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_MANAGEBOOK.png")));
        ADM_DASHBOARD.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_DASHBOARD.png")));
        ADM_ACCOUNT.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_ACCOUNT.png")));
    }//GEN-LAST:event_ADM_MANAGE_USERMouseClicked

    private void ADM_ACCOUNTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADM_ACCOUNTMouseClicked
        jP_ADM_ACCOUNT.setVisible(true);
        jP_ADM_MANAGE_USERS.setVisible(false);
        STUDENT_ACCOUNT_PANEL.setVisible(false);
        jP_ADM_MANAGE_BOOKS.setVisible(false);
        jP_ADM_DASHBOARD.setVisible(false);
        
        ADM_ACCOUNT.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_ACCOUNT_ACTIVE.png")));
        ADM_MANAGE_USER.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_MANAGEUSER.png")));
        ADM_MANAGE_BOOK.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_MANAGEBOOK.png")));
        ADM_DASHBOARD.setIcon(new ImageIcon(getClass().getResource("/ADM/ADM_DASHBOARD.png")));
    }//GEN-LAST:event_ADM_ACCOUNTMouseClicked

    private void ST_FULLNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ST_FULLNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ST_FULLNAMEActionPerformed

    private void ST_CREATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ST_CREATEActionPerformed
        // TODO add your handling code here:
        String studentName = ST_FULLNAME.getText();
        String studentID = ST_STNUMBER.getText();
        String studentEmail = ST_EMAILADD.getText();
        String studentHome = ST_HOMEADD.getText();
        String studentPass = ST_PASSWORD.getText();
        String studentPhonenum = ST_PHONENUM.getText();
        String studentUsername = ST_USERNAME.getText();
        String studentConfirmPass = ST_CONFIRMPASS.getText();
        String yearLevel = ST_YEARSEC.getText();

        if (studentName.isEmpty() || studentID.isEmpty()|| studentEmail.isEmpty() || studentHome.isEmpty() || studentPass.isEmpty() || studentConfirmPass.isEmpty() || yearLevel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!studentPass.equals(studentConfirmPass)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            Map<String, String> studentData = new HashMap<>();
            studentData.put("full_name", studentName);
            studentData.put("student_number", studentID);
            studentData.put("email_address", studentEmail);
            studentData.put("username", studentUsername);
            studentData.put("phone_number", studentPhonenum);
            studentData.put("home_address", studentHome);
            studentData.put("password", studentPass);
            studentData.put("year_and_section", yearLevel);

            StudentDatabase.getInstance().insertStudent(studentData);
            ST_FULLNAME.setText("");
            ST_STNUMBER.setText("");
            ST_PHONENUM.setText("");
            ST_EMAILADD.setText("");
            ST_HOMEADD.setText("");
            ST_PASSWORD.setText("");
            ST_CONFIRMPASS.setText("");
            ST_USERNAME.setText("");
            ST_YEARSEC.setText("");

            LoadStudent();
            initializeDashboard();

        }


    }//GEN-LAST:event_ST_CREATEActionPerformed

    private void LB_CREATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LB_CREATEActionPerformed

        String librarianName = LB_FULLNAME.getText();
        String librarianID = LB_LIBID.getText();
        String librarianEmail = LB_EMAILADD.getText();
        String librarianHome = LB_HOMEADD.getText();
        String librarianPass = LB_PASSWORD.getText();
        String librarianPhonenum = LB_PHONENUM.getText();
        String librarianBirthdate = LB_BIRTHDATE.getText();
        String librarianConfirmPass = LB_CONFIRMPASS.getText();
        String librarianGWA = LB_GWA.getText();

        if (librarianName.isEmpty() || librarianID.isEmpty()|| librarianEmail.isEmpty() || librarianHome.isEmpty() || librarianPass.isEmpty() || librarianConfirmPass.isEmpty() || librarianGWA.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!librarianPass.equals(librarianConfirmPass)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            Map<String, String> librarianData = new HashMap<>();
            librarianData.put("full_name", librarianName);
            librarianData.put("librarian_id", librarianID);
            librarianData.put("email_address", librarianEmail);
            librarianData.put("phone_number", librarianPhonenum);
            librarianData.put("home_address", librarianHome);
            librarianData.put("password", librarianPass);
            librarianData.put("birthdate", librarianBirthdate);
            librarianData.put("gwa", librarianGWA);

            LibrarianDatabase.getInstance().insertLibrarian(librarianData);
            LB_FULLNAME.setText("");
            LB_LIBID.setText("");
            LB_PHONENUM.setText("");
            LB_EMAILADD.setText("");
            LB_HOMEADD.setText("");
            LB_PASSWORD.setText("");
            LB_CONFIRMPASS.setText("");
            LB_BIRTHDATE.setText("");
            LB_GWA.setText("");
            LoadLibrarian();
            initializeDashboard();
        }



        // TODO add your handling code here:
    }//GEN-LAST:event_LB_CREATEActionPerformed

    private void AD_CREATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AD_CREATEActionPerformed
        // TODO add your handling code here:
        String adminName = AD_FULLNAME.getText();
        String adminID = AD_ADMINID.getText();
        String adminEmail = AD_EMAILADD.getText();
        String adminHome = AD_HOMEADD.getText();
        String adminPass = AD_PASSWORD.getText();
        String adminPhonenum = AD_PHONENUM.getText();
        String adminConfirmPass = AD_CONFIRMPASS.getText();
        String adminEducAttain = AD_EDUCATTAIN.getText();
        String adminKeyPass = AD_KEYPASS.getText();
        String adminAdminNum = AD_ADMINNUM.getText();
        if (adminName.isEmpty() || adminID.isEmpty()|| adminEmail.isEmpty() || adminHome.isEmpty() || adminPass.isEmpty() || adminConfirmPass.isEmpty() || adminEducAttain.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!adminPass.equals(adminConfirmPass)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            Map<String, String> adminData = new HashMap<>();
            adminData.put("full_name", adminName);
            adminData.put("admin_id", adminID);
            adminData.put("email_address", adminEmail);
            adminData.put("phone_number", adminPhonenum);
            adminData.put("home_address", adminHome);
            adminData.put("password", adminPass);
            adminData.put("education_attainment", adminEducAttain);
            adminData.put("key_password", adminKeyPass);
            adminData.put("admin_number", adminAdminNum);

            AdminDatabase.getInstance().insertAdmin(adminData);
            AD_FULLNAME.setText("");
            AD_ADMINID.setText("");
            AD_PHONENUM.setText("");
            AD_EMAILADD.setText("");
            AD_HOMEADD.setText("");
            AD_PASSWORD.setText("");
            AD_CONFIRMPASS.setText("");
            AD_EDUCATTAIN.setText("");
            AD_KEYPASS.setText("");
            AD_ADMINNUM.setText("");
            LoadAdmin();
            initializeDashboard();

        }
    }//GEN-LAST:event_AD_CREATEActionPerformed

    // This is for clear student
    private void ST_CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ST_CLEARActionPerformed
        // TODO add your handling code here:
        ST_FULLNAME.setText("");
        ST_STNUMBER.setText("");
        ST_PHONENUM.setText("");
        ST_EMAILADD.setText("");
        ST_HOMEADD.setText("");
        ST_PASSWORD.setText("");
        ST_CONFIRMPASS.setText("");
        ST_USERNAME.setText("");
        ST_YEARSEC.setText("");

        
    }//GEN-LAST:event_ST_CLEARActionPerformed

    // This is for clear librarian
    private void LB_CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LB_CLEARActionPerformed
        // TODO add your handling code here:
        LB_FULLNAME.setText("");
        LB_LIBID.setText("");
        LB_PHONENUM.setText("");
        LB_EMAILADD.setText("");
        LB_HOMEADD.setText("");
        LB_PASSWORD.setText("");
        LB_CONFIRMPASS.setText("");
        LB_BIRTHDATE.setText("");
        LB_GWA.setText("");
        LB_LIBID.setText("");

    }//GEN-LAST:event_LB_CLEARActionPerformed

    // This is for clear admin
    private void AD_CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AD_CLEARActionPerformed
        // TODO add your handling code here:
        AD_FULLNAME.setText("");
        AD_ADMINID.setText("");
        AD_PHONENUM.setText("");
        AD_EMAILADD.setText("");
        AD_HOMEADD.setText("");
        AD_PASSWORD.setText("");
        AD_CONFIRMPASS.setText("");
        AD_EDUCATTAIN.setText("");
        AD_KEYPASS.setText("");
        AD_ADMINNUM.setText("");
    }//GEN-LAST:event_AD_CLEARActionPerformed

    // This will add books
    private void AB_ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AB_ADDActionPerformed
        // TODO add your handling code here:
        String bookTitle = AB_BOOK_TITLE.getText();
        String bookAuthor = AB_BOOK_AUTHOR.getText();
        String bookISBN = AB_ISBN.getText();
        String bookGenre = AB_BOOK_GENRE.getText();
        String bookDate = AB_DATE_PUB.getText();
        if (bookTitle.isEmpty() || bookAuthor.isEmpty() || bookISBN.isEmpty() || bookGenre.isEmpty() || bookDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Map<String, String> bookData = new HashMap<>();
            bookData.put("book_title", bookTitle);
            bookData.put("book_author", bookAuthor);
            bookData.put("isbn", bookISBN);
            bookData.put("book_genre", bookGenre);
            bookData.put("date_published", bookDate);

            BookDatabase.getInstance().insertBook(bookData);
            AB_BOOK_TITLE.setText("");
            AB_BOOK_AUTHOR.setText("");
            AB_ISBN.setText("");
            AB_BOOK_GENRE.setText("");
            AB_DATE_PUB.setText("");
            LoadBook();
            initializeDashboard();

        }

    }//GEN-LAST:event_AB_ADDActionPerformed

    // This will clear the add books
    private void AB_CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AB_CLEARActionPerformed
        // TODO add your handling code here:
         AB_BOOK_TITLE.setText("");
         AB_BOOK_AUTHOR.setText("");
            AB_ISBN.setText("");
            AB_BOOK_GENRE.setText("");
            AB_DATE_PUB.setText("");

    }//GEN-LAST:event_AB_CLEARActionPerformed

    // This will add the issue books
    private void IS_ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IS_ADDActionPerformed
        // TODO add your handling code here:
        String isbn = IB_ISBN.getText();
        String name = IB_NAME.getText();
        String phone = IB_PHONENUMBER.getText();
        String email = IB_EMAILADD.getText();
        String issueID = IB_ISSUEID.getText();
        String issueDate = IB_ISSUEDATE.getText();
        String returnDate = IB_RETURNDATE.getText();
        String status = IB_COMBO.getSelectedItem().toString();

         if  (isbn.isEmpty() || name.isEmpty() || phone.isEmpty() || email.isEmpty() || issueID.isEmpty() || issueDate.isEmpty() || returnDate.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
         }

        else {
             Map<String, String> issueData = new HashMap<>();
             issueData.put("isbn", isbn);
             issueData.put("name", name);
             issueData.put("phone_number", phone);
             issueData.put("email_address", email);
             issueData.put("issue_id", issueID);
             issueData.put("issue_date", issueDate);
             issueData.put("return_date", returnDate);
             issueData.put("status", status);

             IssueBookDatabase.getInstance().insertIssueBook(issueData);
             IB_ISBN.setText("");
             IB_NAME.setText("");
             IB_PHONENUMBER.setText("");
             IB_EMAILADD.setText("");
             IB_ISSUEID.setText("");
             IB_ISSUEDATE.setText("");
             IB_RETURNDATE.setText("");

                LoadIssueBook();
             initializeDashboard();
         }


    }//GEN-LAST:event_IS_ADDActionPerformed

    // This will clear the issue books
    private void IS_CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IS_CLEARActionPerformed
        // TODO add your handling code here:
        IB_ISBN.setText("");
        IB_NAME.setText("");
        IB_PHONENUMBER.setText("");
        IB_EMAILADD.setText("");
        IB_ISSUEID.setText("");
        IB_ISSUEDATE.setText("");
        IB_RETURNDATE.setText("");
    }//GEN-LAST:event_IS_CLEARActionPerformed

    // Added a function it will add the return books
    private void IS_EDIT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IS_EDIT1ActionPerformed
        // TODO add your handling code here:
        String issueID = RB_ISSUEID.getText();
        String issueDate = RB_ISSUEDATE.getText();
        String returnDate = RB_RETURNDATE.getText();
        String status = RB_BOOKSTATUS.getText();
        String isbn = RB_ISBN.getText();
        String name = RB_NAME.getText();
        String phone = RB_PHONENUMBER.getText();

         if (issueID.isEmpty() || returnDate.isEmpty() || status.isEmpty() || isbn.isEmpty() || name.isEmpty() || phone.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
         } else {
             Map<String, String> issueData = new HashMap<>();
             issueData.put("isbn", isbn);
             issueData.put("name", name);
             issueData.put("phone_number", phone);
             issueData.put("email_address", "N/A");
             issueData.put("issue_id", issueID);
             issueData.put("issue_date", issueDate);
             issueData.put("return_date", returnDate);
             issueData.put("status", status);

             IssueBookDatabase.getInstance().insertIssueBook(issueData);
                RB_ISBN.setText("");
                RB_NAME.setText("");
                RB_PHONENUMBER.setText("");
                RB_ISSUEID.setText("");
                RB_ISSUEDATE.setText("");
                RB_RETURNDATE.setText("");
                RB_BOOKSTATUS.setText("");

             LoadReturnBook();
             initializeDashboard();
         }



    }//GEN-LAST:event_IS_EDIT1ActionPerformed

    // This will clear the return book
    private void IS_CLEAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IS_CLEAR1ActionPerformed
        // TODO add your handling code here:
        RB_ISBN.setText("");
        RB_NAME.setText("");
        RB_PHONENUMBER.setText("");
        RB_ISSUEID.setText("");
        RB_ISSUEDATE.setText("");
        RB_RETURNDATE.setText("");
        RB_BOOKSTATUS.setText("");
    }//GEN-LAST:event_IS_CLEAR1ActionPerformed

    // This will delete the admin to the database
    private void AD_REMOVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AD_REMOVEActionPerformed
        // TODO add your handling code here:

        int selectedRow = AD_TABLE.getSelectedRow();

        if (selectedRow != -1) {
            String adminID = model2.getValueAt(selectedRow, 0).toString();
            
            if(adminId.equals(adminID)){
                 JOptionPane.showMessageDialog(this, "You cannot remove your own account.", "Error", JOptionPane.ERROR_MESSAGE);

            } else{
                // Remove the selected admin from the database
                AdminDatabase.getInstance().deleteAdmin(adminID);
                LoadAdmin();
                initializeDashboard();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an admin to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }


       
    }//GEN-LAST:event_AD_REMOVEActionPerformed

    // This will edit the data of the student
    private void ST_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ST_EDITActionPerformed
        // TODO add your handling code here:
        int selectedRow = ST_TABLE.getSelectedRow();

        if (selectedRow != -1) {

            // Retrieve current student details from the table
            String studentID = model.getValueAt(selectedRow, 0).toString();
            String username = model.getValueAt(selectedRow, 1).toString();
            String fullName = model.getValueAt(selectedRow, 2).toString();
            String studentNumber = model.getValueAt(selectedRow, 3).toString();
            String emailAddress = model.getValueAt(selectedRow, 4).toString();
            String phoneNumber = model.getValueAt(selectedRow, 5).toString();
            String homeAddress = model.getValueAt(selectedRow, 6).toString();
            String yearAndSection = model.getValueAt(selectedRow, 7).toString();
            String password = model.getValueAt(selectedRow, 8).toString();



            // Create input fields
            JTextField usernameField = new JTextField(username);
            JTextField fullNameField = new JTextField(fullName);
            JTextField studentNumberField = new JTextField(studentNumber);
            JTextField emailAddressField = new JTextField(emailAddress);
            JTextField phoneNumberField = new JTextField(phoneNumber);
            JTextField homeAddressField = new JTextField(homeAddress);
            JTextField yearAndSectionField = new JTextField(yearAndSection);
            JTextField passwordField = new JTextField(password);


            // Create a panel to hold the input fields
            JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));
            panel.add(new JLabel("Username:"));
            panel.add(usernameField);
            panel.add(new JLabel("Full Name:"));
            panel.add(fullNameField);
            panel.add(new JLabel("Student Number:"));
            panel.add(studentNumberField);
            panel.add(new JLabel("Email Address:"));
            panel.add(emailAddressField);
            panel.add(new JLabel("Phone Number:"));
            panel.add(phoneNumberField);
            panel.add(new JLabel("Home Address:"));
            panel.add(homeAddressField);
            panel.add(new JLabel("Year and Section:"));
            panel.add(yearAndSectionField);
            panel.add(new JLabel("Password:"));
            panel.add(passwordField);


            // Show the dialog
            int result = JOptionPane.showConfirmDialog(
                    this, panel, "Edit Student Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                // Retrieve updated values
                String updatedFullName = fullNameField.getText();
                String updatedStudentNumber = studentNumberField.getText();
                String updatedEmailAddress = emailAddressField.getText();
                String updatedPhoneNumber = phoneNumberField.getText();
                String updatedHomeAddress = homeAddressField.getText();
                String updatedYearAndSection = yearAndSectionField.getText();
                String updatedPassword = passwordField.getText();
                String updatedUsername = usernameField.getText();


                // Create a map for the updated data
                Map<String, String> studentData = new HashMap<>();
                studentData.put("full_name", updatedFullName);
                studentData.put("student_number", updatedStudentNumber);
                studentData.put("email_address", updatedEmailAddress);
                studentData.put("phone_number", updatedPhoneNumber);
                studentData.put("home_address", updatedHomeAddress);
                studentData.put("year_and_section", updatedYearAndSection);
                studentData.put("password", updatedPassword);
                studentData.put("username", updatedUsername);

                // Update the student in the database

                StudentDatabase.getInstance().updateStudent(studentID, studentData);

                // Reload the student table
                LoadStudent();
                initializeDashboard();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to edit.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ST_EDITActionPerformed

    // This will edit the librarian
    private void LB_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LB_EDITActionPerformed
        // TODO add your handling code here:

        int selectedRow = LB_TABLE.getSelectedRow();

        if (selectedRow != -1) {
            // Retrieve current librarian details from the table
            String librarianID = model1.getValueAt(selectedRow, 0).toString();
            String fullName = model1.getValueAt(selectedRow, 1).toString();
            String emailAddress = model1.getValueAt(selectedRow, 7).toString();
            String phoneNumber = model1.getValueAt(selectedRow, 6).toString();
            String homeAddress = model1.getValueAt(selectedRow, 4).toString();
            String password = model1.getValueAt(selectedRow, 2).toString();
            String birthdate = model1.getValueAt(selectedRow, 3).toString();
            String gwa = model1.getValueAt(selectedRow, 5).toString();

            // Create input fields
            JTextField fullNameField = new JTextField(fullName);
            JTextField emailAddressField = new JTextField(emailAddress);
            JTextField phoneNumberField = new JTextField(phoneNumber);
            JTextField homeAddressField = new JTextField(homeAddress);
            JTextField passwordField = new JTextField(password);
            JTextField birthdateField = new JTextField(birthdate);
            JTextField gwaField = new JTextField(gwa);

            // Create a panel to hold the input fields
            JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
            panel.add(new JLabel("Full Name:"));
            panel.add(fullNameField);
            panel.add(new JLabel("Email Address:"));
            panel.add(emailAddressField);
            panel.add(new JLabel("Phone Number:"));
            panel.add(phoneNumberField);
            panel.add(new JLabel("Home Address:"));
            panel.add(homeAddressField);
            panel.add(new JLabel("Password:"));
            panel.add(passwordField);
            panel.add(new JLabel("Birthdate:"));
            panel.add(birthdateField);
            panel.add(new JLabel("GWA:"));
            panel.add(gwaField);


            // Show the dialog
            int result = JOptionPane.showConfirmDialog(
                    this, panel, "Edit Librarian Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                // Retrieve updated values
                String updatedFullName = fullNameField.getText();
                String updatedEmailAddress = emailAddressField.getText();
                String updatedPhoneNumber = phoneNumberField.getText();
                String updatedHomeAddress = homeAddressField.getText();
                String updatedPassword = passwordField.getText();
                String updatedBirthdate = birthdateField.getText();
                String updatedGwa = gwaField.getText();

                // Create a map for the updated data
                Map<String, String> librarianData = new HashMap<>();
                librarianData.put("full_name", updatedFullName);
                librarianData.put("email_address", updatedEmailAddress);
                librarianData.put("phone_number", updatedPhoneNumber);
                librarianData.put("home_address", updatedHomeAddress);
                librarianData.put("password", updatedPassword);
                librarianData.put("birthdate", updatedBirthdate);
                librarianData.put("gwa", updatedGwa);
                // Update the librarian in the database
                LibrarianDatabase.getInstance().updateLibrarian(librarianID, librarianData);

                // Reload the librarian table
                LoadLibrarian();
                initializeDashboard();

            }
        }


    }//GEN-LAST:event_LB_EDITActionPerformed

    // This will delete the student
    private void ST_REMOVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ST_REMOVEActionPerformed

        int selectedRow = ST_TABLE.getSelectedRow();

        if (selectedRow != -1) {
            String studentID = model.getValueAt(selectedRow, 0).toString();
            // Remove the selected student from the database
            StudentDatabase.getInstance().deleteStudent(studentID);
            LoadStudent();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_ST_REMOVEActionPerformed

    // This will remove the librarian
    private void LB_REMOVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LB_REMOVEActionPerformed
        // TODO add your handling code here:

        int selectedRow = LB_TABLE.getSelectedRow();

        if (selectedRow != -1) {
            String librarianID = model1.getValueAt(selectedRow, 0).toString();
            // Remove the selected librarian from the database
            LibrarianDatabase.getInstance().deleteLibrarian(librarianID);
            LoadLibrarian();
            initializeDashboard();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a librarian to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LB_REMOVEActionPerformed

    // This will delete the book
    private void AB_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AB_DELETEActionPerformed
        // TODO add your handling code here:

        int selectedRow = AB_TABLE.getSelectedRow();

        if (selectedRow != -1) {
            String bookID = model3.getValueAt(selectedRow, 0).toString();
            // Remove the selected book from the database
            BookDatabase.getInstance().deleteBook(bookID);
            LoadBook();
            initializeDashboard();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AB_DELETEActionPerformed

    // This is for edit the books
    private void AB_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AB_EDITActionPerformed
        // TODO add your handling code here:

        int selectedRow = AB_TABLE.getSelectedRow();

        if (selectedRow != -1) {
            // Retrieve current book details from the table
            String bookID = model3.getValueAt(selectedRow, 0).toString();
            String bookTitle = model3.getValueAt(selectedRow, 1).toString();
            String bookAuthor = model3.getValueAt(selectedRow, 2).toString();
            String bookGenre = model3.getValueAt(selectedRow, 3).toString();
            String bookDate = model3.getValueAt(selectedRow, 4).toString();
            String bookISBN = model3.getValueAt(selectedRow, 5).toString();

            // Create input fields
            JTextField bookTitleField = new JTextField(bookTitle);
            JTextField bookAuthorField = new JTextField(bookAuthor);
            JTextField bookISBNField = new JTextField(bookISBN);
            JTextField bookGenreField = new JTextField(bookGenre);
            JTextField bookDateField = new JTextField(bookDate);

            // Create a panel to hold the input fields
            JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
            panel.add(new JLabel("Book Title:"));
            panel.add(bookTitleField);
            panel.add(new JLabel("Book Author:"));
            panel.add(bookAuthorField);
            panel.add(new JLabel("ISBN:"));
            panel.add(bookISBNField);
            panel.add(new JLabel("Book Genre:"));
            panel.add(bookGenreField);
            panel.add(new JLabel("Date Published:"));
            panel.add(bookDateField);

            // Show the dialog
            int result = JOptionPane.showConfirmDialog(
                    this, panel, "Edit Book Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                // Retrieve updated values
                String updatedBookTitle = bookTitleField.getText();
                String updatedBookAuthor = bookAuthorField.getText();
                String updatedBookISBN = bookISBNField.getText();
                String updatedBookGenre = bookGenreField.getText();
                String updatedBookDate = bookDateField.getText();

                // Create a map for the updated data
                Map<String, String> bookData = new HashMap<>();
                bookData.put("book_title", updatedBookTitle);
                bookData.put("book_author", updatedBookAuthor);
                bookData.put("isbn", updatedBookISBN);
                bookData.put("book_genre", updatedBookGenre);
                bookData.put("date_published", updatedBookDate);
                // Update the book in the database
                BookDatabase.getInstance().updateBook(bookID, bookData);
                // Reload the book table
                LoadBook();
                initializeDashboard();
            } else {
            JOptionPane.showMessageDialog(this, "Please select a book to edit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_AB_EDITActionPerformed

    // This will edit the issue books
    private void IS_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IS_EDITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IS_EDITActionPerformed

    // This will delete the issue books
    private void IS_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IS_DELETEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IS_DELETEActionPerformed

     // This will edit the data of the admin
     private void AD_EDITActionPerformed(java.awt.event.ActionEvent evt) {                                        
         // Get the selected row
         int selectedRow = AD_TABLE.getSelectedRow();

         if (selectedRow != -1) {
             // Retrieve current admin details from the table
             String adminID = model2.getValueAt(selectedRow, 0).toString();
             String fullName = model2.getValueAt(selectedRow, 1).toString();
             String keyPassword = model2.getValueAt(selectedRow, 2).toString();
             String educationAttainment = model2.getValueAt(selectedRow, 3).toString();
             String phoneNumber = model2.getValueAt(selectedRow, 4).toString();
             String emailAddress = model2.getValueAt(selectedRow, 5).toString();
             String homeAddress = model2.getValueAt(selectedRow, 6).toString();
             String adminNumber = model2.getValueAt(selectedRow, 7).toString();
             String password = model2.getValueAt(selectedRow, 8).toString();

             // Create input fields
             JTextField adminIDField = new JTextField(adminID);
             JTextField fullNameField = new JTextField(fullName);
             JTextField keyPasswordField = new JTextField(keyPassword);
             JTextField educationAttainmentField = new JTextField(educationAttainment);
             JTextField phoneNumberField = new JTextField(phoneNumber);
             JTextField emailAddressField = new JTextField(emailAddress);
             JTextField homeAddressField = new JTextField(homeAddress);
             JTextField adminNumberField = new JTextField(adminNumber);
             JTextField passwordField = new JTextField(password);

             // Create a panel to hold the input fields
             JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5)); // Adjusted to 9 rows and 2 columns
             panel.add(new JLabel("Full Name:"));
             panel.add(fullNameField);
             panel.add(new JLabel("Key Password:"));
             panel.add(keyPasswordField);
             panel.add(new JLabel("Education Attainment:"));
             panel.add(educationAttainmentField);
             panel.add(new JLabel("Phone Number:"));
             panel.add(phoneNumberField);
             panel.add(new JLabel("Email Address:"));
             panel.add(emailAddressField);
             panel.add(new JLabel("Home Address:"));
             panel.add(homeAddressField);
             panel.add(new JLabel("Admin Number:"));
             panel.add(adminNumberField);
             panel.add(new JLabel("Password:"));
             panel.add(passwordField);

             // Show the dialog
             int result = JOptionPane.showConfirmDialog(
                     this, panel, "Edit Admin Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
             );

             if (result == JOptionPane.OK_OPTION) {
                 // Retrieve updated values
                 String updatedAdminID = adminIDField.getText();
                 String updatedFullName = fullNameField.getText();
                 String updatedKeyPassword = keyPasswordField.getText();
                 String updatedEducationAttainment = educationAttainmentField.getText();
                 String updatedPhoneNumber = phoneNumberField.getText();
                 String updatedEmailAddress = emailAddressField.getText();
                 String updatedHomeAddress = homeAddressField.getText();
                 String updatedAdminNumber = adminNumberField.getText();
                    String updatedPassword = passwordField.getText();

                 // Create a map for the updated data
                 Map<String, String> adminData = new HashMap<>();
                 adminData.put("admin_id", updatedAdminID);
                 adminData.put("full_name", updatedFullName);
                 adminData.put("key_pass", updatedKeyPassword);
                 adminData.put("education_attainment", updatedEducationAttainment);
                 adminData.put("phone_number", updatedPhoneNumber);
                 adminData.put("email_address", updatedEmailAddress);
                 adminData.put("home_address", updatedHomeAddress);
                 adminData.put("admin_number", updatedAdminNumber);
                    adminData.put("password", updatedPassword);

                 // Update the admin in the database
                AdminDatabase.getInstance().updateAdmin(adminID, adminData);

                 // Reload the admin table
                 LoadAdmin();
                 initializeDashboard();
             }
         } else {
             JOptionPane.showMessageDialog(this, "Please select an admin to edit.", "Error", JOptionPane.ERROR_MESSAGE);
         }
     }                                                                              



    // Load the student data into the table
    void LoadStudent() {
        model.setRowCount(0); // Clear existing rows
        studentList = StudentDatabase.getInstance().getStudent();

        if (studentList != null) {
            for (StudentModel student : studentList) {
                model.addRow(new Object[]{
                        student.getUserid(),
                        student.getUsername(),
                        student.getFullname(),
                        student.getStudentNumber(),
                        student.getEmailAddress(),
                        student.getPhoneNumber(),
                        student.getHomeAddress(),
                        student.getYearAndSection(),
                        student.getPassword()

                });
            }
        } else {
            System.out.println("No students found.");
        }
    }

    void LoadLibrarian() {
        model1.setRowCount(0); // Clear existing rows
        librarianList = LibrarianDatabase.getInstance().getLibrarian();

        if (librarianList != null) {
            for (LibraryModel librarian : librarianList) {
                model1.addRow(new Object[]{
                        librarian.getLibrarianId(),
                        librarian.getFullName(),
                        librarian.getPassword(),
                        librarian.getBirthdate(),
                        librarian.getHomeAddress(),
                        librarian.getGwa(),
                        librarian.getPhoneNumber(),
                        librarian.getEmailAddress(),
                });
            }
        } else {
            System.out.println("No librarians found.");
        }
    }


     void LoadAdmin() {
         model2.setRowCount(0); // Clear existing rows
         adminModelList = AdminDatabase.getInstance().getAdmin();

         if (adminModelList != null) {
             for (AdminModel admin : adminModelList) {
                 model2.addRow(new Object[]{
                         admin.getAdminID(),
                         admin.getFullname(),
                         admin.getKeyPassword(),
                         admin.getEducationAttainment(),
                         admin.getPhoneNumber(),
                         admin.getEmailAddress(),
                         admin.getHomeAddress(),
                         admin.getAdminNumber(),
                         admin.getPassword(),
                 });
             }
         } else {
             System.out.println("No admins found.");
         }

     }

    void LoadBook() {
        model3.setRowCount(0); // Clear existing rows
        bookList = BookDatabase.getInstance().getBooks();

        if (bookList != null) {
            for (BookModel book : bookList) {
                model3.addRow(new Object[]{
                        book.getBook_id(),
                        book.getBook_title(),
                        book.getBook_author(),
                        book.getBook_genre(),
                        book.getDate_published(),
                        book.getIsbn(),
                        book.getStatus(),
                });
            }
        } else {
            System.out.println("No books found.");
        }
    }

    void LoadIssueBook() {
        model4.setRowCount(0); // Clear existing rows
        issueBookList = IssueBookDatabase.getInstance().getIssueBook();

        if (issueBookList != null) {
            for (IssueBookModel issue : issueBookList) {
                model4.addRow(new Object[]{
                        issue.getIssue_id(),
                        issue.getIssue_date(),
                        issue.getReturn_date(),
                        issue.getName(),
                        issue.getIsbn(),
                        issue.getPhone_number(),
                        issue.getEmail_address(),
                        issue.getStatus()
                });
            }
        } else {
            System.out.println("No issued books found.");
        }
    }

    void LoadReturnBook() {
        model5.setRowCount(0); // Clear existing rows
        returnBookList = IssueBookDatabase.getInstance().getReturnBook();

        if (returnBookList != null) {
            for (IssueBookModel issue : returnBookList) {
                model5.addRow(new Object[]{
                        issue.getIssue_id(),
                        issue.getIssue_date(),
                        issue.getReturn_date(),
                        issue.getName(),
                        issue.getIsbn(),
                        issue.getPhone_number(),
                        issue.getStatus()
                });
            }
        } else {
            System.out.println("No issued books found.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADMIN(adminId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AB_ADD;
    private javax.swing.JTextField AB_BOOK_AUTHOR;
    private javax.swing.JTextField AB_BOOK_GENRE;
    private javax.swing.JTextField AB_BOOK_TITLE;
    private javax.swing.JButton AB_CLEAR;
    private javax.swing.JTextField AB_DATE_PUB;
    private javax.swing.JButton AB_DELETE;
    private javax.swing.JButton AB_EDIT;
    private javax.swing.JTextField AB_ISBN;
    private javax.swing.JTable AB_TABLE;
    private javax.swing.JLabel ADD_BOOK_LAYOUT;
    private javax.swing.JPanel ADD_BOOK_PANEL;
    private javax.swing.JPanel ADMIN_ACCOUNT_PANEL;
    private javax.swing.JLabel ADM_ACCOUNT;
    private javax.swing.JLabel ADM_ACCOUNT_LAYOUT;
    private javax.swing.JLabel ADM_DASHBOARD;
    private javax.swing.JLabel ADM_DIVIDER;
    private javax.swing.JLabel ADM_EDIT_BUTTON;
    private javax.swing.JLabel ADM_LOGOUT;
    private javax.swing.JLabel ADM_MANAGE_BOOK;
    private javax.swing.JLabel ADM_MANAGE_USER;
    private javax.swing.JLabel ADM_NOTIF;
    private javax.swing.JLabel ADM_SETTING;
    private javax.swing.JTextField AD_ADMINID;
    private javax.swing.JTextField AD_ADMINNUM;
    private javax.swing.JLabel AD_BACKGROUND_LAYOUT;
    private javax.swing.JButton AD_CLEAR;
    private javax.swing.JPasswordField AD_CONFIRMPASS;
    private javax.swing.JButton AD_CREATE;
    private javax.swing.JButton AD_EDIT;
    private javax.swing.JTextField AD_EDUCATTAIN;
    private javax.swing.JTextField AD_EMAILADD;
    private javax.swing.JTextField AD_FULLNAME;
    private javax.swing.JTextField AD_HOMEADD;
    private javax.swing.JTextField AD_KEYPASS;
    private javax.swing.JPasswordField AD_PASSWORD;
    private javax.swing.JTextField AD_PHONENUM;
    private javax.swing.JButton AD_REMOVE;
    private javax.swing.JTable AD_TABLE;
    private javax.swing.JLabel BOOKS_BOOKS_BOOKS;
    private javax.swing.JLabel BUTTON_ADD_BOOK;
    private javax.swing.JLabel BUTTON_ADMIN;
    private javax.swing.JLabel BUTTON_ISSUE_BOOK;
    private javax.swing.JLabel BUTTON_LIBRARIAN;
    private javax.swing.JLabel BUTTON_RETURN_BOOK;
    private javax.swing.JLabel BUTTON_STUDENT;
    private javax.swing.JLabel DASHBAORD_LAYOUT;
    private javax.swing.JComboBox<String> IB_COMBO;
    private javax.swing.JTextField IB_EMAILADD;
    private javax.swing.JTextField IB_ISBN;
    private javax.swing.JTextField IB_ISSUEDATE;
    private javax.swing.JTextField IB_ISSUEID;
    private javax.swing.JTextField IB_NAME;
    private javax.swing.JTextField IB_PHONENUMBER;
    private javax.swing.JTextField IB_RETURNDATE;
    private javax.swing.JTable IB_TABALE;
    private javax.swing.JLabel ISSUE_BOOK_LAYOUT;
    private javax.swing.JPanel ISSUE_BOOK_PANEL;
    private javax.swing.JButton IS_ADD;
    private javax.swing.JButton IS_CLEAR;
    private javax.swing.JButton IS_CLEAR1;
    private javax.swing.JButton IS_DELETE;
    private javax.swing.JButton IS_EDIT;
    private javax.swing.JButton IS_EDIT1;
    private javax.swing.JLabel LB_BACKGROUND_LAYOUT;
    private javax.swing.JTextField LB_BIRTHDATE;
    private javax.swing.JButton LB_CLEAR;
    private javax.swing.JPasswordField LB_CONFIRMPASS;
    private javax.swing.JButton LB_CREATE;
    private javax.swing.JButton LB_EDIT;
    private javax.swing.JTextField LB_EMAILADD;
    private javax.swing.JTextField LB_FULLNAME;
    private javax.swing.JTextField LB_GWA;
    private javax.swing.JTextField LB_HOMEADD;
    private javax.swing.JTextField LB_LIBID;
    private javax.swing.JPasswordField LB_PASSWORD;
    private javax.swing.JTextField LB_PHONENUM;
    private javax.swing.JButton LB_REMOVE;
    private javax.swing.JTable LB_TABLE;
    private javax.swing.JLabel LIBRARIANS_PANEL;
    private javax.swing.JPanel LIBRARIAN_ACCOUNT_PANEL;
    private javax.swing.JLabel NUMBER_ADMINS;
    private javax.swing.JLabel NUMBER_AVAIL_BOOK;
    private javax.swing.JLabel NUMBER_ISSUED_BOOK;
    private javax.swing.JLabel NUMBER_LIBRARIANS;
    private javax.swing.JLabel NUMBER_OVERDUE;
    private javax.swing.JLabel NUMBER_RETURNED_BOOK;
    private javax.swing.JLabel NUMBER_STUDENTS;
    private javax.swing.JLabel OVERDUE_BOOKMARK;
    private javax.swing.JLabel OVERDUE_PANEL;
    private javax.swing.JTextField RB_BOOKSTATUS;
    private javax.swing.JTextField RB_ISBN;
    private javax.swing.JTextField RB_ISSUEDATE;
    private javax.swing.JTextField RB_ISSUEID;
    private javax.swing.JTextField RB_NAME;
    private javax.swing.JTextField RB_PHONENUMBER;
    private javax.swing.JTextField RB_RETURNDATE;
    private javax.swing.JTable RB_TABLE;
    private javax.swing.JLabel RETURN_BOOK_LAYOUT;
    private javax.swing.JPanel RETURN_BOOK_PANEL;
    private javax.swing.JLabel STUDENTS_PANEL;
    private javax.swing.JPanel STUDENT_ACCOUNT_PANEL;
    private javax.swing.JLabel ST_BACKGROUND_LAYOUT;
    private javax.swing.JButton ST_CLEAR;
    private javax.swing.JPasswordField ST_CONFIRMPASS;
    private javax.swing.JButton ST_CREATE;
    private javax.swing.JButton ST_EDIT;
    private javax.swing.JTextField ST_EMAILADD;
    private javax.swing.JTextField ST_FULLNAME;
    private javax.swing.JTextField ST_HOMEADD;
    private javax.swing.JPasswordField ST_PASSWORD;
    private javax.swing.JTextField ST_PHONENUM;
    private javax.swing.JButton ST_REMOVE;
    private javax.swing.JTextField ST_STNUMBER;
    private javax.swing.JTable ST_TABLE;
    private javax.swing.JTextField ST_USERNAME;
    private javax.swing.JTextField ST_YEARSEC;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jP_ADM_ACCOUNT;
    private javax.swing.JPanel jP_ADM_DASHBOARD;
    private javax.swing.JPanel jP_ADM_MANAGE_BOOKS;
    private javax.swing.JPanel jP_ADM_MANAGE_USERS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
