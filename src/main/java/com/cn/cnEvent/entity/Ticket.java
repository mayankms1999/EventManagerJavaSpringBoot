package com.cn.cnEvent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Long price;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Person person;

	@ManyToOne
	@JoinColumn(name = "event_id")
	@JsonBackReference
	private Event event;

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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Ticket() {

	}

	public Ticket(Long id, String name, Long price) {

		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Ticket(Long id, String name, Long price, Person person, Event event) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.person = person;
		this.event = event;
	}

}
