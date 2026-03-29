package com.like.system.user.application.port.in.profile;

import com.like.system.user.domain.SystemUser;

public class SystemUserProfileSelectDTOMapper {

	public static SystemUserProfileSelectDTO toDTO(SystemUser entity, SystemUserProfileSelectSessionDTO session) {
		
		if (entity == null) return null;
		
		//Optional<Dept> dept = Optional.ofNullable(entity.getDept());			
						
		return SystemUserProfileSelectDTO
				.builder()
				.companyCode("001")
			    .userId(entity.id().userId())
 			    //.staffNo(entity.getStaffId().getStaffNo())
			    .staffName(entity.name())												   
			    //.deptCode(dept.map(r -> r.getId().getDeptCode()).orElse(""))
			    //.deptName(dept.map(Dept::getDeptNameKorean).orElse(""))
			    .mobileNum(entity.mobileNum())
 			    .email(entity.email())
 			    .session(session)
 			    /*
 			    .ipAddress(WebRequestUtil.getIpAddress(request))
 			    .lastAccessedTime(new Date(request.getSession().getLastAccessedTime()))
 			    */
				.build();
	}
}
