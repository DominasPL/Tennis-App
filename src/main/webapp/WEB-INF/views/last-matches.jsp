<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/24/19
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Matches</title>
</head>
<body>
    <h1>Dupa</h1>

    <c:forEach items="${allMatches}" var="match">
        <tr>
            <td>${match.player1} vs ${match.player2}</td>
            Data: <td>${match.date}</td>
            - Zwycięzca: <td>${match.winner}</td>
            <td><a class="btn btn-primary" href="/last-matches/${match.id}" role="button">Komentarze</a></td>
            <br>
        </tr>
    </c:forEach>

    <a class="btn btn-primary" href="/" role="button">Powrót</a>

</body>
</html>
