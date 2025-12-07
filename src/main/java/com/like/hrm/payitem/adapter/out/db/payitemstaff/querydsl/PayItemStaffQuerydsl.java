package com.like.hrm.payitem.adapter.out.db.payitemstaff.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryDTO;
import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryResultDTO;
import com.like.hrm.payitem.domain.payitem.QPayItem;
import com.like.hrm.payitem.domain.payitemstaff.QPayItemStaff;
import com.like.hrm.staff.domain.staff.QStaff;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PayItemStaffQuerydsl {

	final QPayItemStaff qPayItemStaff = QPayItemStaff.payItemStaff;
	
	JPAQueryFactory queryFactory;
	
	PayItemStaffQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<PayItemStaffQueryResultDTO> query(PayItemStaffQueryDTO dto) {
		
		QPayItem qPayItem = QPayItem.payItem;
		QStaff qStaff = QStaff.staff;
		
		return queryFactory
				.select(Projections.fields(PayItemStaffQueryResultDTO.class, 
						qPayItemStaff.id.stringValue().as("id"),
						qPayItemStaff.companyCode,
						qPayItemStaff.staffNo,
						qStaff.name.name.as("staffName"),
						qPayItemStaff.payItemCode,
						qPayItem.payItemName,
						qPayItemStaff.priod.from.as("from"),
						qPayItemStaff.priod.to.as("to"),
						qPayItemStaff.wageAmount,
						qPayItemStaff.comment
						)
				)
				.from(qPayItemStaff)
				.innerJoin(qStaff)
					.on(
						qPayItemStaff.companyCode.eq(qStaff.id.companyCode)
						.and(qPayItemStaff.staffNo.eq(qStaff.id.staffNo))
					)
				.innerJoin(qPayItem)
					.on(
						qPayItemStaff.companyCode.eq(qPayItem.id.companyCode)
						.and(qPayItemStaff.payItemCode.eq(qPayItem.id.payItemCode))
					)					
				.fetch();
	}
}
