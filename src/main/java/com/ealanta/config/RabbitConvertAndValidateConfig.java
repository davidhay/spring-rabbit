package com.ealanta.config;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.validation.Validator;

@Configuration
public class RabbitConvertAndValidateConfig {

	private Logger logger = LoggerFactory.getLogger(RabbitConvertAndValidateConfig.class);

	@Autowired
	private Validator validator;

	@Bean
	public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setValidator(this.validator);
		return factory;
	}

	@Bean
	public Jackson2JsonMessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitListenerErrorHandler myErrorHandler() {
		return new RabbitListenerErrorHandler() {

			@Override
			public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message,
					ListenerExecutionFailedException ex) throws Exception {
				Throwable cause = ex.getCause();
				if (cause instanceof ConstraintViolationException) {
					ConstraintViolationException consEx = (ConstraintViolationException) cause;
					logger.info("CONSTRAINT VIOLATION {}", consEx.getMessage());
				} else {
					ex.printStackTrace();
				}
				return null;
			}
		};
	}

}