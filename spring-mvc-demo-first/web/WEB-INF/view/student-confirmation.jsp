<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 06/07/2021
  Time: 07:49 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Confirmation Page</title>
</head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName}
<br><br>
Country: ${student.country}
Country: ${student.countryOptions.get(student.country)}
<br><br>
Favorite Language: ${student.favoriteLanguage}
<br><br>
Operating systems:
<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li>${temp}</li>
    </c:forEach>
</ul>
</body>
</html>
