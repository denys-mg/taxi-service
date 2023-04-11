<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container-md">
            <%@include file="../components/header.jsp"%>
            <div class="bg-body-tertiary p-4">
                <h1>Login:</h1>
                <h4 class="text-danger">${errMessage}</h4>
                <form method="post" action="${pageContext.request.contextPath}/login">
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
                    <button type="submit" class="btn btn-outline-success">Confirm</button>
                </form>

                <a class="text-info fs-5"
                   href="${pageContext.request.contextPath}/drivers/add">
                    Register new driver
                </a>
            </div>
        </div>
    </body>
</html>
