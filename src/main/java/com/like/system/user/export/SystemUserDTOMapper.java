package com.like.system.user.export;

import java.util.Optional;

import com.like.system.dept.domain.Dept;
import com.like.system.dept.domain.DeptId;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserCompany;

import jakarta.persistence.EntityNotFoundException;

public class SystemUserDTOMapper {

	public static SystemUserDTO toDTO(SystemUser entity, String companyCode) {						
		if (entity == null) return null;
		
		SystemUserCompany company = entity.getCompanyInfo(companyCode).orElseThrow(() -> new EntityNotFoundException("회사 정보가 없습니다."));
		
		Optional<Dept> dept = Optional.ofNullable(company.dept());			
		
		SystemUserDTO dto = SystemUserDTO.builder()								
										 .companyCode(company.id().companyCode())
										 .userId(entity.id().userId())										 
										 .name(entity.name())										 
										 .mobileNum(entity.mobileNum())
										 .email(entity.email())
										 .imageBase64(entity.getImage())
										 .enabled(true)											 
										 .staffNo(entity.id().userId())
										 //.deptCode(dept.map(r -> r.id().deptCode()).orElse(""))			
										 .deptCode(dept.map(Dept::id).map(DeptId::deptCode).orElse(""))
										 .deptName(dept.map(Dept::deptNameKorean).orElse(""))
										 .roleList(entity.getRoleList(companyCode)
												   		 .stream()
														 .map(auth -> auth.getAuthority())
														 .toList())										   
										 .build();
		
		return dto;
	}
}
