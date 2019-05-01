<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/24/19
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comments</title>
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
                    <th colspan="4" style="text-align: center"> ${match.player1} vs ${match.player2} - Data: ${match.date} - Zwycięzca: ${match.winner}</th>
                </tr>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Komentarz</th>
                    <th scope="col">Data</th>
                    <th scope="col">Dodany przez</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${comments}" var="comment" varStatus="commentStatus">
                    <tr>
                        <td>${commentStatus.count}</td>
                        <td>${comment.text}</td>
                        <td>${comment.created}</td>
                        <td>${comment.createdBy}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<section class="container-fluid bg">
    <section class="row justify-content-center">
        <section class="col-12 col-sm-6 col-md-3">
            <form:form class="form-container" modelAttribute="commentMatchDTO" method="post" action="/last-matches/add-comment">
                <form:errors path="*"/> <br>
                <div class="form-group">
                    <label>Komentarz</label>
                    <form:textarea class="form-control" placeholder="Enter comment" path="text"/> <br>
                </div>
                <form:hidden path="createdBy" value="${loggedUser}"/>
                <form:hidden path="match_id" value="${match.id}"/>
                <button type="submit" class="btn btn-primary btn-block">Submit</button>
            </form:form>
        </section>
    </section>
</section>

<jsp:include page="../elements/footer.jsp"/>

</body>
</html>
