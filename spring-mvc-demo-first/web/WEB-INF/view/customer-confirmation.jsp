<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 07/07/2021
  Time: 05:53 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Customer Confirmation Page</title>
</head>
<body>
The customer: <b>${customer.firstName} ${customer.lastName}</b> is confirmed.
<br>
Free passes: ${customer.freePasses}
<br>
Postal code: ${customer.postalCode}
<br>
Course code: ${customer.courseCode}
</body>
</html>
