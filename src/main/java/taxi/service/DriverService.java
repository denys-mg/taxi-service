package taxi.service;

import taxi.exception.AuthenticationException;
import taxi.model.Driver;

public interface DriverService extends GenericService<Driver> {
    Driver findByLogin(String login) throws AuthenticationException;
}
