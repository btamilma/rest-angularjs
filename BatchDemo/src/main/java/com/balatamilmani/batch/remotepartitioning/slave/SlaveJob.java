package com.balatamilmani.batch.remotepartitioning.slave;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SlaveJob {
	
	public static void main(String[] args) {
		System.out.println("Starting slave");
		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("rPartitionSlave.xml");
		//context.registerShutdownHook();
		new ClassPathXmlApplicationContext("rPartitionSlave.xml");

		System.out.println("Slave is stopped");
	}

}
