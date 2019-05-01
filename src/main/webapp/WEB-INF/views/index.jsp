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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet">
    <link href="/media/css/style.css" rel="stylesheet" />
</head>
<body>
    <jsp:include page="../elements/navbar.jsp"/>

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


    <jsp:include page="../elements/footer.jsp"/>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

</body>
</html>
