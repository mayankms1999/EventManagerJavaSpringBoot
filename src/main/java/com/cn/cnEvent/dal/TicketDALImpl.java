package com.cn.cnEvent.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.NotFoundException;

@Repository
public class TicketDALImpl implements TicketDAL{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Ticket getTicketById(Long id) {
		 Session session = entityManager.unwrap(Session.class);
		    Ticket ticket = session.get(Ticket.class, id);

		    if (ticket == null) {
		        throw new NotFoundException("Ticket not found with ID: " + id);
		    }

		    return ticket;
	}

	@Override
	public List<Ticket> getAllTickets() {
		 Session session = entityManager.unwrap(Session.class);
		    List<Ticket> allTickets = session.createQuery("SELECT t FROM Ticket t", Ticket.class).getResultList();

		    if (allTickets.isEmpty()) {
		        throw new NotFoundException("No tickets found.");
		    }

		    return allTickets;
	}

	@Override
	public List<Ticket> getAllTicketsByAge(Long age) {
		 Session session = entityManager.unwrap(Session.class);
		    List<Ticket> ticketsByAge = session.createQuery(
		            "SELECT t FROM Ticket t WHERE t.person.age = :age", Ticket.class)
		            .setParameter("age", age)
		            .getResultList();

		    if (ticketsByAge.isEmpty()) {
		        throw new NotFoundException("No tickets found for persons with age: " + age);
		    }

		    return ticketsByAge;
	}

}
