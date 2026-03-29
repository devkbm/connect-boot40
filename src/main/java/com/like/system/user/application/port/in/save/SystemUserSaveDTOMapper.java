package com.like.system.user.application.port.in.save;

import java.util.Optional;

import com.like.system.dept.domain.Dept;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserCompany;

import jakarta.persistence.EntityNotFoundException;

public class SystemUserSaveDTOMapper {

	public static SystemUserSaveDTO toDTO(SystemUser entity, String companyCode) {					
		
		if (entity == null) return null;
		
		SystemUserCompany company = entity.getCompanyInfo(companyCode).orElseThrow(() -> new EntityNotFoundException("회사 정보가 없습니다."));
		
		Optional<Dept> dept = Optional.ofNullable(company.dept());			
		
		SystemUserSaveDTO dto = SystemUserSaveDTO.builder()																		   
										   .userId(entity.id().userId())
										   .name(entity.name())												   										   
										   .mobileNum(entity.mobileNum())
										   .email(entity.email())
										   .imageBase64(entity.getImage())
										   .enabled(true)	
										   //.accountNonExpired(entity.isAccountNonExpired())
										   //.accountNonLocked(entity.isAccountNonLocked())
										   //.credentialsNonExpired(entity.isCredentialsNonExpired())
										   .companyCode(company.id().companyCode())
										   .staffNo(entity.id().userId())
										   .deptCode(dept.map(r -> r.id().deptCode()).orElse(""))
										   .deptName(dept.map(Dept::deptNameKorean).orElse(""))
										   .roleList(entity.getRoleList(companyCode)
														   .stream()
														   .map(auth -> auth.getAuthority())
														   .toList())										   
										   .build();
		
		return dto;
	}
	
	
	
}
