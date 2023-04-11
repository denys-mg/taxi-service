<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Header</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
              crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/2cc17d077d.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <nav class="navbar bg-body-tertiary">
                <div class="container-fluid d-flex align-items-center justify-content-center">
                    <h1 class="ms-3 me-5">
                        <a class="text-decoration-none text-success"
                           href="${pageContext.request.contextPath}/index">
                            <i class="fa-solid fa-taxi text-warning fs-2"></i>
                            Taxi service
                        </a>
                    </h1>

                    <button class="btn btn-primary me-2" type="button">
                        <a class="text-decoration-none text-light"
                           href="${pageContext.request.contextPath}/drivers">
                            Drivers
                        </a>
                    </button>
                    <button class="btn btn-primary me-2" type="button">
                        <a class="text-decoration-none text-light"
                           href="${pageContext.request.contextPath}/cars">
                            Cars
                        </a>
                    </button>
                    <button class="btn btn-primary me-2" type="button">
                        <a class="text-decoration-none text-light"
                           href="${pageContext.request.contextPath}/manufacturers">
                            Manufacturers
                        </a>
                    </button>
                    <c:if test="${pageContext.request.getSession().getAttribute('driverId') != null}">
                        <button class="btn btn-primary me-2" type="button">
                            <a class="text-decoration-none text-light"
                               href="${pageContext.request.contextPath}/drivers/cars">
                                My cars
                            </a>
                        </button>
                    </c:if>

                    <c:if test="${pageContext.request.getSession().getAttribute('driverId') != null}">
                        <button class="btn btn-success ms-5 me-2" type="button">
                            <a class="text-decoration-none text-light"
                               href="${pageContext.request.contextPath}/logout">
                                <i class="fa-solid fa-right-from-bracket fs-6"></i>
                                Logout
                            </a>
                        </button>
                    </c:if>
                    <c:if test="${pageContext.request.getSession().getAttribute('driverId') == null}">
                        <button class="btn btn-success ms-5 me-2" type="button">
                            <a class="text-decoration-none text-light"
                               href="${pageContext.request.contextPath}/login">
                                <i class="fa-solid fa-user fs-5"></i>
                                Login
                            </a>
                        </button>
                    </c:if>
                </div>
            </nav>
        </header>
    </body>
</html>
