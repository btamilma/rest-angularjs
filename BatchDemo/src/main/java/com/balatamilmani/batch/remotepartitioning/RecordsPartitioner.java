package com.balatamilmani.batch.remotepartitioning;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class RecordsPartitioner implements Partitioner {

	private static final int CHUNK_SIZE = 6;
	private int gridSize;
	
	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}

	public Map<String, ExecutionContext> partition(int arg0) {
		System.out.println("gridSize::" + gridSize);

		int startingPoint = 1;
		Map<String, ExecutionContext> executionContextMap = new HashMap<String, ExecutionContext>();

		for(int i=0; i<gridSize; i++){
			ExecutionContext ec = new ExecutionContext();
			
			ec.putInt("from", startingPoint);
			ec.putInt("to", startingPoint+CHUNK_SIZE-1);
			ec.putString("name", "Chunk-"+i);
			
			executionContextMap.put("Chunk-"+i, ec);
			startingPoint = startingPoint+CHUNK_SIZE;
		}
		return executionContextMap;
	}

}
