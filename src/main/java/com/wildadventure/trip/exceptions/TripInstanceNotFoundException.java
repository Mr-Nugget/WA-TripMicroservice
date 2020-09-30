package com.wildadventure.trip.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TripInstanceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TripInstanceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
