<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/21/19
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Duel</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<h1>Zwycięzca</h1>
<tr>
    Nazwa użytkownika: <td>${winner.username}</td>
    - Punkty po zwycięstwie: <td>${winner.points}</td>
    <br>
</tr>

<a class="btn btn-primary" href="/" role="button">Powrót</a>

</body>
</html>
