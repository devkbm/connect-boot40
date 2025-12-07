package com.like.hrm.payitem.application.port.in.payitem.select;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PayItemSelectDTO {
	String clientAppUrl;
	String companyCode;
	String payItemCode;
	String payItemName;
	String type;
	Boolean usePayTable;
	Integer seq;
	String comment;		
}
