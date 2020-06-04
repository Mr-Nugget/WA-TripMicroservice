package com.wildadventure.trip.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wildadventure.trip.exceptions.TripNotFoundException;
import com.wildadventure.trip.models.Trip;
import com.wildadventure.trip.services.ITripService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/Trip")
public class TripController {
	
	@Autowired
	private ITripService tripService;
	
	private static Logger log = Logger.getLogger(TripController.class);
	
	@GetMapping(value ="/all")
	public List<Trip> getAllTrip(){
		return tripService.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trip> getTripById(@PathVariable int id) throws TripNotFoundException {
		Long longId = new Long(id);
		
		Optional<Trip> option = tripService.getById(longId);
		
		if(option.isPresent()) {
			log.info("Find trip with id : " + id);
			return ResponseEntity.ok(option.get());
		}else {
			throw new TripNotFoundException("Cannot find trip with id : " + id);
		}
	}
	
	@PostMapping(value= "/add")
	public ResponseEntity<Void> addTrip(@RequestBody Trip newTrip){
		Trip tripAdded = tripService.add(newTrip);
		
		if(tripAdded == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(tripAdded.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
