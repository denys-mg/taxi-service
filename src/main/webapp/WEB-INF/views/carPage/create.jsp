<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add car</title>
    </head>
    <body>
        <div class="container-md">
            <%@include file="../components/header.jsp"%>
            <h3>Add new car:</h3>
            <form method="post" action="${pageContext.request.contextPath}/cars/add">
                <p class="text-danger m-0">No spaces, only 1-15 symbols</p>
                <div class="input-group mb-3" style="width: 25%;">
                    <span class="input-group-text" style="min-width: 110px;">Model</span>
                    <input type="text" name="model" class="form-control"
                           minlength="1" maxlength="15" pattern="\S{1,15}$" required>
                </div>
                <select name="manufacturerId" class="form-select mb-3" style="width: 10%;">
                    <c:forEach items="${manufacturers}" var="manufacturer">
                        <option value="${manufacturer.id}">
                            <c:out value="${manufacturer.name}" />
                        </option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-outline-success">Confirm</button>
            </form>
        </div>
    </body>
</html>
