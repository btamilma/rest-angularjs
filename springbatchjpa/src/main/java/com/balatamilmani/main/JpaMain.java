package com.balatamilmani.main;
/**
 * @author Balamurugan Tamilmani
 *
 */
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.balatamilmani.model.Person;
import com.balatamilmani.service.PersonService;

public class JpaMain {

	public static void main(String[] args) {
		JobExecution jobExecution = null;
		Job job = null;	
		JobLauncher jobLauncher = null;
		JobRegistry jobRegistry = null;
		
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
			PersonService personService = context.getBean(PersonService.class);
			Person person = new Person();
			person.setId(123);
			person.setFirstName("Thomas");
			person.setLastName("John");
			person.setAge(22);
			person.setSalary(4000);
			//personService.updatePerson(person);
			//System.out.println(person.getSalary());
			//personService.addPerson(person);
			
			jobLauncher = (JobLauncher) context.getBean(JobLauncher.class);
			jobRegistry = (JobRegistry) context.getBean(JobRegistry.class);
			
			job = jobRegistry.getJob("personCsvToDbJob");
			JobParameters jobParameters = new JobParametersBuilder().addLong("jobId", 106L).toJobParameters();
			jobExecution = jobLauncher.run(job, jobParameters);
			while(jobExecution.isRunning()){
				System.out.println("still running");
				Thread.sleep(1000);
			}
			System.out.println(jobExecution.getExitStatus());
			System.out.println("Done");
			
		} catch (NoSuchJobException | JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException | InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		} 
	}
}
