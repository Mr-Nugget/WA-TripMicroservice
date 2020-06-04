package com.wildadventure.trip.services;

import java.util.List;
import java.util.Optional;

import com.wildadventure.trip.models.Trip;

public interface ITripService {
	
	public Trip add(Trip trip);

	public Optional<Trip> getById(Long longId);
	
	public List<Trip> getAll();
}
