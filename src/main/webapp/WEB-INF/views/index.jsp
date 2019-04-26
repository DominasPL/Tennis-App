<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/20/19
  Time: 7:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona Główna</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet">
    <link href="/media/css/style.css" rel="stylesheet" />
</head>
<body>

    <nav class="navbar navbar-inverse navbar fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a class="active" href="/">Strona główna</a></li>
                    <li><a href="#">O nas</a></li>
                    <li><a href="/ranking">Ranking</a></li>
                    <li><a href="/last-matches">Ostatnie mecze</a></li>
                    <sec:authorize access="isAuthenticated()">
                        <li><a href="/edit">Mój profil</a></li>
                    </sec:authorize>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <sec:authorize access="!isAuthenticated()">
                        <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span>Logowanie</a></li>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <li><a href="/register"><span class="glyphicon glyphicon-user"></span>Rejestracja</a></li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Wyloguj</a></li>
                    </sec:authorize>
                </ul>

            </div>
        </div>
    </nav>

    <div id="home">
        <div class="landing-text">
            <h1>Aplikacja do wyszukiwania przeciwnika</h1>
            <h3>Wypróbuj i znajdź idealnego przeciwnika dla siebie</h3>
            <a href="/new-match" class="btn btn-primary btn-lg">Nowy mecz</a>
        </div>
    </div>

    <div class="padding">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <img src="/media/images/2-tennis-balls-blink-images.jpg">
            </div>
            <div class="col-sm-6 text-center">
                <h2>O aplikacji</h2>
                <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores aut autem commodi debitis distinctio earum harum laboriosam magnam maxime nostrum perferendis unde, veniam. Fugiat pariatur, praesentium. A cupiditate eos voluptatibus.</p>
            </div>
        </div>
    </div>
    </div>

    <div class="padding">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <h4>Ranking</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam atque blanditiis esse natus nesciunt non porro repellendus sint, tenetur! Ad autem culpa deserunt doloremque facilis ipsam mollitia, odio quis. Ipsum.</p>
            </div>
            <div class="col-sm-6">
                <h4>Wyszukiwanie przeciwnika</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam atque blanditiis esse natus nesciunt non porro repellendus sint, tenetur! Ad autem culpa deserunt doloremque facilis ipsam mollitia, odio quis. Ipsum.</p>
            </div>
        </div>
    </div>
    </div>

    <div id="fixed">
        <span></span>
    </div>

    <div class="padding">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <img class="img" src="/media/images/djoko.jpg">
                </div>
                <div class="col-sm-3">
                    <img class="img" src="/media/images/fedi.jpeg">
                </div>
                <div class="col-sm-3">
                    <img class="img" src="/media/images/serena.jpg">
                </div>
                <div class="col-sm-3">
                    <img class="img" src="/media/images/1212.jpg">
                </div>
            </div>
        </div>
    </div>


    <footer class="container-fluid text-center">
        <div class="row">
            <div class="col-sm-4">
                <h3>Contact us</h3>
                <br>
                <p>Our address and info here</p>
            </div>
            <div class="col-sm-4">
                <h3>Connect</h3>
                <a href="https://www.facebook.com/" class="fa fa-facebook"></a>
                <a href="https://twitter.com/" class="fa fa-twitter"></a>
                <a href="https://www.google.com/" class="fa fa-google"></a>
                <a href="https://pl.linkedin.com/" class="fa fa-linkedin"></a>
                <a href="https://www.youtube.com/" class="fa fa-youtube"></a>
                <a href="https://www.instagram.com/" class="fa fa-instagram"></a>
            </div>
            <div class="col-sm-4">
                <h3>Links</h3>
            </div>
        </div>
    </footer>

</body>
</html>
