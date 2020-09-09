package com.wildadventure.trip.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildadventure.trip.models.Comment;

@Repository
public interface ICommentDao extends JpaRepository<Comment, Long>{

	public List<Comment> findByTripId(Long tripId);
}
