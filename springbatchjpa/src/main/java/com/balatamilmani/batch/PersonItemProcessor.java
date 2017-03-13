package com.balatamilmani.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.balatamilmani.model.Person;

/**
 * @author Balamurugan Tamilmani
 *
 */
@Component
@Scope(value="step")
public class PersonItemProcessor implements ItemProcessor<Person, Person>{

	@Override
	public Person process(Person person) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(person.getFirstName());
		return person;
	}

	private Person getNewPerson(){
		Person person = new Person();
		person.setId(124);
		person.setFirstName("Power");
		person.setLastName("Star");
		person.setAge(23);
		person.setSalary(8000);
		
		return person;
	}
}
