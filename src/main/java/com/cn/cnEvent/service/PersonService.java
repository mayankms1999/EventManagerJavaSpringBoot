package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.PersonDAL;
import com.cn.cnEvent.entity.Person;

@Service
public class PersonService {
	
	@Autowired
	PersonDAL personDAL;

	@Transactional
	public List<Person> getAllPersons() {
		return personDAL.getAllPersons();
	}

	@Transactional
	public Person getPersonById(Long id) {
		return personDAL.getPersonById(id);
	}

}
