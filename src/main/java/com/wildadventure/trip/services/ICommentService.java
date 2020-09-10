package com.wildadventure.trip.services;

import java.util.List;

import com.wildadventure.trip.models.AddCommentRequest;
import com.wildadventure.trip.models.Comment;
import com.wildadventure.trip.models.Trip;


public interface ICommentService {
	/**
	 * Get comments of a trip and sort it by dates
	 * @param tripId
	 * @return
	 */
	public List<Comment> getCommentsOfATrip(Long tripId);

	/**
	 * Add a comment associated to a user and a trip
	 * @param comment
	 */
	public Comment addComment(AddCommentRequest comment, Trip trip);
}
