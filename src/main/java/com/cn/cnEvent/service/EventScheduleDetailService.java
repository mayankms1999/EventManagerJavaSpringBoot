package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.EventScheduleDetailDAL;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.NotFoundException;





@Service
public class EventScheduleDetailService {
	
	@Autowired
	EventScheduleDetailDAL eventScheduleDetailDAL;

	@Transactional
    public List<EventScheduleDetail> getAllEventDetails() {
        List<EventScheduleDetail> eventDetails = eventScheduleDetailDAL.getAllEventDetails();
        return eventDetails;
    }
	
	@Transactional
	public void saveEventDetails(EventScheduleDetail newEventDetail) {
		  List<EventScheduleDetail> allEventDetails = getAllEventDetails();
		  for (EventScheduleDetail eventScheduleDetail : allEventDetails) {
	            if (eventScheduleDetail.getId() == newEventDetail.getId()) {
	                throw new ElementAlreadyExistException("This paymentDetails already exist.");
	            }
	        }
		  eventScheduleDetailDAL.save(newEventDetail);
	}

	@Transactional
	public EventScheduleDetail getEventDetailsById(Long id) {
		EventScheduleDetail eventScheduleDetail = eventScheduleDetailDAL.getById(id);
	        if (eventScheduleDetail == null) {
	            throw new NotFoundException("No paymentDetails found with id:  " + id);
	        }
	        return eventScheduleDetail;
		
	}

}
