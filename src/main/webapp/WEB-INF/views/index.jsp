<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/20/19
  Time: 7:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona Główna</title>
</head>
<body>

    <h1>Hello!</h1>
    <sec:authorize access="!isAuthenticated()">
        <a href="/login">Logowanie</a>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <a href="/register">Rejestracja</a>
    </sec:authorize>
    <a href="/edit">Mój profil</a>
    <a href="/ranking">Ranking</a>
    <a href="/new-match">Nowy mecz</a>
    <a href="/last-matches">Ostatnie mecze</a>
    <sec:authorize access="isAuthenticated()">
        <a href="/logout">Wyloguj</a>
    </sec:authorize>
</body>
</html>
