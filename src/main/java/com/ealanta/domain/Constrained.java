package com.ealanta.domain;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

public class Constrained {

	@DecimalMin("0")
	@DecimalMax("150")
	private int age;

	@Pattern(regexp = "[A-Z]{4}")
	private String nino;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNino() {
		return nino;
	}

	public void setNino(String nino) {
		this.nino = nino;
	}

	@Override
	public String toString() {
		return "Constrained [age=" + age + ", nino=" + nino + "]";
	}

}
