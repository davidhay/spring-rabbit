package com.ealanta.rest;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ealanta.rabbit.RabbitMessageToPubSubExchangeSender;

@RestController
public class PubSubMessageSendingEndpoint {

	@Autowired
	private RabbitMessageToPubSubExchangeSender pubSubSender;

	@RequestMapping(value = {
			"sendPubSub/{type}/{message}",
			"sendPubSub/{type}"},
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> sendPubSub(
			@PathVariable("type") String type,
			@PathVariable("message") Optional<String>  optMesssage) {
		
		String msg = optMesssage.orElseGet(() -> "msg"+UUID.randomUUID().toString());
	
		final ResponseEntity<String> result;
			pubSubSender.sendMessageToPubSubExchange(type, msg);
			result = ResponseEntity.accepted().body(
					String.format("Sent Pub/Sub Message[%s] of type[%s]", msg, type));
		return result;
	}
}
