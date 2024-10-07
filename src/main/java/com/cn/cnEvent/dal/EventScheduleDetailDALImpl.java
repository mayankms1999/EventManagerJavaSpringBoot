package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.EventScheduleDetail;



@Repository
public class EventScheduleDetailDALImpl implements EventScheduleDetailDAL{
	

    @Autowired
    EntityManager entityManager;
    
    
    @Override
    public EventScheduleDetail getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        EventScheduleDetail eventDetails = session.get(EventScheduleDetail.class, id);
        return eventDetails;
    }
    
	@Override
	public List<EventScheduleDetail> getAllEventDetails() {
		Session session = entityManager.unwrap(Session.class);
		 List<EventScheduleDetail> allEventDetails = session.createQuery(
	                "SELECT e FROM EventScheduleDetail e", EventScheduleDetail.class).getResultList();
	        return allEventDetails;
	}

	@Override
	public void save(EventScheduleDetail newEventDetail) {
		Session session = entityManager.unwrap(Session.class);
		session.save(newEventDetail);
		
	}

}
