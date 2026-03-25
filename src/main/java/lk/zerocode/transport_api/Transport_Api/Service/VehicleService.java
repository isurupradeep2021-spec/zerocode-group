package lk.zerocode.transport_api.Transport_Api.Service;

import lk.zerocode.transport_api.Transport_Api.controller.request.VehicleRequest;
import lk.zerocode.transport_api.Transport_Api.model.Vehicle;

import java.util.List;

public interface VehicleService {

    void create(VehicleRequest vehicleRequest);

    List<Vehicle> getAll();

    Vehicle getById(Long id);

    Vehicle updateById(Long id,VehicleRequest vehicleRequest);
}