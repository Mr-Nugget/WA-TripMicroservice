package com.wildadventure.trip.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wildadventure.trip.models.Trip;
import com.wildadventure.trip.models.TripInstance;

@Repository
public interface ITripInstanceDao extends JpaRepository<TripInstance, Long>{
	
	List<TripInstance> findByTrip(Trip trip);
	
	@Query(value = "SELECT * FROM trip_instance t WHERE t.trip_id = ?1 AND t.begin_date > NOW()", nativeQuery = true)
	List<TripInstance> findCurrentByTrip(Long tripId);
	
}
