<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 06/07/2021
  Time: 07:39 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        First name: <form:input path="firstName" />
        <br><br>
        Last name: <form:input path="lastName" />
        <br><br>
        Country:
        <form:select path="country">
            <form:options items="${student.countryOptions}" />
            <!--<form:option value="Mexico" label="Mexico" />-->
        </form:select>
        <br><br>
        Favorite Language:
        Java <form:radiobutton path="favoriteLanguage" value="Java" />
        Javascript <form:radiobutton path="favoriteLanguage" value="Javascript" />
        Python <form:radiobutton path="favoriteLanguage" value="Python" />
        Other <form:radiobutton path="favoriteLanguage" value="Other" />
        <br><br>
        Operating Systems:
        Linux <form:checkbox path="operatingSystems" value="Linux" />
        Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
        MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />

        <br><br>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>
