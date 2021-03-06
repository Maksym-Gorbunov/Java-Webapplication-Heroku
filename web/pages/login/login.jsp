<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>mg-webbaplication</title>
    <meta name=viewport content="width=device-width,initial-scale=1">
    <base href="${pageContext.request.contextPath}/pages/login/">
    <%-- Bootstrap & jQuery --%>
    <script src="../../js/jquery-1.12.4.min.js"></script>
    <link rel="stylesheet" href="../../css/bootstrap.min.css"/>
    <script src="../../js/bootstrap.min.js"></script>
    <%-- Mine --%>
    <%--<link rel=icon href="img/favicon.ico">--%>
    <%--<link rel="stylesheet" href="css/style.css"/>--%>
    <%--Login--%>
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>

<body>


<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100" >
            <form class="login100-form validate-form" action="${pageContext.request.contextPath}/login" method="post">

                <c:if test="${not empty message}">
                    <p style="color: red; padding-bottom: 2em;">${message}</p>
                </c:if>

                <span class="login100-form-title p-b-34">
						Account Login
					</span>

                <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
                    <input id="first-name" class="input100" type="text" name="username" autocomplete="off" value="" placeholder="User name">
                    <span class="focus-input100"></span>
                </div>
                <div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20" data-validate="Type password">
                    <input class="input100" type="password" name="pass" autocomplete="off" value="" placeholder="Password">
                    <span class="focus-input100"></span>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">
                        Sign in
                    </button>
                </div>

                <%--<div class="w-full text-center">--%>
                    <%--<a href="#" class="txt3">--%>
                        <%--Sign Up--%>
                    <%--</a>--%>
                <%--</div>--%>

                <div class="usersTable">
                    <table class="table table-condensed">
                        <thead>
                        <tr>
                            <th>USER</th>
                            <th>PASSWORD</th>
                        </tr>
                        </thead>
                        <tbody class="table-striped">
                        <c:forEach items="${data}" var="user">
                            <tr>
                                <td>${user.login}</td>
                                <td>${user.password}</td>
                            </tr>
                            <tr> ...    </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>


            </form>

            <div class="login100-more" style="background-image: url('images/bg-02.jpg');"></div>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="vendor/animsition/js/animsition.min.js"></script>
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/select2/select2.min.js"></script>
<script>
    $(".selection-2").select2({
        minimumResultsForSearch: 20,
        dropdownParent: $('#dropDownSelect1')
    });
</script>
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<script src="vendor/countdowntime/countdowntime.js"></script>
<script src="js/main.js"></script>

</body>
</html>
