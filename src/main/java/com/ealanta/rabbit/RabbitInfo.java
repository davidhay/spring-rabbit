package com.ealanta.rabbit;

import java.util.List;
import java.util.Arrays;

public class RabbitInfo {

	public static final String QUEUE_TEST_1 = "test1";
	public static final String QUEUE_TEST_2 = "test2";
	public static final String QUEUE_TEST_3 = "test3";
	public static final String QUEUE_CUSTOMERS = "customers";
	public static final List<String> QUEUE_NAMES = Arrays.asList(QUEUE_TEST_1, QUEUE_TEST_2, QUEUE_TEST_3, QUEUE_CUSTOMERS);
	
	public static boolean isValidQueueName(String name) {
		return QUEUE_NAMES.contains(name);
	}
}
