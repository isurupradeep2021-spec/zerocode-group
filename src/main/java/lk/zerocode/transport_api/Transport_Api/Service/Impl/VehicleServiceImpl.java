package lk.zerocode.transport_api.Transport_Api.Service.Impl;

import lk.zerocode.transport_api.Transport_Api.Service.VehicleService;
import lk.zerocode.transport_api.Transport_Api.controller.request.VehicleRequest;
import lk.zerocode.transport_api.Transport_Api.model.Vehicle;
import lk.zerocode.transport_api.Transport_Api.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void create(VehicleRequest vehicleRequest) {

        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleNumber(vehicleRequest.getVehicleNumber());
        vehicle.setType(vehicleRequest.getType());
        vehicle.setId(vehicleRequest.getId());

        vehicleRepository.createVehicle(vehicle);

    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAllVehicles();

    }

    @Override
    public Vehicle getById(Long id) {
        return vehicleRepository.findVehicleById(id);

    }
}
