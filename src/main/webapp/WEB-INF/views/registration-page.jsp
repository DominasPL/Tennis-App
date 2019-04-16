<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/15/19
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<html>
<head>
    <title>Registration</title>
</head>
<body>

    <form:form modelAttribute="registrationForm" method="post">
        <form:errors path="*"/> <br>
        Nazwa uzytkownika: <form:input path="username"/> <br>
        Imie: <form:input path="firstName"/> <br>
        Nazwisko: <form:input path="lastName"/> <br>
        Hasło: <form:input path="password"/> <br>
        Potwierdz hasło: <form:input path="confirmedPassword"/> <br>
        <input class="btn btn-outline-warning" type="submit" value="Zatwierdź"/>
    </form:form>

</body>
</html>
