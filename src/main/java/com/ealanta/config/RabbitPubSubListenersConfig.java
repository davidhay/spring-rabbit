package com.ealanta.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.ealanta.rabbit.MessageUtils;
import com.ealanta.rabbit.RabbitInfo;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RabbitPubSubListenersConfig {

	@Autowired
	private MessageUtils msgUtils;
	
	
	@RabbitListener(queues = {RabbitInfo.QUEUE_PUBSUB_TYPE1Q1})
	public void receiveType1Queue1(Message message) {
		recvdPubSubMessage("type1",message);
	}
	@RabbitListener(queues = {RabbitInfo.QUEUE_PUBSUB_TYPE1Q2})
	public void receiveType1Queue2(Message message) {
		recvdPubSubMessage("type1",message);
	}	
	@RabbitListener(queues = {RabbitInfo.QUEUE_PUBSUB_TYPE1Q3})
	public void receiveType1Queue3(Message message) {
		recvdPubSubMessage("type1",message);
	}	
	@RabbitListener(queues = {RabbitInfo.QUEUE_PUBSUB_TYPE2Q1})
	public void receiveType2Queue1(Message message) {
		recvdPubSubMessage("type2",message);
	}
	@RabbitListener(queues = {RabbitInfo.QUEUE_PUBSUB_TYPE2Q2})
	public void receiveType2Queue2(Message message) {
		recvdPubSubMessage("type2",message);
	}
	@RabbitListener(queues = {RabbitInfo.QUEUE_PUBSUB_ALL})
	public void receiveAllQueue(Message message) {
		recvdPubSubMessage("ALL",message);
	}
		
	private void recvdPubSubMessage(String type,Message message){
		String msgContent = msgUtils.extractContent(message);
		
		MessageProperties props = message.getMessageProperties();
		Map<String,String> info = new LinkedHashMap<>();

		info.put("msg", msgContent);
		info.put("type", type);
		info.put("routingKey", props.getReceivedRoutingKey());
		info.put("consumerQueue", props.getConsumerQueue());
		
		log.info("PubSub:Recvd {}", StringUtils.join(info));
	}
}
