package com.like.hrm.payitem.application.port.in.paytable.select;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayTableSelectDTO {
	String clientAppUrl;
	String id;
	String companyCode;
	String payItemCode;
	LocalDate effectiveDate;
	String occupationCode;
	String jobGradeCode;
	String payStepCode;
	BigDecimal wageAmount;
	Boolean isEnable;
	String comment;	
}
