package com.ealanta.rabbit;

import java.util.List;
import java.util.Arrays;

public class RabbitInfo {

	public static final String PUB_SUB_MAIN_EX = "main";
	public static final String PUB_SUB_TYPE1_EX = "type1.ex";
	public static final String PUB_SUB_TYPE2_EX = "type2.ex";
	public static final String PUB_SUB_TYPE1_ROUTING_KEY = "type1";
	public static final String PUB_SUB_TYPE2_ROUTING_KEY = "type2";
	
	public static final String QUEUE_TEST_1 = "test1";
	public static final String QUEUE_TEST_2 = "test2";
	public static final String QUEUE_TEST_3 = "test3";
	public static final String QUEUE_CUSTOMERS = "customers";
	
	public static final String QUEUE_PUBSUB_TYPE1Q1 = "type1queue1";
	public static final String QUEUE_PUBSUB_TYPE1Q2 = "type1queue2";
	public static final String QUEUE_PUBSUB_TYPE2Q1 = "type2queue1";
	public static final String QUEUE_PUBSUB_TYPE2Q2 = "type2queue2";
	public static final List<String> QUEUE_NAMES = Arrays.asList(
			QUEUE_TEST_1, QUEUE_TEST_2, QUEUE_TEST_3, QUEUE_CUSTOMERS,
			QUEUE_PUBSUB_TYPE1Q1,
			QUEUE_PUBSUB_TYPE1Q2,
			QUEUE_PUBSUB_TYPE2Q1,
			QUEUE_PUBSUB_TYPE2Q2
			);
	
	public static boolean isValidQueueName(String name) {
		return QUEUE_NAMES.contains(name);
	}
}
