package taxi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import taxi.dao.DriverDao;
import taxi.exception.AuthenticationException;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;
import taxi.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return driverDao.get(id).orElseThrow(
                () -> new NoSuchElementException("No driver found by id " + id));
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver findByLogin(String login) throws AuthenticationException {
        return driverDao.findByLogin(login).orElseThrow(
                () -> new AuthenticationException("Login or password is incorrect"));
    }

    @Override
    public Driver update(Driver driver) {
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        return driverDao.delete(id);
    }
}
