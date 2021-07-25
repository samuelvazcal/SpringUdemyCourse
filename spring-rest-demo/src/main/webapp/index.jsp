<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 24/07/2021
  Time: 08:23 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring REST Demo</title>
</head>
<body>
<h3>Spring REST Demo</h3>
<hr>
<a href="${pageContext.request.contextPath}/test/hello">Hello</a>
<br><br>
<a href="${pageContext.request.contextPath}/api/students">Students</a>
</body>
</html>
