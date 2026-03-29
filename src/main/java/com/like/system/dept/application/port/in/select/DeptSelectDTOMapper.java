package com.like.system.dept.application.port.in.select;

import java.util.Optional;

import com.like.common.vo.LocalDatePeriod;
import com.like.system.dept.domain.Dept;

public class DeptSelectDTOMapper {

	public static DeptSelectDTO toDTO(Dept entity) {							
		
		if (entity == null) return null;
		
		Optional<Dept> parent = Optional.ofNullable(entity.parentDept());
		Optional<LocalDatePeriod> period= Optional.ofNullable(entity.period());
		
		DeptSelectDTO dto = DeptSelectDTO.builder()
							   .createdDt(entity.getCreatedDt())
							   .createdBy(entity.getCreatedBy().getLoggedUser())
							   .modifiedDt(entity.getModifiedDt())
							   .modifiedBy(entity.getModifiedBy().getLoggedUser())								  
							   .companyCode(entity.id().companyCode())
							   .deptCode(entity.id().deptCode())
							   .parentDeptCode(parent.map(r -> r.id().deptCode()).orElse(null))
							   .deptNameKorean(entity.deptNameKorean())
							   .deptAbbreviationKorean(entity.deptAbbreviationKorean())
							   .deptNameEnglish(entity.deptNameEnglish())
							   .deptAbbreviationEnglish(entity.deptAbbreviationEnglish())
							   .fromDate(period.map(LocalDatePeriod::from).orElse(null))
							   .toDate(period.map(LocalDatePeriod::to).orElse(null))
							   .seq(entity.seq())
							   .comment(entity.comment())
							   .build();		
		return dto;		
	}
	
}
