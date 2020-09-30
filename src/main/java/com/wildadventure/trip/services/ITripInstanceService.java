package com.wildadventure.trip.services;

import java.util.List;
import java.util.Optional;

import com.wildadventure.trip.models.Trip;
import com.wildadventure.trip.models.TripInstance;

public interface ITripInstanceService {

	public List<TripInstance> getByTrip(Trip trip);
	
	public List<TripInstance> getCurrentByTrip(Long tripId);
	
	public Optional<TripInstance> getById(Long id);
}
