package lk.zerocode.transport_api.Transport_Api.Service;

import lk.zerocode.transport_api.Transport_Api.controller.request.DriverRequest;
import lk.zerocode.transport_api.Transport_Api.model.Driver;

import java.util.List;

public interface DriverService  {

    void createDriver(DriverRequest driverRequest);

    List<Driver> getAll();

    Driver getById(Long id);

    void updateById(Long driverId, DriverRequest driverRequest);

}
