package com.ealanta.config;

import javax.validation.Valid;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

import com.ealanta.generated.cli.PORSchema;
import com.ealanta.generated.cli.PositionSchema;
import com.ealanta.rabbit.MessageUtils;
import com.ealanta.rabbit.RabbitInfo;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RabbitEsrListenersConfig {

	@Autowired
	private MessageUtils msgUtils;

	@RabbitListener(queues = RabbitInfo.QUEUE_ESR_POS, errorHandler = "myErrorHandler")
	public void receivePOS(@Valid @Payload PositionSchema pos, Message msg) {
		log.info("VALID POS RECVD [{}] from[{}]", pos, msgUtils.getApplicationName(msg));
	}
	
	@RabbitListener(queues = RabbitInfo.QUEUE_ESR_POR, errorHandler = "myErrorHandler")
	public void receivePOS(@Valid @Payload PORSchema por, Message msg) {
		log.info("VALID POR RECVD [{}] from[{}]", por, msgUtils.getApplicationName(msg));
	}

}
