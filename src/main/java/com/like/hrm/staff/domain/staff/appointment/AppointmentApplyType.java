package com.like.hrm.staff.domain.staff.appointment;

import jakarta.persistence.EnumeratedValue;
import lombok.Getter;

@Getter
public enum AppointmentApplyType {
	RESERVATION("10", "예약적용"),
	DIRECTLY("02", "즉시적용")
	;
	
	@EnumeratedValue
	private String code;
	private String description;
	
	AppointmentApplyType(String code, String description) {
		this.code = code;
		this.description = description;
	}
		
}
