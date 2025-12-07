package com.like.hrm.staff.application.port.out.partner;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.staff.domain.partner.PartnerCompanyStaff;

@SecondaryPort
public interface PartnerCompanyStaffCommandDbPort {

	Optional<PartnerCompanyStaff> select(String companyCode, String staffNo);
	
	void save(PartnerCompanyStaff entity);
	
	void delete(String companyCode, String staffNo);
	
}
