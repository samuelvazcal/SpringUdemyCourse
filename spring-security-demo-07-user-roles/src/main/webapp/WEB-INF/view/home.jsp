<%--
  Created by IntelliJ IDEA.
  User: samueL
  Date: 20/07/2021
  Time: 06:37 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>CoatlJ Company Home Page</title>
</head>
<body>
    <h2>CoatlJ Company Home Page</h2>
    <hr>
    <p>
        Welcome to CoatlJ Company!
    </p>
    <hr>
    <!-- display user name and role -->
    <p>
        User: <security:authentication property="principal.username" />
        <br><br>
        Role(s): <security:authentication property="principal.authorities" />
    </p>
    <hr>
    <!-- add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">
        <input type="submit" value="Logout" />
    </form:form>
</body>
</html>
