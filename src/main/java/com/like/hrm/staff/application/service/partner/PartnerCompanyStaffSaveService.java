package com.like.hrm.staff.application.service.partner;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.partner.save.PartnerCompanyStaffSaveDTO;
import com.like.hrm.staff.application.port.in.partner.save.PartnerCompanyStaffSaveDTOMapper;
import com.like.hrm.staff.application.port.in.partner.save.PartnerCompanyStaffSaveUseCase;
import com.like.hrm.staff.application.port.out.partner.PartnerCompanyStaffCommandDbPort;
import com.like.hrm.staff.domain.partner.PartnerCompanyStaff;

@Application
@Service
public class PartnerCompanyStaffSaveService implements PartnerCompanyStaffSaveUseCase {

	PartnerCompanyStaffCommandDbPort dbPort;
	
	PartnerCompanyStaffSaveService(PartnerCompanyStaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(PartnerCompanyStaffSaveDTO dto) {		
		PartnerCompanyStaff entity = this.dbPort.select(dto.companyCode(), dto.staffNo()).orElse(null);
		
		if (entity == null) {
			entity = PartnerCompanyStaffSaveDTOMapper.create(dto);
			entity.createdAppUrl(dto.clientAppUrl());
 		} else {
 			PartnerCompanyStaffSaveDTOMapper.modify(entity, dto);
 			entity.modifiedAppUrl(dto.clientAppUrl());
 		}
		
		this.dbPort.save(entity);		
	}

}
