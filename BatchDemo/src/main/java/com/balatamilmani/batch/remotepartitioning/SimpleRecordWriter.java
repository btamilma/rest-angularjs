package com.balatamilmani.batch.remotepartitioning;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class SimpleRecordWriter implements ItemWriter<String>{

	public void write(List<? extends String> arg0) throws Exception {
		System.out.println("In SimpleRecordWriter.write(). Number of records received->"+arg0.size());
		for(String str : arg0){
			System.out.println("SimpleRecordWriter.write()::"+str);
		}
		
	}

}
