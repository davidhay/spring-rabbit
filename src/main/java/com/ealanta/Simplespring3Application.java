package com.ealanta;

import java.nio.charset.StandardCharsets;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Simplespring3Application {

	@RabbitListener(queues = {"test1","test2"})
	public void receiveMessage1(Message message) {
	    System.out.printf("msg from test1 [%s]%n",new String(message.getBody(),StandardCharsets.UTF_8));
	}
	
	@RabbitListener(queues = {"test2"})
	public void receiveMessage2(Message message) {
	    System.out.printf("msg from test2 [%s]%n",new String(message.getBody(),StandardCharsets.UTF_8));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Simplespring3Application.class, args);
	}	
}
