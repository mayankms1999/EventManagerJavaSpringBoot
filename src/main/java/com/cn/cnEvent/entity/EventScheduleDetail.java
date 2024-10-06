package com.cn.cnEvent.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class EventScheduleDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "startTime")
	private LocalDateTime startTime;
	
	@Column(name = "endTime")
	private LocalDateTime endTime;
	
	@Column(name = "location")
	private String location;

	@JsonIgnore
	@OneToOne(mappedBy ="eventScheduleDetail",cascade = CascadeType.ALL)
	private Event event;
	
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
    public EventScheduleDetail() {
		
	}

	public EventScheduleDetail(Long id, LocalDateTime startTime, LocalDateTime endTime, String location) {
	
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		
	}
	
}
