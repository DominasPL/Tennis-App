<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Created by IntelliJ IDEA.
 User: dominik
 Date: 4/15/19
 Time: 5:10 PM
 To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet">
    <link href="/media/css/style.css" rel="stylesheet" />
    <link rel="stylesheet" href="/media/css/login.css">

</head>
<body>
<jsp:include page="../elements/navbar.jsp"/>
<section class="container-fluid bg">
    <section class="row justify-content-center">
        <section class="col-12 col-sm-6 col-md-3">
        <form:form class="form-container" modelAttribute="registrationForm" method="post">
            <form:errors path="*"/>
                <div class="form-group">
                    <label>Nazwa użytkownika:</label>
                    <form:input class="form-control" placeholder="Podaj nazwę użytkownika" path="username"/>
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <form:input class="form-control" placeholder="Podaj email" path="email"/>
                </div>
                <div class="form-group">
                    <label>Hasło</label>
                    <form:password class="form-control" placeholder="Podaj hasło" path="password"/>
                </div>
                <div class="form-group">
                    <label>Potwierdź hasło</label>
                    <form:password class="form-control" placeholder="Potwierdź hasło" path="confirmedPassword"/>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Potwierdź</button>
        </form:form>
        </section>
    </section>
</section>

<jsp:include page="../elements/footer.jsp"/>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>


</body>
</html>
