package taxi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import taxi.dao.DriverDao;
import taxi.exception.DataProcessingException;
import taxi.lib.Dao;
import taxi.model.Driver;
import taxi.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String createQuery = "INSERT INTO drivers "
                + "(name, licence_number, login, password) VALUES (?, ?, ?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement = connection.prepareStatement(
                        createQuery, Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenceNumber());
            createDriverStatement.setString(3, driver.getLogin());
            createDriverStatement.setString(4, driver.getPassword());
            createDriverStatement.executeUpdate();
            ResultSet resultSet = createDriverStatement.getGeneratedKeys();
            if (resultSet.next()) {
                Long id = resultSet.getObject(1, Long.class);
                driver.setId(id);
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't execute statement "
                    + "to create driver" + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        Driver driver = null;
        String getQuery = "SELECT * FROM drivers WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement =
                        connection.prepareStatement(getQuery)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            if (resultSet.next()) {
                driver = getDriverFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't execute statement "
                    + "to get driver by id" + id, e);
        }
        return Optional.ofNullable(driver);
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        String getAllQuery = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement =
                        connection.prepareStatement(getAllQuery)) {
            ResultSet resultSet = getAllDriversStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(getDriverFromResultSet(resultSet));
            }
            return drivers;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't execute statement "
                    + "to get all drivers", e);
        }
    }

    @Override
    public Optional<Driver> findByLogin(String login) {
        Driver driver = null;
        String getByLoginQuery = "SELECT * FROM drivers WHERE login = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement findByLoginStatement =
                        connection.prepareStatement(getByLoginQuery)) {
            findByLoginStatement.setString(1, login);
            ResultSet resultSet = findByLoginStatement.executeQuery();
            if (resultSet.next()) {
                driver = getDriverFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't execute statement to get driver by login "
                    + login, e);
        }
        return Optional.ofNullable(driver);
    }

    @Override
    public Driver update(Driver driver) {
        String updateQuery = "UPDATE drivers "
                + "SET name = ?, licence_number = ?, "
                + "login = ?, password = ? "
                + "WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement
                        = connection.prepareStatement(updateQuery)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenceNumber());
            updateDriverStatement.setString(3, driver.getLogin());
            updateDriverStatement.setString(4, driver.getPassword());
            updateDriverStatement.setLong(5, driver.getId());
            if (updateDriverStatement.executeUpdate() < 1) {
                throw new DataProcessingException("No data update was performed at " + driver);
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't execute statement"
                    + " to update driver with id " + driver.getId(), e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteQuery = "UPDATE drivers"
                + " SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement
                        = connection.prepareStatement(deleteQuery)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't execute statement"
                    + " to delete driver with id " + id, e);
        }
    }

    private Driver getDriverFromResultSet(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        driver.setId(resultSet.getObject(1, Long.class));
        driver.setName(resultSet.getString(2));
        driver.setLicenceNumber(resultSet.getString(3));
        driver.setLogin(resultSet.getString(4));
        driver.setPassword(resultSet.getString(5));
        return driver;
    }
}
