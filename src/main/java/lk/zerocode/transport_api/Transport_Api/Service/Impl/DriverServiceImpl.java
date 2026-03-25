package lk.zerocode.transport_api.Transport_Api.Service.Impl;

import lk.zerocode.transport_api.Transport_Api.Service.DriverService;
import lk.zerocode.transport_api.Transport_Api.controller.request.DriverRequest;
import lk.zerocode.transport_api.Transport_Api.model.Driver;
import lk.zerocode.transport_api.Transport_Api.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;
    @Override
    public void createDriver(DriverRequest driverRequest) {

        Driver driver = new Driver();
        driver.setId(driverRequest.getId());
        driver.setName(driverRequest.getName());
        driver.setAge(driverRequest.getAge());
        driver.setEmail(driverRequest.getEmail());
        driver.setMobile(driverRequest.getEmail());

       driverRepository.createDriver(driver);
    }

    @Override
    public List<Driver> getAll() {
        return driverRepository.findAllDrivers();
    }

    @Override
    public Driver getById(Long driverId) {

        return driverRepository.findDriverById(driverId);
    }


}
