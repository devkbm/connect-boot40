package com.like.hrm.staff.adapter.out.db.partner;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.partner.querydsl.PartnerCompanyStaffQuerydsl;
import com.like.hrm.staff.application.port.in.partner.query.PartnerCompanyStaffQueryDTO;
import com.like.hrm.staff.application.port.in.partner.query.PartnerCompanyStaffQueryResultDTO;
import com.like.hrm.staff.application.port.out.partner.PartnerCompanyStaffQueryDbPort;

@Repository
public class PartnerCompanyStaffQueryDbAdapter implements PartnerCompanyStaffQueryDbPort {

	PartnerCompanyStaffQuerydsl repository;
	
	PartnerCompanyStaffQueryDbAdapter(PartnerCompanyStaffQuerydsl repository) {
		this.repository = repository;
	}
	
	@Override
	public List<PartnerCompanyStaffQueryResultDTO> query(PartnerCompanyStaffQueryDTO dto) {
		return this.repository.query(dto);
	}

}
