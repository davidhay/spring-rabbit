package com.ealanta.config;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.FanoutExchange;
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
		Queue queuePubSubT2Q1 = new Queue(RabbitInfo.QUEUE_PUBSUB_TYPE2Q1, true);
		Queue queuePubSubT2Q2 = new Queue(RabbitInfo.QUEUE_PUBSUB_TYPE2Q2, true);

		amqpAdmin.declareQueue(queue1);
		amqpAdmin.declareQueue(queue2);
		amqpAdmin.declareQueue(queue3);
		amqpAdmin.declareQueue(queueCustomer);
		amqpAdmin.declareQueue(queuePubSubT1Q1);
		amqpAdmin.declareQueue(queuePubSubT1Q2);
		amqpAdmin.declareQueue(queuePubSubT2Q1);
		amqpAdmin.declareQueue(queuePubSubT2Q2);

		boolean durable = true;
		boolean autoDelete = false;

		TopicExchange mainPubSubEx = new TopicExchange(RabbitInfo.PUB_SUB_MAIN_EX, durable, autoDelete);
		FanoutExchange fanPubSubType1Ex = new FanoutExchange(RabbitInfo.PUB_SUB_TYPE1_EX, durable, autoDelete);
		FanoutExchange fanPubSubType2Ex = new FanoutExchange(RabbitInfo.PUB_SUB_TYPE2_EX, durable, autoDelete);

		amqpAdmin.declareExchange(mainPubSubEx);
		amqpAdmin.declareExchange(fanPubSubType1Ex);
		amqpAdmin.declareExchange(fanPubSubType2Ex);

		Binding bindingT1Q1toType1Ex = BindingBuilder.bind(queuePubSubT1Q1).to(fanPubSubType1Ex);
		Binding bindingT1Q2toType1Ex = BindingBuilder.bind(queuePubSubT1Q2).to(fanPubSubType1Ex);
		
		Binding bindingT2Q1toType2Ex = BindingBuilder.bind(queuePubSubT2Q1).to(fanPubSubType2Ex);
		Binding bindingT2Q2toType2Ex = BindingBuilder.bind(queuePubSubT2Q2).to(fanPubSubType2Ex);

		Binding bindingType1ToMain = BindingBuilder.bind(fanPubSubType1Ex).to(mainPubSubEx)
				.with(RabbitInfo.PUB_SUB_TYPE1_ROUTING_KEY);

		Binding bindingType2ToMain = BindingBuilder.bind(fanPubSubType2Ex).to(mainPubSubEx)
				.with(RabbitInfo.PUB_SUB_TYPE2_ROUTING_KEY);

		amqpAdmin.declareBinding(bindingT1Q1toType1Ex);
		amqpAdmin.declareBinding(bindingT1Q2toType1Ex);
		
		amqpAdmin.declareBinding(bindingT2Q1toType2Ex);
		amqpAdmin.declareBinding(bindingT2Q2toType2Ex);
		
		amqpAdmin.declareBinding(bindingType1ToMain);
		amqpAdmin.declareBinding(bindingType2ToMain);
	}

}