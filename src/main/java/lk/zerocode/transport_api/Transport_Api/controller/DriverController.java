package lk.zerocode.transport_api.Transport_Api.controller;

import lk.zerocode.transport_api.Transport_Api.Service.DriverService;
import lk.zerocode.transport_api.Transport_Api.controller.request.DriverRequest;
import lk.zerocode.transport_api.Transport_Api.controller.response.DriverResponse;
import lk.zerocode.transport_api.Transport_Api.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/drivers")
    public void CreateDriver(@RequestBody DriverRequest driverRequest){

        driverService.createDriver(driverRequest);

    }

    @GetMapping("/drivers")
    public List<DriverResponse> GetAll(){

        List<Driver> driverList = driverService.getAll();

        List<DriverResponse> driverResponseList = new ArrayList<>();

        for (Driver driver:driverList){
            DriverResponse driverResponse = new DriverResponse();
            driverResponse.setId(driver.getId());
            driverResponse.setName(driver.getName());
            driverResponse.setAge(driver.getAge());
            driverResponse.setEmail(driver.getEmail());
            driverResponse.setMobile(driver.getMobile());

            driverResponseList.add(driverResponse);
        }
        return driverResponseList;
    }

    @GetMapping("drivers/{driverid}")
    public DriverResponse findById(@PathVariable("driverid") Long driverId){

        Driver driver = driverService.getById(driverId);

        DriverResponse driverResponse=new DriverResponse();

        driverResponse.setId(driver.getId());
        driverResponse.setName(driver.getName());
        driverResponse.setAge(driver.getAge());
        driverResponse.setEmail(driver.getEmail());
        driverResponse.setMobile(driver.getMobile());


        return  driverResponse;
    }

    @PutMapping("/drivers/{driverId}")
    public void updateById(@PathVariable("driverId") Long driverId, @RequestBody DriverRequest driverRequest){
         driverService.updateById(driverId,driverRequest);
    }


}
