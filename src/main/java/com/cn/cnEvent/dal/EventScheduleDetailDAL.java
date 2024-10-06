package com.cn.cnEvent.dal;

import java.util.List;

import com.cn.cnEvent.entity.EventScheduleDetail;

public interface EventScheduleDetailDAL {

	List<EventScheduleDetail> getAllEventDetails();

	void save(EventScheduleDetail newEventDetail);

	EventScheduleDetail getById(Long id);

}
