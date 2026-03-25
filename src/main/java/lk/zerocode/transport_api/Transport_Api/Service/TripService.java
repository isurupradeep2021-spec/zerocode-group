package lk.zerocode.transport_api.Transport_Api.Service;

import lk.zerocode.transport_api.Transport_Api.controller.request.TripRequest;
import lk.zerocode.transport_api.Transport_Api.model.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripService {

    void createTrip(TripRequest tripRequest);

    List<Trip> findAllTrips();

    Trip findTripById(Long tripId);

    void updateById(Long tripId, TripRequest tripRequest);

}
