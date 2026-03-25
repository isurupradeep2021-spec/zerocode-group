package lk.zerocode.transport_api.Transport_Api.controller;

import lk.zerocode.transport_api.Transport_Api.Service.TripService;
import lk.zerocode.transport_api.Transport_Api.controller.request.TripRequest;
import lk.zerocode.transport_api.Transport_Api.controller.response.TripResponse;
import lk.zerocode.transport_api.Transport_Api.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("/trip")
    public void createTrip(@RequestBody TripRequest tripRequest){

        tripService.createTrip(tripRequest);

    }

    @GetMapping("/trip")
    public List<TripResponse> getAllTrips() {
        List<Trip> tripsList = tripService.findAllTrips();

        List<TripResponse> tripResponsesList = new ArrayList<>();

        for (Trip trip : tripsList) {
            TripResponse tripResponse = new TripResponse();
            tripResponse.setId(trip.getId());
            tripResponse.setDriverName(trip.getDriverName());
            tripResponse.setVehicleNumber(trip.getVehicleNumber());

            tripResponsesList.add(tripResponse);
        }

        return tripResponsesList;
    }

    @GetMapping("/trip/{trip_id}")
    public TripResponse getByTripId(@PathVariable ("trip_id") Long tripId){

        Trip trip=tripService.findTripById(tripId);
        TripResponse tripResponse = new TripResponse();
        tripResponse.setId(trip.getId());
        tripResponse.setDriverName(trip.getDriverName());
        tripResponse.setVehicleNumber(trip.getVehicleNumber());

        return tripResponse;
    }

    @PutMapping("/trip/{trip_id}")
    public void updateById(@PathVariable ("trip_id")Long tripId, @RequestBody TripRequest tripRequest ){
        tripService.updateById(tripId, tripRequest);
    }
}
