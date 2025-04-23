--
-- File generated with SQLiteStudio v3.4.17 on Tue Apr 22 20:57:34 2025
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: admin
CREATE TABLE IF NOT EXISTS admin (user_id INTEGER PRIMARY KEY NOT NULL, admin_id CHAR NOT NULL, password CHAR NOT NULL, full_name CHAR NOT NULL, key_pass INTEGER NOT NULL, education_attainment CHAR NOT NULL, phone_number CHAR NOT NULL, email_address CHAR NOT NULL, home_address CHAR NOT NULL, admin_number INTEGER NOT NULL);
INSERT INTO admin (user_id, admin_id, password, full_name, key_pass, education_attainment, phone_number, email_address, home_address, admin_number) VALUES (1, 'G3-2025', 'admin', 'Reed, Richards', 12345, 'test', '09123456789', 'richard@gmail.com', '28th Floor, Baxter Building', 12345);

-- Table: books
CREATE TABLE IF NOT EXISTS books (book_id INTEGER NOT NULL PRIMARY KEY, book_title CHAR NOT NULL, book_author CHAR NOT NULL, book_genre CHAR NOT NULL, date_publish CHAR NOT NULL, isbn INTEGER NOT NULL, status CHAR NOT NULL);
INSERT INTO books (book_id, book_title, book_author, book_genre, date_publish, isbn, status) VALUES (1, 'Life of RIzal', 'Rizal', 'History', '04/21/25', 434345454, 'Not Available');
INSERT INTO books (book_id, book_title, book_author, book_genre, date_publish, isbn, status) VALUES (2, 'Environmental Science', 'Science Mastor', 'Science', '03/29/1989', 53432434, 'Available');

-- Table: borrow_books
CREATE TABLE IF NOT EXISTS borrow_books (borrow_id INTEGER NOT NULL PRIMARY KEY, user_id INTEGER NOT NULL, book_title CHAR NOT NULL, isbn INTEGER NOT NULL, student_name CHAR NOT NULL, student_number CHAR NOT NULL, borrow_date CHAR NOT NULL, return_date CHAR NOT NULL);
INSERT INTO borrow_books (borrow_id, user_id, book_title, isbn, student_name, student_number, borrow_date, return_date) VALUES (1, 1, 'Life of RIzal', 434345454, 'Grim, Benjamin Jacob', '3434-3434-43243', '04/22/2025', '04/24/2025');

-- Table: issue_books
CREATE TABLE IF NOT EXISTS issue_books (book_id INTEGER NOT NULL PRIMARY KEY, issue_id CHAR NOT NULL, issue_date CHAR NOT NULL, return_date CHAR NOT NULL, name CHAR NOT NULL, isbn INTEGER NOT NULL, phone_number CHAR NOT NULL, email_address CHAR NOT NULL, status CHAR NOT NULL);
INSERT INTO issue_books (book_id, issue_id, issue_date, return_date, name, isbn, phone_number, email_address, status) VALUES (1, '54545', '04/21/25', '04/21/25', 'Wen', 33434, '094334353', 'wen@gmail.com', 'OVERDUE');
INSERT INTO issue_books (book_id, issue_id, issue_date, return_date, name, isbn, phone_number, email_address, status) VALUES (2, '43545', '04/21/25', '04/21/25', 'Wen', 5344545, '094234324', 'N/A', 'RETURNED');
INSERT INTO issue_books (book_id, issue_id, issue_date, return_date, name, isbn, phone_number, email_address, status) VALUES (3, '1745307903162', '04/24/25', '04/22/25', 'Grim, Benjamin Jacob', 53432434, '', '', 'RETURNED');

-- Table: librarian
CREATE TABLE IF NOT EXISTS librarian (user_id INTEGER PRIMARY KEY NOT NULL, librarian_id CHAR NOT NULL, password CHAR NOT NULL, full_name CHAR NOT NULL, birthdate CHAR NOT NULL, home_address CHAR NOT NULL, gwa REAL NOT NULL, email_address CHAR NOT NULL, phone_number CHAR);
INSERT INTO librarian (user_id, librarian_id, password, full_name, birthdate, home_address, gwa, email_address, phone_number) VALUES (1, 'L-616', 'librarian', 'Storim, Susan', '4/21/1993', '28th Floor, Baxter Building', 89.0, '@susamsuestorm', '093434323');

-- Table: student
CREATE TABLE IF NOT EXISTS student (user_id INTEGER PRIMARY KEY NOT NULL, username CHAR NOT NULL, password CHAR NOT NULL, full_name CHAR NOT NULL, year_and_section CHAR NOT NULL, home_address CHAR NOT NULL, email_address CHAR NOT NULL, student_number CHAR NOT NULL, phone_number CHAR NOT NULL, "");
INSERT INTO student (user_id, username, password, full_name, year_and_section, home_address, email_address, student_number, phone_number, "") VALUES (1, 'bengrimm4', 'student', 'Grim, Benjamin Jacob', '4th Year MMA', '25th Floor, Baxter Building', 'grim@gmail.com', '3434-3434-43243', '09123456789', NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
