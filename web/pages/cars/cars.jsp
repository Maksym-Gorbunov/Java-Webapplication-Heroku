<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cars</title>
</head>
<body>

CARS

<div class="carsTable">
    <table class="table table-condensed" id="carsTable">

        <thead>
        <tr>
            <th>Make</th>
            <th>Color</th>
            <th>License Number</th>
            <th>Actions</th>
        </tr>
        </thead>

        <tbody class="table-striped">
        <c:forEach items="${cars}" var="car">
            <%--<tr id="row_'${u.id}'">--%>
            <tr>
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

    <button type="button" class="btn btn-success">Add new user</button>
</div>

</body>
</html>
