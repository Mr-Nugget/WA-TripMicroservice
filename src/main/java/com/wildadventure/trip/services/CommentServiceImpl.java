package com.wildadventure.trip.services;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildadventure.trip.dao.ICommentDao;
import com.wildadventure.trip.models.AddCommentRequest;
import com.wildadventure.trip.models.Comment;
import com.wildadventure.trip.models.Trip;
import com.wildadventure.trip.proxies.IBookingProxy;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	ICommentDao commentDao;
	
	@Autowired
	IBookingProxy bookingProxy;
	
	@Override
	public List<Comment> getCommentsOfATrip(Long tripId) {
		List<Comment> lc = commentDao.findByTripId(tripId);
		Collections.sort(lc);
		return lc;		
	}

	@Override
	@Transactional
	public Comment addComment(AddCommentRequest comment, Trip trip) {
		Comment commentAdd = new Comment();
		commentAdd.setContent(comment.getContent());
		commentAdd.setDate(comment.getDate());
		commentAdd.setUserId(comment.getUserId());
		commentAdd.setUsername(comment.getUsername());
		commentAdd.setTrip(trip);

		// Update the booking associated to close user access to comment
		bookingProxy.updateBookingStatus(comment.getBookingId().intValue());
		
		return commentDao.save(commentAdd);		
	}

}
