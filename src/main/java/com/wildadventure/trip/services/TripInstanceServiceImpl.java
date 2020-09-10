package com.wildadventure.trip.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildadventure.trip.dao.ITripInstanceDao;
import com.wildadventure.trip.models.Trip;
import com.wildadventure.trip.models.TripInstance;
import com.wildadventure.trip.proxies.IBookingProxy;

@Service
public class TripInstanceServiceImpl implements ITripInstanceService {

	@Autowired
	ITripInstanceDao tripInstanceDao;
	
	@Autowired
	IBookingProxy bookingProxy;
	
	@Override
	public List<TripInstance> getByTrip(Trip trip) {
		return tripInstanceDao.findByTrip(trip);
	}

	@Override
	public Optional<TripInstance> getById(Long id) {
		return tripInstanceDao.findById(id);
	}

	@Override
	@Transactional
	public List<TripInstance> getCurrentByTrip(Long tripId) {
		List<TripInstance> lTrip = tripInstanceDao.findCurrentByTrip(tripId);
		for(TripInstance tripInstance : lTrip) {
			Integer nbOfClient = bookingProxy.getNumberOfClientOfTrip(tripInstance.getId().intValue()).getBody();
			tripInstance.setCurrentPerson(nbOfClient);
		}
		return lTrip;
	}

}
