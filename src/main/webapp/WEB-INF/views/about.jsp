<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 5/6/19
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About us</title>
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

<div id="home-other">
    <div class="outer">
        <div class="middle">
            <div class="inner">
                <div class="card text-center text-white bg-dark mb-3" style="max-width: 36rem; height: 34rem;">
                    <div class="card-header"><h3>O nas</h3></div>
                    <div class="card-body">
                        <h5 class="card-title">Nasz zespół</h5>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet consequuntur dolorum earum incidunt, obcaecati quis sequi? Consequuntur mollitia pariatur porro unde voluptates! Accusamus cum earum facere ipsum rem sit tenetur?</p>
                        <h5 class="card-title">Wesprzyj nas</h5>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet consequuntur dolorum earum incidunt, obcaecati quis sequi? Consequuntur mollitia pariatur porro unde voluptates! Accusamus cum earum facere ipsum rem sit tenetur?</p>
                        <a href="#" class="btn btn-primary">Dotacja</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../elements/footer.jsp"/>

</body>
</html>
