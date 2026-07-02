package util;

public class SQLQueries {

    public static final String ADD_BOOK =
            "INSERT INTO books(title,author,status) VALUES(?,?,?)";

    public static final String VIEW_BOOKS =
            "SELECT * FROM books";

    public static final String BORROW_BOOK =
            "UPDATE books SET status='Borrowed' WHERE book_id=?";

    public static final String RETURN_BOOK =
            "UPDATE books SET status='Available' WHERE book_id=?";

    public static final String INSERT_TRANSACTION =
            "INSERT INTO transactions(user_id,book_id,issue_date) VALUES(?,?,?)";

    public static final String UPDATE_RETURN_DATE =
            "UPDATE transactions SET return_date=? WHERE book_id=? AND return_date IS NULL";
}
