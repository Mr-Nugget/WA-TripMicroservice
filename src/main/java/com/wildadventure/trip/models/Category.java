package com.wildadventure.trip.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

/**
 * Category bean bind to trip.
 * @author Titouan
 *
 */
@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	@Length(min=3, max=20, message="Label length must be between 3 and 20")
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

	@Override
	public String toString() {
		return "Category [id=" + id + ", label=" + label + "]";
	}
	
}
