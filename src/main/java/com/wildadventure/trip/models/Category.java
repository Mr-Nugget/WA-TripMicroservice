package com.wildadventure.trip.models;

public class Category {
	private Long id;
	private String label;
	
	public Category() {
		id = null;
		label = "";
	}
	
	public Category(Long id, String label) {
		super();
		this.id = id;
		this.label = label;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
