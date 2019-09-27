package com.ealanta;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitQueueSubscribers {

	@Autowired
	private MessageUtils msgUtils;
	
	@RabbitListener(queues = {RabbitInfo.QUEUE_TEST_1, RabbitInfo.QUEUE_TEST_2})
	public void receiveMessage1(Message message) {
		recvdMessage(message);
	}
		
	private void recvdMessage(Message message){
		String msgContent = msgUtils.extractContent(message);
		MessageProperties props = message.getMessageProperties();
		
		Map<String,String> info = new LinkedHashMap<>();

		info.put("msg", msgContent);
		info.put("routingKey", props.getReceivedRoutingKey());
		info.put("consumerQueue", props.getConsumerQueue());
		info.put("corrId", props.getCorrelationId());
		info.put("contentType", props.getContentType());
		info.put("length", String.valueOf(props.getContentLength()));
		
		System.out.printf("RECVD %s", StringUtils.join(info));
	}

}
