package com.ealanta.config;

import static com.ealanta.rabbit.RabbitInfo.PUBSUB_TYPE1_QUEUE_NAMES;
import static com.ealanta.rabbit.RabbitInfo.PUBSUB_TYPE2_QUEUE_NAMES;
import static com.ealanta.rabbit.RabbitInfo.PUB_SUB_MAIN_EX;
import static com.ealanta.rabbit.RabbitInfo.PUB_SUB_TYPE1_ROUTING_KEY;
import static com.ealanta.rabbit.RabbitInfo.PUB_SUB_TYPE2_ROUTING_KEY;
import static com.ealanta.rabbit.RabbitInfo.QUEUE_CUSTOMERS;
import static com.ealanta.rabbit.RabbitInfo.QUEUE_TEST_1;
import static com.ealanta.rabbit.RabbitInfo.QUEUE_TEST_2;
import static com.ealanta.rabbit.RabbitInfo.QUEUE_TEST_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This creates the Queues on demand if they don't already exist!
 * 
 * @author davidhay
 *
 */
@Component
public class RabbitQueuesExchangesAndBindingsConfig {

	private AmqpAdmin amqpAdmin;

	@Autowired
	public RabbitQueuesExchangesAndBindingsConfig(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin;
	}

	@PostConstruct
	public void createQueues() {

		Queue queue1 = new Queue(QUEUE_TEST_1, true);
		Queue queue2 = new Queue(QUEUE_TEST_2, true);
		Queue queue3 = new Queue(QUEUE_TEST_3, true);
		Queue queueCustomer = new Queue(QUEUE_CUSTOMERS, true);

		amqpAdmin.declareQueue(queue1);
		amqpAdmin.declareQueue(queue2);
		amqpAdmin.declareQueue(queue3);
		amqpAdmin.declareQueue(queueCustomer);
		
		Map<String,List<String>> queueNamesPerMessageType = new HashMap<>();
		
		queueNamesPerMessageType.put(PUB_SUB_TYPE1_ROUTING_KEY, PUBSUB_TYPE1_QUEUE_NAMES);
		queueNamesPerMessageType.put(PUB_SUB_TYPE2_ROUTING_KEY, PUBSUB_TYPE2_QUEUE_NAMES);
		
		createPubSubQueues(PUB_SUB_MAIN_EX, queueNamesPerMessageType);
	}
	
	private void createPubSubQueues(String pubSubExchangeName, Map<String,List<String>> queueNamesPerType) {
		boolean durable = true;
		boolean autoDelete = false;
		
		TopicExchange mainPubSubEx = new TopicExchange(pubSubExchangeName, durable, autoDelete);

		amqpAdmin.declareExchange(mainPubSubEx);
				
		queueNamesPerType.entrySet().forEach( me -> {
			String type = me.getKey();
			List<String> queueNames = me.getValue();
			
			createPubSubQueuesForMessageType(mainPubSubEx, type, queueNames);			
		});
	}

	public void createPubSubQueuesForMessageType(TopicExchange mainPubSubEx, String type, List<String> queueNames) {
		queueNames.stream().forEach(queueName -> {
			Queue queue = new Queue(queueName, true);
			
			amqpAdmin.declareQueue(queue);
			Binding bindQueueToMainWithTypeAsRoutingKey = BindingBuilder.bind(queue).to(mainPubSubEx)
					.with(type);
			
			amqpAdmin.declareBinding(bindQueueToMainWithTypeAsRoutingKey);
		});
	}
}