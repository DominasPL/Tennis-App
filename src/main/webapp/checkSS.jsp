<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/17/19
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Spring Security Taglibs</title>
</head>
<body>

    <sec:authorize access="isAuthenticated()">
        <%--<sec:authentication property="username" var="loggedUser"/>--%>
        <p>Dla Zalogowanego</p>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <p>Dla niezalogowanego</p>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <p>Dla zalogowanego z rolą ADMIN</p>
    </sec:authorize>

</body>
</html>
