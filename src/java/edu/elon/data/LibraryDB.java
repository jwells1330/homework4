/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.data;

/**
 *
 * @author Jacob_Wells
 */
import edu.elon.lib.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibraryDB {

    public static void checkOut(String firstName, String lastName, String email, String title, java.sql.Date dueDate) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO checkedoutbooks (FirstName, LastName, Email, BookTitle, DueDate) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, title);
            ps.setDate(5, dueDate);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Book> getCheckedOut() {
        ArrayList<Book> books = new ArrayList();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet rs = null;

        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM checkedoutbooks");
            rs.next();
            while (rs.next()) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String email = rs.getString("Email");
                String title = rs.getString("BookTitle");
                java.sql.Date dueDate = rs.getDate("DueDate");

                Book book = new Book(firstName, lastName, email, title, dueDate);
                books.add(book);
            }
            return books;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
        }
    }

    public static void checkIn(String title, String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query
                ="Select BookID FROM checkedoutbooks where Email = ? and BookTitle = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(2, title);
            ps.setString(1, email);
            ps.executeQuery();
            
            rs = ps.getResultSet();
            rs.next();
            int id = rs.getInt("BookId");
            
            query
                = "DELETE FROM checkedoutbooks WHERE BookId = ?";
            
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
