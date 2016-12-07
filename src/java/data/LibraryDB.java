/*Copyright © 2016 Sarah Allen and Jacob Wells*/
package data;

import java.sql.*;

public class LibraryDB {

    public static boolean checkOut(String firstName, String lastName, String email, String title) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO checkedoutbooks (FirstName, LastName, Email, BookTitle) "
                + "VALUES (?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, title);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
