package com.balatamilmani.batch.sample;

import java.util.UUID;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpJobTester {
	
	public static void main(String[] args) {
		System.out.println("Launching job");
		ApplicationContext context = new ClassPathXmlApplicationContext("sample-job.xml");

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("empJob");

		try {

			JobParameters jobParams = new JobParametersBuilder().addString(
					"runId", UUID.randomUUID()+"").addString("dirPath", "/home/btamilma/temp").toJobParameters();
		  JobExecution execution = jobLauncher.run(job, jobParams);
		  System.out.println("Exit Status : " + execution.getStatus());
		  System.out.println("Exit Status : " + execution.getAllFailureExceptions());

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			((ConfigurableApplicationContext)context).close();
		}
		System.out.println("Job completed");
	}

}
