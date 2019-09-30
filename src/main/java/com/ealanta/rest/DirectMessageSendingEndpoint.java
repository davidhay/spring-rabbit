package com.ealanta.rest;

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

import com.ealanta.domain.Constrained;
import com.ealanta.domain.Customer;
import com.ealanta.rabbit.RabbitInfo;
import com.ealanta.rabbit.RabbitMessageToDirectExchangeSender;

@RestController
public class DirectMessageSendingEndpoint {

	@Autowired
	private RabbitMessageToDirectExchangeSender sender;

	@RequestMapping(value = {
			"sendSimple/{queueName}/{message}",
			"sendSimple/{queueName}"}, 
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
			sender.sendPlainTextMessageToDirectExchange(queueName, msg, optCorrId);
			result = ResponseEntity.accepted().body(
					String.format("Sent Message[%s] to q[%s]", msg, queueName));
		} else {
			result = ResponseEntity.badRequest().body(
					String.format("The qNname[%s] is invalid - it can only be %s", queueName, RabbitInfo.QUEUE_NAMES));
		}
		return result;
	}
	
	@RequestMapping(value = {
			"sendCustomer/{first}/{last}",
			"sendCustomer"}, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> sendSimple(
			@PathVariable("first") Optional<String> optFirst,
			@PathVariable("last")Optional<String>  optLast) {
		
		String first = optFirst.orElseGet(() -> "f"+UUID.randomUUID().toString());
		String last = optLast.orElseGet(() -> "l"+UUID.randomUUID().toString());
		
		Customer customer = new Customer();
		customer.setFirst(first);
		customer.setLast(last);
		
		String qName = RabbitInfo.QUEUE_CUSTOMERS;
		final ResponseEntity<String> result;
			sender.sendCustomer(qName, customer);
			result = ResponseEntity.accepted().body(
					String.format("Sent Message[%s] to q[%s]", customer, qName));
		return result;
	}

	@RequestMapping(value = {
			"sendConstrained/{age}/{nino}" }, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> sendConstrained(
			@PathVariable("age") int age,
			@PathVariable("nino")  String  nino) {
		

		Constrained constrained = new Constrained();
		constrained.setAge(age);
		constrained.setNino(nino);
		
		String qName = RabbitInfo.QUEUE_VALIDATED;
		final ResponseEntity<String> result;
			sender.sendConstrained(qName, constrained);
			result = ResponseEntity.accepted().body(
					String.format("Sent Message[%s] to q[%s]", constrained, qName));
		return result;
	}

	private String getNow() {
		DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE_TIME;
		String result = fmt.format(LocalDateTime.now().atZone(ZoneId.of("Europe/London")));
		return result;
	}
}
