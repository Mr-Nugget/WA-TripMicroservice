package com.wildadventure.trip.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildadventure.trip.exceptions.CommentEmptyException;
import com.wildadventure.trip.exceptions.TripNotFoundException;
import com.wildadventure.trip.models.AddCommentRequest;
import com.wildadventure.trip.models.Comment;
import com.wildadventure.trip.models.Trip;
import com.wildadventure.trip.services.ICommentService;
import com.wildadventure.trip.services.ITripService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/Comment")
public class CommentController {

	@Autowired
	ICommentService commentService;
	
	@Autowired
	ITripService tripService;

	/**
	 * Get a list of comment associated to a trip
	 * @param tripId
	 * @return
	 */
	@GetMapping("/byTrip/{tripId}")
	public ResponseEntity<List<Comment>> getCommentByTrip(@PathVariable int tripId) {
		List<Comment> lc = commentService.getCommentsOfATrip(new Long(tripId));
		if(lc == null || lc.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lc);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Void> addAComment(@RequestBody AddCommentRequest comment) throws CommentEmptyException, ErrorAddCommentException, TripNotFoundException{
		if(comment == null || comment.getContent() == null || comment.getContent().isEmpty() || comment.getUserId() == null || comment.getUserId() == null) {
			throw new CommentEmptyException();
		}else {
			Optional<Trip> trip = tripService.getById(comment.getTripId());
			if(!trip.isPresent()) {
				throw new TripNotFoundException("Trip not found while adding comment");
			}
			Comment commentAdd = new Comment();
			commentAdd.setContent(comment.getContent());
			commentAdd.setDate(comment.getDate());
			commentAdd.setUserId(comment.getUserId());
			commentAdd.setUsername(comment.getUsername());
			commentAdd.setTrip(trip.get());
			Comment newComment = commentService.addComment(commentAdd);
			if(newComment == null) {
				throw new ErrorAddCommentException();
			}else {
				return ResponseEntity.ok().build();
			}
		}
	}
}
