<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Drivers page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container-md">
            <%@include file="../components/header.jsp"%>
            <h1 class="text-center my-3">Drivers List:</h1>
            <div class="row">
                <c:forEach items="${drivers}" var="driver">
                    <div class="col-sm-4 mb-3">
                        <div class="card border-info">
                            <div class="card-body">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">
                                        <span class="text-info">Driver - </span>
                                        <c:out value="${driver.name}" />
                                    </li>
                                    <li class="list-group-item">
                                        <span class="text-info">licence - </span>
                                         <c:out value="${driver.licenceNumber}" />
                                    </li>
                                    <li class="list-group-item">
                                        <span class="text-info">login - </span>
                                        <c:out value="${driver.login}" />
                                    </li>
                                    <button type="button" class="btn btn-outline-danger">
                                        <a class="text-decoration-none text-black"
                                           href="${pageContext.request.contextPath}/drivers/delete?id=${driver.id}">
                                            Delete driver
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
