package com.wildadventure.trip.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildadventure.trip.dao.ICommentDao;
import com.wildadventure.trip.models.Comment;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	ICommentDao commentDao;
	
	@Override
	public List<Comment> getCommentsOfATrip(Long tripId) {
		List<Comment> lc = commentDao.findByTripId(tripId);
		Collections.sort(lc);
		return lc;		
	}

	@Override
	public Comment addComment(Comment comment) {
		return commentDao.save(comment);		
	}

}
