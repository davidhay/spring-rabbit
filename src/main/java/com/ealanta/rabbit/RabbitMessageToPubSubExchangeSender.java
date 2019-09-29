package com.ealanta.rabbit;

import java.util.Optional;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMessageToPubSubExchangeSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private MessageUtils msgUtils;

	public void sendMessageToPubSubExchange(String messageTypeAsRoutingKey, String message) {
		try {
			final Message msg = msgUtils.getSimpleMessage(message,Optional.empty());
			rabbitTemplate.send(RabbitInfo.PUB_SUB_MAIN_EX, messageTypeAsRoutingKey, msg);
		} catch (AmqpException ex) {
			ex.printStackTrace();
		}
	}
	
}
