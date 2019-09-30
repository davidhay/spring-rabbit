package com.ealanta.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ealanta.rabbit.RabbitInfo;
import com.ealanta.rabbit.RabbitMessageToDirectExchangeSender;

@RestController
public class EsrSendingMessageEndpoint {

	@Autowired
	private RabbitMessageToDirectExchangeSender directExchangeSender;

	@PostMapping(value = {
			"sendJsonPOSMessage" }, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> sendPosMessage(@RequestBody String body) {
		return sendEsrMessage(RabbitInfo.QUEUE_ESR_POS, body, "Position");
	}

	@PostMapping(value = {
			"sendJsonPORMessage" }, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> sendPorMessage(@RequestBody String body) {
		return sendEsrMessage(RabbitInfo.QUEUE_ESR_POR, body, "Reconcilliation");
	}

	private ResponseEntity<String> sendEsrMessage(String queueName, String body, String type) {
		final ResponseEntity<String> result;
		directExchangeSender.sendJsonMessageToDirectExchange(type, queueName, body, Optional.empty());
		result = ResponseEntity.accepted()
				.body(String.format("Sent Esr Message[%s] type[%s] q[%s]", body, type, queueName));
		return result;
	}

}
