package taxi.controller.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import taxi.exception.AuthenticationException;
import taxi.lib.Injector;
import taxi.model.Driver;
import taxi.service.AuthenticationService;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private final AuthenticationService authenticationService =
            (AuthenticationService) injector.getInstance(AuthenticationService.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/authenticationPage/login.jsp")
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Driver driver = authenticationService.login(
                    request.getParameter("login"),
                    request.getParameter("password"));
            HttpSession session = request.getSession();
            session.setAttribute("driverId", driver.getId());
            response.sendRedirect(request.getContextPath() + "/index");
        } catch (AuthenticationException e) {
            request.setAttribute("errMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/authenticationPage/login.jsp")
                    .forward(request, response);
        }
    }
}
