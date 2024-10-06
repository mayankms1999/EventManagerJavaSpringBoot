package com.cn.cnEvent.dal;

import java.util.List;

import com.cn.cnEvent.entity.Person;

public interface PersonDAL {

	List<Person> getAllPersons();

	Person getPersonById(Long id);

}
