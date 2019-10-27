<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>mg-webbaplication</title>
    <meta name=viewport content="width=device-width,initial-scale=1">
    <base href="${pageContext.request.contextPath}/">
    <%-- Bootstrap & jQuery --%>
    <script src="js/jquery-1.12.4.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="js/bootstrap.min.js"></script>
    <%-- Mine --%>
    <link rel=icon href="img/favicon.ico">
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>

<body>

<jsp:include page="../../components/header.jsp"/>

<div class="main">
    <h2>About</h2>

    <div class="left">
        <div>
            <p><b>Web Application</b></p>
            <p></p>
            <p>Java / Web / Servlet</p>
            <p>Heroku</p>
            <p>Mockito/JUnit</p>
            <p>Tomcat 8.5</p>
            <p>Jsp / Jstl</p>
            <p>sQlite 3</p>
            <p>Html5 / Css3</p>
            <p>JavaScript / JQuery</p>
            <p>Bootstap 3.4</p>

            <p>Source Code: <a href="https://github.com/Maksym-Gorbunov/mg-webapplication" target="_blank"><i
                    class="fab fa-github"></i></a></p>
        </div>
    </div>

    <div class="right">
        <img src="${pageContext.request.contextPath}/img/maxcoder.jpg" alt="img" width="300">
    </div>
</div>

<script src="js/script.js"></script>
</body>
</html>
