package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Person;
import com.cn.cnEvent.exception.NotFoundException;

@Repository
public class PersonDALImpl implements PersonDAL {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Person> getAllPersons() {
		 Session session = entityManager.unwrap(Session.class);
		    List<Person> allPersons = session.createQuery("SELECT p FROM Person p", Person.class).getResultList();

		    if (allPersons.isEmpty()) {
		        throw new NotFoundException("No persons found.");
		    }

		    return allPersons;

	}

	@Override
	public Person getPersonById(Long id) {
		  Session session = entityManager.unwrap(Session.class);
		    Person person = session.get(Person.class, id);

		    if (person == null) {
		        throw new NotFoundException("Person not found with ID: " + id);
		    }

		    return person;

	}
}
