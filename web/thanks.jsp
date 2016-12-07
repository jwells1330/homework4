<%-- 
    Document   : thanks
    Created on : Dec 3, 2016, 2:17:22 PM
    Author     : Jacob_Wells
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.html"/>

<nav>Thank you for your patronage of the Belk Library.  You've successfully
    checked out the book, ${title}.  Please note that this book is due 
    back on ${due}.  A friendly email reminder will be sent to you if
    your book becomes overdue.

    <a href="library?action=join">Return to front page</a>
</nav>

    <c:import url="/includes/footer.jsp"/>
  </body>
