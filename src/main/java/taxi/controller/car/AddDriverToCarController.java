package taxi.controller.car;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.exception.DataProcessingException;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.model.Driver;
import taxi.service.CarService;
import taxi.service.DriverService;

@WebServlet(urlPatterns = "/cars/drivers/add")
public class AddDriverToCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private final CarService carService =
            (CarService) injector.getInstance(CarService.class);
    private final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long driverId = Long.valueOf(request.getParameter("driverId"));
        Long carId = Long.valueOf(request.getParameter("carId"));
        Car car = carService.get(carId);
        Driver driver = driverService.get(driverId);
        try {
            carService.addDriverToCar(driver, car);
            response.sendRedirect(request.getContextPath() + "/cars");
        } catch (DataProcessingException e) {
            request.setAttribute("cars", carService.getAll());
            request.setAttribute("drivers", driverService.getAll());
            request.setAttribute("errMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/carPage/driversManagement.jsp")
                    .forward(request, response);
        }
    }
}
