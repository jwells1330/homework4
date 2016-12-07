<%--Copyright © 2016 Sarah Allen and Jacob Wells--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.html"/>

<nav>Thank you for your patronage of the Belk Library.  You've successfully
    checked out the book, (_______).  Please note that this book is due 
    back on (__________).  A friendly email reminder will be sent to you if
    your book becomes overdue.
    <br>
    <p id="return"><a href="library?action=join">Return to front page</a></p>
</nav>

    <c:import url="/includes/footer.jsp"/>
  </body>
