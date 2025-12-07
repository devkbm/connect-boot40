package com.like.hrm.payitem.application.port.in.payitem.save;

import lombok.Builder;

@Builder
public record PayItemSaveDTO(
		String clientAppUrl,
		String companyCode,
		String payItemCode,
		String payItemName,
		String type,
		Boolean usePayTable,
		Integer seq,
		String comment
		) {
}
