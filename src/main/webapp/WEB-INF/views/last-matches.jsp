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
                    <th colspan="5" style="text-align: center">Ostatnie mecze</th>
                </tr>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Gracze</th>
                    <th scope="col">Zwycięzca</th>
                    <th scope="col">Data</th>
                    <th scope="col">Komentarze</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allMatches}" var="match" varStatus="matchStatus">
                    <tr>
                        <td>${matchStatus.count}</td>
                        <td>${match.player1} vs ${match.player2}</td>
                        <td>${match.winner}</td>
                        <td>${match.date}</td>
                        <td><a class="btn btn-primary" href="/last-matches/${match.id}" role="button">Link</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </nav>
    </div>
</div>

<jsp:include page="../elements/footer.jsp"/>
</body>
</html>
