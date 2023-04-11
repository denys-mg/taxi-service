<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Create driver</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container-md">
            <%@include file="../components/header.jsp"%>
            <h3>Registration:</h3>
            <form method="post" action="${pageContext.request.contextPath}/drivers/add">
                <p class="text-danger m-0">No digits and spaces, only 1-16 letters</p>
                <div class="input-group mb-3" style="width: 30%;">
                    <span class="input-group-text" style="min-width: 150px;">Name</span>
                    <input type="text" name="name" class="form-control"
                           minlength="1" maxlength="15" pattern="^[A-Za-z]{1,15}$" required>
                </div>
                <p class="text-danger m-0">Only 10 letters/digits</p>
                <div class="input-group mb-3" style="width: 30%;">
                    <span class="input-group-text" style="min-width: 150px;">Licence number</span>
                    <input type="text" name="licenceNumber" class="form-control"
                           minlength="10" pattern="\w{10}$" required>
                </div>
                <p class="text-danger m-0">4-10 symbols</p>
                <div class="input-group mb-3" style="width: 30%;">
                    <span class="input-group-text" style="min-width: 150px;">Login</span>
                    <input type="text" name="login" class="form-control"
                           minlength="4" maxlength="10" pattern="\S{4,10}$" required>
                </div>
                <p class="text-danger m-0">6-20 symbols</p>
                <div class="input-group mb-3" style="width: 30%;">
                    <span class="input-group-text" style="min-width: 150px;">Password</span>
                    <input type="password" name="password" class="form-control"
                           minlength="6" maxlength="20" pattern="\S{6,20}$" required>
                </div>
                <button type="submit" class="btn btn-outline-success">Register</button>
            </form>
        </div>
    </body>
</html>
