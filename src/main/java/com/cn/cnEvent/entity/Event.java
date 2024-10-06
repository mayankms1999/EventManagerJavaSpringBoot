package com.cn.cnEvent.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private EventScheduleDetail eventScheduleDetail;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Ticket> ticket;

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}

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

	public Event(Long id, String name, String description, EventScheduleDetail eventScheduleDetail, List<Ticket> ticket) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.eventScheduleDetail = eventScheduleDetail;
		this.ticket = ticket;
	}

}
