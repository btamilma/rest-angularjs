package com.balatamilmani.batch.remotepartitioning;

import org.springframework.batch.core.StepExecution;

public class ResponseSender {

	public StepExecution postResponseToMaster(StepExecution stepExecution){
		return stepExecution;
	}
}
