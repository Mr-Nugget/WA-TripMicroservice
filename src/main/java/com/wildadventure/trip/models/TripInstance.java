package com.wildadventure.trip.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


/**
 * Bean object representing instances of a trip by a ManyToOne binding.
 * Describe begin and end date to a trip with the current person registered.
 * @author Titouan
 *
 */

@Entity
public class TripInstance {

	@Id
	@GeneratedValue
	@Column(name="DATES_ID")
	private Long id;
	
	@Column(name="BEGIN_DATE")
	private Date beginDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Transient
	private Integer currentPerson;
	
	@Column(name="PRICE")
	private Float price;
	
	@ManyToOne
	@JoinColumn(name="TRIP_ID")
	private Trip trip;
	
	public TripInstance() {
		
	}


	public TripInstance(Long id, Date beginDate, Date endDate, Integer currentPerson, Float price, Trip trip) {
		super();
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.currentPerson = currentPerson;
		this.price = price;
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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getCurrentPerson() {
		return currentPerson;
	}

	public void setCurrentPerson(Integer currentPerson) {
		this.currentPerson = currentPerson;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "TripInstance [id=" + id + ", beginDate=" + beginDate + ", endDate=" + endDate + ", currentPerson=" + currentPerson + ", trip=" + trip + "]";
	}
	
}
