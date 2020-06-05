package com.wildadventure.trip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildadventure.trip.dao.ITripDao;
import com.wildadventure.trip.models.Category;
import com.wildadventure.trip.models.Trip;

@Service
public class TripServiceImpl implements ITripService {
	
	@Autowired
	ITripDao tripDao;

	@Override
	public Trip add(Trip trip) {
		return tripDao.save(trip);
	}

	@Override
	public Optional<Trip> getById(Long longId) {
		return tripDao.findById(longId);
	}

	@Override
	public List<Trip> getAll() {
		return tripDao.findAll();
	}

	@Override
	public List<Trip> getByCategory(Category category) {
		List<Trip> result = tripDao.findByCategory(category);
		System.out.println(result);
		return result;
	}
}
