package taxi.dao;

import java.util.List;
import taxi.model.Car;
import taxi.model.Driver;

public interface CarDao extends GenericDao<Car> {
    List<Car> getAllByDriver(Long driverId);

    List<Driver> getAllByCar(Long carId);
}
