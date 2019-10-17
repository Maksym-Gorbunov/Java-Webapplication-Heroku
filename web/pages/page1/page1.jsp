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
    <script src="js/script.js"></script>
</head>

<body>
<jsp:include page="../../components/header.jsp"/>
<h1>PAGE 1</h1>

<%--java code in jsp--%>
<%--
<%
srciptlit
%>

--%>

<img src="img/5.jpg" alt="img" height="400" width="400">
<p>Welcome ${user}</p>


<%--<table class="table table-condensed">--%>
    <%--<thead>--%>
    <%--<tr>--%>
        <%--<th>USER</th>--%>
        <%--<th>PASSWORD</th>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<tbody class="table-striped">--%>
    <%--<c:forEach items="${users}" var="user">--%>
        <%--<tr>--%>
            <%--<td>${user.login}</td>--%>
            <%--<td>${user.password}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</tbody>--%>
<%--</table>--%>

<p>The data from servlet: ${data}</p>
<p>Total: ${total}</p>
</body>
</html>
