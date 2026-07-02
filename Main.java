import dao.BookDAO;
import dao.TransactionDAO;

public class Main {

    public static void main(String[] args) {

        BookDAO b = new BookDAO();
        b.addBook("Java", "James Gosling");
        b.viewBooks();

        TransactionDAO t = new TransactionDAO();
        t.borrowBook(1, 1);
        t.returnBook(1);
    }
}