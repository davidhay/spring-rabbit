package com.ealanta.rabbit;

import java.util.Properties;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.scheduling.annotation.Scheduled;

import com.ealanta.rabbit.RabbitInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueMonitor {

	public static final long TWENTY_SECONDS = 20_000;

	private AmqpAdmin rabbitAdmin;

	public QueueMonitor(AmqpAdmin rabbitAdmin){
		this.rabbitAdmin = rabbitAdmin;		
	}
	
	@Scheduled(fixedDelay = TWENTY_SECONDS)
	public void checkQueuesExist() {
		checkQueue(RabbitInfo.QUEUE_TEST_1);
		checkQueue(RabbitInfo.QUEUE_TEST_2);
		checkQueue(RabbitInfo.QUEUE_TEST_3);
	}

	private void checkQueue(String name) {
		boolean exists = doesQueueExist(name);
		if(exists) {
			log.info("The queue[{}] exists :-)", name);
		} else {
			log.info("The queue[{}] does NOT exist :-(", name);
		}
	}
	
	private boolean doesQueueExist(String queueName) {
		try {
			Properties props = rabbitAdmin.getQueueProperties(queueName);
			log.info("properties for [{}] [{}]", queueName, props);
			return props != null;
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
