<%-- 
    Document   : index
    Created on : Dec 2, 2016, 12:28:16 PM
    Author     : jwells8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.html"/>
    <nav>
      <a href="library?action=checkOut">Check out a book</a>
      <br>
      <a href="library?action=manage">Manage checked out books</a>
    </nav>


    <c:import url="/includes/footer.jsp"/>
  </body>
