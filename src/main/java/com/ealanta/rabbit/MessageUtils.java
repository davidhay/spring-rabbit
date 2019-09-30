package com.ealanta.rabbit;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {
	
	public static final String HDR_APPLICATION_NAME = "applicationName";
	
	public Message getPlainTextMessage(String message, Optional<String> correlationid) {
		byte[] data = message.getBytes(StandardCharsets.UTF_8);		
		MessageProperties properties = new MessageProperties();
		properties.setContentType(MediaType.TEXT_PLAIN_VALUE);
		correlationid.ifPresent( corrid -> {
			properties.setCorrelationId(corrid);
		});
		properties.setContentLength(2112);//seems to be ignored.
		return new Message(data, properties);
	}
	
	public Message getJsonMessage(String message, String type, Optional<String> correlationid) {
		byte[] data = message.getBytes(StandardCharsets.UTF_8);		
		MessageProperties properties = new MessageProperties();
		properties.setContentType(MediaType.APPLICATION_JSON_VALUE);
		properties.setType(type);
		correlationid.ifPresent( corrid -> {
			properties.setCorrelationId(corrid);
		});
		return new Message(data, properties);
	}
	
	public String extractContent(Message message) {
		return new String(message.getBody(),StandardCharsets.UTF_8);
	}
	
	public void setApplicationName(Message message, String applicationName) {
		message.getMessageProperties().getHeaders().put(HDR_APPLICATION_NAME, applicationName);
	}
	
	public String getApplicationName(Message message) {
		Object applicationName =  message.getMessageProperties().getHeaders().get(HDR_APPLICATION_NAME);
		return String.valueOf(applicationName);
	}
}
