package edu.elon.lib;

/*Copyright © 2016 Sarah Allen and Jacob Wells*/

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.elon.data.LibraryDB;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author Jacob_Wells
 */
public class LibraryServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        String url = "/index.jsp";
        String action = request.getParameter("action");
        
        System.out.println("ACTION: " + action);

        if (action == null) {
            action = "join";
        }
        if (action.equals("join")) {
            url = "/index.jsp";
        }else if (action.equals("checkOut")){
            url = "/bookCheckout.jsp";
        }else if(action.equals("checkedOut")){
            url = "/thanks.jsp";
            
            String first = request.getParameter("firstName");
            String last = request.getParameter("lastName");
            String email = request.getParameter("email");
            String title = request.getParameter("bookTitle");
            
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.add(Calendar.WEEK_OF_YEAR, 2);
            Date due = calendar.getTime();
            java.sql.Date sqlDue = new java.sql.Date(due.getTime());
            
            LibraryDB.checkOut(first, last, email, title, sqlDue);
            
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            String simpleDate = sdf.format(due);
            
            request.setAttribute("title", title);
            request.setAttribute("due", simpleDate);
        }else if(action.equals("manage")){
            url = "/manageCheckedoutBooks.jsp";
            ArrayList<Book> books = LibraryDB.getCheckedOut();
                       System.out.println(books.size());
            request.setAttribute("booksArray", books);
        }else if(action.equals("checkIn")){
            
            LibraryDB.checkIn(request.getParameter("title").trim(), request.getParameter("email").trim());
            
            url = "/library?action=manage";
            
            
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
