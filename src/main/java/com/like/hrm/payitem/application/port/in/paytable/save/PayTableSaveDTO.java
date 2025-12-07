package com.like.hrm.payitem.application.port.in.paytable.save;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;

@Builder
public record PayTableSaveDTO(
		String clientAppUrl,
		String id,
		String companyCode,
		String payItemCode,
		LocalDate effectiveDate,
		String occupationCode,
		String jobGradeCode,
		String payStepCode,
		BigDecimal wageAmount,
		Boolean isEnable,
		String comment
		) {

}
