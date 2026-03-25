package lk.zerocode.transport_api.Transport_Api.controller;

import lk.zerocode.transport_api.Transport_Api.Service.VehicleService;
import lk.zerocode.transport_api.Transport_Api.controller.request.VehicleRequest;
import lk.zerocode.transport_api.Transport_Api.controller.response.VehicleResponse;
import lk.zerocode.transport_api.Transport_Api.model.Vehicle;
import lk.zerocode.transport_api.Transport_Api.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicles")
    public void create(@RequestBody VehicleRequest vehicleRequest){
        vehicleService.create(vehicleRequest);
    }
    @GetMapping("/vehicles")
    public List<VehicleResponse> getAll(){

        List<Vehicle> VehicleList = vehicleService.getAll();

        List<VehicleResponse> vehicleResponseList= new ArrayList<>();

        for(Vehicle vehicle:VehicleList){
            VehicleResponse vehicleResponse = new VehicleResponse();
            vehicleResponse.setVehicleNumber(vehicle.getVehicleNumber());
            vehicleResponse.setId(vehicle.getId());
            vehicleResponse.setType(vehicle.getType());

            vehicleResponseList.add(vehicleResponse);

        }
        return vehicleResponseList;

    }

    @GetMapping("/vehicles/{id}")
    public VehicleResponse getById(@PathVariable Long id){

        Vehicle vehicle = vehicleService.getById(id);

        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setType(vehicle.getType());
        vehicleResponse.setId(vehicle.getId());
        vehicleResponse.setVehicleNumber(vehicle.getVehicleNumber());

        return vehicleResponse;

    }
}
