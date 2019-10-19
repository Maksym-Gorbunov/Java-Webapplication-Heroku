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
    <link rel="stylesheet" href="pages/page1/style.css"/>
</head>

<body>
<jsp:include page="../../components/header.jsp"/>
<h3>PAGE 1</h3>
<h3>USERS</h3>
<p>Database: sqlite 3</p>
<%--java code in jsp--%>
<%--
<%
srciptlit
%>

--%>

<%--<img src="img/5.jpg" alt="img" height="400" width="400">--%>

<p>Total: ${users.size()}</p>
<div class="usersTable">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Id</th>
            <th>User</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody class="table-striped">
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.login}</td>
                <td>
                    <c:if test="${user.login=='admin'}">
                        ${u.password}
                    </c:if>
                    <c:if test="${user.login!='admin'}">
                        <c:if test="${u.login==user.login}">
                            ${u.password}
                        </c:if>

                    </c:if>

                </td>
                <td>btn</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>
