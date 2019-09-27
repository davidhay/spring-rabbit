package com.ealanta;

import java.util.Optional;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMessageToExchangeSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private MessageUtils msgUtils;

	public void sendMessageToDirectExchange(String routingKeyAsQueueName, String message, Optional<String> correlationId) {
		try {
			final Message msg = msgUtils.getSimpleMessage(message,correlationId);
			rabbitTemplate.send(routingKeyAsQueueName, msg);
		} catch (AmqpException ex) {
			ex.printStackTrace();
		}
	}
}
