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
import com.wildadventure.trip.models.Category;
import com.wildadventure.trip.models.Trip;
import com.wildadventure.trip.services.ITripService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/Trip")
public class TripController {
	
	@Autowired
	private ITripService tripService;
	
	private static Logger log = Logger.getLogger(TripController.class);
	
	/**
	 * Get all Trip of the DB
	 * @return
	 */
	@GetMapping(value ="/all")
	public List<Trip> getAllTrip(){
		return tripService.getAll();
	}
	
	/**
	 * Get a Trip object by it's ID
	 * @param id
	 * @return JSON response with status code
	 * @throws TripNotFoundException
	 */
	@GetMapping(value = "/byId/{id}")
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
	
	/**
	 * Get a list of trip associated to the category with the ID in parameters
	 * @param categoryId
	 * @return a list of trip
	 * @throws TripNotFoundException
	 */
	@GetMapping(value="/byCategory/{categoryId}")
	public ResponseEntity<List<Trip>> getTripByCategory(@PathVariable int categoryId) throws TripNotFoundException{
		Long longId = new Long(categoryId);
		Category category = new Category(longId, "");
		log.info(category);
		List<Trip> result = tripService.getByCategory(category);
		
		if(result != null) {
			return ResponseEntity.ok(result);
		}else {
			throw new TripNotFoundException("Cannot find trip with category id : " + categoryId);
		}
	}
	
	/**
	 * Add a new trip into the DB
	 * @param newTrip
	 * @return the URI of the new object and a status code (success 201 or fail 404)
	 */
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
