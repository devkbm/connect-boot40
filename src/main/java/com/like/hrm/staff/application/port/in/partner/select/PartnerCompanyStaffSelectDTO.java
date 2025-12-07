package com.like.hrm.staff.application.port.in.partner.select;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record PartnerCompanyStaffSelectDTO(
		String companyCode,
		@NotEmpty(message = "직원번호는 필수 입력 값입니다.")
		String staffNo,
		String name,
		String nameEng,
		String nameChi,
		String gender,
		LocalDate birthday,
		String partnerCompanyCode,
		LocalDate joinDate,
		LocalDate retireDate,
		String blngDeptCode,
		String workDeptCode
		) {

}
