package com.balatamilmani.batch.remotepartitioning;

import org.springframework.batch.integration.partition.StepExecutionRequest;

public class RequestSender {

	public StepExecutionRequest postRequestToSlave(StepExecutionRequest stepExecutionRequest){
		System.out.println("In RequestSender.StepExecutionRequest. Sending request to slave::"+stepExecutionRequest.getStepName());
		return stepExecutionRequest;
	}
}
