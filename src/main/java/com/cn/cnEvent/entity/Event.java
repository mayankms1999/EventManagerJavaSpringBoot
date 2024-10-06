package com.cn.cnEvent.entity;

import javax.persistence.*;


@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description", nullable = false)
	private String description;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private EventScheduleDetail eventScheduleDetail;

	public EventScheduleDetail getEventScheduleDetail() {
		return eventScheduleDetail;
	}

	public void setEventScheduleDetail(EventScheduleDetail eventScheduleDetail) {
		this.eventScheduleDetail = eventScheduleDetail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public Event() {
	}
	
	public Event(Long id, String name, String description) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		
	}
	
	public Event(Long id, String name, String description, EventScheduleDetail eventScheduleDetail) {
	
		this.id = id;
		this.name = name;
		this.description = description;
		this.eventScheduleDetail = eventScheduleDetail;
	}

}
