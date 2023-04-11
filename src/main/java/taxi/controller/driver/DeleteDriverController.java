package taxi.controller.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import taxi.lib.Injector;
import taxi.service.DriverService;

@WebServlet(urlPatterns = "/drivers/delete")
public class DeleteDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        HttpSession session = request.getSession();
        Long currentDriverId = (Long) session.getAttribute("driverId");
        driverService.delete(id);
        if (id.equals(currentDriverId)) {
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            response.sendRedirect(request.getContextPath() + "/drivers");
        }
    }
}
