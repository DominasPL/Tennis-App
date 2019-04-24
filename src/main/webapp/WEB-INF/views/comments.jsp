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
        <td>${player1} vs ${player2}</td>
        Data: <td>${date}</td>
        - Zwycięzca: <td>${winner}</td>
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
    <form:form modelAttribute="comment" method="post">
        <form:errors path="*"/> <br>
        <form:textarea path="text"/> <br>
        <input name="match_id" type="hidden" value="${match_id}">
        <input class="btn btn-outline-warning" type="submit" value="Dodaj"/>
    </form:form>


    <a class="btn btn-primary" href="/" role="button">Powrót</a>

</body>
</html>
