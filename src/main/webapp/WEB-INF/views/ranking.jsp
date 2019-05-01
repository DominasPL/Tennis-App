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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet">
    <link href="/media/css/style.css" rel="stylesheet" />
    <link href="/media/css/tables.css" rel="stylesheet" />

</head>
<body>
<jsp:include page="../elements/navbar.jsp"/>

<div id="home-other">
    <div class="landing-text">
    <div id="table-ranking">
    <table>
        <thead>
            <tr>
                <th colspan="7" style="text-align: center">Ranking zawodników</th>
            </tr>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nazwa użytkownika</th>
                <th scope="col">Rozegrane mecze</th>
                <th scope="col">Zwycięstwa</th>
                <th scope="col">Porażki</th>
                <th scope="col">Skuteczność</th>
                <th scope="col">Punkty</th>
             </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user" varStatus="userStatus">
            <tr>
                <td>${userStatus.count}</td>
                <td>${user.username}</td>
                <td>${user.matchesPlayed}</td>
                <td>${user.won}</td>
                <td>${user.lost}</td>
                <td>${user.winPercentage}</td>
                <td>${user.points}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
    </div>
</div>
<jsp:include page="../elements/footer.jsp"/>
</body>
</html>
