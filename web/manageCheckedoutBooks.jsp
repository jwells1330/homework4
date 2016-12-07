<%-- 
    Document   : manageCheckedoutBooks
    Created on : Dec 6, 2016, 8:21:54 PM
    Author     : SarahAllen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.html"/>
<nav>
  <h2>Currently checked out books</h2>
  <table>
    <tr>
      <th>Patron Name</th>
      <th>Email Address</th>
      <th>Book Title</th>
      <th>Due Date</th>
      <th>Overdue</th>
      <td> </td>
    </tr>
  </table>
  <br>
  <p id="return"><a href="library?action=join">Return to front page</a></p>
</nav>
<c:import url="/includes/footer.jsp"/>
</body>