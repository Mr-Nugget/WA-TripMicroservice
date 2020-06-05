package com.wildadventure.trip.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildadventure.trip.models.Category;
import com.wildadventure.trip.models.Trip;

@Repository
public interface ITripDao extends JpaRepository<Trip, Long>{
	
	public List<Trip> findByCategory(Category category);
		
}
