package com.wildadventure.trip.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	@Column(name="COMMENT_ID")
	private Long id;
	@Column(name="CONTENT")
	private String content;
	@Column(name="DATE")
	private Date date;
	@Column(name="USER_ID")
	private Long userId;
	
	@ManyToOne
	@JoinColumn(name="TRIP_ID")
	private Trip trip;
	
	public Comment() {
		id = null;
		content = "";
		date = new Date();
		userId = null;
	}
	
	public Comment(Long id, String content, Date date, Long userId, Trip trip) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
		this.userId = userId;
		this.trip = trip;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", date=" + date + ", userId=" + userId + ", trip=" + trip
				+ "]";
	}
}
