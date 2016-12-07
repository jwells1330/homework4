<%--Copyright © 2016 Sarah Allen and Jacob Wells--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.html"/>

<nav>
  <h2>Checkout a book</h2>
  <form action="library" method="post">
      <input type="hidden" name="action" value="checkedOut">
      <p><label for="firstName">First Name:</label>
          <input name="firstName" type="text" class="text" 
                 id="firstName" autofocus 
                 required 
                 title="Enter First Name"</label></p>
      <p><label for="lastName">Last Name:</label>
          <input name="lastName" type="text" class="text" 
                 id="lastName" required 
                 title="Enter last name"></p>
      <p><label for="email">Email Address:</label>
          <input name="email" type="email" class="text" id="email"
                 title="Enter a valid email address" required></p>
      <p><label for="bookTitle">Book Title:</label>
          <input name="bookTitle" type="text" class="text" id="bookTitle"
                 title="Enter a bookTitle" required></p>
      <p><input type="submit" value="Checkout" id="submit" /></p>
    </form>
  
</nav>


<c:import url="/includes/footer.jsp"/>
</body>
