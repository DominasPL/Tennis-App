<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/16/19
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zaloguj się</title>
</head>
<body>

<form method="post" action="/login">

    <c:if test="${param.error!=null}">
        <span>Nieprawidłowe dane logowania!</span> <br>
    </c:if>
    <c:if test="${param.logout != null}">
        <span>Zostałeś wylogowany!</span> <br>
    </c:if>
    Nazwa użytkownika:
    <input type="text" name="username" required min="3" max="20"/> <br/>
    Hasło:
    <input type="password" name="password" required min="3" max="20"/> <br/>
    <input type="checkbox" name="remember-me"/> <br/>
    <input type="submit" value="Zaloguj">
</form>

</body>
</html>
