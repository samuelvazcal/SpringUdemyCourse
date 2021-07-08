<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 07/07/2021
  Time: 05:20 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
    <!--<style>
        .error {color:red}
    </style>-->
    <title>Customer Registration Form</title>
</head>
<body>
<i>Fill out the for. Asterisk (*) means required.</i>
    <br><br>
    <form:form action="processForm" modelAttribute="customer">
        First Name: <form:input path="firstName" />
        <br><br>
        Last Name (*): <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error" />
        <br><br>
        Free passes: <form:input path="freePasses" />
        <form:errors path="freePasses" cssClass="error" />
        <br><br>
        Postal code: <form:input path="postalCode" />
        <form:errors path="postalCode" cssClass="error" />
        <br><br>
        Course code: <form:input path="courseCode" />
        <form:errors path="courseCode" cssClass="error" />
        <br><br>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>
