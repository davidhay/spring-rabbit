package com.ealanta.config;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ealanta.rabbit.RabbitInfo;

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

		Queue queue1 = new Queue(RabbitInfo.QUEUE_TEST_1, true);
		Queue queue2 = new Queue(RabbitInfo.QUEUE_TEST_2, true);
		Queue queue3 = new Queue(RabbitInfo.QUEUE_TEST_3, true);
		Queue queueCustomer = new Queue(RabbitInfo.QUEUE_CUSTOMERS, true);

		Queue queuePubSubT1Q1 = new Queue(RabbitInfo.QUEUE_PUBSUB_TYPE1Q1, true);
		Queue queuePubSubT1Q2 = new Queue(RabbitInfo.QUEUE_PUBSUB_TYPE1Q2, true);
		Queue queuePubSubT1Q3 = new Queue(RabbitInfo.QUEUE_PUBSUB_TYPE1Q3, true);
		Queue queuePubSubT2Q1 = new Queue(RabbitInfo.QUEUE_PUBSUB_TYPE2Q1, true);
		Queue queuePubSubT2Q2 = new Queue(RabbitInfo.QUEUE_PUBSUB_TYPE2Q2, true);

		amqpAdmin.declareQueue(queue1);
		amqpAdmin.declareQueue(queue2);
		amqpAdmin.declareQueue(queue3);
		amqpAdmin.declareQueue(queueCustomer);
		amqpAdmin.declareQueue(queuePubSubT1Q1);
		amqpAdmin.declareQueue(queuePubSubT1Q2);
		amqpAdmin.declareQueue(queuePubSubT1Q3);
		amqpAdmin.declareQueue(queuePubSubT2Q1);
		amqpAdmin.declareQueue(queuePubSubT2Q2);

		boolean durable = true;
		boolean autoDelete = false;

		TopicExchange mainPubSubEx = new TopicExchange(RabbitInfo.PUB_SUB_MAIN_EX, durable, autoDelete);

		amqpAdmin.declareExchange(mainPubSubEx);

		
		//BIND type1 queues direct to main
		Binding bindingT1Q1directToMain = BindingBuilder.bind(queuePubSubT1Q1).to(mainPubSubEx)
				.with(RabbitInfo.PUB_SUB_TYPE1_ROUTING_KEY);

		Binding bindingT1Q2directToMain = BindingBuilder.bind(queuePubSubT1Q2).to(mainPubSubEx)
				.with(RabbitInfo.PUB_SUB_TYPE1_ROUTING_KEY);
		
		Binding bindingT1Q3directToMain = BindingBuilder.bind(queuePubSubT1Q3).to(mainPubSubEx)
				.with(RabbitInfo.PUB_SUB_TYPE1_ROUTING_KEY);
		
		//BIND type2 queues direct to main
		Binding bindingT2Q1directToMain = BindingBuilder.bind(queuePubSubT2Q1).to(mainPubSubEx)
				.with(RabbitInfo.PUB_SUB_TYPE2_ROUTING_KEY);

		Binding bindingT2Q2directToMain = BindingBuilder.bind(queuePubSubT2Q2).to(mainPubSubEx)
				.with(RabbitInfo.PUB_SUB_TYPE2_ROUTING_KEY);
		
		//Q to topic direct binding
		amqpAdmin.declareBinding(bindingT1Q1directToMain);
		amqpAdmin.declareBinding(bindingT1Q2directToMain);
		amqpAdmin.declareBinding(bindingT1Q3directToMain);
		
		amqpAdmin.declareBinding(bindingT2Q1directToMain);
		amqpAdmin.declareBinding(bindingT2Q2directToMain);
	}

}