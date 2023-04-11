package taxi.controller.driver;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.service.CarService;

@WebServlet(urlPatterns = "/drivers/cars")
public class GetMyCurrentCarsController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private final CarService carService =
            (CarService) injector.getInstance(CarService.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Car> cars = carService.getAllByDriver(
                (Long) request.getSession().getAttribute("driverId"));
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/WEB-INF/views/carPage/cars.jsp").forward(request, response);
    }
}
