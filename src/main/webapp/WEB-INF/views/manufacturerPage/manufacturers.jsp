<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Manufacturers Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container-md">
            <%@include file="../components/header.jsp"%>
            <h3>Add new manufacturer:</h3>
            <form method="post" action="${pageContext.request.contextPath}/manufacturers/add">
                <p class="text-danger m-0">No spaces, only 1-20 symbols</p>
                <div class="input-group mb-3" style="width: 25%;">
                    <span class="input-group-text" style="min-width: 90px;">Name</span>
                    <input type="text" name="name" class="form-control"
                           minlength="1" maxlength="20" pattern="\S{1,20}$" required>
                </div>
                <p class="text-danger m-0">No spaces, only 1-20 letters</p>
                <div class="input-group mb-3" style="width: 25%;">
                    <span class="input-group-text" style="min-width: 90px;">Country</span>
                    <input type="text" name="country" class="form-control"
                           minlength="1" maxlength="20" pattern="^[A-Za-z]{1,20}$" required>
                </div>
                <button type="submit" class="btn btn-outline-success">Confirm</button>
            </form>

            <h1 class="text-center my-3">Manufacturers List:</h1>
            <div class="row">
                <c:forEach items="${manufacturers}" var="manufacturer">
                    <div class="col-sm-4 mb-3">
                        <div class="card border-info">
                            <div class="card-body">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">
                                        <span class="text-info">Manufacturer - </span>
                                        <c:out value="${manufacturer.name}" />
                                    </li>
                                    <li class="list-group-item">
                                        <span class="text-info">Country - </span>
                                        <c:out value="${manufacturer.country}" />
                                    </li>
                                    <button type="button" class="btn btn-outline-danger">
                                        <a class="text-decoration-none text-black"
                                           href="${pageContext.request.contextPath}/manufacturers/delete?id=${manufacturer.id}">
                                            Delete manufacturer
                                        </a>
                                    </button>
                                </ul>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
