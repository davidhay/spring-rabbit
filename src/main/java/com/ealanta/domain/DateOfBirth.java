package com.ealanta.domain;

import lombok.Data;

@Data
public class DateOfBirth {
	private final int day;
	private final int month;
	private final int year;
	private String extra;
}
