package com.like.hrm.payitem.adapter.out.db.paytable;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.paytable.querydsl.PayTableQuerydsl;
import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryDTO;
import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryResultDTO;
import com.like.hrm.payitem.application.port.out.PayTableQueryDbPort;

@Repository
public class PayTableQueryDbAdapter implements PayTableQueryDbPort {

	PayTableQuerydsl repository;
	
	PayTableQueryDbAdapter(PayTableQuerydsl query) {
		this.repository = query;
	}
	
	@Override
	public List<PayTableQueryResultDTO> query(PayTableQueryDTO dto) {
		return this.repository.query(dto);
	}

	
	
}
