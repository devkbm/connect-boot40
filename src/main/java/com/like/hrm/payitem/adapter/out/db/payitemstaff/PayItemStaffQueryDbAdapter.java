package com.like.hrm.payitem.adapter.out.db.payitemstaff;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.payitemstaff.querydsl.PayItemStaffQuerydsl;
import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryDTO;
import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryResultDTO;
import com.like.hrm.payitem.application.port.out.PayItemStaffQueryDbPort;

@Repository
public class PayItemStaffQueryDbAdapter implements PayItemStaffQueryDbPort {

	PayItemStaffQuerydsl repository;
	
	PayItemStaffQueryDbAdapter(PayItemStaffQuerydsl repository) {
		this.repository = repository;
	}
	
	@Override
	public List<PayItemStaffQueryResultDTO> query(PayItemStaffQueryDTO dto) {
		return this.repository.query(dto);
	}

}
