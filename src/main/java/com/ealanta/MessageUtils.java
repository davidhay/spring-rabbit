package com.ealanta;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {
	
	public Message getSimpleMessage(String message, Optional<String> correlationid) {
		byte[] data = message.getBytes(StandardCharsets.UTF_8);		
		MessageProperties properties = new MessageProperties();
		properties.setContentType(MediaType.TEXT_PLAIN_VALUE);
		correlationid.ifPresent( corrid -> {
			properties.setCorrelationId(corrid);
		});
		properties.setContentLength(2112);//seems to be ignored.
		return new Message(data, properties);
	}
	
	public String extractContent(Message message) {
		return new String(message.getBody(),StandardCharsets.UTF_8);
	}

}
