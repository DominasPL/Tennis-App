<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/17/19
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserDetails</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<form:form modelAttribute="user" method="post">
    <form:errors path="*"/> <br>
    <form:hidden path="username"/> <br>
    FirstName: <form:input path="firstName"/> <br>
    LastName: <form:input path="lastName"/> <br>
    PhoneNumber: <form:input path="phoneNumber"/> <br>
    <%--Image: <form:input path="userDetails.image"/> <br>--%>
    <a class="btn btn-danger" href="#" role="button">Dezaktywacja konta</a> <br><br>

    <input class="btn btn-outline-warning" type="submit" value="Zatwierdź"/>
</form:form>


</body>
</html>
