package com.like.hrm.staff.adapter.out.db.partner.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.application.port.in.partner.query.PartnerCompanyStaffQueryDTO;
import com.like.hrm.staff.application.port.in.partner.query.PartnerCompanyStaffQueryResultDTO;
import com.like.hrm.staff.domain.partner.QPartnerCompanyStaff;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PartnerCompanyStaffQuerydsl {

	JPAQueryFactory queryFactory;
	
	PartnerCompanyStaffQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	private final QPartnerCompanyStaff qStaff = QPartnerCompanyStaff.partnerCompanyStaff;
	
	public List<PartnerCompanyStaffQueryResultDTO> query(PartnerCompanyStaffQueryDTO dto) {
		return queryFactory
				.select(Projections.fields(PartnerCompanyStaffQueryResultDTO.class, 
						qStaff.id.companyCode,
						qStaff.id.staffNo,
						qStaff.name.name,
						qStaff.name.nameEng,
						qStaff.name.nameChi,
						qStaff.residentRegistrationNumber.number,
						qStaff.gender,
						qStaff.birthday,
						qStaff.imagePath,
						qStaff.partnerCompanyCode,
						qStaff.workStateCode,
						qStaff.joinDate,
						qStaff.retireDate,
						qStaff.blngDeptCode,
						qStaff.workDeptCode
						)
				)
				.from(qStaff)
				.fetch();		
	}
}
