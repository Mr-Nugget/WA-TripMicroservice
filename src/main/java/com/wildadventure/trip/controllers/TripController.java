package com.wildadventure.trip.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wildadventure.trip.models.Trip;

@RestController
public class TripController {
	
	private static Logger log = Logger.getLogger(TripController.class);
	
	@GetMapping(value = "Trip/{id}")
	public Trip getTripById(@PathVariable int id) {
		log.info("Id du trip :" + id);
		Trip myTrip = new Trip(new Long(0), "La diagonale du fou", "blablabla", "France", "/assets/img/monimage.png", null, null, null);
		
		return myTrip;
	}
}
