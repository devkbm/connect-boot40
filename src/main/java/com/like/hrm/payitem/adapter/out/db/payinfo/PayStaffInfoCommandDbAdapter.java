package com.like.hrm.payitem.adapter.out.db.payinfo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.payinfo.data.PayStaffInfoJpaRepository;
import com.like.hrm.payitem.application.port.out.PayStaffInfoCommandDbPort;
import com.like.hrm.payitem.domain.payinfo.PayStaffInfo;

@Repository
public class PayStaffInfoCommandDbAdapter implements PayStaffInfoCommandDbPort {

	PayStaffInfoJpaRepository repository;
	
	PayStaffInfoCommandDbAdapter(PayStaffInfoJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<PayStaffInfo> select(String id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(PayStaffInfo entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(String id) {
		this.repository.deleteById(id);
	}

}
