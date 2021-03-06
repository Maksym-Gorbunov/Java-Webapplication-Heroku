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
    <link rel="stylesheet" href="pages/users/style.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">


</head>

<body>
<jsp:include page="../../components/header.jsp"/>

<div class="main">

    <h2>Users</h2>

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
        <table class="table table-condensed" id="usersTable">

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
                <tr id="row_'${u.id}'">
                    <td>${u.id}</td>
                    <td>${u.login}</td>
                    <td>
                            <%--if Admin--%>
                        <c:if test="${user.login=='admin'}">
                            ${u.password}
                        </c:if>

                            <%--if User--%>
                        <c:if test="${user.login!='admin'}">
                            <c:if test="${u.login==user.login}">
                                ${u.password}
                            </c:if>
                        </c:if>

                    </td>
                    <td>
                            <%--if Admin--%>
                        <c:if test="${user.login=='admin'}">
                            <button type="button" class="btn btn-sm btn-info editBtn" disabled>Edit</button>
                            <button type="button" class="btn btn-sm btn-danger deleteBtn" disabled>Delete</button>
                        </c:if>

                            <%--if User--%>
                        <c:if test="${user.login!='admin'}">
                            <c:if test="${user.login!=u.login}">
                                <button type="button" class="btn btn-sm btn-info" disabled>Info</button>
                                <button type="button" class="btn btn-sm btn-danger" disabled>Danger</button>
                            </c:if>
                            <c:if test="${user.login==u.login}">
                                <button type="button" class="btn btn-sm btn-info" disabled>Info</button>
                                <button type="button" class="btn btn-sm btn-danger" disabled>Danger</button>
                            </c:if>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <p>
            <button type="button" class="btn btn-success addBtn" disabled>Add new user</button>
        </p>
    </div>
</div>


<script src="pages/users/script.js"></script>
</body>
</html>
