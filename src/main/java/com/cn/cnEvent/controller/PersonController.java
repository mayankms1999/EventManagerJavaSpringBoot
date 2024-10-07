package com.cn.cnEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnEvent.entity.Person;
import com.cn.cnEvent.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;
	
/*
API `GET "/person/{id}" (@PathVariable Long id)
 `: It fetches a Person by its id.
 */
  @GetMapping("/{id}")
  public Person getPersonById(@PathVariable Long id) {
	  return personService.getPersonById(id);
  }

/*
API `GET "/person/all"
 `: It fetches the list of all Persons from the database.
 */
  @GetMapping("/all")
  public List<Person> getAllPersons() {
	  return personService.getAllPersons();
  }
	
}
