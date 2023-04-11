package taxi.controller.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Driver;
import taxi.service.DriverService;

@WebServlet(urlPatterns = "/drivers/add")
public class CreateDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/driverPage/create.jsp")
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String driverName = request.getParameter("name");
        String licenceNumber = request.getParameter("licenceNumber");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Driver driver = new Driver(driverName, licenceNumber, login, password);
        driverService.create(driver);
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
