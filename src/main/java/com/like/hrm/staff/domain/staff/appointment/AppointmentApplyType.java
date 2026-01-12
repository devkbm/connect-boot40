package com.like.hrm.staff.domain.staff.appointment;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.stream.Streams;

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
	
	public static AppointmentApplyType of(final String code) {
		return Optional.ofNullable(CODE_MAP.get(code))
				.orElse(RESERVATION);
	}
	
	// 코드로 ENUM을 조회하기 위 한 MAP 생성
	public static final Map<String, AppointmentApplyType> CODE_MAP = Collections.unmodifiableMap(
			Streams.of(values()).collect(Collectors.toMap(AppointmentApplyType::getCode, Function.identity()))
			);
		
}
