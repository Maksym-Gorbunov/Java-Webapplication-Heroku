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
</head>

<body>

<jsp:include page="components/header.jsp"/>

<div>
    <h1>INDEX</h1>
    <p>Welcome ${user.login}</p>
    <img src="${pageContext.request.contextPath}/img/5.jpg" alt="img" height="400" width="400">
</div>

<script src="js/script.js"></script>
</body>
</html>
