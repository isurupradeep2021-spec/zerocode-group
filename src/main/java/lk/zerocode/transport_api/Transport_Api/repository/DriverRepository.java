package lk.zerocode.transport_api.Transport_Api.repository;

import lk.zerocode.transport_api.Transport_Api.model.Driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverRepository {

    List<Driver> driverList = new ArrayList<>();

    public void createDriver(Driver driver){
        driverList.add(driver);
    }

    public List<Driver> findAllDrivers() {
        return driverList;
    }

    public Driver findDriverById(Long driverId) {
        for (Driver driver : driverList) {

            if (driver.getId() == driverId) {
                return driver;
            }
        }
        return null;
    }
}