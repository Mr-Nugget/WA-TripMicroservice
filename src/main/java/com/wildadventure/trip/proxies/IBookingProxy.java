package com.wildadventure.trip.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "booking-microservice", url="localhost:11090")
public interface IBookingProxy {

	@GetMapping("/Booking/nbOfClient/{tripId}")
	public ResponseEntity<Integer> getNumberOfClientOfTrip(@PathVariable int tripId);
	
	@GetMapping("/Booking/updateStatus/{id}")
	public ResponseEntity<Void> updateBookingStatus(@PathVariable int id);
	
}
