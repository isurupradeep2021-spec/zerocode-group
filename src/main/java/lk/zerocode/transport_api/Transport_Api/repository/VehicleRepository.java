package lk.zerocode.transport_api.Transport_Api.repository;

import lk.zerocode.transport_api.Transport_Api.controller.request.VehicleRequest;
import lk.zerocode.transport_api.Transport_Api.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

    @Repository
    public class VehicleRepository {

        List<Vehicle> vehicleList = new ArrayList<>();

        public void createVehicle(Vehicle vehicle){
            vehicleList.add(vehicle);
        }

        public List<Vehicle> findAllVehicles() {
            return vehicleList;
        }

        public Vehicle findVehicleById(Long vehicleId) {
            for (Vehicle vehicle : vehicleList) {

                if (vehicle.getId() == vehicleId) {
                    return vehicle;
                }
            }
            return null;
        }
        public Vehicle updatevehicle(Long Id, VehicleRequest request) {
            for (Vehicle vehicle : vehicleList) {

                if (vehicle.getId().equals(Id)) {

                    vehicle.setVehicleNumber(request.getVehicleNumber());
                    vehicle.setId(request.getId());
                    vehicle.setType(request.getType());

                    return vehicle;
                }
            }

            return null;
        }

    }

