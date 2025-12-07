package com.like.hrm.payitem.adapter.out.db.payinfo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.payinfo.data.PayStaffItemJpaRepository;
import com.like.hrm.payitem.application.port.out.PayStaffItemCommandDbPort;
import com.like.hrm.payitem.domain.payinfo.PayStaffItem;

@Repository
public class PayStaffItemCommandDbAdapter implements PayStaffItemCommandDbPort {

	PayStaffItemJpaRepository repository;
	
	PayStaffItemCommandDbAdapter(PayStaffItemJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<PayStaffItem> select(String id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(PayStaffItem entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(String id) {
		this.repository.deleteById(id);
	}	

}
