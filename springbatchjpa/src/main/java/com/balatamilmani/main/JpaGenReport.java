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

public class JpaGenReport {

	public static void main(String[] args) {
		JobExecution jobExecution = null;
		Job job = null;	
		JobLauncher jobLauncher = null;
		JobRegistry jobRegistry = null;
		
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
			
			jobLauncher = (JobLauncher) context.getBean(JobLauncher.class);
			jobRegistry = (JobRegistry) context.getBean(JobRegistry.class);
			
			job = jobRegistry.getJob("personDbToCsvJob");
			JobParameters jobParameters = new JobParametersBuilder().addLong("jobId", 100L).toJobParameters();
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
