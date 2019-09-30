package com.ealanta.config;

import javax.validation.Valid;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.validation.annotation.Validated;

import com.ealanta.domain.Constrained;
import com.ealanta.rabbit.MessageUtils;
import com.ealanta.rabbit.RabbitInfo;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@Validated
public class RabbitValidatingListenersConfig {

	@Autowired
	private MessageUtils msgUtils;

	@RabbitListener(queues = RabbitInfo.QUEUE_VALIDATED, errorHandler = "myErrorHandler" )
	public void receiveCustomer(@Valid @Payload Constrained domain, Message msg) {
		log.info("RECVD [{}] from[{}]", domain, msgUtils.getApplicationName(msg));
	}
}
