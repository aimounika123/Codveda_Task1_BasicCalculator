package dao;

import java.sql.*;
import java.time.LocalDate;
import util.DBConnection;
import util.SQLQueries;

public class TransactionDAO {

    public void borrowBook(int userId, int bookId) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(SQLQueries.BORROW_BOOK);

            ps.setInt(1, bookId);
            ps.executeUpdate();

            PreparedStatement ps2 =
                    con.prepareStatement(
                            SQLQueries.INSERT_TRANSACTION);

            ps2.setInt(1, userId);
            ps2.setInt(2, bookId);
            ps2.setDate(3,
                    Date.valueOf(LocalDate.now()));

            ps2.executeUpdate();

            System.out.println("Book Borrowed");

            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int bookId) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(SQLQueries.RETURN_BOOK);

            ps.setInt(1, bookId);
            ps.executeUpdate();

            PreparedStatement ps2 =
                    con.prepareStatement(
                            SQLQueries.UPDATE_RETURN_DATE);

            ps2.setDate(1,
                    Date.valueOf(LocalDate.now()));
            ps2.setInt(2, bookId);

            ps2.executeUpdate();

            System.out.println("Book Returned");

            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
