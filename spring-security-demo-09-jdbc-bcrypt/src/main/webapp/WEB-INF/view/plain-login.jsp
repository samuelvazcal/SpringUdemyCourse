<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 21/07/2021
  Time: 04:03 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">-->
    <style>
        .failed {
            color: red;
        }
    </style>
    <title>Custom Login Page</title>
</head>
<body>
    <h3>My Custom Login Page</h3>
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
        <!-- Check for login error -->
        <c:if test="${param.error != null}">
            <i class="failed">Sorry! You entered invalid username/password.</i>
        </c:if>
        <p>
            User name: <input type="text" name="username" />
        </p>
        <p>
            Password: <input type="password" name="password" />
        </p>
        <input type="submit" value="Login" />
    </form:form>
</body>
</html>
