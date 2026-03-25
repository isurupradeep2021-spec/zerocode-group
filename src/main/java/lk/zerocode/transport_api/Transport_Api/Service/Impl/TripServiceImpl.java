package lk.zerocode.transport_api.Transport_Api.Service.Impl;

import lk.zerocode.transport_api.Transport_Api.Service.TripService;
import lk.zerocode.transport_api.Transport_Api.controller.request.TripRequest;
import lk.zerocode.transport_api.Transport_Api.model.Trip;
import lk.zerocode.transport_api.Transport_Api.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {


    @Autowired
    private TripRepository tripRepository;


    @Override
    public void createTrip(TripRequest tripRequest) {

        Trip trip = new Trip();
        trip.setId(tripRequest.getId());
        trip.setDriverName(tripRequest.getDriverName());
        trip.setVehicleNumber(tripRequest.getVehicleNumber());
        trip.setDistance(tripRequest.getDistance());
        trip.setFare(tripRequest.getFare());

        tripRepository.createTrip(trip);

    }

    @Override
    public List<Trip> findAllTrips() {
        return tripRepository.findAllTrips();
    }

    @Override
    public Trip findTripById(Long tripId) {
        return tripRepository.findTripById(tripId);
    }

    @Override
    public void updateById(Long tripId, TripRequest tripRequest) {
        tripRepository.updateTrip(tripId, tripRequest);
    }
}
