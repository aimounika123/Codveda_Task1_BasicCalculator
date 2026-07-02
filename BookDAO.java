package dao;

import java.sql.*;
import util.DBConnection;
import util.SQLQueries;

public class BookDAO {

    public void addBook(String title, String author) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(SQLQueries.ADD_BOOK);

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, "Available");

            ps.executeUpdate();

            System.out.println("Book Added");

            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewBooks() {
        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery(SQLQueries.VIEW_BOOKS);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " "
                        + rs.getString("title") + " "
                        + rs.getString("author") + " "
                        + rs.getString("status"));
            }

            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}