package com.wildadventure.trip.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Trip {
	//@Id
	//@GeneratedValue
	private Long id;
	private String label;
	private String description;
	private Float price;
	private Integer maxPerson;
	private Integer currentPerson;
	private String imagePath;
	
	private Category category;
	private List<Comment> comments;
	private TripDates dates;
	
	/**
	 * Empty Constructor
	 */
	public Trip() {
		id = null;
		label = "";
		description = "";
		price = new Float(0.00);
		maxPerson = 0;
		currentPerson = 0;
		imagePath = "";
		
		category = new Category();
		comments = new ArrayList<>();
		dates = new TripDates();		
	}
	
	

	public Trip(Long id, String label, String description, Float price, Integer maxPerson, Integer currentPerson,
			String imagePath, Category category, List<Comment> comments, TripDates dates) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.price = price;
		this.maxPerson = maxPerson;
		this.currentPerson = currentPerson;
		this.imagePath = imagePath;
		this.category = category;
		this.comments = comments;
		this.dates = dates;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(Integer maxPerson) {
		this.maxPerson = maxPerson;
	}

	public Integer getCurrentPerson() {
		return currentPerson;
	}

	public void setCurrentPerson(Integer currentPerson) {
		this.currentPerson = currentPerson;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public TripDates getDates() {
		return dates;
	}

	public void setDates(TripDates dates) {
		this.dates = dates;
	}
}
