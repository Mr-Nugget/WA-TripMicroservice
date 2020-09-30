package com.wildadventure.trip.models;

import java.util.Date;

public class AddCommentRequest {

	public AddCommentRequest() {
		// TODO Auto-generated constructor stub
	}
	
	private String content;
	private Date date;
	private Long userId;
	private String username;
	private Long tripId;
	private Long bookingId;
	
	public AddCommentRequest(String content, Date date, Long userId, String username, Long tripId, Long bookingId) {
		super();
		this.content = content;
		this.date = date;
		this.userId = userId;
		this.username = username;
		this.tripId = tripId;
		this.bookingId = bookingId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}	
}
