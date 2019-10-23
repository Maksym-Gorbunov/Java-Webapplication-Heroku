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

<div class="carsTable">
    <p>total: ${cars.size()}</p>



    <%-- ADD NEW CAR --%>
    <h4>ADD NEW CAR</h4>
    <form class="form-inline" action="${pageContext.request.contextPath}/cars" method="POST">
        <input type="hidden" name="_method" value="POST"/>
        <div class="form-group">
            <p><label for="make">Make</label></p>
            <input type="text" class="form-control" id="make" placeholder="Make" name="make">
        </div>
        <div class="form-group">
            <p><label for="color">Color</label></p>
            <input type="text" class="form-control" id="color" placeholder="Color" name="color">
        </div>
        <div class="form-group">
            <p><label for="licensenumber">Licensenumber</label></p>
            <input type="text" class="form-control" id="licensenumber" placeholder="Licensenumber" name="licensenumber">
        </div>
        <div>
            <p></p>
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </form>
    <p></p>


    <%-- TABLE CARS --%>
    <table class="table table-condensed table-bordered" id="carsTable">

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
                <td>-</td>
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

<script src="pages/cars/script.js"></script>
</body>
</html>
