package com.ealanta.domain;

public class DateOfBirth {

	private final int day;
	private final int month;
	private final int year;
	private String extra;
	
	public DateOfBirth(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	@Override
	public String toString() {
		return "DateOfBirth [day=" + day + ", month=" + month + ", year=" + year + ", extra=" + extra + "]";
	}
}
