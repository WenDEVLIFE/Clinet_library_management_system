package database;

import java.awt.print.Book;

public class BookDatabase {

    private static volatile BookDatabase instance;

    public static BookDatabase getInstance() {
        if (instance == null) {
            synchronized (BookDatabase.class) {
                if (instance == null) {
                    instance = new BookDatabase();
                }
            }
        }
        return instance;
    }


}
