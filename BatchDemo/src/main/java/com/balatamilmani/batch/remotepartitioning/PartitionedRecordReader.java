package com.balatamilmani.batch.remotepartitioning;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;

public class PartitionedRecordReader implements ItemReader<String>{

	//@Value("#{stepExecutionContext[from]}")
	//int from;
	//@Value("#{stepExecutionContext[to]}")
	int to;
	private ExecutionContext executionContext;
	
	@BeforeStep
	public void storeExecutionContext(StepExecution stepExecution){
		this.executionContext = stepExecution.getExecutionContext();
		this.to= executionContext.getInt("to");
	}
	//@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		int from= executionContext.getInt("from");
		//System.out.println("PartitionedRecordReader.read():: from: "+from);
		while(from<=this.to){
			executionContext.putInt("from", from+1);
			System.out.println("PartitionedRecordReader.read():: Chunk->["+executionContext.getString("name")+"]. Reading record->"+from);
			return from+"";
		}
		
		return null;
	}

}
