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
    <link rel="stylesheet" href="pages/cars/style.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

</head>

<body>

<jsp:include page="../../components/header.jsp"/>

<div class="main">

    <h2>Cars</h2>

    <p>Total:<span id="total">${cars.size()}</span></p>

    <%-- ADD NEW CAR --%>
    <form class="form-inline addForm" action="${pageContext.request.contextPath}/cars" method="POST">
        <h4>ADD NEW CAR</h4>
        <input type="hidden" name="_method" value="POST"/>
        <div class="form-group addField">
            <input type="text" class="form-control" id="make" placeholder="Make" name="make">
        </div>
        <div class="form-group addField">
            <input type="text" class="form-control" id="color" placeholder="Color" name="color">
        </div>
        <div class="form-group addField">
            <input type="text" class="form-control" id="licensenumber" placeholder="Licensenumber" name="licensenumber">
        </div>
        <div class="form-group addActions">
            <button type="submit" class="btn btn-success addBtn" disabled="disabled">Add</button>
        </div>
    </form>



    <%-- TABLE CARS --%>
    <table class="table table-condensed table-bordered carsTable" id="carsTable">

        <thead>
        <tr>
            <th>N</th>
            <th>Make</th>
            <th>Color</th>
            <th>Licensenumber</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody class="table-striped">
        <c:forEach items="${cars}" var="car">
            <%--<tr id="row_'${car.id}'">--%>
            <tr>
                <td></td>
                <td>${car.make}</td>
                <td>${car.color}</td>
                <td>${car.licensenumber}</td>
                <td>
                    <button type="button" class="btn btn-sm btn-info editBtn">Edit</button>
                    <button type="button" class="btn btn-sm btn-danger deleteBtn">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<%--table rows counter--%>
<style>
    .carsTable {
        counter-reset: rowNumber-1;
    }

    .carsTable tr {
        counter-increment: rowNumber;
    }

    .carsTable tr td:first-child::before {
        content: counter(rowNumber);
        min-width: 1em;
        margin-right: 0.5em;
    }
</style>

<script src="pages/cars/script.js"></script>
</body>
</html>
