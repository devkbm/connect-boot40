package com.like.common.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PhoneNumber {

	@Column(name="PHONE_NO")
	private String number;
	
	public PhoneNumber(String number) {
		this.number = number;
	}
	
	protected PhoneNumber() {}
	
	public String number() {
		return number;
	}
	
	public String getPhoneNumber() {
		return this.number;
	}
	
}
