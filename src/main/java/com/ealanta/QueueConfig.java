package com.ealanta;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * This creates the Queues on demand if they don't already exist!
 * @author davidhay
 *
 */
@Component
public class QueueConfig {

    private AmqpAdmin amqpAdmin;

    @Autowired
    public QueueConfig(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    @PostConstruct
    public void createQueues() {
        amqpAdmin.declareQueue(new Queue(RabbitInfo.QUEUE_TEST_1, true));
        amqpAdmin.declareQueue(new Queue(RabbitInfo.QUEUE_TEST_2, true));
        amqpAdmin.declareQueue(new Queue(RabbitInfo.QUEUE_TEST_3, true));
        amqpAdmin.declareQueue(new Queue(RabbitInfo.QUEUE_CUSTOMERS, true));
    }
    
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}