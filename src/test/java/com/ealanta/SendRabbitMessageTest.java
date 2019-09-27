package com.ealanta;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendRabbitMessageTest {
		
	@Autowired
	private RabbitTemplate template;

	@Test
	public void testSendMessage() {
		DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime now = LocalDateTime.now();
		String time = fmt.format(now);
		MessageProperties props = new MessageProperties();
		Message message = new Message(time.getBytes(StandardCharsets.UTF_8), props);
		
		template.send(RabbitInfo.QUEUE_TEST_1, message);		
	}
}
