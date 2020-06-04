package com.wildadventure.trip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildadventure.trip.models.Trip;

@Repository
public interface ITripDao extends JpaRepository<Trip, Long>{
	
		
}
