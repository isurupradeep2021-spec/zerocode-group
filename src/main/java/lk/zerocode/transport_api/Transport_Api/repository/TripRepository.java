package lk.zerocode.transport_api.Transport_Api.repository;

import lk.zerocode.transport_api.Transport_Api.controller.request.TripRequest;
import lk.zerocode.transport_api.Transport_Api.model.Trip;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TripRepository {

    List<Trip> tripList = new ArrayList<>();

    public void createTrip(Trip trip){
        tripList.add(trip);
    }

    public List<Trip> findAllTrips() {
        return tripList;
    }

    public Trip findTripById(Long tripId) {
        for (Trip trip : tripList) {

            if (trip.getId() == tripId) {
                return trip;
            }
        }
        return null;
    }
    public void updateTrip(Long tripId, TripRequest request) {
        for (Trip trip : tripList) {

            if (trip.getId().equals(tripId)) {

                trip.setId(trip.getId());
                trip.setDriverName(trip.getDriverName());
                trip.setVehicleNumber(trip.getVehicleNumber());

            }
        }

    }

}
