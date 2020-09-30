package com.wildadventure.trip.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildadventure.trip.exceptions.TripInstanceNotFoundException;
import com.wildadventure.trip.models.Trip;
import com.wildadventure.trip.models.TripInstance;
import com.wildadventure.trip.services.ITripInstanceService;

@RestController
@RequestMapping("/Dates")
public class TripInstanceController {

	@Autowired
	ITripInstanceService tripInstanceService;
	
	private static Logger log = Logger.getLogger(TripInstanceController.class);
	
	/**
	 * Get a list of futur tripInstance (dates and current person of a trip) by trip id
	 * @param tripId
	 * @return Json reponse
	 * @throws TripInstanceNotFoundException
	 */
	@GetMapping(value="/byTrip/{tripId}")
	public ResponseEntity<List<TripInstance>> getTripInstanceByTrip(@PathVariable int tripId) throws TripInstanceNotFoundException{
		Trip trip = new Trip();
		trip.setId(new Long(tripId));
		
		List<TripInstance> result =  tripInstanceService.getCurrentByTrip(new Long(tripId));
		log.info(result);
		if(result != null) {
			return ResponseEntity.ok(result);			
		}else {
			throw new TripInstanceNotFoundException("Cannot find tripInstance with trip id : " + tripId);
		}
	}
	
	/**
	 * Get a trip instance by its id
	 * @param instanceId
	 * @return
	 * @throws TripInstanceNotFoundException
	 */
	@GetMapping(value="/byId/{instanceId}")
	public ResponseEntity<TripInstance> getTripInstanceById(@PathVariable int instanceId) throws TripInstanceNotFoundException{
		Optional<TripInstance> option = tripInstanceService.getById(new Long(instanceId));
		if(option.isPresent()) {
			return ResponseEntity.ok(option.get());
		}else {
			throw new TripInstanceNotFoundException("Cannot find trip instance with id " + instanceId);
		}
	}
}
