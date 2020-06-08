package com.wildadventure.trip.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildadventure.trip.models.Trip;
import com.wildadventure.trip.models.TripInstance;

@Repository
public interface ITripInstanceDao extends JpaRepository<TripInstance, Long>{
	
	public List<TripInstance> findByTrip(Trip trip);
	
}
