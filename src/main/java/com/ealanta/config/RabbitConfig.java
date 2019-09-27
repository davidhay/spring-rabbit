package com.ealanta.config;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ealanta.rabbit.MessageUtils;
import com.ealanta.rabbit.QueueMonitor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RabbitConfig {
    
	@Value("${application.name}")
	private String applicationName;
	
	@Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    
    @Bean
    @ConditionalOnProperty(
    	    value="queue.monitor.enabled", 
    	    havingValue = "true", 
    	    matchIfMissing = false)
    public QueueMonitor queueChecker(AmqpAdmin rabbitAdmin) {
    	return new QueueMonitor(rabbitAdmin);
    }
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    private MessageUtils msgUtils;

    
    @PostConstruct
    public void init() {
    	log.info("CALLING POST CONSTRUCT ON CONFIGURATION");
        this.rabbitTemplate.setBeforePublishPostProcessors(outboundPostProcessor());
        this.rabbitTemplate.setAfterReceivePostProcessors(inboundPostProcessor());
    }

    /**
     * NOTE : the post processing is AFTER Conversion to JSON
     */
    @Bean
    public MessagePostProcessor outboundPostProcessor() {
        return message -> {
        	String body = msgUtils.extractContent(message);
        	log.info("outbound post processing [{}]", body);
        	msgUtils.setApplicationName(message, applicationName);
        	return message;
        };
    }
    
    /**
     * NOTE : the post processing is BEFORE Conversion from JSON
     */
    @Bean
    public MessagePostProcessor inboundPostProcessor() {
        return message -> {
        	String body = msgUtils.extractContent(message);
        	log.info("inbound processing [{}] from applicationName[{}]", body, msgUtils.getApplicationName(message));
        	return message;
        };
    }
}