<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Drivers Management</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container-md">
            <%@include file="../components/header.jsp"%>
            <h3>Add driver to car:</h3>
            <h4 class="text-danger">${errMessage}</h4>
            <form method="post" action="${pageContext.request.contextPath}/cars/drivers/add">
                <select name="carId" class="form-select mb-3" style="width: 20%;">
                    <c:forEach items="${cars}" var="car">
                        <option value="${car.id}">
                            <c:out value="${car.manufacturer.getName()}" />
                            <span> - </span>
                            <c:out value="${car.model}" />
                        </option>
                    </c:forEach>
                </select>
                <select name="driverId" class="form-select mb-3" style="width: 20%;">
                    <c:forEach items="${drivers}" var="driver">
                        <option value="${driver.id}">
                            <c:out value="${driver.name}" />
                            <span> - </span>
                            <c:out value="${driver.licenceNumber}" />
                        </option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-outline-success">
                    Confirm
                </button>
            </form>
        </div>
    </body>
</html>
