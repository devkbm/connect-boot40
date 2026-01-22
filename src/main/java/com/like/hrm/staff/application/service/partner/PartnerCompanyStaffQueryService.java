package com.like.hrm.staff.application.service.partner;

import java.util.List;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.partner.query.PartnerCompanyStaffQueryDTO;
import com.like.hrm.staff.application.port.in.partner.query.PartnerCompanyStaffQueryResultDTO;
import com.like.hrm.staff.application.port.in.partner.query.PartnerCompanyStaffQueryUseCase;
import com.like.hrm.staff.application.port.out.partner.PartnerCompanyStaffQueryDbPort;

@Application
@Service
public class PartnerCompanyStaffQueryService implements PartnerCompanyStaffQueryUseCase {

	PartnerCompanyStaffQueryDbPort dbPort;
	
	PartnerCompanyStaffQueryService(PartnerCompanyStaffQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<PartnerCompanyStaffQueryResultDTO> query(PartnerCompanyStaffQueryDTO dto) {
		return this.dbPort.query(dto);
	}

}
