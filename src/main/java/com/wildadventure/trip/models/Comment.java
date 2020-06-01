package com.wildadventure.trip.models;

import java.util.Date;

public class Comment {
	private Long id;
	private String content;
	private Date date;
	private Long userId;
	
	public Comment() {
		id = null;
		content = "";
		date = new Date();
		userId = null;
	}
	
	public Comment(Long id, String content, Date date, Long userId) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
		this.userId = userId;
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
}
