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
</head>
<body>
    <tr>
        <td>${match.player1} vs ${match.player2}</td>
        Data: <td>${match.date}</td>
        - Zwycięzca: <td>${match.winner}</td>
        <br>
    </tr>
    <c:forEach items="${comments}" var="comment">
        <tr>
            <td>${comment.text}</td>
            <td> - ${comment.created}</td>
            <br>
        </tr>
    </c:forEach>

    <h1>Dodaj komentarz</h1>
    <form:form modelAttribute="commentMatchDTO" method="post" action="/last-matches/add-comment">
        <form:errors path="*"/> <br>
        <form:textarea path="text"/> <br>
        <form:hidden path="createdBy" value="${loggedUser}"/>
        <form:hidden path="match_id" value="${match.id}"/>
        <input class="btn btn-outline-warning" type="submit" value="Dodaj"/>
    </form:form>


    <a class="btn btn-primary" href="/" role="button">Powrót</a>

</body>
</html>
