package com.like.system.dept.application.port.in.save;

import java.util.Optional;

import org.jspecify.annotations.Nullable;

import com.like.common.vo.LocalDatePeriod;
import com.like.system.dept.domain.Dept;

public class DeptSaveDTOMapper {

	public static DeptSaveDTO toDTO(Dept entity) {							
		
		if (entity == null) return null;
		
		Optional<Dept> parent = Optional.ofNullable(entity.parentDept());
		Optional<LocalDatePeriod> period= Optional.ofNullable(entity.period());
		
		DeptSaveDTO dto = DeptSaveDTO.builder()
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
	
	public static Dept toEntity(DeptSaveDTO dto, @Nullable Dept parentDept) {
		if (dto.companyCode() == null) new IllegalArgumentException("조직코드가 없습니다.");
		if (dto.deptCode() == null) new IllegalArgumentException("부서코드가 없습니다.");
		
		Dept entity = Dept.builder(dto.companyCode(), dto.deptCode())									   					  
						   .deptNameKorean(dto.deptNameKorean())
						   .deptAbbreviationKorean(dto.deptAbbreviationKorean())
						   .deptNameEnglish(dto.deptNameEnglish())
						   .deptAbbreviationEnglish(dto.deptAbbreviationEnglish())
						   .period(new LocalDatePeriod(dto.fromDate(), dto.toDate()))					   
						   .seq(dto.seq())
						   .comment(dto.comment())
						   .parentDept(parentDept)
						   .parentDeptCode(parentDept == null ? null : parentDept.id().deptCode())
						   .build();
				
		return entity;
	}
	
	public static Dept modifyEntity(Dept dept, DeptSaveDTO dto, @Nullable Dept parentDept) {
		if (dto.companyCode() == null) new IllegalArgumentException("조직코드가 없습니다.");
		if (dto.deptCode() == null) new IllegalArgumentException("부서코드가 없습니다.");
		
		dept.modifyBuilder()		
			.deptNameKorean(dto.deptNameKorean())
			.deptAbbreviationKorean(dto.deptAbbreviationKorean())
			.deptNameEnglish(dto.deptNameEnglish())
			.deptAbbreviationEnglish(dto.deptAbbreviationEnglish())
			.period(new LocalDatePeriod(dto.fromDate(), dto.toDate()))					   
			.seq(dto.seq())
			.comment(dto.comment())
			.parentDept(parentDept)
			.build();
				
		return dept;
	}
	
	
}
