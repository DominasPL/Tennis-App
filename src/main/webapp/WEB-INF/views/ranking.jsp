<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/20/19
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ranking</title>
</head>
<body>

    <h1>To jest Ranking zawodników!</h1>
    <c:forEach items="${users}" var="user">
        <tr>
            Nazwa użytkownika: <td>${user.username}</td>
            <br>
            Rozegrane mecze: <td>${user.ranking.matchesPlayed}</td>
            <br>
            Zwycięstwa: <td>${user.ranking.won}</td>
            <br>
            Przegrane: <td>${user.ranking.lost}</td>
            <br>
            Procent zwycięstw: <td>${user.ranking.winPercentage}</td>
            <br>
            Punkty: <td>${user.ranking.points}</td>
            <br><br><br>
        </tr>
    </c:forEach>

</body>
</html>
