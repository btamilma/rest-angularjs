package com.balatamilmani.batch.sample;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class CustomItemReader implements ItemReader<String>{

	private static int count = 1;
	public CustomItemReader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		if(count<=2){
			count++;
			return "hello";
		}
		return null;
	}

}
