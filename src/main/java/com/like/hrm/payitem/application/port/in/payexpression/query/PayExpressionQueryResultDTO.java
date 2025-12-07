package com.like.hrm.payitem.application.port.in.payexpression.query;

import lombok.Data;

@Data
public class PayExpressionQueryResultDTO {

	String id;
	String companyCode;
	String payItemCode;
	String payItemName;
	String payCondition;
	String formula;
	Long seq;
	String comment;
}
