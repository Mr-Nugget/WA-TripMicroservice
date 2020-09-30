package com.wildadventure.trip.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment implements Comparable<Comment>{
	
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
	@Column(name="USERNAME")
	private String username;
	
	@ManyToOne
	@JoinColumn(name="TRIP_ID")
	@JsonIgnore
	private Trip trip;
	
	public Comment() {
		id = null;
		content = "";
		date = new Date();
		userId = null;
		username = "";
	}
	
	public Comment(Long id, String content, Date date, Long userId, Trip trip, String username) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
		this.userId = userId;
		this.trip = trip;
		this.username = username;
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
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public int compareTo(Comment c) {
		return this.getDate().compareTo(c.getDate());
	}	
}
