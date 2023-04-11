package taxi.controller.manufacturer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Manufacturer;
import taxi.service.ManufacturerService;

@WebServlet(urlPatterns = "/manufacturers/add")
public class CreateManufacturerController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String manufacturerName = request.getParameter("name");
        String manufacturerCountry = request.getParameter("country");
        Manufacturer manufacturer = new Manufacturer(manufacturerName, manufacturerCountry);
        manufacturerService.create(manufacturer);
        response.sendRedirect(request.getContextPath() + "/manufacturers");
    }
}
