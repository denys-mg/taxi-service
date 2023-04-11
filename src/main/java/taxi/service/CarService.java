package taxi.service;

import java.util.List;
import taxi.model.Car;
import taxi.model.Driver;

public interface CarService extends GenericService<Car> {
    List<Driver> getAllByCar(Long carId);

    List<Car> getAllByDriver(Long driverId);

    void addDriverToCar(Driver driver, Car car);

    void removeDriverFromCar(Driver driver, Car car);
}
