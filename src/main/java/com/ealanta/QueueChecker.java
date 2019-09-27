package com.ealanta;

import java.util.Properties;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QueueChecker {

	public static final long TWENTY_SECONDS = 20_000;

	@Autowired
	public AmqpAdmin rabbitAdmin;

	@Scheduled(fixedDelay = TWENTY_SECONDS)
	public void checkQueuesExist() {
		checkQueue(RabbitInfo.QUEUE_TEST_1);
		checkQueue(RabbitInfo.QUEUE_TEST_2);
		checkQueue(RabbitInfo.QUEUE_TEST_3);
	}

	private void checkQueue(String name) {
		boolean exists = doesQueueExist(name);
		if(exists) {
			System.out.printf("The queue[%s] exists :-)%n", name);
		} else {
			System.out.printf("The queue[%s] does NOT exist :-(%n", name);
		}
	}
	
	private boolean doesQueueExist(String queueName) {
		try {
			Properties props = rabbitAdmin.getQueueProperties(queueName);
			System.out.printf("properties for [%s] [%s]%n", queueName, props);
			return props != null;
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
