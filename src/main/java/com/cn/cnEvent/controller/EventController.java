package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
	
	/*
	       • 
API `GET "/event/eventScheduleDetail/{id}" (@PathVariable Long id) `
: It fetches EventScheduleDetail of an Event for the given eventId.

      • 
API `DELETE "/event/delete/eventScheduleDetail/{id}" (@PathVariable Long id) `
: It deletes EventScheduleDetail of an Event for the given eventScheduleDetailId.

      • 
API `GET "/event/location/{location}" (@PathVariable String location) `
: It fetches the list of all Events by the given location. Note the location fetch should be case-insensitive.
	 */
	@Autowired
	EventService eventService;

	@GetMapping("/{id}")
	public Event getEventById(@PathVariable Long id)
	{
		return eventService.getEventById(id);
	}
	@GetMapping("/all")
	public List<Event> getAllEvents()
	{
		return eventService.getAllEvents();
	}
	
	@GetMapping("/eventScheduleDetail/{eventID}")
	public  EventScheduleDetail getEventScheduleDetail(@PathVariable Long eventID)
	{
		return eventService.getEventScheduleDetail(eventID);
	}
    
	@GetMapping("/location/{location}")
	public List<Event> getEventScheduleDetailByLocation(@PathVariable String location) {
		return eventService.getEventsByLocation(location);
	}
	
	@PostMapping("/save")
	public String saveEvent(@RequestBody Event event) {
		return eventService.saveEvent(event);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEvent(@PathVariable Long id)
	{
		return eventService.delete(id);
	}
	
	@DeleteMapping("/delete/eventScheduleDetail/{id}")
	public String deleteEventScheduleDetail(@PathVariable Long id) {
		return eventService.deleteDetail(id);
		
	}

	@PutMapping("/update")
	public String updateEvent(@RequestBody Event updateEvent)
	{
		return eventService.update(updateEvent);
	}

}
