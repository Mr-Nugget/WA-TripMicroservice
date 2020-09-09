package com.wildadventure.trip.services;

import java.util.List;

import com.wildadventure.trip.models.Comment;


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
	public Comment addComment(Comment comment);
}
