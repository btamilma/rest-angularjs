package com.balatamilmani.batch; 

import com.balatamilmani.batch.ExampleItemReader;

import junit.framework.TestCase;

public class ExampleItemReaderTests extends TestCase {

	private ExampleItemReader reader = new ExampleItemReader();
	
	public void testReadOnce() throws Exception {
		assertEquals("Hello world!", reader.read());
		String[] input = {"Hello world!", null};
		System.out.println(input.length);
	}

	public void testReadTwice() throws Exception {
		reader.read();
		assertEquals(null, reader.read());
	}

}
