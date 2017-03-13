package com.balatamilmani.service;
/**
 * @author Balamurugan Tamilmani
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.balatamilmani.dao.JpaBaseDao;
import com.balatamilmani.model.Person;

@Service
@Transactional
public class PersonService {

	@Autowired
	JpaBaseDao<Person> jpaPersonDao;
	
	public void addPerson(Person person){
		jpaPersonDao.persist(person);
	}
	
	public Person updatePerson(Person person){
		return jpaPersonDao.merge(person);
	}
}
