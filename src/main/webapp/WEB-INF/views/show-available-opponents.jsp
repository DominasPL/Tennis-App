<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/20/19
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dostępni przeciwnicy</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<h1>Dostępni przeciwnicy: </h1>
<c:forEach items="${opponents}" var="opponent">
    <tr>
        Nazwa użytkownika: <td>${opponent.username}</td>
        - Punkty: <td>${opponent.points}</td>
        <br>
    </tr>
</c:forEach>
<a class="btn btn-primary" href="/new-match/show-available-opponents/new-opponent" role="button">Losuj przeciwnika</a>
<a class="btn btn-primary" href="/new-match" role="button">Powrót</a>


</body>
</html>
