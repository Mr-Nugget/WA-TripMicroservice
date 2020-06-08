package com.wildadventure.trip.services;

import java.util.List;

import com.wildadventure.trip.models.Trip;
import com.wildadventure.trip.models.TripInstance;

public interface ITripInstanceService {

	public List<TripInstance> getByTrip(Trip trip);
}
