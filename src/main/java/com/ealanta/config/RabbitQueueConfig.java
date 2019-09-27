package com.ealanta.config;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ealanta.rabbit.RabbitInfo;


/**
 * This creates the Queues on demand if they don't already exist!
 * @author davidhay
 *
 */
@Component
public class RabbitQueueConfig {

    private AmqpAdmin amqpAdmin;

    @Autowired
    public RabbitQueueConfig(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    @PostConstruct
    public void createQueues() {
        amqpAdmin.declareQueue(new Queue(RabbitInfo.QUEUE_TEST_1, true));
        amqpAdmin.declareQueue(new Queue(RabbitInfo.QUEUE_TEST_2, true));
        amqpAdmin.declareQueue(new Queue(RabbitInfo.QUEUE_TEST_3, true));
        amqpAdmin.declareQueue(new Queue(RabbitInfo.QUEUE_CUSTOMERS, true));
    }
    
}