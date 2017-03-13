package com.balatamilmani.main;
/**
 * @author Balamurugan Tamilmani
 *
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.balatamilmani.model.Person;
import com.balatamilmani.service.PersonService;

public class JpaClient {

	public static void main(String[] args) {
		
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
			PersonService personService = context.getBean(PersonService.class);
			Person person = new Person();
			person.setId(125);
			person.setFirstName("Navya_N");
			person.setLastName("Nayar_n");
			person.setAge(33);
			person.setSalary(4000);
			personService.updatePerson(person);
			//System.out.println(person.getSalary());
			//personService.addPerson(person);
			
			
			System.out.println("Done");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		} 
	}
}
