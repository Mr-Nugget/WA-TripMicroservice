package com.wildadventure.trip.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Trip {
	@Id
	@GeneratedValue
	@Column(name="TRIP_ID")
	private Long id;
	
	@Column(name="LABEL")
	private String label;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="DESTINATION")
	private String destination;
	
	@Column(name="IMAGE_PATH")
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private Category category;
	
	@OneToMany(mappedBy="trip")
	private List<Comment> comments;
	
	@OneToMany(mappedBy="trip")
	private List<TripInstance> instances;
	
	/**
	 * Empty Constructor
	 */
	public Trip() {
		id = null;
		label = "";
		description = "";
		imagePath = "";
		destination = "";
		category = new Category();
		comments = new ArrayList<>();
		instances = new ArrayList<>();		
	}
	

	public Trip(Long id, String label, String description, String destination, String imagePath, Category category,
			List<Comment> comments, List<TripInstance> instances) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.destination = destination;
		this.imagePath = imagePath;
		this.category = category;
		this.comments = comments;
		this.instances = instances;
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


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public List<TripInstance> getInstances() {
		return instances;
	}


	public void setInstances(List<TripInstance> instances) {
		this.instances = instances;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", label=" + label + ", description=" + description + ", destination=" + destination
				+ ", imagePath=" + imagePath + ", category=" + category + ", comments=" + comments + ", instances="
				+ instances + "]";
	}
	

}
