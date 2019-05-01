<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/26/19
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="/">Strona główna</a></li>
            <li class="nav-item"><a class="nav-link" href="#">O nas</a></li>
            <li class="nav-item"><a class="nav-link" href="/ranking">Ranking</a></li>
            <li class="nav-item"><a class="nav-link" href="/last-matches">Ostatnie mecze</a></li>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item"><a class="nav-link" href="/edit">Mój profil</a></li>
            </sec:authorize>
        </ul>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item"><a class="nav-link" href="/login"><span class="glyphicon glyphicon-log-in"></span>Logowanie</a></li>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item"><a class="nav-link" href="/register"><span class="glyphicon glyphicon-user"></span>Rejestracja</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item"><a class="nav-link" href="/logout"><span class="glyphicon glyphicon-log-out"></span>Wyloguj</a></li>
            </sec:authorize>
        </ul>
    </div>
</nav>

<%--<nav class="navbar navbar-inverse navbar fixed-top">--%>
    <%--<div class="container-fluid">--%>
        <%--<div class="navbar-header">--%>
            <%--<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
            <%--</button>--%>
        <%--</div>--%>
        <%--<div class="collapse navbar-collapse" id="myNavbar">--%>
            <%--<ul class="nav navbar-nav">--%>
                <%--<li><a class="active" href="/">Strona główna</a></li>--%>
                <%--<li><a href="#">O nas</a></li>--%>
                <%--<li><a href="/ranking">Ranking</a></li>--%>
                <%--<li><a href="/last-matches">Ostatnie mecze</a></li>--%>
                <%--<sec:authorize access="isAuthenticated()">--%>
                    <%--<li><a href="/edit">Mój profil</a></li>--%>
                <%--</sec:authorize>--%>
            <%--</ul>--%>

            <%--<ul class="nav navbar-nav navbar-right">--%>
                <%--<sec:authorize access="!isAuthenticated()">--%>
                    <%--<li><a href="/login"><span class="glyphicon glyphicon-log-in"></span>Logowanie</a></li>--%>
                <%--</sec:authorize>--%>
                <%--<sec:authorize access="!isAuthenticated()">--%>
                    <%--<li><a href="/register"><span class="glyphicon glyphicon-user"></span>Rejestracja</a></li>--%>
                <%--</sec:authorize>--%>
                <%--<sec:authorize access="isAuthenticated()">--%>
                    <%--<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Wyloguj</a></li>--%>
                <%--</sec:authorize>--%>
            <%--</ul>--%>

        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>
