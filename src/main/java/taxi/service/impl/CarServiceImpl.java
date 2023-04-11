package taxi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import taxi.dao.CarDao;
import taxi.exception.DataProcessingException;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Car;
import taxi.model.Driver;
import taxi.service.CarService;

@Service
public class CarServiceImpl implements CarService {
    @Inject
    private CarDao carDao;

    @Override
    public Car create(Car car) {
        return carDao.create(car);
    }

    @Override
    public Car get(Long id) {
        return carDao.get(id).orElseThrow(
                () -> new NoSuchElementException("No car found by id " + id));
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    @Override
    public Car update(Car car) {
        return carDao.update(car);
    }

    @Override
    public boolean delete(Long id) {
        return carDao.delete(id);
    }

    @Override
    public List<Driver> getAllByCar(Long carId) {
        return carDao.getAllByCar(carId);
    }

    @Override
    public List<Car> getAllByDriver(Long driverId) {
        return carDao.getAllByDriver(driverId);
    }

    @Override
    public void addDriverToCar(Driver driver, Car car) {
        if (car.getDrivers()
                .stream()
                .anyMatch(d -> d.getId().equals(driver.getId()))) {
            throw new DataProcessingException("Car " + car.getManufacturer().getName()
                    + " - " + car.getModel() + " already has driver "
                    + driver.getName() + ", licence number: " + driver.getLicenceNumber());
        }
        car.getDrivers().add(driver);
        carDao.update(car);
    }

    @Override
    public void removeDriverFromCar(Driver driver, Car car) {
        if (car.getDrivers()
                .stream()
                .anyMatch(d -> d.getId().equals(driver.getId()))) {
            car.getDrivers().remove(driver);
            carDao.update(car);
        }
    }
}
