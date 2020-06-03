package com.wildadventure.trip.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@Column(name="MAX_PERSON")
	private Integer maxPerson;
	
	@Column(name="CURRENT_PERSON")
	private Integer currentPerson;
	
	@ManyToOne
	@JoinColumn(name="TRIP_ID")
	private Trip trip;
	

	public TripInstance(Long id, Date beginDate, Date endDate, Integer maxPerson, Integer currentPerson, Trip trip) {
		super();
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.maxPerson = maxPerson;
		this.currentPerson = currentPerson;
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

	@Override
	public String toString() {
		return "TripInstance [id=" + id + ", beginDate=" + beginDate + ", endDate=" + endDate + ", maxPerson="
				+ maxPerson + ", currentPerson=" + currentPerson + ", trip=" + trip + "]";
	}
	
}
