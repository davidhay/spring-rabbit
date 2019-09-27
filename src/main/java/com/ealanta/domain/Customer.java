package com.ealanta.domain;

public class Customer {
	
	private String first;
	private String last;
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public String toString() {
		return "Customer [first=" + first + ", last=" + last + "]";
	}
	
	
}
