package taxi.controller.car;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.service.CarService;
import taxi.service.DriverService;

@WebServlet(urlPatterns = "/cars/drivers")
public class DisplayCarDriversController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private final CarService carService =
            (CarService) injector.getInstance(CarService.class);
    private final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("cars", carService.getAll());
        request.setAttribute("drivers", driverService.getAll());
        request.getRequestDispatcher("/WEB-INF/views/carPage/driversManagement.jsp")
                .forward(request, response);
    }
}
