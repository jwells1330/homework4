<%--Copyright © 2016 Sarah Allen and Jacob Wells--%>

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
    
    <c:forEach var="item" items="${booksArray}">
    <tr>
      <td>${item.firstName} ${item.lastName}</td>
      <td>${item.email}</td>
      <td>${item.title}</td>
      <td>${item.dueDate}</td>
      <td>${item.overdue}</td>
      <td>
        <form action="checkIn" method="post">
        <input type="hidden" name="email" 
               value=${item.email}>
        <input type="hidden" name="title" 
               value=${item.title}>
        <input type="submit" value="Checkin">
      </form>
      </td>
    </tr>
    </c:forEach>
  </table>
  <br>
  <p id="return"><a href="library?action=join">Return to front page</a></p>
</nav>
<c:import url="/includes/footer.jsp"/>
</body>