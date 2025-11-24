package com.like.system.menu_role.application.port.in.menu_role.save;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record MenuRoleMappingSaveDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,	
		String companyCode,
		String menuGroupCode,
		String menuCode,
		String roleCode
		) {
	
}
