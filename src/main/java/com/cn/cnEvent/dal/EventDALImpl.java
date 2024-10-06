package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.NotFoundException;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import java.util.List;

@Repository
public class EventDALImpl implements EventDAL {

    @Autowired
    EntityManager entityManager;


    @Override
    public Event getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event event = session.get(Event.class, id);
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        Session session = entityManager.unwrap(Session.class);
        List<Event> allEvents = session.createQuery("SELECT e FROM Event e", Event.class).getResultList();
        return allEvents;
    }

    @Override
    public String save(Event event) {
        Session session = entityManager.unwrap(Session.class);
        session.save(event);
        return "The event was saved successfully.";
    }

    @Override
    public String delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event event = session.get(Event.class, id);
        session.delete(event);
        return "The event was deleted successfully";
    }

    @Override
    public String update(Event updateEvent) {
        Session session = entityManager.unwrap(Session.class);
        Event currentEvent = session.get(Event.class, updateEvent.getId());
        currentEvent.setName(updateEvent.getName());
        currentEvent.setDescription(updateEvent.getDescription());
        session.update(currentEvent);
        return "Event is updated successfully";
    }

	@Override
	public EventScheduleDetail getEventScheduleDetail(Long eventID) {
		Session session = entityManager.unwrap(Session.class);
		  EventScheduleDetail eventDetails = session.get(EventScheduleDetail.class, eventID);
	        return eventDetails;
		
	 
	}

	@Override
	public EventScheduleDetail getEventScheduleDetailByLocation(String location) {
	    Session session = entityManager.unwrap(Session.class);
	    EventScheduleDetail eventDetails = session.get(EventScheduleDetail.class, location);
		return eventDetails;
	}

	@Override
	public String deleteDetail(Long id) {
		
		Session session = entityManager.unwrap(Session.class);
        try {
            EventScheduleDetail eventScheduleDetail = session.createQuery(
                            "SELECT e FROM EventScheduleDetail e WHERE e.id = :id", EventScheduleDetail.class)
                    .setParameter("id", id)
                    .getSingleResult();

            for (Event event : getAllEvents()) {
                if(event.getEventScheduleDetail()!=null && event.getEventScheduleDetail().getId().equals(id)){
                    event.setEventScheduleDetail(null);
                    save(event);
                }
            }
            session.delete(eventScheduleDetail);
            return "The eventSchedule was deleted successfully";
        } catch (NoResultException ex) {
            return "EventScheduleDetail with id " + id + " does not exist";
        }
	}

	@Override
	public List<Ticket> getAllTicketsByEventId(Long id) {
		Session session = entityManager.unwrap(Session.class);
	    List<Ticket> tickets = session.createQuery(
	            "SELECT t FROM Ticket t WHERE t.event.id = :eventId", Ticket.class)
	            .setParameter("eventId", id)
	            .getResultList();

	    if (tickets.isEmpty()) {
	        throw new NotFoundException("No tickets found for event with ID: " + id);
	    }

	    return tickets;
	}

	@Override
	public List<Event> getEventsByTicketPrice(Long price) {
		  Session session = entityManager.unwrap(Session.class);
		    List<Event> events = session.createQuery(
		            "SELECT DISTINCT t.event FROM Ticket t WHERE t.price > :price", Event.class)
		            .setParameter("price", price)
		            .getResultList();

		    if (events.isEmpty()) {
		        throw new NotFoundException("No events found with tickets priced above: " + price);
		    }

		    return events;
	}

}
