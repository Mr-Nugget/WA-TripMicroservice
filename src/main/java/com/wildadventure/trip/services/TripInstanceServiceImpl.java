package com.wildadventure.trip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildadventure.trip.dao.ITripInstanceDao;
import com.wildadventure.trip.models.Trip;
import com.wildadventure.trip.models.TripInstance;

@Service
public class TripInstanceServiceImpl implements ITripInstanceService {

	@Autowired
	ITripInstanceDao tripInstanceDao;
	
	@Override
	public List<TripInstance> getByTrip(Trip trip) {
		return tripInstanceDao.findByTrip(trip);
	}

	@Override
	public Optional<TripInstance> getById(Long id) {
		return tripInstanceDao.findById(id);
	}

}
