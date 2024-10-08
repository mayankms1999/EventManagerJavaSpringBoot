package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;

import java.util.List;

public interface EventDAL {

	Event getById(Long id);

	List<Event> getAllEvents();

	String save(Event item);

	String delete(Long id);

	String update(Event updateEvent);

	EventScheduleDetail getEventScheduleDetail(Long eventID);

	EventScheduleDetail getEventScheduleDetailByLocation(String location);

	String deleteDetail(Long id);

	List<Ticket> getAllTicketsByEventId(Long id);

	List<Event> getEventsByTicketPrice(Long price);
}
