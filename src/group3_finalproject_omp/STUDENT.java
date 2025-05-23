/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group3_finalproject_omp;
import database.BookDatabase;
import database.DisplayCountedDashboard;
import database.IssueBookDatabase;
import database.LibrarySQL;
import model.BookModel;
import model.BorrowBookModel;
import model.PendingBorrowModel;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yuuki
 */
public class STUDENT extends javax.swing.JFrame {

    static String userid;
    static  String fullName;
    static String studentNo;
    int availableBooks;
    DefaultTableModel libraryStudentTableModel;
    DefaultTableModel borrowStudentTableModel;
    DefaultTableModel borrowedStudentTableModel;
    List<BookModel> bookList;
    List<BorrowBookModel> borrowedBookList;
    List<PendingBorrowModel> pendingBorrowList;

    /**
     * Creates new form GUEST_DASHBOARD
     */
    public STUDENT(String userid, String fullName, String studentNo) {
        STUDENT.userid = userid;
        STUDENT.fullName = fullName;
        STUDENT.studentNo = studentNo;
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/image_dashboard/omp(green).png")).getImage());
        
        jP_STU_DASHBOARD.setVisible(true);
        jP_STU_LIBRARY.setVisible(false);
        jP_STU_YOURSHELF.setVisible(false);
        jP_STU_ACCOUNT.setVisible(false);

        initializeDashboard();

        String [] columns1 = {"No", "Title", "Author", "Genre", "ISBN", "Status"};
        libraryStudentTableModel = new DefaultTableModel(columns1, 0);
        STU_BORROW_TABLE.setModel(libraryStudentTableModel);
        LoadBookList();

        STU_BORROW_TABLE.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = STU_BORROW_TABLE.getSelectedRow();
            if (selectedRow != -1) {
                // Populate the fields with the selected row's data
                B_BOOKTITLE.setText((String) libraryStudentTableModel.getValueAt(selectedRow, 1)); // Book Title
                B_ISBN.setText((String) libraryStudentTableModel.getValueAt(selectedRow, 4)); // ISBN
            }
        });

        B_STUDENTNAME.setText(fullName);
        B_STUDENTNUM.setText(studentNo);

        // Make the fields non-editable
        B_BOOKTITLE.setEditable(false);
        B_ISBN.setEditable(false);
        B_STUDENTNAME.setEditable(false);
        B_STUDENTNUM.setEditable(false);


        String [] columns2 = {"ID", "UserID", "Book Title", "ISBN", "Name", "Student Number", "Borrow Date", "Return Date"};
        borrowStudentTableModel = new DefaultTableModel(columns2, 0);
        STU_RETURN_TABLE.setModel(borrowStudentTableModel);

        LoadBorrowedBookList();

        STU_RETURN_TABLE.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = STU_RETURN_TABLE.getSelectedRow();
            if (selectedRow != -1) {
                // Populate the fields with the selected row's data
                R_BOOKTITLE.setText((String) borrowStudentTableModel.getValueAt(selectedRow, 2)); // Book Title
                R_ISBN.setText((String) borrowStudentTableModel.getValueAt(selectedRow, 3)); // ISBN
                R_RETURNDATE.setText((String) borrowStudentTableModel.getValueAt(selectedRow, 6)); // Return Date
                R_BORROWEDDATE.setText((String) borrowStudentTableModel.getValueAt(selectedRow, 7)); // Borrowed Date
            }
        });

        R_STUDENTNAME.setText(fullName);
        R_STUDENTNUM.setText(studentNo);

        // Make the fields non-editable
        R_BOOKTITLE.setEditable(false);
        R_ISBN.setEditable(false);
        R_STUDENTNAME.setEditable(false);
        R_STUDENTNUM.setEditable(false);
        R_RETURNDATE.setEditable(false);
        R_BORROWEDDATE.setEditable(false);

        String [] columm5  = {"Book Name", "Due"};
        borrowedStudentTableModel = new DefaultTableModel(columm5, 0);
        borrowTable.setModel(borrowedStudentTableModel);

        LoadPendingBorrowList();

    }

    private void LoadPendingBorrowList() {

        // Load the pending borrow list from the database
        pendingBorrowList = BookDatabase.getInstance().getBorrowBookWithDueStatus(userid);
        borrowedStudentTableModel.setRowCount(0); // Clear existing rows

        for (PendingBorrowModel borrow : pendingBorrowList) {
            String bookName = borrow.getBookTitle();
            String dueStatus = borrow.getDueStatus();

            borrowedStudentTableModel.addRow(new Object[]{bookName, dueStatus});
        }
    }


    void initializeDashboard(){
        // Initialize the dashboard with data from the database
        // For example, you can set the number of available books
        availableBooks = DisplayCountedDashboard.getInstance().getNumberOfBooks();

        STU_NUMBER_AVAIL_BOOK.setText(String.valueOf(availableBooks));


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
        STU_NOTIF = new javax.swing.JLabel();
        STU_SETTINGS = new javax.swing.JLabel();
        jP_STU_DASHBOARD = new javax.swing.JPanel();
        STU_NUMBER_AVAIL_BOOK = new javax.swing.JLabel();
        STU_BOOKSHELF = new javax.swing.JLabel();
        STU_DATETIME = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        borrowTable = new javax.swing.JTable();
        STU_PENDINGS = new javax.swing.JLabel();
        STU_BOOKS = new javax.swing.JLabel();
        STU_DASHBOARD_LAYOUT = new javax.swing.JLabel();
        jP_STU_LIBRARY = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        STU_BORROW_TABLE = new javax.swing.JTable();
        B_BOOKTITLE = new javax.swing.JTextField();
        B_ISBN = new javax.swing.JTextField();
        B_STUDENTNAME = new javax.swing.JTextField();
        B_STUDENTNUM = new javax.swing.JTextField();
        B_BORROWED_DATE = new javax.swing.JTextField();
        B_RETURNDATE = new javax.swing.JTextField();
        B_BORROW = new javax.swing.JButton();
        STU_LIBRARY_LAYOUT = new javax.swing.JLabel();
        jP_STU_YOURSHELF = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        STU_RETURN_TABLE = new javax.swing.JTable();
        R_BOOKTITLE = new javax.swing.JTextField();
        R_ISBN = new javax.swing.JTextField();
        R_STUDENTNAME = new javax.swing.JTextField();
        R_STUDENTNUM = new javax.swing.JTextField();
        R_BORROWEDDATE = new javax.swing.JTextField();
        R_RETURNDATE = new javax.swing.JTextField();
        R_RETURN = new javax.swing.JButton();
        STU_YOURSHELF_LAYOUT = new javax.swing.JLabel();
        jP_STU_ACCOUNT = new javax.swing.JPanel();
        STU_EDIT_BUTTON = new javax.swing.JLabel();
        STU_ACCOUNT_LAYOUT = new javax.swing.JLabel();
        STU_DASHBOARD = new javax.swing.JLabel();
        STU_LIBRARY = new javax.swing.JLabel();
        STU_YOURSHELF = new javax.swing.JLabel();
        STU_ACCOUNT = new javax.swing.JLabel();
        STU_LOG_OUT = new javax.swing.JLabel();
        STU_DIVIDER = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student | One More Page");
        setLocation(new java.awt.Point(300, 150));
        setMinimumSize(new java.awt.Dimension(1190, 675));
        setResizable(false);
        setSize(new java.awt.Dimension(1190, 675));

        jPanel1.setBackground(new java.awt.Color(255, 254, 252));
        jPanel1.setMaximumSize(new java.awt.Dimension(1190, 675));
        jPanel1.setMinimumSize(new java.awt.Dimension(1190, 675));
        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 675));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        STU_NOTIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADMIN_NOTIF.png"))); // NOI18N
        jPanel1.add(STU_NOTIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1067, 26, -1, -1));

        STU_SETTINGS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADM/ADMIN_SETTING.png"))); // NOI18N
        jPanel1.add(STU_SETTINGS, new org.netbeans.lib.awtextra.AbsoluteConstraints(1122, 26, -1, -1));

        jP_STU_DASHBOARD.setBackground(new java.awt.Color(255, 254, 252));
        jP_STU_DASHBOARD.setOpaque(false);
        jP_STU_DASHBOARD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        STU_NUMBER_AVAIL_BOOK.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        STU_NUMBER_AVAIL_BOOK.setText("0");
        jP_STU_DASHBOARD.add(STU_NUMBER_AVAIL_BOOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, -1, -1));

        STU_BOOKSHELF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_BOOKSHELF.png"))); // NOI18N
        jP_STU_DASHBOARD.add(STU_BOOKSHELF, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 158, -1, -1));

        STU_DATETIME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_DATE_TIME.png"))); // NOI18N
        jP_STU_DASHBOARD.add(STU_DATETIME, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 426, -1, -1));

        borrowTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(borrowTable);

        jP_STU_DASHBOARD.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 310, 150));

        STU_PENDINGS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_BORROWED.png"))); // NOI18N
        jP_STU_DASHBOARD.add(STU_PENDINGS, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 157, -1, -1));

        STU_BOOKS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_BOOKS.png"))); // NOI18N
        jP_STU_DASHBOARD.add(STU_BOOKS, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 419, -1, -1));

        STU_DASHBOARD_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_DASHBOARD_LAYOUT.png"))); // NOI18N
        jP_STU_DASHBOARD.add(STU_DASHBOARD_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jP_STU_DASHBOARD, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 0, 979, 675));

        jP_STU_LIBRARY.setBackground(new java.awt.Color(255, 254, 252));
        jP_STU_LIBRARY.setOpaque(false);
        jP_STU_LIBRARY.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane.setBackground(new java.awt.Color(255, 254, 252));
        jScrollPane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jScrollPane.setFocusable(false);

        STU_BORROW_TABLE.setBackground(new java.awt.Color(255, 254, 252));
        STU_BORROW_TABLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(202, 231, 255)));
        STU_BORROW_TABLE.setModel(new javax.swing.table.DefaultTableModel(
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
        STU_BORROW_TABLE.setFocusable(false);
        STU_BORROW_TABLE.setGridColor(new java.awt.Color(99, 151, 57));
        STU_BORROW_TABLE.setRequestFocusEnabled(false);
        STU_BORROW_TABLE.setSelectionBackground(new java.awt.Color(99, 151, 57));
        STU_BORROW_TABLE.setSelectionForeground(new java.awt.Color(199, 229, 176));
        jScrollPane.setViewportView(STU_BORROW_TABLE);

        jP_STU_LIBRARY.add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 111, 880, 160));

        B_BOOKTITLE.setBackground(new java.awt.Color(248, 243, 232));
        B_BOOKTITLE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        B_BOOKTITLE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        B_BOOKTITLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_LIBRARY.add(B_BOOKTITLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 386, 245, 30));

        B_ISBN.setBackground(new java.awt.Color(248, 243, 232));
        B_ISBN.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        B_ISBN.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        B_ISBN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_LIBRARY.add(B_ISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 455, 245, 30));

        B_STUDENTNAME.setBackground(new java.awt.Color(248, 243, 232));
        B_STUDENTNAME.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        B_STUDENTNAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        B_STUDENTNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_LIBRARY.add(B_STUDENTNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 386, 245, 30));

        B_STUDENTNUM.setBackground(new java.awt.Color(248, 243, 232));
        B_STUDENTNUM.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        B_STUDENTNUM.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        B_STUDENTNUM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_LIBRARY.add(B_STUDENTNUM, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 455, 245, 30));

        B_BORROWED_DATE.setBackground(new java.awt.Color(248, 243, 232));
        B_BORROWED_DATE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        B_BORROWED_DATE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        B_BORROWED_DATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_LIBRARY.add(B_BORROWED_DATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 386, 245, 30));

        B_RETURNDATE.setBackground(new java.awt.Color(248, 243, 232));
        B_RETURNDATE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        B_RETURNDATE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        B_RETURNDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_LIBRARY.add(B_RETURNDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 452, 245, 30));

        B_BORROW.setBackground(new java.awt.Color(199, 229, 176));
        B_BORROW.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        B_BORROW.setForeground(new java.awt.Color(99, 151, 57));
        B_BORROW.setText("BORROW");
        B_BORROW.setBorder(null);
        B_BORROW.setFocusPainted(false);
        B_BORROW.setFocusable(false);
        B_BORROW.setRequestFocusEnabled(false);
        B_BORROW.setRolloverEnabled(false);
        B_BORROW.setVerifyInputWhenFocusTarget(false);
        B_BORROW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_BORROWActionPerformed(evt);
            }
        });
        jP_STU_LIBRARY.add(B_BORROW, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 525, 130, 30));

        STU_LIBRARY_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_LIBRARY_FRAME.png"))); // NOI18N
        jP_STU_LIBRARY.add(STU_LIBRARY_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jP_STU_LIBRARY, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 0, 979, 675));

        jP_STU_YOURSHELF.setBackground(new java.awt.Color(255, 254, 252));
        jP_STU_YOURSHELF.setOpaque(false);
        jP_STU_YOURSHELF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 254, 252));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jScrollPane1.setFocusable(false);

        STU_RETURN_TABLE.setBackground(new java.awt.Color(255, 254, 252));
        STU_RETURN_TABLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(202, 231, 255)));
        STU_RETURN_TABLE.setModel(new javax.swing.table.DefaultTableModel(
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
        STU_RETURN_TABLE.setFocusable(false);
        STU_RETURN_TABLE.setGridColor(new java.awt.Color(99, 151, 57));
        STU_RETURN_TABLE.setRequestFocusEnabled(false);
        STU_RETURN_TABLE.setSelectionBackground(new java.awt.Color(99, 151, 57));
        STU_RETURN_TABLE.setSelectionForeground(new java.awt.Color(199, 229, 176));
        jScrollPane1.setViewportView(STU_RETURN_TABLE);

        jP_STU_YOURSHELF.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 111, 880, 160));

        R_BOOKTITLE.setBackground(new java.awt.Color(248, 243, 232));
        R_BOOKTITLE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        R_BOOKTITLE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        R_BOOKTITLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_YOURSHELF.add(R_BOOKTITLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 386, 245, 30));

        R_ISBN.setBackground(new java.awt.Color(248, 243, 232));
        R_ISBN.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        R_ISBN.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        R_ISBN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_YOURSHELF.add(R_ISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 455, 245, 30));

        R_STUDENTNAME.setBackground(new java.awt.Color(248, 243, 232));
        R_STUDENTNAME.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        R_STUDENTNAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        R_STUDENTNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_YOURSHELF.add(R_STUDENTNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 386, 245, 30));

        R_STUDENTNUM.setBackground(new java.awt.Color(248, 243, 232));
        R_STUDENTNUM.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        R_STUDENTNUM.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        R_STUDENTNUM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_YOURSHELF.add(R_STUDENTNUM, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 455, 245, 30));

        R_BORROWEDDATE.setBackground(new java.awt.Color(248, 243, 232));
        R_BORROWEDDATE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        R_BORROWEDDATE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        R_BORROWEDDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_YOURSHELF.add(R_BORROWEDDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 386, 245, 30));

        R_RETURNDATE.setBackground(new java.awt.Color(248, 243, 232));
        R_RETURNDATE.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        R_RETURNDATE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        R_RETURNDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 151, 57)));
        jP_STU_YOURSHELF.add(R_RETURNDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 452, 245, 30));

        R_RETURN.setBackground(new java.awt.Color(199, 229, 176));
        R_RETURN.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        R_RETURN.setForeground(new java.awt.Color(99, 151, 57));
        R_RETURN.setText("RETURN");
        R_RETURN.setBorder(null);
        R_RETURN.setFocusPainted(false);
        R_RETURN.setFocusable(false);
        R_RETURN.setRequestFocusEnabled(false);
        R_RETURN.setRolloverEnabled(false);
        R_RETURN.setVerifyInputWhenFocusTarget(false);
        R_RETURN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R_RETURNActionPerformed(evt);
            }
        });
        jP_STU_YOURSHELF.add(R_RETURN, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 525, 130, 30));

        STU_YOURSHELF_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_YOU_SHELF_FRAME.png"))); // NOI18N
        jP_STU_YOURSHELF.add(STU_YOURSHELF_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jP_STU_YOURSHELF, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 0, 979, 675));

        jP_STU_ACCOUNT.setBackground(new java.awt.Color(255, 254, 252));
        jP_STU_ACCOUNT.setOpaque(false);
        jP_STU_ACCOUNT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        STU_EDIT_BUTTON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_EDIT_BUTTON.png"))); // NOI18N
        jP_STU_ACCOUNT.add(STU_EDIT_BUTTON, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 441, -1, -1));

        STU_ACCOUNT_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_ACCOUNT_FRAME.png"))); // NOI18N
        jP_STU_ACCOUNT.add(STU_ACCOUNT_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jP_STU_ACCOUNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 0, 979, 675));

        STU_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_DASHBOARD_ACTIVE.png"))); // NOI18N
        STU_DASHBOARD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STU_DASHBOARDMouseClicked(evt);
            }
        });
        jPanel1.add(STU_DASHBOARD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 104, -1, -1));

        STU_LIBRARY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_LIBRARY.png"))); // NOI18N
        STU_LIBRARY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STU_LIBRARYMouseClicked(evt);
            }
        });
        jPanel1.add(STU_LIBRARY, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        STU_YOURSHELF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_SHELF.png"))); // NOI18N
        STU_YOURSHELF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STU_YOURSHELFMouseClicked(evt);
            }
        });
        jPanel1.add(STU_YOURSHELF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 236, -1, -1));

        STU_ACCOUNT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_ACCOUNT.png"))); // NOI18N
        STU_ACCOUNT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STU_ACCOUNTMouseClicked(evt);
            }
        });
        jPanel1.add(STU_ACCOUNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 302, -1, -1));

        STU_LOG_OUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_LOGOUT.png"))); // NOI18N
        STU_LOG_OUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STU_LOG_OUTMouseClicked(evt);
            }
        });
        jPanel1.add(STU_LOG_OUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 623, -1, -1));

        STU_DIVIDER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/STU/STU_DIVIDER.png"))); // NOI18N
        jPanel1.add(STU_DIVIDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void STU_LOG_OUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STU_LOG_OUTMouseClicked
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
    }//GEN-LAST:event_STU_LOG_OUTMouseClicked

    private void STU_DASHBOARDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STU_DASHBOARDMouseClicked
        jP_STU_DASHBOARD.setVisible(true);
        jP_STU_LIBRARY.setVisible(false);
        jP_STU_YOURSHELF.setVisible(false);
        jP_STU_ACCOUNT.setVisible(false);
        
        STU_DASHBOARD.setIcon(new ImageIcon(getClass().getResource("/STU/STU_DASHBOARD_ACTIVE.png")));
        STU_LIBRARY.setIcon(new ImageIcon(getClass().getResource("/STU/STU_LIBRARY.png")));
        STU_YOURSHELF.setIcon(new ImageIcon(getClass().getResource("/STU/STU_SHELF.png")));
        STU_ACCOUNT.setIcon(new ImageIcon(getClass().getResource("/STU/STU_ACCOUNT.png")));
    }//GEN-LAST:event_STU_DASHBOARDMouseClicked

    private void STU_LIBRARYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STU_LIBRARYMouseClicked
        jP_STU_DASHBOARD.setVisible(false);
        jP_STU_LIBRARY.setVisible(true);
        jP_STU_YOURSHELF.setVisible(false);
        jP_STU_ACCOUNT.setVisible(false);
        
        STU_DASHBOARD.setIcon(new ImageIcon(getClass().getResource("/STU/STU_DASHBOARD.png")));
        STU_LIBRARY.setIcon(new ImageIcon(getClass().getResource("/STU/STU_LIBRARY_ACTIVE.png")));
        STU_YOURSHELF.setIcon(new ImageIcon(getClass().getResource("/STU/STU_SHELF.png")));
        STU_ACCOUNT.setIcon(new ImageIcon(getClass().getResource("/STU/STU_ACCOUNT.png")));
    }//GEN-LAST:event_STU_LIBRARYMouseClicked

    private void STU_YOURSHELFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STU_YOURSHELFMouseClicked
        jP_STU_DASHBOARD.setVisible(false);
        jP_STU_LIBRARY.setVisible(false);
        jP_STU_YOURSHELF.setVisible(true);
        jP_STU_ACCOUNT.setVisible(false);
        
        STU_DASHBOARD.setIcon(new ImageIcon(getClass().getResource("/STU/STU_DASHBOARD.png")));
        STU_LIBRARY.setIcon(new ImageIcon(getClass().getResource("/STU/STU_LIBRARY.png")));
        STU_YOURSHELF.setIcon(new ImageIcon(getClass().getResource("/STU/STU_SHELF_ACTIVE.png")));
        STU_ACCOUNT.setIcon(new ImageIcon(getClass().getResource("/STU/STU_ACCOUNT.png")));
    }//GEN-LAST:event_STU_YOURSHELFMouseClicked

    private void STU_ACCOUNTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STU_ACCOUNTMouseClicked
        jP_STU_DASHBOARD.setVisible(false);
        jP_STU_LIBRARY.setVisible(false);
        jP_STU_YOURSHELF.setVisible(false);
        jP_STU_ACCOUNT.setVisible(true);
        
        STU_DASHBOARD.setIcon(new ImageIcon(getClass().getResource("/STU/STU_DASHBOARD.png")));
        STU_LIBRARY.setIcon(new ImageIcon(getClass().getResource("/STU/STU_LIBRARY.png")));
        STU_YOURSHELF.setIcon(new ImageIcon(getClass().getResource("/STU/STU_SHELF.png")));
        STU_ACCOUNT.setIcon(new ImageIcon(getClass().getResource("/STU/STU_ACCOUNT_ACTIVE.png")));
    }//GEN-LAST:event_STU_ACCOUNTMouseClicked

    // This will borrow the books
    private void B_BORROWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_BORROWActionPerformed
        // TODO add your handling code here:
        int selectedRow = STU_BORROW_TABLE.getSelectedRow();

        if (selectedRow != -1) {
            String bookTitle = (String) libraryStudentTableModel.getValueAt(selectedRow, 1);
            String isbn = (String) libraryStudentTableModel.getValueAt(selectedRow, 4);
            String studentName = B_STUDENTNAME.getText();
            String studentNum = B_STUDENTNUM.getText();
            String borrowedDate = B_BORROWED_DATE.getText();
            String returnDate = B_RETURNDATE.getText();

            // Validate date format
            if (!isValidDate(borrowedDate) || !isValidDate(returnDate)) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please use MM/dd/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Call the method to borrow the book
            BookDatabase.getInstance().borrowBook(userid,bookTitle, isbn, studentName, studentNum, borrowedDate, returnDate);
            LoadBookList();
            LoadBorrowedBookList();
            LoadPendingBorrowList();
            initializeDashboard();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book to borrow.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_B_BORROWActionPerformed

    private void R_RETURNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R_RETURNActionPerformed
        int selectedRow = STU_RETURN_TABLE.getSelectedRow();

        if (selectedRow != -1) {
            String borrowID = (String) borrowStudentTableModel.getValueAt(selectedRow, 0); // Assuming borrow ID is in column 0
            String bookTitle = (String) borrowStudentTableModel.getValueAt(selectedRow, 2);
            String isbn = (String) borrowStudentTableModel.getValueAt(selectedRow, 3);
            String studentName = R_STUDENTNAME.getText();
            String studentNum = R_STUDENTNUM.getText();
            String borrowedDate = R_BORROWEDDATE.getText();
            String returnDate = R_RETURNDATE.getText();

            // Validate date format
            if (!isValidDate(borrowedDate) || !isValidDate(returnDate)) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please use MM/dd/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (Connection connection = LibrarySQL.getConnection()) {
                connection.setAutoCommit(false); // Start transaction

                // Add to issue_books table
                String issueID = String.valueOf(System.currentTimeMillis()); // Generate a unique ID
                String insertIssueQuery = "INSERT INTO issue_books (issue_id, issue_date, return_date, name, isbn, phone_number, email_address, status) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement insertIssueStatement = connection.prepareStatement(insertIssueQuery)) {
                    insertIssueStatement.setString(1, issueID);
                    insertIssueStatement.setString(2, borrowedDate);
                    insertIssueStatement.setString(3, returnDate);
                    insertIssueStatement.setString(4, studentName);
                    insertIssueStatement.setString(5, isbn);
                    insertIssueStatement.setString(6, ""); // Add phone number if available
                    insertIssueStatement.setString(7, ""); // Add email address if available
                    insertIssueStatement.setString(8, "RETURNED");
                    insertIssueStatement.executeUpdate();
                }

                // Update the book status to "Available"
                String updateBookStatusQuery = "UPDATE books SET status = 'Available' WHERE isbn = ?";
                try (PreparedStatement updateBookStatusStatement = connection.prepareStatement(updateBookStatusQuery)) {
                    updateBookStatusStatement.setString(1, isbn);
                    updateBookStatusStatement.executeUpdate();
                }

                // Delete the record from borrow_books
                String deleteBorrowQuery = "DELETE FROM borrow_books WHERE borrow_id = ?";
                try (PreparedStatement deleteBorrowStatement = connection.prepareStatement(deleteBorrowQuery)) {
                    deleteBorrowStatement.setString(1, borrowID);
                    deleteBorrowStatement.executeUpdate();
                }

                connection.commit(); // Commit transaction
                JOptionPane.showMessageDialog(this, "Book returned successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Reload the borrowed book list
            LoadBorrowedBookList();
            LoadBookList(); // Reload the available books list
            LoadPendingBorrowList();
            initializeDashboard();
            JOptionPane.showMessageDialog(this, "Please select a book to return.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_R_RETURNActionPerformed
    void LoadBookList() {
        libraryStudentTableModel.setRowCount(0); // Clear existing rows
        bookList = BookDatabase.getInstance().getBooksAvailable();

        if (bookList != null) {
            for (BookModel book : bookList) {
                libraryStudentTableModel.addRow(new Object[]{
                        book.getBook_id(),
                        book.getBook_title(),
                        book.getBook_author(),
                        book.getBook_genre(),
                        book.getIsbn(),
                        book.getStatus(),
                });
            }
        } else {
            System.out.println("No books found.");
        }
    }


    // Helper method to validate date format
    private boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date); // Try parsing the date
            return true;
        } catch (Exception e) {
            return false; // Invalid date format
        }
    }


    void LoadBorrowedBookList() {
        borrowStudentTableModel.setRowCount(0); // Clear existing rows
        borrowedBookList = BookDatabase.getInstance().getBorrowedBooks(userid);

        if (borrowedBookList != null) {
            for (BorrowBookModel book : borrowedBookList) {
                borrowStudentTableModel.addRow(new Object[]{
                        book.getId(),
                        book.getUserid(),
                        book.getBookTitle(),
                        book.getIsbn(),
                        book.getStudentName(),
                        book.getStudentNum(),
                        book.getBorrowedDate(),
                        book.getReturnDate(),
                });
            }
        } else {
            System.out.println("No borrowed books found.");
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
            java.util.logging.Logger.getLogger(STUDENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(STUDENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(STUDENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(STUDENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new STUDENT(userid, fullName, studentNo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField B_BOOKTITLE;
    private javax.swing.JButton B_BORROW;
    private javax.swing.JTextField B_BORROWED_DATE;
    private javax.swing.JTextField B_ISBN;
    private javax.swing.JTextField B_RETURNDATE;
    private javax.swing.JTextField B_STUDENTNAME;
    private javax.swing.JTextField B_STUDENTNUM;
    private javax.swing.JTextField R_BOOKTITLE;
    private javax.swing.JTextField R_BORROWEDDATE;
    private javax.swing.JTextField R_ISBN;
    private javax.swing.JButton R_RETURN;
    private javax.swing.JTextField R_RETURNDATE;
    private javax.swing.JTextField R_STUDENTNAME;
    private javax.swing.JTextField R_STUDENTNUM;
    private javax.swing.JLabel STU_ACCOUNT;
    private javax.swing.JLabel STU_ACCOUNT_LAYOUT;
    private javax.swing.JLabel STU_BOOKS;
    private javax.swing.JLabel STU_BOOKSHELF;
    private javax.swing.JTable STU_BORROW_TABLE;
    private javax.swing.JLabel STU_DASHBOARD;
    private javax.swing.JLabel STU_DASHBOARD_LAYOUT;
    private javax.swing.JLabel STU_DATETIME;
    private javax.swing.JLabel STU_DIVIDER;
    private javax.swing.JLabel STU_EDIT_BUTTON;
    private javax.swing.JLabel STU_LIBRARY;
    private javax.swing.JLabel STU_LIBRARY_LAYOUT;
    private javax.swing.JLabel STU_LOG_OUT;
    private javax.swing.JLabel STU_NOTIF;
    private javax.swing.JLabel STU_NUMBER_AVAIL_BOOK;
    private javax.swing.JLabel STU_PENDINGS;
    private javax.swing.JTable STU_RETURN_TABLE;
    private javax.swing.JLabel STU_SETTINGS;
    private javax.swing.JLabel STU_YOURSHELF;
    private javax.swing.JLabel STU_YOURSHELF_LAYOUT;
    private javax.swing.JTable borrowTable;
    private javax.swing.JPanel jP_STU_ACCOUNT;
    private javax.swing.JPanel jP_STU_DASHBOARD;
    private javax.swing.JPanel jP_STU_LIBRARY;
    private javax.swing.JPanel jP_STU_YOURSHELF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
