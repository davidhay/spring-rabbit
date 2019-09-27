package com.ealanta;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageSendingEndpoint {

	@Autowired
	private RabbitMessageToExchangeSender sender;

	@RequestMapping(value = {"sendSimple/{queueName}/{message}","sendSimple/{queueName}"}, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> sendSimple(
			@PathVariable("queueName") String queueName,
			@PathVariable("message")Optional<String>  message) {
		
		String msg = message.orElseGet(this::getNow);
		
		final ResponseEntity<String> result;
		if (RabbitInfo.isValidQueueName(queueName)) {
			Optional<String> optCorrId;
			if(RabbitInfo.QUEUE_TEST_1.equals(queueName)) {
				optCorrId = Optional.of("abcd"+UUID.randomUUID().toString());
			} else {
				optCorrId = Optional.empty();
			}
			sender.sendMessageToDirectExchange(queueName, msg, optCorrId);
			result = ResponseEntity.accepted().body(
					String.format("Sent Message[%s] to q[%s]", msg, queueName));
		} else {
			result = ResponseEntity.badRequest().body(
					String.format("The qNname[%s] is invalid - it can only be %s", queueName, RabbitInfo.QUEUE_NAMES));
		}
		return result;
	}
	
	public String getNow() {
		DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE_TIME;
		String result = fmt.format(LocalDateTime.now().atZone(ZoneId.of("Europe/London")));
		return result;
	}

}
