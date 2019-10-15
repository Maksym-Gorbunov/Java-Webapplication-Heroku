<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mg-webbaplication</title>
    <meta name=viewport content="width=device-width,initial-scale=1">
    <link rel=icon href=${pageContext.request.contextPath}/img/favicon.ico>
    <%-- Bootstrap & jQuery --%>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <%-- Mine --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
</head>

<body>
<jsp:include page="components/header.jsp"/>
<h1>55555</h1>

<ul class="nav navbar-nav">
    <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
    <li><a href="#">Link</a></li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
           aria-expanded="false">Dropdown <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
        </ul>
    </li>
</ul>

<img src="${pageContext.request.contextPath}/img/5.jpg" alt="img" height="400" width="400">
</body>
</html>
